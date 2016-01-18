package org.wg.carbooking.dao.impl;

import org.wg.carbooking.dao.baseDao;
import org.wg.carbooking.dao.carBookDao;
import org.wg.carbooking.model.carbook;

public class carBookImpl extends baseDao<carbook>implements carBookDao {

	@Override
	public boolean bookCar(carbook cb) {
		String sql = "update `dbo.user` set phone=?, pu_car_time=?, gb_car_time=?, book_car_id=? where id=?";
		int rows = this.getmJdbcTemplate().update(sql, cb.getPu_car_time(), cb.getGb_car_time(), cb.getCarBookId(),
				cb.getUserId());
		if (rows != 0) {
			return true;
		}
		return false;
	}

}
