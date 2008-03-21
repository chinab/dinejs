package de.alombra.dine.steps.build.impl;

import java.io.StringReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.alombra.dine.exception.DineException;
import de.alombra.dine.steps.Executable;
import de.alombra.dine.steps.Step;
import de.alombra.dine.steps.build.StepBuilder;
import de.alombra.dine.steps.build.StepFactory;
import de.alombra.dine.util.IOUtil;

public class CachingFileStepFactory implements StepFactory {

	private String jsRootDir;
	
	private Map<String, String> jsFileCache = new ConcurrentHashMap<String, String>();
	
	private static final Log logger = LogFactory.getLog( CachingFileStepFactory.class );
		
	public CachingFileStepFactory( String jsRootDir ) {
		super();
		this.jsRootDir = jsRootDir;
	}
	
	public synchronized Executable getExecutable( String name ) {
		
		String fileName = jsRootDir+"/"+name+".js";
		
		if ( !this.jsFileCache.containsKey( name ) ) 
			this.jsFileCache.put( name, IOUtil.getFileContent( fileName ) );
		
		try {
			
			if ( logger.isInfoEnabled() )
				logger.info("creating executable ["+name+"]" );
			
			return new StepBuilder().create( new StringReader( this.jsFileCache.get( name ) ), fileName )
									.getExecutable();
		}
		catch ( Exception e ) {
			throw new DineException("unable to create executable "+name, e);
		}
	}
	
	public synchronized Step getStep( String name ) {
		
		String fileName = jsRootDir+"/"+name+".js";
		
		if ( !this.jsFileCache.containsKey( name ) ) 
			this.jsFileCache.put( name, IOUtil.getFileContent( fileName ) );
		
		try {
			
			if ( logger.isInfoEnabled() )
				logger.info("creating step ["+name+"]" );
			
			return new StepBuilder().create( new StringReader( this.jsFileCache.get( name ) ), fileName )
									.getStep();
		}
		catch ( Exception e ) {
			throw new DineException("unable to create step "+name, e);
		}
	}
}
