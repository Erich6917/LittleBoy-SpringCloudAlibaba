package com.little.cloud.dao;

import com.little.cloud.dto.Account;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountDao {
    int insert(@Param("pojo") Account pojo);

    int insertSelective(@Param("pojo") Account pojo);

    int insertList(@Param("pojos") List<Account> pojo);

    int update(@Param("pojo") Account pojo);

    List<Account> getAccountListByCode(@Param("accountCode") String accountCode);

    List<Account> getAccountByCode(@Param("accountCode") String accountCode);
}
