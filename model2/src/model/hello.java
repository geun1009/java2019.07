package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��û�� ���ؼ� ��äȸ �ǰ� �̰� ����Ǵ� ���� �̰Ÿ� �����Ű�°� �ƴ�
public class hello {
   // ��2 �� �������� ���� ������ �ľ��ϱ� ���� ����
   // �ٽ� �����Ͻ� ������ ����
   public String execute(HttpServletRequest req, HttpServletResponse res) throws  ServletException , IOException {
      String hello="hello"; // �����ٰ�
      
      // view�� ǥ���� ���� �ִٸ�, requestScope�� ����
      req.setAttribute("hello", hello); // ���⼭ "hello" �� jsp ���� ���� hello�� �����Ѱ��� �ű⼭ ����� �Ǵϱ�
      // view. �� ����
      

      return "hello.jsp;"; // ����ڰ� ���ϴ� view�� 

      
      
   }
}