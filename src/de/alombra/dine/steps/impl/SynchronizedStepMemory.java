package de.alombra.dine.steps.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.alombra.dine.steps.StepMemory;

public class SynchronizedStepMemory implements StepMemory {

	private Map<String, Object> memories = new ConcurrentHashMap<String, Object>();
	
	public boolean add(String key, Object value) {
		
		if ( exists( key ) )
			return false;
		
		memories.put( key, value );
		
		return true;
	}

	public Object get(String key) {
		return memories.get( key );
	}

	public boolean exists(String key) {		
		return memories.containsKey( key ); 
	}

	public String[] keyNames() {
		
		return this.memories.keySet().toArray( new String[] {} );
	}

}
