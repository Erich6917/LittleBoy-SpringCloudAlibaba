-- auto Generated on 2020-10-21 10:16:51 
-- DROP TABLE IF EXISTS `seckill`; 
CREATE TABLE `seckill`(
	`seckill_id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'seckillId',
	`name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
	`number` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'number',
	`start_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'startTime',
	`end_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'endTime',
	`create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
	`version` INT (11) NOT NULL DEFAULT -1 COMMENT 'version',
	PRIMARY KEY (`seckill_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`seckill`';
