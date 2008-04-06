package de.alombra.dine.steps.execution;

import de.alombra.dine.steps.execution.instruction.Instruction;

public interface ExecutionQueue {

	public ExecutionQueue addInstruction( Instruction instruction );
	public Instruction getNextInstruction();
}
