package de.alombra.dine.steps;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import de.alombra.dine.steps.build.RhinoBuilder;
import de.alombra.dine.steps.resolve.Resolver;

/**
 * This class triggers the instantiation of the steps using a StepBuilder 
 * and will then hold a singleton instance of each step  
 * 
 * @author ssc
 */
public class StepHolder {

	private Map<String, Step> stepInstances = new HashMap<String, Step>();
		
	public void instantiate( Resolver resolver ) {
	  
	  Map<String, Reader> resolvedSteps = resolver.resolveStepCode(); 
	  
	  for ( String name : resolvedSteps.keySet() )
	    instantiate( resolvedSteps.get( name ), name );
	}
	
	public Step get( String name ) {
	  
	  if ( !stepInstances.containsKey( name ) )
	    throw new RuntimeException( "Unknown step "+name+" requested!" );
	  
		return stepInstances.get( name );
	}
	
  private void instantiate( Reader reader, String name ) {
    
    Step stepInstance = new RhinoBuilder().createStep( reader, name ).getStep();
    
    stepInstances.put( name, stepInstance );    
  }	
}
