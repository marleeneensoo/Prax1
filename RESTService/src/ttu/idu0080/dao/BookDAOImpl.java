package ttu.idu0080.dao;

import java.util.Calendar;
import java.util.List;

import ttu.idu0080.exceptions.AppException;
import ttu.idu0080.exceptions.BookFormatException;
import ttu.idu0080.exceptions.BookNullPointerException;
import ttu.idu0080.exceptions.BusinessLogicException;
import ttu.idu0080.models.Book;

public class BookDAOImpl {
	private BookDAO bookDao;
	
	public BookDAOImpl() {
		this.bookDao = new BookDAO();
	}

	public List<Book> getAll() throws BookNullPointerException{
		List<Book> books = this.bookDao.getAll();
		if(books.isEmpty()){
			throw new BookNullPointerException();
		}
		return books;
	}
	
	public Book getBookById(int id) throws BusinessLogicException, BookNullPointerException{
		if(id < 1){
			throw new BusinessLogicException("Negative book id");
		}
		Book book = this.bookDao.getBookById(id);
		if(book == null){
			throw new BookNullPointerException();
		}
		return book;
	} 
	public Book saveBook(Book book) throws BookFormatException, BookNullPointerException{
		if(book == null){
			throw new BookNullPointerException();
		}
		if(
			book.getAuthor().isEmpty()||
			book.getGenre().isEmpty() ||
			book.getTitle().isEmpty() ||
			book.getYear() == 0)
		{
			throw new BookFormatException("All Fields Required");
		}
		int year = Calendar.getInstance().get(Calendar.YEAR);
		if(book.getYear() > year){
			throw new BusinessLogicException("Movie Year Incorrect");
		}
		return this.bookDao.saveBook(book);
	}
	public Book updateBook(Book book) throws BookFormatException, BookNullPointerException{
		if(book == null){
			throw new BookNullPointerException();
		}
		if(
			book.getId() == 0 ||
			book.getAuthor().isEmpty()||
			book.getGenre().isEmpty()||
			book.getTitle().isEmpty()||
			book.getYear() == 0)
		{
			throw new BookFormatException();
		}
		int year = Calendar.getInstance().get(Calendar.YEAR);
		if(book.getYear() > year){
			throw new BusinessLogicException("Movie Year Incorrect");
		}
		return this.bookDao.updateBook(book);
	}
	public void deleteBook(int id) throws BusinessLogicException, BookNullPointerException, AppException {
		if(id < 1){
			throw new BusinessLogicException("Negative book id");
		}
		Book book = this.bookDao.getBookById(id);
		if(book == null){
			throw new BookNullPointerException("Book already deleted or does not exist");
		}
		this.bookDao.deleteBook(id);
		book = this.bookDao.getBookById(id);
		if(book != null){
			throw new AppException("Could not delete book");
		}
	}
	public List<Book> searchBook(String query) throws BookFormatException, BookNullPointerException{
		if(query.isEmpty()){
			throw new BookFormatException("Empty query");
		}
		List<Book> books = this.bookDao.searchBook(query);
		if(books.isEmpty()){
			throw new BookNullPointerException();
		}
		return books;
	}

}
