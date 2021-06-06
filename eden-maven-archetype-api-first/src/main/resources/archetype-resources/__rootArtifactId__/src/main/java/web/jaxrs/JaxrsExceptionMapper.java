#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.jaxrs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.ylzl.eden.spring.boot.framework.web.rest.errors.BadRequestAlertException;
import org.ylzl.eden.spring.boot.framework.web.rest.vm.ErrorVM;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Jaxrs 统一异常处理器
 *
 * @author gyl
 * @since 0.0.1
 */
@Slf4j
@Component
@Provider
public class JaxrsExceptionMapper implements ExceptionMapper<Throwable> {

  @Override
  public Response toResponse(Throwable t) {
    ErrorVM vm = build(t);
    Response.ResponseBuilder builder =
        Response.status(Response.Status.fromStatusCode(vm.getStatusCode())).entity(vm);
    builder.type(MediaType.APPLICATION_JSON);
    log.error("系统错误：{}", t.getMessage(), t);
    return builder.build();
  }

  public static ErrorVM build(Throwable t) {
    ErrorVM errorVM = ErrorVM.builder().build();
    if (t instanceof BadRequestAlertException) {
      BadRequestAlertException ex = (BadRequestAlertException) t;
      errorVM.setMessage(ex.getMessage());
      errorVM.setDescription(ex.getDescription());
      errorVM.setStatusCode(ex.getStatusCode());
    } else {
      errorVM.setMessage("服务器内部错误");
      errorVM.setDescription(t.getMessage());
      errorVM.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
    return errorVM;
  }
}
