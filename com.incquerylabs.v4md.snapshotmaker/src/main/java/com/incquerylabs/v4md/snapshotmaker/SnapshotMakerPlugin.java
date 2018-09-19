package com.incquerylabs.v4md.snapshotmaker;

import com.incquerylabs.v4md.snapshotmaker.ui.SnapshotmakerMainMenuConfigurator;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.plugins.Plugin;

public class SnapshotMakerPlugin extends Plugin {
	@Override
	public boolean close() {
		return true;
	}

	@Override
	public void init() {

		ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();
		manager.addMainMenuConfigurator(new SnapshotmakerMainMenuConfigurator());

	}

	@Override
	public boolean isSupported() {
		return true;
	}

	

}
