package org.wg.carbooking.dao;

import org.wg.carbooking.model.carbook;

public interface carBookDao {

	/**用于租车预定
	 * @param cb ： carBook POJO对象
	 * @return
	 */
	public boolean bookCar(carbook cb);
}
