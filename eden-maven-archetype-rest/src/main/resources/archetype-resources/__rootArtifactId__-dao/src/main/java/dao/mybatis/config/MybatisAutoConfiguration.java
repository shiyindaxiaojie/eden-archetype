#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.mybatis.config;

import ${package}.constant.ApplicationConstants;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Mybatis 自动配置
 *
 * @author gyl
 * @since 0.0.1
 */
@MapperScan("${package}.mybatis.mapper")
@Slf4j
@Configuration
public class MybatisAutoConfiguration {
}
