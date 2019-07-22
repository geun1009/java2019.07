package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberVO;

public class MemberModel {
	// ���� ������ �ľ��ϸ鼭
	// ��2�� �������� ���� ������ �ľ��ϱ� ���� ����
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<MemberVO> list = new ArrayList<>();	
		
		for(int i=0; i<10;i++) {
			MemberVO v = new MemberVO();
			v.setId("bit" +i);
			v.setName("��Ʈ��"+i);
			v.setPwd("bit"+i);
			list.add(v);
		}
		request.setAttribute("list",list);
		return "jsltdemo.jsp";
	
	}
}