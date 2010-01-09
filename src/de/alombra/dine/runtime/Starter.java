package de.alombra.dine.runtime;

import de.alombra.dine.http.HttpManager;
import de.alombra.dine.http.impl.HttpManagerImpl;
import de.alombra.dine.steps.StepHolder;
import de.alombra.dine.steps.execution.ExecutionQueue;
import de.alombra.dine.steps.execution.StepExecutor;
import de.alombra.dine.steps.execution.impl.BlockingExecutionQueue;
import de.alombra.dine.steps.execution.impl.MultithreadedStepExecutor;
import de.alombra.dine.steps.execution.instruction.Instruction;


public class Starter {

  public static void setupAndStart( RuntimeConfig runtimeConfig ) {
        
    StepHolder stepHolder   = new StepHolder();
    
    HttpManager httpManager = new HttpManagerImpl(
                                      runtimeConfig.getMaxConcurrentThreads(),
                                      runtimeConfig.isAllowCircularRedirects()
                                   );  
        
    ExecutionQueue queue    = new BlockingExecutionQueue();
    
    stepHolder.instantiate( runtimeConfig.getResolverCallback() );

    StepExecutor executor = new MultithreadedStepExecutor( 
                                    runtimeConfig,  
                                    queue, 
                                    stepHolder, 
                                    httpManager 
                             ); 
  
    for ( Instruction instruction : runtimeConfig.getSeedInstructionCallback().getSeedInstructions() ) {
      executor.addInstruction( instruction );
    }
  
    
    executor.start();         
    
  }
}
