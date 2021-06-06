#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.ylzl.eden.spring.boot.framework.web.rest.errors.ErrorAssert;

/**
 * TODO
 *
 * @author gyl
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum AuthErrorEnum implements ErrorAssert {
  LOGIN_INVALID("获取不到当前登录用户");

  private String message;
}
