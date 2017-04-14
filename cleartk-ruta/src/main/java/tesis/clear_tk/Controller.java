package tesis.clear_tk;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.uima.cas.CAS;

import tesis.extractors.Phrase;

public class Controller {

  private static Logger LOGGER = Logger.getLogger(Controller.class);

  public static void main(String[] args) throws Exception {
    Files.list(Paths.get(Properties.PLAIN_TEXT_DIR)).forEach(file -> {
      try {
        String filename = file.getFileName().toString();
        LOGGER.info("FILE: " + filename);
        run(filename);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  public static void run(String filename) throws Exception {

    DocsStructurator.run(Properties.PLAIN_TEXT_DIR + filename);
    filename += ".xmi";

    // Read annotated docs
    CAS cas = XMIReader.toCas(Properties.ANNOTATED_DOCS_DIR + filename);

    RutaRunner.run(cas, filename);

    // Read qa sentences
    cas = XMIReader.toCas(Properties.QA_SENTENCES_DIR + filename);

    List<Phrase> phrases = ScenarioLinker.extract(cas);

    ScenarioGenerator.run(phrases, filename);
  }
}
