package de.alombra.dine.steps;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class StepMemory {

  private Map<String, String> memories = new ConcurrentHashMap<String, String>();
 
  public boolean hasKey( String key ) {
    return memories.containsKey( key );
  }
  
  public void put( String key, String value ) {
    memories.put( key, value );
  }
}
