/*
 Navicat Premium Data Transfer

 Source Server         : sql_blog
 Source Server Type    : MySQL
 Source Server Version : 100417
 Source Host           : localhost:3306
 Source Schema         : dbdesign

 Target Server Type    : MySQL
 Target Server Version : 100417
 File Encoding         : 65001

 Date: 25/05/2021 19:45:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `cid` int NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creatTime` int NULL DEFAULT NULL COMMENT '创建时间',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '随想内容',
  `total_likes` int NULL DEFAULT NULL COMMENT '点赞数',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (0, '张三', 123, '1231', 1231);
INSERT INTO `comment` VALUES (27, 'LeoMilk', 1, '\"sdasd\"', 1);
INSERT INTO `comment` VALUES (28, 'LeoMilk', 1, '\"fsfsdff\"', 1);
INSERT INTO `comment` VALUES (29, 'LeoMilk', 1, '\"阿松大萨达大苏打的阿达阿三撒旦阿松大阿萨\"', 1);
INSERT INTO `comment` VALUES (30, 'undefined', 1, '\"安抚阿斯弗\"', 1);

SET FOREIGN_KEY_CHECKS = 1;
