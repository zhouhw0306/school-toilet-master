/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost:3306
 Source Schema         : school_master

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : 65001

 Date: 01/09/2022 20:15:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_toilet
-- ----------------------------
DROP TABLE IF EXISTS `tbl_toilet`;
CREATE TABLE `tbl_toilet`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(255) NULL DEFAULT NULL COMMENT '类型  1 小便池 2 蹲坑 3马桶',
  `status` int(255) NULL DEFAULT NULL COMMENT '0 无人  1 有人 2 维修中 ',
  `place_no` int(255) NULL DEFAULT NULL COMMENT '所属大楼编号',
  `place_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细位置',
  `sex` int(255) NULL DEFAULT NULL COMMENT '1 男 0女',
  `health` int(255) NULL DEFAULT NULL COMMENT '1 干净 2 一般 3 肮脏',
  `use_num` int(11) NULL DEFAULT NULL COMMENT '使用次数',
  `use_num_count` int(255) NULL DEFAULT NULL COMMENT '使用总次数',
  `setup_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '安装时间',
  `clean_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上次清洁时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 99 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_toilet
-- ----------------------------
INSERT INTO `tbl_toilet` VALUES (20, 1, 1, 2, '爱心楼1楼男厕5号蹲坑', 1, 2, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (19, 1, 0, 1, '启德楼1楼男厕1号蹲坑', 1, 3, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (18, 2, 1, 1, '启德楼1楼男厕2号蹲坑', 1, 2, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (7, 3, 1, 4, '致远楼2楼女厕1号马桶', 0, 1, 21, 245, '2022-01-19 19:57:53', '2022-08-11 07:00:07');
INSERT INTO `tbl_toilet` VALUES (76, 3, 1, 4, '致远楼3楼男厕2号马桶', 1, 1, 0, 0, '2022-09-01 19:45:31', '2022-09-01 19:45:31');
INSERT INTO `tbl_toilet` VALUES (9, 3, 0, 1, '启德楼1楼女厕1号马桶', 0, 3, 1, 102, '2022-03-09 07:58:12', '2022-08-12 13:00:55');
INSERT INTO `tbl_toilet` VALUES (10, 2, 1, 4, '致远楼3楼男厕1号蹲坑', 1, 1, 2, 45, '2022-07-07 14:58:18', '2022-08-11 10:00:59');
INSERT INTO `tbl_toilet` VALUES (11, 2, 0, 5, '沁华楼2楼女厕1号蹲坑', 0, 2, 5, 21, '2022-08-03 10:58:23', '2022-08-14 10:01:03');
INSERT INTO `tbl_toilet` VALUES (12, 1, 0, 1, '启德楼1楼男厕1号小便池', 1, 3, 68, 456, '2020-01-23 12:58:26', '2022-08-14 06:01:05');
INSERT INTO `tbl_toilet` VALUES (13, 3, 1, 5, '沁华楼2楼女厕1号马桶', 0, 3, 54, 455, '2020-02-12 14:58:34', '2022-08-14 01:01:07');
INSERT INTO `tbl_toilet` VALUES (14, 2, 1, 1, '启德楼1楼男厕3号蹲坑', 1, 1, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (17, 2, 0, 1, '启德楼1楼男厕4号蹲坑', 1, 3, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (16, 2, 0, 1, '启德楼1楼男厕6号蹲坑', 1, 2, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (15, 2, 1, 1, '启德楼1楼男厕5号蹲坑', 1, 1, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (21, 3, 1, 1, '启德楼1楼男厕5号马桶', 1, 2, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (67, 3, 1, 2, '爱心楼3楼女厕1号马桶', 0, 1, 0, 0, '2022-09-01 19:42:12', '2022-09-01 19:42:12');
INSERT INTO `tbl_toilet` VALUES (66, 2, 0, 2, '爱心楼2楼男厕5号蹲坑', 1, 1, 0, 0, '2022-09-01 19:41:34', '2022-09-01 19:41:34');
INSERT INTO `tbl_toilet` VALUES (65, 2, 1, 2, '爱心楼2楼男厕4号蹲坑', 1, 1, 0, 0, '2022-09-01 19:41:24', '2022-09-01 19:41:24');
INSERT INTO `tbl_toilet` VALUES (64, 2, 0, 2, '爱心楼2楼男厕3号蹲坑', 1, 1, 0, 0, '2022-09-01 19:41:14', '2022-09-01 19:41:14');
INSERT INTO `tbl_toilet` VALUES (63, 2, 1, 2, '爱心楼2楼男厕2号蹲坑', 1, 1, 0, 0, '2022-09-01 19:41:02', '2022-09-01 19:41:02');
INSERT INTO `tbl_toilet` VALUES (62, 2, 1, 2, '爱心楼2楼男厕1号蹲坑', 1, 1, 0, 0, '2022-09-01 19:40:52', '2022-09-01 19:40:52');
INSERT INTO `tbl_toilet` VALUES (34, 2, 1, 3, '逸夫楼1楼男厕1号蹲坑', 1, 1, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (35, 2, 1, 3, '逸夫楼1楼男厕2号蹲坑', 1, 2, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (36, 2, 2, 3, '逸夫楼1楼男厕3号蹲坑', 1, 1, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (37, 2, 0, 3, '逸夫楼1楼男厕4号蹲坑', 1, 2, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (38, 2, 1, 3, '逸夫楼1楼男厕5号蹲坑', 1, 1, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (39, 2, 0, 3, '逸夫楼1楼男厕6号蹲坑', 1, 2, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (40, 2, 0, 3, '逸夫楼1楼男厕7号蹲坑', 1, 1, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (41, 2, 2, 3, '逸夫楼1楼男厕1号蹲坑', 1, 2, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (42, 1, 0, 3, '逸夫楼1楼男厕1号小便池', 1, 1, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (43, 2, 1, 3, '逸夫楼1楼男厕8号蹲坑', 1, 3, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (44, 1, 0, 2, '爱心楼1楼男厕5号小便池', 1, 1, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (45, 2, 1, 3, '逸夫楼1楼男厕9号蹲坑', 1, 2, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (46, 2, 0, 3, '逸夫楼1楼男厕10号蹲坑', 1, 1, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (47, 2, 0, 3, '逸夫楼1楼男厕11号蹲坑', 1, 2, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (48, 2, 2, 3, '逸夫楼1楼男厕12号蹲坑', 1, 2, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (49, 2, 1, 3, '逸夫楼1楼男厕13号蹲坑', 1, 1, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (50, 2, 1, 3, '逸夫楼1楼男厕14号蹲坑', 1, 2, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (51, 2, 1, 3, '逸夫楼1楼男厕15号蹲坑', 1, 1, 12, 466, '2020-11-14 14:58:41', '2022-08-14 21:01:12');
INSERT INTO `tbl_toilet` VALUES (75, 3, 1, 4, '致远楼3楼男厕1号马桶', 1, 1, 0, 0, '2022-09-01 19:45:18', '2022-09-01 19:45:18');
INSERT INTO `tbl_toilet` VALUES (74, 1, 0, 4, '致远楼3楼男厕3号小便池', 1, 1, 0, 0, '2022-09-01 19:45:06', '2022-09-01 19:45:06');
INSERT INTO `tbl_toilet` VALUES (73, 1, 1, 4, '致远楼3楼男厕2号小便池', 1, 1, 0, 0, '2022-09-01 19:44:56', '2022-09-01 19:44:56');
INSERT INTO `tbl_toilet` VALUES (72, 1, 1, 4, '致远楼3楼男厕1号小便池', 1, 1, 0, 0, '2022-09-01 19:44:39', '2022-09-01 19:44:39');
INSERT INTO `tbl_toilet` VALUES (68, 3, 0, 2, '爱心楼3楼女厕2号马桶', 0, 1, 0, 0, '2022-09-01 19:42:31', '2022-09-01 19:42:31');
INSERT INTO `tbl_toilet` VALUES (69, 3, 1, 2, '爱心楼3楼女厕3号马桶', 0, 1, 0, 0, '2022-09-01 19:42:40', '2022-09-01 19:42:40');
INSERT INTO `tbl_toilet` VALUES (70, 2, 0, 4, '致远楼3楼男厕2号蹲坑', 1, 1, 0, 0, '2022-09-01 19:44:11', '2022-09-01 19:44:11');
INSERT INTO `tbl_toilet` VALUES (71, 2, 0, 4, '致远楼3楼男厕3号蹲坑', 1, 1, 0, 0, '2022-09-01 19:44:22', '2022-09-01 19:44:22');
INSERT INTO `tbl_toilet` VALUES (77, 3, 1, 4, '致远楼3楼男厕3号马桶', 1, 1, 0, 0, '2022-09-01 19:45:40', '2022-09-01 19:45:40');
INSERT INTO `tbl_toilet` VALUES (78, 3, 1, 4, '致远楼2楼女厕2号马桶', 0, 1, 0, 0, '2022-09-01 19:47:45', '2022-09-01 19:47:45');
INSERT INTO `tbl_toilet` VALUES (79, 3, 1, 4, '致远楼2楼女厕3号马桶', 0, 1, 0, 0, '2022-09-01 19:47:54', '2022-09-01 19:47:54');
INSERT INTO `tbl_toilet` VALUES (80, 3, 1, 4, '致远楼2楼女厕4号马桶', 0, 1, 0, 0, '2022-09-01 19:48:04', '2022-09-01 19:48:04');
INSERT INTO `tbl_toilet` VALUES (81, 3, 1, 4, '致远楼2楼女厕5号马桶', 0, 1, 0, 0, '2022-09-01 19:48:27', '2022-09-01 19:48:27');
INSERT INTO `tbl_toilet` VALUES (82, 3, 1, 4, '致远楼2楼女厕6号马桶', 0, 1, 0, 0, '2022-09-01 19:48:37', '2022-09-01 19:48:37');
INSERT INTO `tbl_toilet` VALUES (83, 1, 1, 5, '沁华楼3楼男厕1号小便池', 1, 1, 0, 0, '2022-09-01 19:50:25', '2022-09-01 19:50:25');
INSERT INTO `tbl_toilet` VALUES (84, 1, 1, 5, '沁华楼3楼男厕2号小便池', 1, 1, 0, 0, '2022-09-01 19:50:37', '2022-09-01 19:50:37');
INSERT INTO `tbl_toilet` VALUES (85, 1, 0, 5, '沁华楼3楼男厕3号小便池', 1, 1, 0, 0, '2022-09-01 19:50:50', '2022-09-01 19:50:50');
INSERT INTO `tbl_toilet` VALUES (86, 2, 1, 5, '沁华楼3楼男厕1号蹲坑', 1, 1, 0, 0, '2022-09-01 19:53:33', '2022-09-01 19:53:33');
INSERT INTO `tbl_toilet` VALUES (87, 2, 1, 5, '沁华楼3楼男厕2号蹲坑', 1, 1, 0, 0, '2022-09-01 19:53:41', '2022-09-01 19:53:41');
INSERT INTO `tbl_toilet` VALUES (88, 2, 1, 5, '沁华楼3楼男厕3号蹲坑', 1, 1, 0, 0, '2022-09-01 19:53:49', '2022-09-01 19:53:49');
INSERT INTO `tbl_toilet` VALUES (89, 3, 1, 5, '沁华楼3楼男厕1号马桶', 1, 1, 0, 0, '2022-09-01 19:53:59', '2022-09-01 19:53:59');
INSERT INTO `tbl_toilet` VALUES (90, 3, 1, 5, '沁华楼3楼男厕2号马桶', 1, 1, 0, 0, '2022-09-01 19:54:07', '2022-09-01 19:54:07');
INSERT INTO `tbl_toilet` VALUES (91, 3, 0, 5, '沁华楼3楼男厕3号马桶', 1, 1, 0, 0, '2022-09-01 19:54:15', '2022-09-01 19:54:15');
INSERT INTO `tbl_toilet` VALUES (92, 2, 1, 5, '沁华楼3楼女厕2号蹲坑', 0, 1, 0, 0, '2022-09-01 19:54:44', '2022-09-01 19:54:44');
INSERT INTO `tbl_toilet` VALUES (93, 2, 1, 5, '沁华楼3楼女厕3号蹲坑', 0, 1, 0, 0, '2022-09-01 19:54:52', '2022-09-01 19:54:52');
INSERT INTO `tbl_toilet` VALUES (94, 3, 1, 5, '沁华楼3楼女厕2号马桶', 0, 1, 0, 0, '2022-09-01 19:55:05', '2022-09-01 19:55:05');
INSERT INTO `tbl_toilet` VALUES (95, 3, 0, 5, '沁华楼3楼女厕3号马桶', 0, 1, 0, 0, '2022-09-01 19:55:12', '2022-09-01 19:55:12');
INSERT INTO `tbl_toilet` VALUES (96, 3, 1, 5, '沁华楼3楼女厕4号马桶', 0, 1, 0, 0, '2022-09-01 19:55:21', '2022-09-01 19:55:21');
INSERT INTO `tbl_toilet` VALUES (97, 3, 1, 5, '沁华楼3楼女厕5号马桶', 0, 1, 0, 0, '2022-09-01 19:55:30', '2022-09-01 19:55:30');
INSERT INTO `tbl_toilet` VALUES (98, 3, 1, 5, '沁华楼3楼女厕6号马桶', 0, 1, 0, 0, '2022-09-01 19:55:37', '2022-09-01 19:55:37');

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES (1, 'admin', '333', '浅夏', '广东深圳', '2022-08-14 16:19:05');

SET FOREIGN_KEY_CHECKS = 1;
