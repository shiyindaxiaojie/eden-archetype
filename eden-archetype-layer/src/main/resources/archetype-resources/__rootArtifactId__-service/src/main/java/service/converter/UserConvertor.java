#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.converter;

import ${package}.api.dto.UserRequestDTO;
import ${package}.api.dto.UserResponseDTO;
import ${package}.dao.repository.mybatis.dataobject.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户转换器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Mapper(componentModel = "spring",
	nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
	nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserConvertor {

	UserDO dtoToDataObject(UserRequestDTO dto);

	void updateDataObjectFromDTO(UserRequestDTO dto, @MappingTarget UserDO dataObject);

	UserResponseDTO dataObjectToVO(UserDO dataObject);

	List<UserResponseDTO> dataObjectListToVOList(List<UserDO> dataObjectList);
}
