package org.exception;

public class RepeatKillException extends SeckillException {

	/**
	 * �ظ���ɱ�쳣
	 */
	private static final long serialVersionUID = 1L;

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepeatKillException(String message) {
		super(message);
	}

}
