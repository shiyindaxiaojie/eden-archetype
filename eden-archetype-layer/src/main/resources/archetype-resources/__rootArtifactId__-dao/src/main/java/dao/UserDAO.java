#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import com.github.pagehelper.Page;
import ${package}.api.dto.UserPageQuery;
import ${package}.dao.database.dataobject.UserDO;

/**
 * 用户（数据对象）存储访问接口
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
public interface UserDAO {

	/**
	 * 创建用户
	 *
	 * @param dataObject
	 * @return
	 */
	boolean save(UserDO dataObject);

	/**
	 * 修改用户
	 *
	 * @param dataObject
	 */
	boolean updateById(UserDO dataObject);

	/**
	 * 删除用户
	 *
	 * @param id
	 */
	boolean deleteById(Long id);

	/**
	 * 获取用户信息
	 *
	 * @param id
	 * @return
	 */
	UserDO findById(Long id);

	/**
	 * 获取用户分页
	 *
	 * @param query
	 * @return
	 */
	Page<UserDO> findByPage(UserPageQuery query);
}
