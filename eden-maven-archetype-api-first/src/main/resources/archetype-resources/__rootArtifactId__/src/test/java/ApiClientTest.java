#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${package}.client.CurrencyApi;
import ${package}.client.vm.CurrencyVM;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * API 客户端单元测试
 *
 * @author gyl
 * @since 1.0.0
 */
@DisplayName("API 测试用例")
@RunWith(SpringRunner.class)
@SpringBootTest
public class LazadaApiClientTest {

  @Autowired private CurrencyApi currencyApi;

  @DisplayName("获取实时汇率")
  @Test
  public void assertgGetCurrency() {
    Assertions.assertDoesNotThrow(
        () -> {
          CurrencyVM currencyVM = currencyApi.getCurrency("MY");
          System.out.println(currencyVM);
          //			Assertions.assertEquals(true, "true".equals(courseVM.getSuccess()));
        });
  }
}
