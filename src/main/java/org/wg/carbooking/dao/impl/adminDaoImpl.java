package org.wg.carbooking.dao.impl;

import org.springframework.stereotype.Repository;
import org.wg.carbooking.dao.adminDao;
import org.wg.carbooking.dao.baseDao;
import org.wg.carbooking.model.admin;

@Repository(value = "adminDaoImpl")
public class adminDaoImpl extends baseDao<admin> implements adminDao {

	@Override
	public admin queryForAdminBean(admin admin) {
		String sql = "select * from `dbo.admin` where admin_name=? and admin_pass=?";
		return queryForBean(admin.class, sql, new Object[]{admin.getAdmin_name(),admin.getAdmin_pass()});
	}

}
