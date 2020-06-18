package com.little.cloud.dao;

import com.little.cloud.dto.AccountVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountVODao {
    int insert(@Param("pojo") AccountVO pojo);

    int insertSelective(@Param("pojo") AccountVO pojo);

    int insertList(@Param("pojos") List<AccountVO> pojo);

    int update(@Param("pojo") AccountVO pojo);
}
