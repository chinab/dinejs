package de.alombra.dine.steps.execution.content.impl;

import java.io.IOException;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.exception.DineException;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.execution.content.ContentFormatter;
import de.alombra.dine.util.IOUtil;

public class XmlContentFormatter implements ContentFormatter {

	public void format( Step step, HttpMethod method ) {

		try {						
			String xml = IOUtil.getContentLengthUnkown( method.getResponseBodyAsStream() );
			
			// see https://bugzilla.mozilla.org/show_bug.cgi?id=336551
			xml = xml.substring( xml.indexOf("?>")+2, xml.length() ).trim();
			
			step.setXmlStr( xml );
		} 
		catch (IOException e) {
			throw new DineException("unable to read xml answer", e);
		}


	}

}
