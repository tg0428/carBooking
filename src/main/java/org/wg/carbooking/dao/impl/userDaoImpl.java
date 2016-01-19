package org.wg.carbooking.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.wg.carbooking.dao.baseDao;
import org.wg.carbooking.dao.userDao;
import org.wg.carbooking.model.user;
import org.wg.carbooking.utils.MD5;

@Repository(value = "userDaoImpl")
public class userDaoImpl extends baseDao<user> implements userDao {

	@Override
	public boolean add(user user) {
		String sql = "insert into `dbo.user` (name,password) values (?,?)";
		int rows;
		try {
			if (isExist(user)){
				return false;
			}
			rows = this.getmJdbcTemplate().update(sql, user.getName(),MD5.EncoderByMd5(user.getPassword()));
			if (rows != 0){
				return true;
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean search(user user) {
		String sql = "select * from `dbo.user` where name=? and password=?";
		int rows = this.getmJdbcTemplate().update(sql, user.getName(),user.getPassword());
		
		if (rows != 0){
			return true;
		}
		return false;
	}
	
	public boolean isExist(user user){
		String sql = "select * from `dbo.user` where name=?";
		int rows = this.getmJdbcTemplate().update(sql, user.getName());
		
		if (rows != 0){
			return true;
		}
		return false;
	}

	@Override
	public user queryForUserBean(user user) {
		String sql = "select * from `dbo.user` where name=?";
		return queryForBean(user.class, sql, new Object[]{user.getName()});
	}

	@Override
	public List<Map<String, Object>> queryForUserList() {
		String sql = "select * from `dbo.user` as A left join `dbo.car` as B on A.book_car_id=B.car_id";
		return queryForList(sql);
	}
}
