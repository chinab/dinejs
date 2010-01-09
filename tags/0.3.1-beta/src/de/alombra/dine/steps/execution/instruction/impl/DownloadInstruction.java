package de.alombra.dine.steps.execution.instruction.impl;

/**
 * This instruction will make dine download a file 
 * 
 * @author ssc
 */
public class DownloadInstruction extends AbstractInstruction {

  /**
   * the complete URI of the content to download
   */
	private String url;
	
	/**
	 * the name of the file to which the content will be saved
	 */
	private String fileName;
	
	public DownloadInstruction( String url, String fileName ) {
		super();
		this.url = url;
		this.fileName = fileName;
	}
	
	public String getUrl() {
		return url;
	}
	public String getFileName() {
		return fileName;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
