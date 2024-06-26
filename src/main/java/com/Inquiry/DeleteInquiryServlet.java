package com.Inquiry;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteinquiryDetails
 */
@WebServlet("/DeleteInquiryServlet")
public class DeleteInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("inqId");//get the Id of the required database entry
		boolean isTrue;
		
		isTrue=inquiryDB.deleteInquiry(id);//calls the deleteinquiry method in inquiryDb and return the boolean value
		
		if(isTrue==true) {
			RequestDispatcher disp = request.getRequestDispatcher("createInquiry.jsp");//navigate
			disp.forward(request,response);
			
		}
		else {
			List<inquiry> inqDetails = inquiryDB.getInquiryDetails(id);
			request.setAttribute("inqDetails", inqDetails);
			
			RequestDispatcher disp = request.getRequestDispatcher("inquiryDetails.jsp");//navigate
			disp.forward(request,response);
		}
		
	}

}
