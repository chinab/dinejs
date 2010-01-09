package de.alombra.dine.runtime.callback;

import java.io.InputStream;


public interface DownloadCallback {

  public void processDownload( InputStream inputStream, String filename );
  
  public void writeFile( String content, String filename );
}
