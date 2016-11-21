/*
MySQL Backup
Source Server Version: 4.0.22
Source Database: zerodios
Date: 11/21/2016 17:13:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `web_category`
-- ----------------------------
DROP TABLE IF EXISTS `web_category`;
CREATE TABLE `web_category` (
  `ID` int(11) NOT NULL default '0',
  `NAME` varchar(255) default NULL,
  `PARENT` int(11) NOT NULL default '-1',
  `STATUS` tinyint(4) NOT NULL default '0',
  `VERSION` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ID`,`VERSION`)
) TYPE=MyISAM;

-- ----------------------------
--  Table structure for `web_event`
-- ----------------------------
DROP TABLE IF EXISTS `web_event`;
CREATE TABLE `web_event` (
  `ID` int(11) NOT NULL default '0',
  `TITLE` varchar(255) NOT NULL default '',
  `DESCRIPTION` varchar(255) NOT NULL default '',
  `STATUS` tinyint(4) NOT NULL default '0',
  `VERSION` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ID`,`VERSION`)
) TYPE=MyISAM;

-- ----------------------------
--  Table structure for `web_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `web_feedback`;
CREATE TABLE `web_feedback` (
  `ID` int(11) NOT NULL default '0',
  `TITLE` varchar(255) default NULL,
  `DESCRIPTION` varchar(255) default NULL,
  `STATUS` tinyint(4) NOT NULL default '0',
  `AUTHOR` int(11) NOT NULL default '0',
  `DATE` datetime NOT NULL default '0000-00-00 00:00:00',
  `VERSION` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ID`,`VERSION`)
) TYPE=MyISAM;

-- ----------------------------
--  Table structure for `web_gameinfo`
-- ----------------------------
DROP TABLE IF EXISTS `web_gameinfo`;
CREATE TABLE `web_gameinfo` (
  `ID` int(11) NOT NULL default '0',
  `MENU` int(11) NOT NULL default '0',
  `TITLE` varchar(255) NOT NULL default '',
  `CONTENT` varchar(255) NOT NULL default '',
  `STATUS` tinyint(4) NOT NULL default '0',
  `VERSION` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ID`,`VERSION`)
) TYPE=MyISAM;

-- ----------------------------
--  Table structure for `web_images`
-- ----------------------------
DROP TABLE IF EXISTS `web_images`;
CREATE TABLE `web_images` (
  `ID` int(11) NOT NULL default '0',
  `NAME` varchar(255) NOT NULL default '',
  `LOCATION` varchar(255) default NULL,
  `VERSION` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ID`,`VERSION`)
) TYPE=MyISAM;

-- ----------------------------
--  Table structure for `web_menu`
-- ----------------------------
DROP TABLE IF EXISTS `web_menu`;
CREATE TABLE `web_menu` (
  `ID` int(11) NOT NULL default '0',
  `NAME` varchar(255) NOT NULL default '',
  `PARENT` int(11) NOT NULL default '-1',
  `LINK` varchar(255) NOT NULL default '',
  `LEVEL` int(11) NOT NULL default '1',
  `STATUS` tinyint(4) NOT NULL default '0',
  `VERSION` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ID`,`VERSION`)
) TYPE=MyISAM;

-- ----------------------------
--  Table structure for `web_news`
-- ----------------------------
DROP TABLE IF EXISTS `web_news`;
CREATE TABLE `web_news` (
  `ID` int(11) NOT NULL default '0',
  `CATEGORY` int(11) NOT NULL default '0',
  `TITLE` varchar(255) NOT NULL default '',
  `DESCRIPTION` mediumtext,
  `AUTHOR` int(11) NOT NULL default '0',
  `DATE` datetime NOT NULL default '0000-00-00 00:00:00',
  `REMARK` int(11) default NULL,
  `PIN` tinyint(1) NOT NULL default '0',
  `STATUS` tinyint(4) NOT NULL default '0',
  `VERSION` bigint(8) NOT NULL default '0',
  PRIMARY KEY  (`ID`,`VERSION`)
) TYPE=MyISAM;

-- ----------------------------
--  Table structure for `web_recharge`
-- ----------------------------
DROP TABLE IF EXISTS `web_recharge`;
CREATE TABLE `web_recharge` (
  `ID` int(11) NOT NULL default '0',
  `ACCOUNT_ID` int(11) NOT NULL default '0',
  `AMOUNT` bigint(20) NOT NULL default '0',
  `DATE` datetime default NULL,
  `TYPE` int(11) NOT NULL default '0',
  `COMMENT` varchar(255) default NULL,
  `VERSION` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ID`,`VERSION`)
) TYPE=MyISAM;

-- ----------------------------
--  Table structure for `web_recharge_type`
-- ----------------------------
DROP TABLE IF EXISTS `web_recharge_type`;
CREATE TABLE `web_recharge_type` (
  `ID` int(11) NOT NULL default '0',
  `NAME` varchar(255) NOT NULL default '',
  `STATUS` tinyint(4) NOT NULL default '0',
  `VERSION` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ID`,`VERSION`)
) TYPE=MyISAM;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `web_menu` VALUES ('1','HomePage','-1','#','1','0','0'), ('2','Account','-1','#','1','0','0'), ('3','Support','-1','#','1','0','0'), ('4','Information','-1','#','1','0','0'), ('5','Event','-1','#','1','0','0'), ('6','Services','-1','#','1','0','0'), ('7','Community','-1','#','1','0','0'), ('8','Recharge','-1','#','1','0','0'), ('9','LogIn','2','#','2','0','0'), ('10','Register','2','#','2','0','0'), ('11','ForgotPassword','2','#','2','0','0'), ('12','AccountManagement','2','#','2','0','0'), ('13','Contact','3','#','2','0','0'), ('14','LockAccount','3','#','2','0','0'), ('15','UnlockAccount','3','#','2','0','0'), ('16','Newbie','4','#','2','0','0'), ('17','GameSystem','4','#','2','0','0'), ('18','GameDetail','4','#','2','0','0'), ('19','GameInterface','16','#','3','0','0'), ('20','GameAction','16','#','3','0','0'), ('21','FAQ','16','#','3','0','0'), ('22','Quest','16','#','3','0','0'), ('23','LevelUpGuide','16','#','3','0','0'), ('24','SkillGuide','16','#','3','0','0'), ('25','Robot','17','#','3','0','0'), ('26','Equipment','17','#','3','0','0'), ('27','Weapon','17','#','3','0','0'), ('28','Item','17','#','3','0','0'), ('29','NPC','17','#','3','0','0'), ('30','Map','17','#','3','0','0'), ('31','Mission','17','#','3','0','0'), ('32','Evolution','18','#','3','0','0'), ('33','Transform','18','#','3','0','0'), ('34','Core','18','#','3','0','0'), ('35','BP','18','#','3','0','0'), ('36','PKSystem','18','#','3','0','0'), ('37','GuildAndFleet','18','#','3','0','0'), ('38','Forum','7','#','2','0','0'), ('39','Facebook','7','#','2','0','0');
INSERT INTO `web_news` VALUES ('1','1','The Test News','<font size=\"5\">This </font><font size=\"3\">is </font><font size=\"1\">test </font><font size=\"5\"><b>news </b><font face=\"Comic Sans MS\">description</font></font><div><font size=\"5\" face=\"Tahoma\"><i>And </i><strike>this </strike><u>is </u>new line</font></div><div><ul><li><font face=\"Tahoma\" size=\"5\">bul1</font></li><li><font face=\"Tahoma\" size=\"5\">bul2</font></li></ul><font face=\"Tahoma\" size=\"5\"><ol><li>num1</li><li>num2</li></ol></font></div>','1000000','2016-07-08 13:57:32','1','1','1','9');
