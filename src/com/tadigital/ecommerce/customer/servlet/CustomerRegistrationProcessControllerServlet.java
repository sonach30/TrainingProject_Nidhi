package com.tadigital.ecommerce.customer.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.websocket.Session;

import com.tadigital.ecommerce.customer.entity.Customer;
import com.tadigital.ecommerce.customer.service.CustomerService;

//import com.tadigital.service.EmployeeService;
@WebServlet("/register")
public class CustomerRegistrationProcessControllerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("em");
		String password = req.getParameter("pwd");

		// GETTING FIRSTNAME AND LASTNAME
		String lastName = "";
		String firstName = "";
		if (name.split("\\w+").length > 1) {
			int len = name.length();
			firstName = name.substring(0, name.indexOf(' '));
			lastName = name.substring(name.indexOf(' ') + 1, len);
		}

		// CALLING CUSTOMER CLASS IN ENTITY PACKAGE FOR SETTING VALUES FOR CUSTOMER
		// FIRSTNAME LASTNAME EMAIL AND PASSWORD
		Customer customer = new Customer();
		customer.setCust_fname(firstName);
		customer.setCust_lname(lastName);
		customer.setCust_email(email);
		customer.setCust_password(password);

		// CALLING CUSTOMERSERVICE CLASS FOR CHECKING STATUS
		CustomerService customerService = new CustomerService();
		boolean status = customerService.registerCustomer(customer);

		// STATUS==TRUE
		if (status) {
			HttpSession session = req.getSession();
			session.setAttribute("SUCCESS", "successregister");
			RequestDispatcher rd = req.getRequestDispatcher("SignInSignUpForms.jsp");
			try {

				rd.forward(req, resp);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			HttpSession session = req.getSession();

			session.setAttribute("SUCCESS", "failregister");
			RequestDispatcher rd = req.getRequestDispatcher("SignInSignUpForms.jsp");
			try {
				rd.forward(req, resp);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}
}