package de.alombra.dine.steps.execution.instruction.impl;

import org.apache.commons.httpclient.HttpState;

import de.alombra.dine.steps.execution.instruction.Instruction;


public abstract class AbstractInstruction implements Instruction {

  private HttpState stateBefore;
  
  public HttpState getStateBefore() {
    return this.stateBefore;
  }

  public void setStateBefore( HttpState state ) {
    this.stateBefore = state;
  }

}
