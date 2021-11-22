package sevlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDao;


@WebServlet("/Servlet01")
public class Servlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactDao dao = new ContactDao();
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");

		try {
			dao.insert(name,contact);
			response.sendRedirect("index.html");
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}

		//		//pw.append(name+" 's Contact : "+contact);
		//		System.out.println(name+" 님의 연락처 : "+contact);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
