package edu.exa.unicen.qascenario.ui.popup.actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;

import scenario.impl.GeneralScenarioImpl;

public class MultiValueScenarioGenerator extends ScenarioGenerator {

  public MultiValueScenarioGenerator(URI uri) {
    super(uri);
  }

  @Override
  public void generate(Map<EStructuralFeature, ListViewer> map) {
    GeneralScenarioImpl newScenario = createNewScenarioInstance();
    for (EStructuralFeature feature : map.keySet()) {
      newScenario.eSet(feature, ((IStructuredSelection) map.get(feature).getSelection()).toList());
    }
    //Resolve cross references
    newScenario.eResource().getContents().addAll(EcoreUtil.copyAll(newScenario.eCrossReferences()));

    String scenarioFileName =
        ResourcesPlugin.getWorkspace().getRoot().getLocation() + mUri.toString() + ".gen";

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
    
    return "Multi-Value";
  }  
  

}
