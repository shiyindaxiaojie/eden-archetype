package ${package}.web.config;

import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author gyl
 * @version 1.0.0
 */
@Configuration
public class JacksonAutoConfiguration {

	@Bean
	public JavaTimeModule javaTimeModule() {
		return new JavaTimeModule();
	}

	@Bean
	public Jdk8Module jdk8TimeModule() {
		return new Jdk8Module();
	}
}
