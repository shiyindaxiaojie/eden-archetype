#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app.user.executor.command;

import org.ylzl.eden.spring.framework.cola.dto.Response;
import ${package}.app.user.assembler.UserAssembler;
import ${package}.client.user.dto.command.UserAddCmd;
import ${package}.domain.user.entity.User;
import ${package}.domain.user.gateway.UserGateway;
import org.springframework.stereotype.Component;

/**
 * 新增用户指令执行器
 *
 * @author gyl
 * @since 2.4.x
 */
@Component
public class UserAddCmdExe {

	private final UserGateway userGateway;

	public UserAddCmdExe(UserGateway userGateway) {
		this.userGateway = userGateway;
	}

	public Response execute(UserAddCmd cmd) {
		User user = UserAssembler.INSTANCE.toEntity(cmd.getUserDTO());
		userGateway.save(user);
		return Response.buildSuccess();
	}
}
