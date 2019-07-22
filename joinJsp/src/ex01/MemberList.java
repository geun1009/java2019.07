package ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dto.MyMemberDTO;

public class MemberList extends HttpServlet{
	private MemberDao sdao;
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=euc-kr");
		  
	      PrintWriter out = resp.getWriter();
	      out.println("<p> 회원리스트 </p>");
	      sdao = MemberDao.getDao();
	      
	      List<MyMemberDTO> slist = sdao.getListMember("");
	      
	      
	      StringBuffer sb = new StringBuffer();
	      for (MyMemberDTO e : slist) {
	         sb.append("<p>").append(e.getName()).append("</p>");
	      }
	      out.println(sb.toString());
	      out.close();
	}
}
