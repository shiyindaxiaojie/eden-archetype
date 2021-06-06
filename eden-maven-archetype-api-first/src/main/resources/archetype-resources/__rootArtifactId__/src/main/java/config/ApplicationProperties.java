#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 应用配置属性
 *
 * @author gyl
 * @since 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

	private final RamApi ramApi = new RamApi();

  private final CurrencyApi currencyApi = new CurrencyApi();

	@Data
	public static class RamApi {

		private String basePath;
	}

  @Data
  public static class CurrencyApi {

    private String basePath;
  }
}
