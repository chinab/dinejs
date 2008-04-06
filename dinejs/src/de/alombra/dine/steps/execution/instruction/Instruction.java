package de.alombra.dine.steps.execution.instruction;

import org.apache.commons.httpclient.HttpState;

public interface Instruction {

  public void setStateBefore( HttpState state );
  public HttpState getStateBefore();
}
