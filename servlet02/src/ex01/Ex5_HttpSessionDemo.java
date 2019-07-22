package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/loginAccess")
public class Ex5_HttpSessionDemo extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		String uid = req.getParameter("uid");
		String pwd = req.getParameter("pwd");
		System.out.println(uid+":"+pwd);
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html; charset=euc-kr");
		//���� data
		String dbId = "admin";
		String dbPwd = "12";
		//���� �Ǿ����� ������ ���� �����ϱ� ���ؼ�
		//servletSession�� ���� ����
		if(dbId.equals(uid) && dbPwd.equals(pwd)) {
			//HttpSession ��ü�� ���
			HttpSession session = req.getSession();
			session.setAttribute("uid", uid);
			resp.sendRedirect("indexServlet");
			
		}else {
			out.println("<script>");
			out.println(" alert('Error')");
			out.println(" location='loginForm.html'");
			out.println("</script>");
			//resp.sendRedirect("loginForm.html");
		}
	}
}
