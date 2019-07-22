package vo;

public class CustomerVO {
	private int num;
	private String name,email,phone;
	
	public CustomerVO(int d, String a,String b,String c){
	      num=d;  
		  name=a;
	      email=b;
	      phone=c;
	   }
	   public void Customer() {}
	      // TODO Auto-generated method stub
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
