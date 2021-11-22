package study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudyDao;
import dto.StudyDto;

@WebServlet("/Output")
public class Output extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		StudyDao dao =new StudyDao();
		try {
			List<StudyDto> list	= dao.selectAll();
			pw.append("<html>");
			pw.append("<head>");
			pw.append("</head>");
			pw.append("<body>");
			pw.append("<table border=1 align=center");
			pw.append("<tr>");
			pw.append("<th colspan=6 align=center>Student Score");
			pw.append("</tr>");
			pw.append("<tr>");
			pw.append("<td>");
			pw.append("<td>name");
			pw.append("<td>kor");
			pw.append("<td>eng");
			pw.append("<td>sum");
			pw.append("<td>avg");
			pw.append("</tr>");
			for(StudyDto dto : list) {
				pw.append("<tr>");
				pw.append("<td>"+dto.getId());
				pw.append("<td>"+dto.getName());
				pw.append("<td>"+dto.getKor());
				pw.append("<td>"+dto.getEng());
				pw.append("<td>"+(dto.getKor()+dto.getEng()));
				pw.append("<td>"+(dto.getKor()+dto.getEng())/2.0);
				pw.append("</tr>");
			}
			pw.append("<tr>");
			pw.append("<td colspan=6 align=center><a href='index.html'>Back");
			pw.append("</tr>");
			pw.append("<form action=Delete method=get>");
			pw.append("<tr>");
			pw.append("<td colspan=6 align=center>Delete");
			pw.append("</tr>");
			pw.append("<tr>");
			pw.append("<td colspan=4><input type=text placeholder='input id to delete' name=id>");
			pw.append("<td colspan=2><button>Delete</button>");
			pw.append("</tr>");
			pw.append("</form>");
			pw.append("<form action=Update method=get>");
			pw.append("<tr>");
			pw.append("<td colspan=6 align=center>Update");
			pw.append("</tr>");
			pw.append("<tr>");
			pw.append("<td colspan=4><input type=text placeholder='input name to update' name=name>");
			pw.append("<td colspan=2 rowspan=4><button>update</button>");
			pw.append("</tr>");
			pw.append("<tr>");
			pw.append("<td colspan=4><input type=text placeholder='input kor to update' name=kor>");
			pw.append("</tr>");
			pw.append("<tr>");
			pw.append("<td colspan=4><input type=text placeholder='input eng to update' name=eng>");
			pw.append("</tr>");
			pw.append("<tr>");
			pw.append("<td colspan=4><input type=text placeholder='input id to target' name=updateId>");
			pw.append("</tr>");
			pw.append("</form>");
			pw.append("</table>");
			pw.append("</body>");
			pw.append("</html>");
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
