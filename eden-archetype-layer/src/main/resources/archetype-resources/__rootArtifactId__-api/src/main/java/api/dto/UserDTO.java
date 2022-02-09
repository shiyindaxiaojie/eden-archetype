#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

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
public class UserDTO {

	@NotBlank(message = "用户不能为空")
	private String userName;

	@NotBlank(message = "邮箱不能为空")
	private String email;

	private String realName;
}
