package com.little.cloud.controller;

import com.little.cloud.dto.AccountVO;
import com.little.cloud.service.AccountVOService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-17
 */
@RestController
@Slf4j
public class AccountController {

  @Autowired
  private AccountVOService accountService;

  @GetMapping("/account/{accountCode}")
  public AccountVO getByCode(@PathVariable String accountCode) {
    log.info("get account detail,accountCode is :{}", accountCode);
//    return accountService.sel(accountCode);
    return null;
  }

  @PostMapping("/account/update")
  public String update(AccountVO accountVO) {
    log.info("update account:{}", accountVO);
//    return accountService.updateAccount(accountVO);
    return "UPDATE SUCCESS";
  }

  @PostMapping("/account/insert")
  public String insert(AccountVO accountVO) {
    log.info("insert account:{}", accountVO);
//    return accountService.insertAccount(accountVO);
    accountService.insert(accountVO);
    return "SUCCESS";
  }

  @PostMapping("/account/delete")
  public String delete(@RequestParam String accountCode) {
    log.info("delete account,accountCode is {}", accountCode);
//    return accountService.(accountCode);
    return "DELETE SUCCESS";
  }
}
