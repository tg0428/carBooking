package org.wg.carbooking.dao.impl;

import org.springframework.stereotype.Repository;
import org.wg.carbooking.dao.baseDao;
import org.wg.carbooking.dao.carBookDao;
import org.wg.carbooking.utils.webGetDate;
import org.wg.carbooking.vo.carbook;

@Repository(value = "carBookImpl")
public class carBookImpl extends baseDao<carbook>implements carBookDao {

	@Override
	public boolean bookCar(carbook carbook) {
		String sql = "insert into `dbo.carbook` (pu_car_time,gb_car_time,book_car_id,book_num,user_id,create_time,contact,tips) values (?,?,?,?,?,?,?,?)";
		int rows = this.getmJdbcTemplate().update(sql, carbook.getPu_car_time(), carbook.getGb_car_time(),
				carbook.getCarBookId(), carbook.getBookNum(), carbook.getUserId(), webGetDate.getDate(),carbook.getContact(),carbook.getTips());
		if (rows != 0) {
			return true;
		}
		return false;
	}

}
