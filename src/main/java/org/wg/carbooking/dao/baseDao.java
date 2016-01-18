package org.wg.carbooking.dao;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "baseDao")
public abstract class baseDao<T> {

	private JdbcTemplate mJt;

	@Resource
	public void setDataSource(DataSource dataSource) {
		this.mJt = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getmJdbcTemplate() {
		return mJt;
	}

	public List<Map<String, Object>> queryForList(Object[] objects, String sql) {
		try {
			return this.getmJdbcTemplate().queryForList(sql, objects);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<T> queryForList(Class<T> beanClass, String sql, Object[] objects) {
		try {
			return this.getmJdbcTemplate().query(sql, new BeanPropertyRowMapper<T>(beanClass), objects);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public T queryForBean(Class<T> beanClass, String sql, Object[] objects) {
		Object o;
		try {
			o = this.getmJdbcTemplate().queryForObject(sql, beanClass, objects);
		} catch (DataAccessException e) {
			e.printStackTrace();
			o = null;
		}
		return (T) o;
	}
	
	public List<Map<String,Object>> queryForList(String sql){
		Object[] o = new Object[]{};
		return queryForList(o, sql);
	}
}
