package de.alombra.dine.steps.execution.instruction.impl;

import de.alombra.dine.http.HttpResult;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.StepContext;
import de.alombra.dine.steps.execution.content.ContentFormatterFactory;
import de.alombra.dine.steps.execution.instruction.InstructionRunner;
import de.alombra.dine.util.ReportingUtil;

public class StepRunner extends AbstractInstructionRunner<StepInstruction> {

	private StepInstruction instruction;

	private HttpResult executeHttpRequest( Step step, StepContext ctx ) throws Exception {
	  
    if ( Step.HTTP_METHOD_GET.equalsIgnoreCase( step.getMethod() ) )
      return getStepExecutor().getHttpManager().executeGet( step.getUrl( ctx ) );

    if ( Step.HTTP_METHOD_POST.equalsIgnoreCase( step.getMethod() ) )
      return getStepExecutor().getHttpManager().executePost( step.getUrl( ctx ), step.getPostParams() );
	  
	  throw new RuntimeException( "Unknown HTTP method: "+step.getMethod() );
	}
	
	private String extractResponse( HttpResult result ) {
	  
    String contentType = result.getHttpMethod().getResponseHeader("Content-Type").getValue();
    
    return ContentFormatterFactory.getFormatter( contentType )
                                  .format( result.getHttpMethod() );	  	  
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
			
			//System.out.println( step.getMethod() );
			
			//this.step.setHttpResponse( method.getStatusCode() );
			
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