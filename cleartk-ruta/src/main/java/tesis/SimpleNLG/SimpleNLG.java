package tesis.SimpleNLG;

import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.PPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.realiser.english.Realiser;

public class SimpleNLG {

	public static void main(String[] args) {
		Lexicon lexicon = Lexicon.getDefaultLexicon();
		NLGFactory factory = new NLGFactory(lexicon);
		SPhraseSpec phrase = new SPhraseSpec(factory);
		Realiser realiser = new Realiser(lexicon);
		
		NPPhraseSpec complement = factory.createNounPhrase("user");
		complement.setDeterminer("the");
		PPPhraseSpec prepPhrase = factory.createPrepositionPhrase();
		prepPhrase.setPreposition("on");
		prepPhrase.setComplement(complement);
				
		
		phrase.setVerb(factory.createVerbPhrase("display"));
		phrase.setObject(factory.createNounPhrase("the alarm"));
		phrase.addModifier(prepPhrase);
		
		phrase.setFeature(Feature.TENSE, Tense.PRESENT);
		
		System.out.println(realiser.realise(phrase));
	}

}
