#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.user.dto.command;

import ${package}.client.user.dto.UserDTO;
import lombok.*;

import java.io.Serializable;

/**
 * 新增用户指令
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class UserAddCmd implements Serializable {

	private UserDTO userDTO;
}
