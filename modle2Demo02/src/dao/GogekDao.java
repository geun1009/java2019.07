package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import factory.FactoryService;
import vo.DeptVO;
import vo.GogekVO;
import vo.SawonVO;
import vo.SearchVO;

public class GogekDao {
	private static GogekDao dao;
	
	private GogekDao() {}
	
	public static synchronized GogekDao getDao() {
		if (dao == null)
			dao = new GogekDao();
		return dao;
	}
	
	//
	public List<GogekVO> getGogekList(SearchVO svo) {
		SqlSession ss = FactoryService.getFactory().openSession();
		List<GogekVO> list = ss.selectList("gogek.search",svo);
		ss.close();
		return list;
	}
	//resultMap ¿¹Á¦
	public List<DeptVO> getDeptList() {
		SqlSession ss = FactoryService.getFactory().openSession();
		List<DeptVO> list = ss.selectList("sawon.showDept");
		ss.close();
		return list;
	}
	public List<SawonVO> getSawonPhoneList() {
		SqlSession ss = FactoryService.getFactory().openSession();
		List<SawonVO> list = ss.selectList("sawon.sawonList2");
		ss.close();
		return list;
	}
}
