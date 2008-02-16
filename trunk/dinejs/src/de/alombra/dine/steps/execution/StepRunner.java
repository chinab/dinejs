package de.alombra.dine.steps.execution;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.exception.DineException;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.execution.http.HttpUtil;
import de.alombra.dine.steps.execution.xml.XmlUtil;

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
//			System.out.println( method.getResponseHeader("Content-Type").getValue() );
			this.step.setXmlStr( XmlUtil.htmlToXml( method.getResponseBodyAsStream() ) );			
			this.step.run();
		}
		catch ( Exception e ) {
			throw new DineException("Unable to run step", e );
		}
		finally {
			this.stepExecutor.notifyOfTermination();
		}
	}

}
