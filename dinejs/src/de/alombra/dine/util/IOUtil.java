package de.alombra.dine.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class IOUtil {

  public static final Log logger = LogFactory.getLog( IOUtil.class );
  
  public static void createFolder( String path ) {
    
    File file = new File( path );
    
    if ( file.exists() && file.isDirectory() && file.canWrite() )
      return;
    
    if ( logger.isInfoEnabled() )
      logger.info( "Creating folder: "+path );
    
    file.mkdir();    
  }
  
	public static void writeToFile( InputStream inputStream, String fileName ) {
		
		File file = new File( fileName );
		FileOutputStream fileOutputStream = null;
		try {
			if ( !file.exists() )
				file.createNewFile();

			fileOutputStream = new FileOutputStream( file );
			
			int nextByte; 
			
			while ( ( nextByte = inputStream.read() ) != -1 ) {
				fileOutputStream.write( nextByte );
			}
		}
		catch( Exception e ) {
			throw new RuntimeException( e );
		}
		finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				throw new RuntimeException("Unable to close file output stream", e);
			}
		}
	}
	
	public static List<File> scanDirectory( File baseDir ) {
		
		List<File> foundFiles = new LinkedList<File>();
		
		if ( baseDir.isDirectory() && baseDir.canRead() ) {
			for ( File foundFile : baseDir.listFiles() ) {
				
				if ( foundFile.isDirectory() && foundFile.canRead() ) {
					foundFiles.addAll( IOUtil.scanDirectory( foundFile ) );
				}
				
				if ( foundFile.isFile() && foundFile.canRead() && foundFile.getName().endsWith(".js") )
					foundFiles.add( foundFile );				
			}
		}
		
		return foundFiles;	
	}
	
	public static String getContent( InputStream stream ) {
		
		try {
			
			byte b[] = new byte[ stream.available() ];
			
			stream.read( b );
			
			stream.close();
			
			return new String( b );		
		} 
		catch ( Exception e ) {
			throw new RuntimeException( e );
		}
	}
	
	public static String getContentLengthUnkown( InputStream stream ) {
		
		try {
			// TODO refactor, this is very ugly and perhaps unstable code!
			int b;
			
			List<Byte> byteList = new LinkedList<Byte>();
			
			while ( ( b = stream.read() ) != -1 )
				byteList.add( new Byte( (byte)b ) );
	
			byte[] bytes = new byte[ byteList.size() ];
			
			int n=0;
			
			for ( Byte oneByte : byteList )
				bytes[n++] = oneByte;
			
			return new String( bytes );
		}
		catch( Exception e ) {
			throw new RuntimeException("unable to read inputStream intto String", e );
		}
	}	
}