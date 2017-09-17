/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : contract

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-09-10 20:32:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_contract_contract_add`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_contract_add`;
CREATE TABLE `t_contract_contract_add` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `HTID` varchar(40) DEFAULT NULL COMMENT '合同ID',
  `PCID` varchar(40) DEFAULT NULL COMMENT '批次ID',
  `FXXM` varchar(40) DEFAULT NULL COMMENT '分析项目',
  `CREATE_TIME` varchar(40) DEFAULT NULL COMMENT '创建时间',
  `CREATE_MAN` varchar(40) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='已添加分析项';

-- ----------------------------
-- Records of t_contract_contract_add
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_contract_batch_rel`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_contract_batch_rel`;
CREATE TABLE `t_contract_contract_batch_rel` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `HTID` varchar(40) DEFAULT NULL COMMENT '合同WID',
  `PCID` varchar(40) DEFAULT NULL COMMENT '批次WID',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同批次关系表';

-- ----------------------------
-- Records of t_contract_contract_batch_rel
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_contract_fxxm`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_contract_fxxm`;
CREATE TABLE `t_contract_contract_fxxm` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `HTID` varchar(40) DEFAULT NULL COMMENT '合同WID',
  `FXXM_BH` varchar(40) DEFAULT NULL COMMENT '分析项目编号',
  `FXXM` varchar(100) DEFAULT NULL COMMENT '分析项目名称',
  `DJ` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `SL` int(11) DEFAULT NULL COMMENT '数量',
  `ZK` decimal(10,2) DEFAULT NULL COMMENT '折扣',
  `ZJ` decimal(10,2) DEFAULT NULL COMMENT '总价',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同分析项';

-- ----------------------------
-- Records of t_contract_contract_fxxm
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_contract_main`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_contract_main`;
CREATE TABLE `t_contract_contract_main` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `HTLX` varchar(4) DEFAULT NULL COMMENT '合同类型',
  `HTMC` varchar(100) DEFAULT NULL COMMENT '合同名称',
  `HTBH` varchar(40) DEFAULT NULL COMMENT '合同编号',
  `HTJF` varchar(40) DEFAULT NULL COMMENT '合同甲方',
  `XMFZR` varchar(40) DEFAULT NULL COMMENT '项目负责人',
  `HTJE` decimal(10,2) DEFAULT NULL COMMENT '合同金额',
  `HTZK` decimal(10,2) DEFAULT NULL COMMENT '合同折扣',
  `ZZJE` decimal(10,2) DEFAULT NULL COMMENT '最终金额',
  `HTSJ` varchar(30) DEFAULT NULL COMMENT '合同时间',
  `HTZXSJ` varchar(30) DEFAULT NULL COMMENT '合同执行时间',
  `RWZT` int(11) DEFAULT NULL COMMENT '任务状态',
  `DATASTATUS` varchar(10) DEFAULT NULL COMMENT '数据状态',
  `CurrentStep` int(11) DEFAULT NULL COMMENT '当前步骤',
  `DFZH` varchar(100) DEFAULT NULL COMMENT '对方账号',
  `BY10` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY9` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY8` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY7` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY6` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY5` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY4` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY3` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY1` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY2` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `CREATE_TIME` varchar(40) DEFAULT NULL COMMENT '创建时间',
  `CREATE_MAN` varchar(40) DEFAULT NULL COMMENT '创建人',
  `DQBH` int(11) DEFAULT NULL COMMENT '当前序号',
  `BZ` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同管理信息表';

-- ----------------------------
-- Records of t_contract_contract_main
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_contract_money`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_contract_money`;
CREATE TABLE `t_contract_contract_money` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `HTID` varchar(40) DEFAULT NULL COMMENT '合同ID',
  `FXXM` varchar(40) DEFAULT NULL COMMENT '分析项目',
  `DJ` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `SL` int(11) DEFAULT NULL COMMENT '数量',
  `ZKJG` decimal(10,2) DEFAULT NULL COMMENT '折扣价格',
  `ZJ` decimal(10,2) DEFAULT NULL COMMENT '总价',
  `CREATE_TIME` varchar(40) DEFAULT NULL COMMENT '创建时间',
  `CREATE_MAN` varchar(40) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同价目列表';

-- ----------------------------
-- Records of t_contract_contract_money
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_custom_account`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_custom_account`;
CREATE TABLE `t_contract_custom_account` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `CUSTOM_ID` varchar(40) DEFAULT NULL COMMENT '客户ID',
  `ACCOUNT_NUMBER` varchar(40) DEFAULT NULL COMMENT '账户编号',
  `DQBH` int(11) DEFAULT NULL COMMENT '当前序号',
  `BANK_ACCOUNT` varchar(100) DEFAULT NULL COMMENT '银行账户',
  `ACCOUNT_MONEY` decimal(10,2) DEFAULT NULL COMMENT '账户余额',
  `CREATE_TIME` varchar(40) DEFAULT NULL COMMENT '创建时间',
  `CREATE_MAN` varchar(40) DEFAULT NULL COMMENT '创建人',
  `DATASTATUS` varchar(4) DEFAULT NULL COMMENT '数据有效性',
  `BY10` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY9` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY8` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY7` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY6` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY5` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY4` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY3` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY1` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY2` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  PRIMARY KEY (`WID`),
  UNIQUE KEY `IND_CUSTOM_ACCOUNT_NUMBER` (`ACCOUNT_NUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户账号信息';

-- ----------------------------
-- Records of t_contract_custom_account
-- ----------------------------
INSERT INTO `t_contract_custom_account` VALUES ('195634d9-5155-4103-8234-5719b5cbdf5c', '', '20170800001', '1', '123123', '123123.00', '2017-08-26 11:07:49', '1', '1', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_contract_custom_account` VALUES ('5ee05ffd-a15f-4f5c-8bbc-0020e5f58ce7', '39dcf810-c373-4d35-9992-8595f6203a81', '20170800002', '2', '123123', '123412.00', '2017-08-26 11:14:10', '1', '1', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_contract_custom_account` VALUES ('774d869d-0375-41a9-99e8-fd9acd852f3d', 'f734aa5b-7a85-4488-a6a4-1d7d5c3d962a', '20170800003', '3', '12121', '12338949.24', '2017-08-26 11:15:43', '1', '1', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `t_contract_custom_main`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_custom_main`;
CREATE TABLE `t_contract_custom_main` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `CUSTOM_NAME` varchar(100) DEFAULT NULL COMMENT '客户名称',
  `CUSTOM_NUMBER` varchar(40) DEFAULT NULL COMMENT '客户编号',
  `CUSTOM_TYPE` varchar(4) DEFAULT NULL COMMENT '客户类别',
  `LINK_MAN` varchar(100) DEFAULT NULL COMMENT '客户联系人',
  `CONTRACT_WAY` varchar(30) DEFAULT NULL COMMENT '客户联系方式',
  `COMPANY_NAME` varchar(100) DEFAULT NULL COMMENT '客户公司名称',
  `COMPANY_ADDRESS` varchar(200) DEFAULT NULL COMMENT '客户公司地址',
  `COMPANY_ACCOUNT` varchar(100) DEFAULT NULL COMMENT '客户账户信息',
  `COMPANY_PRE_ACCOUNT` varchar(100) DEFAULT NULL COMMENT '客户预存账号',
  `CREATE_TIME` varchar(40) DEFAULT NULL COMMENT '创建时间',
  `CREATE_MAN` varchar(40) DEFAULT NULL COMMENT '创建人',
  `DATASTATUS` varchar(4) DEFAULT NULL COMMENT '数据有效性',
  `BY10` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY9` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY8` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY7` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY6` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY5` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY4` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY3` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY1` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY2` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `DQBH` int(11) DEFAULT NULL COMMENT '当前序号',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户信息资料';

-- ----------------------------
-- Records of t_contract_custom_main
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_custom_money_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_custom_money_log`;
CREATE TABLE `t_contract_custom_money_log` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `CUSTOM_ID` varchar(40) DEFAULT NULL COMMENT '客户ID',
  `ACCOUNT_NUMBER` varchar(40) DEFAULT NULL COMMENT '账户编号',
  `BANK_ACCOUNT` varchar(100) DEFAULT NULL COMMENT '银行账户',
  `ACCOUNT_MONEY` decimal(10,2) DEFAULT NULL COMMENT '账户余额',
  `BD_MONEY` decimal(10,2) DEFAULT NULL COMMENT '变动金额',
  `CREATE_TIME` varchar(40) DEFAULT NULL COMMENT '创建时间',
  `CREATE_MAN` varchar(40) DEFAULT NULL COMMENT '创建人',
  `CONTRACT_ID` varchar(40) DEFAULT NULL COMMENT '合同ID',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户账号金额变更日志';

-- ----------------------------
-- Records of t_contract_custom_money_log
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_custom_update_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_custom_update_log`;
CREATE TABLE `t_contract_custom_update_log` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `CUSTOM_ID` varchar(40) DEFAULT NULL COMMENT '客户ID',
  `ACCOUNT_NUMBER` varchar(40) DEFAULT NULL COMMENT '账户编号',
  `BANK_ACCOUNT` varchar(100) DEFAULT NULL COMMENT '银行账户',
  `ACCOUNT_MONEY` decimal(10,2) DEFAULT NULL COMMENT '账户余额',
  `CREATE_TIME` varchar(40) DEFAULT NULL COMMENT '创建时间',
  `CREATE_MAN` varchar(40) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TYPE` int(11) DEFAULT NULL COMMENT '修修改类型1增2改3删除',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户账号修改日志';

-- ----------------------------
-- Records of t_contract_custom_update_log
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_pcgl_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_pcgl_detail`;
CREATE TABLE `t_contract_pcgl_detail` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `YPBH` varchar(40) DEFAULT NULL COMMENT '样品编号',
  `YPPH` varchar(100) DEFAULT NULL COMMENT '样品批号',
  `YPYYBH` varchar(40) DEFAULT NULL COMMENT '样品原有编号',
  `YPXZ` varchar(100) DEFAULT NULL COMMENT '样品性质',
  `YPEWM` varchar(100) DEFAULT NULL COMMENT '样品二维码',
  `FXXM` varchar(1000) DEFAULT NULL COMMENT '分析项目',
  `PCWID` varchar(40) DEFAULT NULL COMMENT '批次WID',
  `DQBH` int(11) DEFAULT NULL COMMENT '当前序号',
  PRIMARY KEY (`WID`),
  UNIQUE KEY `IND_PCGL_DETAIL_YPBH` (`YPBH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='批次管理详情';

-- ----------------------------
-- Records of t_contract_pcgl_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_pcgl_detail_fxxm`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_pcgl_detail_fxxm`;
CREATE TABLE `t_contract_pcgl_detail_fxxm` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `FXXMBH` varchar(40) DEFAULT NULL COMMENT '分析项目编号',
  `PWID` varchar(40) DEFAULT NULL COMMENT '样品批次ID',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='样品详情对应的分析项目';

-- ----------------------------
-- Records of t_contract_pcgl_detail_fxxm
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_pcgl_main`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_pcgl_main`;
CREATE TABLE `t_contract_pcgl_main` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `PCLB` varchar(10) DEFAULT NULL COMMENT '批次类别',
  `EJFL` varchar(100) DEFAULT NULL COMMENT '二级分类',
  `PCMC` varchar(100) DEFAULT NULL COMMENT '批次名称',
  `YPPH` varchar(100) DEFAULT '' COMMENT '样品批号',
  `SL` int(11) DEFAULT NULL COMMENT '数量',
  `PP` varchar(10) DEFAULT NULL COMMENT '品牌',
  `SLDW` varchar(20) DEFAULT NULL COMMENT '数量单位',
  `CFD` varchar(100) DEFAULT NULL COMMENT '存放地',
  `GG` varchar(100) DEFAULT NULL COMMENT '规格',
  `KZSJD` varchar(40) DEFAULT NULL COMMENT '控制时间点',
  `GYS` varchar(100) DEFAULT NULL COMMENT '供应商',
  `SYSJ` varchar(40) DEFAULT NULL COMMENT '送样时间',
  `YPSX` varchar(100) DEFAULT NULL COMMENT '样品属性',
  `SYR` varchar(40) DEFAULT NULL COMMENT '送样人',
  `SYXMFZR` varchar(40) DEFAULT NULL COMMENT '送样项目负责人',
  `SYDW` varchar(100) DEFAULT NULL COMMENT '送样单位',
  `FXXM` varchar(1000) DEFAULT NULL COMMENT '分析项目',
  `HTH` varchar(40) DEFAULT NULL COMMENT '合同号',
  `PCZT` varchar(10) DEFAULT NULL COMMENT '批次状态',
  `SHSJ` varchar(40) DEFAULT NULL COMMENT '审核时间',
  `BZ` varchar(400) DEFAULT NULL COMMENT '备注',
  `DJ` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `HBDW` varchar(10) DEFAULT NULL COMMENT '货币单位',
  `DQBH` int(11) DEFAULT NULL COMMENT '当前序号',
  `CREATE_TIME` varchar(40) DEFAULT NULL COMMENT '创建时间',
  `CREATE_MAN` varchar(40) DEFAULT NULL COMMENT '创建人',
  `BY10` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY9` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY8` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY7` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY6` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY5` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY4` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY3` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY1` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY2` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  PRIMARY KEY (`WID`),
  UNIQUE KEY `IND_PCGL_MAIN_YPBH` (`YPPH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='批次管理';

-- ----------------------------
-- Records of t_contract_pcgl_main
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_pcgl_main_fxxm`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_pcgl_main_fxxm`;
CREATE TABLE `t_contract_pcgl_main_fxxm` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `FXXMBH` varchar(40) DEFAULT NULL COMMENT '分析项目编号',
  `PWID` varchar(40) DEFAULT NULL COMMENT '样品批次ID',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='批次对应的分析项目';

-- ----------------------------
-- Records of t_contract_pcgl_main_fxxm
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_pxgl_main`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_pxgl_main`;
CREATE TABLE `t_contract_pxgl_main` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `PXLX` varchar(4) DEFAULT NULL COMMENT '培训类型',
  `PXMC` varchar(40) DEFAULT NULL COMMENT '培训名称',
  `BEGTIME` varchar(40) DEFAULT NULL COMMENT '培训开始时间',
  `ENDTIME` varchar(40) DEFAULT NULL COMMENT '培训结束时间',
  `PXFY` decimal(10,2) DEFAULT NULL COMMENT '培训费用',
  `BZ` varchar(400) DEFAULT NULL COMMENT '备注',
  `BY10` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY9` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY8` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY7` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY6` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY5` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY4` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY3` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY1` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY2` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `CurrentStep` int(11) DEFAULT NULL COMMENT '当前步骤',
  `RWZT` int(11) DEFAULT NULL COMMENT '任务状态',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='培训管理';

-- ----------------------------
-- Records of t_contract_pxgl_main
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_sjzd_custom_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_custom_type`;
CREATE TABLE `t_contract_sjzd_custom_type` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户类别';

-- ----------------------------
-- Records of t_contract_sjzd_custom_type
-- ----------------------------
INSERT INTO `t_contract_sjzd_custom_type` VALUES ('36e3fed2-292d-49d1-a948-25f81b89a087', '03', '客户类别3', '1', '3');
INSERT INTO `t_contract_sjzd_custom_type` VALUES ('e993afe6-b981-4b88-81ad-9c15accc4bbb', '01', '客户类别1', '1', '1');
INSERT INTO `t_contract_sjzd_custom_type` VALUES ('ffa58f45-8341-4f5c-bb73-83c86c760835', '02', '客户类别2', '1', '2');

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
-- Table structure for `t_contract_sjzd_fxxm`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_fxxm`;
CREATE TABLE `t_contract_sjzd_fxxm` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  `FXDJ` decimal(10,2) DEFAULT NULL COMMENT '分析单价',
  `FXYJ` varchar(100) DEFAULT NULL COMMENT '分析依据',
  `FXXLB` varchar(40) DEFAULT NULL COMMENT '分析项类别',
  `BZ` varchar(400) DEFAULT NULL COMMENT '备注',
  `FXRY` varchar(40) DEFAULT NULL COMMENT '分析人员',
  `SHRY` varchar(40) DEFAULT NULL COMMENT '审核人员',
  `ZK` decimal(10,2) DEFAULT NULL COMMENT '折扣',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分析项目';

-- ----------------------------
-- Records of t_contract_sjzd_fxxm
-- ----------------------------
INSERT INTO `t_contract_sjzd_fxxm` VALUES ('307cd8aa-7392-449f-acdb-f3c3171ff072', '307cd8aa-7392-449f-acdb-f3c3171ff072', '分析项目3', '1', '3', '10000.00', '分析项目2', '分析项目3', '', '1', '1', '1.00');
INSERT INTO `t_contract_sjzd_fxxm` VALUES ('65cb072b-0c75-4dcd-9afc-2f3f36558e4e', '65cb072b-0c75-4dcd-9afc-2f3f36558e4e', '分析项目1', '1', '1', '123.00', '分析项目1', '分析项目1', '', '1', '1', '0.80');
INSERT INTO `t_contract_sjzd_fxxm` VALUES ('ff8d7d5e-2797-461b-8c1e-2042ee43cafb', 'ff8d7d5e-2797-461b-8c1e-2042ee43cafb', '分析项目2', '1', '2', '100.00', '分析项目2', '分析项目2', '', '1', '1', '0.90');

-- ----------------------------
-- Table structure for `t_contract_sjzd_hbdw`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_hbdw`;
CREATE TABLE `t_contract_sjzd_hbdw` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货币单位';

-- ----------------------------
-- Records of t_contract_sjzd_hbdw
-- ----------------------------
INSERT INTO `t_contract_sjzd_hbdw` VALUES ('f5c22f44-3b07-493a-8bf4-9e7eb2770c62', '单位1', '单位1', '1', '1');

-- ----------------------------
-- Table structure for `t_contract_sjzd_hcfl`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_hcfl`;
CREATE TABLE `t_contract_sjzd_hcfl` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='耗材分类';

-- ----------------------------
-- Records of t_contract_sjzd_hcfl
-- ----------------------------
INSERT INTO `t_contract_sjzd_hcfl` VALUES ('a31ddc3f-582e-4870-9b60-b56427d6bb15', '02', '耗材分类2', '1', '2');
INSERT INTO `t_contract_sjzd_hcfl` VALUES ('b89b159e-50f9-4b92-9d69-f9d983fc18a9', '01', '耗材分类1', '1', '1');

-- ----------------------------
-- Table structure for `t_contract_sjzd_htlx`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_htlx`;
CREATE TABLE `t_contract_sjzd_htlx` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同类型表';

-- ----------------------------
-- Records of t_contract_sjzd_htlx
-- ----------------------------
INSERT INTO `t_contract_sjzd_htlx` VALUES ('972fa935-ca8c-4338-9e43-b845e94248e1', '1', '合同类型1', '1', '1');
INSERT INTO `t_contract_sjzd_htlx` VALUES ('e62abe28-c203-4b17-af18-66fb7bb7ab51', '2', '合同类型2', '1', '2');

-- ----------------------------
-- Table structure for `t_contract_sjzd_htzk`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_htzk`;
CREATE TABLE `t_contract_sjzd_htzk` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` decimal(10,2) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同折扣表';

-- ----------------------------
-- Records of t_contract_sjzd_htzk
-- ----------------------------
INSERT INTO `t_contract_sjzd_htzk` VALUES ('6dac538b-5fab-4969-80e4-951b0f456f33', '0.90', '9折', '1', '2');
INSERT INTO `t_contract_sjzd_htzk` VALUES ('bcf1c4a6-532c-4e0f-9dd8-c17010531fc6', '1.00', '无折扣', '1', '3');
INSERT INTO `t_contract_sjzd_htzk` VALUES ('f21d3edf-4ed1-42bc-8c4d-dab7a2cf40b2', '0.80', '8折扣', '1', '1');

-- ----------------------------
-- Table structure for `t_contract_sjzd_htzt`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_htzt`;
CREATE TABLE `t_contract_sjzd_htzt` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同状态表';

-- ----------------------------
-- Records of t_contract_sjzd_htzt
-- ----------------------------
INSERT INTO `t_contract_sjzd_htzt` VALUES ('21d12fbb-2e9f-4abd-8743-a822d705ee24', '-99', '审核不通过', '1', '5');
INSERT INTO `t_contract_sjzd_htzt` VALUES ('832fbfb4-e6dc-41db-ab28-e1a8c71e1316', '102', '审核通过', '1', '4');
INSERT INTO `t_contract_sjzd_htzt` VALUES ('9d8339e6-f2b8-4b47-a4f7-387d3048d961', '101', '进行中', '1', '3');
INSERT INTO `t_contract_sjzd_htzt` VALUES ('e6b0d2ce-ee96-4238-b7a2-2c9c36a4b1c9', '100', '待审核', '1', '2');
INSERT INTO `t_contract_sjzd_htzt` VALUES ('fbefcb71-970c-4c9f-8bb8-2bab2a67a8b4', '1', '未付款', '1', '1');

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
-- Table structure for `t_contract_sjzd_money`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_money`;
CREATE TABLE `t_contract_sjzd_money` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `HTID` varchar(40) DEFAULT NULL COMMENT '合同ID',
  `FXXM` varchar(40) DEFAULT NULL COMMENT '分析项目',
  `DJ` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `SL` int(11) DEFAULT NULL COMMENT '数量',
  `ZKJG` decimal(10,2) DEFAULT NULL COMMENT '折扣价格',
  `ZJ` decimal(10,2) DEFAULT NULL COMMENT '总价',
  `CREATE_TIME` varchar(40) DEFAULT NULL COMMENT '创建时间',
  `CREATE_MAN` varchar(40) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同价目列表';

-- ----------------------------
-- Records of t_contract_sjzd_money
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_sjzd_pclb`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_pclb`;
CREATE TABLE `t_contract_sjzd_pclb` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='批次类别';

-- ----------------------------
-- Records of t_contract_sjzd_pclb
-- ----------------------------
INSERT INTO `t_contract_sjzd_pclb` VALUES ('3c2eb7e4-1118-4d12-a73c-48e4dc738ec9', '01', '测试类别1', '1', '1');
INSERT INTO `t_contract_sjzd_pclb` VALUES ('9ca1bc52-5182-4ed2-af8c-c2afc1c6cb3b', '01', '测试类别1', '2', '1');
INSERT INTO `t_contract_sjzd_pclb` VALUES ('affcf598-6596-4fa6-b441-2bf2a2559b6d', '02', '测试类别2', '1', '2');

-- ----------------------------
-- Table structure for `t_contract_sjzd_pczt`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_pczt`;
CREATE TABLE `t_contract_sjzd_pczt` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='批次状态';

-- ----------------------------
-- Records of t_contract_sjzd_pczt
-- ----------------------------
INSERT INTO `t_contract_sjzd_pczt` VALUES ('196d8a9b-1c54-4436-bf50-67ec84ab9460', '2', '待测', '1', '2');
INSERT INTO `t_contract_sjzd_pczt` VALUES ('1f2d1c0d-5538-48b1-9803-35505d754ee4', '3', '检测中', '1', '3');
INSERT INTO `t_contract_sjzd_pczt` VALUES ('9ca8dc2b-b9de-41b5-b428-dce92a484167', '1', '新建', '1', '1');
INSERT INTO `t_contract_sjzd_pczt` VALUES ('b06064b2-074d-4d74-8d97-1334f462da29', '批次状态1', '批次状态1', '2', '1');
INSERT INTO `t_contract_sjzd_pczt` VALUES ('c8f794d1-8b85-468f-a5a2-f6525e3b0157', '4', '已归档', '1', '4');

-- ----------------------------
-- Table structure for `t_contract_sjzd_pp`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_pp`;
CREATE TABLE `t_contract_sjzd_pp` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品牌';

-- ----------------------------
-- Records of t_contract_sjzd_pp
-- ----------------------------
INSERT INTO `t_contract_sjzd_pp` VALUES ('a03f6fb7-4fe4-49a1-b994-80165668811b', '品牌1', '品牌1', '1', '1');

-- ----------------------------
-- Table structure for `t_contract_sjzd_pxlx`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_pxlx`;
CREATE TABLE `t_contract_sjzd_pxlx` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='培训类型';

-- ----------------------------
-- Records of t_contract_sjzd_pxlx
-- ----------------------------
INSERT INTO `t_contract_sjzd_pxlx` VALUES ('6d42585f-13d8-4f81-a51c-8d88093b2d56', '2', '培训类型2', '1', '2');
INSERT INTO `t_contract_sjzd_pxlx` VALUES ('d76f14c5-7b94-4d14-8120-f458484b5b66', '1', '培训类型1', '1', '1');

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
INSERT INTO `t_contract_sjzd_shzt` VALUES ('01', '1', '草稿', '1', '1');
INSERT INTO `t_contract_sjzd_shzt` VALUES ('02', '100', '待审核', '2', '1');
INSERT INTO `t_contract_sjzd_shzt` VALUES ('03', '101', '进行中', '3', '1');
INSERT INTO `t_contract_sjzd_shzt` VALUES ('04', '102', '已完成', '4', '1');
INSERT INTO `t_contract_sjzd_shzt` VALUES ('99', '-99', '审核不通过', '5', '1');

-- ----------------------------
-- Table structure for `t_contract_sjzd_sldw`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_sldw`;
CREATE TABLE `t_contract_sjzd_sldw` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数量单位';

-- ----------------------------
-- Records of t_contract_sjzd_sldw
-- ----------------------------
INSERT INTO `t_contract_sjzd_sldw` VALUES ('3894184d-9dcf-4efd-8547-b95b7215095d', '数量单位1', '数量单位1', '1', '1');

-- ----------------------------
-- Table structure for `t_contract_sjzd_sydw`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_sydw`;
CREATE TABLE `t_contract_sjzd_sydw` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='送样单位';

-- ----------------------------
-- Records of t_contract_sjzd_sydw
-- ----------------------------
INSERT INTO `t_contract_sjzd_sydw` VALUES ('5dd972d8-e681-4b27-a991-20188580a68e', '2', '送样单位2', '1', '2');
INSERT INTO `t_contract_sjzd_sydw` VALUES ('ead7207f-b952-4eea-9a26-2fa20f96b4cb', '1', '送样单位1', '1', '1');

-- ----------------------------
-- Table structure for `t_contract_sjzd_taskstatus`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_taskstatus`;
CREATE TABLE `t_contract_sjzd_taskstatus` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务状态';

-- ----------------------------
-- Records of t_contract_sjzd_taskstatus
-- ----------------------------
INSERT INTO `t_contract_sjzd_taskstatus` VALUES ('05886bf4-4efb-466b-bdaf-f9caba548569', '3', '数据处理', '1', '3');
INSERT INTO `t_contract_sjzd_taskstatus` VALUES ('26e82bf0-af89-45eb-a37b-7950123c8dbb', '2', '检测', '1', '2');
INSERT INTO `t_contract_sjzd_taskstatus` VALUES ('56b8d191-5ac5-4700-b7e3-3902572384ce', '100', '待审核', '1', '5');
INSERT INTO `t_contract_sjzd_taskstatus` VALUES ('7a766650-77a8-492b-9229-5d873dedf6ef', '1', '前处理', '1', '1');
INSERT INTO `t_contract_sjzd_taskstatus` VALUES ('8280af68-a238-44d3-9bfb-f6b81317cd03', '102', '已结束', '1', '7');
INSERT INTO `t_contract_sjzd_taskstatus` VALUES ('94e39073-f196-4685-8ee5-5303f8f362af', '101', '审核进行中', '1', '6');
INSERT INTO `t_contract_sjzd_taskstatus` VALUES ('d94413ac-4b7c-4c05-a80d-475d0c5d4cf9', '-99', '不通过', '1', '8');
INSERT INTO `t_contract_sjzd_taskstatus` VALUES ('ed67ea5b-d34a-4de6-bf82-d2d5940e66a1', '4', '数据报告', '1', '4');

-- ----------------------------
-- Table structure for `t_contract_sjzd_taskstatus_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_taskstatus_detail`;
CREATE TABLE `t_contract_sjzd_taskstatus_detail` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='子任务任务状态';

-- ----------------------------
-- Records of t_contract_sjzd_taskstatus_detail
-- ----------------------------
INSERT INTO `t_contract_sjzd_taskstatus_detail` VALUES ('067ae4d1-5115-45ff-bb25-cce33d9deccd', '2', '检测', '1', '2');
INSERT INTO `t_contract_sjzd_taskstatus_detail` VALUES ('bb47db67-67ec-41c2-92f3-2dd95030a2bc', '3', '数据处理', '1', '3');
INSERT INTO `t_contract_sjzd_taskstatus_detail` VALUES ('d8697c95-a394-404f-85ca-73f7952d56be', '4', '完成', '1', '4');
INSERT INTO `t_contract_sjzd_taskstatus_detail` VALUES ('ea1fc905-468d-4e3a-a265-f65118f6bcbf', '1', '前处理', '1', '1');

-- ----------------------------
-- Table structure for `t_contract_sjzd_ypcfd`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_sjzd_ypcfd`;
CREATE TABLE `t_contract_sjzd_ypcfd` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LBDM` varchar(40) DEFAULT NULL COMMENT '代码',
  `LBMC` varchar(60) DEFAULT NULL COMMENT '类别名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `OrderBy` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='样品存放地';

-- ----------------------------
-- Records of t_contract_sjzd_ypcfd
-- ----------------------------
INSERT INTO `t_contract_sjzd_ypcfd` VALUES ('b2f56784-7072-41ea-89fc-dcfb31bdc3ad', '样品存放地1', '样品存放地1', '1', '1');

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
-- Table structure for `t_contract_static_money`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_static_money`;
CREATE TABLE `t_contract_static_money` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `DATA_YEAR` int(11) DEFAULT NULL COMMENT '年',
  `DATA_MONTH` int(11) DEFAULT NULL COMMENT '月',
  `DATA_YEAR_MONTH` varchar(40) DEFAULT NULL COMMENT '年月',
  `SR` decimal(10,2) DEFAULT NULL COMMENT '收入',
  `WRZ` decimal(10,2) DEFAULT NULL COMMENT '未入账',
  `ZC` decimal(10,2) DEFAULT NULL COMMENT '支出',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收入统计';

-- ----------------------------
-- Records of t_contract_static_money
-- ----------------------------
INSERT INTO `t_contract_static_money` VALUES ('04bcf79a-3e88-42be-adc1-6205f1da7931', '2017', '11', '2017-11', null, null, null);
INSERT INTO `t_contract_static_money` VALUES ('0758861b-5524-4fcb-8649-90fc1691cdbe', '2017', '1', '2017-01', null, null, null);
INSERT INTO `t_contract_static_money` VALUES ('24462f2a-01ce-47ad-ba11-980c9de3f793', '2017', '12', '2017-12', null, null, null);
INSERT INTO `t_contract_static_money` VALUES ('2dcafe56-a26c-40c1-88e4-7d5cdcf53240', '2017', '4', '2017-04', null, null, null);
INSERT INTO `t_contract_static_money` VALUES ('37cc6b75-6976-4650-9692-c6ff8ec21582', '2017', '10', '2017-10', null, null, null);
INSERT INTO `t_contract_static_money` VALUES ('38b89be2-b47a-461b-89cc-b3d9c811d4e6', '2017', '2', '2017-02', null, null, null);
INSERT INTO `t_contract_static_money` VALUES ('62d68b68-8f3c-4cef-947f-151000665e8e', '2017', '3', '2017-03', null, null, null);
INSERT INTO `t_contract_static_money` VALUES ('8de87885-0de2-4417-8af1-d05af271463a', '2017', '7', '2017-07', null, null, null);
INSERT INTO `t_contract_static_money` VALUES ('d60b161f-9aa0-4053-a929-eccc385ffdc4', '2017', '8', '2017-08', null, null, null);
INSERT INTO `t_contract_static_money` VALUES ('d91711f5-e587-48a9-810b-710d7de425ed', '2017', '5', '2017-05', null, null, null);
INSERT INTO `t_contract_static_money` VALUES ('e7163d8e-8136-4492-af5e-e5fa39e207e7', '2017', '6', '2017-06', null, null, null);
INSERT INTO `t_contract_static_money` VALUES ('ff76f843-59a6-4eaa-bd9e-43bbc049c607', '2017', '9', '2017-09', null, '8150.72', null);

-- ----------------------------
-- Table structure for `t_contract_supplies_gmb`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_supplies_gmb`;
CREATE TABLE `t_contract_supplies_gmb` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LYSL` int(11) DEFAULT NULL COMMENT '购买数量',
  `USERID` varchar(40) DEFAULT NULL COMMENT '申请人ID',
  `SQSJ` varchar(40) DEFAULT NULL COMMENT '申请时间',
  `RWZT` varchar(10) DEFAULT NULL COMMENT '申请状态',
  `CURENTSTEP` int(11) DEFAULT NULL COMMENT '当前步骤',
  `BZ` varchar(400) DEFAULT NULL COMMENT '备注',
  `HCID` varchar(40) DEFAULT NULL COMMENT '耗材ID',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='耗材信息购买表';

-- ----------------------------
-- Records of t_contract_supplies_gmb
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_supplies_lqb`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_supplies_lqb`;
CREATE TABLE `t_contract_supplies_lqb` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LYSL` int(11) DEFAULT NULL COMMENT '领用数量',
  `GHSL` int(11) DEFAULT NULL COMMENT '归还数量',
  `USERID` varchar(40) DEFAULT NULL COMMENT '申请人ID',
  `SQSJ` varchar(40) DEFAULT NULL COMMENT '申请时间',
  `RWZT` varchar(10) DEFAULT NULL COMMENT '申请状态',
  `CURENTSTEP` int(11) DEFAULT NULL COMMENT '当前步骤',
  `BZ` varchar(400) DEFAULT NULL COMMENT '备注',
  `HCID` varchar(40) DEFAULT NULL COMMENT '耗材ID',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='耗材信息领取表';

-- ----------------------------
-- Records of t_contract_supplies_lqb
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_supplies_main`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_supplies_main`;
CREATE TABLE `t_contract_supplies_main` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `HCFL` varchar(10) DEFAULT NULL COMMENT '耗材分类',
  `PM` varchar(100) DEFAULT NULL COMMENT '品名',
  `XHPPCH` varchar(100) DEFAULT NULL COMMENT '消耗品批次号',
  `XHPLRSJ` varchar(40) DEFAULT NULL COMMENT '消耗品录入时间',
  `YXQ` decimal(10,2) DEFAULT NULL COMMENT '有效期',
  `KC` int(11) DEFAULT NULL COMMENT '库存',
  `SLDW` varchar(20) DEFAULT NULL COMMENT '数量单位',
  `DJ` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `HBDW` varchar(20) DEFAULT NULL COMMENT '货币单位',
  `GYS` varchar(100) DEFAULT NULL COMMENT '供应商',
  `YJSL` int(11) DEFAULT NULL COMMENT '预警数量',
  `BZ` varchar(400) DEFAULT NULL COMMENT '备注',
  `DQBH` int(11) DEFAULT NULL COMMENT '当前序号',
  `FID` varchar(40) DEFAULT NULL COMMENT '父编号',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='耗材信息表';

-- ----------------------------
-- Records of t_contract_supplies_main
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_supplies_shb`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_supplies_shb`;
CREATE TABLE `t_contract_supplies_shb` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `LYSL` int(11) DEFAULT NULL COMMENT '损坏数量',
  `USERID` varchar(40) DEFAULT NULL COMMENT '申请人ID',
  `SQSJ` varchar(40) DEFAULT NULL COMMENT '申请时间',
  `RWZT` varchar(10) DEFAULT NULL COMMENT '申请状态',
  `CURENTSTEP` int(11) DEFAULT NULL COMMENT '当前步骤',
  `BZ` varchar(400) DEFAULT NULL COMMENT '备注',
  `HCID` varchar(40) DEFAULT NULL COMMENT '耗材ID',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='耗材信息损坏表';

-- ----------------------------
-- Records of t_contract_supplies_shb
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_supplies_total`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_supplies_total`;
CREATE TABLE `t_contract_supplies_total` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `HCFL` varchar(10) DEFAULT NULL COMMENT '耗材分类',
  `PM` varchar(100) DEFAULT NULL COMMENT '品名',
  `XHPLRSJ` varchar(40) DEFAULT NULL COMMENT '消耗品录入时间',
  `KC` int(11) DEFAULT NULL COMMENT '库存',
  `SLDW` varchar(20) DEFAULT NULL COMMENT '数量单位',
  `DJ` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `HBDW` varchar(20) DEFAULT NULL COMMENT '货币单位',
  `GYS` varchar(100) DEFAULT NULL COMMENT '供应商',
  `YJSL` int(11) DEFAULT NULL COMMENT '预警数量',
  `BZ` varchar(400) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='耗材信息汇总表';

-- ----------------------------
-- Records of t_contract_supplies_total
-- ----------------------------

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
INSERT INTO `t_contract_sys_flowset` VALUES ('140621d9-7746-41e7-b6d5-616a7774adca', '04', '1', '6ecefc16-fa74-4f14-95ac-cb181fe1fe42', null);
INSERT INTO `t_contract_sys_flowset` VALUES ('2da49492-445b-4dcc-a212-2566cc0a2fcb', '04', '2', '946e4674-8d0c-4f33-a806-a407fb7430fa', null);
INSERT INTO `t_contract_sys_flowset` VALUES ('3a4adba6-3010-4203-ae12-d781650c8bda', '05', '1', '1', null);
INSERT INTO `t_contract_sys_flowset` VALUES ('559cc82c-3adc-4c6b-b65a-edd19b930bb0', '01', '1', '1', '01');
INSERT INTO `t_contract_sys_flowset` VALUES ('91953950-fa55-4013-bf7d-8f9c2cf7da1e', null, null, null, null);
INSERT INTO `t_contract_sys_flowset` VALUES ('a6492082-81f4-4c81-9f1a-a8787ca4fafd', '02', '1', '593a3814-95fd-44a5-9dc3-54ba9e975b01', null);
INSERT INTO `t_contract_sys_flowset` VALUES ('b6a05dce-fbbe-409d-978b-8b756dd85faa', '03', '2', '02d79cb6-6437-4f09-9ff5-8b56f7940cc0', null);
INSERT INTO `t_contract_sys_flowset` VALUES ('f3232c90-d4b7-43b1-95a7-359eeb43e3db', '03', '1', '2df0c66f-9d5a-4a73-bc33-45ce6e93a80c', null);

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
INSERT INTO `t_contract_sys_flowset_data` VALUES ('02949f93-3447-4492-8a3f-318de67c3b69', '03', 'f9d21d25-d807-49ac-af50-5f02e9408e85', '1', '02', '2017-08-22 14:51:59', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('04a19b1f-ea9b-4ef8-add5-97a2bc146fa4', '03', 'eb0256ed-bdef-4af8-b911-2393fa9af113', '2', '03', '2017-08-19 02:00:20', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('04ec94d3-9b32-4850-aeeb-44d23d8eb410', '01', '97c36542-ba2c-4459-8ba8-f821914a119c', '1', '100', '2017-09-10 13:30:15', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('05193e7d-b9da-4658-8d60-88c9b5de9c45', '03', '59657429-4e4b-4079-b479-e1ba27d13f88', '2', '03', '2017-08-19 00:55:07', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('05d3ed22-baf3-40ab-87c2-97cf4ceabc4e', '05', '9cbc5999-da0c-49e4-a760-37e39d346f44', '1', '100', '2017-09-10 17:45:03', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('07a9fbfd-1858-44c1-b9fa-82197ab2d974', '01', 'b396f5ec-da23-486b-a55c-af24845f7099', '1', '100', '2017-09-10 13:31:10', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('0d3ff2d9-af45-4167-b56e-a01949ee6003', '02', '9adc8133-48a0-4386-800e-c665b6c00020', '1', '02', '2017-08-15 12:57:14', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('0d5898b3-5be5-4b51-9253-a86f66bed4df', '01', '2d08077d-d19d-4eef-9a7b-b4017462dedc', '2', '03', '2017-08-13 10:39:26', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('0d74d089-f756-425c-be02-7d694b131510', '03', 'a372482d-6f7c-4627-a993-eaec86c38b60', '-1', '04', '2017-08-19 01:50:00', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('0f1363c3-2880-45f9-8cba-73a60f1fb6a5', '02', '3365ea81-0b97-429b-aabb-7d1af3fc2643', '1', '02', '2017-08-20 17:44:11', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('0f7fd155-0b2a-40d6-825c-5b1ab6a18694', '01', 'f552fd56-6cc7-40c1-8ba1-b43724d2a882', '1', '100', '2017-09-10 13:31:22', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('0fde4adb-bfc8-4468-a474-397f842933dd', '01', '0a109715-8349-4c8a-a5a8-fe66b88f3972', '-1', '102', '2017-09-10 13:45:34', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('112c1ef1-4aaa-4089-9b4a-b059a8d73e0b', '02', '4990ec3f-5503-4374-8832-e46c28a90aab', '1', '02', '2017-08-15 09:04:49', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('14e93309-1096-42f9-8f78-d276c7d4cf39', '01', '03bdac00-0942-4ef8-aa89-4fa958ba19bf', '1', '100', '2017-09-10 13:17:23', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('170902a0-495b-45e4-b403-7b256654fa15', '03', 'a372482d-6f7c-4627-a993-eaec86c38b60', '1', '02', '2017-08-19 01:46:05', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('17f8617c-cbb4-4ef3-9ac3-caeb57c950f8', '03', 'e44c5d02-b4b5-4875-bbc0-7a1da3564e8c', '1', '100', '2017-08-27 11:53:08', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('18293e11-6316-489f-b0bf-3354bbafc649', '01', '6898688e-0dba-45c3-9335-15980e1a2b2a', '2', '03', '2017-08-13 10:21:33', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('1892b8a1-0f4e-4b3d-983f-9f24e6bc65a1', '03', '0e789238-18cc-4649-bc91-85faaefc7e29', '2', '03', '2017-08-19 02:01:11', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('19cdf2a3-532e-47b7-94b7-f0ac33e2b9eb', '03', 'cc313384-3c7e-4526-b89d-8f9d732ef4ea', '2', '03', '2017-08-22 16:19:14', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('1ba20e70-264d-4c11-957f-ce03c0487b83', '03', '2ff3e658-4c6e-4f11-9423-ebee137b7f92', '2', '03', '2017-08-26 22:15:21', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('1db59bf4-64a2-48b6-a85c-4e2b99fa26d1', '01', 'b6fdfef4-4df1-490e-94f0-796b94159cba', '2', '03', '2017-08-13 10:38:05', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('2026f4d8-05a6-48d1-914a-264f9da7a6d1', '04', 'ed7a9bec-f104-4272-a053-4061103f54b9', '2', '101', '2017-08-27 18:06:17', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('22a3dfd6-3a10-4568-a3aa-2fb9e993bc9a', '03', '2ededa93-d1bc-4052-a07d-8eb85d4a4bc3', '-1', '04', '2017-08-22 16:20:28', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('23afa84c-2b39-40b4-8243-d4e1b1e2a675', '03', '7d3d63fd-d4b7-42aa-a5f7-2d5980dbf26a', '1', '02', '2017-08-22 14:51:54', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('27ec319a-ba38-466f-bd6f-fee784638294', '01', '2d08077d-d19d-4eef-9a7b-b4017462dedc', '1', '02', '2017-08-13 10:38:23', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('28c9897a-5664-479b-a997-c1b941f13229', '01', '6790991f-40f7-48fd-8a25-4f21770889d7', '1', '100', '2017-09-10 13:21:47', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('2c6e7333-a980-400f-b17b-6142888b2480', '01', '2d08077d-d19d-4eef-9a7b-b4017462dedc', '-1', '04', '2017-08-13 10:41:14', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('2e71e096-319f-446c-b5a6-7ce8d0d350d2', '03', 'd80a27f0-ee8a-4615-85fd-fec2cd866205', '1', '02', '2017-08-22 14:51:45', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('2f4a8254-9b97-4c5f-95e1-6c0e0e220dcd', '02', 'e5d11c22-a0d9-4b6f-b119-920f7347230c', '1', '02', '2017-08-14 17:30:29', '1', '提交检测', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('2f5fee31-d39c-4de8-8cd9-3463b07d3251', '03', '02705864-70cc-4004-86cd-63f6d0f13735', '-1', '04', '2017-08-19 02:01:30', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('2f7daf2e-375f-44ee-833d-1d99aee375e1', '03', '16cdd755-2c87-4cb2-b845-045cb3b819e3', '1', '02', '2017-08-26 22:49:28', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('2fc15625-fac6-4456-8aa9-8e426a683927', '01', '6898688e-0dba-45c3-9335-15980e1a2b2a', '1', '02', '2017-08-13 10:06:03', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('357ed4ed-bed4-4632-9ddf-60f735e07122', '03', '08321ced-a063-47b1-bfa8-dd6ef45bc842', '2', '03', '2017-08-19 12:43:07', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('36520b2c-f6a0-42eb-98e8-27f2be62eea5', '03', '59657429-4e4b-4079-b479-e1ba27d13f88', '2', '03', '2017-08-19 01:04:08', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('395a1614-141e-4ff9-bf7f-31a45441fd21', '03', 'ed7a9bec-f104-4272-a053-4061103f54b9', '1', '100', '2017-08-27 15:44:35', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('3fa36a6d-d74d-4a1e-9ae6-27ffd1944ba2', '02', '8e576322-d91c-4eb3-8a3e-cdec9600da19', '1', '02', '2017-08-15 13:01:43', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('4539c236-833d-413f-b8fb-d10713091d05', '03', 'eb0256ed-bdef-4af8-b911-2393fa9af113', '-1', '04', '2017-08-19 02:00:27', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('469d693f-390e-4be3-b76d-ecb34fa3b33a', '03', '0e4f749f-dd58-4a5c-b51f-095c9e0a9b73', '-1', '04', '2017-08-19 01:49:56', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('480be905-f7b4-41c7-9f29-015e76889e59', '03', 'cc313384-3c7e-4526-b89d-8f9d732ef4ea', '-1', '04', '2017-08-22 16:19:36', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('486640a4-8be6-4333-8119-e1542f60f383', '03', '6e13a66a-9a3e-4701-bd44-ba0b7d794ee3', '1', '02', '2017-08-18 23:38:18', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('4d027aa8-9195-4116-9469-8dcf724de858', '03', '44e96809-ddc6-4a3d-9a6e-da183f0e4c15', '1', '02', '2017-08-18 23:36:14', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('5140d87c-2b4e-4bff-9470-d65ce7a673a7', '03', '0e789238-18cc-4649-bc91-85faaefc7e29', '1', '02', '2017-08-19 02:00:47', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('5781642e-a32a-42d5-a978-4513881fa4c3', '03', '7a896373-7802-4bc3-a755-bb11c16d1c7d', '1', '02', '2017-08-19 00:43:04', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('596c0b3f-e489-488d-ac90-db40bd7f1e5a', '03', '3ab1fd86-4b56-405a-8704-33d001de8225', '-1', '102', '2017-08-27 13:03:16', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('5973d900-1361-4960-87a7-b9d9c3c2dc7c', '02', 'c6d98072-b9ed-4454-8071-9d2c0c059afe', '1', '02', '2017-08-14 10:51:33', '1', '提交检测', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('5d9baba6-6051-4f13-8283-dfb14999b40a', '03', '02705864-70cc-4004-86cd-63f6d0f13735', '2', '03', '2017-08-19 01:52:31', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('5f429618-5be3-4c78-ab70-df46e5f675f4', '03', '235bddd7-304b-40d9-a2c2-162f57ca5969', '1', '02', '2017-08-19 00:39:21', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('5f9c00a1-9812-4a10-8341-b4e9756431ee', '03', 'b830aa0a-0f82-4150-8db0-421e37f491ab', '1', '02', '2017-08-19 00:44:49', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('6192222d-a384-4e01-b9af-38f7a592baff', '03', 'cc313384-3c7e-4526-b89d-8f9d732ef4ea', '1', '02', '2017-08-22 15:06:10', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('61f64001-88de-47d3-b7a7-f39c0961213e', '01', '6898688e-0dba-45c3-9335-15980e1a2b2a', '3', '03', '2017-08-13 10:26:01', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('66aa0ec1-e5b3-42e4-ae26-08c0db5b465e', '02', '8e576322-d91c-4eb3-8a3e-cdec9600da19', '-1', '04', '2017-08-15 15:56:51', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('6a6c5a28-4053-46a7-8b3a-3b047f70ccae', '03', '59657429-4e4b-4079-b479-e1ba27d13f88', '2', '03', '2017-08-19 00:58:23', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('6b095a54-a5e1-4a75-b0da-663fa081b8cb', '03', 'ff4dd509-407e-4e51-ae95-838b745e90bf', '2', '101', '2017-08-27 12:56:53', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('6c4e6538-ea9a-495d-a352-cfc5789a6229', '03', '67b20b01-9f57-427b-8cf8-3019b519e4aa', '1', '02', '2017-08-19 13:01:45', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('6f8c1444-0ac5-4e14-bfc5-4912c1ecba17', '03', 'd5a33a63-4c51-4705-8e4d-7ddfb18a08b9', '-1', '04', '2017-08-19 02:02:07', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('71796250-7236-446b-8ce7-bc474ccdf949', '03', '02705864-70cc-4004-86cd-63f6d0f13735', '1', '02', '2017-08-19 01:52:04', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('75ad0c2e-6fdb-4f11-adce-4669b4b420cd', '01', 'cb7e0884-b2f5-4556-9e38-d94adcf44407', '1', '01', '2017-08-13 10:49:46', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('769a8ee0-254f-460d-840b-891e720a9f31', '01', '0a109715-8349-4c8a-a5a8-fe66b88f3972', '1', '100', '2017-09-10 13:31:22', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('77360325-af4a-4b17-a452-faca1360487d', '03', '59657429-4e4b-4079-b479-e1ba27d13f88', '2', '03', '2017-08-19 01:04:21', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('77ab5e8f-87e6-446a-aee9-2fb2ed1c49d4', '03', '59657429-4e4b-4079-b479-e1ba27d13f88', '1', '02', '2017-08-19 00:46:30', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('78521307-8c7f-4ed8-a81f-8d14455b5e3f', '04', '87ec6874-32bc-4d5e-acbc-bc62d31f4308', '1', '100', '2017-09-02 19:43:54', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('799613ab-c96c-4073-ad5b-c97068dde51c', '03', '710b4748-537b-45db-b084-a83d89b80c14', '1', '02', '2017-08-19 00:42:28', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('7a2ad1cf-b5d5-4f21-9354-89481cb16f1d', '03', '96bbc753-38a1-458c-9082-f724e1313f0c', '1', '02', '2017-08-19 01:55:02', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('7a5c01fc-1c14-4202-88c9-318439cbdf76', '04', '87ec6874-32bc-4d5e-acbc-bc62d31f4308', '2', '101', '2017-09-02 19:44:37', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('80329719-c7fd-4178-a640-b8c22587a181', '04', '87ec6874-32bc-4d5e-acbc-bc62d31f4308', '-1', '102', '2017-09-02 19:44:52', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('84fb21cb-319f-4bfd-a376-cb7cd150bf2e', '03', '2ededa93-d1bc-4052-a07d-8eb85d4a4bc3', '2', '03', '2017-08-22 16:20:17', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('88d2a942-0b48-46b7-8fb7-3762e639e82a', '04', 'ed7a9bec-f104-4272-a053-4061103f54b9', '-1', '102', '2017-08-27 18:06:44', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('88daefd7-c6e9-491f-94f1-8790798a3f62', '02', 'd71acb3a-9e53-4a8e-86ba-38fd8353d59c', '1', '02', '2017-08-20 02:13:22', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('8ac96fa3-0659-452e-82c2-5a815288572f', '01', 'b9fb22c2-d876-45e9-86b6-b82f1d37c725', '-1', '102', '2017-09-10 13:44:57', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('8bea676f-30d6-4705-80e2-cac0ceb3e34b', '03', '08321ced-a063-47b1-bfa8-dd6ef45bc842', '1', '02', '2017-08-19 12:41:47', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('8c1becbe-1daa-4fd9-856f-340103acb731', '02', 'dad422e6-b6c3-4898-ae41-8151662580d7', '1', '02', '2017-08-14 11:30:10', '1', '提交检测', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('8d09b7d6-e864-4b4b-970d-4655c0e90eb0', '03', 'eb0256ed-bdef-4af8-b911-2393fa9af113', '2', '03', '2017-08-19 02:00:20', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('8f082f9c-3bd9-4005-8e7f-f0ceeb310070', '03', 'a372482d-6f7c-4627-a993-eaec86c38b60', '2', '03', '2017-08-19 01:49:37', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('903779b7-dc3b-4374-b4e9-6d1de59a1104', '01', 'da52743b-6483-4fce-9853-38935b5930f3', '1', '100', '2017-09-10 13:30:43', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('908810d0-4bb4-4127-9270-70eedd1c1cd0', '03', 'e6f918c6-31ea-47b1-bb2f-f659c642bb94', '1', '02', '2017-08-26 22:49:36', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('923175dc-e857-44ac-830d-c4cedab63dc6', '02', '55e624bb-351a-4204-a7b6-cbd64fe863f4', '1', '02', '2017-08-19 02:45:42', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('9231d0c3-ec7f-41c9-8ad5-d953d586ba95', '03', '59657429-4e4b-4079-b479-e1ba27d13f88', '2', '03', '2017-08-19 01:03:13', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('952bcd38-e986-4d4b-8782-d672ef395d0b', '04', 'ed7a9bec-f104-4272-a053-4061103f54b9', '1', '100', '2017-08-27 17:25:23', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('958f1f16-8eb2-4cb7-8fd5-96d4e9b824dd', '03', '0e4f749f-dd58-4a5c-b51f-095c9e0a9b73', '1', '02', '2017-08-19 01:45:53', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('9aa35ac3-3ec0-4bf2-bb87-ba7cdb7dfa74', '01', '8043fc10-dae8-4029-aa6f-0eccedba812d', '1', '-99', '2017-09-10 14:00:52', '1', '不通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('9c16f393-a106-4430-8e27-585a7f0ee751', '01', '7c4d7c31-8f68-4b4d-999a-6bdd713af959', '1', '100', '2017-09-10 13:30:55', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('a194758f-b004-4148-8284-07511c41f990', '04', '699532a5-88d8-47fb-8fe1-d5213d44edb2', '1', '100', '2017-09-10 19:50:52', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('a285e095-9ceb-4a17-afbf-2710624dadcc', '03', '3ab1fd86-4b56-405a-8704-33d001de8225', '2', '101', '2017-08-27 12:57:04', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('a58d620e-4c65-446c-8f50-d7bc16a8d921', '03', '59657429-4e4b-4079-b479-e1ba27d13f88', '-1', '04', '2017-08-19 01:49:50', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('a94f4920-a3c2-4faf-85ee-939d22445247', '03', 'd5a33a63-4c51-4705-8e4d-7ddfb18a08b9', '2', '03', '2017-08-19 02:01:59', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('abf2003e-c14d-4f15-bcf6-5ce05bab31df', '02', 'dd9b3193-8873-4a41-96ec-4823d045d6c4', '1', '02', '2017-08-14 11:28:37', '1', '提交检测', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('adb0a361-aa51-4459-9645-02639c2a14f0', '01', '8043fc10-dae8-4029-aa6f-0eccedba812d', '1', '100', '2017-09-10 13:31:32', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('b0247048-043c-421a-a305-7439a26b3383', '03', '96bbc753-38a1-458c-9082-f724e1313f0c', '2', '03', '2017-08-19 12:43:01', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('b039285b-2d65-41b2-a8a3-65f83b64b207', '03', '59657429-4e4b-4079-b479-e1ba27d13f88', '2', '03', '2017-08-19 00:55:37', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('b1d1a9a8-a7fe-4a5d-a590-be6eb8ee815e', '01', '8043fc10-dae8-4029-aa6f-0eccedba812d', '1', '-99', '2017-09-10 14:03:05', '1', '不通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('b22314d5-a4c9-43c6-835d-af8320ecec38', '05', '9cbc5999-da0c-49e4-a760-37e39d346f44', '-1', '102', '2017-09-10 18:14:46', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('bb73b2bc-30e2-4b64-8da7-6c23a9f560e5', '04', '699532a5-88d8-47fb-8fe1-d5213d44edb2', '2', '101', '2017-09-10 19:51:24', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('be2153ee-d5b9-4cea-a2a7-23a7e931c4f2', '01', '99d24bb0-5488-4e0c-aa57-4de4467d8e78', '1', '01', '2017-08-13 10:50:15', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('befb9f46-76fe-4c2c-8e4c-53249c839e9f', '03', 'eb0256ed-bdef-4af8-b911-2393fa9af113', '1', '02', '2017-08-19 02:00:09', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('c008536e-6446-4a99-8ec0-4c603762bf4e', '01', '47488384-8233-4a46-9416-bb5192c655e7', '1', '01', '2017-08-13 10:49:46', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('c6b8d348-a26c-4681-8b3d-3884914128db', '03', '7f71987d-15f8-4ff7-b723-e9f5ce51196d', '1', '02', '2017-08-26 22:49:25', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('c6ca434f-05b1-4b30-828b-41c401811ed4', '03', 'd5a33a63-4c51-4705-8e4d-7ddfb18a08b9', '1', '02', '2017-08-19 02:01:50', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('cd824e51-0d33-4a01-ae44-735d2768f059', '04', '699532a5-88d8-47fb-8fe1-d5213d44edb2', '-1', '102', '2017-09-10 19:51:33', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('cf18d532-5edb-4953-b8f6-96b7cf04e685', '03', '3ab1fd86-4b56-405a-8704-33d001de8225', '1', '100', '2017-08-27 12:54:41', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('d2775067-e67f-4565-9b73-300489ddf220', '03', '0e4f749f-dd58-4a5c-b51f-095c9e0a9b73', '2', '03', '2017-08-19 01:46:20', '1', '进行中', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('d6902f32-30de-4fe5-9269-68e9055b3831', '01', 'ecefcdb5-c92d-470b-8822-d6413f9a8d44', '1', '100', '2017-09-10 13:04:58', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('d7913b99-cc54-49c5-8a65-e0fe1c2fb639', '03', '2ededa93-d1bc-4052-a07d-8eb85d4a4bc3', '1', '02', '2017-08-22 15:06:16', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('d8c4edbe-c7b1-4052-a5d4-9c88f892aa64', '03', 'ed7a9bec-f104-4272-a053-4061103f54b9', '1', '100', '2017-08-27 15:49:47', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('d95dd51f-2905-4788-9c56-9b0bf7981e38', '01', 'b9fb22c2-d876-45e9-86b6-b82f1d37c725', '1', '100', '2017-09-10 13:31:42', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('dd78834f-71c7-4a63-86cb-0badba727457', '03', 'b2b08768-0891-4a55-ac4a-6d6a0a8120f8', '1', '02', '2017-08-19 12:41:20', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('e54791a3-d7e6-4b8a-85c6-7e6f867b4a7e', '01', 'b6fdfef4-4df1-490e-94f0-796b94159cba', '1', '02', '2017-08-13 10:37:41', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('eb7c736d-d2d4-4956-b4fb-bc779a65df36', '01', 'ecefcdb5-c92d-470b-8822-d6413f9a8d44', '-1', '102', '2017-09-10 13:45:17', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('eea728a6-f0f5-45fe-8af6-5c54e6572c1a', '03', 'ff4dd509-407e-4e51-ae95-838b745e90bf', '-1', '102', '2017-08-27 13:03:24', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('f1d0a617-3ebc-4ced-b036-e1fe1d3ed4b6', '03', 'd7b99af1-bf04-43ce-9fbe-2f9149a323ec', '1', '02', '2017-08-22 15:06:23', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('f43ba1af-e845-4941-bcdc-bf4c69690abf', '01', '2d08077d-d19d-4eef-9a7b-b4017462dedc', '3', '03', '2017-08-13 10:40:38', '1', '审核通过', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('f608bf45-6edb-4297-8407-d147f7c0ea3e', '04', 'b2634079-f77c-4ea8-8703-95239bab7137', '1', '100', '2017-09-02 00:29:24', '1', '提交审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('f8d95491-81cc-45d1-8ab9-fc9cee1e3857', '03', '2ff3e658-4c6e-4f11-9423-ebee137b7f92', '1', '02', '2017-08-26 22:15:01', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('f974e87e-5702-4d4e-a593-d526648c83db', '03', 'ff4dd509-407e-4e51-ae95-838b745e90bf', '1', '100', '2017-08-27 12:47:59', '1', '待审核', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('f9c9bdb6-00df-4921-973f-ce2acf55417c', '03', '2ff3e658-4c6e-4f11-9423-ebee137b7f92', '-1', '04', '2017-08-26 22:15:36', '1', '已结束', null);
INSERT INTO `t_contract_sys_flowset_data` VALUES ('fa34678d-11a9-47dc-8817-50e96280c371', '03', '0e789238-18cc-4649-bc91-85faaefc7e29', '-1', '04', '2017-08-19 02:01:32', '1', '已结束', null);

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
INSERT INTO `t_contract_sys_permission` VALUES ('0', '权限与菜单 ', '权限与菜单管理', '-1', '1', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '', '0');
INSERT INTO `t_contract_sys_permission` VALUES ('100', '用户管理', '用户管理', '0', '2', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '', '100');
INSERT INTO `t_contract_sys_permission` VALUES ('101', '基本信息', '基本信息', '100', '3', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '/users/index', '101');
INSERT INTO `t_contract_sys_permission` VALUES ('103', '修改', '修改', '101', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnModify', '103');
INSERT INTO `t_contract_sys_permission` VALUES ('104', '删除', '删除', '101', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnDelete', '104');
INSERT INTO `t_contract_sys_permission` VALUES ('105', '新增', '新增', '101', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnNew', '105');
INSERT INTO `t_contract_sys_permission` VALUES ('106', '导出', '导出', '101', '4', null, '1', '2017-08-28 22:06:24', null, '2017-08-28 22:06:28', null, 'btnExport', '106');
INSERT INTO `t_contract_sys_permission` VALUES ('110', '请假信息', '请假信息', '100', '3', '', '1', '2017-08-19 18:09:26', '', '2017-08-19 18:11:34', '', '/userleaves/index', '110');
INSERT INTO `t_contract_sys_permission` VALUES ('111', '新建', '新建', '110', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnNew', '111');
INSERT INTO `t_contract_sys_permission` VALUES ('112', '修改', '修改', '110', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnModify', '112');
INSERT INTO `t_contract_sys_permission` VALUES ('113', '删除', '删除', '110', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnDelete', '113');
INSERT INTO `t_contract_sys_permission` VALUES ('114', '查看', '查看', '110', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnDetail', '114');
INSERT INTO `t_contract_sys_permission` VALUES ('120', '请假审核', '请假审核', '100', '3', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '/userleavesexamine/index', '120');
INSERT INTO `t_contract_sys_permission` VALUES ('130', '批次管理', '批次管理', '0', '2', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '/batch/index', '130');
INSERT INTO `t_contract_sys_permission` VALUES ('131', '起草合同', '起草合同', '130', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnDraftContract', '131');
INSERT INTO `t_contract_sys_permission` VALUES ('132', '发起任务', '发起任务', '130', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnAddTask', '132');
INSERT INTO `t_contract_sys_permission` VALUES ('133', '新建', '新建', '130', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnAddBatch', '133');
INSERT INTO `t_contract_sys_permission` VALUES ('134', '修改', '修改', '130', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnModifyBatch', '134');
INSERT INTO `t_contract_sys_permission` VALUES ('135', '删除', '删除', '130', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnDeletebatch', '135');
INSERT INTO `t_contract_sys_permission` VALUES ('136', '详情', '详情', '130', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnViewDetail', '136');
INSERT INTO `t_contract_sys_permission` VALUES ('137', '复制', '复制', '130', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnCopyBatch', '137');
INSERT INTO `t_contract_sys_permission` VALUES ('138', '归档', '归档', '130', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnFileBatch', '138');
INSERT INTO `t_contract_sys_permission` VALUES ('139', '导出', '导出', '130', '4', null, '1', '2017-08-26 04:12:49', null, '2017-08-26 04:12:54', null, 'btnExport', '139');
INSERT INTO `t_contract_sys_permission` VALUES ('140', '导入', '导入', '130', '4', null, '1', '2017-08-26 04:13:59', null, '2017-08-26 04:13:41', null, 'btnImport', '140');
INSERT INTO `t_contract_sys_permission` VALUES ('141', '批量删除', '批量删除', '130', '4', null, '1', '2017-09-01 22:54:14', null, '2017-09-01 22:54:19', null, 'btnBatchDelete', '141');
INSERT INTO `t_contract_sys_permission` VALUES ('150', '任务管理', '任务管理', '0', '2', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '', '150');
INSERT INTO `t_contract_sys_permission` VALUES ('160', '项目任务', '项目任务', '150', '3', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '/task/index', '160');
INSERT INTO `t_contract_sys_permission` VALUES ('161', '详情', '详情', '160', '4', '', '1', '2017-08-20 11:35:43', '', '2017-08-19 18:11:34', '', 'btnDetail', '161');
INSERT INTO `t_contract_sys_permission` VALUES ('162', '提交审核', '提交审核', '160', '4', null, '1', '2017-08-20 11:36:47', null, '2017-08-20 11:36:18', null, 'btnSubmit', '162');
INSERT INTO `t_contract_sys_permission` VALUES ('163', '删除', '删除', '160', '4', null, '1', '2017-08-20 13:16:10', null, '2017-08-20 11:37:10', null, 'btnDelete', '163');
INSERT INTO `t_contract_sys_permission` VALUES ('164', '检测', '检测', '160', '4', null, '1', '2017-08-20 13:16:08', null, '2017-08-20 11:38:29', null, 'btnExamine', '164');
INSERT INTO `t_contract_sys_permission` VALUES ('170', '项目任务审核', '项目任务审核', '150', '3', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '/taskExamine/index', '170');
INSERT INTO `t_contract_sys_permission` VALUES ('200', '耗材管理', '耗材管理', '0', '2', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '', '200');
INSERT INTO `t_contract_sys_permission` VALUES ('201', '公共仓库', '公共仓库', '200', '3', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '/supply/index', '201');
INSERT INTO `t_contract_sys_permission` VALUES ('202', '新建', '新建', '201', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnAdd', '202');
INSERT INTO `t_contract_sys_permission` VALUES ('205', '详情', '详情', '201', '4', '', '1', '2017-09-01 23:12:21', '', '2017-08-19 18:11:34', '', 'btnDetail', '205');
INSERT INTO `t_contract_sys_permission` VALUES ('206', '导出', '导出', '201', '4', null, '1', '2017-09-01 23:12:45', null, '2017-09-01 23:12:32', null, 'btnExport', '206');
INSERT INTO `t_contract_sys_permission` VALUES ('210', '耗材领用管理', '耗材领用管理', '200', '3', '', '1', '2017-08-22 13:19:24', '', '2017-08-19 18:11:34', '', '/supplyTotal/index', '210');
INSERT INTO `t_contract_sys_permission` VALUES ('211', '领取', '领取', '210', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnLqb', '211');
INSERT INTO `t_contract_sys_permission` VALUES ('212', '申买', '申买', '210', '4', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', 'btnGmb', '212');
INSERT INTO `t_contract_sys_permission` VALUES ('213', '报损', '报损', '210', '4', '', '1', '2017-08-19 18:14:11', '', '2017-08-19 18:11:34', '', 'btnShb', '213');
INSERT INTO `t_contract_sys_permission` VALUES ('214', '详情', '详情', '210', '4', null, '1', '2017-08-26 23:11:03', null, '2017-08-26 23:11:07', null, 'btnDetail', null);
INSERT INTO `t_contract_sys_permission` VALUES ('230', '领用记录', '领用记录', '200', '3', '', '1', '2017-08-27 12:55:52', '', '2017-08-19 18:11:34', '', '/supplyTotalDetailInfo/index', '230');
INSERT INTO `t_contract_sys_permission` VALUES ('240', '耗材领取审核', '耗材领取审核', '200', '3', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '/lqbExamine/index', '240');
INSERT INTO `t_contract_sys_permission` VALUES ('250', '耗材购买审核', '耗材购买审核', '200', '3', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '/gmbExamine/index', '250');
INSERT INTO `t_contract_sys_permission` VALUES ('260', '耗材损坏审核', '耗材损坏审核', '200', '3', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '/shbExamine/index', '260');
INSERT INTO `t_contract_sys_permission` VALUES ('300', '客户管理', '客户管理', '0', '2', null, '1', '2017-08-20 20:24:36', null, '2017-08-20 20:24:24', null, null, '300');
INSERT INTO `t_contract_sys_permission` VALUES ('301', '客户档案信息', '客户档案信息', '300', '3', null, '1', '2017-08-20 21:03:06', null, '2017-08-20 20:25:16', null, '/custom/index', '301');
INSERT INTO `t_contract_sys_permission` VALUES ('302', '新增', '新增', '301', '4', null, '1', '2017-08-20 20:26:01', null, '2017-08-20 20:26:06', null, 'btnAdd', '302');
INSERT INTO `t_contract_sys_permission` VALUES ('303', '修改', '修改', '301', '4', null, '1', '2017-08-20 21:12:00', null, '2017-08-20 20:26:47', null, 'btnModify', '303');
INSERT INTO `t_contract_sys_permission` VALUES ('304', '删除', '删除', '301', '4', null, '1', '2017-08-20 21:12:01', null, '2017-08-20 20:27:25', null, 'btnDelete', '304');
INSERT INTO `t_contract_sys_permission` VALUES ('305', '详情', '详情', '301', '4', null, '1', '2017-08-20 21:12:03', null, '2017-08-20 20:28:10', null, 'btnDetail', '305');
INSERT INTO `t_contract_sys_permission` VALUES ('306', '新建帐户', '新建帐户', '301', '4', null, '1', '2017-08-26 07:21:51', null, '2017-08-26 07:21:54', null, 'btnAddAccount', '306');
INSERT INTO `t_contract_sys_permission` VALUES ('307', '客户账户信息', '客户账户信息', '300', '3', null, '1', '2017-08-26 10:45:19', null, '2017-08-26 10:45:22', null, '/customAccount/index', '307');
INSERT INTO `t_contract_sys_permission` VALUES ('308', '修改', '修改', '307', '4', null, '1', '2017-08-26 10:47:20', null, '2017-08-26 10:46:19', null, 'btnModify', '308');
INSERT INTO `t_contract_sys_permission` VALUES ('309', '删除', '删除', '307', '4', null, '1', '2017-08-26 10:47:46', null, '2017-08-26 10:47:03', null, 'btnDelete', '309');
INSERT INTO `t_contract_sys_permission` VALUES ('310', '详情', '详情', '307', '4', null, '1', '2017-08-26 10:48:01', null, '2017-08-26 10:47:52', null, 'btnDetail', '310');
INSERT INTO `t_contract_sys_permission` VALUES ('320', '培训管理', '培训管理', '0', '2', null, '1', '2017-09-10 15:02:07', null, '2017-09-10 15:02:11', null, null, '320');
INSERT INTO `t_contract_sys_permission` VALUES ('321', '进修培训管理', '进修培训管理', '320', '3', null, '1', '2017-09-10 15:22:02', null, '2017-09-10 15:03:09', null, '/pxglInfo/index', '321');
INSERT INTO `t_contract_sys_permission` VALUES ('322', '新建', '新建', '321', '4', null, '1', '2017-09-10 15:23:14', null, '2017-09-10 15:04:14', null, 'btnAdd', '322');
INSERT INTO `t_contract_sys_permission` VALUES ('323', '修改', '修改', '321', '4', null, '1', '2017-09-10 15:23:37', null, '2017-09-10 15:23:42', null, 'btnModify', '323');
INSERT INTO `t_contract_sys_permission` VALUES ('324', '删除', '删除', '321', '4', null, '1', '2017-09-10 15:24:51', null, '2017-09-10 15:24:32', null, 'btnDelete', '324');
INSERT INTO `t_contract_sys_permission` VALUES ('328', '进修培训审核', '进修培训审核', '320', '3', null, '1', '2017-09-10 15:05:32', null, '2017-09-10 15:05:10', null, '/pxglExamineInfo/index', '328');
INSERT INTO `t_contract_sys_permission` VALUES ('330', '个人进行培训信息', '个人进行培训信息', '320', '3', null, '1', '2017-09-10 15:27:00', null, '2017-09-10 15:26:18', null, '/personPxgl/index', '330');
INSERT INTO `t_contract_sys_permission` VALUES ('350', '合同管理', '合同管理', '0', '2', null, '1', '2017-08-22 17:59:32', null, '2017-08-22 17:58:35', null, '/contractInfo/index', '350');
INSERT INTO `t_contract_sys_permission` VALUES ('351', '新增', '新增', '350', '4', null, '1', '2017-08-22 17:59:56', null, '2017-08-22 17:59:41', null, 'btnAdd', '351');
INSERT INTO `t_contract_sys_permission` VALUES ('352', '删除', '删除', '350', '4', null, '1', '2017-08-22 18:00:15', null, '2017-08-22 18:00:20', null, 'btnDelete', '352');
INSERT INTO `t_contract_sys_permission` VALUES ('353', '修改', '修改', '350', '4', null, '1', '2017-08-22 18:00:54', null, '2017-08-22 18:00:59', null, 'btnModify', '353');
INSERT INTO `t_contract_sys_permission` VALUES ('354', '提交审核', '提交审核', '350', '4', null, '1', '2017-08-27 13:36:49', null, '2017-08-27 13:36:40', null, 'btnSubmit', '354');
INSERT INTO `t_contract_sys_permission` VALUES ('355', '合同审核', '合同审核', '0', '2', null, '1', '2017-08-27 15:57:11', null, '2017-08-27 15:51:54', null, '/contractInfoExamine/index', '355');
INSERT INTO `t_contract_sys_permission` VALUES ('356', '详情', '详情', '350', '4', null, '1', '2017-08-27 18:13:17', null, '2017-08-27 18:13:21', null, 'btnDetail', '356');
INSERT INTO `t_contract_sys_permission` VALUES ('357', '导出', '导出', '350', '4', null, '1', '2017-09-02 10:12:28', null, '2017-09-02 10:12:33', null, 'btnExport', '357');
INSERT INTO `t_contract_sys_permission` VALUES ('9000', '系统管理', '系统管理', '0', '2', '', '1', '2017-08-19 18:11:34', '', '2017-08-19 18:11:34', '', '', '9000');
INSERT INTO `t_contract_sys_permission` VALUES ('9010', '部门管理', '部门管理', '9000', '3', '', '1', '2017-08-19 18:13:52', '', '2017-08-19 18:11:34', '', '/departments/index', '9010');
INSERT INTO `t_contract_sys_permission` VALUES ('9020', '字典表管理', '字典表管理', '9000', '3', '', '1', '2017-08-19 18:13:52', '', '2017-08-19 18:11:34', '', '/zdbs/index', '9020');
INSERT INTO `t_contract_sys_permission` VALUES ('9030', '字典表详情', '字典表详情', '9000', '3', '', '1', '2017-08-19 18:13:53', '', '2017-08-19 18:11:34', '', '/zdbdetail/index', '9030');
INSERT INTO `t_contract_sys_permission` VALUES ('9040', '权限管理', '权限管理', '9000', '3', '', '1', '2017-08-19 18:13:54', '', '2017-08-19 18:11:34', '', '/permissions/index', '9040');
INSERT INTO `t_contract_sys_permission` VALUES ('9050', '流程设置', '流程设置', '9000', '3', '', '1', '2017-08-19 18:13:59', '', '2017-08-19 18:11:34', '', '/flowset/index', '9050');
INSERT INTO `t_contract_sys_permission` VALUES ('9060', '分析项管理', '分析项管理', '9000', '3', null, '1', '2017-08-19 22:26:18', null, '2017-08-19 22:26:22', null, '/fxxmInfo/index', '9060');

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
INSERT INTO `t_contract_sys_role` VALUES ('02d79cb6-6437-4f09-9ff5-8b56f7940cc0', '耗材审核2', '耗材审核2', null, '1', '2017-08-26 19:47:35', '1', '2017-08-26 19:47:36', '1', '10');
INSERT INTO `t_contract_sys_role` VALUES ('1', '系统管理员', '系统管理员', '1', '1', '2017-08-26 19:40:31', null, '2017-08-26 19:40:32', '1', '1');
INSERT INTO `t_contract_sys_role` VALUES ('2df0c66f-9d5a-4a73-bc33-45ce6e93a80c', '耗材审核1', '耗材审核1', null, '1', '2017-08-26 19:46:58', '1', '2017-08-26 19:46:58', '1', '3');
INSERT INTO `t_contract_sys_role` VALUES ('424bdd51-c051-4372-af15-63e7281fb53b', '合同管理', '合同管理', null, '1', '2017-08-26 19:47:02', '1', '2017-08-26 19:47:03', '1', '4');
INSERT INTO `t_contract_sys_role` VALUES ('593a3814-95fd-44a5-9dc3-54ba9e975b01', '样品审核', '样品审核', null, '1', '2017-08-26 19:47:07', '1', '2017-08-26 19:47:08', '1', '5');
INSERT INTO `t_contract_sys_role` VALUES ('6ecefc16-fa74-4f14-95ac-cb181fe1fe42', '报告批准', '报告批准', null, '1', '2017-08-26 19:47:12', '1', '2017-08-26 19:47:13', '1', '6');
INSERT INTO `t_contract_sys_role` VALUES ('888a5e99-f208-4a4e-8257-3d3980d4a3de', '合同审核', '合同审核', null, '1', '2017-08-26 19:47:18', '1', '2017-08-26 19:47:19', '1', '7');
INSERT INTO `t_contract_sys_role` VALUES ('90efc372-be92-41a6-bd9e-a63e9318dad3', '样品输入', '样品输入', null, '1', '2017-08-26 19:47:24', '1', '2017-08-26 19:47:25', '1', '8');
INSERT INTO `t_contract_sys_role` VALUES ('946e4674-8d0c-4f33-a806-a407fb7430fa', '实验室管理', '实验室管理', null, '1', '2017-08-26 19:47:29', '1', '2017-08-26 19:47:30', '1', '9');
INSERT INTO `t_contract_sys_role` VALUES ('f6296c35-b9ef-4cfd-bee7-013038cada75', '样品检测人员', '样品检测人员', null, '1', '2017-08-26 19:46:52', '1', '2017-08-26 19:46:52', '1', '2');

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
INSERT INTO `t_contract_sys_role_permission` VALUES ('051a8cb3-9a1d-4b29-ac19-e2406413af9a', '240', '2df0c66f-9d5a-4a73-bc33-45ce6e93a80c');
INSERT INTO `t_contract_sys_role_permission` VALUES ('0c194669-a73f-4a90-8888-5fc200f2807f', '101', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('0d4e120d-22af-41c1-b063-df009227605d', '9040', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('0f75da8f-b685-40e1-8dca-6eefaf6af388', '133', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('123f1903-5338-402c-8f87-aa56def5e498', '230', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('129ea517-4b33-4c14-a076-b376a8ebf47b', '120', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('15820232-16ac-47bd-91e5-9f89c9115a9d', '213', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('15890e4b-0824-439e-ac1d-1d390b618fce', '308', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('1646aac9-dcb2-4d04-8ed3-936148c95539', '9000', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('1989e10a-be1e-4069-8a1b-a97149024379', '353', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('1b88fa00-f231-4d25-80ea-b33ec371ca4b', '205', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('1c583642-c2ed-422c-8cac-6d87334f5e97', '9020', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('1d19e27e-1b06-489e-aaa7-b57b11953ad1', '0', '946e4674-8d0c-4f33-a806-a407fb7430fa');
INSERT INTO `t_contract_sys_role_permission` VALUES ('1e3c7c0a-e9a6-4c52-8c2f-3a016dd07bb3', '114', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('1e6d86ca-b9be-482e-9b20-d38fd4e5073c', '250', '2df0c66f-9d5a-4a73-bc33-45ce6e93a80c');
INSERT INTO `t_contract_sys_role_permission` VALUES ('1fa54cda-fb94-4912-a978-e9a039ef8bca', '150', '593a3814-95fd-44a5-9dc3-54ba9e975b01');
INSERT INTO `t_contract_sys_role_permission` VALUES ('203fa11c-0d13-40b8-8f02-18b6be94ede2', '210', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('216e62ce-e949-4832-b227-d6bce65cd3c0', '320', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('245cc769-1f57-48d3-9612-a467445655da', '200', '2df0c66f-9d5a-4a73-bc33-45ce6e93a80c');
INSERT INTO `t_contract_sys_role_permission` VALUES ('257e2023-8381-40da-8909-f5442823b0cd', '9060', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('27c8ad4f-4bb4-4c17-8a59-0c1fa09ef09f', '164', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('2813fa89-3715-49d3-be99-737d0c391e20', '0', '02d79cb6-6437-4f09-9ff5-8b56f7940cc0');
INSERT INTO `t_contract_sys_role_permission` VALUES ('2e580cc5-9586-4081-a033-c0a039beca28', '0', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('2fe772fe-bdb0-4a43-9fb3-e781cf5a508b', '111', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('31422df2-f03d-41be-9291-026e8823c2af', '130', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('31fb1315-e683-4936-b3ba-ea8655aba39c', '9010', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('3e644268-4ffd-4fbe-8741-72def9e8902a', '260', '2df0c66f-9d5a-4a73-bc33-45ce6e93a80c');
INSERT INTO `t_contract_sys_role_permission` VALUES ('3f60fb1e-5aca-43f1-8480-975ebdc2f8da', '200', '02d79cb6-6437-4f09-9ff5-8b56f7940cc0');
INSERT INTO `t_contract_sys_role_permission` VALUES ('4110e045-dd5b-4ad6-bbe4-353175270a2b', '162', 'f6296c35-b9ef-4cfd-bee7-013038cada75');
INSERT INTO `t_contract_sys_role_permission` VALUES ('44b447cd-9c4d-443a-8f27-a19eb1acee40', '306', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('4b146568-0b5c-4956-89cf-087f0cfef80b', '131', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('4b46c20b-7981-4f58-b338-a4a07b909395', '356', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('4df5b9e7-0da0-4d75-aef8-9547758b1e68', '161', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('5a1c8bfe-959a-423e-8ae0-173d12910d6d', '260', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('5b52760a-d616-419d-a851-204f433932a4', '150', 'f6296c35-b9ef-4cfd-bee7-013038cada75');
INSERT INTO `t_contract_sys_role_permission` VALUES ('5cf7a4a4-ca2a-49e5-92a9-ec8ee06a32b2', '305', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('61822eb5-e16f-46ef-b510-419307dc952f', '0', '6ecefc16-fa74-4f14-95ac-cb181fe1fe42');
INSERT INTO `t_contract_sys_role_permission` VALUES ('67fc55c4-3b04-4c45-b981-e68a47947bb4', '163', 'f6296c35-b9ef-4cfd-bee7-013038cada75');
INSERT INTO `t_contract_sys_role_permission` VALUES ('6c817c5e-7e46-48ce-8c80-505145e870db', '324', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('6d1f8607-ea78-4afe-9718-69592622fb39', '106', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('6d69ff1c-14f7-4d77-a36e-f7246bad77bc', '132', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('7216d98e-a0f6-464f-a185-bae7f1173bac', '103', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('7c6328d7-6531-485a-9a6e-7418271e6a93', '301', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('7f94f856-0c8c-42c7-b17d-56602dc95cd7', '137', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('814462b0-a097-4864-88c4-1ff5a9dd11c3', '355', '6ecefc16-fa74-4f14-95ac-cb181fe1fe42');
INSERT INTO `t_contract_sys_role_permission` VALUES ('81e5fd2a-466c-43a0-a08f-c42c290fdeb4', '322', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('82e66363-4763-4a2f-8f84-132711cc5fcb', '240', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('85769397-add8-45d0-9400-26aa29dbaa3d', '214', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('8632b9bf-2f25-4d16-9979-40a9abc0fc4c', '135', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('86dcff35-ade6-4d8d-b43e-a407e75998f0', '9050', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('87572446-1bb0-4efa-afe1-3b395a847afc', '355', '946e4674-8d0c-4f33-a806-a407fb7430fa');
INSERT INTO `t_contract_sys_role_permission` VALUES ('88eed92a-4f57-4d9a-90d5-b0b2c894eafc', '100', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('8c0ca200-2020-4e81-9618-034a536fecc1', '357', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('8cbf3d6e-ad0d-48db-a854-4d21a8e97185', '134', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('8e002d60-6c4e-4ea9-9a7e-a89ad0b9e6f2', '302', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('921cb68e-8b33-4431-a624-9c66afefcfc4', '162', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('97779e25-be7a-4f95-a9c6-6d90f0abeda5', '240', '02d79cb6-6437-4f09-9ff5-8b56f7940cc0');
INSERT INTO `t_contract_sys_role_permission` VALUES ('9df12bc7-5911-4043-ae96-aaa812e8a293', '139', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('9f8a391b-6a5d-429d-91e8-823c992c279f', '200', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('a3d060f5-13e9-49cc-a168-73d6cde8e65f', '351', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('a3e7d955-ac8e-408b-b550-9318f4eea715', '160', 'f6296c35-b9ef-4cfd-bee7-013038cada75');
INSERT INTO `t_contract_sys_role_permission` VALUES ('a4ff97ee-795e-4e8c-8dfb-94f7d90bad8c', '161', 'f6296c35-b9ef-4cfd-bee7-013038cada75');
INSERT INTO `t_contract_sys_role_permission` VALUES ('a55204f0-5c49-4c77-9475-30a5c765cfca', '105', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('a6d063de-2f7d-4e3d-8ffe-2d08d99fefd5', '328', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('ac168278-d123-4eec-a169-1cc9da0b5cea', '206', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('ad3dd948-78cd-4dcf-8e79-ca6b48d84e6f', '150', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('ad7e0f2f-e58b-4890-8d00-4e881c5ac112', '352', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('ae52e2c1-08e7-4c24-b6ff-e454deb8abdd', '212', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('af4f03b8-3a1c-4419-9335-4fbc267e203d', '164', 'f6296c35-b9ef-4cfd-bee7-013038cada75');
INSERT INTO `t_contract_sys_role_permission` VALUES ('b01ced46-7cb0-4f88-8603-16dfa1bf6918', '170', '593a3814-95fd-44a5-9dc3-54ba9e975b01');
INSERT INTO `t_contract_sys_role_permission` VALUES ('b074f823-8776-41d7-8d73-cd122a4307cf', '113', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('b42f879a-0de7-45a5-a150-39a10c10f92c', '350', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('b6e76875-7c18-46b1-9445-339d71e01d9e', '354', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('b76c5456-7ec4-4808-bdf3-fc9f679c10e8', '0', '2df0c66f-9d5a-4a73-bc33-45ce6e93a80c');
INSERT INTO `t_contract_sys_role_permission` VALUES ('b9f1bcb9-0d16-40ff-a4a9-a1f7d9a2f7d1', '140', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('bb4d2981-4cae-4b86-bad9-6f429a7c20c4', '0', '593a3814-95fd-44a5-9dc3-54ba9e975b01');
INSERT INTO `t_contract_sys_role_permission` VALUES ('c3bf2c6b-f676-4cd6-8c0b-5c2d48dafb92', '325', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('cb334b7e-4d75-435e-9d94-12c6676a0345', '138', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('cbbbab1c-4981-406e-b532-14a1f1e6a481', '160', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('cc544a3f-a070-4c1b-ba7b-19a853f6fa9e', '250', '02d79cb6-6437-4f09-9ff5-8b56f7940cc0');
INSERT INTO `t_contract_sys_role_permission` VALUES ('ce096250-469d-4325-aef8-7d36d5bf2d10', '112', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('cecb6ec6-736e-4f60-99c5-22d1f1beee82', '250', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('d03e0f19-8736-48a0-8302-d308aa8394de', '170', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('d11eb306-3056-4172-97fd-b25f3992fb95', '163', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('d1bbdb5a-d568-4798-af7d-24e5f052ad6f', '304', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('d35fa82b-92eb-41ac-8ec0-91db00aa532b', '300', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('d9269316-0727-4e0e-bbf1-5197df2361f0', '0', 'f6296c35-b9ef-4cfd-bee7-013038cada75');
INSERT INTO `t_contract_sys_role_permission` VALUES ('e46e647e-3cb9-426b-963b-c4271e52a11f', '303', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('e53a14a3-8ed7-4b4e-a251-8690458cb61e', '310', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('e8f8d43f-c15c-450d-ab1a-36a9964d9beb', '330', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('e9ff56fd-21a8-44c7-bf82-b689bb28643e', '136', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('ec1e193e-0fb0-4287-bba7-17984e27cf24', '201', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('ec311a81-2986-4734-b7e6-55f6c0952071', '9030', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('ede98f57-e959-4c20-bbd1-1730013b7515', '202', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('eed2ea52-e714-46ba-807a-05cb94be2f5b', '211', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('f3476cb1-bff2-477f-9420-44dda9e3b27c', '321', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('f39d79b9-b0ea-40ba-b94f-1418d782fce2', '141', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('f8c1f516-93d7-4aa2-adb5-0fa364105281', '323', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('fd2d892e-14bb-4ff5-8ad0-882fba222176', '110', '1');
INSERT INTO `t_contract_sys_role_permission` VALUES ('fd48378a-ba8a-44c1-ac22-eb3bfb65c10e', '260', '02d79cb6-6437-4f09-9ff5-8b56f7940cc0');
INSERT INTO `t_contract_sys_role_permission` VALUES ('feb878e5-7819-4012-b21b-a3d455cfa97b', '307', '1');

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
  `CAN_DELETE` int(11) DEFAULT NULL COMMENT '是否可删除',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表管理';

-- ----------------------------
-- Records of t_contract_sys_zdbs
-- ----------------------------
INSERT INTO `t_contract_sys_zdbs` VALUES ('009404f1-5eff-4dd2-b4e9-2d3ae99bd9ac', 'T_CONTRACT_SJZD_ZWLB', '职位类别', '1', '2017-06-03 15:43:46', '1', '2017-06-03 15:43:46', '1', '1', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('12150c72-bbf5-46a5-8361-4278fa45dcb4', '12', '12', '2', '2017-06-03 16:37:34', '1', '2017-06-03 16:37:35', '1', '1', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('2d602859-a4d2-4711-86bd-7136b5e6adc8', 'T_CONTRACT_SJZD_HTZK', '折扣表', '1', '2017-08-23 20:24:46', '1', '2017-08-23 20:24:46', '1', '22', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('348cf56b-a5e8-4b5d-9c07-82eaac65da34', 'T_CONTRACT_SJZD_HTZT', '合同状态', '1', '2017-08-26 03:48:36', '1', '2017-08-25 22:48:25', '1', '35', '1');
INSERT INTO `t_contract_sys_zdbs` VALUES ('423558da-34df-433d-acc4-e3140ef4a1b3', 'T_CONTRACT_SJZD_PXLX', '培训类型', '1', '2017-09-10 15:32:23', '1', '2017-09-10 15:32:23', '1', '50', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('53f6d6c2-7b11-415f-a7e0-b9ada5423877', 'T_CONTRACT_SJZD_TASKSTATUS', '任务状态', '1', '2017-08-26 03:48:38', '1', '2017-08-13 21:39:20', '1', '11', '1');
INSERT INTO `t_contract_sys_zdbs` VALUES ('619316a5-f631-4145-a827-b89b8240ddf6', 'T_CONTRACT_SJZD_SYDW', '送样单位', '1', '2017-08-19 21:13:14', '1', '2017-08-19 21:13:14', '1', '20', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('61cf9093-bbae-4301-b7c8-25cc48321472', 'T_CONTRACT_SJZD_PCZT', '批次状态', '1', '2017-08-26 03:48:39', '1', '2017-08-13 16:09:52', '1', '8', '1');
INSERT INTO `t_contract_sys_zdbs` VALUES ('7b6a12e4-b44a-465c-aa67-810458da024d', 'T_CONTRACT_SJZD_HTZT', '合同状态', '2', '2017-08-26 03:48:42', '1', '2017-08-25 22:48:43', '1', '35', '1');
INSERT INTO `t_contract_sys_zdbs` VALUES ('819f6f4b-e8cf-46d3-94cb-7c3738c04e37', 'T_CONTRACT_SJZD_TASKSTATUS_DETAIL', '子任务任务状态', '1', '2017-08-26 03:48:56', '1', '2017-08-14 13:18:29', '1', '15', '1');
INSERT INTO `t_contract_sys_zdbs` VALUES ('8460c0a5-b599-4f89-9c25-51968f5443c7', 'T_CONTRACT_SJZD_HCFL', '耗材分类', '1', '2017-08-16 20:42:06', '1', '2017-08-16 20:42:06', '1', '13', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('8e83da42-29f7-493b-bb08-be897f4b6446', 'T_CONTRACT_SJZD_HBDW', '货币单位', '1', '2017-08-13 16:08:45', '1', '2017-08-13 16:08:45', '1', '4', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('8f3ea749-2773-460b-b5ac-be0a809c70a9', 'T_CONTRACT_SJZD_PP', '品牌', '1', '2017-08-13 16:08:59', '1', '2017-08-13 16:08:59', '1', '5', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('91c58606-d1c6-4341-8c80-5c3bb4c3453f', 'T_CONTRACT_SJZD_YPCFD', '样品存放地', '1', '2017-08-13 16:09:29', '1', '2017-08-13 16:09:29', '1', '7', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('92d6066d-9c0b-4c67-a1fb-a264ce8db1d4', 'T_CONTRACT_SJZD_PCLB', '批次类别', '1', '2017-08-13 16:08:29', '1', '2017-08-13 16:08:29', '1', '3', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('b27da1ea-1c3b-44b1-a114-79e6de342aff', '12', '3', '2', '2017-06-03 16:35:37', '1', '2017-06-03 16:35:38', '1', '1', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('c8dcf178-1dff-492d-bab0-34ad83622627', 'T_CONTRACT_SJZD_QJLX', '请假类型', '1', '2017-06-04 18:38:37', '1', '2017-06-04 18:38:37', '1', '2', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('d29a1cd0-5735-4d89-83d3-7582573ef864', '12', '123', '2', '2017-06-03 16:00:24', '1', '2017-06-03 16:00:25', '1', '2345', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('d4f8320b-41ca-4633-afd2-016b5b93b49b', 'T_CONTRACT_SJZD_CUSTOM_TYPE', '客户类别', '1', '2017-08-20 19:10:26', '1', '2017-08-20 19:10:26', '1', '21', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('d5af10b0-d874-41e7-8c01-9becc2611078', 'T_CONTRACT_SJZD_HTLX', '合同类型', '1', '2017-08-25 21:21:29', '1', '2017-08-25 21:21:29', '1', '32', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('e2414fbb-32b7-4a96-88f9-c1151b0bf829', 'T_CONTRACT_SJZD_SLDW', '数量单位', '1', '2017-08-13 16:09:15', '1', '2017-08-13 16:09:15', '1', '6', null);
INSERT INTO `t_contract_sys_zdbs` VALUES ('ea1b5f93-3187-4449-91ad-5850a8aa7172', 'T_CONTRACT_SJZD_FXXM', 'fxxm', '2', '2017-08-26 03:43:11', '1', '2017-08-26 03:43:11', '1', '9', null);

-- ----------------------------
-- Table structure for `t_contract_task_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_task_detail`;
CREATE TABLE `t_contract_task_detail` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `RWLX` varchar(40) DEFAULT NULL COMMENT '任务类型',
  `YPBH` varchar(40) DEFAULT NULL COMMENT '样品编号',
  `FRWBH` varchar(40) DEFAULT NULL COMMENT '父任务编号',
  `RWBH` varchar(40) DEFAULT NULL COMMENT '任务编号',
  `YPPH` varchar(100) DEFAULT NULL COMMENT '样品批号',
  `YPYYBH` varchar(40) DEFAULT NULL COMMENT '样品原有编号',
  `YPXZ` varchar(100) DEFAULT NULL COMMENT '样品性质',
  `YPEWM` varchar(100) DEFAULT NULL COMMENT '样品二维码',
  `FXXM` varchar(100) DEFAULT NULL COMMENT '分析项目',
  `PCWID` varchar(40) DEFAULT NULL COMMENT '批次WID',
  `DQBH` int(11) DEFAULT NULL COMMENT '当前序号',
  `RWFPR` varchar(100) DEFAULT NULL COMMENT '任务分配人',
  `JSSJ` varchar(40) DEFAULT NULL COMMENT '结束时间',
  `RWZT` int(11) DEFAULT NULL COMMENT '任务状态',
  `DATASTATUS` varchar(10) DEFAULT NULL COMMENT '数据状态',
  `FRWID` varchar(40) DEFAULT NULL COMMENT '父任务ID',
  `PCXQID` varchar(40) DEFAULT NULL COMMENT '批次详情ID',
  PRIMARY KEY (`WID`),
  UNIQUE KEY `IDX_TASK_DETAIL_RWBH` (`RWBH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务信息详情';

-- ----------------------------
-- Records of t_contract_task_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `t_contract_task_main`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_task_main`;
CREATE TABLE `t_contract_task_main` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `RWLX` varchar(40) DEFAULT NULL COMMENT '任务类型',
  `RWMC` varchar(100) DEFAULT NULL COMMENT '任务名称',
  `RWBH` varchar(40) DEFAULT NULL COMMENT '任务编号',
  `YPPH` varchar(40) DEFAULT NULL COMMENT '样品批号',
  `FXXM` varchar(100) DEFAULT NULL COMMENT '分析项目',
  `RWFPR` varchar(100) DEFAULT NULL COMMENT '任务分配人',
  `JHKSSJ` varchar(40) DEFAULT NULL COMMENT '计划开始时间',
  `JHJSSJ` varchar(40) DEFAULT NULL COMMENT '计划结束时间',
  `SJKSSJ` varchar(40) DEFAULT NULL COMMENT '实际开始时间',
  `SJJSSJ` varchar(40) DEFAULT NULL COMMENT '实际结束时间',
  `RWSHR` varchar(40) DEFAULT NULL COMMENT '任务审核人',
  `SHWCSJ` varchar(40) DEFAULT NULL COMMENT '审核完成时间',
  `RWZT` int(11) DEFAULT NULL COMMENT '任务状态',
  `FJ` varchar(100) DEFAULT NULL COMMENT '附件',
  `BZ` varchar(400) DEFAULT NULL COMMENT '备注',
  `DQBH` int(11) DEFAULT NULL COMMENT '当前序号',
  `PCWID` varchar(40) DEFAULT NULL COMMENT '批次WID',
  `DATASTATUS` varchar(10) DEFAULT NULL COMMENT '数据状态',
  `CurrentStep` int(11) DEFAULT NULL COMMENT '当前步骤',
  PRIMARY KEY (`WID`),
  UNIQUE KEY `IDX_TASK_MAIN_RWBH2` (`RWBH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='样品任务信息';

-- ----------------------------
-- Records of t_contract_task_main
-- ----------------------------

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

-- ----------------------------
-- Table structure for `t_contract_user_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_contract_user_userinfo`;
CREATE TABLE `t_contract_user_userinfo` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `NAME1` varchar(40) DEFAULT NULL COMMENT '人员名称',
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
  `DATASTATUS` int(11) DEFAULT NULL COMMENT '状态',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CreateBy` varchar(40) DEFAULT NULL COMMENT '创建人',
  `UpdateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `UpdateBy` varchar(40) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`WID`),
  UNIQUE KEY `IDX_USER_USERINFO_GH` (`GH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员基本信息';

-- ----------------------------
-- Records of t_contract_user_userinfo
-- ----------------------------
INSERT INTO `t_contract_user_userinfo` VALUES ('1', '测试仪', '1', '12345', '17705181062', '123@qq.com', '2017-08-14', '002', '004', '123', '112', '123', '12', '2017-08-14', '1', '2017-08-28 13:31:11', null, '2017-08-28 13:31:11', '1');

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
INSERT INTO `t_contract_user_userinfo_role` VALUES ('11147d19-3179-44eb-8c7e-0f154803a5a1', '1', '2df0c66f-9d5a-4a73-bc33-45ce6e93a80c');
INSERT INTO `t_contract_user_userinfo_role` VALUES ('146f78de-902e-4e48-bfc4-d81a7dea5f07', '1', '424bdd51-c051-4372-af15-63e7281fb53b');
INSERT INTO `t_contract_user_userinfo_role` VALUES ('7c31ee3d-d193-4899-a90d-15ce5feedd32', '1', '593a3814-95fd-44a5-9dc3-54ba9e975b01');
INSERT INTO `t_contract_user_userinfo_role` VALUES ('9fd35123-cb06-4ba8-a954-589dc4c409f2', '1', '02d79cb6-6437-4f09-9ff5-8b56f7940cc0');
INSERT INTO `t_contract_user_userinfo_role` VALUES ('b9d27309-de21-48ca-8831-199d478e8bda', '1', '6ecefc16-fa74-4f14-95ac-cb181fe1fe42');
INSERT INTO `t_contract_user_userinfo_role` VALUES ('c3af6a6c-e471-4ea1-8086-416ff12626cf', '1', '946e4674-8d0c-4f33-a806-a407fb7430fa');
INSERT INTO `t_contract_user_userinfo_role` VALUES ('d6470480-814e-4e3a-8078-b4cd6a079f1d', '1', '90efc372-be92-41a6-bd9e-a63e9318dad3');
INSERT INTO `t_contract_user_userinfo_role` VALUES ('dde1bb4d-efb1-4c75-8987-21317f542a1a', '1', '888a5e99-f208-4a4e-8257-3d3980d4a3de');
INSERT INTO `t_contract_user_userinfo_role` VALUES ('e0287e3c-b792-4116-8218-1765747aa6a2', '1', '1');
INSERT INTO `t_contract_user_userinfo_role` VALUES ('eb58cd7f-1638-42aa-96e2-d090508103d2', '1', 'f6296c35-b9ef-4cfd-bee7-013038cada75');

-- ----------------------------
-- Table structure for `培训管理`
-- ----------------------------
DROP TABLE IF EXISTS `培训管理`;
CREATE TABLE `培训管理` (
  `WID` varchar(40) NOT NULL COMMENT 'WID',
  `PXLX` varchar(4) DEFAULT NULL COMMENT '培训类型',
  `PXMC` varchar(40) DEFAULT NULL COMMENT '培训名称',
  `BEGTIME` varchar(40) DEFAULT NULL COMMENT '培训开始时间',
  `ENDTIME` varchar(40) DEFAULT NULL COMMENT '培训结束时间',
  `PXFY` decimal(10,2) DEFAULT NULL COMMENT '培训费用',
  `BZ` varchar(400) DEFAULT NULL COMMENT '备注',
  `BY10` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY9` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY8` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY7` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY6` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY5` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY4` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY3` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY1` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `BY2` varchar(100) DEFAULT NULL COMMENT '备用字符段1',
  `CurrentStep` int(11) DEFAULT NULL COMMENT '当前步骤',
  `RWZT` int(11) DEFAULT NULL COMMENT '任务状态',
  PRIMARY KEY (`WID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 培训管理
-- ----------------------------
