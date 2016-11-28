package tesis.extractors;

import java.util.Optional;

import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.NLGFactory;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.PPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;

public class NounModExtractor extends PhraseExtractor {
	
	private NLGFactory mFactory;
	
	public NounModExtractor(NLGFactory nlgFactory) {
		mFactory = nlgFactory;
	}

	@Override
	public SPhraseSpec assemble(SemanticGraph graph, SemanticGraphEdge edge) {
			IndexedWord indexedVerb = edge.getGovernor(); 
			IndexedWord indexedComplement = getDependent(graph, indexedVerb, "nmod");
			IndexedWord indexedPreposition = getDependent(graph, indexedComplement, "case");
			IndexedWord indexedDeterminer = getDependent(graph, indexedComplement, "det");
			
			String verb = indexedVerb.originalText(); // update
			String object = edge.getDependent().originalText(); // alarm
			String complement = indexedComplement.originalText(); // user
			String preposition = indexedPreposition.originalText(); // on
			String complementDeterminer = indexedDeterminer.originalText(); // the
			
			SPhraseSpec phrase = new SPhraseSpec(mFactory);
			
			NPPhraseSpec nlpComplement = mFactory.createNounPhrase(complement);
			nlpComplement.setDeterminer(complementDeterminer);
			PPPhraseSpec nlpModifier = mFactory.createPrepositionPhrase();
			nlpModifier.setPreposition(preposition);
			nlpModifier.setComplement(nlpComplement);
			
			phrase.setVerb(mFactory.createVerbPhrase(verb));
			phrase.setObject(mFactory.createNounPhrase(object));
			phrase.addModifier(nlpModifier);

			phrase.setFeature(Feature.TENSE, Tense.PRESENT);
		return phrase;
	}

}
