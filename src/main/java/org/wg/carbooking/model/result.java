package org.wg.carbooking.model;

public class result {

	private String msg;
	private static result rs = new result();
	
	private result(){}
	
	public static result getInstance(){
		return rs;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
