package de.alombra.dine.steps.execution.content.impl;

import java.io.IOException;

import org.apache.commons.httpclient.HttpMethod;

import de.alombra.dine.steps.execution.content.ContentFormatter;
import de.alombra.dine.util.IOUtil;

public class XmlContentFormatter implements ContentFormatter {

	public String format( HttpMethod method ) {

		try {						
			String xml = IOUtil.getContentLengthUnkown( method.getResponseBodyAsStream() );
			
			// we need to cut out the <?xml ... ?> declaration because
			// of a bug in E4X, for details see: https://bugzilla.mozilla.org/show_bug.cgi?id=336551
			xml = xml.substring( xml.indexOf("?>")+2, xml.length() ).trim();
			
			return xml;
		} 
		catch (IOException e) {
			throw new RuntimeException("unable to read xml answer", e);
		}


	}

}
