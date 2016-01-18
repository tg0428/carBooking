package org.wg.carbooking.dao;

import org.wg.carbooking.model.car;

public interface carDao {

	/**添加汽车
	 * @param c
	 * @return
	 */
	public boolean add(car c);
	
	/**删除汽车
	 * @param c
	 * @return
	 */
	public boolean del(car c);
	
	/**更新汽车
	 * @param c
	 * @return
	 */
	public boolean upd(car c);
}
