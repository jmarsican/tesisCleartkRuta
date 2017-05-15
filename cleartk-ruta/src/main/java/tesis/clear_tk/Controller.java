package tesis.clear_tk;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.uima.cas.CAS;

import tesis.extractors.Phrase;
import tesis.similarityCoefficient.Jaccard;
import tesis.similarityCoefficient.JaccardRunner;

public class Controller {

  private static Logger LOGGER = Logger.getLogger(Controller.class);

  public static void main(String[] args) throws Exception {
    Map<String, Double> results = new HashMap<String, Double>();
    Files.list(Paths.get(Properties.PLAIN_TEXT_DIR)).forEach(file -> {
      try {
        String filename = file.getFileName().toString();
        LOGGER.info("FILE: " + filename);
        run(filename, results);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });

    // order results by similarity coefficient
    results.entrySet().stream().sorted(new Comparator<Entry<String, Double>>() {
      @Override
      public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
        return Double.compare(o2.getValue(), o1.getValue());
      }
    }).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
  }

  public static void run(String filename, Map<String, Double> results) throws Exception {

    DocsStructurator.run(Properties.PLAIN_TEXT_DIR + filename);
    filename += ".xmi";

    // Read annotated docs
    CAS cas = XMIReader.toCas(Properties.ANNOTATED_DOCS_DIR + filename);

    RutaRunner.run(cas, filename);

    // Read qa sentences
    cas = XMIReader.toCas(Properties.QA_SENTENCES_DIR + filename);

    List<Phrase> phrases = ScenarioLinker.extract(cas);

    ScenarioHandler.save(phrases, filename);

    Set<String> lemmas = ScenarioLinker.getLemmas(phrases);

    results.put(filename + " P1", Jaccard.getCoefficient(lemmas, JaccardRunner.LEMMAS_P1));
    results.put(filename + " P2", Jaccard.getCoefficient(lemmas, JaccardRunner.LEMMAS_P2));
    results.put(filename + " P1-P2", Jaccard.getCoefficient(lemmas, JaccardRunner.LEMMAS_P1_P2));
  }
}
