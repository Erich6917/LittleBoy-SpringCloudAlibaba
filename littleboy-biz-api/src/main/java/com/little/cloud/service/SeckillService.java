package com.little.cloud.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.little.cloud.dto.Seckill;
import com.little.cloud.dao.SeckillDao;

@Service
public class SeckillService{

    @Resource
    private SeckillDao seckillDao;

    public int insert(Seckill pojo){
        return seckillDao.insert(pojo);
    }

    public int insertSelective(Seckill pojo){
        return seckillDao.insertSelective(pojo);
    }

    public int insertList(List<Seckill> pojos){
        return seckillDao.insertList(pojos);
    }

    public int update(Seckill pojo){
        return seckillDao.update(pojo);
    }

    public int initSeckill(long seckillId) {
        return seckillDao.initSeckill(seckillId);
    }

    public Seckill selectById(long killId) {
        return seckillDao.selectById(killId);
    }

    public int cutOne(long killId) {
        return seckillDao.cutOne(killId);
    }
}
