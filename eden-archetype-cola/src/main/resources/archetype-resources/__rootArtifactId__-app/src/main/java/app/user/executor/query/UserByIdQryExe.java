#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app.user.executor.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ${package}.app.user.assembler.UserAssembler;
import ${package}.client.user.dto.UserDTO;
import ${package}.client.user.dto.query.UserByIdQry;
import ${package}.infrastructure.user.database.dataobject.UserDO;
import ${package}.infrastructure.user.database.mapper.UserMapper;
import org.ylzl.eden.spring.framework.cola.dto.SingleResponse;
import org.ylzl.eden.spring.framework.error.ClientErrorType;

/**
 * 根据主键获取用户信息指令执行器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@RequiredArgsConstructor
@Slf4j
@Component
public class UserByIdQryExe {

	private final UserMapper userMapper;

	private final UserAssembler userAssembler;

	public SingleResponse<UserDTO> execute(UserByIdQry query) {
		UserDO userDO = userMapper.selectById(query.getId());
		ClientErrorType.notNull(userDO, "A0201", query.getId());
		return SingleResponse.of(userAssembler.toDTO(userDO));
	}
}
