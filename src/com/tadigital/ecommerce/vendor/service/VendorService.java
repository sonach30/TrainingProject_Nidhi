package com.tadigital.ecommerce.vendor.service;

import com.tadigital.ecommerce.customer.dao.CustomerDao;
import com.tadigital.ecommerce.customer.entity.Customer;
import com.tadigital.ecommerce.vendor.dao.VendorDao;
import com.tadigital.ecommerce.vendor.entity.Vendor;

public class VendorService {
	VendorDao vendorDao = new VendorDao();
	
	// CHECKING THE STATUS FOR SELECT QUERY FOR CHECKING THE LOGIN PROCESS SUCCESS
	public boolean loginVendor(Vendor vendor) {
		
		VendorDao vendorDao = new VendorDao();
		
		// GETTING STATUS FOR SELECT QUERY FROM CUSTOMERDAO
		boolean status = vendorDao.selectVendorByEmailAndPassword(vendor);

		// RETURNING THE STATUS
		return status;
	}
	
		// CREATING COOKIE FOR LOGIN
		public boolean cookieLogin(Vendor vendor) {
			boolean status = vendorDao.updateCookieTime(vendor);
			return status;
		}

		
		// CHECKING COOKIE LAST LOGIN TIME
		public boolean directcookieLogin(Vendor vendor) {
			boolean status = vendorDao.selectCookie(vendor);
			return status;
		}

}
