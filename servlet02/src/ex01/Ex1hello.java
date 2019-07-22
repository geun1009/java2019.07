package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex1hello")//servlet 3.0 ���� ���� ����
public class Ex1hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Ex1hello() {
        System.out.println("������ ȣ��");
    }

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		 System.out.println("init ȣ��");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet �޼��� ȣ��");
		
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		response.setCharacterEncoding("euc-kr");
		
		out.println("�Է� ���� ��"+request.getParameter("msg"));
		out.close();
	}

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy ȣ��");
	}
}
