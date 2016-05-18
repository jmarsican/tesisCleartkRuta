package tesis.clear_tk;

import java.io.File;
import java.util.Collection;

import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.fit.util.CasIOUtil;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.cleartk.token.type.Token;

public class XMIReaderTest {

	private static final String XMI_FILE_PATH = "output/lemma.xmi";
	private static final String TYPE_SYSTEM_FILE_PATH = "descriptor/uima/ruta/example/TestPerformanceTypeSystem.xml";

	public static void main(String[] args) throws Exception {

		  TypeSystemDescription tsd = TypeSystemDescriptionFactory
		  .createTypeSystemDescriptionFromPath(TYPE_SYSTEM_FILE_PATH);
		 
		 JCas jCas = JCasFactory.createJCas(tsd);
		 
		 CasIOUtil.readXmi(jCas, new File(XMI_FILE_PATH));
		
		 Collection<Token> tokens = JCasUtil.select(jCas, Token.class);

	}

}
