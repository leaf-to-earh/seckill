package org.exception;

/*
 * ��ɱ�ر��쳣
 */
public class SeckillClosedException extends SeckillException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SeckillClosedException(String message) {
		super(message);
	}

	public SeckillClosedException(String message, Throwable cause) {
		super(message, cause);
	}

}
