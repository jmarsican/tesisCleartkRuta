package edu.exa.unicen.qascenario.ui.popup.actions;
/******************************************************************************
 * All Right Reserved. 
 * Copyright (c) 1998, 2004 Jackwind Li Guojie
 * 
 * Created on Feb 15, 2004 10:57:32 AM by JACK
 * $Id$
 * 
 *****************************************************************************/



import java.util.Vector;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class SampleListViewer {
  
  Shell shell;
  
  ListViewer listViewer;

  /**
   * Represents programming languages. 
   *
   */
  public static class Language {
    public String genre;
    public boolean isObjectOriented;
    
    public Language() { }
    public Language(String genre, boolean isObjectOriented) {
      this.genre = genre;
      this.isObjectOriented = isObjectOriented;
    }
    
    public String toString() {
      return "Lang: " + genre + " [" + (isObjectOriented ? "Object-oriented" : "Procedural") + "]";
    }
  }
  
  Vector<Language> languages = new Vector<Language>();
  
  private void init() {
    languages.add(new Language("Java", true));
    languages.add(new Language("C", false));
    languages.add(new Language("C++", true));
    languages.add(new Language("SmallTalk", true));
    
    listViewer = new ListViewer(shell);    
    
    listViewer.setContentProvider(new ArrayContentProvider());
    
    listViewer.setInput(languages);
    
    listViewer.setLabelProvider(new LabelProvider() {
      public String getText(Object element) {
        return ((Language)element).genre;
      }
    });    

    listViewer.setSorter(new ViewerSorter(){
      public int compare(Viewer viewer, Object e1, Object e2) {
        return ((Language)e1).genre.compareTo(((Language)e2).genre);
      }

    });
    
  }
  
  Button buttonAdd;
  Button buttonRemove;
  
  private void addButtons() {
    Composite composite = new Composite(shell, SWT.NULL);
    FillLayout fillLayout = new FillLayout(SWT.VERTICAL);
    fillLayout.spacing = 2;
    
    composite.setLayout(fillLayout);
    
    buttonAdd = new Button(composite, SWT.PUSH);
    buttonAdd.setText("Add");
    
    buttonRemove = new Button(composite, SWT.PUSH);
    buttonRemove.setText("Remove");
    
    buttonAdd.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
    	  
        String text ="";
        InputDialog input = new InputDialog(shell, "New language genre: ",
        		"Add new element", "XXXX", new IInputValidator() {
            public String isValid(final String s) {
                if (s.getBytes().length > 1024) {
                    return "";
                }
                return null;
            }
        });
        
        if (input.open() == Window.OK) {
            text = input.getValue();        
            if(text != null) 
            	languages.add(new Language(text, true));
        }
        
        listViewer.refresh(false);
      }
    });

       
    buttonRemove.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
        IStructuredSelection selection = (IStructuredSelection)listViewer.getSelection();
        Language language = (Language)selection.getFirstElement();
        if(language != null) {
	        languages.remove(language);        
	        listViewer.refresh(false);
        }
      }
    });
  }
    
  
  public SampleListViewer() {
	Display display = new Display();
	shell = new Shell(display);
    RowLayout rowLayout = new RowLayout();
    shell.setLayout(rowLayout);
    
    (new Label(shell, SWT.NULL)).setText("What programming languages are you proficient in? ");
    
    init();
    
    addButtons();

    shell.pack();
    shell.open();
    //textUser.forceFocus();
    new ScenarioDialog(shell).open();

    // Set up the event loop.
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        // If no more entries in event queue
        display.sleep();
      }
    }

    display.dispose();
  }
  public static void main(String[] args) {
    new SampleListViewer();
  }
}