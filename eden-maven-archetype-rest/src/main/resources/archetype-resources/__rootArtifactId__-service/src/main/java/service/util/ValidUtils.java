#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.util;

import com.google.common.base.CaseFormat;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.ylzl.eden.spring.boot.commons.lang.reflect.ReflectionUtils;
import org.ylzl.eden.spring.boot.support.dao.util.SortRuleEnum;

import java.util.Arrays;

/**
 * 校验工具集
 *
 * @author gyl
 * @since 0.0.1
 */
@UtilityClass
public class ValidUtils {

  /**
   * 是否属于有效排序列
   *
   * @param clazz
   * @param sortColumn
   * @return
   */
  public static boolean isValidSortColumns(Class<?> clazz, String sortColumn) {
    return StringUtils.isNotEmpty(sortColumn)
        ? ReflectionUtils.getDeclaredFields(clazz).stream()
            .anyMatch(
                field ->
                    CaseFormat.LOWER_CAMEL
                        .to(CaseFormat.LOWER_UNDERSCORE, field.getName())
                        .equals(sortColumn))
        : true;
  }

  /**
   * 是否符合排序规则
   *
   * @param sortRule
   * @return
   */
  public static boolean isValidSortRule(String sortRule) {
    return StringUtils.isNotEmpty(sortRule)
        ? Arrays.stream(SortRuleEnum.values())
            .anyMatch(name -> name.toString().toLowerCase().equals(sortRule))
        : true;
  }
}
