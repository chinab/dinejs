package de.alombra.dine.steps.execution.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.alombra.dine.exception.DineException;
import de.alombra.dine.steps.Executable;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.StepMemory;
import de.alombra.dine.steps.StepParameters;
import de.alombra.dine.steps.build.StepFactory;
import de.alombra.dine.steps.execution.ExecutionContext;
import de.alombra.dine.steps.impl.SynchronizedStepMemory;

public class BlockingExecutionContext implements ExecutionContext {
	
	private BlockingQueue<Step> stepsQueue = new LinkedBlockingQueue<Step>();
	private StepFactory factory;
	
	private StepMemory memory = new SynchronizedStepMemory();
	
	private String resultProcessorName;
	
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

	public ExecutionContext setResultProcessor( String name ) {
		this.resultProcessorName = name;
		return this;
	}

	public boolean hasResultProcessor() {
		return ( null != this.resultProcessorName );
	}
	
	public Executable getResultProcessor() {
		Executable resultProcessor = this.factory.getExecutable( this.resultProcessorName );
		
		resultProcessor.setMemory( this.memory );
		
		return resultProcessor;
	}	
	
	
	public ExecutionContext addStep( String name ) {
		try {
			return addStep( this.factory.getStep( name ) );
		}
		catch ( DineException de ) {
			logger.warn("Unable to add step ["+name+"]", de );
			return this;
		}
	}
	
	public ExecutionContext addStep( String name, StepParameters parameters ) {
		
		Step step =  this.factory.getStep( name );

		for ( String key : parameters.keyNames() ) {
			step.addParameter( key, parameters.getAttribute( key ) );
		}
		
		return addStep( step );
	}	
	
	public ExecutionContext addStep( Step step ) {						
			
		step.setMemory( memory );
		
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
