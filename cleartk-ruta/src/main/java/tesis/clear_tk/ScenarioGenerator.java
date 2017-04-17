package tesis.clear_tk;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import scenario.ScenarioFactory;
import scenario.ScenarioPackage;
import scenario.impl.GeneralScenarioImpl;
import scenario.impl.ScenarioFactoryImpl;
import tesis.extractors.Phrase;

public class ScenarioGenerator {

  private static final String SCENARIO_OUTPUT_PATH = Properties.SCENARIOS_DIR + "%s.scenario";

  private static GeneralScenarioImpl createScenario(String documentLocation) {
    GeneralScenarioImpl scenario =
        (GeneralScenarioImpl) ScenarioFactoryImpl.eINSTANCE.createGeneralScenario();

    documentLocation = documentLocation.substring(0, documentLocation.lastIndexOf('.'));
    String absolutePath = new File(Properties.PLAIN_TEXT_DIR + documentLocation).getAbsolutePath();
    scenario.setDocumentLocation(absolutePath);

    ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    resourceSet.getPackageRegistry().put(ScenarioPackage.eNS_URI, ScenarioPackage.eINSTANCE);

    Resource resource = resourceSet.createResource(URI.createURI("http:///My.scenario"));
    resource.getContents().add(scenario);

    return scenario;
  }

  public static void run(List<Phrase> phrases, String filename) throws Exception {

    GeneralScenarioImpl scenario = createScenario(filename);

    phrases.forEach(phrase -> {
      scenario.Phrase scenarioPhrase = ScenarioFactory.eINSTANCE.createPhrase();
      scenarioPhrase.setBegin(phrase.getBegin());
      scenarioPhrase.setEnd(phrase.getEnd());
      scenarioPhrase.setValue(phrase.getText());

      ((EList<scenario.Phrase>) scenario.eGet(phrase.getScenarioSection(), true, true))
          .add(scenarioPhrase);
      scenario.eResource().getContents().add(scenarioPhrase);
    });

    String scenarioFileName =
        String.format(SCENARIO_OUTPUT_PATH, filename.substring(0, filename.indexOf('.')));
    FileOutputStream outputStream = new FileOutputStream(new File(scenarioFileName));
    scenario.eResource().save(outputStream, null);
  }

}
