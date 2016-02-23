package org.wg.carbooking.vo;

public class article {

	/**
	 * type : 文章类型 1 : 公司简介 2 : 帮助中心 3 : 公司公告 4 : 公司新闻 5 : 公司活动
	 */
	private int article_type;
	private int article_id;
	private String article_title;
	private String article_content;
	private String article_time;
	private String article_priority;

	public String getArticle_priority() {
		return article_priority;
	}

	public void setArticle_priority(String article_priority) {
		this.article_priority = article_priority;
	}

	public int getArticle_type() {
		return article_type;
	}

	public void setArticle_type(int article_type) {
		this.article_type = article_type;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public String getArticle_time() {
		return article_time;
	}

	public void setArticle_time(String article_time) {
		this.article_time = article_time;
	}
}
