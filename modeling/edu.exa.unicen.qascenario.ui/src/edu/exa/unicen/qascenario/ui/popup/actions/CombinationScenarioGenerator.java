package edu.exa.unicen.qascenario.ui.popup.actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;

import scenario.Phrase;
import scenario.impl.GeneralScenarioImpl;

public class CombinationScenarioGenerator extends ScenarioGenerator {

	public CombinationScenarioGenerator(URI uri) {
		super(uri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void generate(Map<EStructuralFeature, ListViewer> map) {
		int currentFeature = 0;
		EStructuralFeature feature = (EStructuralFeature) map.keySet().toArray()[currentFeature];
		// generate first tree level
		List<Object> phrases = ((IStructuredSelection) map.get(feature).getSelection()).toList();
		if (phrases.size() == 0) {
			generate(map, new HashMap<EStructuralFeature, Phrase>(), currentFeature + 1, null);
		} else {
			for (Object phrase : phrases) {
				generate(map, new HashMap<EStructuralFeature, Phrase>(), currentFeature + 1, (Phrase) phrase);
			}
		}
	}	

	private void generate(Map<EStructuralFeature, ListViewer> map, Map<EStructuralFeature, Phrase> newScenario, int currentFeature, Phrase currentPhrase) {
		EStructuralFeature[] features = (EStructuralFeature[]) map.keySet().toArray(new EStructuralFeature[map.size()]);
		if (currentPhrase != null)
          newScenario.put(features[currentFeature - 1], currentPhrase);
		if (features.length == currentFeature) {
			saveScenario(newScenario);
		} else {// generar hijos			
			List phrases = ((IStructuredSelection) map.get(features[currentFeature]).getSelection()).toList();
			if (phrases.size() == 0) {
				generate(map, newScenario, currentFeature + 1, null);
			} else {
				for (Object phrase : phrases) {
					generate(map, newScenario, currentFeature + 1, (Phrase) phrase);
				}
			}
		}
	}

	private void saveScenario(Map<EStructuralFeature, Phrase> scenarioValues) {
		GeneralScenarioImpl newScenario = createNewScenarioInstance();
		for (EStructuralFeature feature : scenarioValues.keySet()) {
			newScenario.eSet(feature, Arrays.asList(scenarioValues.get(feature)));
		}
		//Resolve cross references and avoid loose original references
	    newScenario.eResource().getContents().addAll(EcoreUtil.copyAll(newScenario.eCrossReferences()));

		String scenarioFileName = ResourcesPlugin.getWorkspace().getRoot()
				.getLocation()
				+ mUri.toString() + ".gen" + System.identityHashCode(newScenario);

		 FileOutputStream outputStream;
		 try {
		
		 outputStream = new FileOutputStream(new File(scenarioFileName));
		 newScenario.eResource().save(outputStream, null);
		
		
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
	}
	
	 @Override
	  public String toString() {	    
	    return "Combination";
	  }  
	  
}
