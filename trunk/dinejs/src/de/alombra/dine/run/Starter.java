package de.alombra.dine.run;

import de.alombra.dine.http.HttpManager;
import de.alombra.dine.http.impl.HttpManagerImpl;
import de.alombra.dine.steps.StepHolder;
import de.alombra.dine.steps.execution.ExecutionQueue;
import de.alombra.dine.steps.execution.StepExecutor;
import de.alombra.dine.steps.execution.impl.BlockingExecutionQueue;
import de.alombra.dine.steps.execution.impl.MultithreadedStepExecutor;
import de.alombra.dine.steps.execution.instruction.impl.StepInstruction;
import de.alombra.dine.steps.resolve.Resolver;
import de.alombra.dine.steps.resolve.impl.FilesystemResolver;


class Starter {

  static void setup() {
    
    RuntimeConfig config = RuntimeConfig.getInstance();
    
    Resolver resolver = new FilesystemResolver( config.getStepsBaseDir() );
    
    StepHolder stepHolder   = new StepHolder();
    HttpManager httpManager = new HttpManagerImpl( config.getMaxConcurrentThreads() );
    ExecutionQueue queue    = new BlockingExecutionQueue();
    
    stepHolder.instantiate( resolver );

    StepExecutor executor = new MultithreadedStepExecutor( 
                                    config.getMaxConcurrentThreads(),  
                                    queue, 
                                    stepHolder, 
                                    httpManager 
                             ); 
  
    StepInstruction instruction = new StepInstruction();    
    instruction.setStepName( config.getSeedStep() );

    executor.addInstruction( instruction );
    
    executor.start();       
    
  } 
}
