package com.little.cloud.dao;

import com.little.cloud.dto.SuccessKilled;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SuccessKilledDao {

  int insert(@Param("pojo") SuccessKilled pojo);

  int insertSelective(@Param("pojo") SuccessKilled pojo);

  int insertList(@Param("pojos") List<SuccessKilled> pojo);

  int update(@Param("pojo") SuccessKilled pojo);

  int deleteById(@Param("seckillId") long seckillId);

  int countKilled(@Param("seckillId") long seckillId);
}
