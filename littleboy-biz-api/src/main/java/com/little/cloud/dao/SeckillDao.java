package com.little.cloud.dao;

import com.little.cloud.dto.Seckill;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SeckillDao {

  int insert(@Param("pojo") Seckill pojo);

  int insertSelective(@Param("pojo") Seckill pojo);

  int insertList(@Param("pojos") List<Seckill> pojo);

  int update(@Param("pojo") Seckill pojo);

  int initSeckill(@Param("seckillId") long seckillId);

  Seckill selectById(@Param("seckillId") long seckillId);

  int cutOne(@Param("seckillId")  long seckillId);

  Seckill selectByIdForupdate(@Param("seckillId")  long killId);

  int cutOneForupdate(@Param("seckillId") long killId);
}
