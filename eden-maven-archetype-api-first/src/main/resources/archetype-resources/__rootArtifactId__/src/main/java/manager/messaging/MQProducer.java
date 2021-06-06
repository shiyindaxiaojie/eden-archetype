#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.manager.messaging;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ylzl.eden.spring.boot.commons.json.JacksonUtils;
import org.ylzl.eden.spring.boot.commons.lang.RandomStringUtils;

/**
 * 发送消息到 MQ
 *
 * @author gyl
 * @since 0.0.1
 */
@Slf4j
@Component
public class MQProducer {

  @Autowired(required = false)
  private RocketMQTemplate rocketMQTemplate;

  /**
   * 发送消息
   *
   * @param topic 主题
   * @param data 数据
   * @param timeout 发送超时
   * @param <T> 数据类型
   */
  @SneakyThrows
  public <T> void send(String topic, T data, Long timeout) {
    String sendId = RandomStringUtils.randomNumeric(20);
    String msg = JacksonUtils.toJSONString(data);
    log.info("发送消息到 Broker，标识：{}，主题：{}，内容：{}", sendId, topic, msg);
    rocketMQTemplate.asyncSend(
        topic,
        msg,
        new SendCallback() {

          @Override
          public void onSuccess(SendResult sendResult) {
            log.info("Broker 处理成功，标识：{}", sendId);
          }

          @Override
          public void onException(Throwable throwable) {
            log.error("Broker 处理失败，标识：{}，异常：{}", sendId, throwable.getMessage());
          }
        },
        timeout);
  }
}
