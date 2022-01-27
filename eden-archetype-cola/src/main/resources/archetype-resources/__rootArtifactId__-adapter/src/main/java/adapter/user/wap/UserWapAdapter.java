#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.adapter.user.wap;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.SingleResponse;
import org.ylzl.eden.adapter.dto.JsonResult;
import org.ylzl.eden.adapter.dto.Page;
import ${package}.adapter.constant.ApiConstant;
import ${package}.client.user.api.UserService;
import ${package}.client.user.dto.UserVO;
import ${package}.client.user.dto.command.UserAddCmd;
import ${package}.client.user.dto.command.UserModifyCmd;
import ${package}.client.user.dto.command.UserRemoveCmd;
import ${package}.client.user.dto.query.UserByIdQry;
import ${package}.client.user.dto.query.UserListByPageQry;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户领域 WAP适配器（适配APP协议）
 *
 * @author gyl
 * @since 2.4.x
 */
@SuppressWarnings("unchecked")
@Slf4j
@RequestMapping(ApiConstant.WAP_API_PATH + "/users")
@RestController
public class UserWapAdapter {

	@DubboReference
	private UserService userService; // 优化点：使用 Dubbo 也能用，但会额外造成网络开销，本地服务使用 JVM 调用

//	private final UserService userService;
//
//	public UserWapAdapter(UserService userService) {
//		this.userService = userService;
//	}

	/**
	 * 创建用户
	 *
	 * @param cmd
	 * @return
	 */
	@PostMapping
	public JsonResult createUser(@Valid @RequestBody UserAddCmd cmd) {
		userService.createUser(cmd);
		return JsonResult.buildCommandSuccess();
	}

	/**
	 * 修改用户
	 *
	 * @param id
	 * @param cmd
	 * @return
	 */
	@PutMapping("/{id}")
	public JsonResult modifyUser(@PathVariable Long id, @Valid @RequestBody UserModifyCmd cmd) {
		cmd.setUserId(id);
		userService.modifyUser(cmd);
		return JsonResult.buildCommandSuccess();
	}

	/**
	 * 删除用户
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public JsonResult removeUserById(@PathVariable Long id) {
		userService.removeUser(UserRemoveCmd.builder().userId(id).build());
		return JsonResult.buildCommandSuccess();
	}

	/**
	 * 根据主键获取用户信息
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public JsonResult<UserVO> getUserById(@PathVariable Long id) {
		SingleResponse<UserVO> response = userService.getUserById(UserByIdQry.builder().userId(id).build());
		return JsonResult.buildQuerySuccess(response.getData());
	}

	/**
	 * 根据分页获取用户列表
	 *
	 * @param query
	 * @return
	 */
	@GetMapping
	public JsonResult<Page<UserVO>> listUserByPage(@Valid @ModelAttribute UserListByPageQry query) {
		PageResponse<UserVO> response = userService.listUserByPage(query);
		return JsonResult.buildQuerySuccess(Page.buildPage(response.getData(), response.getTotalCount()));
	}
}
