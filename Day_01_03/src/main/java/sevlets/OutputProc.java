package sevlets;

import java.io.IOException;
import java.util.ArrayList;
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
		
//		String[] arr = new String[] {"Apple","Mango","Orange"};
//		ContactDto dto = new ContactDto(100,"ABC","DEF");
//		List<ContactDto> list = new ArrayList<>();
//		list.add(new ContactDto(1,"ABC","DEF"));
//		list.add(new ContactDto(2,"GHI","JKL"));
//		list.add(new ContactDto(3,"MNO","PQR"));
//		
//		request.setAttribute("simple1", 14);
//		request.setAttribute("simple2", "Hello");
//		request.setAttribute("array", arr);
//		request.setAttribute("contact", dto);
//		request.setAttribute("list", list);
		
		ContactDao dao = ContactDao.getInstance();
		try {
			List<ContactDto> list = dao.selectAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("outputView.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
