package de.alombra.dine.steps.execution;

import de.alombra.dine.steps.execution.instruction.Instruction;

/**
 * The queue of steps and downloads that still need to be done
 * by dine.
 * 
 * @author ssc
 */
public interface ExecutionQueue {

  /**
   * add an instruction to the queue 
   * 
   * @param instruction 
   * @return
   */
	public ExecutionQueue addInstruction( Instruction instruction );
	
	/**
	 * fetch the next instruction from the queue
	 * 
	 * @return null if there's currently no instruction in the queue
	 */
	public Instruction getNextInstruction();
}
