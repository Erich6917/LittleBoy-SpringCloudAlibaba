package com.little.cloud.dto;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-24
 */
@Data
public class Product {

  private Long id;
  private String productCode;
  private String productName;
  private int count;
  private BigDecimal price;
}
