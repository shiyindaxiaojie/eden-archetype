#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ${package}.service.UserService;
import ${package}.web.constant.ApiConstant;

/**
 * 用户控制器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Slf4j
@RequestMapping(ApiConstant.WEB_API_PATH + "/users")
@Controller
public class UserController {

	private final UserService userService;

	public UserController(@Qualifier("userService") UserService userService) {
		this.userService = userService;
	}

	/**
	 * 根据主键获取用户信息
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public String getUserById(@PathVariable Long id, Model model) {
		userService.getUserById(id, model);
		return "user/user-detail";
	}
}
