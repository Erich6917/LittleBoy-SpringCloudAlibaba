-- auto Generated on 2021-02-20 10:21:00 
-- DROP TABLE IF EXISTS `evection`; 
CREATE TABLE `tb_evection`(
	`id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`userid` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'userid',
	`evectionnname` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'evectionName',
	`num` DOUBLE (16,4) NOT NULL DEFAULT -1.0 COMMENT 'num',
	`beginddate` DATETIME DEFAULT NULL COMMENT 'beginDate',
	`endddate` DATETIME  DEFAULT NULL COMMENT 'endDate',
	`destination` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'destination',
	`reson` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'reson',
  `status` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'status',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`evection`';


-- auto Generated on 2021-02-20 10:21:57 
-- DROP TABLE IF EXISTS `flow_info`; 
CREATE TABLE `tb_flow`(
	`id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`flowname` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'flowname',
	`flowkey` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'flowkey',
	`filepath` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'filepath',
	`state` INT (11) NOT NULL DEFAULT -1 COMMENT 'state',
	`createtime` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createtime',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`tb_flow`';


CREATE TABLE `tb_sitemessage`(
	`id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`userid` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'userid',
  `taskid` VARCHAR (150) NOT NULL DEFAULT '' COMMENT 'taskid',
	`type` INT (11) NOT NULL DEFAULT -1 COMMENT 'type',
	`content` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'content',
	`isread` INT (11) NOT NULL DEFAULT -1 COMMENT 'isread',
	`createtime` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createtime',
	`updatetime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updatetime',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`tb_sitemessage`';

CREATE TABLE `tb_user`(
	`id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`username` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'username',
	`password` VARCHAR (150) NOT NULL DEFAULT '' COMMENT 'password',
	`email` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'email',
	`gender` INT (11) NOT NULL DEFAULT -1 COMMENT 'gender',
	`age` INT (11) NOT NULL DEFAULT -1 COMMENT 'age',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`tb_user`';


insert into `tb_user`
(id,username,`password`)
VALUES
(1,'jack','$2a$10$EB64LBqdu4DbxYG0kHW8juU/Hy6AsAZpQl2NsmWfPOz2u1htWAXcO'),
(2,'rose','$2a$10$EB64LBqdu4DbxYG0kHW8juU/Hy6AsAZpQl2NsmWfPOz2u1htWAXcO'),
(3,'tom','$2a$10$EB64LBqdu4DbxYG0kHW8juU/Hy6AsAZpQl2NsmWfPOz2u1htWAXcO'),
(4,'jerry','$2a$10$EB64LBqdu4DbxYG0kHW8juU/Hy6AsAZpQl2NsmWfPOz2u1htWAXcO');
insert into tb_flow
(flowname,flowkey,filepath,state)
values 
('出差申请','evection','bpmn/evection.bpmn',1);

select * from tb_user;
select * from tb_flow;
