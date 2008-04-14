package de.alombra.dine.steps.execution.instruction.impl;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.alombra.dine.steps.execution.instruction.InstructionRunner;
import de.alombra.dine.util.IOUtil;
import de.alombra.dine.util.ReportingUtil;

/**
 * used to execute the download defined in the given download instruction
 * 
 * @author ssc
 */
public class DownloadRunner extends AbstractInstructionRunner<DownloadInstruction> {

  /**
   * the given DownloadInstruction
   */
	private DownloadInstruction downloadInstruction;
	
	private static final Log logger = LogFactory.getLog( DownloadRunner.class );
	

	public void run() {
	
		HttpMethod method = null;
		
		try {
			
			logger.info( "downloading "+downloadInstruction.getUrl()+" to "+downloadInstruction.getFileName() );
			
			// execute the HTTP request
			method = getStepExecutor().getHttpManager().executeGet( downloadInstruction.getUrl() ).getHttpMethod();
			
			// save the content to the file
			IOUtil.writeToFile( method.getResponseBodyAsStream(), downloadInstruction.getFileName() );
		} 
		catch ( Exception e ) {
			ReportingUtil.reportException( e );
		}
		finally {			
			
			if ( null != method ) {
			  // definitely release the HTTP connection
			  // necessary for correct pooling
				method.releaseConnection();
			}
			
			// definitely notify the executor, so it 
			// can execute the next step
			getStepExecutor().notifyOfTermination();
		}

	}

	/**
	 * @see InstructionRunner#setInstruction(de.alombra.dine.steps.execution.instruction.Instruction)
	 */
	public InstructionRunner<DownloadInstruction> setInstruction( DownloadInstruction downloadInstruction) {
		this.downloadInstruction = downloadInstruction;
		return this;
	}

}
