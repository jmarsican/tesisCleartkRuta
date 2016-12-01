package tesis.extractors;

import java.util.stream.Stream;

import simplenlg.framework.PhraseElement;
import simplenlg.phrasespec.SPhraseSpec;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;

public abstract class PhraseExtractor {
	
	protected static final IndexedWord EMPTY_INDEXED_WORD = new IndexedWord("",0,0);
	
	public abstract SPhraseSpec assemble(SemanticGraph graph, SemanticGraphEdge edge);
	
	protected Stream<SemanticGraphEdge> getOutEdgesSorted(SemanticGraph graph, IndexedWord node, String relationShortName){
		return graph.getOutEdgesSorted(node).stream()
				.filter(e -> relationShortName.equals(e.getRelation().getShortName()));
	}
	
	protected IndexedWord getDependent(SemanticGraph graph, IndexedWord node, String relationShortName) {
		return getOutEdgesSorted(graph, node, relationShortName).findFirst()
				.map(e -> e.getDependent())
				.orElse(EMPTY_INDEXED_WORD);
	}
	
	protected void addCompounds(SemanticGraph graph, IndexedWord node, PhraseElement phrase) {
		getOutEdgesSorted(graph, node, "compound")
			.forEach(edge -> phrase.addPreModifier(edge.getDependent().originalText()));
	}
}
