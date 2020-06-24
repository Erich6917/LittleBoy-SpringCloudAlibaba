package com.little.cloud.service;

import com.little.cloud.dao.AccountDao;
import com.little.cloud.dto.Account;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Resource
    private AccountDao accountDao;

    public int insert(Account pojo){
        return accountDao.insert(pojo);
    }

    public int insertSelective(Account pojo){
        return accountDao.insertSelective(pojo);
    }

    public int insertList(List<Account> pojos){
        return accountDao.insertList(pojos);
    }

    public int update(Account pojo){
        return accountDao.update(pojo);
    }

    public List<Account> getAccountListByCode(String accountCode) {
        return accountDao.getAccountListByCode(accountCode);
    }

    public List<Account> getAccountByCode(String accountCode) {
        return accountDao.getAccountByCode(accountCode);
    }
}
