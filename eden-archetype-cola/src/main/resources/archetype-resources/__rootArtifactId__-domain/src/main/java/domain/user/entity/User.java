#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.user.entity;

import com.alibaba.cola.domain.Entity;
import lombok.*;

/**
 * 用户领域（聚合根）
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
@Entity
public class User {

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
	 * 密码
	 */
	private String password;

	/**
	 * 帐号状态（0正常 1停用）
	 */
	private String status;

	/**
	 * 删除标志（0代表存在 2代表删除）
	 */
	private Integer delFlag;

	/**
	 * 用户详情
	 */
	private UserDetail userDetail;
}
