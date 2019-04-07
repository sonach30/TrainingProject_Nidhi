package com.tadigital.ecommerce.vendor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tadigital.ecommerce.vendor.entity.Vendor;


public class VendorDao extends Dao {

	//EXTRACTING AND ASSIGNING DETAILS FROM customer_details TABLE FOR ENTERED EMAIL AND PASSWORD
	public boolean selectVendorByEmailAndPassword(Vendor vendor) {
		boolean status = false;
		
		//ESTABLISHING DATABSE CONNECTION
		Connection con = openConnection();
		Statement stmt = openStatement(con);
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM vendor_details WHERE vendor_email = '" + vendor.getVendor_email() + "' AND vendor_password = '" + vendor.getVendor_password() + "'";
			rs = stmt.executeQuery(sql);
			
			//SETTING VALUES FOR CUSTOMER ID FIRSTNAME AND LASTNAME 
			if(rs.next()) {
				status = true;
				
				//SETTING THE VALUES IN CUSTOMER ENTITY FROM THE DATABASE FOR CURRENT USER
				vendor.setVendor_id(rs.getInt(1));
				vendor.setVendor_fname(rs.getString(2));
				vendor.setVendor_lname(rs.getString(3));
				
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
	
	//SELECT QUERY FOR COOKIE
	public boolean updateCookieTime(Vendor vendor) {
		boolean status = false;
		
		Connection con = openConnection();
		Statement stmt = openStatement(con);
		
		try {
			
			//UPDATE customer_information SET cust_gender=customer.getGender(), cust_address=customer.getAddress(), cust_city=customer.getCity,  cust_zip=customer.getZip(),
			//cust_state=customer.getState(), cust_country=customer.getCountry
			String sql = "UPDATE vendor_details SET vendor_lltime = '" + vendor.getVendor_lltime() +"' WHERE vendor_email='"+vendor.getVendor_email()+"'";
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
	public boolean selectCookie(Vendor vendor) {
		
		boolean status = false;
		
		Connection con = openConnection();
		Statement stmt = openStatement(con);
		
		try {	
			//UPDATE customer_information SET cust_gender=customer.getGender(), cust_address=customer.getAddress(), cust_city=customer.getCity,  cust_zip=customer.getZip(),
			//cust_state=customer.getState(), cust_country=customer.getCountry
			String sql = "SELECT * FROM vendor_details WHERE vendor_email = '" + vendor.getVendor_email() + "' AND vendor_password = '" + vendor.getVendor_password() + "'";
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