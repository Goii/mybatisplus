/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL
 Source Server Type    : MySQL
 Source Server Version : 50096
 Source Host           : 127.0.0.1:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50096
 File Encoding         : 65001

 Date: 31/01/2021 15:59:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `deleted` int(255) NULL DEFAULT 0,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Jone', 18, 'test1@baomidou.com', '3', 0);
INSERT INTO `user` VALUES (2, 'Jack', 20, 'test2@baomidou.com', '2', 0);
INSERT INTO `user` VALUES (3, 'Tom', 28, 'test3@baomidou.com', '1', 0);
INSERT INTO `user` VALUES (4, 'Sandy', 21, 'test4@baomidou.com', '1', 0);
INSERT INTO `user` VALUES (5, 'Levi', 15, 'test5@163.com', '2', 1);

SET FOREIGN_KEY_CHECKS = 1;
