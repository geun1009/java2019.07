package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import dao.GogekDao;
import vo.DeptVO;
import vo.GogekVO;
import vo.SawonVO;

public class Dept01Model implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		return test2(request);
	}
	public ActionForward test1(HttpServletRequest request, HttpServletResponse response) {
		List<DeptVO> list = GogekDao.getDao().getDeptList();
		request.setAttribute("dlist", list);
		return new ActionForward("deptlist.jsp", false);
	}
	public ActionForward test2(HttpServletRequest request) {
		List<SawonVO> list = GogekDao.getDao().getSawonPhoneList();
		request.setAttribute("slist", list);
		return new ActionForward("sawonPhoneList.jsp", false);
	}
}
