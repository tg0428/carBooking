package org.wg.carbooking.dao;

import java.util.List;
import java.util.Map;

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
	
	/**查询汽车
	 * @param c
	 * @return
	 */
	public car queryForCarBean(int id); 
	
	/**查询汽车列表
	 * @return
	 */
	public List<Map<String,Object>> queryForCarList();
}
