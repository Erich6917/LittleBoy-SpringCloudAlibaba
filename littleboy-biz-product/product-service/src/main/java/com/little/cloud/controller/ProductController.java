package com.little.cloud.controller;

import com.little.cloud.commom.ResultData;
import com.little.cloud.dto.Product;
import com.little.cloud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-17
 */
@RestController
@Slf4j
@RequestMapping("/api/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("{productCode}")
  public ResultData<Product> getByCode(@PathVariable String productCode) {
    log.info("get product detail,productCode is :{}", productCode);
    Product product = productService.getProductByCode(productCode);
    return ResultData.success(product);
  }
}
