-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: feature_selection_web
-- ------------------------------------------------------
-- Server version	5.5.62

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `account_id` int(11) NOT NULL,
  `account_name` varchar(30) NOT NULL,
  `account_password` varchar(255) NOT NULL,
  `account_email` varchar(50) NOT NULL,
  `account_power` int(6) NOT NULL,
  PRIMARY KEY (`account_id`) USING BTREE,
  KEY `account_power` (`account_power`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (5,'赵龙','e10adc3949ba59abbe56e057f20f883e','4589565@163.com',457947);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator` (
  `administrator_id` varchar(20) NOT NULL,
  `administrator_name` varchar(30) NOT NULL,
  `administrator_password` varchar(255) NOT NULL,
  PRIMARY KEY (`administrator_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES ('1','1821203795@qq.com','123456'),('1821203795@qq.com','马凯健','1234'),('admin','马凯健','123456');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `algorithm`
--

DROP TABLE IF EXISTS `algorithm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `algorithm` (
  `algorithm_id` int(11) NOT NULL AUTO_INCREMENT,
  `algorithm_name` text NOT NULL,
  `algorithm_paper_reference` text,
  `algorithm_paper_link` text,
  `algorithm_call_interface` text,
  `ut` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `algorithm_description` text,
  `algorithm_call_host` text,
  `algorithm_call_exchange` text,
  `algorithm_call_demo_routingkey` text,
  `algorithm_call_port` text,
  `algorithm_call_username` text,
  `algorithm_call_password` text,
  `algorithm_call_execution_send_routingkey` text,
  `algorithm_call_execution_connect_routingkey` text,
  `algorithm_call_execution_routingkey` text,
  `algorithm_name_mapper` text,
  PRIMARY KEY (`algorithm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `algorithm`
--

LOCK TABLES `algorithm` WRITE;
/*!40000 ALTER TABLE `algorithm` DISABLE KEYS */;
INSERT INTO `algorithm` VALUES (15,'算法1','算法1','www.baidu.com','www.baidu.com','2020-05-22 07:54:12','算法1','192.168.56.1','algotihmservice1exchange','algotihmservice1routingkey','5672','test1','test','algotihmservice1routingkey','algotihmservice1routingkey',NULL,NULL),(16,'算法儿','尝试使用算法2','interface','www.apache.com','2020-05-31 05:54:35','尝试使用算法2','127.1.1.1','mqexchaneg','mqexchaneg','5672','root','123456',NULL,NULL,'mqexchaneg',NULL),(17,'算法三','算法三','算法三','算法三','2020-05-31 06:07:41','算法三','127.1.1.1','算法三','算法三','算法三','guest','guest',NULL,NULL,'算法三',NULL),(18,'算法id为18','新的算法算法id为18','新的算法算法id为18','新的算法算法id为18','2020-06-02 07:43:56','新的算法算法id为18','算法id为18','算法id为18','算法id为18','算法id为18','算法id为18','算法id为18','算法id为18','算法id为18',NULL,NULL);
/*!40000 ALTER TABLE `algorithm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `algorithm_keywords`
--

DROP TABLE IF EXISTS `algorithm_keywords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `algorithm_keywords` (
  `algorithm_id` int(11) NOT NULL,
  `keyword` text NOT NULL,
  `ut` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`algorithm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `algorithm_keywords`
--

LOCK TABLES `algorithm_keywords` WRITE;
/*!40000 ALTER TABLE `algorithm_keywords` DISABLE KEYS */;
/*!40000 ALTER TABLE `algorithm_keywords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apply_account`
--

DROP TABLE IF EXISTS `apply_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply_account` (
  `apply_id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_email` varchar(50) NOT NULL,
  `apply_reason` text NOT NULL,
  `administrator_id` varchar(20) DEFAULT NULL,
  `apply_condition` varchar(20) NOT NULL DEFAULT '审核中',
  `administrator_reason` text,
  `ut` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `apply_password` text NOT NULL,
  PRIMARY KEY (`apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply_account`
--

LOCK TABLES `apply_account` WRITE;
/*!40000 ALTER TABLE `apply_account` DISABLE KEYS */;
INSERT INTO `apply_account` VALUES (5,'1821203795@qq.com','shenq','1','通过审核','无','2020-05-17 01:41:38','e10adc3949ba59abbe56e057f20f883e');
/*!40000 ALTER TABLE `apply_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dataset`
--

DROP TABLE IF EXISTS `dataset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dataset` (
  `dataset_id` int(11) NOT NULL AUTO_INCREMENT,
  `dataset_name` text,
  `dataset_description` text,
  `dataset_size` text,
  `dataset_source` text,
  `dataset_dimension` text,
  `is_common` bit(1) DEFAULT b'0',
  `ut` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dataset_file` text,
  `dataset_records` int(11) DEFAULT NULL,
  `dataset_tags` text,
  `dataset_type` text,
  `dataset_count` text,
  PRIMARY KEY (`dataset_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dataset`
--

LOCK TABLES `dataset` WRITE;
/*!40000 ALTER TABLE `dataset` DISABLE KEYS */;
INSERT INTO `dataset` VALUES (1,'测试用数据集1','测试用数据集','133','测试用数据集','10','\0','2020-05-27 09:47:46','static\\dataset\\iris.csv',NULL,NULL,NULL,NULL),(2,'wine','wine',NULL,'wine','0','','2020-05-27 09:58:18','static/dataset/temp/2020/05/15/e7a193bb-2b2e-421c-bc2d-b8f1daa470da.csv',NULL,NULL,NULL,'0'),(3,'wine-D','wine-D',NULL,'wine-D','0','','2020-05-27 09:50:43','static\\dataset\\temp\\2020\\05\\27\\757df62d-d7f1-49a1-9601-d0aaf4bc286c.csv',NULL,NULL,NULL,'0'),(4,'111','1',NULL,'https://www.baidu.com','19','','2020-05-27 10:03:06','wine-D.csv',NULL,NULL,NULL,'1');
/*!40000 ALTER TABLE `dataset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dataset_form`
--

DROP TABLE IF EXISTS `dataset_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dataset_form` (
  `input_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `input_name` varchar(255) NOT NULL,
  `input_description` text,
  `input_href` text,
  `input_preprocess` text,
  `input_algorithm` text,
  `input_record` int(11) DEFAULT NULL,
  `input_dimension` varchar(20) DEFAULT NULL,
  `input_tag` varchar(100) DEFAULT NULL,
  `input_type` varchar(50) DEFAULT NULL,
  `input_status` varchar(10) NOT NULL DEFAULT '审核中',
  `input_file` varchar(100) DEFAULT NULL,
  `input_reviewer` varchar(20) DEFAULT NULL,
  `input_start_time` datetime DEFAULT NULL,
  `input_review_time` datetime DEFAULT NULL,
  `input_end_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`input_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dataset_form`
--

LOCK TABLES `dataset_form` WRITE;
/*!40000 ALTER TABLE `dataset_form` DISABLE KEYS */;
INSERT INTO `dataset_form` VALUES (4,303030,'wine','wine','wine','wine','11',NULL,NULL,NULL,NULL,'通过审核','static\\dataset\\temp\\2020\\05\\15\\e7a193bb-2b2e-421c-bc2d-b8f1daa470da.csv',NULL,NULL,NULL,'2020-05-15 11:45:41','2020-05-15 03:45:09'),(5,303030,'wine-D','wine-D','wine-D','wine-D','wine-D',NULL,NULL,NULL,NULL,'不通过','static\\dataset\\temp\\2020\\05\\27\\79d98c7b-726b-4703-9b27-c339ec5635d5.csv',NULL,NULL,NULL,'2020-05-27 17:50:24','2020-05-27 09:49:59'),(6,303030,'wine-D','wine-D','wine-D','wine-D','wine-D',NULL,NULL,NULL,NULL,'通过审核','static\\dataset\\temp\\2020\\05\\27\\757df62d-d7f1-49a1-9601-d0aaf4bc286c.csv',NULL,NULL,NULL,'2020-05-27 17:50:43','2020-05-27 09:50:31');
/*!40000 ALTER TABLE `dataset_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `html_element_control`
--

DROP TABLE IF EXISTS `html_element_control`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `html_element_control` (
  `module_key` varchar(50) NOT NULL DEFAULT '',
  `html_name` varchar(30) NOT NULL DEFAULT '',
  `type` varchar(10) NOT NULL,
  `ch_value` text NOT NULL,
  `en_value` text NOT NULL,
  PRIMARY KEY (`module_key`,`html_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `html_element_control`
--

LOCK TABLES `html_element_control` WRITE;
/*!40000 ALTER TABLE `html_element_control` DISABLE KEYS */;
INSERT INTO `html_element_control` VALUES ('aboutus','header','text','关于我们','AboutUs'),('aboutusinfo','aboutus','text',' 广东工业大学是一所以工为主、工理经管文法艺结合、多科性协调发展的省属重点大学、广东省高水平大学重点建设高校，1995年由原广东工学院、广东机械学院和华南建设学院（东院）合并组建而成，1958年开办本科教育。六十多年来，学校始终坚持“与广东崛起共成长，为广东发展作贡献”的办学理念，加强与产业深度融合，不断推进内涵建设，办学实力、社会影响力和国际声誉日益提升。2019年首次进入THE（泰晤士高等教育）世界大学排行榜、软科世界大学学术排名“千强”名单，2020年泰晤士高等教育新兴经济体大学排名中国大陆高校第51位，USNews2020世界大学工科排行榜国内排名第45位、世界排名第268位。\r\n\r\n                            学校坐落于中国南方名城广州，拥有大学城、东风路、龙洞、番禺等多个校区，校园占地总面积3066.67亩，环境优美。大学城校区突出工科特色优势；东风路校区突出国际设计创意特色优势；龙洞校区突出管理学、理学、社工服务特色优势；番禺校区突出中外合作办学特色优势。\r\n\r\n                            目前，学校共设有20个学院、4个公共课教学部(中心)，拥有博士后科研流动站6个、省攀峰重点学科一级学科4个、省优势重点学科一级学科6个、省特色重点学科二级学科5个、一级学科博士学位授权点7个、二级学科博士学位授权点31个、一级学科硕士学位授权点23个、二级学科硕士学位授权点95个，硕士专业学位授予权13种，同时具有同等学力人员申请硕士学位授予权。机械、信息、材料、化工四个学科为广东省“211工程”三期重点建设学科。工程学、材料科学、计算机科学、化学、环境科学与生态学等5个学科进入ESI全球学科排名前1%行列，其中工程学已进入1.9‰。学校现有本科专业81个，招生专业（类）46个。目前全日制在校生44000余人，其中本科生36000余人，研究生7000余人，并招有不同层次的成人学历教育学生、港澳台生、国际学生，已形成“学士-硕士-博士”完整的人才培养体系。\r\n\r\n                            学校提出“以更加解放的思想、更加开放的姿态、更加创新的体制机制、更加勤奋务实的工作作风，集聚海内外创新人才，多模式构建创新平台，营造创新氛围，培养创新人才”的发展思路，全面实施大学生创新行动计划、研究生拔尖创新人才培育计划、研究生优质生源“千苗计划”、强师工程等重大战略。近年来，学校在人才培养、师资队伍、科研创新、社会服务等方面发展迅速，成效显著。\r\n\r\n                            学校高度重视高素质师资队伍建设，现有专任教师2000多人，拥有职称自主评审权，其中正高级职称400多人，副高级职称约700人。先后推出“百人计划”“青年百人计划”“培英育才计划”“教师出国研修计划”等，师资实力日益雄厚。目前拥有全职院士1人，聘有外籍院士4人、中国科学院院士2人、中国工程院院士4人，拥有“教育部高层次人才”、国家“杰青”、新世纪“百千万人才工程”人才、海外高层次人才、国家“优青”、教育部“新世纪优秀人才”等国家级人才达100多人次，珠江学者、青年珠江学者、省“杰青”等省级人才100多人次、省部级“创新团队”13个。高素质师资队伍的建设，为学校快速发展提供了强有力的人才支撑。\r\n\r\n                            学校科研工作坚持顶天立地战略，科研整体实力不断增强。学校建有省部共建国家重点实验室1个、国家地方联合工程实验室1个、国家地方联合工程研究中心1个、国家发改委现代服务业产业集聚基地1个、教育部重点实验室2个、教育部国际合作联合实验室1个、教育部协同创新中心1个、广东省重点实验室及其他省级科研平台70余个。2019年，国家自然科学基金项目立项数位列全国高校第59位，立项经费突破亿元；牵头承担国家重点研发计划项目5项，立项经费近1亿元。近五年来，学校以第一完成单位获得国家科学技术奖3项，其中2019年获国家技术发明奖二等奖、国家科技进步二等奖各1项；获省部级科技奖一等奖12项，其中2019年获教育部科技奖自然科学一等奖1项、省科技一等奖4项、省科技合作奖1项；获教育部高等学校科学研究优秀成果奖（人文社会科学）3项，其中2019年获二等奖2项，获广东省哲学社会科学优秀成果奖一等奖4项。获中国专利优秀奖6项，学校发明专利授权位列全国高校第31位。\r\n\r\n                            学校不断加强与产业深度融合，与地方政府和工业界联合建立了“广州国家现代服务业集成电路设计产业化基地”“佛山广工大数控装备协同创新研究院”“东莞华南设计创新院”“河源广工大协同创新研究院”“惠州广工大物联网协同创新研究院”“汕头广工大协同创新研究院”“云浮创新设计中心”“东源广工大现代产业协同创新研究院”等多个跨学科协同创新平台，推动广东国防科技工业技术成果产业化应用推广中心落地，前期投入6亿元资助中心建设。学校致力于在高端装备、智能制造、IC设计、工业设计、先进材料、环境生态、生物制药、软物质等多个领域构建高水平协同创新平台，促进产学研和协同创新取得实质性成果，助力地方经济社会高质量发展。\r\n\r\n                            学校坚持开放办学，不断加强对外合作与交流，先后与国（境）外150多所知名大学和机构建立合作关系，开展学生培养、教学改革、师资培养、人才引进、科研创新、平台建设等多方面合作，为学校人才培养国际化、师资队伍国际化和科研工作国际化创造条件、提供良好平台。学校高度重视服务国家“一带一路”倡议，加强国际化人才培养，支持“一带一路”沿线国家学生来华留学与技术培训。现有国家外专局和教育部“高等学校学科创新引智计划”（“111计划”）1个、粤港澳离散制造智能化联合实验室1个，开办有中外合作办学项目动画专业1个，机械设计制造及其自动化、电气工程及其自动化、土木工程、计算机科学与技术、工商管理专业本科国际班5个。\r\n\r\n                            学校落实立德树人根本任务，努力培养有家国情怀、有国际视野、有坚实基础、有创新能力的高素质人才。现有教育部卓越工程师教育培养计划专业7个、国家级特色专业建设点7个、国家级专业综合改革试点专业1个、教育部专业认证/评估通过15个、广东省名牌专业13个、省级特色专业18个、省级重点专业5个、省级专业综合改革试点专业16个，国家级精品课程（含双语教学示范课程）3门、省级精品课程（含双语教学示范课程）99门，国家级工程实践教育中心7个、国家级研究生联合培养示范基地2个、国家级大学生实践教学基地1个、省级大学生实践教学基地38个，国家级实验教学示范中心3个、国家级虚拟仿真实验教学中心1个、省级实验教学示范中心24个、省级虚拟仿真实验教学中心3个，拥有教育部教学指导委员会委员8人、国家级教学团队1个、省级教学团队18个、省教学名师16人。近五年来，获国家级教学成果二等奖2项，省级教学成果一等奖14项、二等奖21项。学校办学条件良好，校舍建筑面积161万余平方米，现有计算机15500台套，教学、科研仪器设备固定资产总值15.21亿元，拥有藏书401.1万册、电子图书237.04万册。\r\n\r\n                            学校高度重视创新创业教育和文化素质教育。通过一系列创新政策和举措，学生创新能力和综合素质不断提高，学生在全国各类科技创新竞赛、文化体育竞赛中屡创佳绩。中国高等教育学会2019全国普通高校学科竞赛排行榜位居36位。2013-2019年，学校连续四届捧得“挑战杯”全国赛“优胜杯”，获特等奖4项；2012-2018年，学校连续四届夺得“创青春”全国赛金奖，其中2018年摘得金奖2项，并捧得“优胜杯”；2018年，第42届ACM-ICPC全球总决赛总排名第32位、国内高校排名第8位；2017年，我校FSAE车队获中国大学生方程式汽车大赛总成绩第一名；2018年，我校学生荣获美国大学生数学建模竞赛一等奖18项；2017-2018年，我校学生获得德国RED\r\n                            DOT（红点）设计大奖1项、德国IF DEGIGN TALENT AWAARD\r\n                            大奖4项；我校“北斗”团队、“QG工作室”获评“小平科技创新团队”，近五年有3名大学生分别获得第七届、第十届、第十一届中国青少年科技创新奖。学校男子篮球队连续三年获全国大超联赛总冠军，2011年获第八届亚洲大学篮球锦标赛冠军；足球队获2018-2019CUFA全国大学生校园足球联赛大学男子校园组总冠军，第24届中国大学生乒乓球锦标赛（超级组）获男子单打冠军，2019年中国大学生阳光体育游泳比赛获男子200米自由泳第一名。近年来，学生在声乐、器乐和舞蹈集体项目上获全国大学生艺术展演一等奖、全国大学生素质教育艺术品牌金奖等50余项。\r\n\r\n                            学校坚持以习近平新时代中国特色社会主义思想为指导，深入贯彻习近平总书记对广东重要讲话和重要指示批示精神，抢抓粤港澳大湾区建设重大历史机遇，坚持改革创新，不断促进高质量发展，努力建设以工为主、与产业深度融合、极具创造活力的“特色鲜明、国内一流、世界知名”的高水平大学。','广东工业大学是一所以工为主、工理经管文法艺结合、多科性协调发展的省属重点大学、广东省高水平大学重点建设高校，1995年由原广东工学院、广东机械学院和'),('aboutustitle','aboutus','text','关于我们','aboutus'),('accounttitle','login','text','账号','Account'),('algorithms_filter','execution_algorithms','filter_btn','筛选','Filter'),('algorithms_filter1','execution_algorithms','title','搜索','Search'),('algorithms_filter2','execution_algorithms','title','计算方式','Calculation'),('algorithms_filter3','execution_algorithms','title','系列','Series'),('algorithms_info_how','execution_algorithms','title','如何使用','How to start'),('algorithms_info_how_context','execution_algorithms','html','<p class=\"card-text\">上述步骤帮助你快速使用算法</p>','<p class=\"card-text\">Follow these steps help you get start quickly.</p>'),('algorithms_info_how_img','execution_algorithms','img','pic/timg.jpg','pic/timg.jpg'),('algorithms_info_intro','execution_algorithms','title','算法介绍','Introduction'),('algorithms_info_papers','execution_algorithms','title','文献来源','Papers'),('algorithms_info_parameter','execution_algorithms','title','参数信息','Parameters of the algorithm'),('algorithms_info_parameter_footer','execution_algorithms','text','参数','Parameter'),('algorithms_info_parameter_li1','execution_algorithms','li','类型：','Type:'),('algorithms_info_parameter_li2','execution_algorithms','li','默认值：','Default Value:'),('algorithms_info_title','execution_algorithms','title','特征算法','Feature Selection Algorithm'),('algorithms_search','execution_algorithms','text','搜索','Search'),('already','register','text','准备拥有一个账户','Already have an account'),('b2ef35dd','aboutus','html_pages','测试','<p>测试<br></p>'),('brand','header','text','AlgGroup','AlgGroup'),('button_text1','guide','text','试一试','Tryit'),('button_text2','guide','text','学习更多','Learn More'),('contactustitle','aboutus','text','联系我们','contact us'),('datasetinfotitle','schemesDetails','text','数据集信息','DatasetInfo'),('dataset_info_p1','execution_main','text','简介','Introduction'),('dataset_info_p2','execution_main','text','数据源','Source'),('dataset_info_p3','execution_main','text','大小','Size'),('dataset_info_p4','execution_main','text','维度','Dimension:'),('dataset_info_p5','execution_main','text','记录数','Records:'),('dataset_info_p6','execution_main','text','标签数','Tags:'),('dataset_info_p7','execution_main','text','类型','Type:'),('executions','header','text','执行器','Executions'),('gettingstart','header','text','快速开始','GettingStart'),('givittry','algorithms','text','尝试一下','Give It a Try'),('guideinfocontent','algorithms','text','<p>1.选择您想要测试的算法(每个下拉栏代表一个算法。点击下拉栏左侧的算法名，查看算法的具体信息)</p><p>2. 单击下拉栏右侧的下拉标记</p><p>3. 您可以在下拉列表中看到方案列表，点击方案名称即可查看方案的具体信息。(我们设置了算法的一些参数和供运行使用的数据集。)</p><p>4. 选择您想要测试的方案，然后单击右侧运行按钮</p><p>5. 查看右边的结果，它将通过图形显示</p>','<p>1.chooice the algorithm that you want to test（Each drop-down bar represents an algorithm. Click the algorithm name to the left of the drop-down bar to see the specific information of the algorithm）</p><p>2.Click the drop-down flag in the right of the drop-down bar</p><p>3.you can see schemes list in the Dropdownlist,and click the scheme name to see the specific information of the schemes.(The scheme is an example. We set some parameters of the algorithm and the dataset for operation.) </p><p>4.chooice the sheme that you want to test,and click the butoon on the right</p><p>5.check the result on the right,it will be show by the graph'),('guideinfotitile','algorithms','text','使用步骤说明','Using procedure'),('guidetext','guide','text','特征选择算法研究','Reseraches on Feature Selection'),('home_text','execution_home','text','这里我们为您提供了很多算法，希望能帮助您更好地分析数据集，做出更好的决策。','Here we provide you with a lot of algorithms and hope to help you analysis your datasets better and make better decisions.'),('home_title','execution_home','title','欢迎来到执行器系统','Welcome to Executions'),('home_ul1','execution_home','title','特色','What You Can Do?'),('home_ul1_li1','execution_home','li','使用全部的算法','Use all algorithm'),('home_ul1_li2','execution_home','li','自定义所有参赛','Costumed all parameter'),('home_ul1_li3','execution_home','li','上传你的数据集','Upload your own dataset'),('home_ul1_li4','execution_home','li','随时查询你的订单','Check Your Task Anytime'),('home_ul2','execution_home','title','如何开始？','How to Start?'),('home_ul2_li1','execution_home','li','选择算法','Step1:Choose an algorithm that you need.'),('home_ul2_li2','execution_home','li','上传数据集','Step2:Upload your dataset or choose a public dataset.'),('home_ul2_li3','execution_home','li','选择参数配置算法','Step3:Set up parameters or choose situation.'),('home_ul2_li4','execution_home','li','等待结果','Step4:Waiting for result.'),('introductionusinfo','aboutus','text','Cillum ad ut irure tempor velit nostrud occaecat\r\n                            ullamco aliqua anim Lorem sint. Veniam sint duis incididunt do esse magna mollit excepteur\r\n                            laborum qui. Id id reprehenderit sit est eu aliqua occaecat quis et velit excepteur laborum\r\n                            mollit dolore eiusmod. Ipsum dolor in occaecat commodo et voluptate minim reprehenderit\r\n                            mollit pariatur. Deserunt non laborum enim et cillum eu deserunt excepteur ea incididunt\r\n                            minim occaecat.','Cillum ad ut irure tempor velit nostrud occaecat\r\n                            ullamco aliqua anim Lorem sint. Veniam sint duis incididunt do esse magna mollit excepteur\r\n                            laborum qui. Id id reprehenderit sit est eu aliqua occaecat quis et velit excepteur laborum\r\n                            mollit dolore eiusmod. Ipsum dolor in occaecat commodo et voluptate minim reprehenderit\r\n                            mollit pariatur. Deserunt non laborum enim et cillum eu deserunt excepteur ea incididunt\r\n                            minim occaecat.'),('introductionustitle','aboutus','text','人员介绍','introduction of us'),('log','login','text','登陆','Log'),('login','header','text','登陆','Login'),('logintitle','login','text','登陆','Login'),('modal_btn_cancel','execution_main','btn','取消','cancel'),('modal_btn_close','execution_main','btn','关闭','Close'),('modal_btn_confirm','execution_main','text','确定','Confirm'),('modal_btn_save','execution_main','btn','保存','Save'),('modal_btn_submit','execution_main','btn','提交','Submit'),('navBody_a1','execution_main','nav_li','首页','Home'),('navBody_a2','execution_main','nav_li','算法列表','Algorithms'),('navBody_a3','execution_main','nav_li','创建任务','New Task'),('navBody_a4','execution_main','nav_li','查询任务','Query Task'),('navBody_a5','execution_main','nav_li','公共数据集','Public Dataset'),('navHead_btn1','execution_main','nav_btn','登录','Login'),('navHead_li1','execution_main','nav_li','快速开始','Getting Start'),('navHead_li2','execution_main','nav_li','执行器','Executions'),('navHead_li3','execution_main','nav_li','关于我们','About us'),('new_task_navbar_a1','execution_new_task','text','数据集','Dataset'),('new_task_navbar_a2','execution_new_task','text','算法','Algorithm'),('new_task_navbar_a3','execution_new_task','text','基本信息','Basic Info'),('new_task_step1','execution_new_task','text','第一步：选择数据集','Step1: Choose dataset'),('new_task_step1_feedback1','execution_new_task','text','错误！','Error!'),('new_task_step1_feedback2','execution_new_task','html','<strong>还没有选择数据集！</strong>请选择','<strong>Has not selected an dataset!</strong>Please select one.'),('new_task_step1_label1','execution_new_task','label','选择一个公共数据集或者上传一个数据集','Select a public dataset or upload a dataset.'),('new_task_step1_label2','execution_new_task','label','选择一个数据集文件(仅支持.csv .xlsx .xls)','Choose file(.csv .xlsx .xls) from disk.'),('new_task_step1_select_default','execution_new_task','text','选择一个公共数据集','Select a public Dataset'),('new_task_step2','execution_new_task','text','第二步：选择算法并设置参数','Step2: Choose and custom Algorithm'),('new_task_step2_card_btn1','execution_new_task','btn','详细信息','More'),('new_task_step2_card_btn2','execution_new_task','btn','选择算法','Select'),('new_task_step2_card_p1','execution_new_task','text','最近更新','Last Update'),('new_task_step2_feedback1','execution_new_task','html','<strong>还未选择算法。</strong>请选择!','<strong>Has not selected an algorithm!</strong>Please select one.'),('new_task_step3','execution_new_task','text','第三步：填写基本信息','Step3: Fill in BasicInfo'),('new_task_step3_card_label1','execution_new_task','label','邮箱','E-mail'),('new_task_step3_card_label2','execution_new_task','label','名字','Name'),('new_task_step3_card_label3','execution_new_task','label','简介','Comment'),('new_task_step3_card_label4','execution_new_task','label','是否使用邮箱接收结果','Use email to receive result'),('new_task_step3_feedback1','execution_new_task','text','邮箱格式错误！','Not an email!'),('new_task_step3_feedback2','execution_new_task','text','已使用','Has used!Please change'),('new_task_step_btn1','execution_new_task','btn','提交','Submit'),('notaccount','login','text','没有账号？','not account？'),('pagetitle','aboutus','text','关于我们','About Us'),('parametertitle','schemesDetails','text','参数及参数值列表','Parameters and Values list here'),('passwordtitle','login','text','密码','Password'),('public_dataset_check_th1','execution_public_dataset','text','提交时间','Submit Time'),('public_dataset_check_title1','execution_public_dataset','title','我的上传','Your Uploads'),('public_dataset_intro_btn1','execution_public_dataset','btn','上传公共数据集','Upload Dataset'),('public_dataset_intro_btn2','execution_public_dataset','btn','查看我的上传','Check My Uploads'),('public_dataset_intro_p1','execution_public_dataset','text','你可以获取所有公共数据的信息并下载它。','You can get all the dataset information and download them.'),('public_dataset_intro_title','execution_public_dataset','title','下表所有公共数据集','The followings are public datasets available!'),('public_dataset_list_btn1','execution_public_dataset','btn','下载','Download'),('public_dataset_upload_label1','execution_public_dataset','text','预处理说明','Preprocessing'),('public_dataset_upload_label2','execution_public_dataset','text','可用算法','Algorithm'),('public_dataset_upload_label3','execution_public_dataset','text','数据集','Dataset'),('public_dataset_upload_title1','execution_public_dataset','title','上传公共数据集','Upload a Public Dataset\r\n'),('query_task_chart_title','execution_query_task','title','结果集','Results'),('query_task_delete_context','execution_query_task','text','确定删除 ','You are sure delete to delete '),('query_task_delete_warning','execution_query_task','text','警告','Warning'),('query_task_table_th1','execution_query_task','text','id','id'),('query_task_table_th2','execution_query_task','text','名字','Name'),('query_task_table_th3','execution_query_task','text','简介','Comment'),('query_task_table_th4','execution_query_task','text','状态','Status'),('query_task_table_th5','execution_query_task','text','操作','Options'),('register','login','text','注册','Register'),('register','register','text','注册','Register'),('registeremail','register','text','邮箱','Email'),('registerpassword','register','text','密码','Password'),('registerreason','register','text','申请原因','applyReason'),('registersuccess','register','run','提交成功','success to commit'),('registertitle','register','text','注册','Register'),('resulttext','algorithms','text','运行处理结果图表','navicat for result'),('run','algorithms','text','运行','run'),('schemehead','algorithms','text','以下是运行方案细节','The following is the detail of schemes'),('schemesdetailstitle','schemesDetails','text','方案详情','SchemesDetails'),('title','algorithms','text','实现特征选择算法','Implemented Feature Selection Algorithms'),('updatetitle','updates','text','更新','Update');
/*!40000 ALTER TABLE `html_element_control` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `html_element_control_default`
--

DROP TABLE IF EXISTS `html_element_control_default`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `html_element_control_default` (
  `module_key` varchar(50) NOT NULL,
  `html_name` varchar(30) NOT NULL,
  `type` varchar(10) NOT NULL,
  `ch_value` text NOT NULL,
  `en_value` text NOT NULL,
  PRIMARY KEY (`html_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `html_element_control_default`
--

LOCK TABLES `html_element_control_default` WRITE;
/*!40000 ALTER TABLE `html_element_control_default` DISABLE KEYS */;
/*!40000 ALTER TABLE `html_element_control_default` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keywords`
--

DROP TABLE IF EXISTS `keywords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keywords` (
  `algorithm_id` int(11) NOT NULL,
  `keyword` varchar(50) NOT NULL,
  `ut` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`algorithm_id`,`keyword`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keywords`
--

LOCK TABLES `keywords` WRITE;
/*!40000 ALTER TABLE `keywords` DISABLE KEYS */;
/*!40000 ALTER TABLE `keywords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameter`
--

DROP TABLE IF EXISTS `parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parameter` (
  `parameter_id` int(11) NOT NULL AUTO_INCREMENT,
  `algorithm_id` int(11) NOT NULL,
  `parameter_name` text NOT NULL,
  `parameter_description` text,
  `parameter_type` text,
  `parameter_default_value` text,
  `parameter_validity_check_interface` text,
  `parameter_validity_description` text,
  `ut` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `parameter_setting_info` text,
  `parameter_name_mapper` text,
  PRIMARY KEY (`parameter_id`),
  KEY `algorithm _id` (`algorithm_id`),
  CONSTRAINT `parameter_ibfk_1` FOREIGN KEY (`algorithm_id`) REFERENCES `algorithm` (`algorithm_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameter`
--

LOCK TABLES `parameter` WRITE;
/*!40000 ALTER TABLE `parameter` DISABLE KEYS */;
INSERT INTO `parameter` VALUES (1,15,'参数id为1','我试一下修改','input','100',NULL,NULL,'2020-06-02 14:26:57','{\"type\":\"selection\",\"options\":[\"d\",\"e\",\"f\"],\"optionExtra\":{\"d\":{\"type\":\"text\",\"options\":[]},\"e\":{\"type\":\"selection\",\"options\":[\"11\",\"22\",\"33\"]},\"f\":{\"type\":\"text\",\"options\":[]}}}',NULL),(24,15,'尝试用','试一下','text','200',NULL,NULL,'2020-05-30 17:01:42','{\"type\":\"text\",\"options\":[],\"optionExtra\":null}',NULL),(25,15,'尝试用','终极测试','selection','100',NULL,NULL,'2020-05-30 17:01:42','{\"type\":\"selection\",\"options\":[\"100\",\"200\"],\"optionExtra\":{\"100\":{\"type\":\"text\",\"options\":[]},\"200\":{\"type\":\"selection\",\"options\":[\"100\",\"200\",\"300\"]}}}',NULL),(26,16,'第二个算法的text参数','text类型参数','text','200',NULL,NULL,'2020-05-31 05:56:37','{\"type\":\"text\",\"options\":[],\"optionExtra\":null}',NULL),(27,16,'第二个算法的radio参数','radio类型参数','radio','100',NULL,NULL,'2020-05-31 05:56:37','{\"type\":\"radio\",\"options\":[\"100\",\"200\",\"300\"],\"optionExtra\":null}',NULL),(28,16,'','','','',NULL,NULL,'2020-06-03 07:13:05','{\"type\":\"selection\",\"options\":[\"200\",\"250\"],\"optionExtra\":{\"200\":{\"type\":\"text\",\"options\":[]},\"250\":{\"type\":\"selection\",\"options\":[\"100\",\"200\",\"300\"]}}}',NULL),(29,17,'第三个算法的text参数','text类型参数','text','200',NULL,NULL,'2020-05-31 06:11:11','{\"type\":\"text\",\"options\":[],\"optionExtra\":null}',NULL),(30,17,'第三个算法的radio参数','试一下','radio','200',NULL,NULL,'2020-05-31 06:11:11','{\"type\":\"radio\",\"options\":[\"100\",\"200\",\"300\"],\"optionExtra\":null}',NULL),(31,17,'换一个参数名称','justCheck','radio','300',NULL,NULL,'2020-05-31 18:22:59','{\"type\":\"selection\",\"options\":[\"100\",\"200\",\"300\"],\"optionExtra\":{\"100\":{\"type\":\"text\",\"options\":[]},\"200\":{\"type\":\"selection\",\"options\":[\"100\",\"200\",\"300\"]},\"300\":{\"type\":\"selection\",\"options\":[\"true\",\"false\"]}}}',NULL),(32,16,'','','','',NULL,NULL,'2020-06-03 07:12:23','{\"type\":\"text\",\"options\":[],\"optionExtra\":null}',NULL),(33,16,'','','','',NULL,NULL,'2020-06-02 15:05:03','{\"type\":\"selection\",\"options\":[\"200\",\"300\"],\"optionExtra\":{\"200\":{\"type\":\"text\",\"options\":[]},\"300\":{\"type\":\"selection\",\"options\":[\"100\",\"200\",\"300\"]}}}',NULL),(37,18,'input类型参数','input的参数描述','text','100',NULL,NULL,'2020-06-02 13:40:29','{\"type\":\"text\",\"options\":[],\"optionExtra\":null}',NULL),(38,18,'selection类型参数','selection的参数描述','selection','100',NULL,NULL,'2020-06-02 13:40:29','{\"type\":\"selection\",\"options\":[\"100\",\"200\"],\"optionExtra\":{\"100\":{\"type\":\"text\",\"options\":[]},\"200\":{\"type\":\"selection\",\"options\":[\"100\",\"200\",\"300\"]}}}',NULL),(39,15,'完整的算法参数添加','试一下','selection','200',NULL,NULL,'2020-06-03 12:47:14','{\"type\":\"selection\",\"options\":[\"200\"],\"optionExtra\":{\"200\":{\"type\":\"selection\",\"options\":[\"true\"]}}}',NULL),(40,15,'完整尝试text','试一下','text','200',NULL,NULL,'2020-06-03 12:57:04','{\"type\":\"text\",\"options\":[],\"optionExtra\":null}',NULL),(41,15,'完整尝试text','试一下','text','200',NULL,NULL,'2020-06-03 12:58:00','{\"type\":\"text\",\"options\":[],\"optionExtra\":null}',NULL),(42,15,'尝试selection','试一下','selection','200',NULL,NULL,'2020-06-03 12:59:46','{\"type\":\"selection\",\"options\":[\"200\",\"300\"],\"optionExtra\":{}}',NULL),(44,18,'尝试完整的Selection','试一下','selection','200',NULL,NULL,'2020-06-03 13:07:57','{\"type\":\"selection\",\"options\":[\"200\"],\"optionExtra\":{\"200\":{\"type\":\"selection\",\"options\":[\"100\",\"200\",\"300\"]}}}',NULL),(45,16,'text类型参数','试一下','text','100',NULL,NULL,'2020-06-03 13:11:58','{\"type\":\"text\",\"options\":[],\"optionExtra\":null}',NULL),(46,16,'selection类型参数','试一下selection','selection','200',NULL,NULL,'2020-06-03 13:11:58','{\"type\":\"selection\",\"options\":[\"500\",\"600\"],\"optionExtra\":{\"500\":{\"type\":\"selection\",\"options\":[\"100\",\"200\",\"300\"]},\"600\":{\"type\":\"selection\",\"options\":[\"true\",\"false\"]}}}',NULL),(47,15,'尝试一次不会消失','试一下','selection','1',NULL,NULL,'2020-06-04 11:47:42','{\"type\":\"selection\",\"options\":[\"1\",\"2\"],\"optionExtra\":{\"1\":{\"type\":\"selection\",\"options\":[\"100\",\"200\",\"300\"]},\"2\":{\"type\":\"selection\",\"options\":[\"true\",\"false\"]}}}',NULL),(48,16,'尝试用','试一下','text','200',NULL,NULL,'2020-06-05 03:37:22','{\"type\":\"text\",\"options\":[],\"optionExtra\":null}',NULL),(49,16,'尝试debug后的radio','试一下','radio','200',NULL,NULL,'2020-06-05 03:37:53','{\"type\":\"radio\",\"options\":[\"100,200,300\"],\"optionExtra\":null}',NULL),(50,15,'添加映射值','第一次尝试映射值的使用','selection','200',NULL,NULL,'2020-06-05 17:53:32','{\"type\":\"selection\",\"options\":[\"200\",\"300\"],\"optionExtra\":{\"200\":{\"type\":\"selection\",\"options\":[\"true\",\"false\"]},\"300\":{\"type\":\"selection\",\"options\":[\"100\",\"200\",\"300\"]}}}','algorithm_name_mapper'),(51,15,'尝试radio','试一下radio','radio','30',NULL,NULL,'2020-06-06 06:03:11','{\"type\":\"radio\",\"options\":[\"30\",\"40\"],\"optionExtra\":null}','test_radio'),(52,15,'尝试selection','尝试selection','selection','200',NULL,NULL,'2020-06-06 06:03:11','{\"type\":\"selection\",\"options\":[\"200\",\"300\"],\"optionExtra\":{\"200\":{\"type\":\"selection\",\"options\":[\"100\",\"200\",\"300\"]},\"300\":{\"type\":\"text\",\"options\":[]}}}','test_seletion'),(53,16,'尝试映射的使用radio','尝试映射的使用radio','radio','radio取值25',NULL,NULL,'2020-06-06 07:20:13','{\"type\":\"radio\",\"options\":[\"radio取值25\",\"radio取值30\"],\"optionExtra\":null}','test_radio'),(54,16,'尝试映射Selection','试一下','selection','测试Selection25',NULL,NULL,'2020-06-06 07:20:13','{\"type\":\"selection\",\"options\":[\"测试Selection25\",\"测试Selection30\"],\"optionExtra\":{\"测试Selection25\":{\"type\":\"selection\",\"options\":[\"100\",\"200\",\"300\"]},\"测试Selection30\":{\"type\":\"text\",\"options\":[]}}}','test_selection');
/*!40000 ALTER TABLE `parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameter_scheme`
--

DROP TABLE IF EXISTS `parameter_scheme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parameter_scheme` (
  `scheme_id` int(11) NOT NULL AUTO_INCREMENT,
  `algorithm_id` int(11) NOT NULL,
  `scheme_name` text NOT NULL,
  `scheme_description` text,
  `dataset_id` int(11) DEFAULT NULL,
  `scheme_remark` text,
  `ut` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`scheme_id`),
  KEY `algorithm_id` (`algorithm_id`),
  KEY `dataset_id` (`dataset_id`),
  CONSTRAINT `parameter_scheme_ibfk_1` FOREIGN KEY (`algorithm_id`) REFERENCES `algorithm` (`algorithm_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `parameter_scheme_ibfk_2` FOREIGN KEY (`dataset_id`) REFERENCES `dataset` (`dataset_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameter_scheme`
--

LOCK TABLES `parameter_scheme` WRITE;
/*!40000 ALTER TABLE `parameter_scheme` DISABLE KEYS */;
INSERT INTO `parameter_scheme` VALUES (2,15,'方案2','方案2',2,'方案2','2020-05-27 10:26:38');
/*!40000 ALTER TABLE `parameter_scheme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameter_scheme_value`
--

DROP TABLE IF EXISTS `parameter_scheme_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parameter_scheme_value` (
  `scheme_id` int(11) NOT NULL,
  `parameter_id` int(11) NOT NULL,
  `parameter_value` text NOT NULL,
  `is_selected` tinyint(4) DEFAULT '1',
  `step` int(11) DEFAULT '-1',
  PRIMARY KEY (`scheme_id`,`parameter_id`),
  KEY `parameter _id` (`parameter_id`),
  CONSTRAINT `parameter_scheme_value_ibfk_1` FOREIGN KEY (`scheme_id`) REFERENCES `parameter_scheme` (`scheme_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `parameter_scheme_value_ibfk_2` FOREIGN KEY (`parameter_id`) REFERENCES `parameter` (`parameter_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameter_scheme_value`
--

LOCK TABLES `parameter_scheme_value` WRITE;
/*!40000 ALTER TABLE `parameter_scheme_value` DISABLE KEYS */;
INSERT INTO `parameter_scheme_value` VALUES (2,1,'111',1,-1);
/*!40000 ALTER TABLE `parameter_scheme_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameter_value_map`
--

DROP TABLE IF EXISTS `parameter_value_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parameter_value_map` (
  `web_parameter` varchar(50) NOT NULL DEFAULT '',
  `algorithm_parameter` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`web_parameter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameter_value_map`
--

LOCK TABLES `parameter_value_map` WRITE;
/*!40000 ALTER TABLE `parameter_value_map` DISABLE KEYS */;
INSERT INTO `parameter_value_map` VALUES ('1','itr_num_1'),('100','itr_num_100'),('100,200,300','100'),('100_100,200,300','100'),('100_true,false','200'),('1_100','100'),('1_200','200'),('1_300','300'),('2','itr_num_2'),('200','itr_num_200'),('200_100,200','100'),('200_true','true'),('200_true,false','200'),('2_false','false'),('2_true','true'),('300','itr_num_300'),('300_100,200','true'),('300_true,false','false'),('500','itr_num_500'),('500_100','100'),('500_200','200'),('500_300','300'),('600','itr_num_600'),('600_false','false'),('600_true','true'),('true,false','200');
/*!40000 ALTER TABLE `parameter_value_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `power`
--

DROP TABLE IF EXISTS `power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `power` (
  `account_power` int(6) NOT NULL DEFAULT '0',
  `account_id` int(11) NOT NULL DEFAULT '0',
  `execution_algorithm1` bit(1) DEFAULT b'0',
  `execution_algorithm2` bit(1) DEFAULT b'0',
  PRIMARY KEY (`account_power`,`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `power`
--

LOCK TABLES `power` WRITE;
/*!40000 ALTER TABLE `power` DISABLE KEYS */;
INSERT INTO `power` VALUES (1350,1,'\0','\0'),(74460,4,'\0','\0'),(88440,2456,'\0','\0'),(221547,13,'\0','\0'),(248907,2,'\0','\0'),(430246,2,'\0','\0'),(457947,5,'\0','\0'),(478184,14,'\0','\0'),(513869,3,'\0','\0'),(695394,16,'\0','\0'),(778110,2,'\0','\0'),(861085,15,'\0','\0'),(940547,2,'\0','\0');
/*!40000 ALTER TABLE `power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procedure_settings`
--

DROP TABLE IF EXISTS `procedure_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procedure_settings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `algorithm_id` int(11) NOT NULL,
  `name` text NOT NULL,
  `state` enum('required','optionalSelected','optional') NOT NULL,
  `options` text NOT NULL,
  `default_option` text NOT NULL,
  `description` text NOT NULL,
  `name_mapper` text,
  KEY `procedure_settings_algorithm_algorithm_id_fk` (`id`) USING BTREE,
  KEY `procedure_settings___fk1` (`algorithm_id`) USING BTREE,
  CONSTRAINT `procedure_settings___fk1` FOREIGN KEY (`algorithm_id`) REFERENCES `algorithm` (`algorithm_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procedure_settings`
--

LOCK TABLES `procedure_settings` WRITE;
/*!40000 ALTER TABLE `procedure_settings` DISABLE KEYS */;
INSERT INTO `procedure_settings` VALUES (3,15,'步骤1','required','100,200','100','无',NULL),(4,15,'步骤三','required','方法1，方法2','方法1','步骤1',NULL),(5,16,'第一次使用映射步骤添加','optionalSelected','方法1,方法2,方法3','方法1','初始化步骤','first_time_use_mapper_add'),(6,15,'第二次尝试','required','方法1,方法2,方法3','方法1','第一次尝试使用映射','seconde_test'),(7,16,'第三次尝试了','optionalSelected','方法1,方法2,方法3','方法1','第三次尝试使用映射添加','third_test'),(8,17,'还没有步骤','optional','1,2,3','1','use','notproce'),(9,18,'测试步骤','optionalSelected','方法A,方法B,方法C','方法A','测试映射','test_procedureSetting');
/*!40000 ALTER TABLE `procedure_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scheme_dataset`
--

DROP TABLE IF EXISTS `scheme_dataset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scheme_dataset` (
  `scheme_id` int(11) NOT NULL,
  `dataset_id` int(11) NOT NULL,
  `scheme_remark` text,
  PRIMARY KEY (`scheme_id`,`dataset_id`),
  KEY `dataset_id` (`dataset_id`),
  CONSTRAINT `scheme_dataset_ibfk_1` FOREIGN KEY (`scheme_id`) REFERENCES `parameter_scheme` (`scheme_id`) ON DELETE CASCADE,
  CONSTRAINT `scheme_dataset_ibfk_2` FOREIGN KEY (`dataset_id`) REFERENCES `dataset` (`dataset_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheme_dataset`
--

LOCK TABLES `scheme_dataset` WRITE;
/*!40000 ALTER TABLE `scheme_dataset` DISABLE KEYS */;
/*!40000 ALTER TABLE `scheme_dataset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scheme_procedure`
--

DROP TABLE IF EXISTS `scheme_procedure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scheme_procedure` (
  `scheme_procedure_id` int(11) NOT NULL AUTO_INCREMENT,
  `scheme_id` int(11) NOT NULL,
  `procedure_name` text NOT NULL,
  `procedure_setting_data` text NOT NULL,
  PRIMARY KEY (`scheme_procedure_id`),
  KEY `scheme_procedure_parameter_scheme__fk` (`scheme_id`),
  CONSTRAINT `scheme_procedure_parameter_scheme__fk` FOREIGN KEY (`scheme_id`) REFERENCES `parameter_scheme` (`scheme_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheme_procedure`
--

LOCK TABLES `scheme_procedure` WRITE;
/*!40000 ALTER TABLE `scheme_procedure` DISABLE KEYS */;
/*!40000 ALTER TABLE `scheme_procedure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_info`
--

DROP TABLE IF EXISTS `task_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_info` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `task_name` varchar(50) NOT NULL,
  `task_status` varchar(10) NOT NULL DEFAULT '排队中',
  `task_comment` text,
  `task_reviewer` varchar(20) DEFAULT NULL,
  `task_reviewed_time` datetime DEFAULT NULL,
  `task_start_time` datetime DEFAULT NULL,
  `task_end_time` datetime DEFAULT NULL,
  `task_email` varchar(50) DEFAULT NULL,
  `algorithm_id` int(11) NOT NULL,
  `algorithm_parameters` text NOT NULL,
  `dataset_id` int(11) DEFAULT NULL,
  `dataset_upload` text,
  `algorithm_start_time` datetime DEFAULT NULL,
  `algorithm_end_time` datetime DEFAULT NULL,
  `algorithm_status` varchar(10) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`task_id`),
  KEY `task_info_ibfk_2` (`algorithm_id`),
  KEY `task_info_ibfk_3` (`dataset_id`),
  CONSTRAINT `task_info_ibfk_2` FOREIGN KEY (`algorithm_id`) REFERENCES `algorithm` (`algorithm_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `task_info_ibfk_3` FOREIGN KEY (`dataset_id`) REFERENCES `dataset` (`dataset_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_info`
--

LOCK TABLES `task_info` WRITE;
/*!40000 ALTER TABLE `task_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_result`
--

DROP TABLE IF EXISTS `task_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_result` (
  `task_id` int(11) NOT NULL,
  `result_id` int(11) NOT NULL,
  `result_val` text NOT NULL,
  PRIMARY KEY (`result_id`,`task_id`),
  KEY `task_result_ibfk_1` (`task_id`),
  CONSTRAINT `task_result_ibfk_1` FOREIGN KEY (`task_id`) REFERENCES `task_info` (`task_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_result`
--

LOCK TABLES `task_result` WRITE;
/*!40000 ALTER TABLE `task_result` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `update_info`
--

DROP TABLE IF EXISTS `update_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `update_info` (
  `update_id` int(11) NOT NULL AUTO_INCREMENT,
  `update_content` text NOT NULL,
  `ut` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`update_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `update_info`
--

LOCK TABLES `update_info` WRITE;
/*!40000 ALTER TABLE `update_info` DISABLE KEYS */;
INSERT INTO `update_info` VALUES (1,'更新算法一','2020-03-31 06:51:08'),(2,'更新测试算法二','2020-04-01 12:42:54');
/*!40000 ALTER TABLE `update_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_algorithm_mapper`
--

DROP TABLE IF EXISTS `web_algorithm_mapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `web_algorithm_mapper` (
  `web_algorithm_mapper_id` int(11) NOT NULL AUTO_INCREMENT,
  `parameter_id` int(11) DEFAULT NULL,
  `algorithm_id` int(11) DEFAULT NULL,
  `procedure_setting_id` int(11) DEFAULT NULL,
  `web_key` text NOT NULL,
  `algorithm_value` text NOT NULL,
  PRIMARY KEY (`web_algorithm_mapper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_algorithm_mapper`
--

LOCK TABLES `web_algorithm_mapper` WRITE;
/*!40000 ALTER TABLE `web_algorithm_mapper` DISABLE KEYS */;
INSERT INTO `web_algorithm_mapper` VALUES (1,50,15,NULL,'200','itr_num_200'),(2,50,15,NULL,'300','itr_num_300'),(3,50,15,NULL,'200_true','algorithm_true'),(4,50,15,NULL,'200_false','algorithm_false'),(5,50,15,NULL,'300_100','algorithm_100'),(6,50,15,NULL,'300_200','algorithm_200'),(7,50,15,NULL,'300_300','algorithm_300'),(8,NULL,16,7,'方法1','mew'),(9,NULL,16,7,'方法2','inti'),(10,NULL,17,8,'1','one'),(11,NULL,17,8,'2','two'),(12,NULL,17,8,'3','three'),(13,51,15,NULL,'100','test_radio_100'),(14,51,18,NULL,'200','test_radio_200'),(15,51,15,NULL,'30','test_radio_30'),(16,51,15,NULL,'40','test_radio_40'),(17,52,15,NULL,'200','test_seletion_200'),(18,52,15,NULL,'300','test_seletion_300'),(19,52,15,NULL,'200_100','100'),(20,52,15,NULL,'200_200','200'),(21,52,15,NULL,'200_300','300'),(22,NULL,18,9,'方法A','userA'),(23,NULL,18,9,'方法B','userB'),(24,NULL,18,9,'方法C','userC'),(25,53,16,NULL,'radio取值25','test_radio_25'),(26,53,16,NULL,'radio取值30','test_radio_30'),(27,54,16,NULL,'测试Selection25','test_selection_25'),(28,54,16,NULL,'测试Selection30','test_selection_30'),(29,54,16,NULL,'测试Selection25_100','100'),(30,54,16,NULL,'测试Selection25_200','200'),(31,54,16,NULL,'测试Selection25_300','300');
/*!40000 ALTER TABLE `web_algorithm_mapper` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-06 15:27:14
