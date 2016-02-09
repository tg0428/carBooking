/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : carbook

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-02-02 21:33:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dbo.admin
-- ----------------------------
DROP TABLE IF EXISTS `dbo.admin`;
CREATE TABLE `dbo.admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(10) NOT NULL COMMENT '管理员用户名',
  `admin_pass` varchar(10) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dbo.article
-- ----------------------------
DROP TABLE IF EXISTS `dbo.article`;
CREATE TABLE `dbo.article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `article_title` varchar(30) NOT NULL COMMENT '文章标题',
  `article_content` text COMMENT '文章内容',
  `article_time` varchar(255) DEFAULT NULL COMMENT '文章发布时间',
  `article_type` int(2) DEFAULT NULL,
  PRIMARY KEY (`article_id`),
  KEY `article2type` (`article_type`),
  CONSTRAINT `article2type` FOREIGN KEY (`article_type`) REFERENCES `dbo.typeofarticle` (`article_type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dbo.car
-- ----------------------------
DROP TABLE IF EXISTS `dbo.car`;
CREATE TABLE `dbo.car` (
  `car_id` int(3) NOT NULL AUTO_INCREMENT COMMENT '汽车id',
  `car_name` varchar(15) NOT NULL COMMENT '汽车名称',
  `leaguer_price` decimal(10,0) NOT NULL COMMENT '会员价格',
  `retail_price` decimal(10,0) NOT NULL COMMENT '门市价格',
  `car_detail` varchar(255) DEFAULT NULL COMMENT '汽车详情',
  `image_server_url` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL COMMENT '汽车图片路径',
  `car_type` int(2) DEFAULT NULL COMMENT '汽车优惠类型',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`car_id`),
  KEY `car2type` (`car_type`),
  CONSTRAINT `car2type` FOREIGN KEY (`car_type`) REFERENCES `dbo.typeofcar` (`type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dbo.typeofarticle
-- ----------------------------
DROP TABLE IF EXISTS `dbo.typeofarticle`;
CREATE TABLE `dbo.typeofarticle` (
  `article_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_type_detail` varchar(10) DEFAULT NULL COMMENT '文章类型内容',
  PRIMARY KEY (`article_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dbo.typeofcar
-- ----------------------------
DROP TABLE IF EXISTS `dbo.typeofcar`;
CREATE TABLE `dbo.typeofcar` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '汽车优惠类型id',
  `type_detail` varchar(20) NOT NULL COMMENT '汽车优惠类型详情',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dbo.user
-- ----------------------------
DROP TABLE IF EXISTS `dbo.user`;
CREATE TABLE `dbo.user` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL COMMENT '用户名',
  `password` varchar(10) NOT NULL COMMENT '密码',
  `phone` varchar(20) NOT NULL COMMENT '联系方式',
  `pu_car_time` varchar(30) DEFAULT NULL COMMENT '取车日期',
  `gb_car_time` varchar(30) DEFAULT NULL COMMENT '还车日期',
  `book_car_id` int(3) DEFAULT NULL COMMENT '预定车辆id',
  `tips` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user2car` (`book_car_id`),
  CONSTRAINT `user2car` FOREIGN KEY (`book_car_id`) REFERENCES `dbo.car` (`car_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
