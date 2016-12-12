package com.seckill.enums;

/**
 * 使用枚举表示常量
 */
public enum SeckillStateEnum {
    SUCCESS(1, "秒杀成功!"),
    END(0, "秒杀关闭！"),
    REPEAT_KILL(-1, "重复秒杀！"),
    INNER_ERROR(-2, "系统异常！"),
    DATA_REWRITE(-3, "数据篡改！");
    private int state;
    private String stateInfo;

    SeckillStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStateEnum seckillStateEnum(int index) {
        for (SeckillStateEnum seckillStateEnum : values()) {
            if (seckillStateEnum.getState() == index) {
                return seckillStateEnum;
            }
        }
        return null;
    }
}
