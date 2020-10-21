-- auto Generated on 2020-10-20 15:06:48 
-- DROP TABLE IF EXISTS `success_killed`; 
CREATE TABLE `success_killed`(
	`seckill_id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'seckillId',
	`user_id` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'userId',
	`state` INT (11) NOT NULL DEFAULT -1 COMMENT 'state',
	`create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
	PRIMARY KEY (`seckill_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`success_killed`';
