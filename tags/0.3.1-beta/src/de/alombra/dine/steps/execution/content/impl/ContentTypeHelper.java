package de.alombra.dine.steps.execution.content.impl;

import de.alombra.dine.steps.execution.content.Encoding;


public class ContentTypeHelper {

  public static Encoding getEncodingFromXML( String xml ) {
    
    // regex would be better here...
    String encoding = xml.substring( xml.indexOf("encoding=\"")+10, xml.indexOf("?>") );
    encoding = encoding.substring( 0, encoding.indexOf( '"' ) );
    
    return Encoding.getByIdentifier( encoding );
  }
 
  public static Encoding getEncodingFromHttpHeader( String header ) {
    
    // regex would be better here...
    String encoding = header.substring( header.indexOf( "charset=" )+8, header.length() );
    
    if ( encoding.indexOf( ";" ) != -1 ) {
      encoding = encoding.substring( 0, encoding.indexOf( ";" ) );
    }
    
    return Encoding.getByIdentifier( encoding );
  }
}
