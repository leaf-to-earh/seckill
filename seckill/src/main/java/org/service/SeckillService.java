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
	 * ��ѯ������ɱ��Ʒ
	 * @return ��Ʒ�б�
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * ����id��ѯ��ɱ��Ʒ
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	
	/**
	 * ��ɱ��ʼ�����ɱ��ַ���������ϵͳʱ�����ɱʱ��
	 * @param seckillId
	 * @return
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * ִ����ɱ���������׳��ظ���ɱ�쳣����ɱ�ر��쳣����ɱ�쳣
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) 
			throws RepeatKillException, SeckillClosedException, SeckillException;
}
