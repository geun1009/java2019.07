package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import obj.BizClass;

public class TodayAction implements Action{
	private SimpleDateFormat f;
	
	public TodayAction() {
		f= new SimpleDateFormat("yyyy�� mm�� dd��");
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BizClass v = new BizClass();
		v.setBizV("�����Ͻ� ����");
		request.setAttribute("v", v);
		request.setAttribute("todate", f.format(new Date()));
		return new ActionForward("today.jsp",false);
	}
	

}
