package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청에 이해서 객채회 되고 이게 실행되는 거지 이거를 실행시키는게 아님
public class hello {
   // 모델2 의 구조에서 모델의 원리를 파악하기 위한 예제
   // 핵심 비지니스 로직을 수행
   public String execute(HttpServletRequest req, HttpServletResponse res) throws  ServletException , IOException {
      String hello="hello"; // 보내줄값
      
      // view에 표시할 값이 있다면, requestScope에 저장
      req.setAttribute("hello", hello); // 여기서 "hello" 는 jsp 에서 받을 hello로 동일한거임 거기서 출력이 되니까
      // view. 를 선정
      

      return "hello.jsp;"; // 사용자가 원하는 view임 

      
      
   }
}