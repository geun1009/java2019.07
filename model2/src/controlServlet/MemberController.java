package controlServlet;

import java.io.IOException;


import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberModel;
import model.Model;
import model.hello;

//��� ��û�� ����Ѵ�.
@WebServlet("*.bit")
public class MemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		//��û�� �м� http://localhost/model2Demo/index.bit?cmd=menList
		String cmd = req.getParameter("cmd");
		//�������� ������ ��Ʈ�ѷ� �۾��� �Ϸ�, ���յ� �����ϰ� ����
		Model md = null;
		
		if(cmd.equals("hello")) {
			md = new hello();
		}else if(cmd.equals("mList")) {
			md = new MemberModel();
		}
		//!!!!!!!������!!!!!!!���� servlet�� ó���ϱ� ���ؼ� ����������
		String view = md.execute(req, resp);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req,resp);
		
		
		
		
		//������ Ư¡, ���, �������̽� (Overriding)
	}
}