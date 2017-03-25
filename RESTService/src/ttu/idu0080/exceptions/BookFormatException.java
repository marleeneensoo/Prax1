package ttu.idu0080.exceptions;

public class BookFormatException extends Exception{

	public BookFormatException() {
		this("Book format type invalid");
	}

	public BookFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BookFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookFormatException(String message) {
		super(message);
	}

	public BookFormatException(Throwable cause) {
		super(cause);
	}
	
	
	

}
