package de.alombra.dine.steps.execution.content;

import org.apache.commons.httpclient.HttpMethod;

/**
 * used to extract certain Strings from the HTTP response
 * and encode them with the right encoding
 * 
 * @author ssc
 */
public interface ContentFormatter {

  /**
   * returns a correctly encoded String built from the 
   * HTTP response
   * 
   * @param method
   * @param contentType
   * @return
   */
	public String format( HttpMethod method, String contentType );
	
	/**
	 * can this ContentFormatter handle the given content type
	 * 
	 * @param contentType
	 * @return
	 */
	public boolean isApplicable( String contentType );
}
