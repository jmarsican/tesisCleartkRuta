package edu.exa.unicen.qascenario.ui.popup.actions;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.ListViewer;

import scenario.ScenarioPackage;
import scenario.impl.GeneralScenarioImpl;
import scenario.impl.ScenarioFactoryImpl;

public abstract class ScenarioGenerator {
	protected URI mUri;
	
	public ScenarioGenerator(URI uri) {
		mUri = uri;
	}

	public GeneralScenarioImpl createNewScenarioInstance() {
		GeneralScenarioImpl scenario = (GeneralScenarioImpl) ScenarioFactoryImpl.eINSTANCE
				.createGeneralScenario();

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(ScenarioPackage.eNS_URI, ScenarioPackage.eINSTANCE);

		Resource resource = resourceSet.createResource(URI.createURI("http:///My.scenario"));
		resource.getContents().add(scenario);

		return scenario;
	}

	public abstract void generate(Map<EStructuralFeature, ListViewer> map);
}
