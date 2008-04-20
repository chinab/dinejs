package de.alombra.dine.runtime.callback;

import java.io.Reader;
import java.util.Map;


public interface ResolverCallback {

  public Map<String, Reader> resolveStepCode();
}
