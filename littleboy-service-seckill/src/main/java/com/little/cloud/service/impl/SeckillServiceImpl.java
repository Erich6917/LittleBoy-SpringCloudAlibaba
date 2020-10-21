package com.little.cloud.service.impl;

import com.little.cloud.aop.Servicelock;
import com.little.cloud.dto.Seckill;
import com.little.cloud.dto.SuccessKilled;
import com.little.cloud.service.ISeckillService;
import com.little.cloud.service.SeckillService;
import com.little.cloud.service.SuccessKilledService;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
  /**
   * 思考：为什么不用synchronized service 默认是单例的，并发下lock只有一个实例 互斥锁 参数默认false，不公平锁
   */
  private Lock lock = new ReentrantLock(true);

  @Override
  public void initSeckill(long seckillId) {

    //删除成功历时记录
    successKilledService.deleteById(seckillId);

    //重置秒杀商品数量
    seckillService.initSeckill(seckillId);

  }

  @Override
  @Transactional
  public void startSeckill(long killId, long userId) {
    startKill(killId, userId);
    /**
     * mybatis 如何分表保存
     */

  }

  private boolean startKill(long killId, long userId) {
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
      return Boolean.TRUE;
    } else {
//      log.info("sorry {} 商品已抢空", userId);
      return Boolean.FALSE;
    }
  }

  @Override
  public int getCountKill(long killId) {

    return successKilledService.countKilled(killId);

  }

  @Override
  @Transactional
  public Boolean startSeckillLock(long killId, long userId) {
    lock.lock();
    Boolean rtFlag = Boolean.FALSE;
    try {
      rtFlag = startKill(killId, userId);
    } catch (Exception e) {
      log.info("抢购异常 {}", e);
    } finally {
      lock.unlock();
    }
    return rtFlag;
  }

  @Override
  @Transactional
  @Servicelock
  public Boolean startAopSeckillLock(long killId, long userId) {
    Boolean rtFlag = Boolean.FALSE;
    try {
      rtFlag = startKill(killId, userId);
    } catch (Exception e) {
      log.info("抢购异常 {}", e);
    }
    return rtFlag;
  }
}
