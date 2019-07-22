package vo;

import java.util.List;

public class DeptVO {
	private int deptno;
	private String dname,loc;
	private List<SawonVO> sawon;
	public List<SawonVO> getSawon() {
		return sawon;
	}

	public void setSawon(List<SawonVO> sawon) {
		this.sawon = sawon;
	}

	public DeptVO() {}
	
	public DeptVO(Integer deptno,String dname) {
		this.deptno = deptno;
		this.dname = dname;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
