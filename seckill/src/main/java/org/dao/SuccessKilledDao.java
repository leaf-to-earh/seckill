package org.dao;

import org.apache.ibatis.annotations.Param;
import org.entity.SuccessKilled;

public interface SuccessKilledDao {

	/**
	 * 插入秒杀成功明细，并可过滤重复秒杀
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
	
	/**
	 * 根据id查询查询秒杀成功的记录并携带秒杀商品实体
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
