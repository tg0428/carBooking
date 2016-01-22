package org.wg.carbooking.vo;

public class carbook {

	private int carBookId;
	private int userId;
	private String pu_car_time;
	private String gb_car_time;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCarBookId() {
		return carBookId;
	}

	public void setCarBookId(int carBookId) {
		this.carBookId = carBookId;
	}

	public String getPu_car_time() {
		return pu_car_time;
	}

	public void setPu_car_time(String pu_car_time) {
		this.pu_car_time = pu_car_time;
	}

	public String getGb_car_time() {
		return gb_car_time;
	}

	public void setGb_car_time(String gb_car_time) {
		this.gb_car_time = gb_car_time;
	}

}
