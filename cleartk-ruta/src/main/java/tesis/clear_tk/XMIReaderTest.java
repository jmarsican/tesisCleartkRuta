package tesis.clear_tk;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
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
import org.cleartk.token.type.Token;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import scenario.GeneralScenario;
import scenario.ScenarioFactory;
import scenario.ScenarioPackage;
import simplenlg.framework.NLGElement;
import simplenlg.framework.NLGFactory;
import simplenlg.framework.PhraseElement;
import simplenlg.lexicon.Lexicon;
import simplenlg.realiser.english.Realiser;
import tesis.extractors.DirectObjectExtractor;
import tesis.extractors.ExtractorsManager;
import tesis.extractors.NominalSubjectExtractor;
import tesis.extractors.NominalSubjectPassiveExtractor;
import tesis.extractors.PhraseExtractor;
import uima.ruta.example.TestPerformance.PerformanceSentence;

import com.google.common.collect.Sets;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;
import edu.stanford.nlp.util.CoreMap;

public class XMIReaderTest {

  private static Logger LOGGER = Logger.getLogger(XMIReaderTest.class);

  private static final String INPUT_DIR = "plaintext-input/";
  private static final String XMI_INPUT_DIR = "annotated-docs/";
  private static final String XMI_OUTPUT_DIR = "qa-sentences/";
  private static final String SCENARIO_OUTPUT_PATH = "scenarios/%s.scenario";

  private static final String PERFORMANCE_ENGINE_PATH =
      "descriptor/uima/ruta/example/TestPerformanceEngine.xml";
  private static final String PERFORMANCE_SCRIPT_PATH =
      "script/uima/ruta/example/TestPerformance.ruta";
  private static final String TYPE_SYSTEM_FILE_PATH =
      "descriptor/uima/ruta/example/TestPerformanceTypeSystem.xml";

  public static void main(String[] args) throws Exception {
    Files.list(Paths.get(XMI_INPUT_DIR)).forEach(file -> {
      try {
        String filename = file.getFileName().toString();
        LOGGER.info("FILE: " + filename);
        readXmi(filename);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  private static GeneralScenario createScenario(String documentLocation) {
    GeneralScenario scenario = ScenarioFactory.eINSTANCE.createGeneralScenario();

    documentLocation = documentLocation.substring(0, documentLocation.lastIndexOf('.'));
    String absolutePath = new File(INPUT_DIR + documentLocation).getAbsolutePath();
    scenario.setDocumentLocation(absolutePath);

    ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    resourceSet.getPackageRegistry().put(ScenarioPackage.eNS_URI, ScenarioPackage.eINSTANCE);

    Resource resource = resourceSet.createResource(URI.createURI("http:///My.scenario"));
    resource.getContents().add(scenario);

    return scenario;
  }

  private static void addContent(GeneralScenario scenario, String value, int begin, int end) {
    scenario.Phrase phrase = ScenarioFactory.eINSTANCE.createPhrase();
    phrase.setBegin(begin);
    phrase.setEnd(end);
    phrase.setValue(value);

    scenario.setQualityAttribute("Performance");
    scenario.getEnvironment().add(phrase);
    scenario.getMeasure().add(phrase);
    scenario.getResponse().add(phrase);
    scenario.getSource().add(phrase);
    scenario.getStimulus().add(phrase);
    scenario.getArtifact().add(phrase);

    scenario.eResource().getContents().add(phrase);
  }

  private static SemanticGraph getSemanticGraph(Annotation annotation) {
    CoreMap sentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
    return sentence.get(SemanticGraphCoreAnnotations.BasicDependenciesAnnotation.class);
  }

  private static CAS xmiFileToCas(File xmiFile) throws Exception {
    if (!xmiFile.exists()) {
      return null;
    }

    TypeSystemDescription tsd =
        TypeSystemDescriptionFactory.createTypeSystemDescriptionFromPath(TYPE_SYSTEM_FILE_PATH);
    JCas jCas = JCasFactory.createJCas(tsd);

    CasIOUtil.readXmi(jCas, xmiFile);
    return jCas.getCas();
  }

  private static void runRuta(CAS cas, String filename) throws Exception {
    File aedesc = new File(PERFORMANCE_ENGINE_PATH);
    XMLInputSource inae = new XMLInputSource(aedesc);
    ResourceSpecifier specifier = UIMAFramework.getXMLParser().parseResourceSpecifier(inae);
    AnalysisEngineDescription aed = (AnalysisEngineDescription) specifier;

    ResourceManager resMgr = UIMAFramework.newDefaultResourceManager();
    aed.resolveImports(resMgr);

    AnalysisEngine ae = UIMAFramework.produceAnalysisEngine(aed, resMgr, null);
    File scriptFile = new File(PERFORMANCE_SCRIPT_PATH);
    ae.setConfigParameterValue(RutaEngine.PARAM_SCRIPT_PATHS, new String[] {scriptFile
        .getParentFile().getAbsolutePath()});
    String name = scriptFile.getName().substring(0, scriptFile.getName().length() - 5);
    ae.setConfigParameterValue(RutaEngine.PARAM_MAIN_SCRIPT, name);
    ae.reconfigure();
    ae.process(cas);
    XMIWriter.writeXmi(cas, new File(XMI_OUTPUT_DIR + filename));
  }

  public static void readXmi(String filename) throws Exception {

    // Read annotated-docs
    CAS cas = xmiFileToCas(new File(XMI_INPUT_DIR + filename));

    // //////////////////////////////////////
    // RUN RUTA
    if (cas == null) {
      runRuta(cas, filename);
    }

    // Read annotated-docs
    cas = xmiFileToCas(new File(XMI_OUTPUT_DIR + filename));

    // //////////////////////////////////////
    // RUTA SENTENCES TO STANFORD ANNOTATION
    Collection<PerformanceSentence> sentences =
        JCasUtil.select(cas.getJCas(), PerformanceSentence.class);

    Collection<Token> tokens = JCasUtil.select(cas.getJCas(), Token.class);

    List<Annotation> annotations = new ArrayList<Annotation>();
    for (PerformanceSentence sentence : sentences) {

      tokens.stream().filter(
          t -> t.getPos().startsWith("vb") || t.getBegin() > sentence.getBegin()
              && t.getEnd() > sentence.getEnd());

      Annotation annotation = new Annotation(sentence.getCoveredText());
      annotation.set(CoreAnnotations.BeginIndexAnnotation.class, sentence.getBegin());
      annotation.set(CoreAnnotations.EndIndexAnnotation.class, sentence.getEnd());
      annotations.add(annotation);
    }

    // //////////////////////////////////////
    // CREATE AND RUN THE STANFORD CORENLP PIPELINE
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,depparse,natlog,openie");
    props.setProperty("outputFormat", "X-CAS");
    props.setProperty("outputExtension", "xmi");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

    pipeline.annotate(annotations);

    // //////////////////////////////////////
    // PREPARA NLG Y EXTRACTORS
    Lexicon lexicon = Lexicon.getDefaultLexicon();
    NLGFactory factory = new NLGFactory(lexicon);

    Realiser realiser = new Realiser(lexicon);

    Set<String> extractors =
        Sets.newHashSet(NominalSubjectExtractor.RELATION_SHORT_NAME,
            NominalSubjectPassiveExtractor.RELATION_SHORT_NAME,
            DirectObjectExtractor.RELATION_SHORT_NAME);

    // //////////////////////////////////////
    // POR CADA STANFORD ANNOTATION: OBTIENE EL GRAFO Y CORE LOS EXTRACTORS
    List<ScenarioData> scenarioDataList = new ArrayList<ScenarioData>();
    annotations.forEach(annotation -> {

      LOGGER.info(String.format("SENTENCE: '%s' [%d->%d].", annotation,
          annotation.get(CoreAnnotations.BeginIndexAnnotation.class),
          annotation.get(CoreAnnotations.EndIndexAnnotation.class)));

      // getSemanticGraph
        SemanticGraph graph = getSemanticGraph(annotation);
        List<SemanticGraphEdge> edges = graph.edgeListSorted();
        ExtractorsManager extractorsManager = new ExtractorsManager(factory);

        // Filtering edges
        List<SemanticGraphEdge> filteredEdges =
            edges.stream().filter(edge -> extractors.contains(edge.getRelation().getShortName()))
                .collect(Collectors.toList());

        // por cada edge filtrado
        System.out.println("\ndetected phrases:\n");
        filteredEdges.forEach(filteredEdge -> {
          PhraseExtractor extractor =
              extractorsManager.getExtractor(filteredEdge.getRelation().getShortName());

          // RUN EXTRACTOR
            if (extractor != null) {
              PhraseElement phrase = extractor.assemble(graph, filteredEdge);
              if (phrase != null) {
                NLGElement nlgElement = realiser.realise(phrase);
                int begin = annotation.get(CoreAnnotations.BeginIndexAnnotation.class);
                int end = annotation.get(CoreAnnotations.EndIndexAnnotation.class);
                scenarioDataList.add(new ScenarioData(nlgElement.toString(), begin, end));
                System.out.println(nlgElement);
              }
            }
          });
        System.out.println();
      });

    // //////////////////////////////////////
    // CREATE SCENARIO
    GeneralScenario scenario = createScenario(filename);
    scenarioDataList.forEach(scenarioData -> addContent(scenario, scenarioData.getValue(),
        scenarioData.getBegin(), scenarioData.getEnd()));

    String scenarioFileName =
        String.format(SCENARIO_OUTPUT_PATH, filename.substring(0, filename.indexOf('.')));
    FileOutputStream outputStream = new FileOutputStream(new File(scenarioFileName));
    scenario.eResource().save(outputStream, null);
  }
}
