package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberVO;

public class MemberModel {
	// 모델의 원리를 파악하면서
	// 모델2의 구조에서 모델의 원리를 파악하기 위한 예제
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<MemberVO> list = new ArrayList<>();	
		
		for(int i=0; i<10;i++) {
			MemberVO v = new MemberVO();
			v.setId("bit" +i);
			v.setName("비트인"+i);
			v.setPwd("bit"+i);
			list.add(v);
		}
		request.setAttribute("list",list);
		return "jsltdemo.jsp";
	
	}
}