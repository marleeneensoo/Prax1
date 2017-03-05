package ttu.idu0080.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ttu.idu0080.config.DatabaseConfig;
import ttu.idu0080.models.Book;

public class BookDAO extends DAO{
	
	public List<Book> getAll(){
		try {
			String sql = "SELECT * FROM books";
			ResultSet resultSet= this.getRequest(sql); //resultSet- andmebaas annab mingi vastuse
			List<Book> books = new ArrayList<Book>();
			while(resultSet.next()){
				Book book = new Book();
				book.setId(resultSet.getInt("id")); //mapping 
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setGenre(resultSet.getString("genre"));
				book.setYear(resultSet.getInt("year"));
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Book getBookById(int id){
		String sql = "SELECT * FROM books WHERE id="+ String.valueOf(id);
		ResultSet resultSet= this.getRequest(sql);
		try {
			resultSet.first();
			Book book = new Book();
			book.setId(resultSet.getInt("id")); //mapping 
			book.setTitle(resultSet.getString("title"));
			book.setAuthor(resultSet.getString("author"));
			book.setGenre(resultSet.getString("genre"));
			book.setYear(resultSet.getInt("year"));
			return book;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} 
	public Book saveBook(Book book){
		DatabaseConfig databaseConfig = new DatabaseConfig();
		String sql = "INSERT INTO books(title, author, genre, year) VALUES (?,?,?,?)";
		try {
			PreparedStatement preparedStmt = databaseConfig.getConnection().prepareStatement(sql);
			preparedStmt.setString(1, book.getTitle());
		    preparedStmt.setString(2, book.getAuthor());
		    preparedStmt.setString(3, book.getGenre());
		    preparedStmt.setInt(4, book.getYear());
		    preparedStmt.execute();
		    databaseConfig.getConnection().close();
		    return book;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Book updateBook(Book book){
		DatabaseConfig databaseConfig = new DatabaseConfig();
		String sql = "UPDATE books SET title=?, author=?, genre=?, year=? WHERE id=?";
		try {
			PreparedStatement preparedStmt = databaseConfig.getConnection().prepareStatement(sql);
			preparedStmt.setString(1, book.getTitle());
		    preparedStmt.setString(2, book.getAuthor());
		    preparedStmt.setString(3, book.getGenre());
		    preparedStmt.setInt(4, book.getYear());
		    preparedStmt.setInt(5, book.getId());
		    preparedStmt.execute();
		    databaseConfig.getConnection().close();
		    return book;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void deleteBook(int id) {
		DatabaseConfig databaseConfig = new DatabaseConfig();
		String sql = "DELETE FROM books WHERE id=?";
		try {
			PreparedStatement preparedStmt = databaseConfig.getConnection().prepareStatement(sql);
		    preparedStmt.setInt(1, id);
		    preparedStmt.execute();
		    databaseConfig.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Book> searchBook(String query){
		try {
			String sql = "SELECT * FROM `books` WHERE title LIKE '%"+query+"%' OR author LIKE '%"+query+"%' OR year LIKE '%"+query+"%' OR genre LIKE '%"+query+"%' OR id LIKE '%"+query+"%'";
			ResultSet resultSet= this.getRequest(sql); 
			List<Book> books = new ArrayList<Book>();
			while(resultSet.next()){
				Book book = new Book();
				book.setId(resultSet.getInt("id")); //mapping 
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setGenre(resultSet.getString("genre"));
				book.setYear(resultSet.getInt("year"));
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
