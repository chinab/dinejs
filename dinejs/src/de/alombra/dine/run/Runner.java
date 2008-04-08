package de.alombra.dine.run;


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
	  
	  
	  RuntimeConfig.init( 
	                  Integer.parseInt( args[0] ), 
	                  stepsDir,  
	                  downloadDir,
	                  args[3] 
	                 );
	  
	  Starter.setup();
	}
}
