#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.jaxrs;

import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Jaxrs 启动器
 *
 * @author gyl
 * @since 0.0.1
 */
@Component
@ApplicationPath("/v1/")
public class JaxrsApplication extends Application {}
