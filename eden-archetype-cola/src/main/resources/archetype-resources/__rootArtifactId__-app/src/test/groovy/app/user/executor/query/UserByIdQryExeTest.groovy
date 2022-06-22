#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app.user.executor.query

import org.slf4j.Logger
import ${package}.app.user.assembler.UserAssembler
import ${package}.client.user.dto.UserDTO
import ${package}.client.user.dto.query.UserByIdQry
import ${package}.infrastructure.user.database.dataobject.UserDO
import ${package}.infrastructure.user.database.mapper.UserMapper
import org.ylzl.eden.spring.framework.cola.dto.SingleResponse
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class UserByIdQryExeTest extends Specification {
    @Mock
    UserMapper userMapper
    @Mock
    UserAssembler userAssembler
    @Mock
    Logger log
    @InjectMocks
    UserByIdQryExe userByIdQryExe

    def setup() {
        MockitoAnnotations.openMocks(this)
    }

    def "test execute"() {
        given:
		UserDO userDO = UserDO.builder().id(1L).login("login").email ("email").build()
		UserDTO userDTO = UserDTO.builder().id(1L).login("login").email("email").build()
		when(userMapper.selectById(any())).thenReturn(userDO)
		when(userAssembler.toDTO(userDO)).thenReturn(userDTO)

        when:
        SingleResponse<UserDTO> result = userByIdQryExe.execute(new UserByIdQry(1L))

        then:
        result == SingleResponse.of(userDTO)
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum${symbol_pound}!/testme
