package demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.model.HelloModel;
import demo.model.MemberModel;
import demo.model.Model;
// ����û�� ����Ѵ�.
@WebServlet("*.bit")
public class ControllServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doProcess(req, resp);
	}
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		// ��û�� �м� : http://localhost/model2Demo01/index.bit?cmd=memlist
		String cmd = req.getParameter("cmd");
		// �������� ������ ��Ʈ���� �۾��� �Ϸ� , ���յ� �����ϰ� ���� 
		Model md = null;
		if(cmd.equals("hello")) {
			md = new HelloModel();
		}else if(cmd.equals("mlist")) {
			md = new MemberModel();
		}
		String view = md.execute(req, resp);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
}
