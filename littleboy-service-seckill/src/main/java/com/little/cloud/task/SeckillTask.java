package com.little.cloud.task;

import com.little.cloud.service.ISeckillService;
import java.util.concurrent.CountDownLatch;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-10-22
 */
@Data
@Slf4j
public class SeckillTask implements Runnable {


  @Autowired
  private ISeckillService seckillService;

  private CountDownLatch countDownLatch;
  private Long userId;
  private Long killId;

  public SeckillTask(CountDownLatch countDownLatch, Long userId, Long killId) {
    this.countDownLatch = countDownLatch;
    this.userId = userId;
    this.killId = killId;
  }

  public SeckillTask(CountDownLatch countDownLatch, Long userId, Long killId,ISeckillService seckillService) {
    this.seckillService = seckillService;
    this.countDownLatch = countDownLatch;
    this.userId = userId;
    this.killId = killId;
  }

  @Override
  public void run() {
    Boolean flag = seckillService.startSeckillLock(killId, userId);
    if (flag) {
      log.info("抢购成功 user {}", userId);
    } else {
      log.info("抢购失败 user {}", userId);
    }
    //数量消耗要在任务执行到的时候扣掉
    countDownLatch.countDown();

  }
}
