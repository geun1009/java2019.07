package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.ConnDriver;
import dto.MyMemberDTO;

public class MemberDao implements MemberInter {
	private static MemberDao dao;

	private MemberDao() {
	}

	public static synchronized MemberDao getDao() {
		if (dao == null)
			dao = new MemberDao();
		return dao;
	}

	@Override
	public void addMember(MyMemberDTO vo) {
		System.out.println("addMember 함수 호출");

		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = ConnDriver.getConn();

			String sql = "insert into mymember values(mymember_seq.nextVal,?,?,?,sysdate)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, vo.getId());
			pstm.setString(2, vo.getPwd());
			pstm.setString(3, vo.getName());

			System.out.println("데이터베이스 데이터 ");

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

	@Override
	public List<MyMemberDTO> getListMember(String searchValue) {
		String sql1 = "select num,id,pwd,name,edate from mymember where name like ? order by 1 desc";
		Connection con = null;
		PreparedStatement pstm = null;
		// select 일 경우 cursor를 반환조진다.
		ResultSet rs = null;
		List<MyMemberDTO> list = new ArrayList<>();
		try {
			// 1.Connection 연결
			con = ConnDriver.getConn();
			// System.out.println("연결 성공" +con);
			pstm = con.prepareStatement(sql1);
			pstm.setString(1, "%" + searchValue + "%");
			// 실제 sql문을 전송한후 반환을 한다.
			rs = pstm.executeQuery();
			StringBuffer sb = new StringBuffer();
			while (rs.next()) {

				MyMemberDTO vo = new MyMemberDTO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));

				vo.setName(rs.getString("name"));

				list.add(vo);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		return list;
	}
}
