package de.alombra.dine.steps.execution.instruction.impl;

import org.apache.commons.httpclient.HttpState;

import de.alombra.dine.steps.execution.instruction.Instruction;

/**
 * Abstract base class for all instructions
 * 
 * Implementation of {@link Instruction}
 * 
 * @author ssc
 */
public abstract class AbstractInstruction implements Instruction {

  /**
   * the HTTP state of the step that created 
   * this instruction
   */
  private HttpState stateBefore;
  
  /**
   * @see Instruction#getStateBefore()
   */
  public HttpState getStateBefore() {
    return this.stateBefore;
  }

  /**
   * @see Instruction#setStateBefore(HttpState)
   */
  public void setStateBefore( HttpState state ) {
    this.stateBefore = state;
  }

}
