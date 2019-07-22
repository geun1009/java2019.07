package dao;

import conn.ConnDriver;
import dto.SawonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SawonImple implements SawonInter{

    private static SawonImple sawondao;
    
    public synchronized static SawonImple getSawondao(){
        if(sawondao == null){
            sawondao = new SawonImple();
        }
        return sawondao;
    }
    

    @Override
    public void addSawon(SawonDTO dto){
        Connection con = null;
        PreparedStatement pstm = null;
        try{
            con = ConnDriver.getConn();
            //insert into sawon values(sawon_seq.nextVal,'박점심',20,'과장',5000,sysdate,'남자',10)
            String sql = "insert into sawon values(sawon_seq.nextVal,?,?,?,?,sysdate,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, dto.getSaname());
            pstm.setInt(2, dto.getDeptno());
            pstm.setString(3, dto.getSajob());
            pstm.setInt(4, dto.getSapay());
            pstm.setString(5, dto.getSasex());
            pstm.setInt(6, dto.getSamgr());
            pstm.executeUpdate();
        }catch(SQLException ex){ ex.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(con!=null){
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    
    @Override
    public List<SawonDTO> getListSawon(String searchValue){
        String sql1="select sabun,saname,deptno,sahire,sapay from sawon where saname like ? order by 1 desc";
        Connection con =null;
        PreparedStatement pstm = null;
        //select 일 경우 cursor를 반환조진다.
        ResultSet rs = null;
        List<SawonDTO> list = new ArrayList<>();
        try {
            //1.Connection 연결
            con = ConnDriver.getConn();
            //System.out.println("연결 성공" +con);
            pstm = con.prepareStatement(sql1);
            pstm.setString(1, "%" + searchValue + "%");
            //실제 sql문을 전송한후 반환을 한다.
            rs = pstm.executeQuery();
            StringBuffer sb = new StringBuffer();
            while(rs.next()){
                //sabun,saname,deptno,sapay,sahire
                //사원의 정보 하나당 SAwonDTO가 하나씩 생성
                SawonDTO vo = new SawonDTO();
                vo.setSabun(rs.getInt("sabun"));
                vo.setSaname(rs.getString("saname"));
                vo.setDeptno(rs.getInt("deptno"));
                //vo.setSajob(rs.getString("sajob"));
                vo.setSapay(rs.getInt("sapay"));               
                vo.setSahire(rs.getString("sahire"));
               // vo.setSasex(rs.getString("sasex"));
                //vo.setSamgr(rs.getInt("samgr"));
                //사원들의 정보를 리스트에 추가
                list.add(vo);
                /*sb.append("사원 번호:").append(rs.getInt("sabun")).append("\n");
                sb.append("월급 : ").append(rs.getInt("sapay")).append("\n");
                sb.append("이름 : ").append(rs.getString("saname")).append("\n");
                sb.append("부서번호 :").append(rs.getInt("deptno")).append("\n");
                sb.append("입사일 : ").append(rs.getString("sahire")).append("\n");*/
            }
            //ui에 적용
            //resv.setText(sb.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try {
                if(rs !=null){
                    rs.close();
                }
                if(pstm !=null){
                    pstm.close();
                }
                if(con !=null){
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }
}