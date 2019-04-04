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
		
		
		
		
		//FUNCTION FOR INSERTING IN THE customer_details(First Name, Last Name, Email, Password)
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
		
		
		
		//SETTING THE CUSTOMER DETAILS
		public boolean updateCustomerById(Customer customer) {
			boolean status = false;
			Connection con = openConnection();
			Statement stmt = openStatement(con);
			ResultSet rs = null;
			
			try {
				
				String sql = "UPDATE customer_details SET cust_gender = '" + customer.getCust_gender() +"', cust_address='" +customer.getCust_address()+"', cust_city='" +customer.getCust_city()+"',  cust_zip='"+customer.getCust_zip()+"',cust_state='"+customer.getCust_state()+"' ,cust_country='"+customer.getCust_country()+"',cust_number='"+customer.getCust_number()+"' WHERE cust_id='"+customer.getCust_id()+"'";
				int row = stmt.executeUpdate(sql);
				if(row!=0) {
					status = true;	
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} finally {
				closeStatement(stmt);
				closeResultSet(rs);
				closeConnection(con);
			  }
			
			return status;
		}
		
		
		
		//CHANGING THE PASSWORD
		public boolean updateCustomerPasswordById(Customer customer) {
			boolean status = false;
			
			Connection con = openConnection();
			Statement stmt = openStatement(con);
			
			try {
				
				//UPDATE customer_information SET cust_gender=customer.getGender(), cust_address=customer.getAddress(), cust_city=customer.getCity,  cust_zip=customer.getZip(),
				//cust_state=customer.getState(), cust_country=customer.getCountry
				String sql = "UPDATE customer_details SET cust_password = '" + customer.getCust_password() +"' WHERE cust_id='"+customer.getCust_id()+"'";
				int row = stmt.executeUpdate(sql);
			
				if(row!=0) {
					status = true;
					
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} finally {
				closeStatement(stmt);
				closeConnection(con);
			}
			
			return status;
		}
		
		
		
		//SETTING COOKIE END TIME
		public boolean selectCookie(Customer customer) {
			
			boolean status = false;
			
			Connection con = openConnection();
			Statement stmt = openStatement(con);
			
			try {	
				//UPDATE customer_information SET cust_gender=customer.getGender(), cust_address=customer.getAddress(), cust_city=customer.getCity,  cust_zip=customer.getZip(),
				//cust_state=customer.getState(), cust_country=customer.getCountry
				String sql = "SELECT * FROM user_information WHERE usr_email=? and usr_lltime=?";
			    int row = stmt.executeUpdate(sql);
				
				if(row!=0) {
					
					status = true;	
				}
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} finally {
				closeStatement(stmt);
				closeConnection(con);
			}
			
			return status;
		}
		
	

		//SELECT QUERY FOR COOKIE
		public boolean updateCookieTime(Customer customer) {
			boolean status = false;
			
			Connection con = openConnection();
			Statement stmt = openStatement(con);
			
			try {
				
				//UPDATE customer_information SET cust_gender=customer.getGender(), cust_address=customer.getAddress(), cust_city=customer.getCity,  cust_zip=customer.getZip(),
				//cust_state=customer.getState(), cust_country=customer.getCountry
				String sql = "UPDATE customer_details SET cust_lltime = '" + customer.getCust_lltime() +"' WHERE cust_email='"+customer.getCust_email()+"'";
				int row = stmt.executeUpdate(sql);
				
				if(row!=0) {
					
					status = true;
					
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} finally {
				closeStatement(stmt);
				closeConnection(con);
			}
			
			return status;
		}		
	}