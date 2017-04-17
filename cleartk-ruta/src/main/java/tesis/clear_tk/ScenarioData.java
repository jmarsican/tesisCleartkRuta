package tesis.clear_tk;

public class ScenarioData {
  private final String value;
  private final int begin;
  private final int end;


  public ScenarioData(String value, int begin, int end) {
    super();
    this.value = value;
    this.begin = begin;
    this.end = end;
  }

  public String getValue() {
    return value;
  }

  public int getBegin() {
    return begin;
  }

  public int getEnd() {
    return end;
  }
}
