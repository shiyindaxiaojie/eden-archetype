import org.springframework.stereotype.Component;
import org.ylzl.eden.spring.framework.cola.dto.Response;

/**
 * 新增用户指令执行器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Component
public class UserAddCmdExe {

	private final UserGateway userGateway;

	private final UserAssembler userAssembler;

	public UserAddCmdExe(UserGateway userGateway, UserAssembler userAssembler) {
		this.userGateway = userGateway;
		this.userAssembler = userAssembler;
	}

	public Response execute(UserAddCmd cmd) {
		User user = userAssembler.toEntity(cmd);
		userGateway.save(user);
		return Response.buildSuccess();
	}
}
