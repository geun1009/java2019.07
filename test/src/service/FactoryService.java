package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
		// 싱글톤 패턴
		private static SqlSessionFactory factory;
		static{
			// config/sqlMapConfig.xml을 reader 해야 한다.
			try {
				Reader reader = 
						Resources.getResourceAsReader("config/sqlMapConfig.xml");
				factory = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		// 클라이언트가 사용될 SqlSessionFactory를 반환 하는 메서드를 정의
		public static SqlSessionFactory getFactory() {
			return factory;
		}
		
}
