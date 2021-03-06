package org.wg.carbooking.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.wg.carbooking.model.pager;
import org.wg.carbooking.service.baseService;
import org.wg.carbooking.service.managerService;
import org.wg.carbooking.vo.admin;
import org.wg.carbooking.vo.article;
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
		return mUD.add(user);
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
	public boolean BookCar(carbook carbook) {
		return mCBD.bookCar(carbook);
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
	public car GetCarBean(String id) {
		return mCD.queryForCarBean(id);
	}

	@Override
	public user GetUserBean(user user) {
		return mUD.queryForUserBean(user);
	}

	@Override
	public boolean addArticle(article article) {
		return mAT.add(article);
	}

	@Override
	public boolean delArticle(int id) {
		return mAT.del(id);
	}

	@Override
	public boolean updateArticle(article article) {
		return mAT.update(article);
	}

	@Override
	public List<Map<String, Object>> getArticleList(int type) {
		return mAT.queryForArticleList(type);
	}

	@Override
	public article GetArticle(int type, int id) {
		return mAT.queryForBean(type, id);
	}

	@Override
	public List<car> GetCarOfType(int type) {
		return mCD.queryForCarBean(type);
	}

	@Override
	public List<Map<String, Object>> getArticleList(int type, int num) {
		return mAT.queryForArticleList(type, num);
	}

	@Override
	public pager<Map<String, Object>> GetCarList(int pageNum, int pageSize) {
		return mCD.paginationForCar(pageNum, pageSize);
	}

	@Override
	public pager<Map<String, Object>> GetCarList(int pageNum, int pageSize, int type) {
		return mCD.paginationForCar(pageNum, pageSize, type);
	}

	@Override
	public List<Map<String, Object>> GetUserInfo(int userId) {
		return mUD.queryForInfoList(userId);
	}

}
