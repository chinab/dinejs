package de.alombra.dine.exception;

public class DineException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DineException() {
		super();
	}

	public DineException( String message, Throwable throwable ) {
		super( message, throwable );
	}

	public DineException( String message) {
		super( message );
	}

	public DineException( Throwable throwable ) {
		super( throwable );
	}

	
}
