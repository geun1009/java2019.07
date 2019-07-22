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
		System.out.println("addMember �Լ� ȣ��");

		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = ConnDriver.getConn();

			String sql = "insert into mymember values(mymember_seq.nextVal,?,?,?,sysdate)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, vo.getId());
			pstm.setString(2, vo.getPwd());
			pstm.setString(3, vo.getName());

			System.out.println("�����ͺ��̽� ������ ");

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
		// select �� ��� cursor�� ��ȯ������.
		ResultSet rs = null;
		List<MyMemberDTO> list = new ArrayList<>();
		try {
			// 1.Connection ����
			con = ConnDriver.getConn();
			// System.out.println("���� ����" +con);
			pstm = con.prepareStatement(sql1);
			pstm.setString(1, "%" + searchValue + "%");
			// ���� sql���� �������� ��ȯ�� �Ѵ�.
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
