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
		public boolean selectEmployeeByEmailAndPassword(Customer customer) {
			boolean status = false;
			
			Connection con = openConnection();
			Statement stmt = openStatement(con);
			ResultSet rs = null;
			
			try {
				String sql = "SELECT * FROM customer_details WHERE cust_email = '" + customer.getCust_email() + "' AND cust_password = '" + customer.getCust_password() + "'";
				
				rs = stmt.executeQuery(sql);
				
				//SETTING VALUES FOR CUSTOMER ID FIRSTNAME AND LASTNAME 
				if(rs.next()) {
					status = true;
					
					customer.setCust_id(rs.getInt(1));
					customer.setCust_fname(rs.getString(2));
					customer.setCust_lname(rs.getString(3));
					
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
		
		
		
		
		//FUNCTION FOR INSERTING IN THE customer_details
		//RETURN THE STATUS FOR INSERTING QUERY
		public boolean insertCustomer(Customer customer) {
			boolean status = false;
			
			Connection con = openConnection();
			Statement stmt = openStatement(con);
			
			try {
				String sql = "INSERT INTO customer_details(cust_fname, cust_lname, cust_email, cust_password) VALUES('" + customer.getCust_fname() + "', '" + customer.getCust_lname() + "', '" + customer.getCust_email() + "', '" + customer.getCust_password() + "')";
				
				int rows = stmt.executeUpdate(sql);
				if(rows != 0) {
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
		
		/*from Employee.java from com.tadigital.service to get the status for select*/
		/*public ArrayList<Customer> selectAllEmployees() {
			ArrayList<Customer> employeeList = new ArrayList<>(); 
			
			Connection con = openConnection();
			Statement stmt = openStatement(con);
			ResultSet rs = null;
			
			try {
				String sql = "SELECT * FROM employee_information";
				
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Employee employee = new Employee();				
					employee.setId(rs.getInt(1));
					employee.setFirstName(rs.getString(2));
					employee.setLastName(rs.getString(3));
					Calendar doj = new GregorianCalendar();
					doj.setTimeInMillis(rs.getDate(4).getTime());
					employee.setDateOfJoining(doj);
					employee.setEmail(rs.getString(5));
					employee.setPassword(rs.getString(6));
					employee.setRePassword(rs.getString(7));
					
					employeeList.add(employee);
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} finally {
				closeStatement(stmt);
				closeResultSet(rs);
				closeConnection(con);
			}
			
			return employeeList;
		}
	}*/

}
