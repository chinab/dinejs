package de.alombra.dine.steps.execution.instruction.impl;


public class DownloadInstruction extends AbstractInstruction {

	private String url;
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
