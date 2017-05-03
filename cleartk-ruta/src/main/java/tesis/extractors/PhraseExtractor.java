package tesis.extractors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import simplenlg.framework.NLGFactory;
import simplenlg.framework.PhraseElement;
import simplenlg.lexicon.Lexicon;
import simplenlg.realiser.english.Realiser;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;
import edu.stanford.nlp.util.CoreMap;

public abstract class PhraseExtractor {
  protected static final IndexedWord EMPTY_INDEXED_WORD = new IndexedWord("", 0, 0);
  protected String RELATION_SHORT_NAME;

  protected int scenarioSection;
  protected NLGFactory mFactory;
  protected Realiser realizer;

  public PhraseExtractor(int section) {
    scenarioSection = section;
    Lexicon lexicon = Lexicon.getDefaultLexicon();
    mFactory = new NLGFactory(lexicon);
    realizer = new Realiser(lexicon);
  }

  protected abstract PhraseElement doAssemble(SemanticGraph graph, SemanticGraphEdge edge);

  private Stream<SemanticGraphEdge> getOutEdgesSorted(SemanticGraph graph, IndexedWord node,
      String relationShortName) {
    return graph.getOutEdgesSorted(node).stream()
        .filter(e -> relationShortName.equals(e.getRelation().getShortName()));
  }

  protected SemanticGraph getSemanticGraph(Annotation annotation) {
    CoreMap sentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
    return sentence.get(SemanticGraphCoreAnnotations.BasicDependenciesAnnotation.class);
  }

  protected IndexedWord getDependent(SemanticGraph graph, IndexedWord node, String relationShortName) {
    return getOutEdgesSorted(graph, node, relationShortName).findFirst().map(e -> e.getDependent())
        .orElse(EMPTY_INDEXED_WORD);
  }

  protected void addCompounds(SemanticGraph graph, IndexedWord node, PhraseElement phrase) {
    PhraseElement modifier = mFactory.createNounPhrase();
    getOutEdgesSorted(graph, node, "compound").forEach(
        edge -> modifier.addComplement(edge.getDependent().originalText()));
    phrase.addPreModifier(modifier);
  }

  public List<Phrase> extract(Annotation annotation) {
    SemanticGraph graph = getSemanticGraph(annotation);

    List<SemanticGraphEdge> edges = graph.edgeListSorted();

    // Filtering edges
    List<SemanticGraphEdge> filteredEdges =
        edges.stream()
            .filter(edge -> (edge.getRelation().getShortName()).equals(getEdgeRelationShortName()))
            .collect(Collectors.toList());

    List<Phrase> phrases = new ArrayList<Phrase>();

    filteredEdges.forEach(filteredEdge -> {
      PhraseElement phraseElement = doAssemble(graph, filteredEdge);
      if (phraseElement == null) {
        return;
      }
      String text = realizer.realise(phraseElement).toString();
      int begin = annotation.get(CoreAnnotations.BeginIndexAnnotation.class);
      int end = annotation.get(CoreAnnotations.EndIndexAnnotation.class);

      phrases.add(new Phrase(scenarioSection, text, begin, end));
      Logger.getLogger(this.getClass()).info(text);
    });

    return phrases;
  }

  public String getEdgeRelationShortName() {
    return RELATION_SHORT_NAME;
  }
}
