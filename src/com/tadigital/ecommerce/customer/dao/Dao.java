package com.tadigital.ecommerce.customer.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


	public class Dao {
		protected Connection openConnection() {
			
			Connection con = null;
			
			//SETTING THE VALUES FOR DATABASE CONNECTION FROM PROPERTIES FILE 
			Properties props = new Properties();
			InputStream inputStream = getClass().getResourceAsStream("Dao.properties");
			try {
				props.load(inputStream);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}			
			String driver = props.getProperty("cust_db_driver");
			String database = props.getProperty("cust_db_database");
			String root = props.getProperty("cust_db_root");

			//ESTABLISHING THE DATABASE CONNECTION
			try {				
				Class.forName(driver);
				con = DriverManager.getConnection(database, root, "");
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		
			return con;
		}
	
		//STATEMENT INTERFACE CREATED
		protected Statement openStatement(Connection con) {
			Statement stmt = null;
		
			try {
				stmt = con.createStatement();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			return stmt;
		}
	
	
		//CLOSING THE RESULTSET
		protected void closeResultSet(ResultSet rs) {
			try {
				
				if(rs != null) {
				rs.close();
				
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	
	
		//CLOSING THE STATEMENT
		protected void closeStatement(Statement stmt) {
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
	
		//CLOSING THE CONNECTION
		protected void closeConnection(Connection con) {
			try {
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException sqle) {
			sqle.printStackTrace();
			}
		}
}