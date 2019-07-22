package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex1hello")//servlet 3.0 부터 서블릿 맵핑
public class Ex1hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Ex1hello() {
        System.out.println("생성자 호출");
    }

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		 System.out.println("init 호출");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet 메서드 호출");
		
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		response.setCharacterEncoding("euc-kr");
		
		out.println("입력 받은 값"+request.getParameter("msg"));
		out.close();
	}

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy 호출");
	}
}
