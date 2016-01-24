package org.wg.carbooking.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.wg.carbooking.dao.adminDao;
import org.wg.carbooking.dao.carBookDao;
import org.wg.carbooking.dao.carDao;
import org.wg.carbooking.dao.typeOfCarDao;
import org.wg.carbooking.dao.userDao;

@Service("baseService")
public abstract class baseService {
	
	public userDao mUD;
	public carDao mCD;
	public carBookDao mCBD;
	public adminDao mAD;
	public typeOfCarDao mTC;
	
	@Resource(name = "adminDaoImpl")
	public void setmAD(adminDao mAD) {
		this.mAD = mAD;
	}

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
	
	@Resource(name = "typeOfCarDaoImpl")
	public void setmTC(typeOfCarDao mTC) {
		this.mTC = mTC;
	}
}
