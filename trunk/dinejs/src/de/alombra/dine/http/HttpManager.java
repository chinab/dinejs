package de.alombra.dine.http;

import java.util.Map;



public interface HttpManager {

  public HttpResult executeGet( String url ) throws Exception;

  public HttpResult executePost( String url, Map<String, String> params ) throws Exception;

}