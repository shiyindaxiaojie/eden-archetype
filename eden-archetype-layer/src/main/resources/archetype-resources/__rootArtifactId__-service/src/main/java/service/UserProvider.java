#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import org.apache.dubbo.config.annotation.DubboService;
import ${package}.api.UserService;
import ${package}.dao.UserDAO;
import ${package}.service.constant.DubboConstant;
import ${package}.service.converter.UserConvertor;
import ${package}.service.impl.UserServiceImpl;

/**
 * 用户业务 RPC服务端
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@DubboService(timeout = DubboConstant.DEFAULT_TIMEOUT)
public class UserProvider extends UserServiceImpl implements UserService {

	public UserProvider(UserDAO userDAO, UserConvertor userConvertor) {
		super(userDAO, userConvertor);
	}
}
