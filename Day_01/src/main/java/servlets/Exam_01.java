package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Exam_01") //annotation(기능을 포함하는 주석) //이 주소를 찾아오면 이 서블릿으로 보내라라는 명령
public class Exam_01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String currentTime = new Date().toString();
		
		PrintWriter pw = response.getWriter();
		pw.append(currentTime);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		System.out.println("클라이언트가 post 방식으로 request를 발송함");
	}
}
