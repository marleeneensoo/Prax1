package ttu.idu0080.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BookFormatException extends WebApplicationException {

	public BookFormatException() {
		this("Book format type invalid");
	}

	public BookFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookFormatException(String message) {
		super(Response.status(Response.Status.BAD_REQUEST)
				.entity(message)
				.type(MediaType
						.TEXT_PLAIN)
						.build()
			);
	}

	public BookFormatException(Throwable cause) {
		super(cause);
	}
	
	
	

}
