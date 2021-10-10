#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.jaxrs;

import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.api.validation.ResteasyViolationExceptionMapper;
import org.jboss.resteasy.api.validation.Validation;
import org.springframework.stereotype.Component;
import org.ylzl.eden.spring.boot.framework.web.rest.vm.ErrorVM;

import javax.validation.ValidationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Resteasy 自定义校验器
 *
 * @author gyl
 * @since 0.0.1
 */
@Slf4j
@Component
@Provider
public class CustomResteasyViolationExceptionMapper extends ResteasyViolationExceptionMapper {

  @Override
  public Response toResponse(ValidationException ex) {
    ErrorVM entity = ErrorVM.builder().message("客户端请求异常").description(ex.getMessage()).build();
    Response.ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST).entity(entity);
    builder.type(MediaType.APPLICATION_JSON);
    builder.header(Validation.VALIDATION_HEADER, Boolean.TRUE.toString());
    log.warn("参数校验不通过：{}", ex.getMessage(), ex);
    return builder.build();
  }
}
