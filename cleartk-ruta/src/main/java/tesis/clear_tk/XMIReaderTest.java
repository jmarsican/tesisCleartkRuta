package tesis.clear_tk;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

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
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.PPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.realiser.english.Realiser;
import uima.ruta.example.TestPerformance.PerformanceSentence;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;
import edu.stanford.nlp.util.CoreMap;

public class XMIReaderTest {

	private static final String XMI_INPUT_DIR = "input/";
	private static final String XMI_OUTPUT_DIR = "output/";

	private static final String PERFORMANCE_ENGINE_PATH = "descriptor/uima/ruta/example/TestPerformanceEngine.xml";
	private static final String PERFORMANCE_SCRIPT_PATH = "script/uima/ruta/example/TestPerformance.ruta";
	private static final String TYPE_SYSTEM_FILE_PATH = "descriptor/uima/ruta/example/TestPerformanceTypeSystem.xml";
	
	private static final IndexedWord EMPTY_INDEXED_WORD = new IndexedWord(new CoreLabel());

	public static void main(String[] args) throws Exception {
		Files.list(Paths.get(XMI_INPUT_DIR))
        .forEach(file -> {
        	try {
				readXmi(file.getFileName().toString());
			} catch (Exception e) {
				e.printStackTrace();
			}	
        });	
	}
	
	private static IndexedWord getDependent(SemanticGraph graph, IndexedWord node, String relationShortName) {
		Optional<IndexedWord> indexedWord = 
				graph.getOutEdgesSorted(node).stream()
				.filter(e -> relationShortName.equals(e.getRelation().getShortName()))
				.findFirst().map(e -> e.getDependent());
		return indexedWord.orElse(EMPTY_INDEXED_WORD);
	}
	
	public static void readXmi(String fileName) throws Exception {

		System.out.println("-------------------");
		System.out.println("File: " + fileName);
		System.out.println("-------------------");
		
		TypeSystemDescription tsd = TypeSystemDescriptionFactory
				.createTypeSystemDescriptionFromPath(TYPE_SYSTEM_FILE_PATH);
		JCas jCas = JCasFactory.createJCas(tsd);

		File xmiFile = null;
		xmiFile = new File(XMI_OUTPUT_DIR + fileName);
		boolean runRutaScript = false;
		if (!xmiFile.exists()) {
			runRutaScript = true;
			xmiFile = new File(XMI_INPUT_DIR + fileName);
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
		
		// Loop over sentences in the document
		for (Annotation annotation : annotations) {
			for (CoreMap sentence : annotation
					.get(CoreAnnotations.SentencesAnnotation.class)) {
				SemanticGraph graph = sentence
						.get(SemanticGraphCoreAnnotations.BasicDependenciesAnnotation.class);
				List<SemanticGraphEdge> edges = graph.edgeListSorted();
				
				// Filtering nsubjpass edges 
				edges = edges.stream().filter(edge -> 
					"nsubjpass".equals(edge.getRelation().getShortName()))
						.collect(Collectors.toList());
				
				edges.forEach(edge -> {
					IndexedWord indexedVerb = edge.getGovernor(); 
					IndexedWord indexedComplement = getDependent(graph, indexedVerb, "nmod");
					IndexedWord indexedPreposition = getDependent(graph, indexedComplement, "case");
					IndexedWord indexedDeterminer = getDependent(graph, indexedComplement, "det");
					
					String verb = indexedVerb.originalText(); // update
					String object = edge.getDependent().originalText(); // alarm
					String complement = indexedComplement.originalText(); // user
					String preposition = indexedPreposition.originalText(); // on
					String complementDeterminer = indexedDeterminer.originalText(); // the
					
					Lexicon lexicon = Lexicon.getDefaultLexicon();
					NLGFactory factory = new NLGFactory(lexicon);
					SPhraseSpec phrase = new SPhraseSpec(factory);
					Realiser realiser = new Realiser(lexicon);
					
					NPPhraseSpec nlpComplement = factory.createNounPhrase(complement);
					nlpComplement.setDeterminer(complementDeterminer);
					PPPhraseSpec nlpModifier = factory.createPrepositionPhrase();
					nlpModifier.setPreposition(preposition);
					nlpModifier.setComplement(nlpComplement);
					
					phrase.setVerb(factory.createVerbPhrase(verb));
					phrase.setObject(factory.createNounPhrase(object));
					phrase.addModifier(nlpModifier);

					phrase.setFeature(Feature.TENSE, Tense.PRESENT);

					System.out.println(realiser.realise(phrase));					
				});
				 
			}
		}

	}

}
