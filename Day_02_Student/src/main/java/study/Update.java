package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudyDao;

@WebServlet("/Update")
public class Update extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("updateId"));
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor")); 
		int eng = Integer.parseInt(request.getParameter("eng"));
		StudyDao dao = StudyDao.getInstance();
		
		try {
			dao.update(id, name, kor, eng);
			response.sendRedirect("Output");
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
