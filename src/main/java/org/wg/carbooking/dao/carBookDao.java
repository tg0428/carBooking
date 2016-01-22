package org.wg.carbooking.dao;

import org.wg.carbooking.vo.carbook;

public interface carBookDao {

	/**预定汽车
	 * @param cb carbook对象
	 * @return
	 */
	public boolean bookCar(carbook cb);
}
