package tesis.clear_tk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.fit.util.JCasUtil;

import tesis.extractors.ExtractorsManager;
import tesis.extractors.Phrase;
import uima.ruta.example.TestPerformance.PerformanceSentence;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class ScenarioLinker {

  private static List<Annotation> performanceSentenceToStanfordAnnotation(CAS cas)
      throws CASException {
    Collection<PerformanceSentence> sentences =
        JCasUtil.select(cas.getJCas(), PerformanceSentence.class);

    List<Annotation> annotations = new ArrayList<Annotation>();
    for (PerformanceSentence sentence : sentences) {

      Annotation annotation = new Annotation(sentence.getCoveredText());
      annotation.set(CoreAnnotations.BeginIndexAnnotation.class, sentence.getBegin());
      annotation.set(CoreAnnotations.EndIndexAnnotation.class, sentence.getEnd());
      annotations.add(annotation);
    }

    return annotations;
  }

  public static List<Phrase> extract(CAS cas) throws Exception {
    // Create Stanford CoreNLP pipeline
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,depparse,natlog,openie");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

    List<Annotation> annotations = performanceSentenceToStanfordAnnotation(cas);
    pipeline.annotate(annotations);

    List<Phrase> phrases = new ArrayList<Phrase>();

    ExtractorsManager extractorsManager = new ExtractorsManager();
    // Loop over sentences in the document
    annotations.forEach(annotation -> {
      extractorsManager.getExtractors().forEach(
          extractor -> phrases.addAll(extractor.extract(annotation)));
    });

    return phrases;
  }

  public static Set<String> getLemmas(List<Phrase> phrases) throws Exception {
    String text =
        phrases.stream().map(phrase -> phrase.getText()).collect(Collectors.joining("\n"));
    return getLemmas(text);
  }

  public static Set<String> getLemmas(String text) {
    // Create Stanford CoreNLP pipeline
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

    Annotation document = new Annotation(text);
    pipeline.annotate(document);

    Set<String> lemmas =
        document.get(SentencesAnnotation.class).stream()
            .map(sentence -> sentence.get(TokensAnnotation.class)).flatMap(List::stream)
            .filter(token -> token.tag().startsWith("VB") || token.tag().startsWith("NN"))
            .map(token -> token.lemma()).collect(Collectors.toSet());

    System.out.println("TEXT: " + text);
    System.out.println("LEMMAS:");
    lemmas.forEach(lemma -> System.out.println(lemma));

    return lemmas;
  }
}
