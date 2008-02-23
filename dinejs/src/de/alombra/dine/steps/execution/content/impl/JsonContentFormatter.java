package de.alombra.dine.steps.execution.content.impl;

import java.io.IOException;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.exception.DineException;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.execution.content.ContentFormatter;
import de.alombra.dine.util.IOUtil;

public class JsonContentFormatter implements ContentFormatter {

	public void format( Step step, HttpMethod method ) {

		try {
			step.setJsonStr( IOUtil.getContentLengthUnkown( method.getResponseBodyAsStream() ) );
		} 
		catch ( IOException e) {
			throw new DineException("Unable to read json answer");
		}
	}

}
