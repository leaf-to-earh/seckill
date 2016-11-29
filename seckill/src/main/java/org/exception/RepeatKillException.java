package org.exception;

public class RepeatKillException extends SeckillException {

	/**
	 * ÷ÿ∏¥√Î…±“Ï≥£
	 */
	private static final long serialVersionUID = 1L;

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepeatKillException(String message) {
		super(message);
	}

}
