package de.alombra.dine.clients.cli.callback;

import de.alombra.dine.runtime.callback.MemoryCallback;
import de.alombra.dine.steps.StepMemory;


public class EmptyMemoryCallback implements MemoryCallback {

  public void processResult( StepMemory stepMemory ) {
    // do nothing
  }

}
