package ttu.idu0080.controllers;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ttu.idu0080.dao.BookDAO;
import ttu.idu0080.dao.BookDAOImpl;
import ttu.idu0080.exceptions.AppException;
import ttu.idu0080.exceptions.BookFormatException;
import ttu.idu0080.exceptions.BookNullPointerException;
import ttu.idu0080.exceptions.BusinessLogicException;
import ttu.idu0080.models.Book;
import ttu.idu0080.repositories.RESTService2API;

@Path("/book")
public class BookController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAll() throws BookNullPointerException{
		BookDAOImpl bookDao = new BookDAOImpl();
		return bookDao.getAll();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Book getBookById(@PathParam("id") int id) throws BusinessLogicException, BookNullPointerException{
		BookDAOImpl bookDao = new BookDAOImpl();
		return bookDao.getBookById(id);	
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book saveBook(Book book) throws BookFormatException, BookNullPointerException{
		BookDAOImpl bookDao = new BookDAOImpl();
		return bookDao.saveBook(book);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book updateBook(Book book) throws BookFormatException, BookNullPointerException{ 
		BookDAOImpl bookDao = new BookDAOImpl();
	      return bookDao.updateBook(book);
	}  
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteBook(@PathParam("id") int id) throws BusinessLogicException, BookNullPointerException, AppException{
		BookDAOImpl bookDao = new BookDAOImpl();
		bookDao.deleteBook(id);
	}
	@GET
	@Path("/search/{query}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> searchBook(@PathParam("query") String query) throws BookFormatException, BookNullPointerException{
		BookDAOImpl bookDao = new BookDAOImpl();
		return bookDao.searchBook(query);
	}
	@GET
	@Path("/external")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBooksFromService2(){
		RESTService2API restService2API = new RESTService2API();
		return restService2API.getBooks();
	}
	
}




