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
 * Servlet implementation class CustomerExceptionContrllerServlet
 */
@WebServlet("/CustomerException")
public class CustomerExceptionContrllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerExceptionContrllerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*SETTING THE EXCEPTION THAT OCCURED FOR CUSTOMER TO SESSION VARIABLE*/
		HttpSession session = request.getSession();
		String exception = (String) session.getAttribute("CUSTOMEREXCEPTION");

		Customer customer = new Customer();

		CustomerService service = new CustomerService();
		boolean status = service.exceptionCustomer(customer, exception);
		
		if (status) {
			
			/*SETTING SESSION VARIABLE FOR SUCCESFUL LOGGING EXCEPTION FOR CUSTOMER*/
			session.setAttribute("SUCCESS", "successerror");
			RequestDispatcher rd = request.getRequestDispatcher("MyErrorPage.jsp");
			
			try {
				
				rd.forward(request, response);
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}

		} else {
			
			/*SETTING SESSION VARIABLE FOR UNSUCCESFUL LOGGING EXCEPTION FOR CUSTOMER*/
			session.setAttribute("SUCCESS", "failerror");
			RequestDispatcher rd = request.getRequestDispatcher("SignInSignUpForms.jsp");
			try {
				
				rd.forward(request, response);
			}catch(Exception e) {
				
				e.printStackTrace();
				
			}
		}
	}

}
