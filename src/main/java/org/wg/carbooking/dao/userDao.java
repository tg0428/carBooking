package org.wg.carbooking.dao;

import org.wg.carbooking.model.user;

public interface userDao {

	/**用于用户注册
	 * @param user ： user POJO对象
	 * @return
	 */
	public boolean register(user user);
}
