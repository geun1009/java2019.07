package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

public class HelloAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setAttribute("m", "hello");
		return new ActionForward("hello.jsp", false);//false, controller���� false�� ��� forward�� �����ڴ�.
	}
	
	

}
