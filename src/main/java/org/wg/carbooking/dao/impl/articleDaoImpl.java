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
		String sql = "insert into `dbo.article` (article_title,article_content,article_time,article_type,article_priority) values (?,?,?,?,?) ";
		int rows = this.getmJdbcTemplate().update(sql, article.getArticle_title(), article.getArticle_content(),
				article.getArticle_time(), article.getArticle_type(),article.getArticle_priority());
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
		String sql = "update `dbo.article` set article_title=?, article_content=?, article_time=?, article_type=?, article_priority=?  where article_id=?";
		int rows = this.getmJdbcTemplate().update(sql, article.getArticle_title(), article.getArticle_content(),
				article.getArticle_time(), article.getArticle_type(),article.getArticle_priority(), article.getArticle_id());
		if (rows != 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> queryForArticleList(int type) {
		String sql = "select A.* from `dbo.article`  as A LEFT JOIN `dbo.typeofarticle` as B on A.article_type = B.article_type_id where A.article_type ="
				+ type + " ORDER BY A.article_priority DESC";
		return queryForList(sql);
	}

	@Override
	public article queryForBean(int type, int id) {
		String sql = "select A.* from `dbo.article`  as A LEFT JOIN `dbo.typeofarticle` as B on A.article_type = B.article_type_id where A.article_type = ? and A.article_id = ?";
		return queryForBean(article.class, sql, new Object[] { type, id });
	}

	@Override
	public List<Map<String, Object>> queryForArticleList(int type, int num) {
		Object[] o = new Object[] { type, num };
		String sql = "select A.* from `dbo.article`  as A LEFT JOIN `dbo.typeofarticle` as B on A.article_type = B.article_type_id where A.article_type = ? ORDER BY A.article_priority DESC LIMIT 0,?";
		return queryForList(o, sql);
	}

}
