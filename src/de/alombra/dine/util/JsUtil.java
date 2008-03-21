package de.alombra.dine.util;

import de.alombra.json.JsonCode;

public class JsUtil {

	public static String getJsonRepresentation( String[] arr ) {
		 
		JsonCode json = new JsonCode().startArray();
		
		for ( String arrElem : arr )
			json.add( arrElem );
		
		json.endArray();
		return json.toString();
	}
}
