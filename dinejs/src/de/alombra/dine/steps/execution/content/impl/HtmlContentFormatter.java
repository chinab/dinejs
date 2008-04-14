package de.alombra.dine.steps.execution.content.impl;

import org.apache.commons.httpclient.HttpMethod;
import org.htmlcleaner.HtmlCleaner;

import de.alombra.dine.steps.execution.content.Content;

/**
 * used for content type text/html, this creates an XML String from
 * the HTML source 
 * 
 * @author ssc
 */
public class HtmlContentFormatter extends AbstractContentFormatter {

  @Override
  public Content doFormat( HttpMethod method, String contentType ) throws Exception {
    
    HtmlCleaner cleaner = new HtmlCleaner( method.getResponseBodyAsStream() );
    
    cleaner.setNamespacesAware( false );
    cleaner.setOmitXmlDeclaration( true );
    cleaner.setTranslateSpecialEntities( true );
    
    cleaner.clean();      
    
    return new Content(
                  cleaner.getXmlAsString(),
                  ContentTypeHelper.getEncodingFromHttpHeader( contentType )
                 );
  }

  public boolean isApplicable( String contentType ) {
    return contentType.contains("html");
  }

}
