package de.alombra.dine.steps.execution.content;

import de.alombra.dine.steps.execution.content.impl.HtmlContentFormatter;
import de.alombra.dine.steps.execution.content.impl.JsonContentFormatter;
import de.alombra.dine.steps.execution.content.impl.XmlContentFormatter;

public class ContentFormatterFactory {

	private static final ContentFormatter htmlContentFormatter	= new HtmlContentFormatter();
	private static final ContentFormatter xmlContentFormatter 	= new XmlContentFormatter();
	private static final ContentFormatter jsonContentFormatter	= new JsonContentFormatter();
	
	public static ContentFormatter getFormatter( String contentType ) {
		
		if ( contentType.contains("html") )
			return htmlContentFormatter;

		if ( contentType.contains("xml") )
			return xmlContentFormatter;
		
		if ( contentType.contains("json") )
			return jsonContentFormatter;
		
		throw new RuntimeException("unable to handle content "+contentType );
	}
}
