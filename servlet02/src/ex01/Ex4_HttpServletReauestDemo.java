package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reqdemo")
public class Ex4_HttpServletReauestDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MyMethod(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyMethod(req, resp);
	}

	private void MyMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=euc-kr");
		System.out.println("getRequestURL : "+req.getRequestURL());
		System.out.println("ip :"+req.getRemoteAddr());
		System.out.println("path :"+req.getContextPath());
		System.out.println("contnentType : "+req.getContentType());
		System.out.println("method : "+req.getMethod());
		PrintWriter out = resp.getWriter();
		out.println("<img src='img/iu.jpg' style='width:150px;'>");
		
	}
	
}
