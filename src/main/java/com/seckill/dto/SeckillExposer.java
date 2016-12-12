package com.seckill.dto;

/**
 * 暴露秒杀地址
 */
public class SeckillExposer {
    /*是否暴露地址*/
    private boolean exposer;
    /*地址加密*/
    private String md5;
    /*秒杀商品ID*/
    private long seckillId;
    /*系统时间ms*/
    private long now;
    /*秒杀开启时间*/
    private long start;
    /*秒杀结束时间*/
    private long end;

    public SeckillExposer(boolean exposer, String md5, long seckillId) {
        this.exposer = exposer;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public SeckillExposer(boolean exposer, long seckillId, long now, long start, long end) {
        this.exposer = exposer;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public SeckillExposer(boolean exposer, long seckillId) {
        this.exposer = exposer;
        this.seckillId = seckillId;
    }

    public boolean isExposer() {
        return exposer;
    }

    public void setExposer(boolean exposer) {
        this.exposer = exposer;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "SeckillExposer{" +
                "exposer=" + exposer +
                ", md5='" + md5 + '\'' +
                ", seckillId=" + seckillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
