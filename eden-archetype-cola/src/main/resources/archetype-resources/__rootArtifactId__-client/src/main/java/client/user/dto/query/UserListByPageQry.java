#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.user.dto.query;

import org.ylzl.eden.spring.framework.cola.dto.PageQuery;
import lombok.*;

import java.io.Serializable;

/**
 * 根据分页查询获取用户列表指令
 *
 * @author gyl
 * @since 2.4.x
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class UserListByPageQry extends PageQuery implements Serializable {

	private String userName;

	private String email;

	private String phone;
}
