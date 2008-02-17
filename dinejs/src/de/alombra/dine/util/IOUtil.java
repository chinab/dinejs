package de.alombra.dine.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import de.alombra.dine.exception.DineException;

public class IOUtil {

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
	
	public static Properties loadProperties( String fileName ) {
		
		try {
			
			Properties props = new Properties();
			props.load( new FileInputStream( fileName ) );
			
			return props;
		}
		catch ( Exception e ) {
			throw new DineException( e );
		}
	}
	
}
