#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.user.gateway;

import ${package}.domain.user.entity.User;

/**
 * 用户领域防腐层
 *
 * @author gyl
 * @since 2.4.x
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
	 * @param authority
	 */
	void deleteById(User user);
}
