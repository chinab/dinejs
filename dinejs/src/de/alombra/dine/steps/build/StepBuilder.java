package de.alombra.dine.steps.build;

import java.io.Reader;

import de.alombra.dine.steps.Step;

/**
 * create a step instance from a reader to it's JavaScript source
 * 
 * @author ssc
 */
public interface StepBuilder {

  public StepBuilder createStep( Reader reader, String name );

  public Step getStep();

  public void setStep( Step step );

}