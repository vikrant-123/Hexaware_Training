package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * DBConnection class for managing database connections and properties in 
 * the Virtual Art Gallery application.
 * This class provides a method to establish a connection to the database
 * using connection details from a properties file.
 *
 * @author Vikrant Bathe
 * @version 1.0
 * @since 2024-02-01
 */
public class DBConnection {

static Connection con;
	
public static Connection getConnection() {
		
		String fileName = "D:\\Eclipse\\Hexaware_training\\VAG\\src\\main\\resources\\db.properties";
		Properties props = new Properties();
		FileInputStream fis =null;
		
		try {
			fis = new FileInputStream(fileName);
			props.load(fis);
			
			String url = props.getProperty("db.url");
			String un = props.getProperty("db.username");
			String pwd = props.getProperty("db.password");
			
		con = DriverManager.getConnection(url , un , pwd);
		} catch (SQLException | IOException e) {
		
			e.printStackTrace();
		}	
		
		return con;
	}

}
