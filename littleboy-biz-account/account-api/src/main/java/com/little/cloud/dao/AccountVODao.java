package com.little.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.little.cloud.dto.AccountVO;

@Mapper
public interface AccountVODao {
    int insert(@Param("pojo") AccountVO pojo);

    int insertSelective(@Param("pojo") AccountVO pojo);

    int insertList(@Param("pojos") List<AccountVO> pojo);

    int update(@Param("pojo") AccountVO pojo);
}
