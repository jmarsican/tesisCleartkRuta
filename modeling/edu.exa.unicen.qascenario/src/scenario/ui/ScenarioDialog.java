package scenario.ui;

import java.awt.List;
import java.io.IOException;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
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
import scenario.ScenarioPackage;

public class ScenarioDialog extends Dialog {

	private DataBindingContext context;
	private Binding bindValue;
	
	private static final int _ADDPLAYER = 1001;
	private GeneralScenario scenario;
	private ComposedAdapterFactory composedAdapterFactory;
	private Resource resource;

	private void createSection(Composite parent,String attribute,List items){
		Composite root = new Composite(parent, SWT.None);
		root.setLayout(new ColumnLayout());
		Label label = new Label(root, SWT.NONE);
		label.setText(attribute);
		
		/*create controls*/
		Composite nameComposite = new Composite(root, SWT.None);
		nameComposite.setLayout(new GridLayout(3, false));
		final Text input = new Text(nameComposite, SWT.NONE);
		Button btnAdd = new Button(nameComposite, SWT.PUSH);		
		
		/*create list*/
		final ListViewer listViewer = new ListViewer(root, SWT.SINGLE | SWT.H_SCROLL
				| SWT.V_SCROLL);
		listViewer.setContentProvider(new AdapterFactoryContentProvider(getAdapterFactory()));
		listViewer.setLabelProvider(new AdapterFactoryLabelProvider(getAdapterFactory()));
		listViewer.setInput(items);
		
		btnAdd.setText("Add");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
		    	  
		        String text = input.getText();
		        listViewer.refresh();
			}
		});
		new Button(nameComposite, SWT.PUSH).setText("Remove");
		
		root.layout();
	}
	
	protected Control createDialogArea(Composite parent) {
		Composite root = (Composite) super.createDialogArea(parent);
		root.setLayout(new GridLayout(2, true));
		//createSection(root,"Source");
		/*createSection(root,"Stimulus");
		createSection(root,"Environmnet");
		createSection(root,"Artifact");
		createSection(root,"Response");
		createSection(root,"Measure");*/
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
		case _ADDPLAYER:
			addPlayer();
			break;
		default:
			super.buttonPressed(buttonId);
		}
	}
	

	protected void addPlayer(){
		//Player player = BowlingFactory.eINSTANCE.createPlayer();
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(getScenario());
		Command command = AddCommand.create(editingDomain, getScenario(),
				ScenarioPackage.eINSTANCE.getGeneralScenario_Artifact(), "new measure");
		editingDomain.getCommandStack().execute(command);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, _ADDPLAYER, "Add Player", true);
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

	/*protected void setActivePlayer(Player firstElement) {
		//Remove old binding if existing and bind text field to name attribute
		if(bindValue!=null){
			bindValue.dispose();
		}
		text.setText("");
		ISWTObservableValue observeText = SWTObservables.observeText(text, SWT.Modify);
		IObservableValue observeValue = EMFObservables.observeValue(firstElement, BowlingPackage.eINSTANCE.getPlayer_Name());
		bindValue = context.bindValue(observeText, observeValue);
	}*/


}
