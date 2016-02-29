package org.wg.carbooking.vo;

public class carbook {

	private String bookNum;
	
	private int carBookId;
	
	private String contact;

	private String gb_car_time;
	
	private String pu_car_time;
	
	private String tips;

	private int userId;

	public String getBookNum() {
		return bookNum;
	}

	public int getCarBookId() {
		return carBookId;
	}

	public String getContact() {
		return contact;
	}

	public String getGb_car_time() {
		return gb_car_time;
	}

	public String getPu_car_time() {
		return pu_car_time;
	}

	public String getTips() {
		return tips;
	}

	public int getUserId() {
		return userId;
	}

	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}

	public void setCarBookId(int carBookId) {
		this.carBookId = carBookId;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setGb_car_time(String gb_car_time) {
		this.gb_car_time = gb_car_time;
	}

	public void setPu_car_time(String pu_car_time) {
		this.pu_car_time = pu_car_time;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
