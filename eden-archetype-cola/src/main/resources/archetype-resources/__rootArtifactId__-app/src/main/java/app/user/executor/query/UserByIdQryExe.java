#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app.user.executor.query;

import org.springframework.stereotype.Component;
import ${package}.app.user.assembler.UserAssembler;
import ${package}.client.user.dto.UserVO;
import ${package}.client.user.dto.query.UserByIdQry;
import ${package}.infrastructure.user.database.dataobject.UserDO;
import ${package}.infrastructure.user.database.mapper.UserMapper;
import org.ylzl.eden.spring.framework.cola.dto.SingleResponse;
import org.ylzl.eden.spring.framework.cola.exception.ClientErrorType;

/**
 * 根据主键获取用户信息指令执行器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Component
public class UserByIdQryExe {

	private final UserMapper userMapper;

	public UserByIdQryExe(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public SingleResponse<UserVO> execute(UserByIdQry query) {
		UserDO userDO = userMapper.selectById(query.getId());
		ClientErrorType.A0201.notNull(userDO);
		return SingleResponse.of(UserAssembler.INSTANCE.toVO(userDO));
	}
}
