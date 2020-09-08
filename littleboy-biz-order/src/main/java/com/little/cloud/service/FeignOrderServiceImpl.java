package com.little.cloud.service;

import com.little.cloud.dto.Order;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-24
 */
@Service
public class FeignOrderServiceImpl implements FeignOrderService {

  @Autowired
  private OrderService orderService;

  @Override
  public List<Order> getOrderListByAccountCode(String accountCode) {
    return orderService.getOrderListByAccountCode(accountCode);
  }
}
