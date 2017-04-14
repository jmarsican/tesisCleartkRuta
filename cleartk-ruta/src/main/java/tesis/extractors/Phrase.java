package tesis.extractors;

public class Phrase {

  private final int scenarioSection;
  private final String text;
  private final int begin;
  private final int end;

  public Phrase(int scenarioSection, String text, int begin, int end) {
    super();
    this.scenarioSection = scenarioSection;
    this.text = text;
    this.begin = begin;
    this.end = end;
  }

  public int getScenarioSection() {
    return scenarioSection;
  }

  public String getText() {
    return text;
  }

  public int getBegin() {
    return begin;
  }

  public int getEnd() {
    return end;
  }

}
