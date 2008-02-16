package de.alombra.dine.steps.execution.xml;

import java.io.InputStream;

import org.htmlcleaner.HtmlCleaner;

public class XmlUtil {

	public static String htmlToXml( InputStream input ) throws Exception {
		
		HtmlCleaner cleaner = new HtmlCleaner( input );
		
		cleaner.setNamespacesAware( false );
		cleaner.setOmitXmlDeclaration( true );

		cleaner.clean();
		
		return cleaner.getXmlAsString();				
	}
}
