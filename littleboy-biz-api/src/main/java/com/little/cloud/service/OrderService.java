package com.little.cloud.service;

import com.little.cloud.dto.Account;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.little.cloud.dto.Order;
import com.little.cloud.dao.OrderDao;

@Service
public class OrderService{

    @Resource
    private OrderDao orderDao;

    public int insert(Order pojo){
        return orderDao.insert(pojo);
    }

    public int insertSelective(Order pojo){
        return orderDao.insertSelective(pojo);
    }

    public int insertList(List<Order> pojos){
        return orderDao.insertList(pojos);
    }

    public int update(Order pojo){
        return orderDao.update(pojo);
    }

    public List<Order> getOrderListByAccountCode(String accountCode) {
        return orderDao.getOrderListByAccountCode(accountCode);
    }
}
