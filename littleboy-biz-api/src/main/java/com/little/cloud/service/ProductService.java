package com.little.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.little.cloud.dto.Product;
import com.little.cloud.dao.ProductDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
//@FeignClient(name = "account-service")
public class ProductService {

  @Resource
  private ProductDao productDao;

  public int insert(Product pojo) {
    return productDao.insert(pojo);
  }

  public int insertSelective(Product pojo) {
    return productDao.insertSelective(pojo);
  }

  public int insertList(List<Product> pojos) {
    return productDao.insertList(pojos);
  }

  public int update(Product pojo) {
    return productDao.update(pojo);
  }


  @GetMapping("{productCode}")
  public Product getProductByCode(@PathVariable String productCode) {
    return productDao.getProductByCode(productCode);
  }
}
