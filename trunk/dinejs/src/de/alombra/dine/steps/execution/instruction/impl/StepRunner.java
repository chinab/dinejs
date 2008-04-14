package de.alombra.dine.steps.execution.instruction.impl;

import de.alombra.dine.http.HttpResult;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.StepContext;
import de.alombra.dine.steps.execution.content.ContentFormatterFactory;
import de.alombra.dine.steps.execution.instruction.InstructionRunner;
import de.alombra.dine.util.ReportingUtil;

/**
 * This class coordinates the execution of steps.
 * 
 * It triggers the HTTP request and prepares the fetched information for the step.
 * 
 * @author ssc
 */
public class StepRunner extends AbstractInstructionRunner<StepInstruction> {

  /**
   * the instruction to run
   */
	private StepInstruction instruction;

	private HttpResult executeHttpRequest( Step step, StepContext ctx ) throws Exception {
	  
	  // trigger execution of a HTTP GET request
    if ( Step.HTTP_METHOD_GET.equalsIgnoreCase( step.getMethod() ) )
      return getStepExecutor().getHttpManager().executeGet( step.getUrl( ctx ) );

    // trigger execution of a HTTP POST request
    if ( Step.HTTP_METHOD_POST.equalsIgnoreCase( step.getMethod() ) )
      return getStepExecutor().getHttpManager().executePost( step.getUrl( ctx ), step.getPostParams() );
	  
	  throw new RuntimeException( "Unknown HTTP method: "+step.getMethod() );
	}
	
	private String extractResponse( HttpResult result ) {
	  
    String contentType = result.getHttpMethod().getResponseHeader("Content-Type").getValue();
    
    // get the formatted and encoded content 
    return ContentFormatterFactory.getFormatter( contentType )
                                  .format( result.getHttpMethod(), contentType );	  	  
	}
	
	public void run() {

		HttpResult httpResult = null;
		
		try {
		  
		  // retrieve the step responsible for parsing this request
			Step step = getStepExecutor().getStepHolder().get( instruction.getStepName() );
			
			// create a new context for this request and fill it with the required information 
			StepContext stepContext = new StepContext( this );
						
			stepContext.setParameters( instruction.getParameters() );
			
			// execute the real HTTP request either per GET or per POST
			httpResult = executeHttpRequest( step, stepContext );
			
			// the http response code
			stepContext.setResponseCode( httpResult.getHttpMethod().getStatusCode() );
			
			// format the result 
			stepContext.setResponse( extractResponse( httpResult ) );
			
			// save this requests state ( cookies etc )
			stepContext.setHttpState( httpResult.getHttpState() );
			
			// have the step parse the result
			step.run( stepContext );
		}
		catch ( Exception e ) {
			ReportingUtil.reportException( e );
		}
		finally {			
			
		  // definitely release the HTTP connection,
		  // this is crucial for pooling!
			if ( null != httpResult.getHttpMethod() )
			  httpResult.getHttpMethod().releaseConnection();
			
			// definitely notify the step executor of termination,
			// so that it can fetch new instructions
			getStepExecutor().notifyOfTermination();
		}
	}

	public InstructionRunner<StepInstruction> setInstruction( StepInstruction stepInstruction ) {
		this.instruction = stepInstruction;
		return this;		
	}
}
