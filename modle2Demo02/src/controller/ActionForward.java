package controller;

public class ActionForward {
	private String url;
	private boolean method;// 모델의 수행후 이용할 형식
	public ActionForward(String url, boolean method) {
		this.url = url;
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	
	public boolean isMethod() {
		return method;
	}

}
