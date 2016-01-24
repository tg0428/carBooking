package org.wg.carbooking.vo;

import org.springframework.web.multipart.MultipartFile;

public class car {

	private int car_id;
	private String car_name;
	private String leaguer_price;
	private String retail_price;
	private String car_detail;
	private String image_url;
	private MultipartFile file;
	private String car_type;
	private String tips;

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public String getLeaguer_price() {
		return leaguer_price;
	}

	public void setLeaguer_price(String leaguer_price) {
		this.leaguer_price = leaguer_price;
	}

	public String getRetail_price() {
		return retail_price;
	}

	public void setRetail_price(String retail_price) {
		this.retail_price = retail_price;
	}

	public String getCar_detail() {
		return car_detail;
	}

	public void setCar_detail(String car_detail) {
		this.car_detail = car_detail;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

}
