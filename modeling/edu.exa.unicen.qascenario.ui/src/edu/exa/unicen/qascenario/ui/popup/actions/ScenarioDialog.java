package edu.exa.unicen.qascenario.ui.popup.actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import scenario.GeneralScenario;
import scenario.Phrase;
import scenario.ScenarioFactory;
import scenario.ScenarioPackage;
import scenario.impl.GeneralScenarioImpl;

public class ScenarioDialog extends Dialog {


  private static final int _GENERATE = 1001;
  private GeneralScenario scenario;
  private ComposedAdapterFactory composedAdapterFactory;
  private Resource resource;
  
  private Map<EStructuralFeature, ListViewer> map;

  private void openDocumentDialog(String documentLocation, int selectionStart, int selectionEnd) {
    DocumentDialog documentDialog = new DocumentDialog(createShell());
    documentDialog.loadContent(documentLocation, selectionStart, selectionEnd);
    documentDialog.open();
  }

  private void createSection(Composite parent, String attribute, final EStructuralFeature feature) {
    Composite root = new Composite(parent, SWT.None);
    root.setLayout(new ColumnLayout());
    Label label = new Label(root, SWT.NONE);
    label.setText(attribute);

    /* create controls */
    Composite nameComposite = new Composite(root, SWT.None);
    nameComposite.setLayout(new GridLayout(3, false));
    final Text input = new Text(nameComposite, SWT.NONE);

    /* create list */
    final ListViewer listViewer = new ListViewer(root, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    listViewer.setContentProvider(new ArrayContentProvider());
    listViewer.setInput((EList<Phrase>) scenario.eGet(feature));
    Button btnAdd = new Button(nameComposite, SWT.PUSH);
    btnAdd.setText("Add");
    btnAdd.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {

        String text = input.getText();
        Phrase phrase = ScenarioFactory.eINSTANCE.createPhrase();
        phrase.setValue(text);
        ((EList<Phrase>) scenario.eGet(feature)).add(phrase);
        resource.getContents().add(phrase);
        listViewer.refresh();
      }
    });

    IDoubleClickListener listener = new IDoubleClickListener() {

      @Override
      public void doubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = ((IStructuredSelection) event.getSelection());
        Phrase phrase = (Phrase) selection.getFirstElement();
        openDocumentDialog(scenario.getDocumentLocation(), phrase.getBegin(), phrase.getEnd());
      }
    };
    listViewer.addDoubleClickListener(listener);

    Button btnRemove = new Button(nameComposite, SWT.PUSH);
    btnRemove.setText("Remove");
    btnRemove.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {

        IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
        Iterator<Phrase> phrases = selection.iterator();
        while (phrases.hasNext()) {
          ((EList<Phrase>) getScenario().eGet(feature)).remove(phrases.next());
        }
        listViewer.refresh(false);
      }
    });
    
    map.put(feature, listViewer);

    root.layout();
  }

  protected Control createDialogArea(Composite parent) {
    Composite root = (Composite) super.createDialogArea(parent);
    root.setLayout(new GridLayout(2, true));

    map = new HashMap<EStructuralFeature, ListViewer>();
    createSection(root, "Source", ScenarioPackage.eINSTANCE.getGeneralScenario_Source());
    createSection(root, "Stimulus", ScenarioPackage.eINSTANCE.getGeneralScenario_Stimulus());
    createSection(root, "Environmnet", ScenarioPackage.eINSTANCE.getGeneralScenario_Environment());
    createSection(root, "Artifact", ScenarioPackage.eINSTANCE.getGeneralScenario_Artifact());
    createSection(root, "Response", ScenarioPackage.eINSTANCE.getGeneralScenario_Response());
    createSection(root, "Measure", ScenarioPackage.eINSTANCE.getGeneralScenario_Measure());

    parent.pack();
    return parent;
  }

  protected void loadContent(IFile file) throws IOException {
    AdapterFactoryEditingDomain editingDomain =
        new AdapterFactoryEditingDomain(getAdapterFactory(), new BasicCommandStack());
    resource = editingDomain.createResource(file.getFullPath().toString());
    resource.load(null);
    EObject eObject = resource.getContents().get(0);
    setScenario((GeneralScenario) eObject);
  }

  protected void save() throws IOException {
    resource.save(null);
  }

  protected void buttonPressed(int buttonId) {
    switch (buttonId) {
      case _GENERATE:
        GeneralScenarioImpl newScenario = ScenarioGenerator.createNewScenarioInstance();
        for (EStructuralFeature feature : map.keySet()) {
        	newScenario.eSet(feature, ((IStructuredSelection) map.get(feature).getSelection()).toList());
        }
        
        URI uri = resource.getURI();        
        String scenarioFileName = ResourcesPlugin.getWorkspace().getRoot().getLocation() + uri.toString() + ".gen";
        
        FileOutputStream outputStream;
		try {
			
			outputStream = new FileOutputStream(new File(scenarioFileName));
			newScenario.eResource().save(outputStream, null);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            
        
        break;
      default:
        super.buttonPressed(buttonId);
    }
  }


  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, _GENERATE, "Generate Concrete", true);
    super.createButtonsForButtonBar(parent);
  }

  @Override
  protected void okPressed() {
    try {
      save();
    } catch (IOException e) {
      Status status = new Status(IStatus.ERROR, "edu.exa.unicen", 0, e.getMessage(), null);
      ErrorDialog.openError(this.getShell(), "Error on save", "Something went wrong on save",
          status);
    }
    super.okPressed();
  }



  /**
   * Return an ComposedAdapterFactory for all registered modesl
   * 
   * @return a ComposedAdapterFactory
   */
  protected AdapterFactory getAdapterFactory() {
    if (composedAdapterFactory == null) {
      composedAdapterFactory =
          new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    }
    return composedAdapterFactory;
  }

  protected ScenarioDialog(Shell parentShell) {
    super(parentShell);
  }

  public GeneralScenario getScenario() {
    return scenario;
  }

  public void setScenario(GeneralScenario scenario) {
    this.scenario = scenario;
  }

}
