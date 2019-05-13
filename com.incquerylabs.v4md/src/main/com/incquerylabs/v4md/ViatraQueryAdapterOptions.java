package com.incquerylabs.v4md;

public class ViatraQueryAdapterOptions {

	private static final ViatraQueryAdapterOptions instance = new ViatraQueryAdapterOptions();
	private boolean enableEngineProfiling = false;
	
	private ViatraQueryAdapterOptions() {
		// Hidden singleton constructor
	}
	
	public static ViatraQueryAdapterOptions getInstance() {
		return instance;
	}

	public boolean isEnableEngineProfiling() {
		return enableEngineProfiling;
	}

	public void setEnableEngineProfiling(boolean enableEngineProfiling) {
		this.enableEngineProfiling = enableEngineProfiling;
	}
	
}
