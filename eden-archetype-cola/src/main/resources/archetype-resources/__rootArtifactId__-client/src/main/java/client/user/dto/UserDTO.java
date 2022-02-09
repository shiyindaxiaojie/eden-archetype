#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.user.dto;

import lombok.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * 用户创建（数据传输对象）
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
public class UserDTO implements Serializable {

	/**
	 * 用户账号
	 */
	@NotBlank(message = "用户不能为空")
	private String userName;

	/**
	 * 密码
	 */
	@NotBlank(message = "密码不能为空")
	private String password;

	/**
	 * 用户邮箱
	 */
	@NotBlank(message = "邮箱不能为空")
	private String email;

	/**
	 * 真实名称
	 */
	private String realName;
}
