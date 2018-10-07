package com.incquerylabs.v4md.test.runner;

import com.nomagic.magicdraw.commandline.CommandLineActionManager;
import com.nomagic.magicdraw.plugins.Plugin;

public class ValidationTestPlugin extends Plugin {

	@Override
	public void init() {
		CommandLineActionManager.getInstance().addAction(new TestRunner());
	}

	@Override
	public boolean close() {
		return true;
	}

	@Override
	public boolean isSupported() {
		return true;
	}
}