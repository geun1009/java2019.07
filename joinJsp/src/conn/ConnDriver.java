package conn;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;;

public class ConnDriver {
	private static DataSource ds;
	static {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mykosta");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConn() throws SQLException {
		return ds.getConnection();
	}
}