package com.tadigital.ecommerce.vendor.entity;

public class Vendor {
	
	//VENDOR FIELDS
	private int vendor_id;
	private String vendor_fname;
	private String vendor_lname;
	private String vendor_email;
	private String vendor_password;
	private long vendor_lltime;
	
	public Vendor() {
		
	}
	
	public Vendor(int vendor_id, String vendor_fname, String vendor_lname, String vendor_email, String vendor_password, long vendor_lltime) {
	
		// ASSIGNING VALUES TO CUSTOMER FIELDS
		this.vendor_id = vendor_id;
		this.vendor_fname = vendor_fname;
		this.vendor_lname = vendor_lname;
		this.vendor_email = vendor_email;
		this.vendor_password = vendor_password;
		this.vendor_lltime = vendor_lltime;
	}
	
	   // SETTER MEHODS
		public void setVendor_id(int vendor_id) {
			this.vendor_id = vendor_id;
		}
		public void setVendor_fname(String vendor_fname) {
			this.vendor_fname = vendor_fname;
		}
		public void setVendor_lname(String vendor_lname) {
			this.vendor_lname = vendor_lname;
		}
		public void setVendor_email(String vendor_email) {
			this.vendor_email = vendor_email;
		}
		public void setVendor_password(String vendor_password) {
			this.vendor_password = vendor_password;
		}
		public void setVendor_lltime(long vendor_lltime) {
			this.vendor_lltime = vendor_lltime;
		}
		
		// GETTER METHODS
		public int getVendor_id() {
			return vendor_id;
		}
		public String getVendor_fname() {
			return vendor_fname;
		}
		public String getVendor_lname() {
			return vendor_lname;
		}
		public String getVendor_email() {
			return vendor_email;
		}
		public String getVendor_password() {
			return vendor_password;
		}
		public long getVendor_lltime() {
			return vendor_lltime;
		}
}

