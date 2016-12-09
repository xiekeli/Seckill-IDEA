-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据库
USE seckill;
-- 创建秒杀库存表
-- InnoDB存储引擎能提供事务处理和行锁，能增加并发性能
-- AUTO_INCREMENT设置自增主键的起始值
-- DEFAULT CHARSET=UTF8设置编码格式
-- COMMENT='SSM框架实例'设置表注释
CREATE TABLE seckill (
	-- bigint最大整型
	`seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品ID',
	`seckill_name` VARCHAR (120) NOT NULL COMMENT '名称',
	`seckill_number` INT NOT NULL COMMENT '数量',
	`seckill_start_time` TIMESTAMP NOT NULL COMMENT '开始时间',
	`seckill_end_time` TIMESTAMP NOT NULL COMMENT '结束时间',
	`seckill_create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	-- 设置主键
	PRIMARY KEY (seckill_id),
	KEY start_time (seckill_start_time),
	KEY end_time (seckill_end_time),
	KEY create_time (seckill_create_time)
) ENGINE = INNODB AUTO_INCREMENT = 1000 DEFAULT CHARSET = UTF8 COMMENT = 'SSM框架秒杀实例';

-- 初始化数据
INSERT INTO seckill (
	seckill_name,
	seckill_number,
	seckill_start_time,
	seckill_end_time
)
VALUES
	(
		'千元秒杀iphone6',
		1000,
		'2016-01-01 00:00:00',
		'2016-01-02 00:00:00'
	),
	(
		'百元秒杀iphone6',
		100,
		'2016-01-01 00:00:00',
		'2016-01-02 00:00:00'
	),
	(
		'十元秒杀iphone6',
		10,
		'2016-01-01 00:00:00',
		'2016-01-02 00:00:00'
	),
	(
		'一元秒杀iphone6',
		1,
		'2016-01-01 00:00:00',
		'2016-01-02 00:00:00'
	);

-- 秒杀成功明细表
-- 用户登录认证相关的信息
CREATE TABLE seckill_success (
	`seckill_id` BIGINT NOT NULL COMMENT '商品ID',
	`seckill_user_phone` BIGINT NOT NULL COMMENT '用户手机号',
	-- -1无效，0成功，1已付款，2已发货，
	`seckill_state` TINYINT NOT NULL DEFAULT - 1 COMMENT '状态码',
	`seckill_create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
	-- 联合主键，保证用户秒杀产品的唯一性，即不能重复秒杀
	PRIMARY KEY (seckill_id, seckill_user_phone),
	KEY create_time (seckill_create_time)
)

-- 连接数据库控制台
mysql -u root -p