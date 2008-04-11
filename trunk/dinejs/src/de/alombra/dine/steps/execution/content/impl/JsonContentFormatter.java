package de.alombra.dine.steps.execution.content.impl;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.steps.execution.content.Content;
import de.alombra.dine.steps.execution.content.Encoding;
import de.alombra.dine.util.IOUtil;

public class JsonContentFormatter extends AbstractContentFormatter {

  @Override
  public Content doFormat( HttpMethod method, String contentType ) throws Exception {
     
    Encoding e =                   ContentTypeHelper.getEncodingFromHttpHeader( contentType );
    
    return new Content(
                  IOUtil.getContentLengthUnkown( method.getResponseBodyAsStream() ),
                  e
                 );
    
  }

}
