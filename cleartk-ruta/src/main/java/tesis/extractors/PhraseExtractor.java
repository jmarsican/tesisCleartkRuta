package tesis.extractors;

import java.util.Optional;

import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;
import simplenlg.phrasespec.SPhraseSpec;

public abstract class PhraseExtractor {
	
	private static final IndexedWord EMPTY_INDEXED_WORD = new IndexedWord("",0,0);
	
	public abstract SPhraseSpec assemble(SemanticGraph graph, SemanticGraphEdge edge);
	
	protected IndexedWord getDependent(SemanticGraph graph, IndexedWord node, String relationShortName) {
		Optional<IndexedWord> indexedWord = 
				graph.getOutEdgesSorted(node).stream()
				.filter(e -> relationShortName.equals(e.getRelation().getShortName()))
				.findFirst().map(e -> e.getDependent());
		return indexedWord.orElse(EMPTY_INDEXED_WORD);
	}
}
