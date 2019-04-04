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

/**
 * Servlet implementation class CustomerAccountControllerServlet
 */
@WebServlet("/CustomerAccount")
public class CustomerAccountControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerAccountControllerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Customer customer = new Customer();
		customer = (Customer) session.getAttribute("CUSTOMERDATA");

		String gender = request.getParameter("f6");
		String address = request.getParameter("f7");
		String city = request.getParameter("f8");
		Long zip = Long.parseLong(request.getParameter("f9"));
		String state = request.getParameter("f10");
		String country = request.getParameter("f11");
		Integer contact = Integer.parseInt(request.getParameter("f12"));

		customer.setCust_gender(gender);
		customer.setCust_address(address);
		customer.setCust_city(city);
		customer.setCust_zip(zip);
		customer.setCust_state(state);
		customer.setCust_country(country);
		customer.setCust_number(contact);

		CustomerService customerService = new CustomerService();
		boolean status = customerService.updateCustomer(customer);

		if (status) {

			/* SETTING CUSTOMER DATA INTO SESSION VARIABLE FORM CUSTOMER ENTITY */
			session.setAttribute("CUSTOMERFULLDATA", customer);

			/* SETTING SESSION VARIABLE FOR SUCCESSFUL UPDATE */
			session.setAttribute("SUCCESS", "successupdate");
			RequestDispatcher rd = request.getRequestDispatcher("CustomerAccount.jsp");

			try {
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			/* SETTING SESSION VARIABLE FOR UNSUCCESSFUL UPDATE */
			session.setAttribute("SUCCESS", "failupdate");
			RequestDispatcher rd = request.getRequestDispatcher("CustomerAccount.jsp");

			try {
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}
}
