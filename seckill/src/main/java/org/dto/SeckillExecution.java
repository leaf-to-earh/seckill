package org.dto;

import org.entity.SuccessKilled;
import org.enumers.SeckillStatusEnum;

/**
 * �����ɱִ�к��� 
 * @author BlueStone
 *
 */
public class SeckillExecution {
//  ��ɱ��Ʒid
	private long seckillId;
//	��ɱ���ִ��״̬
	private int status;
//	��ɱ���ִ��״̬��Ϣ
	private String statusInfo;
//	��ɱ�ɹ�����
	private SuccessKilled successKilled;
	
//	��ɱ�ɹ�ʱ
	public SeckillExecution(long seckillId, SeckillStatusEnum seckillStatusEnum, SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.status = seckillStatusEnum.getStatus();
		this.statusInfo = seckillStatusEnum.getStatusInfo();
		this.successKilled = successKilled;
	}

//	��ɱʧ��ʱ
	public SeckillExecution(long seckillId, SeckillStatusEnum seckillStatusEnum) {
		this.seckillId = seckillId;
		this.status = seckillStatusEnum.getStatus();
		this.statusInfo = seckillStatusEnum.getStatusInfo();
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

	@Override
	public String toString() {
		return "SeckillExecution [seckillId=" + seckillId + ", status=" + status + ", statusInfo=" + statusInfo
				+ ", successKilled=" + successKilled + "]";
	}
	
}
