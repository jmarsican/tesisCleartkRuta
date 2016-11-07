package tesis.clear_tk;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.cas.CAS;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.fit.util.CasIOUtil;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceManager;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.apache.uima.ruta.engine.RutaEngine;
import org.apache.uima.util.XMLInputSource;

import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.realiser.english.Realiser;
import uima.ruta.example.TestPerformance.PerformanceSentence;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;
import edu.stanford.nlp.util.CoreMap;

public class XMIReaderTest {

	private static final String XMI_INPUT_FILE_PATH = "input/ejemplos performance.txt.xmi";
	private static final String XMI_OUTPUT_FILE_PATH = "output/ejemplos performance.txt.xmi";

	private static final String PERFORMANCE_ENGINE_PATH = "descriptor/uima/ruta/example/TestPerformanceEngine.xml";
	private static final String PERFORMANCE_SCRIPT_PATH = "script/uima/ruta/example/TestPerformance.ruta";
	private static final String TYPE_SYSTEM_FILE_PATH = "descriptor/uima/ruta/example/TestPerformanceTypeSystem.xml";

	public static void main(String[] args) throws Exception {

		TypeSystemDescription tsd = TypeSystemDescriptionFactory
				.createTypeSystemDescriptionFromPath(TYPE_SYSTEM_FILE_PATH);
		JCas jCas = JCasFactory.createJCas(tsd);

		File xmiFile = null;
		xmiFile = new File(XMI_OUTPUT_FILE_PATH);
		boolean runRutaScript = false;
		if (!xmiFile.exists()) {
			runRutaScript = true;
			xmiFile = new File(XMI_INPUT_FILE_PATH);
		}

		CasIOUtil.readXmi(jCas, xmiFile);
		CAS cas = jCas.getCas();

		if (runRutaScript) {
			File aedesc = new File(PERFORMANCE_ENGINE_PATH);
			XMLInputSource inae = new XMLInputSource(aedesc);
			ResourceSpecifier specifier = UIMAFramework.getXMLParser()
					.parseResourceSpecifier(inae);
			AnalysisEngineDescription aed = (AnalysisEngineDescription) specifier;

			ResourceManager resMgr = UIMAFramework.newDefaultResourceManager();
			aed.resolveImports(resMgr);

			AnalysisEngine ae = UIMAFramework.produceAnalysisEngine(aed,
					resMgr, null);
			File scriptFile = new File(PERFORMANCE_SCRIPT_PATH);
			ae.setConfigParameterValue(
					RutaEngine.PARAM_SCRIPT_PATHS,
					new String[] { scriptFile.getParentFile().getAbsolutePath() });
			String name = scriptFile.getName().substring(0,
					scriptFile.getName().length() - 5);
			ae.setConfigParameterValue(RutaEngine.PARAM_MAIN_SCRIPT, name);
			ae.reconfigure();
			ae.process(cas);
		}
		Collection<PerformanceSentence> sentences = JCasUtil.select(
				cas.getJCas(), PerformanceSentence.class);

		List<Annotation> annotations = new ArrayList<Annotation>();
		for (PerformanceSentence sentence : sentences) {
			annotations.add(new Annotation(sentence.getCoveredText()));
		}

		// Create the Stanford CoreNLP pipeline
		Properties props = new Properties();
		props.setProperty("annotators",
				"tokenize,ssplit,pos,lemma,depparse,natlog,openie");
		props.setProperty("outputFormat", "X-CAS");
		props.setProperty("outputExtension", "xmi");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

		// Annotate an example document.
		pipeline.annotate(annotations);

		List<String> verbs = new ArrayList<String>();
		List<String> nouns = new ArrayList<String>();
		
		// Loop over sentences in the document
		for (Annotation annotation : annotations) {
			System.out.println(annotation.toString());
			for (CoreMap sentence : annotation
					.get(CoreAnnotations.SentencesAnnotation.class)) {
				// Get the OpenIE triples for the sentence
				SemanticGraph graph = sentence
						.get(SemanticGraphCoreAnnotations.BasicDependenciesAnnotation.class);
				// Print the triples
				List<SemanticGraphEdge> edges = graph.edgeListSorted();
				for (SemanticGraphEdge edge : edges) {
					if (edge.getRelation().getShortName().equals("nmod"))
						System.out.println(edge.getRelation().getLongName()
								+ ":\n" + edge.getDependent() + "<-\t"
								+ edge.getGovernor() + "\n" +

								edge.getSource() + "\n" + edge.getTarget());
				}
			}
		}

		Lexicon lexicon = Lexicon.getDefaultLexicon();
		NLGFactory factory = new NLGFactory(lexicon);
		SPhraseSpec phrase = new SPhraseSpec(factory);
		Realiser realiser = new Realiser(lexicon);

		for (int i = 0; i < verbs.size(); i++) {
			phrase.setSubject(factory.createNounPhrase("my dog"));
			phrase.setVerb(factory.createVerbPhrase("chasing"));
			phrase.setObject(factory.createNounPhrase("George"));

			phrase.setFeature(Feature.TENSE, Tense.PRESENT);

			System.out.println(realiser.realise(phrase));
		}
	}

}
