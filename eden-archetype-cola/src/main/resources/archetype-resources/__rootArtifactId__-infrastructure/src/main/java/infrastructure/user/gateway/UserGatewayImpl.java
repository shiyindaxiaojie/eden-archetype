#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.user.gateway;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ${package}.domain.user.entity.User;
import ${package}.domain.user.gateway.UserGateway;
import ${package}.infrastructure.user.database.convertor.UserConvertor;
import ${package}.infrastructure.user.database.mapper.UserMapper;

/**
 * 用户领域防腐层实现
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@RequiredArgsConstructor
@Repository
public class UserGatewayImpl implements UserGateway {

	private final UserMapper userMapper;

	private final UserConvertor userConvertor;

	/**
	 * 新增用户
	 *
	 * @param user
	 */
	@Override
	public void save(User user) {
		userMapper.insert(userConvertor.toDataObject(user));
	}

	/**
	 * 修改用户
	 *
	 * @param user
	 */
	@Override
	public void updateById(User user) {
		userMapper.updateById(userConvertor.toDataObject(user));
	}

	/**
	 * 删除用户
	 *
	 * @param user
	 */
	@Override
	public void deleteById(User user) {
		userMapper.deleteById(user.getId());
	}
}
