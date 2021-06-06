#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.manager.rest;

import ${package}.manager.rest.vm.CurrencyVM;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 实时汇率接口
 *
 * @author gyl
 * @since 0.0.1
 */
public interface CurrencyApi {

  @GET
  @Path("/{code}.json")
  @Produces({MediaType.APPLICATION_JSON})
  CurrencyVM getCurrency(@PathParam("code") String code);
}
