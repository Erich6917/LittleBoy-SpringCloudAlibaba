package com.little.cloud.dto;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-17
 */
@Data
public class Account {

  private Long id;
  private String accountCode;
  private String accountName;
  private BigDecimal amount;
}
