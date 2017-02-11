package tesis.SimpleNLG;

import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.PPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import simplenlg.realiser.english.Realiser;

public class SimpleNLG {

	public static void main(String[] args) {
		Lexicon lexicon = Lexicon.getDefaultLexicon();
		NLGFactory factory = new NLGFactory(lexicon);
		SPhraseSpec phrase = new SPhraseSpec(factory);
				
		VPPhraseSpec verb = factory.createVerbPhrase("updating");
		verb.setFeature(Feature.NEGATED, true);
		phrase.setVerb(verb);

		NPPhraseSpec subject = factory.createNounPhrase("The system");
		phrase.setSubject(subject);
		phrase.setObject(factory.createNounPhrase("the alarm"));

		PPPhraseSpec prepPhrase = factory.createPrepositionPhrase();
		NPPhraseSpec complement = factory.createNounPhrase("user interface");
		complement.setDeterminer("the");
		prepPhrase.setComplement(complement);
		prepPhrase.setPreposition("on");
		phrase.addModifier(prepPhrase);		
		
		Realiser realiser = new Realiser(lexicon);
		System.out.println(realiser.realise(phrase));
	}

}
