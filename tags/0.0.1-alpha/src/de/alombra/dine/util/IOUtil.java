package de.alombra.dine.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import de.alombra.dine.exception.DineException;

public class IOUtil {

	public static void createFile( String fileName, String content ) {
		
		try {
	        FileWriter out = new FileWriter( new File( fileName ) );
	        out.write( content );
	        out.close();
		}
		catch ( Exception e ) {
		
			
		}
	}
	
	public static String getContent( InputStream stream ) {
		
		try {
			
			byte b[] = new byte[ stream.available() ];
			
			stream.read( b );
			
			stream.close();
			
			return new String( b );		
		} 
		catch ( Exception e ) {
			throw new DineException( e );
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
			throw new DineException("unable to read inputStream intto String", e );
		}
	}
	
	public static String getFileContent( String fileName ) {

		File file = new File( fileName );
				
		if ( !file.exists() || !file.canRead() || !file.isFile() )
			throw new DineException( "unable to read file "+fileName );
		
		try {
			return IOUtil.getContent( new FileInputStream( file ) );
		} 
		catch ( FileNotFoundException e ) {
			throw new DineException( e );
		}
	}
	
}
