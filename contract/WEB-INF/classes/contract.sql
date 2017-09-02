/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : contract

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-08-11 22:02:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_contract_sjzd_flowsettype`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_flowsettype`;
CREATE TABLE `t_contract_sjzd_flowsettype` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程类型';

-- ----------------------------
-- Records of t_contract_sjzd_flowsettype
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_sjzd_lclx`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_lclx`;
CREATE TABLE `t_contract_sjzd_lclx` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程类型2';

-- ----------------------------
-- Records of t_contract_sjzd_lclx
-- ----------------------------
INSERT INTO `t_contract_sjzd_lclx` VALUES ('1', '01', '请假流程类型', '1', '1');

-- ----------------------------
-- Table structure for `t_contract_sjzd_qjlx`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_qjlx`;
CREATE TABLE `t_contract_sjzd_qjlx` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='请假类型';

-- ----------------------------
-- Records of t_contract_sjzd_qjlx
-- ----------------------------
INSERT INTO `t_contract_sjzd_qjlx` VALUES ('a9652f37-8fe3-4241-a822-9f8f3b2634a6', '01', '请假1', '1', '1');
INSERT INTO `t_contract_sjzd_qjlx` VALUES ('d0f4abd1-d1f5-4633-a247-c0ba2d0dacf0', '02', '请假2', '1', '2');
INSERT INTO `t_contract_sjzd_qjlx` VALUES ('f8781374-f017-4d7a-82b8-9ee93b7f6aaa', '03', '请假3', '1', '3');

-- ----------------------------
-- Table structure for `t_contract_sjzd_shtype`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_shtype`;
CREATE TABLE `t_contract_sjzd_shtype` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='审核类型';

-- ----------------------------
-- Records of t_contract_sjzd_shtype
-- ----------------------------
INSERT INTO `t_contract_sjzd_shtype` VALUES ('1', '01', '小组审核', '1', '1');
INSERT INTO `t_contract_sjzd_shtype` VALUES ('2', '02', '部门审核', '1', '2');

-- ----------------------------
-- Table structure for `t_contract_sjzd_shzt`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_shzt`;
CREATE TABLE `t_contract_sjzd_shzt` (
  `WID` varchar(40) NOT NULL DEFAULT '',
  `BM` varchar(4) DEFAULT NULL,
  `NAME` varchar(40) DEFAULT NULL,
  `PX` int(3) DEFAULT NULL,
  `sfsy` int(3) DEFAULT NULL,
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_contract_sjzd_shzt
-- ----------------------------
INSERT INTO `t_contract_sjzd_shzt` VALUES ('01', '01', '草稿', '1', '1');
INSERT INTO `t_contract_sjzd_shzt` VALUES ('02', '02', '待审核', '2', '1');
INSERT INTO `t_contract_sjzd_shzt` VALUES ('03', '03', '进行中', '3', '1');
INSERT INTO `t_contract_sjzd_shzt` VALUES ('04', '04', '已完成', '4', '1');
INSERT INTO `t_contract_sjzd_shzt` VALUES ('99', '-99', '审核不通过', '5', '1');

-- ----------------------------
-- Table structure for `t_contract_sjzd_zwlb`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_zwlb`;
CREATE TABLE `t_contract_sjzd_zwlb` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职务类别';

-- ----------------------------
-- Records of t_contract_sjzd_zwlb
-- ----------------------------
INSERT INTO `t_contract_sjzd_zwlb` VALUES ('9770b731-7f6f-4c51-b331-697b2c52a2af', '112', '12123', '1', '1');
INSERT INTO `t_contract_sjzd_zwlb` VALUES ('b4ae101d-5b0c-4726-a35c-a04d25d0d610', '12', '12', '2', '12');
INSERT INTO `t_contract_sjzd_zwlb` VALUES ('e0f09c26-ee78-4ed6-9db4-69c51a9a1473', '1', '23', '2', '1234');

-- ----------------------------
-- Table structure for `t_contract_sys_depart`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sys_depart`;
CREATE TABLE `t_contract_sys_depart` (
  `WID` varchar(40) NOT NULL DEFAULT '' COMMENT 'WID',
  `BM` varchar(40) DEFAULT NULL COMMENT '编码',
  `NAME` varchar(40) DEFAULT NULL COMMENT '名称',
  `PID` varchar(40) DEFAULT NULL COMMENT '父节点',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CreateBy` varchar(40) DEFAULT NULL COMMENT '创建人',
  `UpdateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UpdateBy` varchar(40) DEFAULT NULL COMMENT '更新人',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  `TYPE` int(11) DEFAULT NULL COMMENT '类型（0、根节点、1部门、2小组）',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息';

-- ----------------------------
-- Records of t_contract_sys_depart
-- ----------------------------
INSERT INTO `t_contract_sys_depart` VALUES ('-1', '-1', '部门管理', null, '1', '2017-07-30 15:23:04', null, '2017-07-30 15:23:12', null, null, '0');
INSERT INTO `t_contract_sys_depart` VALUES ('c71bde0a-5b69-47c6-bd17-be1ed84efe3c', '002', '二级部门', 'fa60a449-bc45-482f-8ff5-bf2429adeb0d', '1', '2017-07-30 15:26:47', '1', '2017-07-30 15:26:47', '1', null, '1');
INSERT INTO `t_contract_sys_depart` VALUES ('e3aaa2b0-4431-4e72-a0dd-5d38c6d17a46', '004', '我的小组', 'c71bde0a-5b69-47c6-bd17-be1ed84efe3c', '1', '2017-07-30 15:27:06', '1', '2017-07-30 15:27:06', '1', null, '2');
INSERT INTO `t_contract_sys_depart` VALUES ('fa60a449-bc45-482f-8ff5-bf2429adeb0d', '001', '一级部门', '-1', '1', '2017-07-30 15:26:25', '1', '2017-07-30 15:26:25', '1', null, '1');

-- ----------------------------
-- Table structure for `t_contract_sys_flowset`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sys_flowset`;
CREATE TABLE `t_contract_sys_flowset` (
  `WID` varchar(40) NOT NULL,
  `TYPE` varchar(40) DEFAULT NULL,
  `PX` int(8) DEFAULT NULL,
  `NAME` varchar(40) DEFAULT NULL,
  `SHTYPE` varchar(4) DEFAULT NULL COMMENT '审核类型',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_contract_sys_flowset
-- ----------------------------
INSERT INTO `t_contract_sys_flowset` VALUES ('', null, '12', 'ea4688af-aef8-4b61-8a28-b26e12b80820', '01');
INSERT INTO `t_contract_sys_flowset` VALUES ('299fe3a7-b923-40de-b581-2ae548666729', '01', '3', 'bfda7210-9495-4cc3-a3cf-bea248a47188', '02');
INSERT INTO `t_contract_sys_flowset` VALUES ('559cc82c-3adc-4c6b-b65a-edd19b930bb0', '01', '1', 'ea4688af-aef8-4b61-8a28-b26e12b80820', '01');
INSERT INTO `t_contract_sys_flowset` VALUES ('935ffdd4-8154-4dfa-ab27-1e8ffebcde48', '01', '2', '85e4f219-bf38-46b0-88f6-71270396478e', '02');

-- ----------------------------
-- Table structure for `t_contract_sys_flowset_data`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sys_flowset_data`;
CREATE TABLE `t_contract_sys_flowset_data` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `TYPE` varchar(4) DEFAULT NULL COMMENT '流程类型',
  `DATA_ID` varchar(40) DEFAULT NULL COMMENT '数据标识',
  `CURRENT_STEP` int(11) DEFAULT NULL COMMENT '当前步骤',
  `CURRENT_STATE` varchar(4) DEFAULT NULL COMMENT '当前状态',
  `CJSJ` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `SHID` varchar(40) DEFAULT NULL COMMENT '审核人ID',
  `CONTENT` varchar(400) DEFAULT NULL COMMENT '审核原因',
  `ROLEID` varchar(40) DEFAULT NULL COMMENT '审核角色',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程数据';

-- ----------------------------
-- Records of t_contract_sys_flowset_data
-- ----------------------------
INSERT INTO `t_contract_sys_flowset_data` VALUES ('01ba3f3f-d952-46ce-a8eb-18059ded8814', '01', '77d9c1da-003f-4872-9ad2-e3ee7d9ca819', '3', '03', '2017-07-30 20:46:15', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('165c171c-033e-494f-9dbf-a318431aa33d', '01', '77d9c1da-003f-4872-9ad2-e3ee7d9ca819', '-1', '04', '2017-07-30 20:47:18', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('1ae0d6d1-62f2-4c82-8b20-8c0d44ac41c9', '01', 'cebc89c1-833f-4a63-9006-51429351fc3b', '2', '03', '2017-07-30 20:42:17', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('6033088b-861b-4ea8-b565-6044143d6ec4', '01', '058301cc-832d-4531-b803-d11e4b44cc81', '1', '02', '2017-07-30 20:32:22', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('6f4f33ca-65f5-4e15-bb94-8cdd865bc2e4', '01', 'bbdf4474-7b44-47e0-858d-580c4460c696', '2', '02', '2017-07-30 20:05:56', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('=-57878[p mm,ol.', '01', '996af688-3943-436e-a7c1-8fd793e1e807', null, '02', '2017-07-30 13:41:47', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('a7b33121-52f3-4891-a847-7d41429b41f5', '01', 'bbdf4474-7b44-47e0-858d-580c4460c696', '1', '02', '2017-07-30 17:50:10', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('a9c86680-2f8d-4d7b-b9d7-1c74abe75692', '01', '058301cc-832d-4531-b803-d11e4b44cc81', '2', '03', '2017-07-30 20:32:41', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('ba176b53-4ca2-4a11-b997-10a1ff2ee0cc', '01', 'bbdf4474-7b44-47e0-858d-580c4460c696', '3', '02', '2017-07-30 20:06:47', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('e63c47d1-9ee9-47a2-b8df-52a7e7b1eb80', '01', '77d9c1da-003f-4872-9ad2-e3ee7d9ca819', '2', '03', '2017-07-30 20:45:46', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('ef440af4-722f-48ad-aab9-14390da8989a', '01', '77d9c1da-003f-4872-9ad2-e3ee7d9ca819', '1', '02', '2017-07-30 20:45:33', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('fd6bb50b-e659-47e9-9283-e92d067f23a7', '01', 'cebc89c1-833f-4a63-9006-51429351fc3b', '1', '02', '2017-07-30 20:40:38', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('ff5177c4-7c46-44b3-8106-decaee832d5a', '01', '953d3477-548d-468c-bdf7-f0692088fb3e', null, '02', '2017-07-15 13:05:15', '1', '提交审核', null);

-- ----------------------------
-- Table structure for `t_contract_sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sys_permission`;
CREATE TABLE `t_contract_sys_permission` (
  `WID` varchar(40) NOT NULL DEFAULT '' COMMENT 'WID',
  `NAME` varchar(40) DEFAULT NULL COMMENT '权限名称',
  `DESCRIPTION` varchar(100) DEFAULT NULL COMMENT '权限描述',
  `PID` varchar(40) DEFAULT NULL COMMENT '父标志',
  `LEVEL` int(11) DEFAULT NULL COMMENT '层次',
  `CODE` varchar(100) DEFAULT NULL COMMENT '编码',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CreateBy` varchar(40) DEFAULT NULL COMMENT '创建人',
  `UpdateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UpdateBy` varchar(40) DEFAULT NULL COMMENT '更新人',
  `URL` varchar(100) DEFAULT NULL,
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_contract_sys_permission
-- ----------------------------
INSERT INTO `t_contract_sys_permission` VALUES ('0', '权限与菜单 ', '权限与菜单管理', '-1', '1', null, '1', '2017-05-28 14:01:47', null, '2017-05-28 11:38:50', null, null, '1');
INSERT INTO `t_contract_sys_permission` VALUES ('1', '系统管理', '系统管理', '0', '2', '', '1', '2017-06-04 18:23:54', null, '2017-05-27 23:02:25', null, '', '900');
INSERT INTO `t_contract_sys_permission` VALUES ('10', '删除角色', '删除角色', '3', '4', 'role:delete', '1', '2017-06-04 18:27:15', null, '2017-05-28 23:58:23', null, '/roles/delete', '944');
INSERT INTO `t_contract_sys_permission` VALUES ('11', '新增角色', '新增角色', '3', '4', 'role:insert', '1', '2017-06-04 18:27:12', null, '2017-05-28 23:59:41', null, '/roles/insert', '943');
INSERT INTO `t_contract_sys_permission` VALUES ('12', '修改角色权限关系', '修改角色权限关系', '3', '4', 'permission:updateRolePerms', '1', '2017-06-04 18:27:20', null, '2017-05-29 19:32:22', null, '/permissions/updateRolePerms', '945');
INSERT INTO `t_contract_sys_permission` VALUES ('13', '部门管理', '部门管理', '1', '3', 'department:list', '1', '2017-06-04 18:25:34', null, '2017-06-02 13:25:49', null, '/departments/index,/departments/list', '910');
INSERT INTO `t_contract_sys_permission` VALUES ('131', '审核', '审核', '22', '4', 'userleaveexamine:examine', '1', '2017-07-30 15:06:44', null, '2017-07-30 15:05:40', null, '/userleavesexamine/examine', '131');
INSERT INTO `t_contract_sys_permission` VALUES ('14', '字典表管理', '字典表管理', '1', '3', 'zdb:list', '1', '2017-06-04 18:25:43', null, '2017-06-02 23:58:59', null, '/zdbs/index,/zdbs/list', '920');
INSERT INTO `t_contract_sys_permission` VALUES ('15', '字典表详情', '字典表详情', '1', '3', 'zdbdetail:list', '1', '2017-06-04 18:26:17', null, '2017-06-03 16:45:51', null, '/zdbdetail/index,/zdbdetail/list', '930');
INSERT INTO `t_contract_sys_permission` VALUES ('16', '用户管理', '用户管理', '0', '2', null, '1', '2017-06-04 18:24:06', null, '2017-06-04 17:57:18', null, null, '100');
INSERT INTO `t_contract_sys_permission` VALUES ('17', '请假信息', '请假信息', '16', '3', 'userleaveinfo:list', '1', '2017-06-04 19:58:31', null, '2017-06-04 19:58:38', null, '/userleaves/index,/userleaves/list', '120');
INSERT INTO `t_contract_sys_permission` VALUES ('18', '新建', '新建', '17', '4', 'userleaveinfo:insert', '1', '2017-06-04 20:06:22', null, '2017-06-04 20:05:46', null, '/userleaves/insert', '121');
INSERT INTO `t_contract_sys_permission` VALUES ('19', '修改', '修改', '17', '4', 'userleaveinfo:update', '1', '2017-06-04 20:07:48', null, '2017-06-04 20:07:31', null, '/userleaves/update', '122');
INSERT INTO `t_contract_sys_permission` VALUES ('2', '基本信息', '基本信息', '16', '3', 'userinfo:list', '1', '2017-06-04 18:24:58', null, '2017-05-28 11:40:26', null, '/users/index,/users/list', '110');
INSERT INTO `t_contract_sys_permission` VALUES ('20', '删除', '删除', '17', '4', 'userleaveinfo:delete', '1', '2017-06-04 20:08:44', null, '2017-06-04 20:08:26', null, '/userleaves/delete', '123');
INSERT INTO `t_contract_sys_permission` VALUES ('21', '查看', '查看', '17', '4', 'userleaveinfo:select', '1', '2017-06-04 20:09:28', null, '2017-06-04 20:09:12', null, '/userleaves/select', '124');
INSERT INTO `t_contract_sys_permission` VALUES ('22', '请假审核', '请假审核', '16', '3', 'userleaveexamine:list', '1', '2017-06-18 17:27:50', null, '2017-06-18 17:19:07', null, '/userleavesexamine/index,/userleavesexamine/list', '130');
INSERT INTO `t_contract_sys_permission` VALUES ('23', '流程设置', '流程设置', '1', '3', 'flowset:list', '1', '2017-06-18 21:42:32', null, '2017-06-18 21:35:31', null, '/flowset/index,/flowset/list', '950');
INSERT INTO `t_contract_sys_permission` VALUES ('3', '权限管理', '权限管理', '1', '3', 'permission:list', '1', '2017-06-04 18:26:58', null, '2017-05-28 14:10:41', null, '/permissions/index,/roles/list,permissions/permission', '940');
INSERT INTO `t_contract_sys_permission` VALUES ('4', '查看用户', '查看用户', '2', '4', 'userinfo:select', '1', '2017-06-04 18:25:03', null, '2017-05-28 15:29:15', null, '/users/query', '111');
INSERT INTO `t_contract_sys_permission` VALUES ('5', '修改用户', '修改用户', '2', '4', 'userinfo:update', '1', '2017-06-04 18:25:06', null, '2017-05-28 15:30:14', null, '/users/update', '112');
INSERT INTO `t_contract_sys_permission` VALUES ('6', '删除用户', '删除用户', '2', '4', 'userinfo:delete', '1', '2017-06-04 18:25:08', null, '2017-05-28 15:31:14', null, '/users/delete', '113');
INSERT INTO `t_contract_sys_permission` VALUES ('7', '新增用户', '新增用户', '2', '4', 'userinfo:insert', '1', '2017-06-04 18:25:11', null, '2017-05-28 15:38:55', null, '/users/insert', '114');
INSERT INTO `t_contract_sys_permission` VALUES ('8', '查看权限', '查看权限', '3', '4', 'role:select', '1', '2017-06-04 18:27:03', null, '2017-05-28 23:56:33', null, '/roles/select', '941');
INSERT INTO `t_contract_sys_permission` VALUES ('9', '修改角色', '修改角色', '3', '4', 'role:update', '1', '2017-06-04 18:27:07', null, '2017-05-28 23:57:40', null, '/roles/update', '942');

-- ----------------------------
-- Table structure for `t_contract_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sys_role`;
CREATE TABLE `t_contract_sys_role` (
  `WID` varchar(40) NOT NULL DEFAULT '' COMMENT 'WID',
  `NAME` varchar(40) DEFAULT NULL COMMENT '角色名称',
  `DESCRIPTION` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `isFinal` int(11) DEFAULT NULL COMMENT '是否可删除',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CreateBy` varchar(40) DEFAULT NULL COMMENT '创建人',
  `UpdateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UpdateBy` varchar(40) DEFAULT NULL COMMENT '更新人',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_contract_sys_role
-- ----------------------------
INSERT INTO `t_contract_sys_role` VALUES ('1', '系统管理员', '系统管理员', '1', '1', '2017-06-14 22:07:11', null, '2017-05-29 22:35:04', '1', '1');
INSERT INTO `t_contract_sys_role` VALUES ('25d15308-84d5-4e6f-bbfb-c874b187f75d', null, null, null, '2', '2017-06-14 22:07:12', '1', '2017-05-29 22:18:23', '1', '2');
INSERT INTO `t_contract_sys_role` VALUES ('45bf4404-864f-420f-ba47-b16141f92a74', '123123', '1234', null, '2', '2017-06-14 22:07:13', '1', '2017-05-29 22:19:14', '1', '3');
INSERT INTO `t_contract_sys_role` VALUES ('7cd0c781-9201-4856-9f1d-077bf79aa256', null, null, null, '2', '2017-06-14 22:07:14', '1', '2017-05-29 22:18:34', '1', '4');
INSERT INTO `t_contract_sys_role` VALUES ('85e4f219-bf38-46b0-88f6-71270396478e', '二级部门管理员', '二级部门管理员', null, '1', '2017-06-14 22:07:15', '1', '2017-06-14 20:32:19', '1', '5');
INSERT INTO `t_contract_sys_role` VALUES ('9bab929d-2582-4fa7-9569-c0b26afa0689', null, null, null, '2', '2017-06-14 22:07:15', '1', '2017-05-29 22:18:38', '1', '6');
INSERT INTO `t_contract_sys_role` VALUES ('bfda7210-9495-4cc3-a3cf-bea248a47188', '一级部门管理员', '一级部门管理员', null, '1', '2017-06-14 22:07:18', '1', '2017-06-14 20:32:06', '1', '7');
INSERT INTO `t_contract_sys_role` VALUES ('ea4688af-aef8-4b61-8a28-b26e12b80820', '小组管理员', '小组管理员', null, '1', '2017-06-25 20:53:33', '1', '2017-06-25 20:53:33', '1', null);

-- ----------------------------
-- Table structure for `t_contract_sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sys_role_permission`;
CREATE TABLE `t_contract_sys_role_permission` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `PERMISSIONID` varchar(40) DEFAULT NULL COMMENT '权限ID',
  `RoleId` varchar(40) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限对应关系表';

-- ----------------------------
-- Records of t_contract_sys_role_permission
-- ----------------------------
INSERT INTO `t_contract_sys_role_permission` VALUES ('0b6fddab-0dbe-4d33-88e3-8aa6d7b0b8ac', '11', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('0c8cef3e-fad3-4062-ae1b-e502698ec8c2', '23', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('1e174389-ea03-4e58-b0ef-e0e3cec783a8', '16', '85e4f219-bf38-46b0-88f6-71270396478e');
INSERT INTO `t_contract_sys_role_permission` VALUES ('221ea48b-3bb1-4a9d-adb9-f120c4811a8f', '7', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('238377fd-d53c-4189-8a38-1d290f7a8e62', '10', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('3799fa65-8801-4c86-9f17-c4330f70ad71', '0', '85e4f219-bf38-46b0-88f6-71270396478e');
INSERT INTO `t_contract_sys_role_permission` VALUES ('383fd2a5-f8db-44b7-98b8-c47c0bdd8b14', '22', '85e4f219-bf38-46b0-88f6-71270396478e');
INSERT INTO `t_contract_sys_role_permission` VALUES ('42439521-ddd8-44ed-9099-bf9aadfb0e56', '16', 'bfda7210-9495-4cc3-a3cf-bea248a47188');
INSERT INTO `t_contract_sys_role_permission` VALUES ('49e94454-520f-4586-af16-bc6066bc6275', '16', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('5055c2e7-14ae-45ef-bdc2-3d2de371e273', '9', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('51aad7ae-53db-409e-889c-e330f0c8b8dd', '13', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('55091d2e-6781-42fc-b084-0cf0380578a8', '15', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('5f027562-2c71-40d7-8df5-f9e8e484b217', '4', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('6839e0c4-f2ca-47cf-b20b-c4d263ea75f2', '1', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('6b59be0c-c0da-48b7-9e17-f0edd87e6249', '0', 'ea4688af-aef8-4b61-8a28-b26e12b80820');
INSERT INTO `t_contract_sys_role_permission` VALUES ('70247a74-d486-4dda-a125-36be553129af', '12', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('71b652d3-cb8f-451e-a149-18a1d996c6f4', '19', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('7644b9e1-f0bf-469c-a7a4-79555e13546a', '21', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('7fd9512d-330e-4cdb-a526-9b77e2d84234', '8', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('9ae87129-fc9d-4d69-9f14-3db47c5b3b71', '0', 'bfda7210-9495-4cc3-a3cf-bea248a47188');
INSERT INTO `t_contract_sys_role_permission` VALUES ('9d776052-f66c-4818-9a1a-1e8766fa2652', '17', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('afd288be-fa86-4ce1-b55c-9a029bef669a', '131', 'bfda7210-9495-4cc3-a3cf-bea248a47188');
INSERT INTO `t_contract_sys_role_permission` VALUES ('b0a6cd98-e12a-438c-94f9-5cb6451c1a74', '22', 'bfda7210-9495-4cc3-a3cf-bea248a47188');
INSERT INTO `t_contract_sys_role_permission` VALUES ('ca76bc1b-696b-42d9-a568-50f9dd3d815f', '14', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('cbf5d5af-8d61-4218-8dfe-6aba72c7de29', '18', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('cc184326-06b5-4aa9-b5e0-a9138d5e9556', '3', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('cc18c289-71c6-4890-b374-d814d1f86812', '22', 'ea4688af-aef8-4b61-8a28-b26e12b80820');
INSERT INTO `t_contract_sys_role_permission` VALUES ('ce779c82-79db-4049-9c89-4961f3438c08', '5', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('d44a4aaf-7b1b-45c3-a5e3-282f48f20f57', '0', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('dc52b170-4ab0-4d10-93b3-51fda306c077', '16', 'ea4688af-aef8-4b61-8a28-b26e12b80820');
INSERT INTO `t_contract_sys_role_permission` VALUES ('eb4139a5-d871-4c62-b87e-c05ca6b1fc17', '2', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('efdc4ea6-e8be-4d96-882b-a17a835ba861', '131', 'ea4688af-aef8-4b61-8a28-b26e12b80820');
INSERT INTO `t_contract_sys_role_permission` VALUES ('f80e2f29-1d17-4e0a-a175-20bc7f6a8b4a', '20', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('f8ba158d-15ba-4aba-a021-3adfd395773b', '6', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('fa97f90e-76d0-4e86-b491-915a02f8e82e', '131', '85e4f219-bf38-46b0-88f6-71270396478e');

-- ----------------------------
-- Table structure for `t_contract_sys_zdbs`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sys_zdbs`;
CREATE TABLE `t_contract_sys_zdbs` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `CODE` varchar(40) DEFAULT NULL COMMENT '代码',
  `NAME` varchar(40) DEFAULT NULL COMMENT '名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CreateBy` varchar(40) DEFAULT NULL COMMENT '创建人',
  `UpdateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UpdateBy` varchar(40) DEFAULT NULL COMMENT '更新人',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表管理';

-- ----------------------------
-- Records of t_contract_sys_zdbs
-- ----------------------------
INSERT INTO `t_contract_sys_zdbs` VALUES ('009404f1-5eff-4dd2-b4e9-2d3ae99bd9ac', 'T_CONTRACT_SJZD_ZWLB', '职位类别', '1', '2017-06-03 15:43:46', '1', '2017-06-03 15:43:46', '1', '1');
INSERT INTO `t_contract_sys_zdbs` VALUES ('12150c72-bbf5-46a5-8361-4278fa45dcb4', '12', '12', '2', '2017-06-03 16:37:34', '1', '2017-06-03 16:37:35', '1', '1');
INSERT INTO `t_contract_sys_zdbs` VALUES ('b27da1ea-1c3b-44b1-a114-79e6de342aff', '12', '3', '2', '2017-06-03 16:35:37', '1', '2017-06-03 16:35:38', '1', '1');
INSERT INTO `t_contract_sys_zdbs` VALUES ('c8dcf178-1dff-492d-bab0-34ad83622627', 'T_CONTRACT_SJZD_QJLX', '请假类型', '1', '2017-06-04 18:38:37', '1', '2017-06-04 18:38:37', '1', '2');
INSERT INTO `t_contract_sys_zdbs` VALUES ('d29a1cd0-5735-4d89-83d3-7582573ef864', '12', '123', '2', '2017-06-03 16:00:24', '1', '2017-06-03 16:00:25', '1', '2345');

-- ----------------------------
-- Table structure for `t_contract_user_leaveinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_user_leaveinfo`;
CREATE TABLE `t_contract_user_leaveinfo` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `TYPE` varchar(10) DEFAULT NULL COMMENT '请假类型',
  `NAME` varchar(100) DEFAULT NULL COMMENT '请假名称',
  `YHID` varchar(40) DEFAULT NULL COMMENT '请假人员',
  `STARTTIME` varchar(20) DEFAULT NULL COMMENT '请假开始时间',
  `ENDTIME` varchar(20) DEFAULT NULL COMMENT '请假结束时间',
  `TIME` double DEFAULT NULL COMMENT '请假时长',
  `AUDITORS` varchar(40) DEFAULT NULL COMMENT '审核人员',
  `TaskStatus` varchar(4) DEFAULT NULL COMMENT '任务状态',
  `CONTENT` varchar(400) DEFAULT NULL COMMENT '备注',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CreateBy` varchar(40) DEFAULT NULL COMMENT '创建人',
  `UpdateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UpdateBy` varchar(40) DEFAULT NULL COMMENT '更新人',
  `CurrentStep` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户请假信息';

-- ----------------------------
-- Records of t_contract_user_leaveinfo
-- ----------------------------
INSERT INTO `t_contract_user_leaveinfo` VALUES ('77d9c1da-003f-4872-9ad2-e3ee7d9ca819', '02', '123', '1', '2017-07-30 20:45', '2017-08-03 20:45', '32', null, '04', '12345', '1', '2017-07-30 20:45:33', '1', '2017-07-30 20:45:33', '1', '-1');

-- ----------------------------
-- Table structure for `t_contract_user_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_user_userinfo`;
CREATE TABLE `t_contract_user_userinfo` (
  `WID` varchar(40) NOT NULL DEFAULT '' COMMENT 'WID',
  `NAME` varchar(40) DEFAULT NULL COMMENT '人员名称',
  `PASSWORD` varchar(100) DEFAULT NULL COMMENT '密码',
  `GH` varchar(40) DEFAULT NULL COMMENT '员工号',
  `PHONE` varchar(20) DEFAULT NULL COMMENT '手机号',
  `EMAIL` varchar(30) DEFAULT NULL COMMENT '邮箱地址',
  `BIRTHDAY` varchar(10) DEFAULT NULL COMMENT '出生年月',
  `DEPARTMENT` varchar(100) DEFAULT NULL COMMENT '部门信息',
  `TEAM` varchar(100) DEFAULT NULL COMMENT '科室或小组信息',
  `DEGREE` varchar(20) DEFAULT NULL COMMENT '学位',
  `JOBCATEGORY` varchar(40) DEFAULT NULL COMMENT '职位类别',
  `JOB` varchar(100) DEFAULT NULL COMMENT '职位',
  `CONTRACTVALIDITY` varchar(20) DEFAULT NULL COMMENT '合同有效期',
  `CONTRACTTIME` varchar(20) DEFAULT NULL COMMENT '合同签订时间',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `CreateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `CreateBy` varchar(40) DEFAULT NULL COMMENT '创建人',
  `UpdateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UpdateBy` varchar(40) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员基本信息';

-- ----------------------------
-- Records of t_contract_user_userinfo
-- ----------------------------
INSERT INTO `t_contract_user_userinfo` VALUES ('1', '1234', 'c4ca4238a0b923820dcc509a6f75849b', '12345', '17705181062', '12345@qq.com', '12345', '002', '004', '234', '1234', '234', '23', '2017-07-30', '1', '2017-05-27 17:11:13', null, '2017-07-31 09:36:31', '1');
INSERT INTO `t_contract_user_userinfo` VALUES ('66f3eb6b-55a6-4da1-9ba0-0d160b44deac', '17705181062', 'e10adc3949ba59abbe56e057f20f883e', '17705181062', '17705181062', '17705181062@qq.com', '2017-06-14', '123455', '我的小组', '1234', '123', '123', '12,2017-06-14', null, '1', '2017-06-14 21:44:02', '1', '2017-06-14 21:44:01', '1');

-- ----------------------------
-- Table structure for `t_contract_user_userinfo_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_user_userinfo_role`;
CREATE TABLE `t_contract_user_userinfo_role` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `UserId` varchar(40) DEFAULT NULL COMMENT '用户ID',
  `RoleId` varchar(40) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色对应关系表';

-- ----------------------------
-- Records of t_contract_user_userinfo_role
-- ----------------------------
INSERT INTO `t_contract_user_userinfo_role` VALUES ('0459caa5-60e1-40ec-a7da-045a3373d6f9', '1', '1');
INSERT INTO `t_contract_user_userinfo_role` VALUES ('5d40bd13-888c-4003-a3c3-79eccb1ad395', '1', 'ea4688af-aef8-4b61-8a28-b26e12b80820');
INSERT INTO `t_contract_user_userinfo_role` VALUES ('616d3582-db85-48e7-90fa-a31577071777', '1', '85e4f219-bf38-46b0-88f6-71270396478e');
INSERT INTO `t_contract_user_userinfo_role` VALUES ('e7ed5a5e-cb16-485c-bdf8-2ca491b55799', '1', 'bfda7210-9495-4cc3-a3cf-bea248a47188');
