package tesis.clear_tk;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.impl.XmiCasSerializer;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.XMLSerializer;
import org.cleartk.util.ViewUriUtil;

public class XMIWriter<ANNOTATION_TYPE extends Annotation, BLOCK_TYPE extends Annotation> extends
    JCasAnnotator_ImplBase {

  public static final String PARAM_OUTPUT_PATH = "outputPath";
  @ConfigurationParameter(description = "Output path directory.", name = PARAM_OUTPUT_PATH,
      mandatory = true)
  private String outputPath;

  private UimaContext context;

  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);
    if (aContext == null && context != null) {
      aContext = context;
    }
    if (aContext != null) {
      outputPath = (String) aContext.getConfigParameterValue(PARAM_OUTPUT_PATH);
      this.context = aContext;
    }
  }

  public static void writeXmi(CAS aCas, File name) throws Exception {
    FileOutputStream out = null;

    try {
      // write XMI
      out = new FileOutputStream(name);
      XmiCasSerializer ser = new XmiCasSerializer(aCas.getTypeSystem());
      XMLSerializer xmlSer = new XMLSerializer(out, false);
      ser.serialize(aCas, xmlSer.getContentHandler());
    } catch (Exception e) {
      throw e;
    } finally {
      if (out != null) {
        out.close();
      }
    }
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    CAS cas = jcas.getCas();

    String fileName = (new File(ViewUriUtil.getURI(jcas))).getName();
    if (!fileName.endsWith(".xmi")) {
      fileName = fileName + ".xmi";
    }
    File file = new File(outputPath, fileName);
    try {
      writeXmi(cas, file);
    } catch (Exception e) {
      throw new AnalysisEngineProcessException(e);
    }
  }
}
