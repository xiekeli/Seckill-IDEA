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
        return "秒杀商品ID=" + seckillId + "，秒杀商品名称=" + seckillName + "，秒杀商品数量=" + seckillNumber
                + "，秒杀开始时间=" + seckillStartTime + "，秒杀结束时间=" + seckillEndTime
                + "，秒杀商品创建时间=" + seckillCreateTime;
    }
}
