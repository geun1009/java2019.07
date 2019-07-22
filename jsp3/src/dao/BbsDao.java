package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.BbsVo;
import service.FactoryService;

public class BbsDao implements BbsDaoInter {
	private static BbsDao dao;

	private BbsDao(){}

	public static synchronized BbsDao getDao() {
		if (dao == null)
			dao = new BbsDao();
		return dao;
	}

	// ȸ������
	public void bbsIn(BbsVo vo) {
		// ���̹�Ƽ�� ȯ�� �������� ���� ���ۿ� ������ �� �ִ� ���� ��ü�� ����
		SqlSession ss = FactoryService.getFactory().openSession();
		ss.insert("bbssql.bbs_in", vo);
		// ����Ŀ���� �ƴ�
		ss.commit();
		ss.close();
	}
	public List<BbsVo> getList(Map<String, Integer> map){
		SqlSession ss = FactoryService.getFactory().openSession();
		List<BbsVo> list = ss.selectList("bbs_listp",map);
		ss.close();
		return list;
	}
	public int getCnt() {
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.selectOne("totalCount");
		ss.close();
		return cnt;
	}
}
