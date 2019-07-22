package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import action.Action;

public class FactoryService {
	private static SqlSessionFactory factory;
	private FactoryService() {}
	static {
			//config/config.xml을 reader 해야한다.
		try(Reader reader = 
					Resources.getResourceAsReader("config/config.xml");){
			factory = new SqlSessionFactoryBuilder().build(reader);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//클라이언트가 사용할 SqlSessionFactory를 한번 반환 하는 메서드를 정의
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
