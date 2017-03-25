package ttu.idu0080.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BusinessLogicException extends WebApplicationException {

	public BusinessLogicException() {
		this("Business logic exception");
	}

	public BusinessLogicException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessLogicException(String message) {
		super(Response.status(Response.Status.BAD_REQUEST)
				.entity(message)
				.type(MediaType
						.TEXT_PLAIN)
						.build()
			);
	}

	public BusinessLogicException(Throwable cause) {
		super(cause);
	}
	
	
	

}
