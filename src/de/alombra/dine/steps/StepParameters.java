package de.alombra.dine.steps;

public interface StepParameters {

	public StepParameters setAttribute(String key, String value);

	public String getAttribute(String key);

	public String[] keyNames();

}