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

	// 회원가입
	public void bbsIn(BbsVo vo) {
		// 마이바티스 환경 설정으로 부터 매퍼에 저복할 수 있는 세션 객체를 생성
		SqlSession ss = FactoryService.getFactory().openSession();
		ss.insert("bbssql.bbs_in", vo);
		// 오토커밋이 아님
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
