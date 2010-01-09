package de.alombra.dine.http.impl;

import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import de.alombra.dine.http.HttpManager;
import de.alombra.dine.http.HttpResult;
import de.alombra.dine.http.cookie.AcceptAllCookieSpec;


public class HttpManagerImpl implements HttpManager {

  private HttpClient httpClient;

  static {
    CookiePolicy.registerCookieSpec( AcceptAllCookieSpec.SPEC_IDENTIFIER, AcceptAllCookieSpec.class ); 
  }
  
  public HttpManagerImpl( int maxConcurrentThreads, boolean allowCircularRedirects ) {
    super();
    
    MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager(); 
    
    HttpConnectionManagerParams connectionManagerParams = new HttpConnectionManagerParams();
    
    connectionManagerParams.setMaxTotalConnections( maxConcurrentThreads );
    
    connectionManager.setParams( connectionManagerParams );
    
    httpClient = new HttpClient( connectionManager );

    httpClient.getParams().setBooleanParameter( HttpClientParams.ALLOW_CIRCULAR_REDIRECTS, allowCircularRedirects );
    
    httpClient.getParams().setCookiePolicy( AcceptAllCookieSpec.SPEC_IDENTIFIER );        
  }
  
  public HttpResult executeGet( String url ) throws Exception {
    
    HttpMethod method = new GetMethod( url );

    // decoy
    //method.addRequestHeader( "User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)" );
    
    httpClient.executeMethod( method );
    
    return new HttpResult( method, httpClient.getState() );
  }
  
  public HttpResult executePost( String url, Map<String, String> params ) throws Exception {
    
    PostMethod method = new PostMethod( url );
    
    method.setRequestBody( convertParameters( params ) );
        
    httpClient.executeMethod( method );

    return new HttpResult( method, httpClient.getState() );
  }
  
  private NameValuePair[] convertParameters( Map<String, String> params ) {
    
    NameValuePair[] pairs = new NameValuePair[ params.size() ];
    
    int n=0;
    
    for ( String key : params.keySet() ) {
      pairs[n++] = new NameValuePair( key, params.get( key ) );    
    }    
    
    return pairs;
  }
}
