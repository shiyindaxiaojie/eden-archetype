#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.user.gateway;

import ${package}.domain.user.entity.User;

/**
 * 用户领域防腐层
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
public interface UserGateway {

	/**
	 * 新增用户
	 *
	 * @param user
	 */
	void save(User user);

	/**
	 * 修改用户
	 *
	 * @param user
	 */
	void updateById(User user);

	/**
	 * 删除用户
	 *
	 * @param user
	 */
	void deleteById(User user);
}
