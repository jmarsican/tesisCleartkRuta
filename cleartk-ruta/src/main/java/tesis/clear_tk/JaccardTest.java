package tesis.clear_tk;

import info.debatty.java.stringsimilarity.Jaccard;

public class JaccardTest {

  public static void main(String[] args) {
    Jaccard jaccard = new Jaccard();
    double distance =
        jaccard.similarity("1234567890 1234567890 1234567890 1234567890",
            "1234567890 1234567890 1234567890 1234567890");
    System.out.println(distance);
  }

}
