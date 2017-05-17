package tesis.similarityCoefficient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.emf.ecore.resource.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import tesis.clear_tk.ScenarioLinker;

import com.google.common.collect.Sets;

public class JaccardRunner {

  public static final String P1 =
      "A field system detects a change of some value and notifies MSLite. "
          + "The system operates under normal conditions1. "
          + "The value is updated on all user screens that display the old value "
          + "within 3 seconds.";
  public static final String P2 =
      "An alarm occurs, either originating in a field system or in MSLite. "
          + "The system operates under normal conditions2. "
          + "The alarm is displayed on the user interfaces of all users "
          + "that must receive the alarm within 3 seconds. "
          + "The Time durations specified in this scenario are performance goals "
          + "and are not to be taken as hard deadlines.";

  public static final Set<String> LEMMAS_P1 = ScenarioLinker.getLemmas(JaccardRunner.P1);
  public static final Set<String> LEMMAS_P2 = ScenarioLinker.getLemmas(JaccardRunner.P2);
  public static final Set<String> LEMMAS_P1_P2 = Sets.intersection(LEMMAS_P1, LEMMAS_P2);

  private static String readScenarioPhrases(File file) throws Exception {
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(file);
    doc.getDocumentElement().normalize();

    NodeList phrasesList = doc.getElementsByTagName("edu.exa.unicen.scenario:Phrase");

    StringBuilder text = new StringBuilder();
    for (int i = 0; i < phrasesList.getLength(); i++) {
      Node phrase = phrasesList.item(i);
      Node node = phrase.getAttributes().getNamedItem("value");
      if (node != null) {
        text.append(node.getNodeValue() + "\n");
      }
    };

    return text.toString();
  }

  private static void jaccard(String path) {
    File file = new File(path);
    if (file.isDirectory()) {
      try {
        Files.list(Paths.get(path.toString())).forEach(p -> jaccard(p.toString()));
      } catch (IOException e) {
        e.printStackTrace();
      }
      return;
    }


    String filename = file.getName();
    if (!filename.contains(".gen") && !filename.contains(".scenario")) {
      return;
    }

    String text = "";
    try {
      text = readScenarioPhrases(file);
    } catch (Exception e) {
      System.out.println("Error al leer el scenario " + path.toString());
      e.printStackTrace();
    }

    System.out.println("\n------------------------------------------------------\nFILE: "
        + filename + "\n------------------------------------------------------\n");
    Set<String> lemmas = ScenarioLinker.getLemmas(text);
    System.out.println();
    System.out
.println("P1: " + Jaccard.getCoefficient(lemmas, JaccardRunner.LEMMAS_P1));
    System.out
.println("P2: " + Jaccard.getCoefficient(lemmas, JaccardRunner.LEMMAS_P2));
    System.out.println("P1-P2: "
        + Jaccard.getCoefficient(lemmas, JaccardRunner.LEMMAS_P1_P2));
  }

  public static void main(String[] args) throws Exception {

    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
    
    for (String path : args) {
      jaccard(path);
    }
  }
}
