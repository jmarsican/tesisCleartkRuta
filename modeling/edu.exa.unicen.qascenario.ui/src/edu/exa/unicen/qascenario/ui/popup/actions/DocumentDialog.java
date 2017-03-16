package edu.exa.unicen.qascenario.ui.popup.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DocumentDialog extends Dialog {

  private String documentLocation;

  private int selectionStart;

  private int selectionEnd;

  public DocumentDialog(Shell parentShell) {
    super(parentShell);
  }

  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);
    Text text = new Text(container, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
    text.setEditable(false);

    GridData gridData = new GridData();
    gridData.horizontalAlignment = GridData.FILL;
    gridData.verticalAlignment = GridData.FILL;
    gridData.grabExcessHorizontalSpace = true;
    gridData.grabExcessVerticalSpace = true;
    gridData.horizontalSpan = 2;
    text.setLayoutData(gridData);

    text.setText(getDocumentText());
    text.setSelection(this.selectionStart, this.selectionEnd);

    return container;
  }

  private String getDocumentText() {
    byte[] document = {};
    try {
      document = Files.readAllBytes(Paths.get(documentLocation));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new String(document);
  }

  @Override
  protected boolean isResizable() {
    return true;
  }

  public void loadContent(String documentLocation, int selectionStart, int selectionEnd) {
    this.documentLocation = documentLocation;
    this.selectionStart = selectionStart;
    this.selectionEnd = selectionEnd;
  }

  public int getSelectionStart() {
    return selectionStart;
  }

  public int getSelectionEnd() {
    return selectionEnd;
  }


}
