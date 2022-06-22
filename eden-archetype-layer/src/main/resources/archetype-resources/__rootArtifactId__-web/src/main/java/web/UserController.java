#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ${package}.api.UserService;
import ${package}.api.dto.UserRequestDTO;
import ${package}.api.dto.UserPageQuery;
import ${package}.api.dto.UserResponseDTO;
import ${package}.web.constant.ApiConstant;
import org.ylzl.eden.spring.framework.cola.dto.PageResponse;
import org.ylzl.eden.spring.framework.cola.dto.Response;
import org.ylzl.eden.spring.framework.cola.dto.SingleResponse;

import javax.validation.Valid;

/**
 * 用户控制器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@RequiredArgsConstructor
@Slf4j
@RequestMapping(ApiConstant.WEB_API_PATH + "/users")
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
	public Response createUser(@Valid @RequestBody UserRequestDTO dto) {
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
	public Response modifyUser(@PathVariable Long id, @Valid @RequestBody UserRequestDTO dto) {
		return userService.modifyUser(id, dto);
	}

	/**
	 * 删除用户
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public Response removeUser(@PathVariable Long id) {
		return userService.removeUser(id);
	}

	/**
	 * 根据主键获取用户信息
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public SingleResponse<UserResponseDTO> getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	/**
	 * 根据分页获取用户列表
	 *
	 * @param query
	 * @return
	 */
	@GetMapping
	public PageResponse<UserResponseDTO> listUserByPage(@Valid @ModelAttribute UserPageQuery query) {
		return userService.listUserByPage(query);
	}
}
