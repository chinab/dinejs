package de.alombra.dine.steps.execution.content.impl;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.steps.execution.content.Content;
import de.alombra.dine.util.IOUtil;

/**
 * used for content type text/json and text/javascript, returns the json string 
 * 
 * @author ssc
 */
public class JsonContentFormatter extends AbstractContentFormatter {

  @Override
  public Content doFormat( HttpMethod method, String contentType ) throws Exception {

    return new Content(
                  IOUtil.getContentLengthUnkown( method.getResponseBodyAsStream() ),
                  ContentTypeHelper.getEncodingFromHttpHeader( contentType )
                 );
    
  }

  public boolean isApplicable( String contentType ) {
    return ( contentType.contains("json") || contentType.contains("javascript") ); 
  }

}
