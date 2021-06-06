#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.ylzl.eden.spring.boot.framework.web.rest.errors.ErrorAssert;

/**
 * 分页参数错误枚举
 *
 * @author fc
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum PageableErrorEnum implements ErrorAssert {
  WRONG_SORT_COLUMN_PARAMETER("排序列参数错误"),
  WRONG_SORT_RULE_PARAMETER("排序规则参数错误");

  private String message;
}
