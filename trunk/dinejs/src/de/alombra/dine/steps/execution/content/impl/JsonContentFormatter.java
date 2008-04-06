package de.alombra.dine.steps.execution.content.impl;

import java.io.IOException;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.steps.execution.content.ContentFormatter;
import de.alombra.dine.util.IOUtil;

public class JsonContentFormatter implements ContentFormatter {

	public String format( HttpMethod method ) {

		try {
			return IOUtil.getContentLengthUnkown( method.getResponseBodyAsStream() );
		} 
		catch ( IOException e) {
			throw new RuntimeException("Unable to read json answer");
		}
	}

}
