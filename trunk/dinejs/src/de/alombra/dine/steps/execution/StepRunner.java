package de.alombra.dine.steps.execution;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.exception.DineException;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.execution.content.ContentFormatterFactory;
import de.alombra.dine.steps.execution.http.HttpUtil;

public class StepRunner implements Runnable {

	private Step step;
	private StepExecutor stepExecutor;	
	
	public StepRunner(Step step, StepExecutor stepExecutor) {
		super();
		this.step = step;
		this.stepExecutor = stepExecutor;
	}


	public void run() {

		try {

			HttpMethod method = HttpUtil.executeGet( this.step.getUrl() );
	
			this.step.setHttpResponse( method.getStatusCode() );
			
			String contentType = method.getResponseHeader("Content-Type").getValue();
			
			ContentFormatterFactory.getFormatter( contentType )
								   .format( this.step, method );
			
			this.step.run();
		}
		catch ( Exception e ) {
			System.err.println( e );
			//throw new DineException("Unable to run step", e );
		}
		finally {
			this.stepExecutor.notifyOfTermination();
		}
	}

}
