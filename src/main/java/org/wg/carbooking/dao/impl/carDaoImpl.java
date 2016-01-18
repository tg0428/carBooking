package org.wg.carbooking.dao.impl;

import org.wg.carbooking.dao.baseDao;
import org.wg.carbooking.dao.carDao;
import org.wg.carbooking.model.car;

public class carDaoImpl extends baseDao<car>implements carDao {

	@Override
	public boolean add(car c) {
		String sql = "insert into `dbo.car` (car_name,leaguer_price,retail_price,car_detail,image_url,car_type,tips) values (?,?,?,?,?,?,?)";
		int rows = this.getmJdbcTemplate().update(sql, c.getCar_name(), c.getLeaguer_price(), c.getRetail_price(),
				c.getCar_detail(), c.getImage_url(), c.getCar_type(), c.getTips());
		if (rows != 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean del(car c) {
		String sql = "delete from `dbo.car` where car_id=?";
		int rows = this.getmJdbcTemplate().update(sql,c.getCar_id());
		
		if (rows != 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean upd(car c) {
		String sql = "update `dbo.car` set car_name=?,leaguer_price=?,retail_price=?,car_detail=?,image_url=?,car_type=?,tips=? where car_id=?";
		int rows = this.getmJdbcTemplate().update(sql, c.getCar_name(), c.getLeaguer_price(), c.getRetail_price(),
				c.getCar_detail(), c.getImage_url(), c.getCar_type(), c.getTips(),c.getCar_id());
		
		if (rows != 0){
			return true;
		}
		return false;
	}

}
