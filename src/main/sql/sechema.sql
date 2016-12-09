-- ���ݿ��ʼ���ű�

-- �������ݿ�
CREATE DATABASE seckill;
-- ʹ�����ݿ�
USE seckill;
-- ������ɱ����
-- InnoDB�洢�������ṩ������������������Ӳ�������
-- AUTO_INCREMENT����������������ʼֵ
-- DEFAULT CHARSET=UTF8���ñ����ʽ
-- COMMENT='SSM���ʵ��'���ñ�ע��
CREATE TABLE seckill (
	-- bigint�������
	`seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '��ƷID',
	`seckill_name` VARCHAR (120) NOT NULL COMMENT '����',
	`seckill_number` INT NOT NULL COMMENT '����',
	`seckill_start_time` TIMESTAMP NOT NULL COMMENT '��ʼʱ��',
	`seckill_end_time` TIMESTAMP NOT NULL COMMENT '����ʱ��',
	`seckill_create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
	-- ��������
	PRIMARY KEY (seckill_id),
	KEY start_time (seckill_start_time),
	KEY end_time (seckill_end_time),
	KEY create_time (seckill_create_time)
) ENGINE = INNODB AUTO_INCREMENT = 1000 DEFAULT CHARSET = UTF8 COMMENT = 'SSM�����ɱʵ��';

-- ��ʼ������
INSERT INTO seckill (
	seckill_name,
	seckill_number,
	seckill_start_time,
	seckill_end_time
)
VALUES
	(
		'ǧԪ��ɱiphone6',
		1000,
		'2016-01-01 00:00:00',
		'2016-01-02 00:00:00'
	),
	(
		'��Ԫ��ɱiphone6',
		100,
		'2016-01-01 00:00:00',
		'2016-01-02 00:00:00'
	),
	(
		'ʮԪ��ɱiphone6',
		10,
		'2016-01-01 00:00:00',
		'2016-01-02 00:00:00'
	),
	(
		'һԪ��ɱiphone6',
		1,
		'2016-01-01 00:00:00',
		'2016-01-02 00:00:00'
	);

-- ��ɱ�ɹ���ϸ��
-- �û���¼��֤��ص���Ϣ
CREATE TABLE seckill_success (
	`seckill_id` BIGINT NOT NULL COMMENT '��ƷID',
	`seckill_user_phone` BIGINT NOT NULL COMMENT '�û��ֻ���',
	-- -1��Ч��0�ɹ���1�Ѹ��2�ѷ�����
	`seckill_state` TINYINT NOT NULL DEFAULT - 1 COMMENT '״̬��',
	`seckill_create_time` TIMESTAMP NOT NULL COMMENT '����ʱ��',
	-- ������������֤�û���ɱ��Ʒ��Ψһ�ԣ��������ظ���ɱ
	PRIMARY KEY (seckill_id, seckill_user_phone),
	KEY create_time (seckill_create_time)
)

-- �������ݿ����̨
mysql -u root -p