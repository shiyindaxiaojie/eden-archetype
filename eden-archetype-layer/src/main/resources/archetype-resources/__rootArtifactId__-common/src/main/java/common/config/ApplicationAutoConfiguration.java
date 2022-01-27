#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 应用自动配置
 *
 * @author gyl
 * @since 2.4.x
 */
@EnableConfigurationProperties({ApplicationProperties.class})
@Slf4j
@Configuration
public class ApplicationAutoConfiguration {

}
