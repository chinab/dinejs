package de.alombra.dine.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import de.alombra.dine.http.cookie.AcceptAllCookieSpec;

public class HttpUtil {
	
	private static final HttpClient httpClient;
	
	static {
		
		MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager(); 
		
		HttpConnectionManagerParams connectionManagerParams = new HttpConnectionManagerParams();
		
		connectionManagerParams.setMaxTotalConnections( 50 );
		
		connectionManager.setParams( connectionManagerParams );
		
		httpClient = new HttpClient( connectionManager );
		
		
		CookiePolicy.registerCookieSpec( AcceptAllCookieSpec.SPEC_IDENTIFIER, AcceptAllCookieSpec.class );
		
		httpClient.getParams().setCookiePolicy( AcceptAllCookieSpec.SPEC_IDENTIFIER );
	}

	public static HttpMethod executeGet( String url ) throws Exception {
		
		HttpMethod method = new GetMethod( url );

		httpClient.executeMethod( method );

		return method;
	}
}
