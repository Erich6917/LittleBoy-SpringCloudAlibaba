package com.little.cloud.controller;

import com.little.cloud.config.SpringContextUtil;
import com.little.cloud.entity.Result;
import com.little.cloud.service.ISeckillService;
import com.little.cloud.task.SeckillTask;
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
      new LinkedBlockingQueue<>(2000));

  @Autowired
  private ISeckillService seckillService;

  @ApiOperation(value = "秒杀一(最low实现)", nickname = "爪哇笔记")
  @PostMapping("/start")
  public Result demo_010_start(long killId) {
    log.info("开始秒杀一(会出现超卖) {}", killId);
    seckillService.initSeckill(killId);

    int totalNum = 1050;
    CountDownLatch latch = new CountDownLatch(totalNum);
    for (int i = 0; i < totalNum; i++) {
      final long userId = i;
      Runnable task = () -> {
        log.info("抢购中 user {}", userId);
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
    log.info("本次秒杀商品ID [{}] 抢购人数{} 秒杀个数 {}", killId, totalNum, killCount);

    return Result.ok();
  }

  @ApiOperation(value = "秒杀二(程序锁)", nickname = "科帮网")
  @PostMapping("/startLock")
  public Result demo_020_startLock(long killId) {
    log.info("开始秒杀二(出现超卖,事务提交和锁释放的前后顺序) {}", killId);
    seckillService.initSeckill(killId);
    int totalNum = 20;
    CountDownLatch latch = new CountDownLatch(totalNum);
    for (int i = 0; i < totalNum; i++) {
      final long userId = i;
      Runnable task = () -> {
        Boolean flag = seckillService.startSeckillLock(killId, userId);
        if (flag) {
          log.info("抢购成功 user {}", userId);
        } else {
          log.info("抢购失败 user {}", userId);
        }
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
    log.info("本次秒杀商品ID [{}] 抢购人数{} 秒杀个数 {}", killId, totalNum, killCount);
    return Result.ok();
  }

  @ApiOperation(value = "秒杀二(程序锁) demo2 task", nickname = "科帮网")
  @PostMapping("/startLock2")
  public Result demo_021_startLock(long killId) {
    log.info("开始秒杀二(出现超卖,事务提交和锁释放的前后顺序) {}", killId);
    seckillService.initSeckill(killId);
    int totalNum = 20;

    /**
     * 线程中调用service 处理具体的业务,在多线程时使用@Autowired总是获取不到bean，
     * 原因是：new thread不在spring容器中，也就无法获得spring中的bean对象。
     */
    ISeckillService ConfigService = SpringContextUtil.getBean(ISeckillService.class);

    CountDownLatch latch = new CountDownLatch(totalNum);
    for (int i = 0; i < totalNum; i++) {
      final long userId = i;
      SeckillTask task = new SeckillTask(latch, userId, killId, ConfigService);
      executor.execute(task);
    }
    try {
      latch.await();
    } catch (InterruptedException e) {
      log.info("秒杀统计异常 {}", e);
    }
    int killCount = seckillService.getCountKill(killId);
    log.info("本次秒杀商品ID [{}] 抢购人数{} 秒杀个数 {}", killId, totalNum, killCount);
    return Result.ok();
  }

  @ApiOperation(value = "秒杀三(AOP程序锁)", nickname = "科帮网")
  @PostMapping("/startAopLock")
  public Result startAopLock(long killId) {
    log.info("开始秒杀三(正常)");
    seckillService.initSeckill(killId);
    int totalNum = 20;
    CountDownLatch latch = new CountDownLatch(totalNum);
    for (int i = 0; i < totalNum; i++) {
      final long userId = i;
      Runnable task = () -> {
        Boolean flag = seckillService.startAopSeckillLock(killId, userId);
        if (flag) {
          log.info("抢购成功 user {}", userId);
        } else {
          log.info("抢购失败 user {}", userId);
        }
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
    log.info("本次秒杀商品ID [{}] 抢购人数{} 秒杀个数 {}", killId, totalNum, killCount);
    return Result.ok();
  }

  @ApiOperation(value = "秒杀四(数据库悲观锁)", nickname = "科帮网")
  @PostMapping("/startDBPCC_ONE")
  public Result startDBPCC_ONE(long killId) {
    log.info("秒杀四(数据库悲观锁)(限流可能少买)");

    seckillService.initSeckill(killId);
    int totalNum = 20;
    CountDownLatch latch = new CountDownLatch(totalNum);
    for (int i = 0; i < totalNum; i++) {
      final long userId = i;
      Runnable task = () -> {

        Boolean flag = Boolean.FALSE;
        try {
          flag = seckillService.startSeckilDBPCC_ONE(killId, userId);
        } catch (RuntimeException e) {
          log.info("访问太频繁");
        }
        if (flag) {
          log.info("抢购成功 user {}", userId);
        } else {
          log.info("抢购失败 user {}", userId);
        }
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
    log.info("本次秒杀商品ID [{}] 抢购人数{} 秒杀个数 {}", killId, totalNum, killCount);

    return Result.ok();
  }

  @ApiOperation(value = "秒杀五(数据库悲观锁)", nickname = "科帮网")
  @PostMapping("/startDPCC_TWO")
  public Result startDPCC_TWO(long killId) {
    seckillService.initSeckill(killId);
    int totalNum = 20;
    CountDownLatch latch = new CountDownLatch(totalNum);
    for (int i = 0; i < totalNum; i++) {
      final long userId = i;
      Runnable task = () -> {

        Boolean flag  = seckillService.startSeckilDBPCC_TWO(killId, userId);
        if (flag) {
          log.info("抢购成功 user {}", userId);
        } else {
          log.info("抢购失败 user {}", userId);
        }
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
    log.info("本次秒杀商品ID [{}] 抢购人数{} 秒杀个数 {}", killId, totalNum, killCount);



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
