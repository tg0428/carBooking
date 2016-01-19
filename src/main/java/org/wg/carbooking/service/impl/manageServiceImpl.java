package org.wg.carbooking.service.impl;

import org.springframework.stereotype.Service;
import org.wg.carbooking.model.admin;
import org.wg.carbooking.model.car;
import org.wg.carbooking.model.carbook;
import org.wg.carbooking.model.user;
import org.wg.carbooking.service.baseService;
import org.wg.carbooking.service.managerService;

@Service("managerService")
public class manageServiceImpl extends baseService implements managerService {
	
	@Override
	public boolean Login(user user) {
		return mUD.search(user);
	}

	@Override
	public boolean Register(user user) {
		return mUD.search(user);
	}

	@Override
	public boolean AddCar(car c) {
		return mCD.add(c);
	}

	@Override
	public boolean DelCar(car c) {
		return mCD.del(c);
	}

	@Override
	public boolean UpdCar(car c) {
		return mCD.upd(c);
	}

	@Override
	public boolean BookCar(carbook cb) {
		return mCBD.bookCar(cb);
	}

	@Override
	public admin Access(admin admin) {
		return mAD.queryForAdminBean(admin);
	}

}
