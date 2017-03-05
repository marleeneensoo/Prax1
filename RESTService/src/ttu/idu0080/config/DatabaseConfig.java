package ttu.idu0080.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConfig {
	
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "";
    private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost:3306/books";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "root";
    
    public Connection getConnection(){
    	try {
			Class.forName(this.PROPERTY_NAME_DATABASE_DRIVER);
			Connection connection = DriverManager.getConnection(this.PROPERTY_NAME_DATABASE_URL,
																this.PROPERTY_NAME_DATABASE_USERNAME,
																this.PROPERTY_NAME_DATABASE_PASSWORD);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
}
