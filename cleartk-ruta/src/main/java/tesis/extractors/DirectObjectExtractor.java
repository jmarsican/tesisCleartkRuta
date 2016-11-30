package tesis.extractors;

import simplenlg.framework.NLGFactory;
import simplenlg.phrasespec.SPhraseSpec;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;

public class DirectObjectExtractor extends PhraseExtractor {
	
	private NLGFactory mFactory;

	@Override
	public SPhraseSpec assemble(SemanticGraph graph, SemanticGraphEdge edge) {
		IndexedWord indexedVerb = edge.getGovernor(); 
		IndexedWord indexedComplement = getDependent(graph, indexedVerb, "nmod");
		IndexedWord indexedModifier = getDependent(graph, edge.getDependent(), "amod");
		IndexedWord indexedDeterminer = getDependent(graph, edge.getDependent(), "det");
		
		String verb = indexedVerb.originalText(); // update
		String object = edge.getDependent().originalText(); // alarm
		String complement = indexedComplement.originalText(); // user
		String modifier = indexedModifier.originalText(); 
		String complementDeterminer = indexedDeterminer.originalText(); // the
		
		return null;
	}

}
