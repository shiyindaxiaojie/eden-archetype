#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import ${package}.api.dto.UserPageQuery;
import ${package}.dao.UserDAO;
import ${package}.dao.database.dataobject.UserDO;
import ${package}.dao.database.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * 用户（数据对象）存储访问实现
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@RequiredArgsConstructor
@Repository
public class UserDAOImpl implements UserDAO {

	private final UserMapper userMapper;

	/**
	 * 创建用户
	 *
	 * @param dataObject
	 * @return
	 */
	@Override
	public boolean save(UserDO dataObject) {
		return userMapper.insert(dataObject) > 0;
	}

	/**
	 * 修改用户
	 *
	 * @param dataObject
	 */
	@Override
	public boolean updateById(UserDO dataObject) {
		return userMapper.updateById(dataObject) > 0;
	}

	/**
	 * 删除用户
	 *
	 * @param id
	 */
	@Override
	public boolean deleteById(Long id) {
		return userMapper.deleteById(id) > 0;
	}

	/**
	 * 获取用户信息
	 *
	 * @param id
	 * @return
	 */
	@Override
	public UserDO findById(Long id) {
		return userMapper.selectById(id);
	}

	/**
	 * 获取用户分页
	 *
	 * @param query
	 * @return
	 */
	@Override
	public Page<UserDO> findByPage(UserPageQuery query) {
		return PageHelper.startPage(query.getPageIndex(), query.getPageSize())
			.doSelectPage(() -> userMapper.selectPage(query));
	}
}
