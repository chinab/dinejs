package de.alombra.dine.clients.cli.callback;

import java.util.Arrays;
import java.util.List;

import de.alombra.dine.runtime.callback.SeedInstructionCallback;
import de.alombra.dine.steps.execution.instruction.Instruction;
import de.alombra.dine.steps.execution.instruction.impl.StepInstruction;


public class ArgSeedInstructionCallback implements SeedInstructionCallback {

  private String seedStepName;

  public ArgSeedInstructionCallback( String seedStepName ) {
    super();
    this.seedStepName = seedStepName;
  }

  public List<Instruction> getSeedInstructions() {

    StepInstruction seedInstruction = new StepInstruction();
    seedInstruction.setStepName( this.seedStepName );
    
    return Arrays.asList( new Instruction[] { seedInstruction } );
  }
  
  
}
