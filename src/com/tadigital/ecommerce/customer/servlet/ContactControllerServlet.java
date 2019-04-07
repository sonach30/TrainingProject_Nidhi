package com.tadigital.ecommerce.customer.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tadigital.ecommerce.customer.entity.Customer;
import com.tadigital.ecommerce.customer.service.CustomerService;

/**
 * Servlet implementation class ContactControllerServlet
 */
@WebServlet("/Contact")
public class ContactControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String RequestDispatcher = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactControllerServlet() {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("hello\n");
		RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
		try {
				rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String em = request.getParameter("em");
		String fn = request.getParameter("fn");
		String ln = request.getParameter("ln");
		String sub = request.getParameter("sub");
		String mes = request.getParameter("mes");
		
		System.out.println(em + fn + ln + sub + mes);
		
		CustomerService service = new CustomerService();
		boolean status = service.contactQuery(fn,ln,mes,sub,em);
		
		if(status) {
			
			HttpSession session = request.getSession();
			session.setAttribute("SUCCESS", "successsendquery");
			
			//DIRECTING TO INDEX PAGE ON SUCCESSFUL SEND EMAIL
			RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
			try {
				rd.forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("SUCCESS", "unsuccesssendquery");
			
			//DIRECTING TO INDEX PAGE ON SUCCESSFUL SEND EMAIL
			RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
			try {
				rd.forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}