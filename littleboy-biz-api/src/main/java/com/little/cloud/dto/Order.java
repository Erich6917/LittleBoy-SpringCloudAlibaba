package com.little.cloud.dto;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-24
 */
@Data
public class Order {

  private Long id;
  private String orderNo;
  private String accountCode;
  private String productCode;
  private int count;
  private BigDecimal amount;
}
