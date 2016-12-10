package com.seckill.service.impl;

import com.seckill.dao.SeckillDao;
import com.seckill.dao.SeckilledSuccessDao;
import com.seckill.dto.SeckillExcution;
import com.seckill.dto.SeckillExposer;
import com.seckill.entity.Seckill;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;
import com.seckill.exception.SeckillRepeatException;
import com.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/10.
 */
public class SeckillServiceImpl implements SeckillService {
    private SeckillDao seckillDao;
    private SeckilledSuccessDao seckilledSuccessDao;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 4);
    }

    public Seckill getSeckillById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public SeckillExposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if (seckill == null) {
            return new SeckillExposer(false, seckillId);
        }
        Date startTime = seckill.getSeckillStartTime();
        Date endTime = seckill.getSeckillEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new SeckillExposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        String md5 = getMd5(seckillId);
        return new SeckillExposer(true, md5, seckillId);
    }

    public SeckillExcution executeSeckill(long seckillId, long seckillUserPhone, String md5) throws SeckillException, SeckillCloseException, SeckillRepeatException {
        if (md5 == null || md5.equals(getMd5(seckillId))) {
            throw new SeckillException("MD5验证失败！");
        }
        Date now = new Date();
        int updateCount = seckillDao.reduceNumber(seckillId, now);
        if (updateCount < 1) {
            throw new SeckillCloseException("秒杀关闭！");
        } else {
            int insertCount = SeckilledSuccessDao.insertSeckilledSuccess(seckillId, seckillUserPhone);
        }
        return null;
    }

    private String getMd5(long seckillId) {
        String md5 = "seckill" + seckillId;
        return DigestUtils.md5DigestAsHex(md5.getBytes());
    }
}
