package tesis.clear_tk;

import java.io.File;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.cas.CAS;
import org.apache.uima.resource.ResourceManager;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.ruta.engine.RutaEngine;
import org.apache.uima.util.XMLInputSource;

public class RutaRunner {

  public static void run(CAS cas, String filename) throws Exception {
    if (cas == null) {
      return;
    }

    File aedesc = new File(Properties.PERFORMANCE_ENGINE_PATH);
    XMLInputSource inae = new XMLInputSource(aedesc);
    ResourceSpecifier specifier = UIMAFramework.getXMLParser().parseResourceSpecifier(inae);
    AnalysisEngineDescription aed = (AnalysisEngineDescription) specifier;

    ResourceManager resMgr = UIMAFramework.newDefaultResourceManager();
    aed.resolveImports(resMgr);

    AnalysisEngine ae = UIMAFramework.produceAnalysisEngine(aed, resMgr, null);
    File scriptFile = new File(Properties.PERFORMANCE_SCRIPT_PATH);
    ae.setConfigParameterValue(RutaEngine.PARAM_SCRIPT_PATHS, new String[] {scriptFile
        .getParentFile().getAbsolutePath()});
    String name = scriptFile.getName().substring(0, scriptFile.getName().length() - 5);
    ae.setConfigParameterValue(RutaEngine.PARAM_MAIN_SCRIPT, name);
    ae.reconfigure();
    ae.process(cas);
    XMIWriter.writeXmi(cas, new File(Properties.QA_SENTENCES_DIR + filename));
  }
}
