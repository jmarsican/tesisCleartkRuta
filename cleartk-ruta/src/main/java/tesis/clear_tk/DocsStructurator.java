package tesis.clear_tk;

import java.io.File;
import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.cleartk.clearnlp.MpAnalyzer;
import org.cleartk.opennlp.tools.PosTaggerAnnotator;
import org.cleartk.opennlp.tools.SentenceAnnotator;
import org.cleartk.token.tokenizer.TokenAnnotator;
import org.cleartk.util.ae.UriToDocumentTextAnnotator;
import org.cleartk.util.cr.UriCollectionReader;

import com.google.common.collect.Lists;

public class DocsStructurator {

  public static void run(String pathname) throws Exception {

    Collection<File> files = Lists.newArrayList(new File(pathname));

    CollectionReader reader = UriCollectionReader.getCollectionReaderFromFiles(files);

    AnalysisEngineDescription uriToText = UriToDocumentTextAnnotator.getDescription();

    AnalysisEngineDescription sentences = SentenceAnnotator.getDescription();

    AnalysisEngineDescription tokenizer = TokenAnnotator.getDescription();

    AnalysisEngineDescription lemmatizator = MpAnalyzer.getDescription();

    AnalysisEngineDescription posTagger = PosTaggerAnnotator.getDescription();

    AnalysisEngineDescription xmiWriter =
        AnalysisEngineFactory.createEngineDescription(XMIWriter.class, XMIWriter.PARAM_OUTPUT_PATH,
            Properties.ANNOTATED_DOCS_DIR);

    SimplePipeline.runPipeline(reader, uriToText, sentences, tokenizer, posTagger, lemmatizator,
        xmiWriter);
    System.out.println("results written to " + Properties.ANNOTATED_DOCS_DIR);
  }
}
