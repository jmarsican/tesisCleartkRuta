package tesis.extractors;

import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;
import simplenlg.phrasespec.SPhraseSpec;

public interface IPhraseExtractor {
	SPhraseSpec assemble(SemanticGraph graph, SemanticGraphEdge edge);
}
