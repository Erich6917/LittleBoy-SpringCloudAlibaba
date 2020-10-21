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
}
