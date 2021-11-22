package sevlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDao;
import dto.ContactDto;


@WebServlet("/OutputProc")
public class OutputProc extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		ContactDao dao = new ContactDao();
		try {
			List<ContactDto> list = dao.selectAll();
			pw.append("<html>");
			pw.append("<head>");
			pw.append("</head>");
			pw.append("<body>");
			pw.append("<table border=1 align=center>");
			pw.append("<tr>");
			pw.append("<th colspan=3>Contacts");
			pw.append("</tr>");
			pw.append("<tr>");
			pw.append("<th>");
			pw.append("<th>Name");
			pw.append("<th>Contact");
			pw.append("</tr>");
			for(ContactDto dto : list) {
				pw.append("<tr>");
				pw.append("<td>"+dto.getSeq());
				pw.append("<td>"+dto.getName());
				pw.append("<td>"+dto.getContact());
				pw.append("</tr>");
			}
			pw.append("<tr>");
			pw.append("<th colspan=3>");
			pw.append("<form action='DeleteProc' method=get>");
			pw.append("<input type=text name=delID placeholder='Input target id to delet'>");
			pw.append("<button>Delete</button>");
			pw.append("</form>");
			pw.append("</tr>");
			
			pw.append("<form action='Update' method=get>");
			pw.append("<tr>");
			pw.append("<th colspan=3>");
			pw.append("<input type=text placeholder='Input name to update' name=name>");
			pw.append("</tr>");
			pw.append("<tr>");
			pw.append("<th colspan=3>");
			pw.append("<input type=text placeholder='Input contact to update' name=contact>");
			pw.append("</tr>");
			pw.append("<tr>");
			pw.append("<th colspan=3>");
			pw.append("<input type=text name=updateId placeholder='Input id to target'>");
			pw.append("</tr>");
			pw.append("<tr>");
			pw.append("<th colspan=3>");
			pw.append("<button>Update</button>");
			pw.append("</tr>");
			pw.append("</form>");
			
			pw.append("<tr>");
			pw.append("<th colspan=3 align=center><a href='index.html'>Back</a>");
			pw.append("</tr>");
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
