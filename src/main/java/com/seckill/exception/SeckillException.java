package com.seckill.exception;

/**
 * 所有秒杀业务的异常（运行期）
 */
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
