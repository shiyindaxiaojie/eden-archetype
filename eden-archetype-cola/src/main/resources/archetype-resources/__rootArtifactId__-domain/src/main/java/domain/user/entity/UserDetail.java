#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.user.entity;

import com.alibaba.cola.domain.Entity;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 用户详情领域（实体）
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
public class UserDetail {

	/**
	 * 用户昵称
	 */
	private String nickName;

	/**
	 * 用户真实姓名
	 */
	private String realName;

	/**
	 * 用户性别（0男 1女 2未知）
	 */
	private String sex;

	/**
	 * 出生日期
	 */
	private LocalDateTime birthday;

	/**
	 * 头像地址
	 */
	private String avatar;

	/**
	 * 证件类型
	 */
	private String idType;

	/**
	 * 证件号
	 */
	private String idNo;

	/**
	 * 学历（0初中，1高中，2中专，3大专，4本科，5硕士，6博士，7其他）
	 */
	private String education;
}
