package org.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.entity.Seckill;

public interface SeckillDao {
	
	/**
	 * �����
	 * @param seckillId �����Ʒid
	 * @param killTime ��ɱʱ��
	 * @return Ӱ�������
	 */
	int reduceQuantity(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
	
	/**
	 * ����seckillId��ѯʵ�����
	 * @param seckillId �����Ʒid
	 * @return ʵ�����
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * ����ƫ������ѯ��ɱ��Ʒʵ�弯��
	 * @param offset
	 * @param limits
	 * @return
	 */
	List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
