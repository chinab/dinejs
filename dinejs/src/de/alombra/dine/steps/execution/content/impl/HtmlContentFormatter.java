package de.alombra.dine.steps.execution.content.impl;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.exception.DineException;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.execution.content.ContentFormatter;
import de.alombra.dine.steps.execution.xml.XmlUtil;

public class HtmlContentFormatter implements ContentFormatter {

	public void format( Step step, HttpMethod method ) {

		try {
			step.setXmlStr( XmlUtil.htmlToXml( method.getResponseBodyAsStream() ) );
		} 
		catch (Exception e) {
			throw new DineException("unable to clean html ", e );
		}

	}

}
