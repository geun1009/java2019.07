package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conn.ConnDriver;
import dto.MyMemberDTO;

public class MemberDao implements MemberInter {
	private static MemberDao dao;

	private MemberDao() {}

	public static synchronized MemberDao getDao() {
		if (dao == null)
			dao = new MemberDao();
		return dao;
	}

	@Override
	public void addMember(MyMemberDTO vo) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = ConnDriver.getConn();

			String sql = "insert into mymember values(mymember_seq.nextVal,?,?,?,sysdate)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, vo.getId());
			pstm.setString(2, vo.getPwd());
			pstm.setString(3, vo.getName());

			pstm.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
