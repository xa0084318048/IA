package IA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {
	
	private static final String databaseURL = "jdbc:ucanaccess://C:/Users/chang/Documents/Database»ÀŒÔø®.accdb";
    private static Connection conn = null;
	
	public Connection getConn() {
		try {
			conn = (Connection) DriverManager.getConnection(databaseURL);
		}catch(SQLException a) {
			System.out.println("Connection fail");
			a.printStackTrace();
		}
		return (Connection) conn;
	}
	
        
    
}


