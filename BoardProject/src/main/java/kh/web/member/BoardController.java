package kh.web.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.web.dao.BoardDao;
import kh.web.dto.BoardDto;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = uri.substring(contextPath.length());
		request.setCharacterEncoding("UTF-8");
		BoardDao dao = BoardDao.getInstance();
		
		try {
			if(cmd.equals("/toboard.board")) {
				
				List<BoardDto> list = dao.selectAll();
				
				request.setAttribute("list", list);
				request.getRequestDispatcher("/board/toboardView.jsp").forward(request, response);
				
			}else if(cmd.equals("/boardWrite.board")) {
				response.sendRedirect("/board/boardWriteView.jsp");
			}else if(cmd.equals("/writeSuccess.board")) {
				String writer= (String)request.getSession().getAttribute("loginId");
				String title = request.getParameter("title");
				String contents = request.getParameter("contents");
				BoardDto dto = new BoardDto(0,writer, title, contents,null,0);
				
				dao.insert(dto);
				response.sendRedirect("/toboard.board");
			}else if(cmd.equals("/detail.board")) {
				int seq = Integer.parseInt(request.getParameter("seq"));
				BoardDto dto = dao.selectBySeq(seq);
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("/board/detail.jsp").forward(request, response);
				dao.addCount(seq);
			}else if(cmd.equals("/delete.board")) {
				int seq = Integer.parseInt(request.getParameter("seq"));
				int result = dao.deleteBySeq(seq);
				request.setAttribute("result", result);
				request.getRequestDispatcher("/toboard.board").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
