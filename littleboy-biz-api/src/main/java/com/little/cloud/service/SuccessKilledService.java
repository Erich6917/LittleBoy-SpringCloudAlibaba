package com.little.cloud.service;

import com.little.cloud.dao.SuccessKilledDao;
import com.little.cloud.dto.SuccessKilled;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SuccessKilledService {

  @Resource
  private SuccessKilledDao successKilledDao;

  public int insert(SuccessKilled pojo) {
    return successKilledDao.insert(pojo);
  }

  public int insertSelective(SuccessKilled pojo) {
    return successKilledDao.insertSelective(pojo);
  }

  public int insertList(List<SuccessKilled> pojos) {
    return successKilledDao.insertList(pojos);
  }

  public int update(SuccessKilled pojo) {
    return successKilledDao.update(pojo);
  }

  public int deleteById(long seckillId) {
    return successKilledDao.deleteById(seckillId);
  }

  public int countKilled(long killId) {

    return successKilledDao.countKilled(killId);
  }
}
