package tesis.extractors;

import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.PhraseElement;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;

public class NominalSubjectExtractor extends PhraseExtractor {
	
	public NominalSubjectExtractor(int section) {
		super(section);
		RELATION_SHORT_NAME = "nsubj";
	}

	@Override
	protected PhraseElement doAssemble(SemanticGraph graph, SemanticGraphEdge edge) {
		IndexedWord indexedVerb = edge.getGovernor();

		String verb = indexedVerb.originalText();

		VPPhraseSpec verbPhrase = mFactory.createVerbPhrase(verb);
		boolean negated = getDependent(graph, indexedVerb, "neg") != EMPTY_INDEXED_WORD;
		verbPhrase.setFeature(Feature.NEGATED, negated);
		addCompounds(graph, indexedVerb, verbPhrase);

		PhraseExtractor nmodExtractor = new NounModExtractor(scenarioSection);
		PhraseElement nmodPhrase = nmodExtractor.doAssemble(graph, edge);
		
		SPhraseSpec phrase = null;
		
		if (nmodPhrase != null) {
			phrase = new SPhraseSpec(mFactory);
			phrase.setFeature(Feature.TENSE, Tense.PRESENT);
			phrase.setVerb(verbPhrase);
			phrase.addModifier(nmodPhrase);
		}
		
		return phrase;
	}

	@Override
	public String getEdgeRelationShortName() {
		return RELATION_SHORT_NAME;
	}

}
