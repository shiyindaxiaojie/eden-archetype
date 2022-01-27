#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app.user.executor.command;

import com.alibaba.cola.dto.Response;
import ${package}.client.user.dto.command.UserRemoveCmd;
import ${package}.domain.user.entity.User;
import ${package}.domain.user.gateway.UserGateway;
import org.springframework.stereotype.Component;

/**
 * 删除用户指令执行器
 *
 * @author gyl
 * @since 2.4.x
 */
@Component
public class UserRemoveCmdExe {

	private final UserGateway userGateway;

	public UserRemoveCmdExe(UserGateway userGateway) {
		this.userGateway = userGateway;
	}

	public Response execute(UserRemoveCmd cmd) {
		userGateway.deleteById(User.builder().userId(cmd.getUserId()).build());
		return Response.buildSuccess();
	}
}
