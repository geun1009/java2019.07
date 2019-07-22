package mymem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("signservlet")
public class SignIndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=euc-kr");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession(false);
		
		if (session != null) {
			String sessionId = session.getId();
			System.out.println("세션아이디:" + sessionId);
			String uid = (String) session.getAttribute("uid");
			out.println(uid + "님 반갑습니다.");
			out.println("<a href='logout'>로그아웃</a>");

		} else {
			out.println("<a href=''>회원가입</a> | ");
			out.println("<a href='loginForm.html'>로그인</a>  ");

		}
	}
}
