package obj;

public class BizClass {
	private String bizV;
	public String insertBiz(String v) {
		bizV = "MyTest "+v;
		return bizV;
	}
	public void setBizV(String bizV) {
		this.bizV = bizV;
	}
	public String getBizView() {
		return bizV+" okokok";
	}
}
