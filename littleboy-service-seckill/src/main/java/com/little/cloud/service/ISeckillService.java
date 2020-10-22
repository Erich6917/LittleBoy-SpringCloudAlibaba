package com.little.cloud.service;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-10-21
 */
public interface ISeckillService {

  public void initSeckill(long seckillId);

  void startSeckill(long killId, long userId);

  int getCountKill(long killId);

  Boolean startSeckillLock(long killId, long userId);

  Boolean startAopSeckillLock(long killId, long userId);

  Boolean startSeckilDBPCC_ONE(long killId, long userId);

  Boolean startSeckilDBPCC_TWO(long killId, long userId);
}
