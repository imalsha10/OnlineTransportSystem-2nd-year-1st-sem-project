package com.Inquiry;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateInquiryServlet")
public class UpdateInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
  

	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("inqId");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
	
		boolean isTrue;
		
		isTrue = inquiryDB.updateinquiry(id, subject, message);
		
		if(isTrue == true) {
			
			List<inquiry> inquiryList = inquiryDB.getInquiryDetails(id);
			request.setAttribute("inquiryList", inquiryList);
			
			RequestDispatcher dis = request.getRequestDispatcher("inqde");
			dis.forward(request, response);
		}
		else{
			
			List<inquiry> inquiryList = inquiryDB.getInquiryDetails(id);
			request.setAttribute("inquiryList", inquiryList);
			
			RequestDispatcher dis = request.getRequestDispatcher("inquiryDetails.jsp");
			dis.forward(request, response);
		}
	}

}
