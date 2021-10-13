#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.aop.config;

import ${package}.aop.LoggingAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 切面自动配置
 *
 * @author gyl
 * @since 1.0.0
 */
@EnableAspectJAutoProxy
@Slf4j
@Configuration
public class AopAutoConfiguration {

  /**
   * 配置日志切面
   *
   * @return
   */
  @Bean
  public LoggingAspect loggingAspect() {
    log.debug("Autowired Logging aspect");
    return new LoggingAspect();
  }
}
