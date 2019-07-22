package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import dao.GogekDao;
import vo.GogekVO;
import vo.SearchVO;

public class GogekModel implements Action {
	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SearchVO svo = new SearchVO();
		svo.setSearchType(request.getParameter("searchType"));
		svo.setSearchValue(request.getParameter("searchValue"));
		
		List<GogekVO> list = GogekDao.getDao().getGogekList(svo);// dao로부터 메서드를 호출

		request.setAttribute("list", list);
		return new ActionForward("gogekList.jsp", false);
	}
}
