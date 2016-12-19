package tesis.extractors;

import simplenlg.framework.NLGFactory;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;

public class DirectObjectExtractor extends PhraseExtractor {
	
	private NLGFactory mFactory;
	
	public DirectObjectExtractor(NLGFactory factory) {
		mFactory = factory;
	}

	@Override
	public SPhraseSpec assemble(SemanticGraph graph, SemanticGraphEdge edge) {
		IndexedWord indexedVerb = edge.getGovernor(); 
		IndexedWord indexedObject = getDependent(graph, indexedVerb, "dobj");
		IndexedWord indexedModifier = getDependent(graph, indexedObject, "amod");
		IndexedWord indexedDeterminer = getDependent(graph, indexedObject, "det");
		
		String verb = indexedVerb.originalText(); // update
		String object = indexedObject.originalText(); // user
		String modifier = indexedModifier.originalText(); 
		String determiner = indexedDeterminer.originalText(); // the
		
		SPhraseSpec phrase = new SPhraseSpec(mFactory);
		
		NPPhraseSpec nlpComplement = mFactory.createNounPhrase(object);
		nlpComplement.setDeterminer(determiner);
		nlpComplement.addModifier(modifier);
		
		phrase.setVerb(mFactory.createVerbPhrase(verb));
		phrase.setObject(nlpComplement);
		
		return phrase;
	}

}
