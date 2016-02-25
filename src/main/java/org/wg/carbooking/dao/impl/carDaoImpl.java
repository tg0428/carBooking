package org.wg.carbooking.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wg.carbooking.dao.baseDao;
import org.wg.carbooking.dao.carDao;
import org.wg.carbooking.model.pager;
import org.wg.carbooking.vo.car;

@Repository(value = "carDaoImpl")
public class carDaoImpl extends baseDao<car>implements carDao {

	@Override
	public boolean add(car c) {
		String sql = "insert into `dbo.car` (car_name,leaguer_price,retail_price,car_detail,image_url,image_server_url,car_type,tips) "
				+ "values (?,?,?,?,?,?,(SELECT type_id from `dbo.typeofcar` where type_detail=?),?)";
		int rows = this.getmJdbcTemplate().update(sql, c.getCar_name(), c.getLeaguer_price(), c.getRetail_price(),
				c.getCar_detail(), c.getImage_url(), c.getImage_server_url(), c.getCar_type(), c.getTips());
		if (rows != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean del(car c) {
		String sql = "delete from `dbo.car` where car_id=?";
		int rows = this.getmJdbcTemplate().update(sql, c.getCar_id());

		if (rows != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean upd(car c) {
		String sql_0 = "update `dbo.car` set car_name=?,leaguer_price=?,retail_price=?,car_detail=?,image_url=?,image_server_url=?,car_type=(SELECT type_id from `dbo.typeofcar` where type_detail=?),tips=? where car_id=?";
		String sql_1 = "update `dbo.car` set car_name=?,leaguer_price=?,retail_price=?,car_detail=?,car_type=(SELECT type_id from `dbo.typeofcar` where type_detail=?),tips=? where car_id=?";

		int rows = 0;

		if (c.getImage_server_url() != null) {
			rows = this.getmJdbcTemplate().update(sql_0, c.getCar_name(), c.getLeaguer_price(), c.getRetail_price(),
					c.getCar_detail(), c.getImage_url(), c.getImage_server_url(), c.getCar_type(), c.getTips(),
					c.getCar_id());
		} else {
			rows = this.getmJdbcTemplate().update(sql_1, c.getCar_name(), c.getLeaguer_price(), c.getRetail_price(),
					c.getCar_detail(), c.getCar_type(), c.getTips(), c.getCar_id());
		}
		if (rows != 0) {
			return true;
		}
		return false;
	}

	@Override
	public car queryForCarBean(String id) {
		String sql = "select * from `dbo.car` as A left join `dbo.typeofcar` as B on A.car_type=B.type_id where A.car_id=? ";
		return queryForBean(car.class, sql, new Object[] { id });
	}

	@Override
	public List<Map<String, Object>> queryForCarList() {
		String sql = "select * from `dbo.car` as A left join `dbo.typeofcar` as B on A.car_type=B.type_id";
		return queryForList(sql);
	}

	@Override
	public List<car> queryForCarBean(int type) {
		String sql = "select * from `dbo.car` as A left join `dbo.typeofcar` as B on A.car_type=B.type_id where B.type_id = ?";
		return queryForList(car.class, sql, new Object[] { type });
	}

	@Override
	public pager<Map<String, Object>> paginationForCar(int pageNum, int pageSize) {

		String s1 = "select count(*) as carNum from `dbo.car` where 1=1";
		String s2 = "select * from `dbo.car` as A left join `dbo.typeofcar` as B on A.car_type=B.type_id limit ?,?";
		return getResult(pageNum, pageSize, s1, s2);
	}


	@Override
	public pager<Map<String, Object>> paginationForCar(int pageNum, int pageSize, int type) {
		String s1 = "select count(*) as carNum from `dbo.car` where car_type = " + type;
		String s2 = "select * from `dbo.car` as A left join `dbo.typeofcar` as B on A.car_type=B.type_id where B.type_id = " + type + " limit ?,?";
		return getResult(pageNum, pageSize, s1, s2);
	}
	
	public pager<Map<String,Object>> getResult(int pageNum, int pageSize, String s1, String s2){
				// 查询获得总记录数
				List<Map<String, Object>> RecordList = queryForList(s1);
				int totalRecord = ((Number) RecordList.get(0).get("carNum")).intValue();

				// 计算其实索引
				int forwardIndex = pageSize * (pageNum - 1);

				//计算总页数
				int totalSize = totalRecord / pageSize;
				if (totalRecord % pageSize != 0){
					totalSize ++ ;
				}
				
				List<Map<String, Object>> source = queryForList(new Object[] { forwardIndex, pageSize }, s2.toString());

				pager<Map<String, Object>> result = null;

				result = new pager<Map<String, Object>>(pageNum, pageSize, totalSize, totalRecord, source);

				return result;
	}

}
