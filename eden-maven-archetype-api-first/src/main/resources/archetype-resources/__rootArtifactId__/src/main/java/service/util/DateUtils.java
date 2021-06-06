#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.util;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.apache.commons.compress.utils.Lists;
import org.ylzl.eden.spring.boot.commons.lang.StringConstants;
import org.ylzl.eden.spring.boot.commons.lang.time.DateFormatEnum;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Date 工具集
 *
 * @author fc
 */
@UtilityClass
public class DateUtils {

  /**
   * 获取相对时间
   *
   * @param date
   * @param amount
   * @return
   */
  public static String getRelativeTime(Date date, int amount) {
    Date addDates = org.ylzl.eden.spring.boot.commons.lang.time.DateUtils.addDays(date, amount);
    return org.ylzl.eden.spring.boot.commons.lang.time.DateUtils.toDateString(addDates);
  }

  /**
   * 转换时间格式 0000-00-00 00:00:00 —> 0000-00-00
   *
   * @param dateTimeStr 需要转换的时间
   * @return
   */
  public static String toDateStr(@NonNull String dateTimeStr) {
    return dateTimeStr.split(StringConstants.SPACE)[0];
  }

  /**
   * 转换时间格式 Date时间格式 —> String时间格式0000-00-00
   *
   * @param dateTimeStr 需要转换的时间
   * @return
   */
  public static String toDateStr(@NonNull Date dateTimeStr) {
    return org.ylzl.eden.spring.boot.commons.lang.time.DateUtils.toDateString(dateTimeStr);
  }

  /**
   * 转换时间格式 String时间格式0000-00-00 -> Date时间格式
   *
   * @param dateTimeStr 需要转换的时间
   * @return
   */
  public static Date toDate(@NonNull String dateTimeStr) {
    Date date = null;
    try {
      date =
          org.ylzl.eden.spring.boot.commons.lang.time.DateUtils.toDate(
              dateTimeStr, DateFormatEnum.ISO_8601_EXTENDED_DATE_FORMAT.getPattern());
    } catch (ParseException e) {
      throw new RuntimeException("转换时间格式 String时间格式0000-00-00 -> Date时间格式 异常");
    }
    return date;
  }

  /**
   * 根据创建时间获取创建时间到昨天期间的所有时间
   *
   * @param gmtCreate 创建时间
   * @return 所有时间
   */
  public static List<String> getTimest(String gmtCreate) {
    List<String> datesStr = Lists.newArrayList();
    Date gmtCreateDate = toDate(gmtCreate);
    Date yesterdayDate = toDate(DateUtils.getRelativeTime(new Date(), -1));
    while (gmtCreateDate.getTime() <= yesterdayDate.getTime()) {
      datesStr.add(toDateStr(gmtCreateDate));
      gmtCreateDate = toDate(DateUtils.getRelativeTime(gmtCreateDate, 1));
    }
    return datesStr;
  }
}
