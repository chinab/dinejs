package de.alombra.dine.steps.execution.instruction.impl;

import java.util.HashMap;
import java.util.Map;

public class StepInstruction extends AbstractInstruction {

	private String stepName;
	private Map<String, String> parameters = new HashMap<String, String>();
	
	public String getStepName() {
		return stepName;
	}
	public Map<String, String> getParameters() {
		return parameters;
	}
	public StepInstruction setStepName(String stepName) {
		this.stepName = stepName;
		return this;
	}
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	
	
}
