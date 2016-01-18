package org.wg.carbooking.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.wg.carbooking.dao.baseDao;
import org.wg.carbooking.dao.userDao;
import org.wg.carbooking.model.user;
import org.wg.carbooking.utils.MD5;

@Repository(value = "userDaoImpl")
public class userDaoImpl extends baseDao<user> implements userDao {

	@Override
	public boolean register(user user) {
		String sql = "insert into `dbo.user` (name,password) values (?,?)";
		int rows;
		try {
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

}
