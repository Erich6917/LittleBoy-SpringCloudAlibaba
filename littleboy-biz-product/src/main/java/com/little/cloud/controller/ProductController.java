package com.little.cloud.controller;

import com.little.cloud.ResultData;
import com.little.cloud.dto.Product;
import com.little.cloud.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/api/product")
@Api(tags = "Product模块")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("{productCode}")
  @ApiOperation(value = "产品查询-根据产品编码查找对应的产品")
  public ResultData<Product> getByCode(@PathVariable String productCode) {
    log.info("get product detail,productCode is :{}", productCode);
    Product product = productService.getProductByCode(productCode);
    return ResultData.success(product);
  }

  @PostMapping("/insert")
  @ApiOperation(value = "产品保存")
  public ResultData<String> insert(@RequestBody Product product){
    log.info("insert product:{}",product);
    productService.insert(product);
    return ResultData.success("insert product succeed");
  }

}
