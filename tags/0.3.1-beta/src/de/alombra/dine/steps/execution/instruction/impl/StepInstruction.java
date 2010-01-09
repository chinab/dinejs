package de.alombra.dine.steps.execution.instruction.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * This instruction will make dine execute the named step for
 * the result of this HTTP request
 * 
 * @author ssc
 */
public class StepInstruction extends AbstractInstruction {

  /**
   * the name of the step to execute
   */
	private String stepName;
	
	/**
	 * the parameters to pass to this step via it's context
	 */
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
