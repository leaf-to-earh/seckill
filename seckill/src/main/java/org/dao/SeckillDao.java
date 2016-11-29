package org.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.entity.Seckill;

public interface SeckillDao {
	
	/**
	 * 减库存
	 * @param seckillId 库存商品id
	 * @param killTime 秒杀时间
	 * @return 影响的行数
	 */
	int reduceQuantity(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
	
	/**
	 * 根据seckillId查询实体对象
	 * @param seckillId 库存商品id
	 * @return 实体对象
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * 根据偏移量查询秒杀商品实体集合
	 * @param offset
	 * @param limits
	 * @return
	 */
	List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
