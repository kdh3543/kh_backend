package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet01")
public class Servlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name"); 
		String message = request.getParameter("message"); // --> 서블릿이 값을 꺼낼 때 request에서의 name값을 통해 꺼내옴
		 PrintWriter pw = response.getWriter();
		 pw.append("<html>");
		 pw.append("<body>");
		 pw.append("<font color=pink size=20>");
		 pw.append(name + "'s message: " + message);
		 pw.append("</font>");
		 pw.append("</body>");
		 pw.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
