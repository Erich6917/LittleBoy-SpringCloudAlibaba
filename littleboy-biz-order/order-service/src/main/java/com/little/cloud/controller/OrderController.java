package com.little.cloud.controller;

import com.little.cloud.commom.ResultData;
import com.little.cloud.dto.Account;
import com.little.cloud.dto.Order;
import com.little.cloud.service.AccountService;
import com.little.cloud.service.OrderService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-17
 */
@RestController
@Slf4j
@RequestMapping("/api/order")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping("/{accountCode}")
  public ResultData<List<Order>> getByCode(@PathVariable String accountCode) {
    log.info("get order detail,accountCode is :{}", accountCode);
    List<Order> list =  orderService.getOrderListByAccountCode(accountCode);
    return ResultData.success(list);
  }

}
