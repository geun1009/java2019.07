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
		// get ����̵� post����̵� �ϴ� �Ѿ���� ó�����ֱ� ���� doProcess() �����Ѱ���
		req.setCharacterEncoding("euc-kr");
		hello hello = new hello(); // ������ ���� �������� ���⼭ ���� ������������� ������ �ʺ��ϱ� ��Ʈ�ѷ��� ������ �����.
		String view = hello.execute(req, res); // ���� ������ �׷��� �� ������ ����Ͻ� ������ �� ����ڰ� ���ϴ� ���� ������ �װ� ����ڿ��� ������ �並 �����ؼ�
												// �Ѱ��ش�.
		RequestDispatcher rd = req.getRequestDispatcher(view); // �Ѱܿ� ������ �������� �並 ���� ��� �Ѱ��ٶ� req�� �Ѱ��ִ°Ŵ� �׷��� ������ ������ ��
																// �����ϱ�
		rd.forward(req, res);

	}
}