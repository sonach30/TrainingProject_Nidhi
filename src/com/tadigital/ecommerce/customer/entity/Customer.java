package com.tadigital.ecommerce.customer.entity;

public class Customer {
	// CUSTOMER FIELDS
	private int cust_id;
	private String cust_fname;
	private String cust_lname;
	private String cust_email;
	private String cust_password;
	private String cust_gender;
	private String cust_address;
	private String cust_city;
	private Long cust_zip;
	private String cust_state;
	private String cust_country;
	private int cust_number;
	private long cust_lltime;

	public Customer() {

	}

	public Customer(int cust_id, String cust_fname, String cust_lname, String cust_email, String cust_password,
			String cust_gender, String cust_address, String cust_city, Long cust_zip, String cust_state,
			String cust_country, int cust_number, Long cust_lltime) {
		// ASSIGNING VALUES TO CUSTOMER FIELDS
		this.cust_id = cust_id;
		this.cust_fname = cust_fname;
		this.cust_lname = cust_lname;
		this.cust_email = cust_email;
		this.cust_password = cust_password;
		this.cust_gender = cust_gender;
		this.cust_address = cust_address;
		this.cust_city = cust_city;
		this.cust_zip = cust_zip;
		this.cust_state = cust_state;
		this.cust_country = cust_country;
		this.cust_number = cust_number;
		this.cust_lltime = cust_lltime;
	}

	// SETTER MEHODS
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public void setCust_fname(String cust_fname) {
		this.cust_fname = cust_fname;
	}

	public void setCust_lname(String cust_lname) {
		this.cust_lname = cust_lname;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public void setCust_password(String cust_password) {
		this.cust_password = cust_password;
	}

	public void setCust_gender(String cust_gender) {
		this.cust_gender = cust_gender;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public void setCust_city(String cust_city) {
		this.cust_city = cust_city;
	}

	public void setCust_zip(Long cust_zip) {
		this.cust_zip = cust_zip;
	}

	public void setCust_state(String cust_state) {
		this.cust_state = cust_state;
	}

	public void setCust_country(String cust_country) {
		this.cust_country = cust_country;
	}

	// PHONE NUMBER
	public void setCust_number(int cust_number) {
		this.cust_number = cust_number;
	}

	// LAST LOGIN TIME OF COOKIE
	public void setCust_lltime(long cust_lltime) {
		this.cust_lltime = cust_lltime;
	}

	// GETTER METHODS
	public int getCust_id() {
		return cust_id;
	}

	public String getCust_fname() {
		return cust_fname;
	}

	public String getCust_lname() {
		return cust_lname;
	}

	public String getCust_email() {
		return cust_email;
	}

	public String getCust_password() {
		return cust_password;
	}

	public String getCust_gender() {
		return cust_gender;
	}

	public String getCust_address() {
		return cust_address;
	}

	public String getCust_city() {
		return cust_city;
	}

	public Long getCust_zip() {
		return cust_zip;
	}

	public String getCust_state() {
		return cust_state;
	}

	public String getCust_country() {
		return cust_country;
	}

	public int getCust_number() {
		return cust_number;
	}

	public long getCust_lltime() {
		return cust_lltime;
	}

};
