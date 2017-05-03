package tesis.similarityCoefficient;

import java.util.Set;
import java.util.stream.Stream;

public class Jaccard {

  public static double getCoefficient(Set<String> a, Set<String> b) {
    double intersect = a.stream().filter(b::contains).filter(x -> x != null).count();
    double union = Stream.concat(a.stream(), b.stream()).distinct().filter(x -> x != null).count();
    return intersect / union;
  }

}
