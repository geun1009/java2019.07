package demo.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.hello;

/**
 * Servlet implementation class helloController
 */
@WebServlet("/helloController")
public class helloController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get 방식이든 post방식이든 일단 넘어오면 처리해주기 위해 doProcess() 정의한거임
		req.setCharacterEncoding("euc-kr");
		hello hello = new hello(); // 원래는 모델이 여러개면 여기서 모델을 갈라줘야하지만 지금은 초보니까 컨트롤러를 여러개 만든다.
		String view = hello.execute(req, res); // 모델을 실행함 그러면 모델 내에서 비즈니스 로직이 들어서 사용자가 원하는 값이 나오고 그걸 사용자에게 보여줄 뷰를 지정해서
												// 넘겨준다.
		RequestDispatcher rd = req.getRequestDispatcher(view); // 넘겨온 정보를 바탕으로 뷰를 지정 계속 넘겨줄때 req를 넘겨주는거는 그래야 정보를 전달할 수
																// 있으니까
		rd.forward(req, res);

	}
}