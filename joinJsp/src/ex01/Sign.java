package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dao.MemberInter;
import dto.MyMemberDTO;
@WebServlet("/sign")
public class Sign extends HttpServlet{
	private MemberInter sdao; 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=euc-kr");
		req.setCharacterEncoding("euc-kr");
		
		sdao = MemberDao.getDao();
		MyMemberDTO dto = new MyMemberDTO();
		
		dto.setId(req.getParameter("id"));
		dto.setPwd(req.getParameter("pwd"));
		dto.setName(req.getParameter("name"));
		dto.setEdate(req.getParameter("date"));
		
		System.out.println("dto 데이터 입력");
		sdao.addMember(dto);
	}
}
