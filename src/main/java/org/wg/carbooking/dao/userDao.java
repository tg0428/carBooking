package org.wg.carbooking.dao;

import java.util.List;
import java.util.Map;

import org.wg.carbooking.vo.user;

public interface userDao {

	/**添加用户
	 * @param user
	 * @return
	 */
	public boolean add(user user);
	
	/**查询用户
	 * @param user
	 * @return
	 */
	public boolean search(user user);
	
	/**查询用户
	 * @param user
	 * @return
	 */
	public user queryForUserBean(user user);
	
	/**查询用户列表
	 * @return
	 */
	public List<Map<String,Object>> queryForUserList();
}
