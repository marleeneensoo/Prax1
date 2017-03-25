package ttu.idu0080.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BookNullPointerException extends WebApplicationException {

	public BookNullPointerException() {
		this("Books not found");
	}

	public BookNullPointerException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookNullPointerException(String message) {
		super(Response.status(Response.Status.NOT_FOUND)
				.entity(message)
				.type(MediaType
						.TEXT_PLAIN)
						.build()
			);
	}

	public BookNullPointerException(Throwable cause) {
		super(cause);
	}
	
}
