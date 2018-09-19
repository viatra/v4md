package com.incquerylabs.v4md.snapshotmaker.ui.action;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.incquerylabs.v4md.snapshotmaker.trafos.FullModelBatchTransformation;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.ui.dialogs.MDDialogParentProvider;

public class ExampleAction extends MDAction{
	private static final long serialVersionUID = 8437220468635496371L;

	public ExampleAction(String id, String name) {
		super(id, name, null, null);
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Project project = Application.getInstance().getProject();
		ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
		AdvancedViatraQueryEngine engine = adapter.getEngine();
		
		FullModelBatchTransformation trafo = new FullModelBatchTransformation(engine);
		trafo.execute();
		
		JOptionPane.showMessageDialog(MDDialogParentProvider.getProvider().getDialogParent(), "The correction has been done");
	}
}
