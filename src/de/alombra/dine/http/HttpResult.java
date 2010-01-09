package de.alombra.dine.http;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpState;


public class HttpResult {

  private HttpMethod httpMethod;
  private HttpState httpState;
  
  
  
  public HttpResult( HttpMethod httpMethod, HttpState httpState ) {
    super();
    this.httpMethod = httpMethod;
    this.httpState = httpState;
  }

  public HttpMethod getHttpMethod() {
    return httpMethod;
  }
  
  public HttpState getHttpState() {
    return httpState;
  }
}
