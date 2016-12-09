package com.seckill.entity;

import java.util.Date;

public class Seckill {
	private long seckillId;
	private String seckillName;
	private int seckillNumber;
	private Date seckillStartTime;
	private Date seckillEndTime;
	private Date seckillCreateTime;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public String getSeckillName() {
		return seckillName;
	}

	public void setSeckillName(String seckillName) {
		this.seckillName = seckillName;
	}

	public int getSeckillNumber() {
		return seckillNumber;
	}

	public void setSeckillNumber(int seckillNumber) {
		this.seckillNumber = seckillNumber;
	}

	public Date getSeckillStartTime() {
		return seckillStartTime;
	}

	public void setSeckillStartTime(Date seckillStartTime) {
		this.seckillStartTime = seckillStartTime;
	}

	public Date getSeckillEndTime() {
		return seckillEndTime;
	}

	public void setSeckillEndTime(Date seckillEndTime) {
		this.seckillEndTime = seckillEndTime;
	}

	public Date getSeckillCreateTime() {
		return seckillCreateTime;
	}

	public void setSeckillCreateTime(Date seckillCreateTime) {
		this.seckillCreateTime = seckillCreateTime;
	}

	@Override
	public String toString() {
		return "Seckill [seckillId=" + seckillId + ", seckillName=" + seckillName + ", seckillNumber=" + seckillNumber
				+ ", seckillStartTime=" + seckillStartTime + ", seckillEndTime=" + seckillEndTime
				+ ", seckillCreateTime=" + seckillCreateTime + "]";
	}
}
