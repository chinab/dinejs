package de.alombra.dine.steps.execution.instruction;

import org.apache.commons.httpclient.HttpState;

/**
 * base interface for all instruction modelling
 * anything that dine can execute
 * 
 * @author ssc
 */
public interface Instruction {

  /**
   * the HTTP state before ( cookies, etc ) 
   * 
   * @param state
   */
  public void setStateBefore( HttpState state );
  public HttpState getStateBefore();
}
