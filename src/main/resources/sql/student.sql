/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.120
Source Server Version : 50718
Source Host           : 192.168.0.120:3306
Source Database       : xytest

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-16 05:11:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '小明', '16', '备注111', '2017-06-16 03:34:55', '2017-06-16 03:35:12');
INSERT INTO `student` VALUES ('2', '小红', '13', '备注2222', '2017-06-16 03:34:55', '2017-06-16 03:34:55');
INSERT INTO `student` VALUES ('3', '小强', '19', '备注333', '2017-06-16 03:34:55', '2017-06-16 03:35:16');
INSERT INTO `student` VALUES ('4', '小王', '15', '备注44654', '2017-06-16 05:02:23', '2017-06-16 05:02:23');
