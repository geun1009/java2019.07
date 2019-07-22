package ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonImple;
import dao.SawonInter;
import dto.SawonDTO;

@WebServlet("/slist")
public class Ex6_SawonListServletDemo extends HttpServlet{
   private SawonInter sdao;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html;charset=euc-kr");
  
      PrintWriter out = resp.getWriter();
      out.println("<p> 사원 리스트 </p>");
      sdao = SawonImple.getSawondao();
      
      List<SawonDTO> slist = sdao.getListSawon("");
      
      
      StringBuffer sb = new StringBuffer();
      for (SawonDTO e : slist) {
         sb.append("<p>").append(e.getSaname()).append(e.getSahire()).append("</p>");
      }
      out.println(sb.toString());
      out.close();
   } 
}