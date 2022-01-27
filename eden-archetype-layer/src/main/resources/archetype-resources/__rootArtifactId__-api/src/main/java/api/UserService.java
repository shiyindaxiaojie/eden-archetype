#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api;

import ${package}.api.dto.UserDTO;
import ${package}.api.dto.UserPageQuery;
import ${package}.api.dto.UserVO;
import org.ylzl.eden.adapter.dto.JsonResult;
import org.ylzl.eden.adapter.dto.Page;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 用户业务逻辑接口
 *
 * @author gyl
 * @since 2.4.x
 */
@Path("/users")
public interface UserService {

	/**
	 * 创建用户
	 *
	 * @param dto
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	JsonResult createUser(UserDTO dto);

	/**
	 * 修改用户
	 *
	 * @param id
	 * @param dto
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@PUT
	JsonResult modifyUser(@PathParam("id") Long id, UserDTO dto);

	/**
	 * 删除用户
	 *
	 * @param id
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@DELETE
	JsonResult removeUser(@PathParam("id") Long id);

	/**
	 * 获取用户信息
	 *
	 * @param id
	 * @return
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@GET
	JsonResult<UserVO> getUserById(@PathParam("id") Long id);

	/**
	 * 获取用户分页
	 *
	 * @param query
	 * @return
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	JsonResult<Page<UserVO>> listUserByPage(UserPageQuery query);
}
