package tesis.clear_tk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.fit.util.JCasUtil;

import tesis.extractors.ExtractorsManager;
import tesis.extractors.Phrase;
import uima.ruta.example.TestPerformance.PerformanceSentence;
import edu.stanford.nlp.ling.CoreAnnotations;
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
}
