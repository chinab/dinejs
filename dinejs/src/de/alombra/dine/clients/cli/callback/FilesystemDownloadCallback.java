package de.alombra.dine.clients.cli.callback;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import de.alombra.dine.runtime.callback.DownloadCallback;
import de.alombra.dine.util.IOUtil;


public class FilesystemDownloadCallback implements DownloadCallback {

  private String baseDir;
  
  public FilesystemDownloadCallback( String baseDir ) {
    super();
    this.baseDir = baseDir;
  }

  public void processDownload( InputStream inputStream, String filename ) {

    IOUtil.writeBinaryFile( inputStream, this.baseDir+"/"+filename );
  }

  public void writeFile( String content, String filename ) {

    IOUtil.writeToFile( new ByteArrayInputStream( content.getBytes() ), filename );
  }

}
