/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : mydb

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 19/05/2022 14:42:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `contract_Id` int(11) NOT NULL AUTO_INCREMENT,
  `contract_Info` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contract_Start` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contract_End` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contract_Describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contract_State` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contract_Amount` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`contract_Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES (1, '陈博', '2019-09-09', '2020-09-09', 'WWWXX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '200吨');
INSERT INTO `contract` VALUES (2, '陈俊龙', '2019-10-10', '2021-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '201吨');
INSERT INTO `contract` VALUES (3, '陈俊鑫', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '202吨');
INSERT INTO `contract` VALUES (4, '陈琪', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '203吨');
INSERT INTO `contract` VALUES (5, '成相璋', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '204吨');
INSERT INTO `contract` VALUES (6, '仇天硕', '2019-10-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '205吨');
INSERT INTO `contract` VALUES (7, '杜闯', '2019-05-04', '2019-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '206吨');
INSERT INTO `contract` VALUES (8, '范清清', '2019-10-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '未结算', '207吨');
INSERT INTO `contract` VALUES (9, '冯镇', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '208吨');
INSERT INTO `contract` VALUES (10, '伏子豪', '2019-10-10', '2021-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '201吨');
INSERT INTO `contract` VALUES (11, '傅嘉恒', '2019-10-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '未结算', '210吨');
INSERT INTO `contract` VALUES (12, '苟晶晶', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '211吨');
INSERT INTO `contract` VALUES (13, '郭泽泰', '2019-10-10', '2021-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '201吨');
INSERT INTO `contract` VALUES (14, '胡惠琴', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '213吨');
INSERT INTO `contract` VALUES (15, '黄明水', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '214吨');
INSERT INTO `contract` VALUES (16, '贾爱玲', '2019-05-04', '2019-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '206吨');
INSERT INTO `contract` VALUES (17, '李程远', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '216吨');
INSERT INTO `contract` VALUES (18, '李珍平', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '217吨');
INSERT INTO `contract` VALUES (19, '陆海洋', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '218吨');
INSERT INTO `contract` VALUES (20, '彭博', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '219吨');
INSERT INTO `contract` VALUES (21, '彭璇', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '220吨');
INSERT INTO `contract` VALUES (22, '曲宇赫', '2019-05-04', '2019-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '206吨');
INSERT INTO `contract` VALUES (23, '谭鑫', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '222吨');
INSERT INTO `contract` VALUES (24, '涂迅', '2019-10-10', '2021-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '201吨');
INSERT INTO `contract` VALUES (25, '王学兵', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '224吨');
INSERT INTO `contract` VALUES (26, '王逸者', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '225吨');
INSERT INTO `contract` VALUES (27, '吴辰昊', '2019-05-04', '2019-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '206吨');
INSERT INTO `contract` VALUES (28, '吴霜', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '227吨');
INSERT INTO `contract` VALUES (29, '杨友森', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '228吨');
INSERT INTO `contract` VALUES (30, '杨哲', '2019-10-10', '2021-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '201吨');
INSERT INTO `contract` VALUES (31, '叶盛', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '230吨');
INSERT INTO `contract` VALUES (32, '张戈旭', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '231吨');
INSERT INTO `contract` VALUES (33, '郑玮琪', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '未结算', '232吨');
INSERT INTO `contract` VALUES (34, '邹珊珊', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '未结算', '233吨');
INSERT INTO `contract` VALUES (35, '林睿', '2019-10-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '未结算', '234吨');
INSERT INTO `contract` VALUES (36, '陈湘', '2019-10-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '未结算', '235吨');
INSERT INTO `contract` VALUES (37, '蒋莹', '2019-10-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '未结算', '236吨');
INSERT INTO `contract` VALUES (38, '张荣轩', '2019-10-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '未结算', '237吨');
INSERT INTO `contract` VALUES (39, '曹集翔', '2019-10-10', '2021-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '201吨');
INSERT INTO `contract` VALUES (40, '赵辰阳', '2019-10-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '未结算', '239吨');
INSERT INTO `contract` VALUES (41, '仇天硕', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '240吨');
INSERT INTO `contract` VALUES (42, '郑然', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '241吨');
INSERT INTO `contract` VALUES (43, '秦超凡', '2019-05-04', '2019-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '206吨');
INSERT INTO `contract` VALUES (44, '江华明', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '243吨');
INSERT INTO `contract` VALUES (45, '秦伟泽', '2019-09-09', '2020-09-09', 'XX大学与XX供气站合作，XX大学工作人员可持XX大学专属供气卡前来供气，供气总量为200吨，合同时间为1年', '已结算', '244吨');

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data`  (
  `data_Id` int(11) NOT NULL AUTO_INCREMENT,
  `data_Time` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `data_Amount` int(11) NULL DEFAULT NULL,
  `data_Info` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `data_User` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`data_Id`) USING BTREE,
  INDEX `User_Data`(`data_User`) USING BTREE,
  CONSTRAINT `User_Data` FOREIGN KEY (`data_User`) REFERENCES `user` (`User_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of data
-- ----------------------------
INSERT INTO `data` VALUES (1, '2022-04-10', 668, '陈博', 1);
INSERT INTO `data` VALUES (2, '2022-04-17', 123, '陈俊龙', 1);
INSERT INTO `data` VALUES (3, '2019-09-09', 123, '陈俊鑫', 1);
INSERT INTO `data` VALUES (4, '2022-04-17', 123, '陈琪', 2);
INSERT INTO `data` VALUES (5, '2022-04-17', 123, '成相璋', 2);
INSERT INTO `data` VALUES (6, '2022-05-01', 57, '仇天硕', 1);
INSERT INTO `data` VALUES (7, '2022-06-01', 58, '杜闯', 2);
INSERT INTO `data` VALUES (8, '2022-07-01', 59, '范清清', 1);
INSERT INTO `data` VALUES (9, '2022-08-01', 60, '冯镇', 2);
INSERT INTO `data` VALUES (10, '2022-09-01', 61, '伏子豪', 1);
INSERT INTO `data` VALUES (11, '2022-10-01', 62, '傅嘉恒', 2);
INSERT INTO `data` VALUES (12, '2022-11-01', 63, '苟晶晶', 1);
INSERT INTO `data` VALUES (13, '2022-12-01', 64, '郭泽泰', 2);
INSERT INTO `data` VALUES (14, '2022-01-01', 65, '胡惠琴', 2);
INSERT INTO `data` VALUES (15, '2022-02-01', 66, '黄明水', 2);
INSERT INTO `data` VALUES (16, '2022-03-01', 67, '贾爱玲', 1);
INSERT INTO `data` VALUES (17, '2022-04-01', 68, '李程远', 2);
INSERT INTO `data` VALUES (18, '2022-05-01', 69, '李珍平', 1);
INSERT INTO `data` VALUES (19, '2022-06-01', 70, '陆海洋', 2);
INSERT INTO `data` VALUES (20, '2022-07-01', 71, '彭博', 1);
INSERT INTO `data` VALUES (21, '2022-08-01', 72, '彭璇', 2);
INSERT INTO `data` VALUES (22, '2022-09-01', 73, '曲宇赫', 1);
INSERT INTO `data` VALUES (23, '2022-10-01', 74, '谭鑫', 2);
INSERT INTO `data` VALUES (24, '2022-11-01', 75, '涂迅', 1);
INSERT INTO `data` VALUES (25, '2022-12-01', 76, '王学兵', 1);
INSERT INTO `data` VALUES (26, '2022-01-01', 77, '王逸者', 1);
INSERT INTO `data` VALUES (27, '2022-02-01', 78, '吴辰昊', 1);
INSERT INTO `data` VALUES (28, '2022-03-01', 79, '吴霜', 2);
INSERT INTO `data` VALUES (29, '2022-04-01', 80, '杨友森', 1);
INSERT INTO `data` VALUES (30, '2022-05-01', 81, '杨哲', 2);
INSERT INTO `data` VALUES (31, '2022-06-01', 82, '叶盛', 1);
INSERT INTO `data` VALUES (32, '2022-07-01', 83, '张戈旭', 2);
INSERT INTO `data` VALUES (33, '2022-08-01', 84, '郑玮琪', 1);
INSERT INTO `data` VALUES (34, '2022-09-01', 85, '邹珊珊', 2);
INSERT INTO `data` VALUES (35, '2022-03-22', 123, '陈博', 1);

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `info_Id` int(11) NOT NULL AUTO_INCREMENT,
  `info_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info_Phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info_Type` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info_Cycle` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info_Address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info_Others` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`info_Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES (1, '陈博', '18176951312', '临时客户', '9', 'whut', '1');
INSERT INTO `info` VALUES (2, '陈俊龙', '18176951312', '常客户', '9', 'whut', '2');
INSERT INTO `info` VALUES (3, '陈俊鑫', '18176951312', '常客户', '9', 'whut', '3');
INSERT INTO `info` VALUES (4, '陈琪', '18176951312', '常客户', '9', 'whut', '4');
INSERT INTO `info` VALUES (5, '成相璋', '18176951312', '常客户', '9', 'whut', '5');
INSERT INTO `info` VALUES (6, '仇天硕', '18176951312', '常客户', '9', 'whut', '6');
INSERT INTO `info` VALUES (7, '杜闯', '18176951312', '常客户', '9', 'whut', '7');
INSERT INTO `info` VALUES (8, '范清清', '18176951312', '常客户', '9', 'whut', '8');
INSERT INTO `info` VALUES (9, '冯镇', '18176951312', '常客户', '9', 'whut', '9');
INSERT INTO `info` VALUES (10, '伏子豪', '18176951312', '常客户', '9', 'whut', '10');
INSERT INTO `info` VALUES (11, '傅嘉恒', '18176951312', '常客户', '9', 'whut', '11');
INSERT INTO `info` VALUES (12, '苟晶晶', '18176951312', '常客户', '9', 'whut', '12');
INSERT INTO `info` VALUES (13, '郭泽泰', '18176951312', '常客户', '9', 'whut', '13');
INSERT INTO `info` VALUES (14, '胡惠琴', '18176951312', '常客户', '9', 'whut', '14');
INSERT INTO `info` VALUES (15, '黄明水', '18176951312', '常客户', '9', 'whut', '15');
INSERT INTO `info` VALUES (16, '贾爱玲', '18176951312', '常客户', '9', 'whut', '16');
INSERT INTO `info` VALUES (17, '李程远', '18176951312', '常客户', '9', 'whut', '17');
INSERT INTO `info` VALUES (18, '李珍平', '18176951312', '常客户', '9', 'whut', '18');
INSERT INTO `info` VALUES (19, '陆海洋', '18176951312', '临时客户', '9', 'whut', '19');
INSERT INTO `info` VALUES (20, '彭博', '18176951312', '临时客户', '9', 'whut', '20');
INSERT INTO `info` VALUES (21, '彭璇', '18176951312', '临时客户', '9', 'whut', '21');
INSERT INTO `info` VALUES (22, '曲宇赫', '18176951312', '临时客户', '9', 'whut', '22');
INSERT INTO `info` VALUES (23, '谭鑫', '18176951312', '常客户', '9', 'whut', '23');
INSERT INTO `info` VALUES (24, '涂迅', '18176951312', '常客户', '9', 'whut', '24');
INSERT INTO `info` VALUES (25, '王学兵', '18176951312', '常客户', '9', 'whut', '25');
INSERT INTO `info` VALUES (26, '王逸者', '18176951312', '临时客户', '9', 'whut', '26');
INSERT INTO `info` VALUES (27, '吴辰昊', '18176951312', '临时客户', '9', 'whut', '27');
INSERT INTO `info` VALUES (28, '吴霜', '18176951312', '临时客户', '9', 'whut', '28');
INSERT INTO `info` VALUES (29, '杨友森', '123', '常客户', '123', 'whut', '29');
INSERT INTO `info` VALUES (30, '杨哲', '18176951312', '临时客户', '9', 'whut', '30');
INSERT INTO `info` VALUES (31, '叶盛', '18176951312', '常客户', '9', 'whut', '31');
INSERT INTO `info` VALUES (32, '张戈旭', '123', '临时客户', '123', 'whut', '32');
INSERT INTO `info` VALUES (33, '郑玮琪', '123', '常客户', '123', 'whut', '33');
INSERT INTO `info` VALUES (34, '邹珊珊', '123', '常客户', '5', 'whut', '34');
INSERT INTO `info` VALUES (35, '陈湘', '15215248454', '常客户', '123', 'whut', '35');
INSERT INTO `info` VALUES (36, '林睿', '15252564752', '临时客户', '5', 'dlut', '36');
INSERT INTO `info` VALUES (37, '邓春芳', '123', '常客户', '12', '中南财经政法大学', '123');

-- ----------------------------
-- Table structure for overdate
-- ----------------------------
DROP TABLE IF EXISTS `overdate`;
CREATE TABLE `overdate`  (
  `overdate_Id` int(11) NOT NULL AUTO_INCREMENT,
  `overdate_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `overdate_Phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `overdate_Type` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `overdate_Time` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`overdate_Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of overdate
-- ----------------------------
INSERT INTO `overdate` VALUES (1, '陈博', '18176951312', '临时客户', '5天');
INSERT INTO `overdate` VALUES (2, '陈俊龙', '18176951312', '临时客户', '3天');
INSERT INTO `overdate` VALUES (3, '陈俊鑫', '18176951312', '临时客户', '2天');
INSERT INTO `overdate` VALUES (4, '陈琪', '18176951312', '常客户', '4天');
INSERT INTO `overdate` VALUES (5, '成相璋', '18176951312', '常客户', '5天');
INSERT INTO `overdate` VALUES (6, '仇天硕', '18176951311', '常客户', '6天');
INSERT INTO `overdate` VALUES (7, '杜闯', '18176951312', '常客户', '7天');
INSERT INTO `overdate` VALUES (8, '范清清', '18176951312', '常客户', '8天');
INSERT INTO `overdate` VALUES (9, '冯镇', '18176951312', '临时客户', '9天');
INSERT INTO `overdate` VALUES (10, '伏子豪', '18176951312', '临时客户', '10天');
INSERT INTO `overdate` VALUES (11, '傅嘉恒', '18176951312', '临时客户', '11天');
INSERT INTO `overdate` VALUES (12, '苟晶晶', '18176951312', '常客户', '12天');
INSERT INTO `overdate` VALUES (13, '郭泽泰', '18176951312', '常客户', '13天');
INSERT INTO `overdate` VALUES (14, '胡惠琴', '18176951312', '常客户', '14天');
INSERT INTO `overdate` VALUES (15, '黄明水', '18176951312', '常客户', '15天');
INSERT INTO `overdate` VALUES (16, '贾爱玲', '18176951312', '常客户', '16天');
INSERT INTO `overdate` VALUES (17, '李程远', '18176951312', '常客户', '17天');
INSERT INTO `overdate` VALUES (18, '李珍平', '18176951312', '常客户', '18天');
INSERT INTO `overdate` VALUES (19, '陆海洋', '18176951312', '常客户', '19天');
INSERT INTO `overdate` VALUES (20, '彭博', '18176951312', '常客户', '20天');
INSERT INTO `overdate` VALUES (21, '彭璇', '18176951312', '常客户', '21天');
INSERT INTO `overdate` VALUES (22, '曲宇赫', '18176951312', '常客户', '22天');
INSERT INTO `overdate` VALUES (23, '谭鑫', '18176951312', '常客户', '23天');
INSERT INTO `overdate` VALUES (24, '涂迅', '18176951312', '常客户', '20天');
INSERT INTO `overdate` VALUES (25, '王学兵', '18176951312', '常客户', '25天');
INSERT INTO `overdate` VALUES (26, '王逸者', '18176951312', '常客户', '26天');
INSERT INTO `overdate` VALUES (27, '吴辰昊', '18176951312', '常客户', '27天');
INSERT INTO `overdate` VALUES (28, '吴霜', '18176951312', '常客户', '28天');
INSERT INTO `overdate` VALUES (29, '杨友森', '18176951312', '临时客户', '29天');
INSERT INTO `overdate` VALUES (30, '杨哲', '18176951312', '临时客户', '30天');
INSERT INTO `overdate` VALUES (31, '叶盛', '18176951312', '临时客户', '31天');
INSERT INTO `overdate` VALUES (32, '张戈旭', '18176951312', '临时客户', '32天');
INSERT INTO `overdate` VALUES (33, '郑玮琪', '18176951312', '常客户', '33天');
INSERT INTO `overdate` VALUES (34, '邹珊珊', '18176951312', '常客户', '34天');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_Id` int(11) NOT NULL,
  `role_Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin');
INSERT INTO `role` VALUES (2, 'user');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `User_Id` int(11) NOT NULL,
  `User_Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `User_Pass` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `User_Phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `User_Address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `User_Role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`User_Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '涂迅', '123', '18176951312', 'whut1999', '1');
INSERT INTO `user` VALUES (2, '谭鑫', '123', '18176951312', 'whut2', '2');
INSERT INTO `user` VALUES (3, '陈博', '123', '18176951312', 'whut3', '1');
INSERT INTO `user` VALUES (4, '陈俊龙', '123', '18176951312', 'whut4', '1');
INSERT INTO `user` VALUES (5, '陈俊鑫', '123', '18176951312', 'whut5', '1');
INSERT INTO `user` VALUES (6, '陈琪', '123', '18176951312', 'whut6', '2');
INSERT INTO `user` VALUES (7, '成相璋', '123', '18176951312', 'whut7', '1');
INSERT INTO `user` VALUES (8, '仇天硕', '123', '18176951312', 'whut8', '2');
INSERT INTO `user` VALUES (9, '杜闯', '123', '18176951312', 'whut9', '1');
INSERT INTO `user` VALUES (10, '范清清', '123', '18176951312', 'whut10', '2');
INSERT INTO `user` VALUES (11, '冯镇', '123', '18176951312', 'whut11', '2');
INSERT INTO `user` VALUES (12, '伏子豪', '123', '18176951312', 'whut12', '2');
INSERT INTO `user` VALUES (13, '傅嘉恒', '123', '18176951312', 'whut13', '2');
INSERT INTO `user` VALUES (14, '苟晶晶', '123', '18176951312', 'whut14', '2');
INSERT INTO `user` VALUES (15, '郭泽泰', '123', '18176951312', 'whut15', '2');
INSERT INTO `user` VALUES (16, '胡惠琴', '123', '18176951312', 'whut16', '2');
INSERT INTO `user` VALUES (17, '黄明水', '123', '18176951312', 'whut17', '2');
INSERT INTO `user` VALUES (18, '贾爱玲', '123', '18176951312', 'whut18', '2');
INSERT INTO `user` VALUES (19, '李程远', '123', '18176951312', 'whut19', '2');
INSERT INTO `user` VALUES (20, '李珍平', '123', '18176951312', 'whut20', '2');
INSERT INTO `user` VALUES (21, '陆海洋', '123', '18176951312', 'whut21', '2');
INSERT INTO `user` VALUES (22, '彭博', '123', '18176951312', 'whut22', '2');
INSERT INTO `user` VALUES (23, '彭璇', '123', '18176951312', 'whut23', '2');
INSERT INTO `user` VALUES (24, '曲宇赫', '123', '18176951312', 'whut24', '2');
INSERT INTO `user` VALUES (25, '王学兵', '123', '18176951312', 'whut25', '2');
INSERT INTO `user` VALUES (26, '王逸者', '123', '18176951312', 'whut26', '2');
INSERT INTO `user` VALUES (27, '吴辰昊', '123', '18176951312', 'whut27', '2');
INSERT INTO `user` VALUES (28, '吴霜', '123', '18176951312', 'whut28', '2');
INSERT INTO `user` VALUES (29, '杨友森', '123', '18176951312', 'whut29', '2');
INSERT INTO `user` VALUES (30, '杨哲', '123', '18176951312', 'whut30', '2');
INSERT INTO `user` VALUES (31, '叶盛', '123', '18176951312', 'whut31', '2');
INSERT INTO `user` VALUES (32, '张戈旭', '123', '18176951312', 'whut32', '2');
INSERT INTO `user` VALUES (33, '郑玮琪', '123', '18176951312', 'whut33', '2');
INSERT INTO `user` VALUES (34, '邹珊珊', '123', '18176951312', 'whut34', '2');
INSERT INTO `user` VALUES (35, '林睿', '123', '18176951312', 'whut35', '1');
INSERT INTO `user` VALUES (36, '陈湘', '123', '18176951312', 'whut36', '2');
INSERT INTO `user` VALUES (37, '蒋莹', '123', '18176951312', 'whut37', '2');
INSERT INTO `user` VALUES (38, '张荣轩', '123', '18176951312', 'whut38', '2');
INSERT INTO `user` VALUES (39, '曹集翔', '123', '18176951312', 'whut39', '2');
INSERT INTO `user` VALUES (40, '赵辰阳', '123', '18176951312', 'whut40', '2');
INSERT INTO `user` VALUES (41, '仇天硕', '123', '18176951312', 'whut41', '2');
INSERT INTO `user` VALUES (42, '郑然', '123', '18176951312', 'whut42', '2');
INSERT INTO `user` VALUES (43, '秦超凡', '123', '18176951312', 'whut43', '2');
INSERT INTO `user` VALUES (44, '江华明', '123', '18176951312', 'whut44', '2');
INSERT INTO `user` VALUES (45, '秦伟泽', '123', '18176951312', 'whut45', '2');

SET FOREIGN_KEY_CHECKS = 1;
