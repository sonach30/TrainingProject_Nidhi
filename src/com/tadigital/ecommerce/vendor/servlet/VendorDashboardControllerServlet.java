package com.tadigital.ecommerce.vendor.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VendorDashboardControllerServlet
 */
@WebServlet("/dashboard")
public class VendorDashboardControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorDashboardControllerServlet() {
        super();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("add_button") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("NewProduct.jsp");
			try {
				rd.forward(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("ProductDashboard.jsp");
			try {
				rd.forward(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			
	}

}
