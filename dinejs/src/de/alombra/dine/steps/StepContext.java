package de.alombra.dine.steps;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpState;

import de.alombra.dine.steps.execution.instruction.Instruction;
import de.alombra.dine.steps.execution.instruction.InstructionRunner;
import de.alombra.dine.steps.execution.instruction.impl.DownloadInstruction;
import de.alombra.dine.steps.execution.instruction.impl.StepInstruction;

public class StepContext {

	private Map<String, String> parameters = new HashMap<String, String>();

	private String response;
	private String responseContentType;
	private int responseCode;
	
	private HttpState httpState;
	
	@SuppressWarnings("unchecked")
	private InstructionRunner runner;
	
	@SuppressWarnings("unchecked")
	public StepContext( InstructionRunner runner ) {
	  this.runner = runner;
	}
	
	public StepContext setParameters( Map<String, String> parameters ) {
		this.parameters = parameters;
		return this;
	}

  public String encode( String param ) {
    try {
      return URLEncoder.encode( param, "UTF-8" );
    }
    catch ( UnsupportedEncodingException e ) {
      throw new RuntimeException( "Unable to encode: "+param, e );
    }
  }	
	
	public void addStep( String stepName ) {
	  
	  StepInstruction instruction = new StepInstruction();
	  
	  instruction.setStepName( stepName );	  
	  
	  doAddInstruction( instruction );
	}
	
	public void addDownload( String url, String fileName ) {
	  
		DownloadInstruction instruction = new DownloadInstruction( url, fileName );
		
		doAddInstruction( instruction );
	}
	
	public void writeToFile( String content, String fileName ) {
	  runner.getStepExecutor().getDownloadCallback().writeFile( content, fileName );
	}
	
	@SuppressWarnings("unchecked")
  public void addStep( String stepName, Map params ) {
	  
	    StepInstruction instruction = new StepInstruction();
	  
	    instruction.setStepName( stepName );	    
	    instruction.setParameters( params );
	    
	    doAddInstruction( instruction );
	}
	
	private void doAddInstruction( Instruction instruction ) {
	  
	  instruction.setStateBefore( httpState );
	  
	  runner.addInstruction( instruction );
	}
	
	public String getResponse() {
		return response;
	}

	public String getResponseContentType() {
		return responseContentType;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public void setResponseContentType(String responseContentType) {
		this.responseContentType = responseContentType;
	}

	public String getParam( String name ) {
		return parameters.get( name );
	}

  public boolean hasParam( String name ) {
    return parameters.containsKey( name );
  }	
	
	public StepMemory getMemory() {
	  return this.runner.getStepExecutor().getStepMemory();
	}

  
  public HttpState getHttpState() {
    return httpState;
  }

  
  public void setHttpState( HttpState httpState ) {
    this.httpState = httpState;
  }

  
  public int getResponseCode() {
    return responseCode;
  }

  
  public void setResponseCode( int responseCode ) {
    this.responseCode = responseCode;
  }
  
  
}
