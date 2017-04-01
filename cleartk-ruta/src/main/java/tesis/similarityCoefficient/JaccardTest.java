package tesis.similarityCoefficient;

import java.util.List;

import org.junit.Assert;

import com.google.common.collect.Lists;


public class JaccardTest {

  public static void main(String[] args) {

    List<String> a = Lists.newArrayList("0", "1", "2", "5", "6");
    List<String> b = Lists.newArrayList("0", "2", "3", "4", "5", "7", "9");

    Jaccard jaccard = new Jaccard();

    Assert.assertEquals(0.3333, jaccard.getCoefficient(a, b), 0.0001);
  }
}
