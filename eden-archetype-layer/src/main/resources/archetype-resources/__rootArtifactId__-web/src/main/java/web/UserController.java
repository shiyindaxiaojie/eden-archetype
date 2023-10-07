#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ${package}.api.UserService;
import ${package}.api.dto.UserPageQuery;
import ${package}.api.dto.UserRequestDTO;
import ${package}.api.dto.UserResponseDTO;
import ${package}.web.constant.API;
import org.ylzl.eden.spring.framework.dto.PageResult;
import org.ylzl.eden.spring.framework.dto.Result;
import org.ylzl.eden.spring.framework.dto.SingleResult;

import javax.validation.Valid;

/**
 * 用户控制器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@RequiredArgsConstructor
@Slf4j
@RequestMapping(API.WEB_API_PATH + "/users")
@RestController
public class UserController {

	private final UserService userService;

	/**
	 * 创建用户
	 *
	 * @param dto
	 * @return
	 */
	@PostMapping
	public Result createUser(@Valid @RequestBody UserRequestDTO dto) {
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
	public Result modifyUser(@PathVariable Long id, @Valid @RequestBody UserRequestDTO dto) {
		return userService.modifyUser(id, dto);
	}

	/**
	 * 删除用户
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public Result removeUser(@PathVariable Long id) {
		return userService.removeUser(id);
	}

	/**
	 * 根据主键获取用户信息
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public SingleResult<UserResponseDTO> getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	/**
	 * 根据分页获取用户列表
	 *
	 * @param query
	 * @return
	 */
	@GetMapping
	public PageResult<UserResponseDTO> listUserByPage(@Valid @ModelAttribute UserPageQuery query) {
		return userService.listUserByPage(query);
	}
}
