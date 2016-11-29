package org.service;

import java.util.List;

import org.dto.Exposer;
import org.dto.SeckillExecution;
import org.entity.Seckill;
import org.exception.RepeatKillException;
import org.exception.SeckillClosedException;
import org.exception.SeckillException;

public interface SeckillService {

	/**
	 * 查询所有秒杀商品
	 * @return 商品列表
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * 根据id查询秒杀商品
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	
	/**
	 * 秒杀开始输出秒杀地址，否则输出系统时间和秒杀时间
	 * @param seckillId
	 * @return
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * 执行秒杀操作，会抛出重复秒杀异常，秒杀关闭异常，秒杀异常
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) 
			throws RepeatKillException, SeckillClosedException, SeckillException;
}
