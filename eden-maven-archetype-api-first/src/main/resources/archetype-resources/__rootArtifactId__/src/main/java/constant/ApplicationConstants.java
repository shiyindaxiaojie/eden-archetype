#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.constant;

import lombok.experimental.UtilityClass;

/**
 * 应用常量定义
 *
 * @author gyl
 * @since 1.0.0
 */
@UtilityClass
public class ApplicationConstants {

  /** Application Package */
  public static final String BASE_PACKAGE = "${package}";

  /** 所有业务字符串类型的默认值（前端缺省条件） */
  public static final String DEFAULT_STR_VALUE = "-1";

  /** 所有业务整型类型的默认值（前端缺省条件） */
  public static final int DEFAULT_INT_VALUE = -1;

  /** 所有业务长整型类型的默认值（前端缺省条件） */
  public static final long DEFAULT_LONG_VALUE = -1L;

  /** 增删改返回值大于0的都为成功 */
  public static final int DEFAULT_SUCCESS_VALUE = 0;
}
