package com.little.cloud.service;

import com.little.cloud.dto.Order;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-24
 */

@FeignClient("order-service")
public interface FeignOrderService {

  @GetMapping("{accountCode}")
  List<Order> getOrderListByAccountCode(@PathVariable String accountCode);
}
