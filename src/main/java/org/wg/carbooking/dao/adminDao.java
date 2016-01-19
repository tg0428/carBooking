package org.wg.carbooking.dao;

import org.wg.carbooking.model.admin;

public interface adminDao {

	/**查询管理员信息
	 * @param admin
	 * @return
	 */
	public admin queryForAdminBean(admin admin);
}
