package de.alombra.dine.steps.execution.instruction.impl;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.alombra.dine.steps.execution.instruction.InstructionRunner;
import de.alombra.dine.util.IOUtil;
import de.alombra.dine.util.ReportingUtil;

public class DownloadRunner extends AbstractInstructionRunner<DownloadInstruction> {

	private DownloadInstruction downloadInstruction;
	
	private static final Log logger = LogFactory.getLog( DownloadRunner.class );
	

	public void run() {
	
		HttpMethod method = null;
		
		try {
			
			logger.info( "downloading "+downloadInstruction.getUrl()+" to "+downloadInstruction.getFileName() );
			
			method = getStepExecutor().getHttpManager().executeGet( downloadInstruction.getUrl() ).getHttpMethod();
			
			IOUtil.writeToFile( method.getResponseBodyAsStream(), downloadInstruction.getFileName() );
		} 
		catch ( Exception e ) {
			ReportingUtil.reportException( e );
		}
		finally {			
			
			if ( null != method )
				method.releaseConnection();
			
			getStepExecutor().notifyOfTermination();
		}

	}

	public InstructionRunner<DownloadInstruction> setInstruction( DownloadInstruction downloadInstruction) {
		this.downloadInstruction = downloadInstruction;
		return this;
	}

}
