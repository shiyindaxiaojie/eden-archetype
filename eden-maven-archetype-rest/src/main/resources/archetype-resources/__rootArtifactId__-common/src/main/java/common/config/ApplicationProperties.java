#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.config;

import lombok.Data;
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

	private final CurrencyApi currencyApi = new CurrencyApi();

	@Data
	public static class CurrencyApi {

		private String basePath;
	}
}
