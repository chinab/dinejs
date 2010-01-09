package de.alombra.dine.steps;

import java.util.Map;


public interface Step {

  public static final String HTTP_METHOD_GET  = "GET";
  public static final String HTTP_METHOD_POST = "POST";
  
	public String getUrl( StepContext stepContext );
	public String getMethod();
	public Map<String, String> getPostParams();
	
	public void run( StepContext stepContext );
}
