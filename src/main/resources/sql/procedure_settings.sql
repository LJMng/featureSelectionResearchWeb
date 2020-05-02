/*
 Navicat Premium Data Transfer

 Source Server         : Stephen
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : feature_selection_web

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 26/04/2020 14:30:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for procedure_settings
-- ----------------------------
DROP TABLE IF EXISTS `procedure_settings`;
CREATE TABLE `procedure_settings`  (
  `id` int(11) NOT NULL AUTO_INCREMENT primary key,
  `algorithm_id` int(11) NOT NULL,
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `state` enum('required','optionalSelected','optional') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `options` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `default_option` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  CONSTRAINT `procedure_settings___fk1` FOREIGN KEY (`algorithm_id`) REFERENCES `algorithm` (`algorithm_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of procedure_settings   INDEX `procedure_settings_algorithm_algorithm_id_fk`(`id`) USING BTREE, INDEX `procedure_settings___fk1`(`algorithm_id`) USING BTREE,
-- ----------------------------
INSERT INTO `procedure_settings` VALUES (1, 1, 'gdut-p1', 'required', 'A Method,B Method,C Method,D Method,F Method', 'B Method', 'procedure1');
INSERT INTO `procedure_settings` VALUES (2, 1, 'gdut-p2', 'optionalSelected', 'A Method,B Method,C Method,D Method,F Method', 'C Method', 'procedure2');
INSERT INTO `procedure_settings` VALUES (3, 1, 'gdut-p3', 'optional', 'A Method,B Method,C Method,D Method,F Method', 'D Method', 'procedure3');
INSERT INTO `procedure_settings` VALUES (4, 1, 'gdut-p4', 'optionalSelected', 'A Method,B Method,C Method,D Method,F Method', 'F Method', 'procedure4');
INSERT INTO `procedure_settings` VALUES (8, 2, 'scau-p1', 'required', 'A Method,B Method,C Method,D Method,F Method', 'B Method', 'procedure1');
INSERT INTO `procedure_settings` VALUES (9, 2, 'scau-p2', 'optionalSelected', 'A Method,B Method,C Method,D Method,F Method', 'C Method', 'procedure2');
INSERT INTO `procedure_settings` VALUES (10, 2, 'scau-p3', 'optional', 'A Method,B Method,C Method,D Method,F Method', 'D Method', 'procedure3');
INSERT INTO `procedure_settings` VALUES (11, 2, 'scau-p4', 'optional', 'A Method,B Method,C Method,D Method,F Method', 'F Method', 'procedure4');

SET FOREIGN_KEY_CHECKS = 1;
