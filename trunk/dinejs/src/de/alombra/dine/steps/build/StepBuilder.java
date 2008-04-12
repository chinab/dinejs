package de.alombra.dine.steps.build;

import java.io.Reader;

import de.alombra.dine.steps.Step;


public interface StepBuilder {

  public abstract StepBuilder createStep( Reader reader, String name );

  public abstract Step getStep();

  public abstract void setStep( Step step );

}