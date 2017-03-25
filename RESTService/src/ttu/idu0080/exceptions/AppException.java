package ttu.idu0080.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class AppException extends WebApplicationException {

	public AppException() {
		this("Webservice failed");
	}
	
	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity(message)
				.type(MediaType
						.TEXT_PLAIN)
						.build()
			);
	}
	
	public AppException(Throwable cause) {
		super(cause);
	}
	
	
}
