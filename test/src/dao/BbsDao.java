package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import service.FactoryService;
import vo.BbsVO;

public class BbsDao {
	private static BbsDao dao;

	public synchronized static BbsDao getDao() {
		if(dao ==  null) dao = new BbsDao();
		return dao;
	}
	
	// 입력메서드 
	public void bbsAdd(BbsVO vo){
		SqlSession ss = FactoryService.getFactory().openSession();
		ss.insert("bbs_in", vo);
		ss.commit();
		ss.close();
	}
	
	public List<BbsVO> getList(){
		SqlSession ss = FactoryService.getFactory().openSession();
		List<BbsVO> list = ss.selectList("bbs_list");
		ss.close();
		return list;
	}
	
	public List<BbsVO> getList(Map<String, Integer> map){
		SqlSession ss = FactoryService.getFactory().openSession();
		List<BbsVO> list = ss.selectList("bbs_listp", map);
		ss.close();
		return list;
	}
	
	public int getCnt(){
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.selectOne("totalCount");
		ss.close();
		return cnt;
	}
	
	
	
	
	
}
