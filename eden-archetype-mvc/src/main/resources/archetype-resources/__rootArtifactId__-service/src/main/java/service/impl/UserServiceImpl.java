#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ${package}.model.entity.User;
import ${package}.model.mapper.UserMapper;
import ${package}.service.UserService;
import org.ylzl.eden.spring.framework.cola.catchlog.annotation.CatchLog;

/**
 * 用户业务逻辑实现
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@CatchLog
@Slf4j
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	private final UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * 获取用户信息
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@Override
	public void getUserById(Long id, Model model) {
		User user = userMapper.selectById(id);
		model.addAttribute("id", user.getId())
			.addAttribute("login", user.getLogin())
			.addAttribute("email", user.getEmail())
			.addAttribute("langKey", user.getLangKey());
	}

}
