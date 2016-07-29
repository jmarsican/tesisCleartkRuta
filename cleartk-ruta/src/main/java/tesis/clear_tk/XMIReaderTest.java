package tesis.clear_tk;

import java.io.File;
import java.util.Collection;

import opennlp.uima.util.AnnotationComboIterator;
import opennlp.uima.util.AnnotationIteratorPair;
import opennlp.uima.util.AnnotatorUtil;
import opennlp.uima.util.UimaUtil;

import org.apache.uima.UIMAFramework;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.TypeSystem;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.fit.factory.UimaContextFactory;
import org.apache.uima.fit.util.CasIOUtil;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceManager;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.apache.uima.ruta.engine.RutaEngine;
import org.apache.uima.util.TypeSystemUtil;
import org.apache.uima.util.XMLInputSource;
import org.cleartk.ml.feature.extractor.CleartkExtractor;
import org.cleartk.token.type.Token;

import uima.ruta.example.TestPerformance.PerformanceSentence;
import uima.ruta.example.TestPerformance.TokenConstraint;
import uima.ruta.example.TestPerformance.TokenTime;

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
		Collection<TokenConstraint> tokens = JCasUtil.select(cas.getJCas(),
				TokenConstraint.class);
		for (TokenConstraint token : tokens) {
			System.out.println(token.getCoveredText());
			System.out.println(token);
		}
		
		UimaContext context = UimaContextFactory.createUimaContext(null);
		
		// sentence type
	    Type sentenceType = AnnotatorUtil.getRequiredTypeParameter(context, cas.getTypeSystem(),
	        UimaUtil.SENTENCE_TYPE_PARAMETER);

	    // token type
	    Type tokenType = AnnotatorUtil.getRequiredTypeParameter(context, cas.getTypeSystem(),
	        UimaUtil.TOKEN_TYPE_PARAMETER);
		
		final AnnotationComboIterator comboIterator = new AnnotationComboIterator(cas,
		        sentenceType, tokenType);
		
		for (AnnotationIteratorPair annotationIteratorPair : comboIterator) {
		      System.out.println(annotationIteratorPair);
		}
		
	}

}
