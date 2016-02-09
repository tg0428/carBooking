package org.wg.carbooking.vo;

public class article {

	/**
	 * type : 文章类型 1 : 公司简介 2 : 帮助中心 3 : 公司公告 4 : 公司新闻 5 : 公司活动
	 */
	private int type;
	private int id;
	private String title;
	private String content;
	private String time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
