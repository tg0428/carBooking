package org.wg.carbooking.dao;

import org.wg.carbooking.model.car;

public interface carDao {

	/**�������
	 * @param c
	 * @return
	 */
	public boolean add(car c);
	
	/**ɾ������
	 * @param c
	 * @return
	 */
	public boolean del(car c);
	
	/**��������
	 * @param c
	 * @return
	 */
	public boolean upd(car c);
}
