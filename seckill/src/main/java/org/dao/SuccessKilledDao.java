package org.dao;

import org.apache.ibatis.annotations.Param;
import org.entity.SuccessKilled;

public interface SuccessKilledDao {

	/**
	 * ������ɱ�ɹ���ϸ�����ɹ����ظ���ɱ
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
	
	/**
	 * ����id��ѯ��ѯ��ɱ�ɹ��ļ�¼��Я����ɱ��Ʒʵ��
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
