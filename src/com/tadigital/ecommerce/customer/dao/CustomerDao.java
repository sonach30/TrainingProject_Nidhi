package com.tadigital.ecommerce.customer.dao;


	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	/*import java.util.ArrayList;
	import java.util.Calendar;
	import java.util.Date;
	//import java.util.GregorianCalendar;
*/
import com.tadigital.ecommerce.customer.entity.Customer;

	public class CustomerDao extends Dao {
		
		//EXTRACTING AND ASSIGNING DETAILS FROM customer_details TABLE FOR ENTERED EMAIL AND PASSWORD
		public boolean selectCustomerByEmailAndPassword(Customer customer) {
			boolean status = false;
			
			//ESTABLISHING DATABSE CONNECTION
			Connection con = openConnection();
			Statement stmt = openStatement(con);
			ResultSet rs = null;
			
			try {
				String sql = "SELECT * FROM customer_details WHERE cust_email = '" + customer.getCust_email() + "' AND cust_password = '" + customer.getCust_password() + "'";
				
				rs = stmt.executeQuery(sql);
				
				//SETTING VALUES FOR CUSTOMER ID FIRSTNAME AND LASTNAME 
				if(rs.next()) {
					status = true;
					
					//SETTING THE VALUES IN CUSTOMER ENTITY FROM THE DATABASE FOR CURRENT USER
					customer.setCust_id(rs.getInt(1));
					customer.setCust_fname(rs.getString(2));
					customer.setCust_lname(rs.getString(3));
					
				}
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} finally {
				
				//CLOSING THE STATEMENT,RESULTSET AND CONNECTION 
				closeStatement(stmt);
				closeResultSet(rs);
				closeConnection(con);
			}
			
			//RETURNING SELECT QUERY EXECUTION STATUS
			return status;
		}
		
		
		
		
		//FUNCTION FOR INSERTING IN THE customer_details
		//RETURN THE STATUS FOR INSERTING QUERY
		public boolean insertCustomer(Customer customer) {
			boolean status = false;
			
			//ESTABLISHING CONNECTION
			Connection con = openConnection();
			Statement stmt = openStatement(con);
			
			try {
				String sql = "INSERT INTO customer_details(cust_fname, cust_lname, cust_email, cust_password) VALUES('" + customer.getCust_fname() + "', '" + customer.getCust_lname() + "', '" + customer.getCust_email() + "', '" + customer.getCust_password() + "')";
				
				//EXECUTING INSERT QUERY
				int rows = stmt.executeUpdate(sql);
				if(rows != 0) {
					status = true;
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} finally {
				
				//CLOSING THE DATABASE CONNECTION 
				closeStatement(stmt);
				closeConnection(con);
			}
			
			//RETURNING THE INSERT QUERY EXECUTION STATUS 
			return status;
		}
		
		
}
