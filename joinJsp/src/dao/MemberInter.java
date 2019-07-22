package dao;

import java.util.List;

import dto.MyMemberDTO;
import dto.SawonDTO;

public interface MemberInter {
	public void addMember(MyMemberDTO dtd);
	
	//public List<SawonDTO> getListSawon(String searchValue);
	public List<MyMemberDTO> getListMember(String searchValue);
}
