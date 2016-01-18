package org.wg.carbooking.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wg.carbooking.dao.carBookDao;
import org.wg.carbooking.dao.carDao;
import org.wg.carbooking.dao.userDao;
import org.wg.carbooking.model.car;
import org.wg.carbooking.model.user;

@Service("baseService")
public abstract class baseService {
	
	public userDao mUD;
	public carDao mCD;
	public carBookDao mCBD;
	
	@Resource(name = "userDaoImpl")
	public void setmUD(userDao mUD) {
		this.mUD = mUD;
	}

	@Resource(name = "carDaoImpl")
	public void setmCD(carDao mCD) {
		this.mCD = mCD;
	}
	
	@Resource(name = "carBookImpl")
	public void setmCBD(carBookDao mCBD) {
		this.mCBD = mCBD;
	}

	public List<Map<String,Object>> getUserList(){
		return mUD.queryForUserList();
	}
	
	public List<Map<String,Object>> getCarList(){
		return mCD.queryForCarList();
	}
	
	public car getCarBean(int id){
		return mCD.queryForCarBean(id);
	}
	
	public user getUserBean(user user){
		return mUD.queryForUserBean(user);
	}
}
