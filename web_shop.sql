/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80025
Source Host           : localhost:3306
Source Database       : web_shop

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2022-02-23 12:11:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `u_id` int NOT NULL,
  `s_id` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of record
-- ----------------------------

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '3年高考1年模拟', '2.00');
INSERT INTO `shop` VALUES ('2', 'java核心卷', '49.90');
INSERT INTO `shop` VALUES ('5', 'java', '12.25');
INSERT INTO `shop` VALUES ('6', '手机', '1999.00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `money` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', '管理员', '0.00');
INSERT INTO `user` VALUES ('2', 'test', '123456', '顾客', '187.75');
INSERT INTO `user` VALUES ('5', '123456', '123456', '顾客', '90.20');
INSERT INTO `user` VALUES ('6', '3', '3', '顾客', '0.00');
INSERT INTO `user` VALUES ('8', '123', '123', '顾客', '0.00');
