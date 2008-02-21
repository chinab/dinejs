package de.alombra.dine.run;

import java.util.Arrays;
import java.util.List;

import de.alombra.dine.steps.build.impl.CachingFileStepFactory;
import de.alombra.dine.steps.execution.ExecutionContext;
import de.alombra.dine.steps.execution.StepExecutor;
import de.alombra.dine.steps.execution.impl.BlockingExecutionContext;
import de.alombra.dine.steps.execution.impl.MultiThreadedStepExecutor;


public class Runner {

	public static void main(String[] args) {
		
		if ( args.length < 4 ) {
			System.err.println("Usage: java -jar dine-all.jar -d <stepDir> -s <seedStep>");
			System.exit(-1);
		}
		
		String jsDir = null;
		String seed  = null;
		
		for ( int n=0; n<args.length ; n++ ) {
			
			if ( args[n].equals("-d" ) )
				jsDir = args[n+1];
			
			if ( args[n].equals("-s") )
				seed = args[n+1];
		}
		
		//String jsDir 				= "/Users/alombra/Entwicklung/projekte/dine/resources/samples";
		int maxConcurrentThreads 	= 20;
		//List<String> seedStepNames 	= Arrays.asList( new String[] { "checkExternalLinks" } );
		List<String> seedStepNames 	= Arrays.asList( new String[] { seed } );
		
		ExecutionContext ctx = BlockingExecutionContext.newInstance( new CachingFileStepFactory( jsDir ) );

		for ( String seedStepName : seedStepNames ) 
			ctx.addStep( seedStepName );
		
		StepExecutor executor = new MultiThreadedStepExecutor( maxConcurrentThreads, ctx );
		
		executor.start();
	}
}
