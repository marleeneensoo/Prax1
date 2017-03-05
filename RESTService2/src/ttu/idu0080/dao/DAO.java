package ttu.idu0080.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ttu.idu0080.config.DatabaseConfig;

public class DAO {
	
	public ResultSet getRequest(String query){
		try {
			DatabaseConfig databaseConfig = new DatabaseConfig();
			Connection connection = databaseConfig.getConnection();
			Statement statement = connection.createStatement();
			return statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
