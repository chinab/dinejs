package de.alombra.dine.steps;

public interface StepMemory {

	public boolean add( String key, Object value );
	public boolean exists( String key );
	public Object get( String key );
	
	public String[] keyNames();
}
