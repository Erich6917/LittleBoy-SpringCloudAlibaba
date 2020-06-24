SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255) DEFAULT NULL,
  `account_code` varchar(255) DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT '0',
  `amount` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_code` varchar(255) DEFAULT NULL COMMENT '编码',
  `product_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `count` int(11) DEFAULT '0' COMMENT '库存数量',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '单价',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_PRODUCT_CODE` (`PRODUCT_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'P001', '笔记本', '10', '3000.00');
INSERT INTO `product` VALUES ('2', 'P002', '手表', '5', '250.00');
INSERT INTO `product` VALUES ('3', 'P003', '键盘', '50', '100.00');
INSERT INTO `product` VALUES ('4', 'P004', '辣条', '1000', '0.50');

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_code` varchar(255) DEFAULT NULL,
  `account_name` varchar(255) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_ACCOUNT_CODE` (`ACCOUNT_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'javadaily', 'JAVA日知录', '10000.00');

insert into `order`
(order_no,account_code,product_code,count,amount)
values
(1,'javadaily','P001',1,3000),
(2,'javadaily','P002',2,500);
