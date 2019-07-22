package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/serverlet02")

public class Ex3_initServlet extends HttpServlet {
	private String email, tel;
	private String company;

	@Override
	public void init() throws ServletException {
		email = getServletConfig().getInitParameter("email");//ServletConfig <=> InitParameter
		tel = getServletConfig().getInitParameter("tel");
		company = getServletConfig().getInitParameter("company");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=euc-kr");
		PrintWriter out = resp.getWriter();
		out.println("<p>Email :");
		out.println(email);
		out.println("</p>");
		out.println("<p>Tel :");
		out.println(tel);
		out.println("</p>");
		out.println("<hr>");
		out.println("<p>Company :");
		out.println(company);
		out.println("</p>");
	}
}
