package de.alombra.dine.steps.resolve;

import java.io.Reader;
import java.util.Map;

/**
 * used to find the names of available steps and readers to their
 * code located in some persistent media
 * 
 * @author ssc
 */
public interface Resolver {

  /**
   * a map of named readers to the code of steps
   * 
   * @return
   */
  public Map<String, Reader> resolveStepCode();
  
}
