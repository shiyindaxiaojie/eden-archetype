#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.dataobject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表数据库对象
 *
 * @author gyl
 * @since 2.4.x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@ToString
@TableName("sys_user")
public class UserDO implements Serializable {

	/**
	 * 用户id
	 */
	@TableId("user_id")
	private Long userId;

	/**
	 * 部门id
	 */
	@TableField("dept_id")
	private Long deptId;

	/**
	 * 用户账号
	 */
	@TableField("user_name")
	private String userName;

	/**
	 * 用户昵称
	 */
	@TableField("nick_name")
	private String nickName;

	/**
	 * 用户类型
	 */
	@TableField("user_type")
	private String userType;

	/**
	 * 用户真实姓名
	 */
	@TableField("real_name")
	private String realName;

	/**
	 * 用户邮箱
	 */
	@TableField("email")
	private String email;

	/**
	 * 手机号码
	 */
	@TableField("phonenumber")
	private String phonenumber;

	/**
	 * 用户性别（0男 1女 2未知）
	 */
	@TableField("sex")
	private String sex;

	/**
	 * 头像地址
	 */
	@TableField("avatar")
	private String avatar;

	/**
	 * 密码
	 */
	@TableField("password")
	private String password;

	/**
	 * 帐号状态（0正常 1停用）
	 */
	@TableField("status")
	private String status;

	/**
	 * 删除标志（0代表存在 2代表删除）
	 */
	@TableField("del_flag")
	private Integer delFlag;

	/**
	 * 最后登录ip
	 */
	@TableField("login_ip")
	private String loginIp;

	/**
	 * 最后登录时间
	 */
	@TableField("login_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date loginDate;

	/**
	 * 创建者
	 */
	@TableField("create_by")
	private String createBy;

	/**
	 * 创建时间
	 */
	@TableField("create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 更新者
	 */
	@TableField("update_by")
	private String updateBy;

	/**
	 * 更新时间
	 */
	@TableField("update_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;

	/**
	 * 密码提示
	 */
	@TableField("pwd_tip")
	private String pwdTip;

	/**
	 * 有效期限类型(0不限,1固定期限)
	 */
	@TableField("valid_type")
	private String validType;

	/**
	 * 使用开始时间
	 */
	@TableField("valid_start_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date validStartTime;

	/**
	 * 使用结束时间
	 */
	@TableField("valid_end_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date validEndTime;

	/**
	 * 是否通知（0不通知，1通知）
	 */
	@TableField("inform")
	private String inform;

	/**
	 * 证件类型
	 */
	@TableField("id_type")
	private String idType;

	/**
	 * 证件号
	 */
	@TableField("id_no")
	private String idNo;

	/**
	 * 职位id
	 */
	@TableField("post_id")
	private Long postId;

	/**
	 * 出生日期
	 */
	@TableField("birthday")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday;

	/**
	 * 身份证
	 */
	@TableField("id_card")
	private String idCard;

	/**
	 * 学历（0初中，1高中，2中专，3大专，4本科，5硕士，6博士，7其他）
	 */
	@TableField("education")
	private String education;

	/**
	 * 工号
	 */
	@TableField("job_no")
	private String jobNo;

	/**
	 * 导师
	 */
	@TableField("tutor")
	private String tutor;

	/**
	 * 普益基金部门
	 */
	@TableField("pyfund_dept")
	private String pyfundDept;

	/**
	 * 普益基金用户id
	 */
	@TableField("puyitou_user_id")
	private String puyitouUserId;

	/**
	 * 学习寄语
	 */
	@TableField("motto")
	private String motto;
}
