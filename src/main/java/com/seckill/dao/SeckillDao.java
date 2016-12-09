package com.seckill.dao;

import java.util.Date;
import java.util.List;

import com.seckill.entity.Seckill;

public interface SeckillDao {
	/**
	 * 数据库减库存数量
	 * 
	 * @param seckillId
	 *            商品ID
	 * @param seckillStartTime
	 *            秒杀开始时间
	 * @return
	 */
	int reduceNumber(long seckillId, Date seckillStartTime);

	/**
	 * 根据ID在数据库查询秒杀对象
	 * 
	 * @param seckillId
	 *            商品ID
	 * @return
	 */
	Seckill queryById(long seckillId);

	/**
	 * 根据偏移量在数据库查找秒杀对象集合
	 * 
	 * @param offset
	 *            从offset+1条数据开始
	 * @param limit
	 *            查询共offset条数据
	 * @return
	 */
	List<Seckill> queryAll(int offset, int limit);
}
