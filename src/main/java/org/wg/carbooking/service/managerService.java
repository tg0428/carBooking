package org.wg.carbooking.service;

import org.springframework.stereotype.Service;
import org.wg.carbooking.model.car;
import org.wg.carbooking.model.carbook;
import org.wg.carbooking.model.user;

@Service
public interface managerService {

	/**登录方法
	 * @param user
	 * @return
	 */
	public boolean Login(user user);
	
	/**注册方法
	 * @param user
	 * @return
	 */
	public boolean Register(user user);
	
	/**添加汽车方法
	 * @param c
	 * @return
	 */
	public boolean AddCar(car c);
	
	/**删除方法
	 * @param c
	 * @return
	 */
	public boolean DelCar(car c);
	
	/**更新汽车信息方法
	 * @param c
	 * @return
	 */
	public boolean UpdCar(car c);
	
	/**预定租车方法
	 * @param cb
	 * @return
	 */
	public boolean BookCar(carbook cb);
}
