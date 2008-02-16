package de.alombra.dine.steps.execution;

import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.StepMemory;

public interface ExecutionContext {

	public ExecutionContext addStep(String name);

	public ExecutionContext addStep(String name, StepMemory memory);

	public ExecutionContext addStep(Step step);

	public Step getNextStep();

}