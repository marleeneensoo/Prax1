package ttu.idu0080.exceptions;

public class BookNullPointerException extends Exception {

	public BookNullPointerException() {
		this("Books not found");
	}

	public BookNullPointerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BookNullPointerException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookNullPointerException(String message) {
		super(message);
	}

	public BookNullPointerException(Throwable cause) {
		super(cause);
	}
	
}
