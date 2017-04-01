package tesis.similarityCoefficient;

import java.util.List;
import java.util.stream.Stream;

public class Jaccard {

  public double getCoefficient(List<String> a, List<String> b) {
    double intersect = a.stream().filter(b::contains).filter(x -> x != null).count();
    double union = Stream.concat(a.stream(), b.stream()).distinct().filter(x -> x != null).count();
    return intersect / union;
  }

}
