package com.little.cloud.controller;

import com.little.cloud.ResultData;
import com.little.cloud.dto.Order;
import com.little.cloud.dto.Product;
import com.little.cloud.service.FeignOrderService;
import com.little.cloud.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-17
 */
@RestController
@Slf4j
@RequestMapping("/api/order")
@Api(tags = "Order模块")
public class OrderController {

  @Autowired
  private OrderService orderService;

//  @Autowired
//  private FeignOrderService feignOrderService;

  @GetMapping("/{accountCode}")
  @ApiOperation(value = "订单查询-根据产品编码查找对应的产品")
  public ResultData<List<Order>> getByCode(@PathVariable String accountCode) {
    log.info("get order detail,accountCode is :{}", accountCode);
    List<Order> list = orderService.getOrderListByAccountCode(accountCode);
//    List<Order> list = feignOrderService.getOrderListByAccountCode(accountCode);
    return ResultData.success(list);
  }

  @PostMapping("/insert")
  @ApiOperation(value = "订单保存")
  public ResultData<String> insert(@RequestBody Order product){
    log.info("insert product:{}",product);
    orderService.insert(product);
    return ResultData.success("insert product succeed");
  }

}
