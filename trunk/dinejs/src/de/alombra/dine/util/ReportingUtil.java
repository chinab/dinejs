package de.alombra.dine.util;

import org.mozilla.javascript.EvaluatorException;

public class ReportingUtil {

	public static void reportException( Exception e ) {
		
		if ( e instanceof EvaluatorException )			
			reportJsError( (EvaluatorException)e );
		
		else		
			//System.err.println( e );
		  e.printStackTrace();
	}
	
	public static void reportJsError( EvaluatorException evaluatorException ) {
		System.err.println("--- JavaScript Error -------------------------------------------------------------");
		System.err.println("");
		System.err.println("File:  "+evaluatorException.sourceName() );
		System.err.println("Line:  "+evaluatorException.lineNumber() );
		System.err.println("");
		System.err.println( evaluatorException.details() );
		System.err.println("");
		System.err.println("----------------------------------------------------------------------------------");
	}
}
