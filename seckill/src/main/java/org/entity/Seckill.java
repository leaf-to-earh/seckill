package org.entity;

import java.util.Date;
/*
 * 秒杀商品实体类
 */
public class Seckill {

	private long seckillId;
	
	private String name;
	
	private int quantity;
	
	private Date startTime;
	
	private Date endTime;
	
	private Date createTime;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Seckill[ id="+ seckillId +
				", name=" + name +
				", quantity=" + quantity +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", createTime=" + createTime +
				"]";
	}
	
}
