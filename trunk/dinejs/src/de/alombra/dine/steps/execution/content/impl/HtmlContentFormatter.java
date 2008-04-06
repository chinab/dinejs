package de.alombra.dine.steps.execution.content.impl;

import org.apache.commons.httpclient.HttpMethod;
import org.htmlcleaner.HtmlCleaner;

import de.alombra.dine.steps.execution.content.ContentFormatter;

public class HtmlContentFormatter implements ContentFormatter {

	public String format( HttpMethod method ) {

		try {
			
			HtmlCleaner cleaner = new HtmlCleaner( method.getResponseBodyAsStream() );
			
			cleaner.setNamespacesAware( false );
			cleaner.setOmitXmlDeclaration( true );

			cleaner.clean();			

			return cleaner.getXmlAsString();
			
		} 
		catch (Exception e) {
			throw new RuntimeException("unable to clean html ", e );
		}

	}

}
