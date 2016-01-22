package org.wg.carbooking.dao;

import java.util.List;

import org.wg.carbooking.vo.typeOfCar;

public interface typeOfCarDao {

	/**获取优惠类型列表
	 * @return
	 */
	public List<typeOfCar> getTypeList();
	
	/**添加优惠类型
	 * @param type_detail
	 * @return
	 */
	public boolean addType(String type_detail);
	
	/**删除优惠类型
	 * @param id
	 * @return
	 */
	public boolean delType(int id);
}
