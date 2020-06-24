package com.little.cloud.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.little.cloud.dto.Product;
import com.little.cloud.dao.ProductDao;

@Service
public class ProductService{

    @Resource
    private ProductDao productDao;

    public int insert(Product pojo){
        return productDao.insert(pojo);
    }

    public int insertSelective(Product pojo){
        return productDao.insertSelective(pojo);
    }

    public int insertList(List<Product> pojos){
        return productDao.insertList(pojos);
    }

    public int update(Product pojo){
        return productDao.update(pojo);
    }

  public Product getProductByCode(String productCode) {
        return productDao.getProductByCode(productCode);
  }
}
