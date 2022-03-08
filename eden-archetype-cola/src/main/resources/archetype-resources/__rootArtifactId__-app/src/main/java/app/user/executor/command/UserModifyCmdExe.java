import org.springframework.stereotype.Component;
import org.ylzl.eden.spring.framework.cola.dto.Response;

/**
 * 修改用户指令执行器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Component
public class UserModifyCmdExe {

	private final UserGateway userGateway;

	private final UserAssembler userAssembler;

	public UserModifyCmdExe(UserGateway userGateway, UserAssembler userAssembler) {
		this.userGateway = userGateway;
		this.userAssembler = userAssembler;
	}

	public Response execute(UserModifyCmd cmd) {
		User user = userAssembler.toEntity(cmd);
		userGateway.updateById(user);
		return Response.buildSuccess();
	}
}
