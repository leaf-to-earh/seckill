package org.entity;

import java.util.Date;
/**
 * 秒杀成功明细实体类
 * @author BlueStone
 *
 */
public class SuccessKilled {

	private long seckillId;
	
	private short state;
	
	private long userPhone;
	
	private Date createTime;
	
	private Seckill seckill;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	@Override
	public String toString() {
		return "Seckill[ id="+ seckillId +
				", userPhone=" + userPhone +
				", state=" + state +
				", createTime=" + createTime +
				"]";
	}
	
}
