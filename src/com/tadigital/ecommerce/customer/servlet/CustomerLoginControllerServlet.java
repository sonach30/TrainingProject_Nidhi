package com.tadigital.ecommerce.customer.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

		// CALLING CUSTOMER CLASS IN ENTITY PACKAGE FOR SETTING VALUES FOR CUSTOMER
		// FIRSTNAME LASTNAME EMAIL AND PASSWORD
		Customer customer = new Customer();
		customer.setCust_email(email);
		customer.setCust_password(password);

		// CALLING THE SERVICE METHOS TO GET STATUS FOR LOGIN
		CustomerService customerService = new CustomerService();
		boolean status = customerService.loginCustomer(customer);
		
		
		HttpSession session = req.getSession();
		session.setAttribute("CUSTOMERDATA", customer);
		if (status) {
			HttpSession ses = req.getSession();
			ses.setAttribute("SUCCESS", 2);

			RequestDispatcher rd = req.getRequestDispatcher("CustomerAccount.jsp");
			rd.forward(req, res);
		} else {
			HttpSession ses = req.getSession();
			ses.setAttribute("SUCCESS", -2);

			RequestDispatcher rd = req.getRequestDispatcher("SignInSignUpForms.jsp");
			rd.forward(req, res);
		}

	}
}
