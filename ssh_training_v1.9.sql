/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : ssh_training

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-09-22 17:29:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `FK24217FDE2CA169A3` (`address_id`),
  CONSTRAINT `FK24217FDE2CA169A3` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for `discount_base`
-- ----------------------------
DROP TABLE IF EXISTS `discount_base`;
CREATE TABLE `discount_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_base` varchar(16) NOT NULL DEFAULT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discount_base
-- ----------------------------
INSERT INTO `discount_base` VALUES ('1', '金额');

-- ----------------------------
-- Table structure for `discount_type`
-- ----------------------------
DROP TABLE IF EXISTS `discount_type`;
CREATE TABLE `discount_type` (
  `type_id` int(11) NOT NULL,
  `type` varchar(16) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discount_type
-- ----------------------------
INSERT INTO `discount_type` VALUES ('1', '一般折扣');

-- ----------------------------
-- Table structure for `om_customers_info`
-- ----------------------------
DROP TABLE IF EXISTS `om_customers_info`;
CREATE TABLE `om_customers_info` (
  `cust_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_code` varchar(10) NOT NULL,
  `customter_name` varchar(120) NOT NULL,
  `type` varchar(8) NOT NULL,
  `group_company` varchar(10) DEFAULT NULL,
  `corporation` varchar(10) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `Discount_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cust_id`),
  KEY `for_org_id` (`org_id`),
  KEY `for_address_id` (`address_id`) USING BTREE,
  CONSTRAINT `for_address_id` FOREIGN KEY (`address_id`) REFERENCES `om_cust_address` (`address_id`) ON UPDATE CASCADE,
  CONSTRAINT `for_org_id` FOREIGN KEY (`org_id`) REFERENCES `om_cust_org` (`org_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of om_customers_info
-- ----------------------------
INSERT INTO `om_customers_info` VALUES ('4', 'HZL', 'huang', 'WTD', 'hand', 'hand', '1', '4', '1');
INSERT INTO `om_customers_info` VALUES ('5', 'HZL', 'huangziliang', 'STD', 'hand1', 'hand1', '1', '5', '1');
INSERT INTO `om_customers_info` VALUES ('6', 'HZL', 'huangziliang', 'STD', 'hand1', 'hand2', '1', '6', '1');
INSERT INTO `om_customers_info` VALUES ('9', 'HZL', 'huangziliang', 'STD', 'hand', 'hand', '2', '7', '1');
INSERT INTO `om_customers_info` VALUES ('12', 'HZL', 'huangziliang', 'STD', 'hand', 'hand', '2', '8', null);
INSERT INTO `om_customers_info` VALUES ('16', 'H1', 'huang3', 'STE', 'HAND3', 'HAND5', '3', '9', null);
INSERT INTO `om_customers_info` VALUES ('17', '12312', '23', '3123', '12312', '3123123', '4', '10', null);
INSERT INTO `om_customers_info` VALUES ('18', '12312', '23', '3123', '12312', '3123123', '5', '11', null);
INSERT INTO `om_customers_info` VALUES ('19', 'ZL', 'ZILIANG', 'STD', '', '', '6', '12', null);
INSERT INTO `om_customers_info` VALUES ('20', 'ZL', 'ZILIANG', 'STD', '', '', '7', '13', null);
INSERT INTO `om_customers_info` VALUES ('21', 'ZL', 'ZILIANG', 'STD', '', '', '8', '14', null);
INSERT INTO `om_customers_info` VALUES ('23', '', '', '', '', '', '10', '16', null);
INSERT INTO `om_customers_info` VALUES ('24', 'GBH', 'asas', 'GG20', 'asd', 'asdasd', '11', '17', null);
INSERT INTO `om_customers_info` VALUES ('25', 'ATW-J', 'huangziliang4', 'GG20', 'asd', '', '12', '18', null);
INSERT INTO `om_customers_info` VALUES ('26', 'GBH', '1', 'STD', '2', '3', '13', '19', null);
INSERT INTO `om_customers_info` VALUES ('27', 'ATW-J', '', 'GG20', '', '', '14', '20', null);
INSERT INTO `om_customers_info` VALUES ('28', 'ATW-J', '1', 'GG20', '2', '3', '15', '21', null);
INSERT INTO `om_customers_info` VALUES ('29', 'ATW-J', 'HT', 'GG20', 'ASD', 'ASD', '16', '22', null);
INSERT INTO `om_customers_info` VALUES ('30', 'ATW', 'aas', 'STD', 'as', 'sasasa', '17', '23', null);
INSERT INTO `om_customers_info` VALUES ('31', 'ATW-J', '黄', 'GG20', 'wq', 'wqwqw', '18', '24', null);
INSERT INTO `om_customers_info` VALUES ('32', 'ATW-J', 'asdasdasd', 'GG20', 'asdasd', 'dasd', '19', '25', null);
INSERT INTO `om_customers_info` VALUES ('33', 'ATW-J', 'asd', 'GG20', 'cacasc', 'ascasc', '20', '26', null);
INSERT INTO `om_customers_info` VALUES ('34', 'ATW-J', 'sad', 'GG20', 'asd', 'asd', '21', '27', null);
INSERT INTO `om_customers_info` VALUES ('35', 'ATW-J', 'sad', 'GG20', 'asd', 'asd', '22', '28', null);
INSERT INTO `om_customers_info` VALUES ('36', 'ATW-J', 'asd', 'GG20', 'asd', 'asd', '23', '29', null);
INSERT INTO `om_customers_info` VALUES ('37', 'ATW-J', 'asd', 'GG20', 'asd', 'asdasd', '24', '30', null);

-- ----------------------------
-- Table structure for `om_cust_address`
-- ----------------------------
DROP TABLE IF EXISTS `om_cust_address`;
CREATE TABLE `om_cust_address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `address1` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `postcode` varchar(15) DEFAULT NULL,
  `port_of_destination` varchar(20) NOT NULL,
  `shipping_mark` varchar(100) NOT NULL,
  `status` varchar(6) NOT NULL DEFAULT '待确认',
  `inactive_date` date DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `address_id_for_cust_id` (`address_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of om_cust_address
-- ----------------------------
INSERT INTO `om_cust_address` VALUES ('4', '美国', '加州', '洛杉矶', '红灯区', null, null, '海港', '码头', '有效', null);
INSERT INTO `om_cust_address` VALUES ('5', '美国', '阿萨德', '但是', '阿萨德', null, null, '大声道', ' 对对对', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('6', 'zm', 'dds', 'ssa', 'adda', null, null, 'sdad', 'sdasd', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('7', '1111', '111', '111', '111111111', null, null, 'asdasdasdasdad', 'asdasdasda', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('8', '22', '22', '22', '22', '22', null, '22', '22', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('9', 'Spain', null, null, 'FFFF', 'OK', 'MEIYOU', 'LAS', 'MATOU', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('10', 'Paraguay', null, null, '1231', '2312', '312', '123', '3123', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('11', 'Paraguay', null, null, '1231', '2312', '312', '123', '3123', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('12', 'Poland', null, null, 'AAA', '', '', 'LL', 'CD', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('13', 'Poland', null, null, 'AAA', '', '', '', 'CD', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('14', 'Poland', null, null, 'AAA', '', '', '', 'CD', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('16', 'USA', null, null, '', '', '', '', '', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('17', 'USA', null, null, 'sdasd', 'asd', 'asd', 'asda', 'asd', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('18', 'Peru', null, null, 'foc', 'asdasd', '', 'LAS', 'aaa', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('19', 'Nicaragua', null, null, '5', '6', '7', '4', '8', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('20', 'USA', '', '', '', '', '', '', '', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('21', 'USA', '4', '5', '7', '8', '9', '6', '10', '待确认', '2015-10-01');
INSERT INTO `om_cust_address` VALUES ('22', 'USA', 'ASD', '23', 'ASD', 'ASDA', 'SDASD', '5', 'ASD', '待确认', '2015-10-01');
INSERT INTO `om_cust_address` VALUES ('23', 'Peru', 'dad', 'aasa', 'dasd', 'asdas', 'dasdasd', 'dasdas', 'asdasd', '确认', '2016-02-06');
INSERT INTO `om_cust_address` VALUES ('24', 'USA', 'qwq', 'wqw', 'qwq', 'wqw', 'qwqwqw', 'qw', 'qwqwq', '待确认', '2018-02-19');
INSERT INTO `om_cust_address` VALUES ('25', 'Norway', 'asdddd', 'dds', 'aas', 'sdsd', 'czc', 'aaa', 'casc', '待确认', '2015-10-01');
INSERT INTO `om_cust_address` VALUES ('26', 'USA', 'asc', 'ascasc', 'asc', 'scasc', 'asc', 'asca', 'cascasc', '待确认', '2013-12-12');
INSERT INTO `om_cust_address` VALUES ('27', 'USA', 'asd', 'asd', 'asd', '', '', 'asda', 'asd', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('28', 'USA', '', 'asd', 'asd', '', '', 'asda', 'asd', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('29', 'USA', '', 'asd', 'ASD', '', '', 'dasdas', 'asdasd', '待确认', null);
INSERT INTO `om_cust_address` VALUES ('30', 'USA', 'asdas', 'aasa', 'ASD', '', '', 'dasdas', 'CD', '待确认', null);

-- ----------------------------
-- Table structure for `om_cust_contactors`
-- ----------------------------
DROP TABLE IF EXISTS `om_cust_contactors`;
CREATE TABLE `om_cust_contactors` (
  `cont_id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_id` int(11) NOT NULL,
  `mailfrom` varchar(50) DEFAULT NULL,
  `prepr_mailto` varchar(200) DEFAULT NULL,
  `po_mailto` varchar(200) DEFAULT NULL,
  `ocpi_mailto` varchar(200) DEFAULT NULL,
  `inv_pklist_mailto` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cont_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of om_cust_contactors
-- ----------------------------
INSERT INTO `om_cust_contactors` VALUES ('1', '4', 'qweq', 'weqweq', 'weqwe', 'qweq', 'weqwe');
INSERT INTO `om_cust_contactors` VALUES ('2', '16', null, 'qwedqwd', 'qdqwd', 'qwdqwdq', 'wdqdqwd');
INSERT INTO `om_cust_contactors` VALUES ('3', '18', null, '3123', '1231', '23123123', '123123');
INSERT INTO `om_cust_contactors` VALUES ('8', '23', null, '', '', '', '');
INSERT INTO `om_cust_contactors` VALUES ('9', '24', 'asas', 'sdasd', 'asd', 'asdasd', 'asd');
INSERT INTO `om_cust_contactors` VALUES ('10', '25', '2222222', 'asdasdasd', '', '', '');
INSERT INTO `om_cust_contactors` VALUES ('11', '26', '19', '20', '21', '22', '23');
INSERT INTO `om_cust_contactors` VALUES ('12', '27', '', '', '', '', '');
INSERT INTO `om_cust_contactors` VALUES ('13', '28', 'dasda', 'sdas', 'dasd', 'asd', 'asd');
INSERT INTO `om_cust_contactors` VALUES ('14', '29', 'QWE', 'QWE', 'QWE', 'QWE', 'QWE');
INSERT INTO `om_cust_contactors` VALUES ('15', '30', 'asd', 'asd', 'asd', 'asd', 'asd');
INSERT INTO `om_cust_contactors` VALUES ('16', '31', 'asda', 'sdas', 'dasd', 'asda', 'asd');
INSERT INTO `om_cust_contactors` VALUES ('17', '32', 'asd', 'sadadada', 'dadsc', 'scsc', 'scscsc');
INSERT INTO `om_cust_contactors` VALUES ('18', '33', '12312', 'sdas', 'QWE', '22', '23');
INSERT INTO `om_cust_contactors` VALUES ('19', '34', '', '', '', '', '');
INSERT INTO `om_cust_contactors` VALUES ('20', '35', '', '', '', '', '');
INSERT INTO `om_cust_contactors` VALUES ('21', '36', '', '', '', '', '');
INSERT INTO `om_cust_contactors` VALUES ('22', '37', '', '', '', '', '');

-- ----------------------------
-- Table structure for `om_cust_org`
-- ----------------------------
DROP TABLE IF EXISTS `om_cust_org`;
CREATE TABLE `om_cust_org` (
  `org_id` int(11) NOT NULL AUTO_INCREMENT,
  `market_area` varchar(10) DEFAULT NULL,
  `bussiness_manager` varchar(15) DEFAULT NULL,
  `bussiness_assistant` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`org_id`),
  KEY `for_cust_id` (`org_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of om_cust_org
-- ----------------------------
INSERT INTO `om_cust_org` VALUES ('1', '05-美国', '李某某', '黄某某');
INSERT INTO `om_cust_org` VALUES ('2', '06-中国', '黄某', '李某');
INSERT INTO `om_cust_org` VALUES ('3', '07-中国', '就是我', '不是我');
INSERT INTO `om_cust_org` VALUES ('4', '1231', '2312', '3123123');
INSERT INTO `om_cust_org` VALUES ('5', '1231', '2312', '3123123');
INSERT INTO `om_cust_org` VALUES ('6', '07-中国', '梁某', '王某');
INSERT INTO `om_cust_org` VALUES ('7', '07-中国', '梁某', '王某');
INSERT INTO `om_cust_org` VALUES ('8', '07-中国', '梁某', '王某');
INSERT INTO `om_cust_org` VALUES ('10', '', '', '');
INSERT INTO `om_cust_org` VALUES ('11', '欧洲1', 'dasd', 'asdasd');
INSERT INTO `om_cust_org` VALUES ('12', '德国', '222', 'you');
INSERT INTO `om_cust_org` VALUES ('13', '欧洲1', '17', '18');
INSERT INTO `om_cust_org` VALUES ('14', '德国', '', '');
INSERT INTO `om_cust_org` VALUES ('15', '德国', 'asdas', 'dasdas');
INSERT INTO `om_cust_org` VALUES ('16', '德国', 'QWE', 'QWE');
INSERT INTO `om_cust_org` VALUES ('17', '亚太', '李丹', '黄子良');
INSERT INTO `om_cust_org` VALUES ('18', '德国', '李丹', '黄子良');
INSERT INTO `om_cust_org` VALUES ('19', '美国', '李丹', '黄子良');
INSERT INTO `om_cust_org` VALUES ('20', '美国', '李丹', '黄子良');
INSERT INTO `om_cust_org` VALUES ('21', '美国', '李丹', '黄子良');
INSERT INTO `om_cust_org` VALUES ('22', '美国', '李丹', '黄子良');
INSERT INTO `om_cust_org` VALUES ('23', '欧洲1', '李丹', '黄子良');
INSERT INTO `om_cust_org` VALUES ('24', '欧洲2', '李丹', '黄子良');

-- ----------------------------
-- Table structure for `om_cust_payment`
-- ----------------------------
DROP TABLE IF EXISTS `om_cust_payment`;
CREATE TABLE `om_cust_payment` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_id` int(11) DEFAULT NULL,
  `invoice_group` varchar(20) DEFAULT NULL,
  `currency` varchar(3) NOT NULL,
  `payment_term` varchar(120) NOT NULL,
  `price_term1` varchar(100) DEFAULT NULL,
  `price_term2` varchar(100) DEFAULT NULL,
  `price_term3` varchar(100) DEFAULT NULL,
  `markup_name` varchar(20) NOT NULL DEFAULT '低于50片加价5%',
  `discount_name` varchar(20) NOT NULL DEFAULT '无折扣',
  PRIMARY KEY (`payment_id`),
  KEY `for_cust_id` (`cust_id`),
  CONSTRAINT `for_cust_id` FOREIGN KEY (`cust_id`) REFERENCES `om_customers_info` (`cust_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of om_cust_payment
-- ----------------------------
INSERT INTO `om_cust_payment` VALUES ('1', '4', '2221', '23', 'qwdqwd', 'qwdqwd', 'qwdqwd', 'qwdq', '低于50片加价5%', '无折扣');
INSERT INTO `om_cust_payment` VALUES ('2', '18', '123123', 'RMB', '123', '3123', '23123', '1231', '123123', '12312');
INSERT INTO `om_cust_payment` VALUES ('7', '23', '', '', '', '', '', '', '', '');
INSERT INTO `om_cust_payment` VALUES ('8', '24', 'asda', 'asd', 'dasd', 'asdas', 'sdas', 'dasdas', 'asd', 'asd');
INSERT INTO `om_cust_payment` VALUES ('9', '25', 'XXXX', 'RMB', 'get', 'aaaaaaa', '', '', 'nothing', '5%');
INSERT INTO `om_cust_payment` VALUES ('10', '26', '9', '11', '13', '14', '15', '16', '10', '12');
INSERT INTO `om_cust_payment` VALUES ('11', '27', '', '', '', '', '', '', '', '');
INSERT INTO `om_cust_payment` VALUES ('12', '28', '11', 'd', 'asdasd', 'asd', 'asda', 'asdasd', '123123', 'asdas');
INSERT INTO `om_cust_payment` VALUES ('13', '29', 'QWE', 'QWE', 'EQW', 'EQWE', 'QWE', 'QWE', 'QWE', 'QWEQW');
INSERT INTO `om_cust_payment` VALUES ('14', '30', 'asd', 'asd', 'asd', 'asd', 'asdasd', 'asd', 'asd', 'asd');
INSERT INTO `om_cust_payment` VALUES ('15', '31', 'asd', 'asd', 'sdas', 'da', 'asd', 'asd', 'asd', 'asda');
INSERT INTO `om_cust_payment` VALUES ('16', '32', 'asd', 'czx', 'c', 'ascasc', 'asd', 'asda', 'cac', 'acs');
INSERT INTO `om_cust_payment` VALUES ('17', '33', 'asd', 'asd', 'asd', '3123', '23123', 'asd', 'asdasd', '5%');
INSERT INTO `om_cust_payment` VALUES ('18', '34', '', 'asd', 'asd', '', '', '', 'asd', 'asd');
INSERT INTO `om_cust_payment` VALUES ('19', '35', '', 'asd', 'asd', '', '', '', 'asd', 'asd');
INSERT INTO `om_cust_payment` VALUES ('20', '36', '', 'asd', 'asd', '', '', '', 'asdasdasd', 'asd');
INSERT INTO `om_cust_payment` VALUES ('21', '37', '', 'RMB', 'GET', '', '', '', '123123', '5%');

-- ----------------------------
-- Table structure for `om_cust_price_list`
-- ----------------------------
DROP TABLE IF EXISTS `om_cust_price_list`;
CREATE TABLE `om_cust_price_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(120) NOT NULL,
  `TYPE` varchar(8) NOT NULL,
  `PL_YH_ITEM` varchar(30) NOT NULL,
  `effective_date_from` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `effective_date_to` timestamp NULL DEFAULT NULL,
  `user_def1` varchar(20) DEFAULT NULL,
  `user_def2` varchar(20) DEFAULT NULL,
  `user_def3` varchar(20) DEFAULT NULL,
  `user_def4` varchar(20) DEFAULT NULL,
  `user_def5` varchar(20) DEFAULT NULL,
  `user_def6` varchar(20) DEFAULT NULL,
  `user_def7` varchar(20) DEFAULT NULL,
  `user_def8` varchar(20) DEFAULT NULL,
  `user_def9` varchar(20) DEFAULT NULL,
  `user_def10` varchar(20) DEFAULT NULL,
  `user_def11` varchar(20) DEFAULT NULL,
  `user_def12` varchar(20) DEFAULT NULL,
  `user_def13` varchar(20) DEFAULT NULL,
  `user_def14` varchar(20) DEFAULT NULL,
  `user_def15` varchar(20) DEFAULT NULL,
  `user_def16` varchar(20) DEFAULT NULL,
  `user_def17` varchar(20) DEFAULT NULL,
  `user_def18` varchar(20) DEFAULT NULL,
  `user_def19` varchar(20) DEFAULT NULL,
  `user_def20` varchar(20) DEFAULT NULL,
  `user_def21` varchar(20) DEFAULT NULL,
  `user_def22` varchar(20) DEFAULT NULL,
  `user_def23` varchar(20) DEFAULT NULL,
  `user_def24` varchar(20) DEFAULT NULL,
  `user_def25` varchar(20) DEFAULT NULL,
  `user_def26` varchar(20) DEFAULT NULL,
  `user_def27` varchar(20) DEFAULT NULL,
  `user_def28` varchar(20) DEFAULT NULL,
  `user_def29` varchar(20) DEFAULT NULL,
  `user_def30` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of om_cust_price_list
-- ----------------------------

-- ----------------------------
-- Table structure for `om_cust_price_list_config`
-- ----------------------------
DROP TABLE IF EXISTS `om_cust_price_list_config`;
CREATE TABLE `om_cust_price_list_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_code` varchar(120) NOT NULL,
  `type` varchar(8) NOT NULL,
  `display_name` varchar(30) DEFAULT NULL,
  `price_list_col` varchar(30) NOT NULL,
  `EXCEL_col` int(3) DEFAULT NULL,
  `activity` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of om_cust_price_list_config
-- ----------------------------

-- ----------------------------
-- Table structure for `om_cust_price_list_config_date`
-- ----------------------------
DROP TABLE IF EXISTS `om_cust_price_list_config_date`;
CREATE TABLE `om_cust_price_list_config_date` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_code` varchar(120) NOT NULL,
  `type` varchar(8) NOT NULL,
  `display_name` varchar(20) DEFAULT NULL,
  `price_list_col` varchar(30) NOT NULL,
  `EXCEL_col` int(3) DEFAULT NULL,
  `activity` varchar(2) DEFAULT NULL,
  `activity_date_from` timestamp NULL DEFAULT NULL,
  `activity_date_to` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of om_cust_price_list_config_date
-- ----------------------------

-- ----------------------------
-- Table structure for `om_cust_price_list_cust`
-- ----------------------------
DROP TABLE IF EXISTS `om_cust_price_list_cust`;
CREATE TABLE `om_cust_price_list_cust` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_id` int(11) NOT NULL,
  `Cust_name` varchar(120) NOT NULL,
  `type` varchar(8) DEFAULT NULL,
  `YH_item` varchar(10) NOT NULL,
  `Effective_date_form` timestamp NULL DEFAULT NULL,
  `Effective_date_to` timestamp NULL DEFAULT NULL,
  `SEGMENT1` varchar(10) DEFAULT NULL,
  `SEGMENT2` varchar(10) DEFAULT NULL,
  `SEGMENT3` varchar(10) DEFAULT NULL,
  `SEGMENT4` varchar(10) DEFAULT NULL,
  `SEGMENT5` varchar(10) DEFAULT NULL,
  `SEGMENT6` varchar(10) DEFAULT NULL,
  `SEGMENT7` varchar(10) DEFAULT NULL,
  `SEGMENT8` varchar(10) DEFAULT NULL,
  `SEGMENT9` varchar(10) DEFAULT NULL,
  `SEGMENT10` varchar(10) DEFAULT NULL,
  `SEGMENT11` varchar(10) DEFAULT NULL,
  `SEGMENT12` varchar(10) DEFAULT NULL,
  `SEGMENT13` varchar(10) DEFAULT NULL,
  `SEGMENT14` varchar(10) DEFAULT NULL,
  `SEGMENT15` varchar(10) DEFAULT NULL,
  `SEGMENT16` varchar(10) DEFAULT NULL,
  `SEGMENT17` varchar(10) DEFAULT NULL,
  `SEGMENT18` varchar(10) DEFAULT NULL,
  `SEGMENT19` varchar(10) DEFAULT NULL,
  `SEGMENT20` varchar(10) DEFAULT NULL,
  `SEGMENT21` varchar(10) DEFAULT NULL,
  `SEGMENT22` varchar(10) DEFAULT NULL,
  `SEGMENT23` varchar(10) DEFAULT NULL,
  `SEGMENT24` varchar(10) DEFAULT NULL,
  `SEGMENT25` varchar(10) DEFAULT NULL,
  `SEGMENT26` varchar(10) DEFAULT NULL,
  `SEGMENT27` varchar(10) DEFAULT NULL,
  `SEGMENT28` varchar(10) DEFAULT NULL,
  `SEGMENT29` varchar(10) DEFAULT NULL,
  `SEGMENT30` varchar(10) DEFAULT NULL,
  `SEGMENT31` varchar(10) DEFAULT NULL,
  `SEGMENT32` varchar(10) DEFAULT NULL,
  `SEGMENT33` varchar(10) DEFAULT NULL,
  `SEGMENT34` varchar(10) DEFAULT NULL,
  `SEGMENT35` varchar(10) DEFAULT NULL,
  `SEGMENT36` varchar(10) DEFAULT NULL,
  `SEGMENT37` varchar(10) DEFAULT NULL,
  `SEGMENT38` varchar(10) DEFAULT NULL,
  `SEGMENT39` varchar(10) DEFAULT NULL,
  `SEGMENT40` varchar(10) DEFAULT NULL,
  `SEGMENT41` varchar(10) DEFAULT NULL,
  `SEGMENT42` varchar(10) DEFAULT NULL,
  `SEGMENT43` varchar(10) DEFAULT NULL,
  `SEGMENT44` varchar(10) DEFAULT NULL,
  `SEGMENT45` varchar(10) DEFAULT NULL,
  `SEGMENT46` varchar(10) DEFAULT NULL,
  `SEGMENT47` varchar(10) DEFAULT NULL,
  `SEGMENT48` varchar(10) DEFAULT NULL,
  `SEGMENT49` varchar(10) DEFAULT NULL,
  `SEGMENT50` varchar(10) DEFAULT NULL,
  `PL_YH_ITEM` varchar(255) DEFAULT NULL,
  `effective_date_from` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `user_def1` varchar(255) DEFAULT NULL,
  `user_def10` varchar(255) DEFAULT NULL,
  `user_def11` varchar(255) DEFAULT NULL,
  `user_def12` varchar(255) DEFAULT NULL,
  `user_def13` varchar(255) DEFAULT NULL,
  `user_def14` varchar(255) DEFAULT NULL,
  `user_def15` varchar(255) DEFAULT NULL,
  `user_def16` varchar(255) DEFAULT NULL,
  `user_def17` varchar(255) DEFAULT NULL,
  `user_def18` varchar(255) DEFAULT NULL,
  `user_def19` varchar(255) DEFAULT NULL,
  `user_def2` varchar(255) DEFAULT NULL,
  `user_def20` varchar(255) DEFAULT NULL,
  `user_def21` varchar(255) DEFAULT NULL,
  `user_def22` varchar(255) DEFAULT NULL,
  `user_def23` varchar(255) DEFAULT NULL,
  `user_def24` varchar(255) DEFAULT NULL,
  `user_def25` varchar(255) DEFAULT NULL,
  `user_def26` varchar(255) DEFAULT NULL,
  `user_def27` varchar(255) DEFAULT NULL,
  `user_def28` varchar(255) DEFAULT NULL,
  `user_def29` varchar(255) DEFAULT NULL,
  `user_def3` varchar(255) DEFAULT NULL,
  `user_def30` varchar(255) DEFAULT NULL,
  `user_def4` varchar(255) DEFAULT NULL,
  `user_def5` varchar(255) DEFAULT NULL,
  `user_def6` varchar(255) DEFAULT NULL,
  `user_def7` varchar(255) DEFAULT NULL,
  `user_def8` varchar(255) DEFAULT NULL,
  `user_def9` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of om_cust_price_list_cust
-- ----------------------------

-- ----------------------------
-- Table structure for `om_discount_applied_records`
-- ----------------------------
DROP TABLE IF EXISTS `om_discount_applied_records`;
CREATE TABLE `om_discount_applied_records` (
  `Discount_id` int(10) NOT NULL AUTO_INCREMENT,
  `discount_name` varchar(30) NOT NULL,
  `Cust_code` varchar(10) NOT NULL,
  `ADN_identify_num` varchar(30) NOT NULL,
  `Applied_amount` int(15) NOT NULL,
  `applied_date` date NOT NULL,
  `cancel` tinyint(2) DEFAULT NULL,
  `Cancel_date` date DEFAULT NULL,
  PRIMARY KEY (`Discount_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of om_discount_applied_records
-- ----------------------------
INSERT INTO `om_discount_applied_records` VALUES ('2', '死了的风景', '收代理费', '1', '232', '2015-09-01', '0', '2015-09-08');

-- ----------------------------
-- Table structure for `om_normal_discount`
-- ----------------------------
DROP TABLE IF EXISTS `om_normal_discount`;
CREATE TABLE `om_normal_discount` (
  `discount_id` int(10) NOT NULL AUTO_INCREMENT,
  `discount_name` varchar(30) NOT NULL,
  `type` varchar(8) NOT NULL,
  `discount_base` varchar(8) NOT NULL,
  `base_qty` int(8) NOT NULL,
  `discount_rate` float(8,0) NOT NULL,
  `activity` varchar(2) NOT NULL,
  `activity_date_from` date NOT NULL,
  `activity_date_to` date NOT NULL,
  `id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `discount_type1` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`discount_id`),
  KEY `for_cust_id` (`discount_id`) USING BTREE,
  KEY `FKE07565384EB4B1D3` (`id`),
  KEY `FKE07565381BE40D61` (`type_id`),
  CONSTRAINT `FKE07565381BE40D61` FOREIGN KEY (`type_id`) REFERENCES `discount_type` (`type_id`),
  CONSTRAINT `FKE07565384EB4B1D3` FOREIGN KEY (`id`) REFERENCES `discount_base` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of om_normal_discount
-- ----------------------------

-- ----------------------------
-- Table structure for `om_special_discount`
-- ----------------------------
DROP TABLE IF EXISTS `om_special_discount`;
CREATE TABLE `om_special_discount` (
  `discount_id` int(10) NOT NULL AUTO_INCREMENT,
  `discount_name` varchar(30) NOT NULL,
  `cust_code` varchar(10) NOT NULL,
  `amount` int(15) NOT NULL,
  `Applied_amount` int(15) NOT NULL,
  `balance` int(15) NOT NULL,
  `activity` varchar(2) NOT NULL DEFAULT '是',
  `Activity_date_from` date NOT NULL,
  `Activity_date_to` date NOT NULL,
  PRIMARY KEY (`discount_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of om_special_discount
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) NOT NULL,
  `authority1` varchar(2) NOT NULL DEFAULT 'N',
  `authority2` varchar(2) NOT NULL DEFAULT 'N',
  `authority3` varchar(2) NOT NULL DEFAULT 'N',
  `authority4` varchar(2) NOT NULL DEFAULT 'N',
  `authority5` varchar(2) NOT NULL DEFAULT 'N',
  `authority6` varchar(2) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`),
  KEY `role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级用户', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y');
INSERT INTO `role` VALUES ('2', '业务员', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y');
INSERT INTO `role` VALUES ('3', '业务经理', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y');
INSERT INTO `role` VALUES ('4', '财务人员', 'N', 'N', 'N', 'N', 'N', 'N');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_pwd` varchar(20) NOT NULL,
  `ch_name` varchar(20) NOT NULL,
  `staff_id` int(11) NOT NULL,
  `en_name` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `phone` int(15) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `for_role` (`role`),
  CONSTRAINT `for_role` FOREIGN KEY (`role`) REFERENCES `role` (`role`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'jky', 'hand', '黄子良', '8802', 'jky', '业务员', '56789', '345678', '2015-09-15');
INSERT INTO `user` VALUES ('3', 'huang', 'huang', '黄子良', '8803', '', '业务员', '0', '', null);
INSERT INTO `user` VALUES ('4', 'hand', 'hand', '黄子良', '8804', '', '财务人员', '0', '', null);
INSERT INTO `user` VALUES ('5', 'ziliang', 'ziliang', '黄子良', '8809', '', '业务经理', '0', '', null);
INSERT INTO `user` VALUES ('6', 'ziliang', 'ziliang', '黄子良', '8809', '', '业务经理', '0', '', null);
INSERT INTO `user` VALUES ('7', 'admin', 'admin', '超级用户', '8888', 'superUser', '超级用户', '8888', '8888', null);
