package sevlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDao;
import dto.ContactDto;


@WebServlet("*.con")
public class ContactController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		System.out.println("사용자가 요청한 주소: "+uri);

		String ctxPath = request.getContextPath();
		System.out.println("프로젝트명: "+ctxPath);

		String cmd = uri.substring(ctxPath.length());
		System.out.println("사용자가 요청한 기능: "+cmd);

		ContactDao dao = ContactDao.getInstance();
		try {
			if(cmd.equals("/output.con")) {
				List<ContactDto> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputView.jsp").forward(request, response);
				
			}else if(cmd.equals("/input.con")) {
				String name = request.getParameter("name");
				String contact = request.getParameter("contact");
				int result = dao.insert(name,contact);
				response.sendRedirect("index.html");
				
			}else if(cmd.equals("/Update.con")) {
				int id = Integer.parseInt(request.getParameter("updateId"));
				String name = request.getParameter("name");
				String contact = request.getParameter("contact");	
				int result = dao.update(id,name,contact);
				
				response.sendRedirect("output.con");
			}else if(cmd.equals("/Delete.con")) {
				int delSeq = Integer.parseInt(request.getParameter("delID"));
				int result = dao.delete(delSeq);
				response.sendRedirect("output.con");
			}else if(cmd.equals("/inputForm.con")) {
				response.sendRedirect("inputForm.html");
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
