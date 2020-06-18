package com.little.cloud.service;

import com.little.cloud.dao.AccountVODao;
import com.little.cloud.dto.AccountVO;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AccountVOService{

    @Resource
    private AccountVODao accountVODao;

    public int insert(AccountVO pojo){
        return accountVODao.insert(pojo);
    }

    public int insertSelective(AccountVO pojo){
        return accountVODao.insertSelective(pojo);
    }

    public int insertList(List<AccountVO> pojos){
        return accountVODao.insertList(pojos);
    }

    public int update(AccountVO pojo){
        return accountVODao.update(pojo);
    }

    public List<AccountVO> getAccountListByCode(String accountCode) {
        return accountVODao.getAccountListByCode(accountCode);
    }
}
