package com.seckill.dto;

import com.seckill.entity.SeckilledSuccess;
import com.seckill.enums.SeckillStateEnum;

/**
 * 秒杀执行结果
 */
public class SeckillExcution {
    /*秒杀商品ID*/
    private long seckillId;
    /*秒杀状态码*/
    private long state;
    /*状态码详情*/
    private String stateInfo;
    /*秒杀成功的对象*/
    private SeckilledSuccess seckilledSuccess;

    public SeckillExcution(long seckillId, SeckillStateEnum seckillStateEnum, SeckilledSuccess seckilledSuccess) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getStateInfo();
        this.seckilledSuccess = seckilledSuccess;
    }

    public SeckillExcution(long seckillId, SeckillStateEnum seckillStateEnum) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getState() {
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

    @Override
    public String toString() {
        return "SeckillExcution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", seckilledSuccess=" + seckilledSuccess +
                '}';
    }
}
