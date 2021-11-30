package kh.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.web.dao.MemberDAO;

@WebServlet("*.mem")
public class MemberController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();

		String cmd = uri.substring(ctxPath.length());

		MemberDAO dao = MemberDAO.getInstance();

		if (cmd.equals("/signup.mem")) {

			response.sendRedirect("member/signup.jsp");

		} else if (cmd.equals("/idCheck.mem")) {

			String id = request.getParameter("id");
			try {
				boolean result = dao.isIdExist(id);
				request.setAttribute("result", result);
				request.getRequestDispatcher("/member/idCheckView.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
