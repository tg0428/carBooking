package org.wg.carbooking.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.wg.carbooking.service.baseService;
import org.wg.carbooking.service.managerService;
import org.wg.carbooking.vo.admin;
import org.wg.carbooking.vo.car;
import org.wg.carbooking.vo.carbook;
import org.wg.carbooking.vo.typeOfCar;
import org.wg.carbooking.vo.user;

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

	@Override
	public List<typeOfCar> GetTypeOfCar() {
		return mTC.getTypeList();
	}

	@Override
	public boolean AddType(String type_detail) {
		return mTC.addType(type_detail);
	}

	@Override
	public boolean DelType(int type_id) {
		return mTC.delType(type_id);
	}

	@Override
	public List<Map<String, Object>> GetCarList() {
		return mCD.queryForCarList();
	}

	@Override
	public List<Map<String, Object>> GetUserList() {
		return mUD.queryForUserList();
	}

	@Override
	public car GetCarBean(int id) {
		return mCD.queryForCarBean(id);
	}

	@Override
	public user GetUserBean(user user) {
		return mUD.queryForUserBean(user);
	}

}
