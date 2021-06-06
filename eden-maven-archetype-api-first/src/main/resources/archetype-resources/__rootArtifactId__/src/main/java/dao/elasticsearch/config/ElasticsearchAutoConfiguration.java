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
@EnableElasticsearchRepositories(ElasticsearchAutoConfiguration.ELASTICSEARCH_PACKAGE)
@Slf4j
@Configuration
public class ElasticsearchAutoConfiguration {

	/** Redis Package */
	public static final String ELASTICSEARCH_PACKAGE = ApplicationConstants.BASE_PACKAGE + ".dao.elasticsearch";
}
