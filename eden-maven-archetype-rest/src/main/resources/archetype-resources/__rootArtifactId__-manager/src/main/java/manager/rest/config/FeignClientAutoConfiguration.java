package ${package}.manager.rest.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ${package}.common.config.ApplicationProperties;
import ${package}.manager.rest.CurrencyApi;

/**
 * Feign 客户端自动配置类
 *
 * @author gyl
 * @since 0.0.1
 */
@EnableFeignClients
@Configuration
public class FeignClientAutoConfiguration {

  private final ObjectMapper objectMapper;

  private final LoadBalancerClient loadBalancer;

  private final ApplicationProperties applicationProperties;

  public FeignClientAutoConfiguration(
      ObjectMapper objectMapper,
      LoadBalancerClient loadBalancer,
      ApplicationProperties applicationProperties) {
    this.objectMapper = objectMapper;
    this.loadBalancer = loadBalancer;
    this.applicationProperties = applicationProperties;
  }

  @ConditionalOnMissingBean
  @Bean
  public CurrencyApi currencyApi() {
    return buildCurrencyApiClient(CurrencyApi.class);
  }

  private <T> T buildCurrencyApiClient(Class<T> clz) {
    return Feign.builder()
        .contract(new JAXRSContract())
        .client(new OkHttpClient())
        .encoder(new JacksonEncoder(objectMapper))
        .decoder(new JacksonDecoder(objectMapper))
        .logger(new Slf4jLogger())
        .target(clz, applicationProperties.getCurrencyApi().getBasePath());
  }
}
