package tesis.SimpleNLG;

import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.realiser.english.Realiser;

public class SimpleNLG {

	public static void main(String[] args) {
		Lexicon lexicon = Lexicon.getDefaultLexicon();
		NLGFactory factory = new NLGFactory(lexicon);
		SPhraseSpec phrase = new SPhraseSpec(factory);
		Realiser realiser = new Realiser(lexicon);

		phrase.setSubject(factory.createNounPhrase("my dog"));
		phrase.setVerb(factory.createVerbPhrase("chase"));
		phrase.setObject(factory.createNounPhrase("George"));
		
		phrase.setFeature(Feature.TENSE, Tense.PRESENT);
		phrase.setFeature(Feature.TENSE, Tense.PRESENT);
		phrase.setFeature(Feature.TENSE, Tense.PRESENT);
		
		System.out.println(realiser.realise(phrase));
	}

}
