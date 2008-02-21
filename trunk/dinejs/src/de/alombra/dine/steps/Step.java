package de.alombra.dine.steps;

public interface Step {

	public void setXmlStr( String xmlStr );	
	public void setJsonStr( String jsonStr );
	public void addParameter( String key, String value );
	public void setHttpResponse( int code );
	
	public String getUrl();
	public void run();
	
	public void setMemory( StepMemory memory );
	
}
