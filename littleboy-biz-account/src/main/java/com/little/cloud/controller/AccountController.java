package com.little.cloud.controller;

import com.little.cloud.ResultData;
import com.little.cloud.dto.Account;
import com.little.cloud.service.AccountService;
import com.little.cloud.service.OrderService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-17
 */
@RestController
@Slf4j
@RequestMapping("/api/account")
public class AccountController {

  @Autowired
  private AccountService accountService;

  @GetMapping("/{accountCode}")
  public ResultData<List<Account>> getByCode(@PathVariable String accountCode) {
    log.info("get account detail,accountCode is :{}", accountCode);
    List<Account> list = accountService.getAccountByCode(accountCode);
    return ResultData.success(list);
  }

  @PostMapping("/insert")
  public ResultData insert(Account accountVO) {
    log.info("insert account:{}", accountVO);
    accountService.insert(accountVO);
    return ResultData.success("SUCCESS");
  }

}
