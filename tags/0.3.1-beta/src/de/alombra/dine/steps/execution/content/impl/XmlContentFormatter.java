package de.alombra.dine.steps.execution.content.impl;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.steps.execution.content.Content;
import de.alombra.dine.util.IOUtil;

/**
 * used for content type text/xml, returns the XML String and cuts off
 * the XML declaration because of an E4X bug
 * 
 * @author ssc
 */
public class XmlContentFormatter extends AbstractContentFormatter {

  @Override
  public Content doFormat( HttpMethod method, String contentType ) throws Exception {

    String xml = IOUtil.getContentLengthUnkown( method.getResponseBodyAsStream() );
    
    // we need to cut out the <?xml ... ?> declaration because
    // of a bug in E4X, for details see: https://bugzilla.mozilla.org/show_bug.cgi?id=336551
    String xmlContent = xml.substring( xml.indexOf("?>")+2, xml.length() ).trim();
    
    return new Content( 
                  xmlContent,
                  ContentTypeHelper.getEncodingFromXML( xml )
                );    
  }

  public boolean isApplicable( String contentType ) {
    return contentType.contains("xml"); 
  }


}
