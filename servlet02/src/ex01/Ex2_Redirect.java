package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex2_Redirect extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("첫번째 페이지");
		String msg = "hello";

		req.setAttribute("msg", msg);
		resp.sendRedirect("second");

		PrintWriter out = resp.getWriter();
		out.println("page first");
		out.println("<hr>");
		out.close();
	}

}
