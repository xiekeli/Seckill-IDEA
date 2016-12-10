package com.seckill.entity;

import java.util.Date;

public class SeckilledSuccess {
    private long seckillId;
    private long seckillUserPhone;
    private short seckillState;
    private Date seckillCreateTime;
    private Seckill seckill;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getSeckillUserPhone() {
        return seckillUserPhone;
    }

    public void setSeckillUserPhone(long seckillUserPhone) {
        this.seckillUserPhone = seckillUserPhone;
    }

    public short getSeckillState() {
        return seckillState;
    }

    public void setSeckillState(short seckillState) {
        this.seckillState = seckillState;
    }

    public Date getSeckillCreateTime() {
        return seckillCreateTime;
    }

    public void setSeckillCreateTime(Date seckillCreateTime) {
        this.seckillCreateTime = seckillCreateTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    @Override
    public String toString() {
        return "秒杀商品ID=" + seckillId + "，秒杀商品用户手机号=" + seckillUserPhone + "，秒杀状态码="
                + seckillState + "，秒杀行为创建时间=" + seckillCreateTime;
    }
}
