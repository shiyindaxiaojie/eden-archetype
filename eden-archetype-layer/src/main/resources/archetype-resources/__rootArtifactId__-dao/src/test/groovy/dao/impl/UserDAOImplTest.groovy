#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.impl

import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import ${package}.dao.database.dataobject.UserDO
import ${package}.dao.database.mapper.UserMapper
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDateTime
import java.time.Month

import static org.mockito.ArgumentMatchers.any
import static org.mockito.Mockito.when

class UserDAOImplTest extends Specification {
	@Mock
	UserMapper userMapper
	@InjectMocks
	UserDAOImpl userDAOImpl

	def setup() {
		MockitoAnnotations.openMocks(this)
	}

	@Unroll
	def "save where dataObject=${symbol_pound}dataObject then expect: ${symbol_pound}expectedResult"() {
		given:
		when(userMapper.insert(any())).thenReturn(1)

		expect:
		userDAOImpl.save(dataObject) == expectedResult

		where:
		dataObject                                                                                                                                                                                                                                                                                                      || expectedResult
		new UserDO(1l, "login", "passwordHash", "email", Boolean.TRUE, Boolean.TRUE, "langKey", "activationKey", "resetKey", LocalDateTime.of(2022, Month.JUNE, 23, 17, 34, 21), "createdBy", LocalDateTime.of(2022, Month.JUNE, 23, 17, 34, 21), "lastModifiedBy", LocalDateTime.of(2022, Month.JUNE, 23, 17, 34, 21)) || true
	}

	@Unroll
	def "update By Id where dataObject=${symbol_pound}dataObject then expect: ${symbol_pound}expectedResult"() {
		given:
		when(userMapper.updateById(any())).thenReturn(1)

		expect:
		userDAOImpl.updateById(dataObject) == expectedResult

		where:
		dataObject                                                                                                                                                                                                                                                                                                      || expectedResult
		new UserDO(1l, "login", "passwordHash", "email", Boolean.TRUE, Boolean.TRUE, "langKey", "activationKey", "resetKey", LocalDateTime.of(2022, Month.JUNE, 23, 17, 34, 21), "createdBy", LocalDateTime.of(2022, Month.JUNE, 23, 17, 34, 21), "lastModifiedBy", LocalDateTime.of(2022, Month.JUNE, 23, 17, 34, 21)) || true
	}

	@Unroll
	def "delete By Id where id=${symbol_pound}id then expect: ${symbol_pound}expectedResult"() {
		given:
		when(userMapper.deleteById(any())).thenReturn(1)

		expect:
		userDAOImpl.deleteById(id) == expectedResult

		where:
		id || expectedResult
		1l || true
	}

	@Unroll
	def "find By Id where id=${symbol_pound}id then expect: ${symbol_pound}expectedResult"() {
		given:
		when(userMapper.selectById(any())).thenReturn(UserDO.builder().id(1L).build())

		expect:
		userDAOImpl.findById(id) == expectedResult

		where:
		id || expectedResult
		1l || UserDO.builder().id(1L).build()
	}

//	@Unroll
//	def "find By Page where query=${symbol_pound}query then expect: ${symbol_pound}expectedResult"() {
//		given:
//		when(userMapper.selectPage(any())).thenReturn([UserDO.builder().id(1L).login("login").email("email").build()])
//
//		expect:
//		userDAOImpl.findByPage(query).getResult() == expectedResult
//
//		where:
//		query                      || expectedResult
//		new UserPageQuery("login") || [UserDO.builder().id(1L).login("login").email("email").build()]
//	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum${symbol_pound}!/testme
