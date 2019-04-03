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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = new Customer();
		customer=(Customer)session.getAttribute("CUSTOMERDATA");
		String email=customer.getCust_email();
		String password=customer.getCust_password();
		String gender=request.getParameter("f6");
		String address=request.getParameter("f7");
		String city = request.getParameter("f8");
		long zip = Long.parseLong(request.getParameter("f9"));
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
		if(status) {
			/*HttpSession session = request.getSession();*/
			session.setAttribute("CUSTOMERFULLDATA", customer);
			session.setAttribute("SUCCESS", 3);
			RequestDispatcher rd = request.getRequestDispatcher("CustomerAccount.jsp");
			System.out.println("Details Updated Succesfull");
			rd.forward(request, response);
		} else {
			HttpSession ses = request.getSession();
			session.setAttribute("SUCCESS", -3);
			RequestDispatcher rd = request.getRequestDispatcher("CustomerAccount.jsp");
			System.out.println("Error");
			//Write Error Message on the screen
			rd.forward(request, response);
		}
		
		doGet(request, response);
	}
}
