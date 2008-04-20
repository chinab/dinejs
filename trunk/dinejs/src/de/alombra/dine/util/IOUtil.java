package de.alombra.dine.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class IOUtil {

  public static final Log logger = LogFactory.getLog( IOUtil.class );
    
	public static void writeToFile( InputStream inputStream, String fileName ) {

    File file = new File( fileName );
    FileOutputStream fileOutputStream = null;
    Writer out = null;

    try {

      if ( !file.exists() )
        file.createNewFile();

      fileOutputStream = new FileOutputStream( file );

      int nextByte; 	      

      out = new BufferedWriter( new OutputStreamWriter( fileOutputStream, "UTF8" ) );

      while ( ( nextByte = inputStream.read() ) != -1 ) {
        out.write( nextByte );
      }
      
    }
    catch( Exception e ) {
      throw new RuntimeException( e );
    }
    finally {
      try {
        out.close();
      } catch (IOException e) {
        throw new RuntimeException( "Unable to close file output stream", e );
      }
    }
  }	  
	
  public static void writeBinaryFile( InputStream inputStream, String fileName ) {

    final int bufferSize = 1000;
    
    try {

      BufferedInputStream in = new BufferedInputStream( inputStream );
      BufferedOutputStream out = new BufferedOutputStream( new FileOutputStream( new File( fileName ) ) );
    
      byte[] buffer = new byte[ bufferSize ];
    
      int readCount = 0;
    
      while ( (readCount = in.read(buffer)) != -1 ) { 
        
        if ( readCount < bufferSize ) {
          out.write(buffer, 0, readCount);
        } 
        else {
          out.write( buffer );
        }
      }    
    } 
    catch( Exception e ) {    
      throw new RuntimeException( "Unable to write file "+fileName, e );
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