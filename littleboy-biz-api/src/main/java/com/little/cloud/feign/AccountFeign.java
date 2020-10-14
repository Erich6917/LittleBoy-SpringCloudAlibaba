//package com.little.cloud.feign;
//
//import com.little.cloud.ResultData;
//import com.little.cloud.dto.Account;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * @Comment
// * @Author LiYuan
// * @Date 2020-10-13
// */
//@FeignClient(name = "account-service")
//public interface AccountFeign {
//  @PostMapping("/account/insert")
//  ResultData<String> insert(@RequestBody Account accountDTO);
//
//  @PostMapping("/account/delete")
//  ResultData<String> delete(@RequestParam("accountCode") String accountCode);
//
//  @PostMapping("/account/update")
//  ResultData<String> update(@RequestBody Account accountDTO);
//
//  @GetMapping("/account/getByCode/{accountCode}")
//  ResultData<Account> getByCode(@PathVariable(value = "accountCode") String accountCode);
//}
