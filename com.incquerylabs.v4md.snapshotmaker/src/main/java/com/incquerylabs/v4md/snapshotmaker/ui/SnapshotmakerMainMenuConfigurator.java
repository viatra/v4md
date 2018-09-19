/*
 *
 * Copyright (c) 2002 NoMagic, Inc. All Rights Reserved.
 */

package com.incquerylabs.v4md.snapshotmaker.ui;

import com.incquerylabs.v4md.snapshotmaker.ui.action.ExampleAction;
import com.incquerylabs.v4md.snapshotmaker.ui.action.MakeSnapshot;
import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.MDActionsCategory;

public class SnapshotmakerMainMenuConfigurator implements AMConfigurator {

	String SNAPSHOT_MAKER = "SnapshotMaker";
	
	final static String EXAMPLE_ID = "EXAMPLE";
	final static String EXAMPLE_NAME = "Example";
	
	public SnapshotmakerMainMenuConfigurator() {
	}
	
	

	@Override
	public void configure(ActionsManager manager) {
		// searching for Examples action category
		ActionsCategory category = (ActionsCategory) manager.getActionFor(SNAPSHOT_MAKER);

		if (category == null) {
			// creating new category
			category = new MDActionsCategory(SNAPSHOT_MAKER, SNAPSHOT_MAKER);
			category.setNested(true);
			manager.addCategory(category);
		}
		
		
		category.addAction(new ExampleAction(EXAMPLE_ID, EXAMPLE_NAME));
		category.addAction(new MakeSnapshot("MAKE_SNAPSHOT", "MAKE_SNAPSHOT"));
	}

	@Override
	public int getPriority() {
		return AMConfigurator.MEDIUM_PRIORITY;
	}

}