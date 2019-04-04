package com.tadigital.ecommerce.customer.servlet;

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
//import com.tadigital.service.EmployeeService;

@WebServlet("/log")
public class CustomerLoginControllerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String email = req.getParameter("em");
		String password = req.getParameter("pwd");
		String signedIn = req.getParameter("ss");

		// CALLING CUSTOMER CLASS IN ENTITY PACKAGE FOR SETTING VALUES FOR CUSTOMER
		// FIRSTNAME LASTNAME EMAIL AND PASSWORD
		Customer customer = new Customer();
		customer.setCust_email(email);
		customer.setCust_password(password);

		HttpSession session = req.getSession();

		
		// CALLING THE SERVICE METHOS TO GET STATUS FOR LOGIN
		CustomerService customerService = new CustomerService();
		boolean status = customerService.loginCustomer(customer);

		//SETTING SESSION VARIABLE WITH THE CUSTOMER DETAILS
		session.setAttribute("CUSTOMERDATA", customer);
		
		//ON SUCCESSFUL EXECUTION OF QUERY FOR LOGIN
		if (status) {
			
			//IF SIGNEDIN BOX CHECKED
			if (signedIn != null) {
				
				// CREATE NEW COOKIE
				long curLoginTime = System.currentTimeMillis();
				String cValue = email + "-" + curLoginTime;
				customer.setCust_lltime(curLoginTime);
				Cookie cookie = new Cookie("abc", cValue);
				cookie.setMaxAge(60 * 60 * 24 * 30);
				res.addCookie(cookie);
				
				CustomerService service = new CustomerService();
				boolean status1 = service.cookieLogin(customer);

				if (status1) {
					
					session.setAttribute("SUCCESS", "succesLogin");
					RequestDispatcher rd = req.getRequestDispatcher("CustomerAccount.jsp");
					
					try {
						
						rd.forward(req, res);
						
					}catch(Exception e) {
						
						e.printStackTrace();
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

				
			} else {
				
				session.setAttribute("SUCCESS", "succesSlogin");
				RequestDispatcher rd = req.getRequestDispatcher("CustomerAccount.jsp");
				
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

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String cValue = (String) session.getAttribute("COOKIEDATA");
		String[] data = cValue.split("-");
		String email = data[0];
		long lastLoginTime = Long.parseLong(data[1]);

		Customer customer = new Customer();
		customer.setCust_lltime(lastLoginTime);
		customer.setCust_email(email);

		CustomerService customerservice = new CustomerService();
		customerservice.directcookieLogin(customer); 
	}
}
