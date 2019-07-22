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

	// ȸ������
	public void addMember(MyMemberDTO dto) {
		// ���̹�Ƽ�� ȯ�� �������� ���� ���ۿ� ������ �� �ִ� ���� ��ü�� ����
		SqlSession ss = FactoryService.getFactory().openSession();
		ss.insert("mymember.add", dto);
		// ����Ŀ���� �ƴ�
		ss.commit();
		ss.close();
	}

	// ���̵� �ߺ�Ȯ��
	public int getIdCount(String id) {
		// ������
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.delete("mymember.idcheck", id);
		ss.close();
		return cnt;
	}
}
