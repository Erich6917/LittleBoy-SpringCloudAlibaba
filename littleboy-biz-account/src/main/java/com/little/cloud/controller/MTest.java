package com.little.cloud.controller;

import lombok.extern.slf4j.Slf4j;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-9-8
 */
@Slf4j
public class MTest {


  static final int CAL_MONTH = 12;
  static final int CARD_MONTH_RATE = 55 / 10000;
  static final int CARD_MONTH_MONEY = 55;

  static final int MONEY_MUL = 10;
  static final int MONEY = 10000 * MONEY_MUL;
  static final float BANK_MONTH_MONEY = 37 * MONEY_MUL;


  public static void main(String[] args) {
    f01CalBankRate();
  }

  public static void f01CalBankRate() {
    float totalInterest = CAL_MONTH * BANK_MONTH_MONEY;
    log.info("方案一 银行说的 一万块 每月利息37 ");
    log.info("本金 {} 月份 {} 利息元/万 {} 利息总计 {} ", MONEY, CAL_MONTH, 37, totalInterest);
    float monthlyReturn = (MONEY + totalInterest) / CAL_MONTH;
    float bankInterestYear = totalInterest / MONEY;
    float bankInterestMonth = totalInterest / MONEY / 12;
    log.info("每月归还{} 利息共计 {} 年利率 {} 月利率 {} ", monthlyReturn, totalInterest, bankInterestYear,
        bankInterestMonth);

    log.info("方案二 刷信卡 万55");
    log.info("本金 {} 刷卡万利息 {} 采用等额本息", MONEY, CARD_MONTH_MONEY);
    float cartMonthly = MONEY / CAL_MONTH;
    float last = MONEY;
    float total = 0;
    for (int i = 1; i <= CAL_MONTH; i++) {
      float interest = last * CARD_MONTH_MONEY / 10000;
      total += interest;
      float cardLast = last - cartMonthly;
      log.info("月份 {} 本月刷卡 {} 本月还钱{} 剩余本金 {} 本月刷卡利息{}", i, last, cartMonthly, cardLast, interest);
      last = cardLast;
    }
    float rateYear = total / MONEY;
    float rateMonth = total / MONEY / 12;
    log.info("利息共计 {} 年利率 {} 月利率 {} ", total, rateYear, rateMonth);
  }

//  public static void main(String[] args) {
//    MTest tool = new MTest();
//    float eachMonth = 2005.62f;
//    float total = 0;
//    for (int i = 12; i > 0; i--) {
//      float moneyMonth = eachMonth * i;
//      float interest = tool.cardMoney(moneyMonth);
//      total += interest;
//      log.info("Month {}, 本金 {}, 利息 {}", i, moneyMonth, interest);
//    }
//    log.info("共计利息 {}", total);
//  }
//
//  public float cardMoney(float total) {
//
//    return total * 55 / 10000;
//  }

}
