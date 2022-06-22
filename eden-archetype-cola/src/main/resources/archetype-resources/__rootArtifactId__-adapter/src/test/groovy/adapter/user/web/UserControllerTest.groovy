#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.adapter.user.web

import org.slf4j.Logger
import ${package}.client.user.api.UserService
import ${package}.client.user.dto.UserDTO
import ${package}.client.user.dto.command.UserAddCmd
import ${package}.client.user.dto.command.UserModifyCmd
import ${package}.client.user.dto.query.UserListByPageQry
import org.ylzl.eden.spring.framework.cola.dto.PageResponse
import org.ylzl.eden.spring.framework.cola.dto.Response
import org.ylzl.eden.spring.framework.cola.dto.SingleResponse
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*


class UserControllerTest extends Specification {
	@Mock
	UserService userService
	@Mock
	Logger log
	@InjectMocks
	UserController userController

	def setup() {
		MockitoAnnotations.openMocks(this)
	}

	@Unroll
	def "create User where cmd=${symbol_pound}cmd then expect: ${symbol_pound}expectedResult"() {
		given:
		when(userService.createUser(any())).thenReturn(Response.buildSuccess())

		expect:
		userController.createUser(cmd) == expectedResult

		where:
		cmd                                          || expectedResult
		new UserAddCmd("login", "password", "email") || Response.buildSuccess()
	}

	@Unroll
	def "modify User where id=${symbol_pound}id and cmd=${symbol_pound}cmd then expect: ${symbol_pound}expectedResult"() {
		given:
		when(userService.modifyUser(any())).thenReturn(Response.buildSuccess())

		expect:
		userController.modifyUser(id, cmd) == expectedResult

		where:
		id | cmd                                                 || expectedResult
		1l | new UserModifyCmd(1l, "login", "password", "email") || Response.buildSuccess()
	}

	@Unroll
	def "remove User By Id where id=${symbol_pound}id then expect: ${symbol_pound}expectedResult"() {
		given:
		when(userService.removeUser(any())).thenReturn(Response.buildSuccess())

		expect:
		userController.removeUserById(id) == expectedResult

		where:
		id || expectedResult
		1l || Response.buildSuccess()
	}

	@Unroll
	def "get User By Id where id=${symbol_pound}id then expect: ${symbol_pound}expectedResult"() {
		given:
		when(userService.getUserById(any())).thenReturn(SingleResponse.of(new UserDTO(1l, "login", "email")))

		expect:
		userController.getUserById(id) == expectedResult

		where:
		id || expectedResult
		1l || SingleResponse.of(new UserDTO(1l, "login", "email"))
	}

	@Unroll
	def "list User By Page where query=${symbol_pound}query then expect: ${symbol_pound}expectedResult"() {
		given:
		when(userService.listUserByPage(any())).thenReturn(PageResponse.of([new UserDTO(1l, "login", "email")], 1, 1, 1))

		expect:
		userController.listUserByPage(query) == expectedResult

		where:
		query                                   || expectedResult
		new UserListByPageQry("login", "email") || PageResponse.of([new UserDTO(1l, "login", "email")], 1, 1, 1)
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum${symbol_pound}!/testme
