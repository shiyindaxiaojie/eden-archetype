#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web;

import ${package}.api.UserService;
import ${package}.api.dto.UserDTO;
import ${package}.api.dto.UserPageQuery;
import ${package}.api.dto.UserVO;
import ${package}.common.constant.ApiConstant;
import org.ylzl.eden.adapter.dto.JsonResult;
import org.ylzl.eden.adapter.dto.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户控制器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Slf4j
@RequestMapping(ApiConstant.WEB_API_PATH + "/users")
@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 创建用户
	 *
	 * @param dto
	 * @return
	 */
	@PostMapping
	public JsonResult createUser(@Valid @RequestBody UserDTO dto) {
		return userService.createUser(dto);
	}

	/**
	 * 修改用户
	 *
	 * @param id
	 * @param dto
	 * @return
	 */
	@PutMapping("/{id}")
	public JsonResult modifyUser(@PathVariable Long id, @Valid @RequestBody UserDTO dto) {
		return userService.modifyUser(id, dto);
	}

	/**
	 * 删除用户
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public JsonResult removeUser(@PathVariable Long id) {
		return userService.removeUser(id);
	}

	/**
	 * 根据主键获取用户信息
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public JsonResult<UserVO> getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	/**
	 * 根据分页获取用户列表
	 *
	 * @param query
	 * @return
	 */
	@GetMapping
	public JsonResult<Page<UserVO>> listUserByPage(@Valid @ModelAttribute UserPageQuery query) {
		return userService.listUserByPage(query);
	}
}
