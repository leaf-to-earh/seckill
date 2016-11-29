package org.dto;

import org.entity.SuccessKilled;
import org.enumers.SeckillStatusEnum;

/**
 * 封闭秒杀执行后结果 
 * @author BlueStone
 *
 */
public class SeckillExecution {
//  秒杀商品id
	private long seckillId;
//	秒杀结果执行状态
	private int status;
//	秒杀结果执行状态信息
	private String statusInfo;
//	秒杀成功对象
	private SuccessKilled successKilled;
	
//	秒杀成功时
	public SeckillExecution(long seckillId, SeckillStatusEnum seckillStatusEnum, SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.status = seckillStatusEnum.getStatus();
		this.statusInfo = seckillStatusEnum.getStatusInfo();
		this.successKilled = successKilled;
	}

//	秒杀失败时
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
