package com.little.cloud.service;

    import com.little.cloud.dao.SeckillDao;
    import com.little.cloud.dto.Seckill;
    import java.util.List;
    import javax.annotation.Resource;
    import org.springframework.stereotype.Service;

@Service
public class SeckillService {

    @Resource
    private SeckillDao seckillDao;

    public int insert(Seckill pojo) {
        return seckillDao.insert(pojo);
    }

    public int insertSelective(Seckill pojo) {
        return seckillDao.insertSelective(pojo);
    }

    public int insertList(List<Seckill> pojos) {
        return seckillDao.insertList(pojos);
    }

    public int update(Seckill pojo) {
        return seckillDao.update(pojo);
    }

    public int initSeckill(long seckillId) {
        return seckillDao.initSeckill(seckillId);
    }

    public Seckill selectById(long killId) {
        return seckillDao.selectById(killId);
    }

    public int cutOne(long killId) {
        return seckillDao.cutOne(killId);
    }

    public Seckill selectByIdForupdate(long killId) {
        return seckillDao.selectByIdForupdate(killId);
    }

    public int cutOneForupdate(long killId) {
        return seckillDao.cutOneForupdate(killId);
    }
}
