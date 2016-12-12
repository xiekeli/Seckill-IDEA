package com.seckill.service.impl;

import com.seckill.dao.SeckillDao;
import com.seckill.dao.SeckilledSuccessDao;
import com.seckill.dto.SeckillExcution;
import com.seckill.dto.SeckillExposer;
import com.seckill.entity.Seckill;
import com.seckill.entity.SeckilledSuccess;
import com.seckill.enums.SeckillStateEnum;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;
import com.seckill.exception.SeckillRepeatException;
import com.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/10.
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SeckilledSuccessDao seckilledSuccessDao;
    /*定义slf4j对象*/
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /*获取所有秒杀对象*/
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 4);
    }

    /*根据ID获取秒杀对象*/
    public Seckill getSeckillById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    /*生成秒杀路径*/
    public SeckillExposer exportSeckillUrl(long seckillId) {
        /*获取秒杀产品ID*/
        Seckill seckill = seckillDao.queryById(seckillId);
        /*如果对象不存在则不生成秒杀路径*/
        if (seckill == null) {
            return new SeckillExposer(false, seckillId);
        }
        /*秒杀开始时间*/
        Date startTime = seckill.getSeckillStartTime();
        /*秒杀结束时间*/
        Date endTime = seckill.getSeckillEndTime();
        /*系统当前时间*/
        Date nowTime = new Date();
        /*如果不在秒杀时间内则不生成秒杀路径*/
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new SeckillExposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        /*获取加密后的秒杀ID*/
        String md5 = getMd5(seckillId);
        /*生成秒杀路径*/
        return new SeckillExposer(true, md5, seckillId);
    }

    /*进行秒杀*/
    /*使用注解控制事务方法*/
    /*不是所有的方法都需要事务，如只有一条修改/查询的操作*/
    @Transactional
    public SeckillExcution executeSeckill(long seckillId, long seckillUserPhone, String md5) throws SeckillException, SeckillCloseException, SeckillRepeatException {
        /*验证秒杀ID的MD5*/
        if (md5 == null || !md5.equals(getMd5(seckillId))) {
            throw new SeckillException("MD5验证失败！");
        }
        /*系统当前时间*/
        Date nowTime = new Date();
        /*获取减库存的更新条数*/
        try {
            int updateCount = seckillDao.reduceNumber(seckillId, nowTime);

            if (updateCount < 1) {
                /*抛出库存不足异常*/
                throw new SeckillCloseException("秒杀已关闭！");
            } else {
            /*获取秒杀成功的更新条数*/
                int insertCount = seckilledSuccessDao.insertSeckilledSuccess(seckillId, seckillUserPhone);
                if (insertCount < 1) {
                    /*抛出重复秒杀异常*/
                    throw new SeckillRepeatException("重复秒杀！");
                } else {
                /*秒杀成功*/
                    SeckilledSuccess seckilledSuccess = seckilledSuccessDao.queryByIdWithSeckill(seckillId, seckillUserPhone);
                    return new SeckillExcution(seckillId, SeckillStateEnum.SUCCESS, seckilledSuccess);
                }
            }
            /*捕获库存不足异常*/
        } catch (SeckillCloseException sce) {
            throw sce;
            /*捕获重复秒杀异常*/
        } catch (SeckillRepeatException sre) {
            throw sre;
            /*捕获秒杀异常*/
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            /*编译期异常转为运行期异常*/
            throw new SeckillException("秒杀异常！" + e.getMessage());
        }

    }

    /*MD5盐值加密*/
    private String getMd5(long seckillId) {
        String md5 = "seckill" + seckillId;
        return DigestUtils.md5DigestAsHex(md5.getBytes());
    }
}
