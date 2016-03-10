package org.wg.carbooking.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.wg.carbooking.dao.baseDao;
import org.wg.carbooking.dao.userDao;
import org.wg.carbooking.utils.MD5;
import org.wg.carbooking.vo.user;

@Repository(value = "userDaoImpl")
public class userDaoImpl extends baseDao<user> implements userDao {

	@Override
	public boolean add(user user) {
		String sql = "insert into `dbo.user` (name,password,phone) values (?,?,?)";
		int rows;
		try {
			if (isExist(user)){
				return false;
			}
			rows = this.getmJdbcTemplate().update(sql, user.getName(),MD5.EncoderByMd5(user.getPassword()),user.getPhone());
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
		int rows = 0;
		try {
			rows = this.getmJdbcTemplate().queryForList(sql, user.getName(),MD5.EncoderByMd5(user.getPassword())).size();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (rows != 0){
			return true;
		}
		return false;
	}
	
	public boolean isExist(user user){
		String sql = "select * from `dbo.user` where name=?";
		int rows = this.getmJdbcTemplate().queryForList(sql, user.getName()).size();
		
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
		String sql = "select * from `dbo.user` as A left join `dbo.carbook` as B on A.id=B.user_id";
		return queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> queryForInfoList(int userId) {
		String sql = "select * from `dbo.user` as A right join `dbo.carbook` as B on A.id = B.user_id where A.id = ?";
		return queryForList(new Object[]{userId}, sql);
	}
}
