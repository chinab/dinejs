package de.alombra.dine.steps.execution.content.impl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.exception.DineException;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.execution.content.ContentFormatter;

public class JsonContentFormatter implements ContentFormatter {

	public void format( Step step, HttpMethod method ) {

		try {
			// TODO refactor, this is very ugly and perhaps unstable code!
			int b;
			
			List<Byte> byteList = new LinkedList<Byte>();
			
			while ( ( b = method.getResponseBodyAsStream().read() ) != -1 ) {

				byteList.add( new Byte( (byte)b ) );
				
				 
			}

			byte[] bytes = new byte[ byteList.size() ];
			int n=0;
			for ( Byte oneByte : byteList )
				bytes[n++] = oneByte;
			
			step.setJsonStr( new String( bytes ) );
		} 
		catch (IOException e) {
			throw new DineException("Unable to read json", e);
		}

	}

}
