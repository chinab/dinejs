package de.alombra.dine.runtime.callback;

import java.util.List;

import de.alombra.dine.steps.execution.instruction.Instruction;


public interface SeedInstructionCallback {

  public List<Instruction> getSeedInstructions();
}
