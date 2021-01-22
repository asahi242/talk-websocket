/*
 Navicat Premium Data Transfer

 Source Server         : 个人
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : localhost:3306
 Source Schema         : talk

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 22/01/2021 18:08:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userid` int(20) NULL DEFAULT NULL,
  `friendid` int(20) NULL DEFAULT NULL,
  `groupNum` int(20) NULL DEFAULT NULL,
  `isdelete` int(1) NULL DEFAULT NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `modifyTIme` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES (1, 1, 2, 1, 0, NULL, NULL);
INSERT INTO `friend` VALUES (2, 1, 3, 1, 0, NULL, NULL);

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userid` int(20) NULL DEFAULT NULL,
  `groupName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `groupNum` int(20) NULL DEFAULT NULL,
  `isdelete` int(1) NULL DEFAULT NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `modifyTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES (1, 1, '好友', 1, 0, NULL, NULL);
INSERT INTO `group` VALUES (2, 1, '同学', 2, 0, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `online` int(1) NULL DEFAULT NULL COMMENT '0:离线 1:在线 2:隐身',
  `sex` int(1) NULL DEFAULT NULL,
  `age` int(20) NULL DEFAULT NULL,
  `isdelete` int(1) NULL DEFAULT NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `modifyTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangsan', '123', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, 'lisi', '123', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, 'wangwu', '123', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (4, 'zhaoliu', '123', 0, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
