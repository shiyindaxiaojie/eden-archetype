#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.manager.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class CurrencyVM {
  private String baseCountry;

  private String baseCurrency;

  private List<Rates> rates;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("unused")
  public static class Rates {
    private Double id;

    private String name;

    @JsonProperty("name_zh")
    private String nameZh;

    private String code;

    @JsonProperty("currency_name")
    private String currencyName;

    @JsonProperty("currency_name_zh")
    private String currencyNameZh;

    @JsonProperty("currency_code")
    private String currencyCode;

    private BigDecimal rate;

    private Double hits;

    private Double selected;

    private Double top;

    private Integer lat;

    private Integer lng;

    private String code3;

    @JsonProperty("code_num")
    private String codeNum;
  }
}
