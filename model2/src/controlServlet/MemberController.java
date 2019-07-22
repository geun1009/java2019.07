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

//모든 요청을 담당한다.
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
		//요청을 분석 http://localhost/model2Demo/index.bit?cmd=menList
		String cmd = req.getParameter("cmd");
		//다형성을 적용한 컨트롤러 작업을 완료, 결합도 느슷하게 설계
		Model md = null;
		
		if(cmd.equals("hello")) {
			md = new hello();
		}else if(cmd.equals("mList")) {
			md = new MemberModel();
		}
		//!!!!!!!다형성!!!!!!!여러 servlet을 처리하기 위해서 굳굳굳굳굳
		String view = md.execute(req, resp);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req,resp);
		
		
		
		
		//다형성 특징, 상속, 인터페이스 (Overriding)
	}
}
