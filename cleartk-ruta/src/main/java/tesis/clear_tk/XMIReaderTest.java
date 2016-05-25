package tesis.clear_tk;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.cas.CAS;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.fit.util.CasIOUtil;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceManager;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.apache.uima.ruta.engine.RutaEngine;
import org.apache.uima.util.CasCreationUtils;
import org.apache.uima.util.XMLInputSource;

import uima.ruta.example.TestPerformance.performanceSentence;
import uima.ruta.example.TestPerformance.tokenConstraint;

public class XMIReaderTest {

	private static final String XMI_FILE_PATH = "input/supplspec_v1.htm.txt.xmi";
	private static final String TYPE_SYSTEM_FILE_PATH = "descriptor/uima/ruta/example/TestPerformanceTypeSystem.xml";
	
	public static void main(String[] args) throws Exception {

		TypeSystemDescription tsd = TypeSystemDescriptionFactory
				.createTypeSystemDescriptionFromPath(TYPE_SYSTEM_FILE_PATH);
		JCas jCas = JCasFactory.createJCas(tsd);

		/*****/
		File aedesc = new File("descriptor/uima/ruta/example/TestPerformanceEngine.xml");
		XMLInputSource inae = new XMLInputSource(aedesc);
		ResourceSpecifier specifier = UIMAFramework.getXMLParser().
		    parseResourceSpecifier(inae);		
		AnalysisEngineDescription aed = (AnalysisEngineDescription) specifier;
			
		ResourceManager resMgr = UIMAFramework.newDefaultResourceManager();
		aed.resolveImports(resMgr);
		        
		AnalysisEngine ae = UIMAFramework.produceAnalysisEngine(aed, 
		    resMgr, null);
		File scriptFile = new File("script/uima/ruta/example/TestPerformance.ruta");
		ae.setConfigParameterValue(RutaEngine.PARAM_SCRIPT_PATHS, 
		    new String[] { scriptFile.getParentFile().getAbsolutePath() });
		String name = scriptFile.getName().substring(0, scriptFile.getName().length() - 5);
		ae.setConfigParameterValue(RutaEngine.PARAM_MAIN_SCRIPT, name);
		ae.reconfigure();
		
		CasIOUtil.readXmi(jCas, new File(XMI_FILE_PATH));		
		CAS cas = jCas.getCas();
		ae.process(cas);
		
		Collection<performanceSentence> tokens = JCasUtil.select(cas.getJCas(), performanceSentence.class);
		for (performanceSentence token : tokens) {
			System.out.println(token);
			System.out.println(token.getCoveredText());
		}
	}

}
