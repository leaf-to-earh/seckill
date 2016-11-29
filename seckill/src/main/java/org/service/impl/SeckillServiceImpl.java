package org.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.dao.SeckillDao;
import org.dao.SuccessKilledDao;
import org.dto.Exposer;
import org.dto.SeckillExecution;
import org.entity.Seckill;
import org.entity.SuccessKilled;
import org.enumers.SeckillStatusEnum;
import org.exception.RepeatKillException;
import org.exception.SeckillClosedException;
import org.exception.SeckillException;
import org.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
public class SeckillServiceImpl implements SeckillService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	用于混淆md5
	private final String salt = "ljsdf#23sa2adf@#^dsf";
	
	@Resource
	private SeckillDao seckillDao;
	
	@Resource
	private SuccessKilledDao successKilledDao;
	
	@Override
	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 4);
	}

	@Override
	public Seckill getById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	@Override
	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = seckillDao.queryById(seckillId);
		if (seckill == null) {
			return new Exposer(false, seckillId);
		}
		long startTime = seckill.getStartTime().getTime();
		long endTime = seckill.getEndTime().getTime();
		long nowTime = new Date().getTime();
		if (nowTime < startTime || nowTime > endTime) {
			return new Exposer(false, seckillId, nowTime, startTime, endTime);
		}
		String md5 = getMD5(seckillId); 
		return new Exposer(true, md5, seckillId);
	}

	@Override
	@Transactional
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws RepeatKillException, SeckillClosedException, SeckillException {
		if (md5 == null || !md5.equals(getMD5(seckillId))) {
			throw new SeckillException("seckill data rewrite");
		}
		Date nowTime = new Date();
		try {
			// 执行秒杀业务逻辑
			int updateCount = seckillDao.reduceQuantity(seckillId, nowTime);
			if (updateCount <= 0) {
				throw new SeckillClosedException("seckill closed !");
			} else {
				// 记录购买行为
				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				if (insertCount <= 0) {
					throw new RepeatKillException("seckill repeated");
				}
			}
		} catch (SeckillClosedException e1) {
			e1.getMessage();
		} catch (RepeatKillException e2) {
			e2.getMessage();
		} catch (Exception e3) {
			logger.error(e3.getMessage(), e3);
			throw new SeckillException("seckill inner error:" + e3.getMessage());
		}
		SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
		return new SeckillExecution(seckillId, SeckillStatusEnum.SUCCESS, successKilled);
	}

	private String getMD5(long seckillId){
		String base = seckillId + "/" + salt;
		return DigestUtils.md5DigestAsHex(base.getBytes());
	}
}
