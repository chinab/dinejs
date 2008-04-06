package de.alombra.dine.steps.execution.instruction;

import de.alombra.dine.steps.execution.StepExecutor;

public interface InstructionRunner<T extends Instruction> extends Runnable {
	
	public StepExecutor getStepExecutor();
	
	public InstructionRunner<T> setStepExecutor( StepExecutor stepExecutor );
	public InstructionRunner<T> setInstruction( T instruction );
	
	public void addInstruction( Instruction instruction );
}
