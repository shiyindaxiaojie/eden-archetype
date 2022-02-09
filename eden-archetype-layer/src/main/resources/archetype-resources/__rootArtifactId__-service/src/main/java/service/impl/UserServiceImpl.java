#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.impl;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.ylzl.eden.adapter.dto.JsonResult;
import org.ylzl.eden.adapter.dto.Page;
import ${package}.api.UserService;
import ${package}.api.dto.UserDTO;
import ${package}.api.dto.UserPageQuery;
import ${package}.api.dto.UserVO;
import ${package}.common.constant.ApiConstant;
import ${package}.dao.UserDAO;
import ${package}.dao.dataobject.UserDO;
import ${package}.dao.mybatis.mapper.UserMapper;
import ${package}.service.converter.UserConvertor;
import org.ylzl.eden.spring.framework.web.errors.ErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务逻辑实现
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@DubboService(timeout = ApiConstant.DEFAULT_TIMEOUT)
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

	private final UserDAO userDAO;

	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * 创建用户
	 *
	 * @param dto
	 * @return
	 */
	@Override
	public JsonResult createUser(UserDTO dto) {
		UserDO userDO = UserConvertor.INSTANCE.dtoToDataObject(dto);
		userDAO.save(userDO);
		return JsonResult.buildCommandSuccess();
	}

	/**
	 * 修改用户
	 *
	 * @param id
	 * @param dto
	 */
	@Override
	public JsonResult modifyUser(Long id, UserDTO dto) {
		UserDO userDO = userDAO.findById(id);
		Assert.notNull(userDO, "更新用户 `%s` 失败，原因：系统不存在该用户", dto.getUserName());

		UserConvertor.INSTANCE.updateDataObjectFromDTO(dto, userDO);
		userDAO.updateById(userDO);
		Assert.isTrue(updateById(userDO), "更新用户 `%s` 失败，原因：该数据已经被修改过啦", dto.getUserName());
		return JsonResult.buildCommandSuccess();
	}

	/**
	 * 删除用户
	 *
	 * @param id
	 */
	@Override
	public JsonResult removeUser(Long id) {
		Assert.isTrue(userDAO.deleteById(id), "删除用户ID `%s` 失败，原因：该数据可能被删除啦", id);
		return JsonResult.buildCommandSuccess();
	}

	/**
	 * 获取用户信息
	 *
	 * @param id
	 * @return
	 */
	@Override
	public JsonResult<UserVO> getUserById(Long id) {
		UserDO userDO = userDAO.findById(id);
		ErrorEnum.ENTITY_NOT_FOUND.notNull(userDO);
		return JsonResult.buildQuerySuccess(UserConvertor.INSTANCE.dataObjectToVO(userDO));
	}

	/**
	 * 获取用户分页
	 *
	 * @param query
	 * @return
	 */
	@Override
	public JsonResult<Page<UserVO>> listUserByPage(UserPageQuery query) {
		com.github.pagehelper.Page<UserDO> userDOPage = userDAO.findByPage(query);
		List<UserVO> userVOList = UserConvertor.INSTANCE.dataObjectListToVOList(userDOPage.getResult());
		Page<UserVO> userVOPage = Page.<UserVO>builder().rows(userVOList).total(userDOPage.getTotal()).build();
		return JsonResult.buildQuerySuccess(userVOPage);
	}
}
