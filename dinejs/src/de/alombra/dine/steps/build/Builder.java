package de.alombra.dine.steps.build;

import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import de.alombra.dine.steps.Step;
import de.alombra.dine.util.IOUtil;

public class Builder {

	private Step step;

	private static final String DINE_JS_CODE = IOUtil.getContent( Builder.class.getClassLoader().getResourceAsStream( "de/alombra/dine/steps/build/base.js" ) );	
	
	private static final Log logger = LogFactory.getLog( Builder.class );
	
	public Builder createStep( Reader reader, String name ) {
	
		logger.info( "generating step ["+name+"]" );
		
		try {
			Context ctx = Context.enter();
		
			Scriptable scope = ctx.initStandardObjects();
			
			ScriptableObject.putProperty( scope, "creator", this );
			ScriptableObject.putProperty( scope, "out", System.out );
	
			ctx.evaluateString( scope, DINE_JS_CODE, "base", 1,	null ); 		
			ctx.evaluateReader( scope, reader, name, 1, null ); 		
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			Context.exit();
		}
		
		return this;
	}
	
	
	public Step getStep() {
		return step;
	}

	public void setStep(Step step) {
		this.step = step;
	}
	
	
}
