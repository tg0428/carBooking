package org.wg.carbooking.dao;

import java.util.List;
import java.util.Map;

import org.wg.carbooking.vo.article;

public interface articleDao {

	
	/**添加方法
	 * @param article
	 * @return
	 */
	public boolean add(article article);
	
	/**删除方法
	 * @param id
	 * @return
	 */
	public boolean del(int id);
	
	/**更新文章方法
	 * @param article
	 * @return
	 */
	public boolean update(article article);
	
	/**获取相应类型文章列表
	 * @param type
	 * @return
	 */
	public List<Map<String,Object>> queryForArticleList(int type);
}
