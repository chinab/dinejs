package de.alombra.dine.steps.execution.content;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.steps.Step;

public interface ContentFormatter {

	public void format( Step step, HttpMethod method );
}
