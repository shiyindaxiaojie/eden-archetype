#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.elasticseach.config;

import ${package}.constant.ApplicationConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Elasticsearch 自动配置类
 *
 * @author gyl
 * @version 1.0.0
 */
@EnableElasticsearchRepositories("${package}.dao.elasticsearch")
@Slf4j
@Configuration
public class ElasticsearchAutoConfiguration {
}
