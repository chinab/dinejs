package de.alombra.dine.steps.build;

import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.EvaluatorException;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import de.alombra.dine.exception.DineException;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.execution.impl.BlockingExecutionContext;
import de.alombra.dine.util.IOUtil;

public class StepBuilder {

	private static final String DINE_JS_CODE = IOUtil.getContent( StepBuilder.class.getClassLoader().getResourceAsStream( "de/alombra/dine/steps/build/base.js" ) );
	
	private Step step;
	
	private static final Log logger = LogFactory.getLog( StepBuilder.class );

	public StepBuilder create( Reader reader, String name ) {

		long start = 0;
		
		if ( logger.isDebugEnabled() ) {
			start = System.currentTimeMillis();
		}
		
		try {
			Context ctx = Context.enter();
			
			Scriptable scope = ctx.initStandardObjects();
										
			ScriptableObject.putProperty( scope, "creator", this );
			ScriptableObject.putProperty( scope, "out", System.out );
			ScriptableObject.putProperty( scope, "executionContext", BlockingExecutionContext.newInstance() );

			ctx.evaluateString( scope, DINE_JS_CODE, "base", 1,	null ); 
			
			ctx.evaluateReader( scope, reader, name, 1, null ); 
		}
		catch( Exception e ) {
			
			if ( e instanceof EvaluatorException ) {
				
				EvaluatorException evaluatorException = (EvaluatorException)e;
				
				System.out.println("--- JavaScript Error -------------------------------------------------------------");
				System.out.println("");
				System.out.println("File:  "+evaluatorException.sourceName() );
				System.out.println("Line:  "+evaluatorException.lineNumber() );
				System.out.println("");
				System.out.println( evaluatorException.details() );
				System.out.println("");
				System.out.println("----------------------------------------------------------------------------------");

			}
			
			throw new DineException( e );
		}
		finally {
			Context.exit();
		}
		
		if ( logger.isDebugEnabled() ) {
			logger.debug( "created step in "+( System.currentTimeMillis()-start )+"ms" );
		}
		
		return this;
	}
	
	public void setStep( Step step ) {
		this.step = step;
	}
	
	public Step getStep() {
		return this.step;
	}
}
