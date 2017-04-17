package tesis.clear_tk;

import java.io.File;

import org.apache.uima.cas.CAS;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.fit.util.CasIOUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.metadata.TypeSystemDescription;

public class XMIReader {

  public static CAS toCas(File xmiFile) throws Exception {
    if (!xmiFile.exists()) {
      return null;
    }

    TypeSystemDescription tsd =
        TypeSystemDescriptionFactory
            .createTypeSystemDescriptionFromPath(Properties.TYPE_SYSTEM_FILE_PATH);
    JCas jCas = JCasFactory.createJCas(tsd);

    CasIOUtil.readXmi(jCas, xmiFile);
    return jCas.getCas();
  }

  public static CAS toCas(String filename) throws Exception {
    return toCas(new File(filename));
  }
}
