/** 
 * Copyright (c) 2011, Regents of the University of Colorado 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer. 
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution. 
 * Neither the name of the University of Colorado at Boulder nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE. 
 */
package org.cleartk.examples.linewriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.cas.impl.XmiCasDeserializer;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.cleartk.clearnlp.MpAnalyzer;
import org.cleartk.opennlp.tools.PosTaggerAnnotator;
import org.cleartk.opennlp.tools.SentenceAnnotator;
import org.cleartk.token.tokenizer.TokenAnnotator;
import org.cleartk.token.type.Sentence;
import org.cleartk.util.ae.UriToDocumentTextAnnotator;
import org.cleartk.util.cr.UriCollectionReader;

import com.lexicalscope.jewel.cli.CliFactory;
import com.lexicalscope.jewel.cli.Option;
//este codigo apesta
/**
 * <br>
 * Copyright (c) 2011, Regents of the University of Colorado <br>
 * All rights reserved.
 */
public class Docs2Tokens {

  public interface Options {
    @Option(
        shortName = "i",
        longName = "inputFileName",
        description = "specify the directory to read plain text files from",
        defaultValue = "src/test/resources/data/twain")
    public File getInputDirectory();

    @Option(
        shortName = "o",
        longName = "outputPath",
        description = "specify the dir to write output files",
        defaultValue = "../ruta/input")
    public File getOutputFile();

  }

  public static void main(String[] args) throws Exception {

    Options options = CliFactory.parseArguments(Options.class, args);

    CollectionReader reader = UriCollectionReader.getCollectionReaderFromDirectory(options.getInputDirectory());

    AnalysisEngineDescription uriToText = UriToDocumentTextAnnotator.getDescription();

    AnalysisEngineDescription sentences = SentenceAnnotator.getDescription();

    AnalysisEngineDescription tokenizer = TokenAnnotator.getDescription();

    AnalysisEngineDescription lemmatizator = MpAnalyzer.getDescription();

    AnalysisEngineDescription posTagger = PosTaggerAnnotator.getDescription();

    AnalysisEngineDescription xmiWriter = AnalysisEngineFactory.createEngineDescription(XMIWriter.class,
    		XMIWriter.PARAM_OUTPUT_PATH,
            options.getOutputFile().getCanonicalPath());

    SimplePipeline.runPipeline(reader, uriToText, sentences, tokenizer, posTagger, lemmatizator, xmiWriter);
    System.out.println("results written to " + options.getOutputFile());

//    InputStream inputStream = new FileInputStream(options.getOutputFile());
//    // InputStream inputStream = xmiWriter.getSourceUrl().openStream();
//    JCas jCAS = JCasFactory.createJCas();
//    XmiCasDeserializer.deserialize(inputStream, jCAS.getCas());
//    Collection<Sentence> sentencesCollection = JCasUtil.select(jCAS, Sentence.class);
  }
}