package de.alombra.dine.steps.execution.instruction.impl;

import de.alombra.dine.steps.execution.StepExecutor;
import de.alombra.dine.steps.execution.instruction.Instruction;
import de.alombra.dine.steps.execution.instruction.InstructionRunner;

/**
 * Abstract base class for all instruction runners
 * 
 * @author ssc
 *
 * @param <T>
 */
public abstract class AbstractInstructionRunner<T extends Instruction> implements InstructionRunner<T> {

  /**
   * the injected Stepexecutor
   */
	private StepExecutor stepExecutor;
	
	/**
	 * @see InstructionRunner#getStepExecutor()
	 */
	public StepExecutor getStepExecutor() {
		return stepExecutor;
	}

	/**
	 * @see InstructionRunner#setStepExecutor(StepExecutor)
	 */
	public InstructionRunner<T> setStepExecutor( StepExecutor stepExecutor ) {
		this.stepExecutor = stepExecutor;
		return this;
	}

	/**
	 * @see InstructionRunner#addInstruction(Instruction)
	 */
	public void addInstruction( Instruction instruction ) {
		this.stepExecutor.addInstruction( instruction );
	}
}
