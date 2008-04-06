package de.alombra.dine.steps.resolve.impl;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import de.alombra.dine.steps.resolve.Resolver;
import de.alombra.dine.util.IOUtil;


public class FilesystemResolver implements Resolver {

  private String baseDir;
  
  public FilesystemResolver( String baseDir ) {
    this.baseDir = baseDir;
  }
  
  public Map<String, Reader> resolveStepCode() {
  
    File dir = new File( this.baseDir );
    Map<String, Reader> resolvedSteps = new HashMap<String, Reader>();
  
    try {
      
      for ( File jsFile : IOUtil.scanDirectory( dir ) ) {
      
        String name = jsFile.getCanonicalPath()
                            .replaceAll( dir.getCanonicalPath(), "" )
                            .replaceAll(".js", "");
  
        resolvedSteps.put( name, new FileReader( jsFile ) );
      }
  
      if ( resolvedSteps.size() == 0 )
        throw new RuntimeException("No steps resolved!");
      
      return resolvedSteps;
    }
    catch ( Exception e ) {
      throw new RuntimeException( "Unable to resolve steps", e );
    }
  }

}
