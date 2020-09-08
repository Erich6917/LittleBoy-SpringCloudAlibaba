package com.little.cloud.controller;

import lombok.extern.slf4j.Slf4j;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-9-8
 */
@Slf4j
public class MTest {

  public static void main(String[] args) {
    MTest tool = new MTest();
    float eachMonth = 2005.62f;
    float total = 0;
    for (int i = 12; i > 0; i--) {
      float moneyMonth = eachMonth * i;
      float interest = tool.cardMoney(moneyMonth);
      total += interest;
      log.info("Month {}, 本金 {}, 利息 {}", i, moneyMonth, interest);
    }
    log.info("共计利息 {}", total);
  }

  public float cardMoney(float total) {

    return total * 55 / 10000;
  }

}
