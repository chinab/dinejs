package de.alombra.dine.steps.execution.content;

import de.alombra.dine.steps.execution.content.impl.HtmlContentFormatter;
import de.alombra.dine.steps.execution.content.impl.JsonContentFormatter;
import de.alombra.dine.steps.execution.content.impl.XmlContentFormatter;

/**
 * This class holds a static array of all available ContentFormatters
 * and will return the appropriate one for the given content type
 * 
 * @author ssc
 */
public class ContentFormatterFactory {
	
	private static ContentFormatter[] availableFormatters = new ContentFormatter[] {
	                                                                new HtmlContentFormatter(),
	                                                                new XmlContentFormatter(),
	                                                                new JsonContentFormatter()
	                                                            };
	
	public static ContentFormatter getFormatter( String contentType ) {
	  
	  for ( ContentFormatter contentFormatter : availableFormatters ) {
	    
	    if ( contentFormatter.isApplicable( contentType ) ) {
	      return contentFormatter;
	    }
	    
	  }
	  
		throw new RuntimeException( "Unable to handle content "+contentType );
	}
}
