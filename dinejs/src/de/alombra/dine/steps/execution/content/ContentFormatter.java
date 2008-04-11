package de.alombra.dine.steps.execution.content;

import org.apache.commons.httpclient.HttpMethod;

public interface ContentFormatter {

	public String format( HttpMethod method, String contentType );
}
