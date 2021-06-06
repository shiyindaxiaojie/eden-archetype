#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ylzl.eden.spring.boot.framework.core.ProfileConstants;

/**
 * Swagger 文件
 *
 * @author gyl
 * @since 1.0.0
 */
@Profile("!" + ProfileConstants.SPRING_PROFILE_PRODUCTION)
@Controller
public class SwaggerController {

  private final OpenAPI openApi;

  public SwaggerController(OpenAPI openApi) {
    this.openApi = openApi;
  }

	/**
	 * 获取 openapi.yaml
	 *
	 * @return
	 * @throws JsonProcessingException
	 */
  @GetMapping(value = "/openapi.yaml", produces = "application/vnd.oai.openapi")
  @ResponseBody
  public String openapiYaml() throws JsonProcessingException {
    return Yaml.mapper().writeValueAsString(openApi);
  }

	/**
	 * 获取 openapi.json
	 *
	 * @return
	 * @throws JsonProcessingException
	 */
  @GetMapping(value = "/openapi.json", produces = "application/json")
  @ResponseBody
  public String openapiJson() throws JsonProcessingException {
    return Json.mapper().writeValueAsString(openApi);
  }
}
