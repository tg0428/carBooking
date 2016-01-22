package org.wg.carbooking.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.wg.carbooking.dao.baseDao;
import org.wg.carbooking.dao.typeOfCarDao;
import org.wg.carbooking.vo.typeOfCar;

@Repository(value = "typeOfCarDaoImpl")
public class typeOfCarDaoImpl extends baseDao<typeOfCar> implements typeOfCarDao {

	@Override
	public List<typeOfCar> getTypeList() {
		String sql = "select * from `dbo.typeofcar`";
		return queryForList(typeOfCar.class, sql);
	}

	@Override
	public boolean addType(String type_detail) {
		String sql = "insert into `dbo.typeofcar` (type_detail) value (?)";
		try {
			int rows = this.getmJdbcTemplate().update(sql, type_detail);
			if (rows != 0){
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delType(int id) {
		String sql = "delete from `dbo.typeofcar` where type_id=?";
		try {
			int rows = this.getmJdbcTemplate().update(sql, id);
			if (rows != 0){
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}
