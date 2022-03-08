import org.springframework.stereotype.Component;
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

	private final UserAssembler userAssembler;

	public UserByIdQryExe(UserMapper userMapper, UserAssembler userAssembler) {
		this.userMapper = userMapper;
		this.userAssembler = userAssembler;
	}

	public SingleResponse<UserDTO> execute(UserByIdQry query) {
		UserDO userDO = userMapper.selectById(query.getId());
		ClientErrorType.A0201.notNull(userDO);
		return SingleResponse.of(userAssembler.toDTO(userDO));
	}
}
