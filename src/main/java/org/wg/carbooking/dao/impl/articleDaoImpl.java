package org.wg.carbooking.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wg.carbooking.dao.articleDao;
import org.wg.carbooking.dao.baseDao;
import org.wg.carbooking.vo.article;

@Repository(value = "articleDaoImpl")
public class articleDaoImpl extends baseDao<article>implements articleDao {

	@Override
	public boolean add(article article) {
		String sql = "insert into `dbo.article` (article_title,article_content,article_time,article_type) values (?,?,?,?) ";
		int rows = this.getmJdbcTemplate().update(sql, article.getTitle(), article.getContent(), article.getTime(),
				article.getType());
		if (rows != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean del(int id) {
		String sql = "delete from `dbo.article` where article_id=?";
		int rows = this.getmJdbcTemplate().update(sql, id);
		if (rows != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(article article) {
		String sql = "update `dbo.article` set article_title=?, article_content=?, article_time=?, article_type=? where article_id=?";
		int rows = this.getmJdbcTemplate().update(sql, article.getTitle(), article.getContent(), article.getTime(),
				article.getType(), article.getId());
		if (rows != 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> queryForArticleList(int type) {
		String sql = "select A.* from `dbo.article`  as A LEFT JOIN `dbo.typeofarticle` as B on A.article_type = B.article_type_id where A.article_type ="
				+ type;
		return queryForList(sql);
	}

}
