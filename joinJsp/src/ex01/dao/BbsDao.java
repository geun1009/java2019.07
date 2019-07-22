package dao;

import org.apache.ibatis.session.SqlSession;

import service.FactoryService;
import vo.BbsVo;

public class BbsDao {
	private static BbsDao dao;
	

	public static synchronized BbsDao getDao() {
		if (dao == null)
			dao = new BbsDao();

		return dao;
	}
	
	public void addBbs(BbsVo vo) {
		SqlSession ss= FactoryService.getFactory().openSession();
		ss.insert("bbssql.add",vo);
		ss.commit();
		ss.close();

	}
	
	
	
	

}
