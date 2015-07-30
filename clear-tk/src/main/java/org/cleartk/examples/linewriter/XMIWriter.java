package org.cleartk.examples.linewriter;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.XmiCasSerializer;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.ruta.engine.RutaEngine;
import org.apache.uima.util.XMLSerializer;

public class XMIWriter<ANNOTATION_TYPE extends Annotation, BLOCK_TYPE extends Annotation>
		extends JCasAnnotator_ImplBase {

	public static final String PARAM_OUTPUT_FILE_NAME = "outputFileName";

	@ConfigurationParameter(description = "Output file name.", name = PARAM_OUTPUT_FILE_NAME, mandatory = false)
	private String outputFileName;

	private static final String OUTPUT = "Output";

	private UimaContext context;

	private String output;

	@Override
	public void initialize(UimaContext aContext)
			throws ResourceInitializationException {
		super.initialize(aContext);
		if (aContext == null && context != null) {
			aContext = context;
		}
		if (aContext != null) {
			output = (String) aContext.getConfigParameterValue(OUTPUT);
			outputFileName = (String) aContext.getConfigParameterValue(PARAM_OUTPUT_FILE_NAME);
			this.context = aContext;
		}
	}

	private static void writeXmi(CAS aCas, File name) throws Exception {
		FileOutputStream out = null;

		try {
			// write XMI
			out = new FileOutputStream(name);
			XmiCasSerializer ser = new XmiCasSerializer(aCas.getTypeSystem());
			XMLSerializer xmlSer = new XMLSerializer(out, false);
			ser.serialize(aCas, xmlSer.getContentHandler());
		} catch (Exception e) {
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		CAS cas = jcas.getCas();

		Type sdiType = cas.getTypeSystem().getType(
				RutaEngine.SOURCE_DOCUMENT_INFORMATION);

		if (outputFileName == null) {
			outputFileName = "output.txt";
		}
		File file = new File(output, outputFileName);
		if (sdiType != null) {
			FSIterator<AnnotationFS> sdiit = cas.getAnnotationIndex(sdiType)
					.iterator();
			if (sdiit.isValid()) {
				AnnotationFS annotationFS = sdiit.get();
				Feature uriFeature = sdiType.getFeatureByBaseName("uri");
				String stringValue = annotationFS.getStringValue(uriFeature);
				File f = new File(stringValue);
				String name = f.getName();
				if (!name.endsWith(".xmi")) {
					name = name + ".xmi";
				}
				String parent = f.getParent().endsWith("/") ? f.getParent() : f
						.getParent() + "/";
				file = new File(parent + output, name);
			}

		}
		try {
			writeXmi(cas, file);
		} catch (Exception e) {
			throw new AnalysisEngineProcessException(e);
		}
	}
}
