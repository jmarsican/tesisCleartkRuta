package tesis.extractors;

import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.NLGFactory;
import simplenlg.framework.PhraseElement;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;

public class NominalSubjectExtractor extends PhraseExtractor {
	
	public NominalSubjectExtractor(NLGFactory nlgFactory) {
		mFactory = nlgFactory;
	}
	
	@Override
	public PhraseElement assemble(SemanticGraph graph, SemanticGraphEdge edge) {
			IndexedWord indexedVerb = edge.getGovernor(); 
			
			String verb = indexedVerb.originalText();
			
			SPhraseSpec phrase = new SPhraseSpec(mFactory);
			
			VPPhraseSpec verbPhrase = mFactory.createVerbPhrase(verb);
			boolean negated = getDependent(graph, indexedVerb, "neg") != EMPTY_INDEXED_WORD;
			verbPhrase.setFeature(Feature.NEGATED, negated);
			phrase.setVerb(verbPhrase);
			addCompounds(graph, indexedVerb, verbPhrase);

			PhraseExtractor extractor = new NounModExtractor(mFactory);
			phrase.addModifier(extractor.assemble(graph, edge));

			phrase.setFeature(Feature.TENSE, Tense.PRESENT);
		return phrase;
	}

	@Override
	public String getEdgeRelationShortName() {
		return "nsubj";
	}

}
