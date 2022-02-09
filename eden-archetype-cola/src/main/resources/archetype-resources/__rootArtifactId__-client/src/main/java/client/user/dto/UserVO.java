#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.user.dto;

import lombok.*;

import java.io.Serializable;

/**
 * 用户已创建（值对象）
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
public class UserVO implements Serializable {

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 用户账号
	 */
	private String userName;

	/**
	 * 用户邮箱
	 */
	private String email;

	/**
	 * 真实名称
	 */
	private String realName;
}
