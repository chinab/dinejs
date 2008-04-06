package de.alombra.dine.steps.resolve;

import java.io.Reader;
import java.util.Map;


public interface Resolver {

  public Map<String, Reader> resolveStepCode();
  
}
