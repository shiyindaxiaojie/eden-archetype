#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app.user.executor.query;

import com.alibaba.cola.dto.PageResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ${package}.app.user.assembler.UserAssembler;
import ${package}.client.user.dto.UserVO;
import ${package}.client.user.dto.query.UserListByPageQry;
import ${package}.infrastructure.user.database.dataobject.UserDO;
import ${package}.infrastructure.user.database.mapper.UserMapper;
import org.springframework.stereotype.Component;

/**
 * 根据分页查询获取用户列表指令执行器
 *
 * @author gyl
 * @since 2.4.x
 */
@Component
public class UserListByPageQryExe {

	private final UserMapper userMapper;

	public UserListByPageQryExe(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public PageResponse<UserVO> execute(UserListByPageQry query) {
		Page<UserDO> page = PageHelper.startPage(query.getPageIndex(), query.getPageSize())
			.doSelectPage(() -> userMapper.selectPage(query));

		return PageResponse.of(UserAssembler.INSTANCE.toVOList(page.getResult()),
			Integer.parseInt(String.valueOf(page.getTotal())),
			query.getPageSize(), query.getPageIndex());
	}
}
