package member;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dto.MemberDto;

@WebServlet("*.mem")
public class Member extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String cmd = uri.substring(ctxPath.length());
		request.setCharacterEncoding("UTF-8");
		MemberDao dao = MemberDao.getInstance();
		try {
			if(cmd.equals("/signup.mem")) {
				response.sendRedirect("/member/signup.jsp");
			}else if(cmd.equals("/idCheck.mem")) {
				String id = request.getParameter("id");
				boolean result = dao.idIsExist(id);
				request.setAttribute("result", result);
				request.getRequestDispatcher("/member/idCheckView.jsp").forward(request, response);
			}else if(cmd.equals("/insert.mem")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String phone = request.getParameter("select")+request.getParameter("num1")+request.getParameter("num2");
				String email = request.getParameter("email");
				String zipcode = request.getParameter("zipcode");
				String addr1 = request.getParameter("addr1");
				String addr2 = request.getParameter("addr2");
				Date date = null;
				
				MemberDto dto = new MemberDto(id,pw,name,phone,email,zipcode,addr1,addr2,date);
				dao.insert(dto);
				response.sendRedirect("/member/signup.jsp");
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
