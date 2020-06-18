package com.little.cloud.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.little.cloud.dto.AccountVO;
import com.little.cloud.dao.AccountVODao;

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
}
