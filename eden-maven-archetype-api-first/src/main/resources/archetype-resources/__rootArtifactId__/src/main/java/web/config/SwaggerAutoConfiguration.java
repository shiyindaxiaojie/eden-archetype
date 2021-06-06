package ${package}.web.config;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.ParseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * TODO
 *
 * @author gyl
 * @version 1.0.0
 */
@Configuration
public class SwaggerAutoConfiguration {

	@Bean
	public OpenAPI openapi() throws IOException {
		ClassPathResource openapiResource = new ClassPathResource("openapi.yaml");
		try (InputStream is = openapiResource.getInputStream()) {
			return new OpenAPIParser()
				.readContents(
					StreamUtils.copyToString(is, Charset.defaultCharset()), null, new ParseOptions())
				.getOpenAPI();
		}
	}
}
