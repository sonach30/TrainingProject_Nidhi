package com.tadigital.ecommerce.vendor.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tadigital.ecommerce.customer.entity.Customer;
import com.tadigital.ecommerce.customer.service.CustomerService;
import com.tadigital.ecommerce.vendor.entity.Vendor;
import com.tadigital.ecommerce.vendor.service.VendorService;

/**
 * Servlet implementation class VendorLoginControllerServlet
 */
@WebServlet("/login")
public class VendorLoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorLoginControllerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String cValue = (String) session.getAttribute("COOKIEDATA");
		String[] data = cValue.split("-");
		String email = data[0];
		long lastLoginTime = Long.parseLong(data[1]);

		Vendor vendor = new Vendor();
		vendor.setVendor_lltime(lastLoginTime);
		vendor.setVendor_email(email);

		VendorService vendorservice = new VendorService();
		Boolean status = vendorservice.directcookieLogin(vendor);
		
		//SEETING SESSION VARIABLE AS YES IF COOKIE ALREADY EXISTS
		session.setAttribute("ALREADYlOGIN","YES");
		
		System.out.println(status);
		
		if(status) {
			RequestDispatcher rd = req.getRequestDispatcher("Vendor_dashboard.jsp");
			try {
					rd.forward(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("MyErrorPage.jsp");
			try {
					rd.forward(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String email = req.getParameter("em");
		String password = req.getParameter("pwd");
		String signedIn = req.getParameter("ss");

		// CALLING CUSTOMER CLASS IN ENTITY PACKAGE FOR SETTING VALUES FOR CUSTOMER
		// FIRSTNAME LASTNAME EMAIL AND PASSWORD
		Vendor vendor = new Vendor();
		vendor.setVendor_email(email);
		vendor.setVendor_password(password);

		HttpSession session = req.getSession();

		
		// CALLING THE SERVICE METHOS TO GET STATUS FOR LOGIN
		VendorService vendorService = new VendorService();
		boolean status = vendorService.loginVendor(vendor);

		//SETTING SESSION VARIABLE WITH THE CUSTOMER DETAILS
		session.setAttribute("VENDORDATA", vendor);
		
		//ON SUCCESSFUL EXECUTION OF QUERY FOR LOGIN
		if (status) {
			
			session.setAttribute("ALREADYlOGIN","YES");
			
			//IF SIGNEDIN BOX CHECKED
			if (signedIn != null) {
				
				// CREATE NEW COOKIE
				long curLoginTime = System.currentTimeMillis();
				String cValue = email + "-" + curLoginTime;
				vendor.setVendor_lltime(curLoginTime);
				Cookie cookie = new Cookie("abc", cValue);
				cookie.setMaxAge(60 * 60 * 24 * 30);
				res.addCookie(cookie);
				
				VendorService service = new VendorService();
				boolean status1 = service.cookieLogin(vendor);

				if (status1) {
					
					session.setAttribute("SUCCESS", "succesLogin");
					RequestDispatcher rd = req.getRequestDispatcher("Vendor_dashboard.jsp");
					
					try {
						
						rd.forward(req, res);
						
					}catch(Exception e) {
						
						e.printStackTrace();
					}
					
				} else {
				
					session.setAttribute("SUCCESS", "faillogin");
					RequestDispatcher rd = req.getRequestDispatcher("VendorSignIn.jsp");
					try {
						
						rd.forward(req, res);
						
					}catch(Exception e) {
						
						e.printStackTrace();
					}
				}

				
			} else {
				
				session.setAttribute("SUCCESS", "succesSlogin");
				RequestDispatcher rd = req.getRequestDispatcher("Vendor_dashboard.jsp");
				
				try {
					
					rd.forward(req, res);
					
				}catch(Exception e) {
					
					e.printStackTrace();
				}

			}
		} else {
			
			session.setAttribute("SUCCESS", "faillogin");
			RequestDispatcher rd = req.getRequestDispatcher("SignInSignUpForms.jsp");
			
			try {
				
				rd.forward(req, res);
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
		}

	}


}
