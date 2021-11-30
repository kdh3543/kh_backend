package kh.web.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import kh.web.dao.MemberDao;
import kh.web.dto.MemberDto;
import kh.web.utils.EncryptionUtils;

@WebServlet("*.con")
public class MembersController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = uri.substring(contextPath.length());
		request.setCharacterEncoding("UTF-8");
		
		MemberDao dao = MemberDao.getInstance();

		try {
			if(cmd.equals("/signup.con")) {
				response.sendRedirect("member/signup.jsp");
			}else if(cmd.equals("/idCheck.con")) {
				String id = request.getParameter("id");

				try {
					boolean result = dao.isIdExist(id);
					request.setAttribute("result", result);
					request.getRequestDispatcher("/member/idCheckView.jsp").forward(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}

			}else if(cmd.equals("/insert.con")) {
				
				String id = request.getParameter("id");
				String pw = EncryptionUtils.pwdEncrypt(request.getParameter("pwd"));
				String name = request.getParameter("name");
				String phone = request.getParameter("select")+request.getParameter("num1")+request.getParameter("num2");
				String email = request.getParameter("email");
				String zipcode = request.getParameter("postcode");
				String address1 = request.getParameter("adrs1");
				String address2 = request.getParameter("adrs2");
				
				MemberDto dto = new MemberDto(id,pw,name,phone,email,zipcode,address1,address2,null);
				dao.insert(dto);
				response.sendRedirect("/index.jsp");
				
			}else if(cmd.equals("/login.con")) {
				String id = request.getParameter("id");
				String pw = EncryptionUtils.pwdEncrypt(request.getParameter("pw"));
				
				boolean result = dao.login(id, pw);
				
				if(result) { // 로그인에 성공했을 경우
					HttpSession session = request.getSession(); // 서버쪽 세션 금고에
					session.setAttribute("loginId", id); //loginId라는 키값으로 사용자 Id를 저장
				}
				response.sendRedirect("/index.jsp");
			}else if(cmd.equals("/logout.con")) {
				//request.getSession().invalidate();
				request.getSession().removeAttribute("loginId");
				response.sendRedirect("/index.jsp");
			}else if(cmd.equals("/leave.con")) {
				int result = dao.delete(request.getSession().getAttribute("loginId"));
				request.getSession().invalidate(); // 세션에서 삭제
				response.sendRedirect("/index.jsp");
			}else if(cmd.equals("/mypage.con")) {
				MemberDto dto = dao.selectAll((String)request.getSession().getAttribute("loginId"));
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("/member/mypageView.jsp").forward(request, response);
			}else if(cmd.equals("/update.con")) {
				String id = (String)request.getSession().getAttribute("loginId");
				String pw = EncryptionUtils.pwdEncrypt(request.getParameter("pwd"));
				String name = request.getParameter("name");
				String phone = request.getParameter("num");
				String email = request.getParameter("email");
				String zipcode = request.getParameter("postcode");
				String address1 = request.getParameter("adrs1");
				String address2 = request.getParameter("adrs2");
				System.out.println(id);
				System.out.println(pw);
				System.out.println(phone);
				MemberDto dto = new MemberDto(id,pw,name,phone,email,zipcode,address1,address2,null);
				
				dao.update(dto);
				response.sendRedirect("/index.jsp");
			}else if(cmd.equals("/index.con")) {
				response.sendRedirect("/index.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
