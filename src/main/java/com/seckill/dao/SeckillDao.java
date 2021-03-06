package com.seckill.dao;

import java.util.Date;
import java.util.List;

import com.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Param;

public interface SeckillDao {
    /**
     * 数据库减库存数量
     *
     * @param seckillId 商品ID
     * @param killTime  秒杀时间
     * @return
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据ID在数据库查询秒杀对象
     *
     * @param seckillId 商品ID
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量在数据库查找秒杀对象集合
     * JAVA不对形参名进行保存，当传入多个形参时需使用注解指定对应的形参名
     *
     * @param offset 从offset+1条数据开始
     * @param limit  查询共offset条数据
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
