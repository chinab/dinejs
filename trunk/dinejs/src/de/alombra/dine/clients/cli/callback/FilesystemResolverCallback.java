package de.alombra.dine.clients.cli.callback;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import de.alombra.dine.runtime.callback.ResolverCallback;
import de.alombra.dine.util.IOUtil;


public class FilesystemResolverCallback implements ResolverCallback {

  /**
   * the root dir under which all steps are located 
   */
  private String baseDir;
  
  public FilesystemResolverCallback( String baseDir ) {
    this.baseDir = baseDir;
  }
  
  public Map<String, Reader> resolveStepCode() {
  
    File dir = new File( this.baseDir );
    Map<String, Reader> resolvedSteps = new HashMap<String, Reader>();
  
    try {
      
      // recursively locate all .js files under the base directory
      for ( File jsFile : IOUtil.scanDirectory( dir ) ) {
      
        // cut off the .js ending, cut off the path to the basedir
        // so that only the path to the file under the basedir is 
        // left as name for the step
        String name = jsFile.getCanonicalPath()
                            .replaceAll( dir.getCanonicalPath(), "" )
                            .replaceAll(".js", "");
  
        resolvedSteps.put( name, new FileReader( jsFile ) );
      }
  
      // at least one step must be found
      if ( resolvedSteps.size() == 0 ) {
        throw new RuntimeException("No steps resolved!");
      }
      
      return resolvedSteps;
    }
    catch ( Exception e ) {
      throw new RuntimeException( "Unable to resolve steps", e );
    }
  }

}
