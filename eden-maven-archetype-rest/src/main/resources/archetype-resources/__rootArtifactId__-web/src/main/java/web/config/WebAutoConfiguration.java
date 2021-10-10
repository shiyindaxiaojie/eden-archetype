package ${package}.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.ylzl.eden.spring.boot.framework.core.FrameworkProperties;
import org.ylzl.eden.spring.boot.framework.core.util.PathMatcherConstants;
import org.ylzl.eden.spring.boot.framework.web.WebConfigurerAdapter;
import org.ylzl.eden.spring.boot.framework.web.filter.CorsFilterBuilder;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Web 自动配置
 *
 * @author gyl
 * @since 1.0.0
 */
@Slf4j
@Configuration
public class WebAutoConfiguration extends WebConfigurerAdapter {

  public WebAutoConfiguration(FrameworkProperties properties, Environment env) {
    super(properties, env);
  }

  @Override
  public void onStartup(ServletContext servletContext) {
    super.onStartup(servletContext);
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("*")
        .allowedHeaders("Content-Type");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("/swagger-ui/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/3.14.2/");
  }

  @Bean
  public CorsFilter corsFilter(FrameworkProperties frameworkProperties) {
    CorsConfiguration corsConfiguration = frameworkProperties.getCors();
    List<String> paths = new ArrayList<>();
    if (corsConfiguration.getAllowedOrigins() != null
        && !corsConfiguration.getAllowedOrigins().isEmpty()) {
      paths.add(PathMatcherConstants.ALL_CHILD_PATTERN);
    }
    return CorsFilterBuilder.builder().corsConfiguration(corsConfiguration).paths(paths).build();
  }
}
