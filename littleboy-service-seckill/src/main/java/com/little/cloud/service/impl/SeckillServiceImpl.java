package com.little.cloud.service.impl;

import com.little.cloud.dto.Seckill;
import com.little.cloud.dto.SuccessKilled;
import com.little.cloud.service.ISeckillService;
import com.little.cloud.service.SeckillService;
import com.little.cloud.service.SuccessKilledService;
import java.util.Date;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-10-21
 */
@Service
@Slf4j
public class SeckillServiceImpl implements ISeckillService {

  @Resource
  SeckillService seckillService;
  @Resource
  SuccessKilledService successKilledService;

  @Override
  public void initSeckill(long seckillId) {

    //删除成功历时记录
    successKilledService.deleteById(seckillId);

    //重置秒杀商品数量
    seckillService.initSeckill(seckillId);

  }

  @Override
  public void startSeckill(long killId, long userId) {
    //查询商品数量
    Seckill seckill = seckillService.selectById(killId);
    //大于0 进行商品扣减 并进行生成成功抢购记录

    Long number = seckill.getNumber();
    if (number > 0) {

      SuccessKilled successKilled = new SuccessKilled();
      successKilled.setUserId(userId);
      successKilled.setCreateTime(new Date());
      successKilled.setSeckillId(killId);
      successKilled.setState(0);
      successKilledService.insert(successKilled);


      seckillService.cutOne(killId);

    }else{
      log.info("商品已抢空");
    }
    /**
     * mybatis 如何分表保存
     */

  }

  @Override
  public int getCountKill(long killId) {

   return  successKilledService.countKilled(killId);

  }
}
