/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : featureselectionweb

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-05-09 11:47:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for algorithm
-- ----------------------------
DROP TABLE IF EXISTS `algorithm`;
CREATE TABLE `algorithm` (
  `algorithm_id` int(11) NOT NULL AUTO_INCREMENT,
  `algorithm_name` text NOT NULL,
  `algorithm_paper_reference` text,
  `algorithm_paper_link` text,
  `algorithm_call_interface` text,
  `ut` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `algorithm_description` text,
  `algorithn_call_host` text,
  `algorithm_call_exchange` text,
  `algorithm_call_routingkey` text,
  `algorithm_call_port` text,
  `algorithm_call_username` text,
  `algorithm_call_password` text,
  PRIMARY KEY (`algorithm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
