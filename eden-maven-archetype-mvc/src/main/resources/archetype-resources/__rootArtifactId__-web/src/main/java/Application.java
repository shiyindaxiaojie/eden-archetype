#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.ylzl.eden.spring.boot.support.start.SpringBootApplicationTemplate;

/**
 * Spring Boot 引导类
 *
 * @author gyl
 * @since 1.0.0
 */
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class Application extends SpringBootApplicationTemplate {

  public Application(Environment env) {
    super(env);
  }

  /**
   * 启动入口
   *
   * @param args 命令行参数
   */
  public static void main(String[] args) {
		SpringApplication app = new SpringApplicationBuilder(Application.class).web(true).build();
    Environment env = run(app, args);
    logApplicationServerAfterRunning(env);
  }
}
