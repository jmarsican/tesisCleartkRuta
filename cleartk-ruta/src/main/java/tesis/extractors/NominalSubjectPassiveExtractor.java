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
	
	public NominalSubjectPassiveExtractor(NLGFactory nlgFactory) {
		mFactory = nlgFactory;
	}
	
	@Override
	public PhraseElement assemble(SemanticGraph graph, SemanticGraphEdge edge) {
			IndexedWord indexedVerb = edge.getGovernor(); 
			IndexedWord indexedObject = edge.getDependent();
			
			String verb = indexedVerb.originalText();
			String object = indexedObject.originalText();
			
			SPhraseSpec phrase = new SPhraseSpec(mFactory);
			
			VPPhraseSpec verbPhrase = mFactory.createVerbPhrase(verb);
			boolean negated = getDependent(graph, indexedVerb, "neg") != EMPTY_INDEXED_WORD;
			verbPhrase.setFeature(Feature.NEGATED, negated);
			phrase.setVerb(verbPhrase);
			addCompounds(graph, indexedVerb, verbPhrase);

			NPPhraseSpec nounPhrase = mFactory.createNounPhrase(object);
			phrase.setObject(nounPhrase);
			addCompounds(graph, indexedObject, nounPhrase);
			
			PhraseExtractor extractor = new NounModExtractor(mFactory);
			phrase.addModifier(extractor.assemble(graph, edge));
			

			phrase.setFeature(Feature.TENSE, Tense.PRESENT);
		return phrase;
	}

	@Override
	public String getEdgeRelationShortName() {
		return "nsubjpass";
	}

}
