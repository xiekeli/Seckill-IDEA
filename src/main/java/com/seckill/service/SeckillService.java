package com.seckill.service;

import com.seckill.dto.SeckillExcution;
import com.seckill.dto.SeckillExposer;
import com.seckill.entity.Seckill;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;
import com.seckill.exception.SeckillRepeatException;

import java.util.List;

/**
 * 站在用户的角度去设计接口
 * 方法定义，参数，返回类型/异常
 */
public interface SeckillService {
    /**
     * 查询所有秒杀商品并返回一个集合
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 根据ID查询一个秒杀商品
     *
     * @param seckillId
     * @return
     */
    Seckill getSeckillById(long seckillId);

    /**
     * 反作弊，在秒杀开启时才开放接口，否则显示本地时间和秒杀开启时间
     *
     * @param seckillId
     * @return
     */
    SeckillExposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param seckillUserPhone
     * @param md5
     */
    SeckillExcution executeSeckill(long seckillId, long seckillUserPhone, String md5) throws SeckillException, SeckillCloseException, SeckillRepeatException;
}
