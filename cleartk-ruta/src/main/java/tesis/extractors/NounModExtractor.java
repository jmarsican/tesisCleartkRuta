package tesis.extractors;

import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.NLGFactory;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.PPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
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
			IndexedWord indexedObject = edge.getDependent();
			IndexedWord indexedComplement = getDependent(graph, indexedVerb, "nmod");
			IndexedWord indexedPreposition = getDependent(graph, indexedComplement, "case");
			IndexedWord indexedDeterminer = getDependent(graph, indexedComplement, "det");
			
			String verb = indexedVerb.originalText();
			String object = indexedObject.originalText();
			String complement = indexedComplement.originalText();
			String preposition = indexedPreposition.originalText();
			String complementDeterminer = indexedDeterminer.originalText();
			
			SPhraseSpec phrase = new SPhraseSpec(mFactory);
			
			NPPhraseSpec nlpComplement = mFactory.createNounPhrase(complement);
			nlpComplement.setDeterminer(complementDeterminer);
			PPPhraseSpec nlpModifier = mFactory.createPrepositionPhrase();
			nlpModifier.setPreposition(preposition);
			nlpModifier.setComplement(nlpComplement);

			VPPhraseSpec verbPhrase = mFactory.createVerbPhrase(verb);
			boolean negated = getDependent(graph, indexedVerb, "neg") != EMPTY_INDEXED_WORD;
			verbPhrase.setFeature(Feature.NEGATED, negated);
			phrase.setVerb(verbPhrase);
			addCompounds(graph, indexedVerb, verbPhrase);

			NPPhraseSpec nounPhrase = mFactory.createNounPhrase(object);
			phrase.setObject(nounPhrase);
			addCompounds(graph, indexedObject, nounPhrase);
			phrase.addModifier(nlpModifier);
			addCompounds(graph, indexedComplement, nlpComplement);

			phrase.setFeature(Feature.TENSE, Tense.PRESENT);
		return phrase;
	}

}
