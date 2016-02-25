package org.wg.carbooking.dao;

import java.util.List;
import java.util.Map;

import org.wg.carbooking.model.pager;
import org.wg.carbooking.vo.car;

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
	public car queryForCarBean(String id); 
	
	/**按照优惠类型查询汽车
	 * @param type
	 * @return
	 */
	public List<car> queryForCarBean(int type);
	
	/**查询汽车列表
	 * @return
	 */
	public List<Map<String,Object>> queryForCarList();
	
	/** 汽车列表分页
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public pager<Map<String,Object>> paginationForCar(int pageNum, int pageSize);
	
	public pager<Map<String,Object>> paginationForCar(int pageNum, int pageSize, int type);
}
