#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app.user.executor.command;

import com.alibaba.cola.dto.Response;
import ${package}.app.user.assembler.UserAssembler;
import ${package}.client.user.dto.command.UserModifyCmd;
import ${package}.domain.user.entity.User;
import ${package}.domain.user.gateway.UserGateway;
import org.springframework.stereotype.Component;

/**
 * 修改用户指令执行器
 *
 * @author gyl
 * @since 2.4.x
 */
@Component
public class UserModifyCmdExe {

	private final UserGateway userGateway;

	public UserModifyCmdExe(UserGateway userGateway) {
		this.userGateway = userGateway;
	}

	public Response execute(UserModifyCmd cmd) {
		User user = UserAssembler.INSTANCE.toEntity(cmd.getUserDTO());
		user.setUserId(cmd.getUserId());
		userGateway.updateById(user);
		return Response.buildSuccess();
	}
}
