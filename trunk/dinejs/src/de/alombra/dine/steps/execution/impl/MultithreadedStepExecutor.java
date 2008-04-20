package de.alombra.dine.steps.execution.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.alombra.dine.http.HttpManager;
import de.alombra.dine.runtime.RuntimeConfig;
import de.alombra.dine.runtime.callback.DownloadCallback;
import de.alombra.dine.steps.StepHolder;
import de.alombra.dine.steps.StepMemory;
import de.alombra.dine.steps.execution.ExecutionQueue;
import de.alombra.dine.steps.execution.StepExecutor;
import de.alombra.dine.steps.execution.instruction.Instruction;
import de.alombra.dine.steps.execution.instruction.impl.DownloadInstruction;
import de.alombra.dine.steps.execution.instruction.impl.DownloadRunner;
import de.alombra.dine.steps.execution.instruction.impl.StepInstruction;
import de.alombra.dine.steps.execution.instruction.impl.StepRunner;

public class MultithreadedStepExecutor implements StepExecutor {

  private volatile int threadCount = 0;

  private ExecutionQueue executionQueue;
  private ExecutorService executorService;
  private StepHolder stepHolder;
  
  private HttpManager httpManager;
  private StepMemory stepMemory;
  
  private RuntimeConfig runtimeConfig;
  
  private static final Log logger = LogFactory.getLog( MultithreadedStepExecutor.class );
    
	public MultithreadedStepExecutor( RuntimeConfig runtimeConfig, ExecutionQueue executionQueue, StepHolder stepHolder, HttpManager httpManager ) {
    super();
    this.runtimeConfig = runtimeConfig;
    
    this.executionQueue   = executionQueue;
    this.executorService  = Executors.newFixedThreadPool( runtimeConfig.getMaxConcurrentThreads() );
    this.stepHolder       = stepHolder;
    
    this.httpManager      = httpManager;
    this.stepMemory       = new StepMemory();
  }

	
  public void notifyOfTermination() {
	  threadCount--;
	}

	public void start() {
		
	  while ( true ) {
	      
	    Instruction instruction = executionQueue.getNextInstruction();
	      
	    if ( null != instruction ) {
	    	
	      threadCount++;
	      
	      if ( instruction instanceof StepInstruction ) {

	    	  executorService.execute( 
	    	                    new StepRunner().setStepExecutor( this )
	    	                                    .setInstruction( (StepInstruction) instruction ) 
	    	                  );
	    	                                           
	      }
	      
	      if ( instruction instanceof DownloadInstruction ) {
	    	  
	        executorService.execute( 
	                          new DownloadRunner().setStepExecutor( this ) 
	                                              .setInstruction( (DownloadInstruction) instruction )
	                        );
	      }

	    }

	      
	    if ( threadCount == 0 ) { 
		       
		    logger.info("done");
		        
		    this.executorService.shutdown();
		    break;
	    }
	      
	      try {
	        Thread.sleep( runtimeConfig.getQueueCheckInterval() );
	      } 
	      catch ( InterruptedException e ) {
	        e.printStackTrace();
	      }
	  }	  
	}

  public void addInstruction( Instruction instruction ) {
    executionQueue.addInstruction( instruction );
  }
  
  public HttpManager getHttpManager() {
    return httpManager;
  }
  
  public StepHolder getStepHolder() {
    return stepHolder;
  }
  
  public StepMemory getStepMemory() {
    return stepMemory;
  }


  public DownloadCallback getDownloadCallback() {
    return runtimeConfig.getDownloadCallback();
  }
  
  
}
