package org.cleartk.examples.linewriter;

import java.io.IOException;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.util.InvalidXMLException;
import org.apache.uima.util.XMLInputSource;

public class PruebaXMIReader {

  public static void main(String[] args) {
    // get Resource Specifier from XML file
    XMLInputSource in;
    try {
      in = new XMLInputSource("MyDescriptor.xml");
      ResourceSpecifier specifier = UIMAFramework.getXMLParser().parseResourceSpecifier(in);
      // XmiCasDeserializer.deserialize(aStream, aCAS);
      // create AE here
      AnalysisEngine ae = UIMAFramework.produceAnalysisEngine(specifier);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InvalidXMLException e) {

    } catch (ResourceInitializationException e) {

    }

  }

}
