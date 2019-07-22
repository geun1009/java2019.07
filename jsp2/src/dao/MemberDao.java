package dao;

import org.apache.ibatis.session.SqlSession;

import dto.MyMemberDTO;
import service.FactoryService;

public class MemberDao implements MemberInter {
	private static MemberDao dao;

	private MemberDao() {
	}

	public static synchronized MemberDao getDao() {
		if (dao == null)
			dao = new MemberDao();
		return dao;
	}

	// 회원가입
	public void addMember(MyMemberDTO dto) {
		// 마이바티스 환경 설정으로 부터 매퍼에 저복할 수 있는 세션 객체를 생성
		SqlSession ss = FactoryService.getFactory().openSession();
		ss.insert("mymember.add", dto);
		// 오토커밋이 아님
		ss.commit();
		ss.close();
	}

	// 아이디 중복확인
	public int getIdCount(String id) {
		// 단일행
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.delete("mymember.idcheck", id);
		ss.close();
		return cnt;
	}
}
