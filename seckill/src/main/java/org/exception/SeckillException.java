package org.exception;

public class SeckillException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4291113598518725887L;

	public SeckillException(String message) {
		super(message);
	}
	
	public SeckillException(String message, Throwable cause) {
		super(message, cause);
	}

}
