package de.alombra.dine.clients.cli;

import de.alombra.dine.clients.cli.callback.ArgSeedInstructionCallback;
import de.alombra.dine.clients.cli.callback.EmptyMemoryCallback;
import de.alombra.dine.clients.cli.callback.FilesystemDownloadCallback;
import de.alombra.dine.clients.cli.callback.FilesystemResolverCallback;
import de.alombra.dine.runtime.RuntimeConfig;
import de.alombra.dine.runtime.Starter;


public class Runner {

  public static void main( String[] args ) throws Exception {
    
    if ( args.length != 4 ) {
      
      System.err.println();
      System.err.println( "Usage: java -jar dinejs-all.jar <maxConcurrentThreads> <StepsBaseDirectory> <DownloadBaseDirectory> <seedStep>" );
      System.err.println();
      System.err.println( "e.g.: java -jar dinejs-all.jar 50 /home/myuser/steps /home/myuser/downloads /myStartStep" );
      System.err.println();
      
      System.exit( -1 );
    }
    
    String stepsDir = args[1];
    
    if ( stepsDir.endsWith( "/" ) )
      stepsDir = stepsDir.substring( 0, stepsDir.length()-1 );
    
    String downloadDir = args[2];
      
    if ( downloadDir.endsWith( "/" ) )
      downloadDir = downloadDir.substring( 0, downloadDir.length()-1 );
    

    RuntimeConfig config = new RuntimeConfig();

    config.setMaxConcurrentThreads( Integer.parseInt( args[0] ) )
          .setAllowCircularRedirects( true )
          .setQueueCheckInterval( 10 )
          .setMemoryCallback( new EmptyMemoryCallback() )
          .setResolverCallback( new FilesystemResolverCallback( stepsDir ) )
          .setDownloadCallback( new FilesystemDownloadCallback( downloadDir ) )
          .setSeedInstructionCallback( new ArgSeedInstructionCallback( args[3] ) );
    
    
    Starter.setupAndStart( config );
  }  
}
