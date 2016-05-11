package edu.exa.unicen.qascenario.ui.popup.actions;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TreeViewer;
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
import scenario.ScenarioPackage;

public class ScenarioDialog extends Dialog {

	
	private static final int _GENERATE = 1001;
	private GeneralScenario scenario;
	private ComposedAdapterFactory composedAdapterFactory;
	private Resource resource;

	private void createSection(Composite parent,String attribute,final EStructuralFeature feature){
		Composite root = new Composite(parent, SWT.None);
		root.setLayout(new ColumnLayout());
		Label label = new Label(root, SWT.NONE);
		label.setText(attribute);
		
		/*create controls*/
		Composite nameComposite = new Composite(root, SWT.None);
		nameComposite.setLayout(new GridLayout(3, false));
		final Text input = new Text(nameComposite, SWT.NONE);
				
		
		/*create list*/
		final ListViewer listViewer = new ListViewer(root, SWT.SINGLE | SWT.H_SCROLL
				| SWT.V_SCROLL);
		listViewer.setContentProvider(new ArrayContentProvider());
		listViewer.setInput((EList<String>)getScenario().eGet(feature));
		
		Button btnAdd = new Button(nameComposite, SWT.PUSH);		
		btnAdd.setText("Add");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
		    	  
		        String text = input.getText();
		        ((EList<String>)getScenario().eGet(feature)).add(text);
		        listViewer.refresh();
			}
		});
		
		Button btnRemove = new Button(nameComposite, SWT.PUSH);
		btnRemove.setText("Remove");
		btnRemove.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
		    	  
				IStructuredSelection selection = (IStructuredSelection)listViewer.getSelection();
				String item = (String)selection.getFirstElement();
		        if(item != null) {
		        	((EList<String>)getScenario().eGet(feature)).remove(item);        
			        listViewer.refresh(false);
		        }
			}
		});
		
		root.layout();
	}
	
	protected Control createDialogArea(Composite parent) {
		Composite root = (Composite) super.createDialogArea(parent);
		root.setLayout(new GridLayout(2, true));
		createSection(root,"Source",ScenarioPackage.eINSTANCE.getGeneralScenario_Source());
		createSection(root,"Stimulus",ScenarioPackage.eINSTANCE.getGeneralScenario_Stimulus());
		createSection(root,"Environmnet",ScenarioPackage.eINSTANCE.getGeneralScenario_Environment());
		createSection(root,"Artifact",ScenarioPackage.eINSTANCE.getGeneralScenario_Artifact());
		createSection(root,"Response",ScenarioPackage.eINSTANCE.getGeneralScenario_Response());
		createSection(root,"Measure",ScenarioPackage.eINSTANCE.getGeneralScenario_Measure());
		
		TreeViewer treeViewer = new TreeViewer(root);
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(getAdapterFactory()));
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(getAdapterFactory()));
		
		//treeViewer.addSelectionChangedListener(this);

		treeViewer.setInput(resource.getResourceSet());

		new AdapterFactoryTreeEditor(treeViewer.getTree(), getAdapterFactory());

		parent.pack();
		return parent;
	}

	protected void loadContent(IFile file) throws IOException {
		AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(
				getAdapterFactory(), new BasicCommandStack());
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
			//addPlayer();
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
			Status status = new Status(IStatus.ERROR,
					"edu.exa.unicen", 0, e.getMessage(),
					null);
			ErrorDialog.openError(this.getShell(), "Error on save",
					"Something went wrong on save", status);
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
			composedAdapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
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
