package tesis.extractors;

import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.NLGFactory;
import simplenlg.framework.PhraseElement;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;

public class NominalSubjectPassiveExtractor extends PhraseExtractor {

	public static final String RELATION_SHORT_NAME = "nsubjpass";

	public NominalSubjectPassiveExtractor(NLGFactory nlgFactory) {
		mFactory = nlgFactory;
	}

	@Override
	protected PhraseElement doAssemble(SemanticGraph graph,
			SemanticGraphEdge edge) {
		IndexedWord indexedVerb = edge.getGovernor();
		IndexedWord indexedObject = edge.getDependent();

		String verb = indexedVerb.originalText();
		String object = indexedObject.originalText();

		VPPhraseSpec verbPhrase = mFactory.createVerbPhrase(verb);
		boolean negated = getDependent(graph, indexedVerb, "neg") != EMPTY_INDEXED_WORD;
		verbPhrase.setFeature(Feature.NEGATED, negated);
		addCompounds(graph, indexedVerb, verbPhrase);

		NPPhraseSpec nounPhrase = mFactory.createNounPhrase(object);
		addCompounds(graph, indexedObject, nounPhrase);

		PhraseExtractor nmodExtractor = new NounModExtractor(mFactory);
		PhraseElement nmodPhrase = nmodExtractor.doAssemble(graph, edge);

		SPhraseSpec phrase = null;

		if (nmodPhrase != null) {
			phrase = new SPhraseSpec(mFactory);
			phrase.setFeature(Feature.TENSE, Tense.PRESENT);
			phrase.setVerb(verbPhrase);
			phrase.setObject(nounPhrase);
			phrase.addModifier(nmodPhrase);
		}

		return phrase;
	}

	@Override
	public String getEdgeRelationShortName() {
		return RELATION_SHORT_NAME;
	}

}
