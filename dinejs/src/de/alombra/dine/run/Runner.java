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

public class Runner {

	public static void main( String[] args ) throws Exception {
		
		Resolver resolver = new FilesystemResolver("/Users/alombra/Entwicklung/workspace/dinejs/samples/immowelt");
		
		StepHolder stepHolder   = new StepHolder();
		HttpManager httpManager = new HttpManagerImpl( 100 );
		ExecutionQueue queue    = new BlockingExecutionQueue();
		
		stepHolder.instantiate( resolver );

	  StepExecutor executor = new MultithreadedStepExecutor( 100,  queue, stepHolder, httpManager ); 
	
	  StepInstruction instruction = new StepInstruction();    
	  instruction.setStepName( "/detail" );

		executor.addInstruction( instruction );
		
		executor.start();		
	}
}
