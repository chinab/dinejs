package de.alombra.dine.steps.execution;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.http.HttpUtil;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.execution.content.ContentFormatterFactory;
import de.alombra.dine.util.ReportingUtil;

public class StepRunner implements Runnable {

	private Step step;
	private StepExecutor stepExecutor;	
	
	public StepRunner(Step step, StepExecutor stepExecutor) {
		super();
		this.step = step;
		this.stepExecutor = stepExecutor;
	}


	public void run() {

		HttpMethod method = null;
		
		try {

			method = HttpUtil.executeGet( this.step.getUrl() );
	
			this.step.setHttpResponse( method.getStatusCode() );
			
			String contentType = method.getResponseHeader("Content-Type").getValue();
			
			ContentFormatterFactory.getFormatter( contentType )
								   .format( this.step, method );
			
			this.step.run();			
		}
		catch ( Exception e ) {
			ReportingUtil.reportException( e );
		}
		finally {			
			
			if ( null != method )
				method.releaseConnection();
			
			this.stepExecutor.notifyOfTermination();
		}
	}

}
