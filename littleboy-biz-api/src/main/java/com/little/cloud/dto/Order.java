package com.little.cloud.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-24
 */
@Data
@ApiModel(value = "产品封装类ProductDTO",description = "产品相关信息封装，用于接口传参")
public class Order {
  @ApiModelProperty(value = "产品主键")
  private Long id;
  @ApiModelProperty(value = "订单编码")
  private String orderNo;
  @ApiModelProperty(value = "账户编码")
  private String accountCode;
  @ApiModelProperty(value = "产品编码")
  private String productCode;
  @ApiModelProperty(value = "数量")
  private int count;
  @ApiModelProperty(value = "总价")
  private BigDecimal amount;
}
