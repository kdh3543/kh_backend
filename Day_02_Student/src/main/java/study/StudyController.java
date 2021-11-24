package study;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudyDao;
import dto.StudyDto;


@WebServlet("*.con")
public class StudyController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String cmd = uri.substring(ctxPath.length());

		StudyDao dao = StudyDao.getInstance();
		try {
			if(cmd.equals("/input.con")) {
				String name = request.getParameter("name");
				int kor = Integer.parseInt(request.getParameter("kor"));
				int eng = Integer.parseInt(request.getParameter("eng"));

				int result = dao.insert(name, kor, eng);
				response.sendRedirect("index.html");

			}else if(cmd.equals("/output.con")) {
				List<StudyDto> list	= dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputView.jsp").forward(request, response);
			}else if(cmd.equals("/delete.con")) {
				int del = Integer.parseInt(request.getParameter("id"));

				dao.delete(del);
				response.sendRedirect("output.con");
			}else if(cmd.equals("/update.con")) {
				int id = Integer.parseInt(request.getParameter("updateId"));
				String name = request.getParameter("name");
				int kor = Integer.parseInt(request.getParameter("kor")); 
				int eng = Integer.parseInt(request.getParameter("eng"));

				dao.update(id, name, kor, eng);
				response.sendRedirect("output.con");
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
