package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
	private static SqlSessionFactory factory;
	private FactoryService() {}
	static {
		try (Reader reader = Resources.getResourceAsReader("config/sqlMapConfig.xml");){
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}
