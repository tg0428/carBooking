package org.wg.carbooking.vo;

import java.util.List;
import java.util.Map;

/**
 * test beetl model
 */
public class user {

	private List<Map<String, Object>> bills;

	private int id;
	private String name;
	private String password;
	private String phone;

	public user(List<Map<String, Object>> bills, int id, String name, String password, String phone) {
		super();
		this.bills = bills;
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	public user() {
		// TODO Auto-generated constructor stub
	}

	public List<Map<String, Object>> getBills() {
		return bills;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public void setBills(List<Map<String, Object>> bills) {
		this.bills = bills;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
