package com.little.cloud.controller;

import java.lang.management.MonitorInfo;
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

    log.info("方案二 银行说的年化率 5.28%");
    float rate_cheat = 5.28f * 0.01f;
    totalInterest = MONEY * rate_cheat;
    float money_pay_month = (MONEY + totalInterest) / 12;
    log.info("本金{} 表面年化率{} 共计利息支出{} ,月支付{}", MONEY, rate_cheat, totalInterest, money_pay_month);

    log.info("方案三 刷信卡 万55");
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


}
