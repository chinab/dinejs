package de.alombra.dine.steps.execution.instruction.impl;

import de.alombra.dine.steps.execution.StepExecutor;
import de.alombra.dine.steps.execution.instruction.Instruction;
import de.alombra.dine.steps.execution.instruction.InstructionRunner;

public abstract class AbstractInstructionRunner<T extends Instruction> implements InstructionRunner<T> {

	private StepExecutor stepExecutor;
	
	public StepExecutor getStepExecutor() {
		return stepExecutor;
	}

	public InstructionRunner<T> setStepExecutor( StepExecutor stepExecutor ) {
		this.stepExecutor = stepExecutor;
		return this;
	}

	public void addInstruction( Instruction instruction ) {
		this.stepExecutor.addInstruction( instruction );
	}
}
