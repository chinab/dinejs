package de.alombra.dine.steps.execution.content.impl;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.steps.execution.content.Content;
import de.alombra.dine.steps.execution.content.ContentFormatter;


public abstract class AbstractContentFormatter implements ContentFormatter {

  public final String format( HttpMethod method, String contentType ) {

    try {
      
      Content content = doFormat( method, contentType );
      
      return new String( 
                    content.getText().getBytes(), 
                    content.getEncoding().getIdentifier() 
                  );
    }
    catch ( Exception e ) {
      throw new RuntimeException( "Unable to format content!", e );
    }
  }

  public abstract Content doFormat( HttpMethod method, String contentType ) throws Exception;
}
