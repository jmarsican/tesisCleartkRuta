package tesis.extractors;

import simplenlg.framework.NLGFactory;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.PPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;

public class NounModExtractor extends PhraseExtractor {
	
	public NounModExtractor(NLGFactory nlgFactory) {
		mFactory = nlgFactory;
	}
	
	@Override
	public SPhraseSpec assemble(SemanticGraph graph, SemanticGraphEdge edge) {
			IndexedWord indexedVerb = edge.getGovernor(); 
			IndexedWord indexedComplement = getDependent(graph, indexedVerb, "nmod");
			IndexedWord indexedPreposition = getDependent(graph, indexedComplement, "case");
			IndexedWord indexedDeterminer = getDependent(graph, indexedComplement, "det");
			
			String complement = indexedComplement.originalText();
			String preposition = indexedPreposition.originalText();
			String complementDeterminer = indexedDeterminer.originalText();
			
			SPhraseSpec phrase = new SPhraseSpec(mFactory);
			
			NPPhraseSpec nlpComplement = mFactory.createNounPhrase(complement);
			nlpComplement.setDeterminer(complementDeterminer);
			PPPhraseSpec nlpModifier = mFactory.createPrepositionPhrase();
			nlpModifier.setPreposition(preposition);
			nlpModifier.setComplement(nlpComplement);

			phrase.addModifier(nlpModifier);
			addCompounds(graph, indexedComplement, nlpComplement);

		return phrase;
	}

	@Override
	public String getEdgeRelationShortName() {
		return "nmod";
	}

}
