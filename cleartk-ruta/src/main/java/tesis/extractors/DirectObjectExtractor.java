package tesis.extractors;

import simplenlg.framework.NLGFactory;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;

public class DirectObjectExtractor extends PhraseExtractor {

	public static final String RELATION_SHORT_NAME = "dobj";

	public DirectObjectExtractor(NLGFactory factory) {
		mFactory = factory;
	}

	@Override
	protected SPhraseSpec doAssemble(SemanticGraph graph, SemanticGraphEdge edge) {
		IndexedWord indexedVerb = edge.getGovernor();
		IndexedWord indexedObject = getDependent(graph, indexedVerb, "dobj");
		IndexedWord indexedModifier = getDependent(graph, indexedObject, "amod");
		IndexedWord indexedDeterminer = getDependent(graph, indexedObject,
				"det");

		String verb = indexedVerb.originalText();
		String object = indexedObject.originalText();
		String modifier = indexedModifier.originalText();
		String determiner = indexedDeterminer.originalText();

		if (object.length() + modifier.length() + determiner.length() == 0) {
			return null;
		}

		NPPhraseSpec nlpComplement = mFactory.createNounPhrase(object);
		nlpComplement.setDeterminer(determiner);
		nlpComplement.addModifier(modifier);

		SPhraseSpec phrase = null;

		phrase = new SPhraseSpec(mFactory);
		phrase.setVerb(mFactory.createVerbPhrase(verb));
		phrase.setObject(nlpComplement);

		return phrase;
	}

	@Override
	public String getEdgeRelationShortName() {
		return RELATION_SHORT_NAME;
	}

}
