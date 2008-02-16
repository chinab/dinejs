package de.alombra.dine.steps.execution.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.execution.ExecutionContext;
import de.alombra.dine.steps.execution.StepExecutor;
import de.alombra.dine.steps.execution.StepRunner;

public class MultiThreadedStepExecutor implements StepExecutor {

	private ExecutionContext executionContext;	
	private ExecutorService executorService;
	private volatile int threadCount = 0;
	
	private static Log logger = LogFactory.getLog( MultiThreadedStepExecutor.class );
	
	public MultiThreadedStepExecutor( int threadPoolSize, ExecutionContext executionContext) {
		super();
		this.executionContext = executionContext;
		this.executorService = Executors.newFixedThreadPool( threadPoolSize );
	}


	public void start() {
		
		while( true ) {
			
			Step nextStep = executionContext.getNextStep();
			
			if ( null != nextStep ) {
				threadCount++;
				this.executorService.execute( new StepRunner( nextStep, this ) );
			}
			
			if ( threadCount == 0 ) {
				
				if ( logger.isInfoEnabled() )
					logger.info("done");
				
				this.executorService.shutdownNow();
				break;
			}
			
			try {
				Thread.sleep( 10 );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void notifyOfTermination() {
		threadCount--;
	}
}
