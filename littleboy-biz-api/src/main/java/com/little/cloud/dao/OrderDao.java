package com.little.cloud.dao;

import com.little.cloud.dto.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.little.cloud.dto.Order;

@Mapper
public interface OrderDao {

  int insert(@Param("pojo") Order pojo);

  int insertSelective(@Param("pojo") Order pojo);

  int insertList(@Param("pojos") List<Order> pojo);

  int update(@Param("pojo") Order pojo);

  List<Order> getOrderListByAccountCode(@Param("accountCode")String accountCode);
}
