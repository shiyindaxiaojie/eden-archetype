#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ${package}.api.dto.UserResponseDTO
import ${package}.web.UserController
import org.ylzl.eden.spring.framework.cola.dto.SingleResponse
import spock.lang.Specification
import spock.lang.Unroll
/**
 * 应用启动集成测试
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationITCase extends Specification {

	@Autowired
	private UserController userController;

	@Unroll
	def "get User By Id where id=${symbol_pound}id then expect: ${symbol_pound}expectedResult"() {
		expect:
		userController.getUserById(id) == expectedResult

		where:
		id || expectedResult
		1l || SingleResponse.of(new UserResponseDTO(1l, "admin", "1813986321@qq.com"))
	}
}
