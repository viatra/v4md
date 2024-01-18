package com.incquerylabs.v4md.test.runner;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.nomagic.magicdraw.commandline.CommandLineActionManager;
import com.nomagic.magicdraw.plugins.Plugin;

public class ValidationTestPlugin extends Plugin {

	@Override
	public void init() {
		CommandLineActionManager.getInstance().addAction(new TestRunner());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("snapshot", new XMIResourceFactoryImpl());
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