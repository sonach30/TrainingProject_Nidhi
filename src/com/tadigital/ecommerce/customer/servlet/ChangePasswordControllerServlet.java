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
 * Servlet implementation class PasswordChangeController
 */
@WebServlet("/ChangePassword")
public class ChangePasswordControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordControllerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Customer customer = new Customer();

		HttpSession ses = request.getSession(); // Session object required?
		customer = (Customer) ses.getAttribute("CUSTOMERDATA");

		String oldPasswordForm = request.getParameter("f1");
		String newPasswordForm = request.getParameter("f2");
		String newpasswordRetypeForm = request.getParameter("f3");
		String currPassword = customer.getCust_password();

		// COMPARING THE OLD PASSWORD WITH PASSWORD FROM DATABASE AND NEW AND RETYPE
		// PASSWORD
		if (currPassword.equals(oldPasswordForm) && newPasswordForm.equals(newpasswordRetypeForm)) {

			customer.setCust_password(newPasswordForm);

			// GETTING THE STATUS OF UPDATE QUERY VIA CUSTOMERSERVICE
			CustomerService customerService = new CustomerService();
			boolean status = customerService.updatePassword(customer);

			if (status) {

				ses.setAttribute("SUCCESS", "successpass");
				RequestDispatcher rd = request.getRequestDispatcher("CustomerAccount.jsp");
				rd.forward(request, response);

			} else {

				ses.setAttribute("SUCCESS", "failpass");
				RequestDispatcher rd = request.getRequestDispatcher("CustomerAccount.jsp");

				try {

					rd.forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else {

			ses.setAttribute("SUCCESS", "failpass");
			RequestDispatcher rd = request.getRequestDispatcher("CustomerAccount.jsp");
			try {

				rd.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
