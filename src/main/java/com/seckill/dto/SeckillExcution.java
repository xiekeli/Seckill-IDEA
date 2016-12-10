package com.seckill.dto;

import com.seckill.entity.SeckilledSuccess;

/**
 * 秒杀执行结果
 */
public class SeckillExcution {
    /*秒杀商品ID*/
    private long seckillId;
    /*秒杀状态码*/
    private short state;
    /*状态码详情*/
    private String stateInfo;
    /*秒杀成功的对象*/
    private SeckilledSuccess seckilledSuccess;

    public SeckillExcution(long seckillId, short state, String stateInfo, SeckilledSuccess seckilledSuccess) {
        this.seckillId = seckillId;
        this.state = state;
        this.stateInfo = stateInfo;
        this.seckilledSuccess = seckilledSuccess;
    }

    public SeckillExcution(long seckillId, short state, String stateInfo) {
        this.seckillId = seckillId;
        this.state = state;
        this.stateInfo = stateInfo;
    }

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

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SeckilledSuccess getSeckilledSuccess() {
        return seckilledSuccess;
    }

    public void setSeckilledSuccess(SeckilledSuccess seckilledSuccess) {
        this.seckilledSuccess = seckilledSuccess;
    }
}
