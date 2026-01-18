/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : oarit_hrss

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 18/01/2026 22:16:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for elv_campus
-- ----------------------------
DROP TABLE IF EXISTS `elv_campus`;
CREATE TABLE `elv_campus`  (
  `campusId` int NOT NULL AUTO_INCREMENT,
  `campusName` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `campusShortName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `campusUsernameId` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `campusAddress` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `campusCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `campusUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`campusId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for elv_faculty
-- ----------------------------
DROP TABLE IF EXISTS `elv_faculty`;
CREATE TABLE `elv_faculty`  (
  `facultyId` int NOT NULL AUTO_INCREMENT COMMENT 'รหัสคณะ',
  `facultyOrgCode` int NULL DEFAULT NULL,
  `facultyOrgType` int NULL DEFAULT NULL,
  `facultyName` varchar(200) CHARACTER SET tis620 COLLATE tis620_thai_ci NULL DEFAULT NULL,
  `facultyNameEn` varchar(200) CHARACTER SET tis620 COLLATE tis620_thai_ci NULL DEFAULT NULL,
  `facultyStatus` int NULL DEFAULT NULL,
  `facultyCampusId` varchar(5) CHARACTER SET tis620 COLLATE tis620_thai_ci NULL DEFAULT NULL,
  `facultyCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `facultyUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`facultyId`) USING BTREE,
  INDEX `f_name`(`facultyOrgCode`) USING BTREE,
  INDEX `f_type`(`facultyName`) USING BTREE,
  INDEX `f_status`(`facultyStatus`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 683 CHARACTER SET = tis620 COLLATE = tis620_thai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for elv_personnel
-- ----------------------------
DROP TABLE IF EXISTS `elv_personnel`;
CREATE TABLE `elv_personnel`  (
  `presId` int NOT NULL AUTO_INCREMENT,
  `presCitizenId` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'บัตรประชาชน',
  `presCampusId` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `presEmpCode` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'รหัสพนักงาน',
  `presFacultyCode` int NULL DEFAULT NULL,
  `presDepartmentCode` int NULL DEFAULT NULL,
  `presTitle` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `presFname` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `presLname` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `presGender` int NULL DEFAULT NULL COMMENT '1 = ชาย , 2 = หญิง',
  `presStatus` int NULL DEFAULT NULL,
  `presSignTitle` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'คำนำหน้าที่ใช้ในการลงนาม',
  `presSignPosition` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'ตำแหน่งในหน่วยงาน ณ ตอนนั้นที่ลงนาม',
  `presGovernmentId` int NULL DEFAULT NULL COMMENT 'ประเภทสิทธิ์การลา',
  `presRoleSignatureId` int NULL DEFAULT NULL COMMENT 'ตำแหน่งในหน่วยงาน / ตำแหน่งในการลงนาม',
  `presAuth` int NULL DEFAULT NULL COMMENT 'สถานะการรับรองผู้ใช้งาน',
  `presWorkStartDate` date NULL DEFAULT NULL COMMENT 'วันที่เริ่มงาน',
  `persWorkPeriodYear` int NULL DEFAULT NULL COMMENT 'ระยะเวลารวมปีที่ทำงาน (นับปี)',
  `persWorkPeriodMonth` int NULL DEFAULT NULL COMMENT 'ระยะเวลารวมปีที่ทำงาน (นับเดือน)',
  `presCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `presUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`presId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2335 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for elv_role_system
-- ----------------------------
DROP TABLE IF EXISTS `elv_role_system`;
CREATE TABLE `elv_role_system`  (
  `roleId` int NOT NULL AUTO_INCREMENT,
  `roleCode` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `roleNameTH` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `roleNameEN` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `roleCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `roleUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for elv_user
-- ----------------------------
DROP TABLE IF EXISTS `elv_user`;
CREATE TABLE `elv_user`  (
  `userId` int NOT NULL AUTO_INCREMENT,
  `userUsername` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `userCitizenId` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'บัตรประชาชน',
  `userEmail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `userTitle` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `userFirstName` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `userLastName` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `userFirstNameEng` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `userLastNameEng` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `userFacultyCode` int NULL DEFAULT NULL,
  `userDepartmentCode` int NULL DEFAULT NULL,
  `userPicture` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `userTel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `userMobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `userTypeId` int NULL DEFAULT NULL,
  `userStatus` int NULL DEFAULT NULL,
  `userCampusId` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `userSignatureFileName` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `userCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `userUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userLastLoginAt` datetime NULL DEFAULT NULL,
  `user_create_at` datetime(6) NULL DEFAULT NULL,
  `user_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `user_first_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `user_last_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `user_username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_activity_type
-- ----------------------------
DROP TABLE IF EXISTS `hrss_activity_type`;
CREATE TABLE `hrss_activity_type`  (
  `activityTypeId` int NOT NULL AUTO_INCREMENT,
  `activityTypeName` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `activityTypeActive` int NULL DEFAULT NULL,
  `activityTypeCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `activityTypeUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`activityTypeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_development_type
-- ----------------------------
DROP TABLE IF EXISTS `hrss_development_type`;
CREATE TABLE `hrss_development_type`  (
  `develTypeId` int NOT NULL AUTO_INCREMENT,
  `develTypeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `develSubOption` int NULL DEFAULT NULL,
  `develTypeActive` int NULL DEFAULT NULL,
  `develTypeCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `develTypeUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `devel_type_active` int NULL DEFAULT NULL,
  `devel_type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`develTypeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_directive_doc
-- ----------------------------
DROP TABLE IF EXISTS `hrss_directive_doc`;
CREATE TABLE `hrss_directive_doc`  (
  `directiveDocId` int NOT NULL AUTO_INCREMENT,
  `directiveDocNumber` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `directiveDocTypeId` int NULL DEFAULT NULL COMMENT 'pk table : hrss_directive_type',
  `directiveDocName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `directiveDocIssuedDate` date NULL DEFAULT NULL COMMENT 'ออกคำสัง ณ',
  `directiveDocStartDate` date NULL DEFAULT NULL COMMENT 'เริ่มทำดำเนินการ',
  `directiveDocEndDate` date NULL DEFAULT NULL COMMENT 'สิ้นสุดการดำเนินการ',
  `directiveDocFile` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT 'ไฟล์เอกสารคำสั่ง',
  `directiveDocUsername` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'เก็บ username',
  `directiveDocCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `directiveDocUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `directive_doc_issued_date` date NULL DEFAULT NULL,
  `directive_doc_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `directive_doc_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`directiveDocId`) USING BTREE,
  INDEX `directiveDocTypeId`(`directiveDocTypeId` ASC) USING BTREE,
  CONSTRAINT `hrss_directive_doc_ibfk_1` FOREIGN KEY (`directiveDocTypeId`) REFERENCES `hrss_directive_type` (`directiveTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_directive_duties
-- ----------------------------
DROP TABLE IF EXISTS `hrss_directive_duties`;
CREATE TABLE `hrss_directive_duties`  (
  `directiveDutiesId` int NOT NULL AUTO_INCREMENT,
  `directiveDutiesDocId` int NULL DEFAULT NULL COMMENT 'pk table hrss_directive_doc',
  `directiveDutiesName` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'ชื่อหน้าที่รับผิดชอบ',
  `directiveDutiesUnit` decimal(10, 2) NULL DEFAULT NULL,
  `directiveDutiesCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `directiveDutiesUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`directiveDutiesId`) USING BTREE,
  INDEX `directiveDutiesDocId`(`directiveDutiesDocId` ASC) USING BTREE,
  CONSTRAINT `hrss_directive_duties_ibfk_1` FOREIGN KEY (`directiveDutiesDocId`) REFERENCES `hrss_directive_doc` (`directiveDocId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_directive_member
-- ----------------------------
DROP TABLE IF EXISTS `hrss_directive_member`;
CREATE TABLE `hrss_directive_member`  (
  `directiveMemberId` int NOT NULL AUTO_INCREMENT,
  `directiveMemberDutiesId` int NULL DEFAULT NULL COMMENT 'pk table : hrss_directive_duties',
  `directiveMemberCitizenId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'เลขบัตรประชาชน',
  `directiveMemberCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `directiveMemberUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`directiveMemberId`) USING BTREE,
  INDEX `directiveMemberDutiesId`(`directiveMemberDutiesId` ASC) USING BTREE,
  CONSTRAINT `hrss_directive_member_ibfk_1` FOREIGN KEY (`directiveMemberDutiesId`) REFERENCES `hrss_directive_duties` (`directiveDutiesId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_directive_type
-- ----------------------------
DROP TABLE IF EXISTS `hrss_directive_type`;
CREATE TABLE `hrss_directive_type`  (
  `directiveTypeId` int NOT NULL AUTO_INCREMENT,
  `directiveTypeName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `directiveTypeCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `directiveTypeUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`directiveTypeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_green_office
-- ----------------------------
DROP TABLE IF EXISTS `hrss_green_office`;
CREATE TABLE `hrss_green_office`  (
  `greenOfficeActId` int NOT NULL AUTO_INCREMENT,
  `greenOfficeActName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `greenOfficeActShort` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `greenOfficeActScore` int NULL DEFAULT NULL,
  `greenOfficeActCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `greenOfficeActUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`greenOfficeActId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_knowledge_type
-- ----------------------------
DROP TABLE IF EXISTS `hrss_knowledge_type`;
CREATE TABLE `hrss_knowledge_type`  (
  `knowledgeId` int NOT NULL AUTO_INCREMENT,
  `knowledgeName` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `knowledgeGreenOption` int NULL DEFAULT NULL,
  `knowledgeActive` int NULL DEFAULT NULL,
  `knowledgeCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `knowledgeUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`knowledgeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_master_access
-- ----------------------------
DROP TABLE IF EXISTS `hrss_master_access`;
CREATE TABLE `hrss_master_access`  (
  `accessId` int NOT NULL AUTO_INCREMENT,
  `accessMenuId` int NULL DEFAULT NULL,
  `accessRoleId` int NULL DEFAULT NULL,
  `accessIsView` int NULL DEFAULT NULL,
  `accessIsEdit` int NULL DEFAULT NULL,
  `accessIsDataCampus` int NULL DEFAULT NULL,
  `accessCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `accessUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`accessId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 383 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_master_menu
-- ----------------------------
DROP TABLE IF EXISTS `hrss_master_menu`;
CREATE TABLE `hrss_master_menu`  (
  `menuId` int NOT NULL AUTO_INCREMENT,
  `menuNameTH` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `menuNameEN` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `menuUrl` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `menuIcon` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `menuPath` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'พาท url ตัวกำหนดว่าคุณอยู่ที่เมนูไหน',
  `menuUrlStart` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'สำรหับเข้าถึง path sub',
  `menuIndex` int NULL DEFAULT NULL COMMENT 'ลำดับการแสดงผลเมนู',
  `menuStatus` int NULL DEFAULT 1 COMMENT '0 = ไม่ใช้งาน , 1 = ใช้งาน',
  `menuCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `menuUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`menuId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_master_submenu
-- ----------------------------
DROP TABLE IF EXISTS `hrss_master_submenu`;
CREATE TABLE `hrss_master_submenu`  (
  `subMenuId` int NOT NULL AUTO_INCREMENT,
  `subMenuMainId` int NULL DEFAULT NULL COMMENT 'pk table = ris_menu',
  `subMenuNameTH` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `subMenuNameEN` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `subMenuUrl` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `subMenuPath` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `subMenuStatus` int NULL DEFAULT NULL,
  `subMenuIndex` int NULL DEFAULT NULL,
  `subMenuCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `subMenuUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`subMenuId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_report
-- ----------------------------
DROP TABLE IF EXISTS `hrss_report`;
CREATE TABLE `hrss_report`  (
  `reportId` int NOT NULL AUTO_INCREMENT,
  `reportActivityTypeId` int NULL DEFAULT NULL,
  `reportDevelopmentTypeId` int NULL DEFAULT NULL,
  `reportTitle` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `reportUsername` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `reportDirectiveDocId` int NULL DEFAULT NULL COMMENT 'pk table : hrss_directive_doc',
  `reportLocation` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `reportOrganizer` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `reportUtilizationTypeId` int NULL DEFAULT NULL,
  `reportUtilizationTypeOther` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `reportAttachedFile` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT 'ชื่อไฟล์',
  `reportDescription` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `reportSuggestion` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `reportCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reportUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`reportId`) USING BTREE,
  INDEX `reportActivityTypeId`(`reportActivityTypeId` ASC) USING BTREE,
  INDEX `reportDirectiveDocId`(`reportDirectiveDocId` ASC) USING BTREE,
  INDEX `reportUtilizationTypeId`(`reportUtilizationTypeId` ASC) USING BTREE,
  INDEX `reportDevelopmentTypeId`(`reportDevelopmentTypeId` ASC) USING BTREE,
  CONSTRAINT `hrss_report_ibfk_1` FOREIGN KEY (`reportActivityTypeId`) REFERENCES `hrss_activity_type` (`activityTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hrss_report_ibfk_2` FOREIGN KEY (`reportDirectiveDocId`) REFERENCES `hrss_directive_doc` (`directiveDocId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hrss_report_ibfk_3` FOREIGN KEY (`reportUtilizationTypeId`) REFERENCES `hrss_utilization_type` (`utilizationTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hrss_report_ibfk_4` FOREIGN KEY (`reportDevelopmentTypeId`) REFERENCES `hrss_development_type` (`develTypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_report_green
-- ----------------------------
DROP TABLE IF EXISTS `hrss_report_green`;
CREATE TABLE `hrss_report_green`  (
  `reportGreenId` int NOT NULL AUTO_INCREMENT,
  `reportGreenReportId` int NULL DEFAULT NULL,
  `reportGreenOfficeId` int NULL DEFAULT NULL,
  `reportGreenCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reportGreenUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`reportGreenId`) USING BTREE,
  INDEX `reportGreenReportId`(`reportGreenReportId` ASC) USING BTREE,
  INDEX `reportGreenOfficeId`(`reportGreenOfficeId` ASC) USING BTREE,
  CONSTRAINT `hrss_report_green_ibfk_1` FOREIGN KEY (`reportGreenReportId`) REFERENCES `hrss_report` (`reportId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hrss_report_green_ibfk_2` FOREIGN KEY (`reportGreenOfficeId`) REFERENCES `hrss_green_office` (`greenOfficeActId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_report_knowledge
-- ----------------------------
DROP TABLE IF EXISTS `hrss_report_knowledge`;
CREATE TABLE `hrss_report_knowledge`  (
  `reportKnwId` int NOT NULL AUTO_INCREMENT,
  `reportKnwReportId` int NULL DEFAULT NULL,
  `reportKnwKnowledgeTypeId` int NULL DEFAULT NULL,
  `reportKnwCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reportKnwUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`reportKnwId`) USING BTREE,
  INDEX `reportKnwReportId`(`reportKnwReportId` ASC) USING BTREE,
  INDEX `reportKnwKnowledgeTypeId`(`reportKnwKnowledgeTypeId` ASC) USING BTREE,
  CONSTRAINT `hrss_report_knowledge_ibfk_1` FOREIGN KEY (`reportKnwReportId`) REFERENCES `hrss_report` (`reportId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hrss_report_knowledge_ibfk_2` FOREIGN KEY (`reportKnwKnowledgeTypeId`) REFERENCES `hrss_knowledge_type` (`knowledgeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for hrss_utilization_type
-- ----------------------------
DROP TABLE IF EXISTS `hrss_utilization_type`;
CREATE TABLE `hrss_utilization_type`  (
  `utilizationTypeId` int NOT NULL AUTO_INCREMENT,
  `utilizationTypeName` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `utilizationTypeOptionOther` int NULL DEFAULT NULL,
  `utilizationTypeCreateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `utilizationTypeUpdateAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`utilizationTypeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
