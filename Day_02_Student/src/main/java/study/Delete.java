package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudyDao;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int del = Integer.parseInt(request.getParameter("id"));
		StudyDao dao = new StudyDao();
		
		try {
			dao.delete(del);
			response.sendRedirect("Output");
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
