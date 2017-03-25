package ttu.idu0080.exceptions;

public class BusinessLogicException extends Exception {

	public BusinessLogicException() {
		this("Business logic exception");
	}

	public BusinessLogicException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessLogicException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessLogicException(String message) {
		super(message);
	}

	public BusinessLogicException(Throwable cause) {
		super(cause);
	}
	
	
	

}
