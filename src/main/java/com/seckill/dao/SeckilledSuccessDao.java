package com.seckill.dao;

import com.seckill.entity.SeckilledSuccess;

public interface SeckilledSuccessDao {
	/**
	 * 向数据库插入秒杀成功的商品ID和对应的用户手机号
	 * 
	 * @param seckillId
	 *            商品ID
	 * @param seckillUserPhone
	 *            用户手机号
	 * @return
	 */
	int insertSeckilledSuccess(long seckillId, long seckillUserPhone);

	/**
	 * 根据商品ID查询秒杀成功的对象并携带秒杀的对象
	 * 
	 * @param seckillId
	 *            商品ID
	 * @return
	 */
	SeckilledSuccess queryByIdWithSeckill(long seckillId);
}
