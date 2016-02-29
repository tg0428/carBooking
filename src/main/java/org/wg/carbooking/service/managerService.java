package org.wg.carbooking.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.wg.carbooking.model.pager;
import org.wg.carbooking.vo.admin;
import org.wg.carbooking.vo.article;
import org.wg.carbooking.vo.car;
import org.wg.carbooking.vo.carbook;
import org.wg.carbooking.vo.typeOfCar;
import org.wg.carbooking.vo.user;

@Service
public interface managerService {

	/**登录方法
	 * @param user
	 * @return
	 */
	public boolean Login(user user);
	
	/**管理员登录方法
	 * @param user
	 * @return
	 */
	public admin Access(admin admin);
	
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
	public boolean BookCar(carbook carbook);
	
	/**获取汽车优惠类型列表
	 * @return
	 */
	public List<typeOfCar> GetTypeOfCar();
	
	/**添加优惠类型
	 * @param type_detail
	 * @return
	 */
	public boolean AddType(String type_detail);
	
	
	/**删除优惠类型
	 * @param type_id
	 * @return
	 */
	public boolean DelType(int type_id);
	
	/**获取车辆管理列表
	 * @return
	 */
	public List<Map<String,Object>> GetCarList();
	
	/**分页获取汽车列表
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public pager<Map<String,Object>> GetCarList(int pageNum, int pageSize);
	
	/**分页获取相应优惠类型汽车列表
	 * @param pageNum
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public pager<Map<String,Object>> GetCarList(int pageNum, int pageSize, int type);
	
	/**获取用户管理列表
	 * @return
	 */
	public List<Map<String,Object>> GetUserList();
	
	/**获取指定用户信息列表
	 * @return
	 */
	public List<Map<String,Object>> GetUserInfo(int userId);
	
	/**获取车辆实体
	 * @param id
	 * @return
	 */
	public car GetCarBean(String id);
	
	/**获取用户实体
	 * @param user
	 * @return
	 */
	public user GetUserBean(user user);
	
	/**添加文章
	 * @param article
	 * @return
	 */
	public boolean addArticle(article article);
	
	/**删除文章
	 * @param id
	 * @return
	 */
	public boolean delArticle(int id);
	
	/**更新文章
	 * @param article
	 * @return
	 */
	public boolean updateArticle(article article);
	
	/**获取列表
	 * @param type
	 * @return
	 */
	public List<Map<String,Object>> getArticleList(int type);
	
	/**获取文章列表前num条
	 * @param type
	 * @param num
	 * @return
	 */
	public List<Map<String,Object>> getArticleList(int type, int num);
	
	/**获取文章实体
	 * @param type
	 * @param id
	 * @return
	 */
	public article GetArticle(int type, int id);
	
	/**获取优惠类型车辆
	 * @param type
	 * @return
	 */
	public List<car> GetCarOfType(int type);
	
}
