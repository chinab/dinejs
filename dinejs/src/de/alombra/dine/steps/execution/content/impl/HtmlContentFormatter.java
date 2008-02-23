package de.alombra.dine.steps.execution.content.impl;

import org.apache.commons.httpclient.HttpMethod;
import org.htmlcleaner.HtmlCleaner;

import de.alombra.dine.exception.DineException;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.execution.content.ContentFormatter;

public class HtmlContentFormatter implements ContentFormatter {

	public void format( Step step, HttpMethod method ) {

		try {
			
			HtmlCleaner cleaner = new HtmlCleaner( method.getResponseBodyAsStream() );
			
			cleaner.setNamespacesAware( false );
			cleaner.setOmitXmlDeclaration( true );

			cleaner.clean();			
			
			step.setXmlStr( cleaner.getXmlAsString() );
		} 
		catch (Exception e) {
			throw new DineException("unable to clean html ", e );
		}

	}

}
