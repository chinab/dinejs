package de.alombra.dine.steps.execution.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.alombra.dine.exception.DineException;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.StepMemory;
import de.alombra.dine.steps.build.StepFactory;
import de.alombra.dine.steps.execution.ExecutionContext;

public class BlockingExecutionContext implements ExecutionContext {
	
	private BlockingQueue<Step> stepsQueue = new LinkedBlockingQueue<Step>();
	private StepFactory factory;
	
	private static final Log logger = LogFactory.getLog( BlockingExecutionContext.class );
	
	private static ExecutionContext instance;

	private BlockingExecutionContext(StepFactory factory) {
		super();
		this.factory = factory;
	}

	public static ExecutionContext newInstance( StepFactory factory ) {
		
		if ( null == instance )
			instance = new BlockingExecutionContext( factory );
		
		return instance;
	}
	
	public static ExecutionContext newInstance() {
		if ( null == instance ) {
			throw new DineException( "Execution context has to be initialized with a StepFactory" );
		}
		return instance;
	}
	
	public ExecutionContext addStep( String name ) {
		return addStep( this.factory.getStep( name ) );
	}
	
	public ExecutionContext addStep( String name, StepMemory memory ) {
		
		Step step =  this.factory.getStep( name );

		for ( String key : memory.keyNames() ) {
			step.addMemoryAttribute( key, memory.getAttribute( key ) );
		}
		
		return addStep( step );
	}	
	
	public ExecutionContext addStep( Step step ) {						
			
		stepsQueue.offer( step );
		
		if ( logger.isDebugEnabled() )
			logger.debug("added "+step.getClass().getSimpleName()+" ("+stepsQueue.size()+" currently queued)" );
		
		return this;
	}
	
	public Step getNextStep() {
		
		List<Step> nextSteps = new LinkedList<Step>();
		
		stepsQueue.drainTo( nextSteps, 1 );
		
		if ( nextSteps.size() > 0 ) {
			
			if ( logger.isDebugEnabled() )
				logger.debug("removed "+nextSteps.get(0).getClass().getSimpleName()+" ("+stepsQueue.size()+" currently queued)" );
			
			return nextSteps.get(0);
		}
		
		return null;
	}
}
