package de.alombra.dine.steps.execution.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;

import de.alombra.dine.steps.execution.http.cookie.AcceptAllCookieSpec;

public class HttpUtil {
	
	static {
		CookiePolicy.registerCookieSpec( AcceptAllCookieSpec.SPEC_IDENTIFIER, AcceptAllCookieSpec.class );
	}

	public static HttpMethod executeGet( String url ) throws Exception {
				
		HttpClient client = new HttpClient();
		
		client.getParams().setCookiePolicy( AcceptAllCookieSpec.SPEC_IDENTIFIER );
		
		HttpMethod method = new GetMethod( url );

		client.executeMethod( method );
		
		return method;
	}
}
