/*
Navicat MySQL Data Transfer

Source Server         : MySQL57
Source Server Version : 50630
Source Host           : localhost:3306
Source Database       : enter

Target Server Type    : MYSQL
Target Server Version : 50630
File Encoding         : 65001

Date: 2016-05-29 15:53:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `wexin_id` char(20) DEFAULT '',
  `alipay_id` varchar(32) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` char(20) NOT NULL,
  `password` char(32) NOT NULL,
  `user_id` char(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `admin_user` (`user_id`),
  CONSTRAINT `admin_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for admin_authorization
-- ----------------------------
DROP TABLE IF EXISTS `admin_authorization`;
CREATE TABLE `admin_authorization` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `admin_id` char(20) NOT NULL,
  `sequence` char(40) NOT NULL,
  `token` char(40) NOT NULL,
  `last_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `authorization_user` (`admin_id`) USING BTREE,
  CONSTRAINT `authorization_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` char(5) NOT NULL,
  `name` char(9) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for commit
-- ----------------------------
DROP TABLE IF EXISTS `commit`;
CREATE TABLE `commit` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` char(20) DEFAULT '',
  `news_id` char(20) NOT NULL,
  `content` varchar(40) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `commit_user` (`user_id`),
  KEY `commit_news` (`news_id`),
  CONSTRAINT `commit_news` FOREIGN KEY (`news_id`) REFERENCES `news` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `commit_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` char(20) NOT NULL,
  `ip` int(64) NOT NULL,
  `last_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `password_success` smallint(255) DEFAULT NULL,
  `password_failure` smallint(255) DEFAULT NULL,
  `cookie_success` smallint(255) DEFAULT NULL,
  `sequence_failure` smallint(255) DEFAULT NULL,
  `multi_device_factor` smallint(255) DEFAULT NULL,
  `ip_factor` smallint(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `login_user` (`user_id`),
  CONSTRAINT `login_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` char(20) NOT NULL,
  `title` char(32) NOT NULL,
  `user_id` char(20) DEFAULT '',
  `content` text NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `news_user` (`user_id`) USING BTREE,
  CONSTRAINT `news_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `production_id` int(20) unsigned DEFAULT '0',
  `proxy_id` char(20) DEFAULT '',
  `user_id` char(20) DEFAULT '',
  `price` char(9) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `qrcode_id` char(20) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `order_proxy` (`proxy_id`),
  KEY `order_user` (`user_id`),
  KEY `order_production` (`production_id`),
  CONSTRAINT `order_production` FOREIGN KEY (`production_id`) REFERENCES `production` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `order_proxy` FOREIGN KEY (`proxy_id`) REFERENCES `proxy` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for production
-- ----------------------------
DROP TABLE IF EXISTS `production`;
CREATE TABLE `production` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `category_id` char(5) DEFAULT '',
  `name` char(32) NOT NULL,
  `price` char(9) NOT NULL,
  `desc` varchar(120) DEFAULT '',
  `thumb` char(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `production_category` (`category_id`),
  CONSTRAINT `production_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for production_gallery
-- ----------------------------
DROP TABLE IF EXISTS `production_gallery`;
CREATE TABLE `production_gallery` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `production_id` int(20) unsigned NOT NULL,
  `image_src` char(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `gallery_production` (`production_id`),
  CONSTRAINT `gallery_production` FOREIGN KEY (`production_id`) REFERENCES `production` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for proxy
-- ----------------------------
DROP TABLE IF EXISTS `proxy`;
CREATE TABLE `proxy` (
  `id` char(20) NOT NULL,
  `name` char(18) NOT NULL,
  `user_id` char(20) NOT NULL,
  `level` tinyint(1) NOT NULL,
  `phone` char(16) NOT NULL,
  `address` varchar(32) NOT NULL,
  `proxy_desc` varchar(40) DEFAULT '',
  `qrcode_id` char(20) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `proxy_user` (`user_id`),
  KEY `proxy_qrcode` (`qrcode_id`),
  CONSTRAINT `proxy_qrcode` FOREIGN KEY (`qrcode_id`) REFERENCES `qrcode` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `proxy_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrcode
-- ----------------------------
DROP TABLE IF EXISTS `qrcode`;
CREATE TABLE `qrcode` (
  `id` char(20) NOT NULL,
  `info` varchar(64) NOT NULL,
  `image_src` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` char(20) NOT NULL,
  `password` char(32) DEFAULT '',
  `name` char(18) DEFAULT '',
  `sex` tinyint(1) DEFAULT '0',
  `native_place` char(20) DEFAULT '',
  `birthday` char(10) DEFAULT '',
  `mobile` char(16) DEFAULT '',
  `email` varchar(32) DEFAULT '',
  `user_desc` varchar(40) DEFAULT '',
  `account_id` int(20) unsigned DEFAULT '0',
  `qrcode_id` char(20) DEFAULT '',
  `head_thumb` char(20) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `user_qrcode` (`qrcode_id`),
  KEY `user_account` (`account_id`),
  CONSTRAINT `user_account` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `user_qrcode` FOREIGN KEY (`qrcode_id`) REFERENCES `qrcode` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_authorization
-- ----------------------------
DROP TABLE IF EXISTS `user_authorization`;
CREATE TABLE `user_authorization` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` char(20) NOT NULL,
  `sequence` char(40) NOT NULL,
  `token` char(40) NOT NULL,
  `last_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `authorization_user` (`user_id`),
  CONSTRAINT `authorization_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
