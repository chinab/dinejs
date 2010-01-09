package de.alombra.dine.steps.execution.instruction;

import de.alombra.dine.steps.execution.StepExecutor;

/**
 * Base interfaces for all classes that can run/execute
 * instructions ( e.g. steps, downloads )
 * 
 * @author ssc
 *
 * @param <T>
 */
public interface InstructionRunner<T extends Instruction> extends Runnable {
	
  /**
   * the executor responsible for coordinating
   * the order of instructions being executed
   * 
   * @return
   */
	public StepExecutor getStepExecutor();
	
	/**
	 * inject the executor responsible for coordinating
	 * this runner and it's instruction
	 * 
	 * @param stepExecutor
	 * @return
	 */
	public InstructionRunner<T> setStepExecutor( StepExecutor stepExecutor );
	
	/**
	 * inject the instruction to run
	 * 
	 * @param instruction
	 * @return
	 */
	public InstructionRunner<T> setInstruction( T instruction );
	
	/**
	 * add a new instruction to the current queue if this runner's executor
	 * 
	 * @param instruction
	 */
	public void addInstruction( Instruction instruction );
}
