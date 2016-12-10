package com.seckill.exception;

/**
 * 重复秒杀的异常（运行期）
 */
public class SeckillRepeatException extends SeckillException{
    public SeckillRepeatException(String message) {
        super(message);
    }

    public SeckillRepeatException(String message, Throwable cause) {
        super(message, cause);
    }
}
