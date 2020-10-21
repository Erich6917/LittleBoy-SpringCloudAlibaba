package com.little.cloud.controller;

import com.little.cloud.entity.Result;
import com.little.cloud.service.ISeckillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 不要较真 这只是一个模拟多线程秒杀案例
 */
@Api(tags = "秒杀")
@RestController
@RequestMapping("/seckill")
@Slf4j
public class SeckillController {


  private static int corePoolSize = Runtime.getRuntime().availableProcessors();
  /**
   * 创建线程池  调整队列数 拒绝服务
   */
  private static ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,
      corePoolSize + 1, 10l, TimeUnit.SECONDS,
      new LinkedBlockingQueue<>(1000));

  @Autowired
  private ISeckillService seckillService;

  @ApiOperation(value = "秒杀一(最low实现)", nickname = "爪哇笔记")
  @PostMapping("/start")
  public Result start(long killId) {
    log.info("开始秒杀一(会出现超卖) {}", killId);
    seckillService.initSeckill(killId);

    int totalNum = 1000;
    CountDownLatch latch = new CountDownLatch(totalNum);
    for (int i = 0; i < totalNum; i++) {
      final long userId = i;
      log.info("抢购中 user {}", userId);

      Runnable task = () -> {
        seckillService.startSeckill(killId, userId);
        //数量消耗要在任务执行到的时候扣掉
        latch.countDown();
      };
      executor.execute(task);
    }
    try {
      latch.await();
    } catch (InterruptedException e) {
      log.info("秒杀统计异常 {}", e);
    }
    int killCount = seckillService.getCountKill(killId);
    log.info("本次秒杀商品ID [{}]攻击秒杀个数 {}", killId, killCount);

    return Result.ok();
  }

  @ApiOperation(value = "秒杀二(程序锁)", nickname = "科帮网")
  @PostMapping("/startLock")
  public Result startLock(long seckillId) {
    log.info("开始秒杀二(正常)");
    return Result.ok();
  }

  @ApiOperation(value = "秒杀三(AOP程序锁)", nickname = "科帮网")
  @PostMapping("/startAopLock")
  public Result startAopLock(long seckillId) {
    log.info("开始秒杀三(正常)");
    return Result.ok();
  }

  @ApiOperation(value = "秒杀四(数据库悲观锁)", nickname = "科帮网")
  @PostMapping("/startDBPCC_ONE")
  public Result startDBPCC_ONE(long seckillId) {
    return Result.ok();
  }

  @ApiOperation(value = "秒杀五(数据库悲观锁)", nickname = "科帮网")
  @PostMapping("/startDPCC_TWO")
  public Result startDPCC_TWO(long seckillId) {
    return Result.ok();
  }

  @ApiOperation(value = "秒杀六(数据库乐观锁)", nickname = "科帮网")
  @PostMapping("/startDBOCC")
  public Result startDBOCC(long seckillId) {
    return Result.ok();
  }

  @ApiOperation(value = "秒杀柒(进程内队列)", nickname = "科帮网")
  @PostMapping("/startQueue")
  public Result startQueue(long seckillId) {
    return Result.ok();
  }

  @ApiOperation(value = "秒杀柒(Disruptor队列)", nickname = "科帮网")
  @PostMapping("/startDisruptorQueue")
  public Result startDisruptorQueue(long seckillId) {

    return Result.ok();
  }
}
