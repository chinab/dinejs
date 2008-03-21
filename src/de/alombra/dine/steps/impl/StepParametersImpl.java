package de.alombra.dine.steps.impl;

import java.util.HashMap;
import java.util.Map;

import de.alombra.dine.steps.StepParameters;

public class StepParametersImpl implements StepParameters {

	private Map<String, String> attributes = new HashMap<String, String>();
	
	public StepParameters setAttribute( String key, String value ) {
		this.attributes.put( key, value );
		return this;
	}
	
	public String getAttribute(String key) {
		return this.attributes.get( key );
	}
	
	public String[] keyNames() {
		return this.attributes.keySet().toArray( new String[] {} );
	}
}
