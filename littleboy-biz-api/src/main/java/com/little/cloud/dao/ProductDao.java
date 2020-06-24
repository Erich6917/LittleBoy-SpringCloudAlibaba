package com.little.cloud.dao;

import com.little.cloud.dto.Product;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductDao {

  int insert(@Param("pojo") Product pojo);

  int insertSelective(@Param("pojo") Product pojo);

  int insertList(@Param("pojos") List<Product> pojo);

  int update(@Param("pojo") Product pojo);

  Product getProductByCode(@Param("productCode") String productCode);
}
