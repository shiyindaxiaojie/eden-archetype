#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app.user.assembler;

import ${package}.client.user.dto.UserDTO;
import ${package}.client.user.dto.UserVO;
import ${package}.domain.user.entity.User;
import ${package}.infrastructure.user.database.dataobject.UserDO;
import org.ylzl.eden.spring.framework.cola.DTOAssembler;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户领域组装器
 *
 * @author gyl
 * @since 2.4.x
 */
@Mapper(componentModel = "spring",
	nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
	nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserAssembler extends DTOAssembler<UserDTO, User> {

	UserAssembler INSTANCE = Mappers.getMapper(UserAssembler.class);

	/**
	 * DO 转 VO
	 *
	 * @param dataObject
	 * @return
	 */
	UserVO toVO(UserDO dataObject);

	/**
	 * DO 转 VO
	 *
	 * @param dataObjectList
	 * @return
	 */
	List<UserVO> toVOList(List<UserDO> dataObjectList);
}
