/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : featureselectionweb

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-05-04 16:17:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for html_element_control
-- ----------------------------
DROP TABLE IF EXISTS `html_element_control`;
CREATE TABLE `html_element_control` (
  `module_key` varchar(50) NOT NULL DEFAULT '',
  `html_name` varchar(30) NOT NULL DEFAULT '',
  `type` varchar(10) NOT NULL,
  `ch_value` text NOT NULL,
  `en_value` text NOT NULL,
  PRIMARY KEY (`module_key`,`html_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of html_element_control
-- ----------------------------
INSERT INTO `html_element_control` VALUES ('aboutusinfo', 'aboutus', 'text', ' 广东工业大学是一所以工为主、工理经管文法艺结合、多科性协调发展的省属重点大学、广东省高水平大学重点建设高校，1995年由原广东工学院、广东机械学院和华南建设学院（东院）合并组建而成，1958年开办本科教育。六十多年来，学校始终坚持“与广东崛起共成长，为广东发展作贡献”的办学理念，加强与产业深度融合，不断推进内涵建设，办学实力、社会影响力和国际声誉日益提升。2019年首次进入THE（泰晤士高等教育）世界大学排行榜、软科世界大学学术排名“千强”名单，2020年泰晤士高等教育新兴经济体大学排名中国大陆高校第51位，USNews2020世界大学工科排行榜国内排名第45位、世界排名第268位。\r\n\r\n                            学校坐落于中国南方名城广州，拥有大学城、东风路、龙洞、番禺等多个校区，校园占地总面积3066.67亩，环境优美。大学城校区突出工科特色优势；东风路校区突出国际设计创意特色优势；龙洞校区突出管理学、理学、社工服务特色优势；番禺校区突出中外合作办学特色优势。\r\n\r\n                            目前，学校共设有20个学院、4个公共课教学部(中心)，拥有博士后科研流动站6个、省攀峰重点学科一级学科4个、省优势重点学科一级学科6个、省特色重点学科二级学科5个、一级学科博士学位授权点7个、二级学科博士学位授权点31个、一级学科硕士学位授权点23个、二级学科硕士学位授权点95个，硕士专业学位授予权13种，同时具有同等学力人员申请硕士学位授予权。机械、信息、材料、化工四个学科为广东省“211工程”三期重点建设学科。工程学、材料科学、计算机科学、化学、环境科学与生态学等5个学科进入ESI全球学科排名前1%行列，其中工程学已进入1.9‰。学校现有本科专业81个，招生专业（类）46个。目前全日制在校生44000余人，其中本科生36000余人，研究生7000余人，并招有不同层次的成人学历教育学生、港澳台生、国际学生，已形成“学士-硕士-博士”完整的人才培养体系。\r\n\r\n                            学校提出“以更加解放的思想、更加开放的姿态、更加创新的体制机制、更加勤奋务实的工作作风，集聚海内外创新人才，多模式构建创新平台，营造创新氛围，培养创新人才”的发展思路，全面实施大学生创新行动计划、研究生拔尖创新人才培育计划、研究生优质生源“千苗计划”、强师工程等重大战略。近年来，学校在人才培养、师资队伍、科研创新、社会服务等方面发展迅速，成效显著。\r\n\r\n                            学校高度重视高素质师资队伍建设，现有专任教师2000多人，拥有职称自主评审权，其中正高级职称400多人，副高级职称约700人。先后推出“百人计划”“青年百人计划”“培英育才计划”“教师出国研修计划”等，师资实力日益雄厚。目前拥有全职院士1人，聘有外籍院士4人、中国科学院院士2人、中国工程院院士4人，拥有“教育部高层次人才”、国家“杰青”、新世纪“百千万人才工程”人才、海外高层次人才、国家“优青”、教育部“新世纪优秀人才”等国家级人才达100多人次，珠江学者、青年珠江学者、省“杰青”等省级人才100多人次、省部级“创新团队”13个。高素质师资队伍的建设，为学校快速发展提供了强有力的人才支撑。\r\n\r\n                            学校科研工作坚持顶天立地战略，科研整体实力不断增强。学校建有省部共建国家重点实验室1个、国家地方联合工程实验室1个、国家地方联合工程研究中心1个、国家发改委现代服务业产业集聚基地1个、教育部重点实验室2个、教育部国际合作联合实验室1个、教育部协同创新中心1个、广东省重点实验室及其他省级科研平台70余个。2019年，国家自然科学基金项目立项数位列全国高校第59位，立项经费突破亿元；牵头承担国家重点研发计划项目5项，立项经费近1亿元。近五年来，学校以第一完成单位获得国家科学技术奖3项，其中2019年获国家技术发明奖二等奖、国家科技进步二等奖各1项；获省部级科技奖一等奖12项，其中2019年获教育部科技奖自然科学一等奖1项、省科技一等奖4项、省科技合作奖1项；获教育部高等学校科学研究优秀成果奖（人文社会科学）3项，其中2019年获二等奖2项，获广东省哲学社会科学优秀成果奖一等奖4项。获中国专利优秀奖6项，学校发明专利授权位列全国高校第31位。\r\n\r\n                            学校不断加强与产业深度融合，与地方政府和工业界联合建立了“广州国家现代服务业集成电路设计产业化基地”“佛山广工大数控装备协同创新研究院”“东莞华南设计创新院”“河源广工大协同创新研究院”“惠州广工大物联网协同创新研究院”“汕头广工大协同创新研究院”“云浮创新设计中心”“东源广工大现代产业协同创新研究院”等多个跨学科协同创新平台，推动广东国防科技工业技术成果产业化应用推广中心落地，前期投入6亿元资助中心建设。学校致力于在高端装备、智能制造、IC设计、工业设计、先进材料、环境生态、生物制药、软物质等多个领域构建高水平协同创新平台，促进产学研和协同创新取得实质性成果，助力地方经济社会高质量发展。\r\n\r\n                            学校坚持开放办学，不断加强对外合作与交流，先后与国（境）外150多所知名大学和机构建立合作关系，开展学生培养、教学改革、师资培养、人才引进、科研创新、平台建设等多方面合作，为学校人才培养国际化、师资队伍国际化和科研工作国际化创造条件、提供良好平台。学校高度重视服务国家“一带一路”倡议，加强国际化人才培养，支持“一带一路”沿线国家学生来华留学与技术培训。现有国家外专局和教育部“高等学校学科创新引智计划”（“111计划”）1个、粤港澳离散制造智能化联合实验室1个，开办有中外合作办学项目动画专业1个，机械设计制造及其自动化、电气工程及其自动化、土木工程、计算机科学与技术、工商管理专业本科国际班5个。\r\n\r\n                            学校落实立德树人根本任务，努力培养有家国情怀、有国际视野、有坚实基础、有创新能力的高素质人才。现有教育部卓越工程师教育培养计划专业7个、国家级特色专业建设点7个、国家级专业综合改革试点专业1个、教育部专业认证/评估通过15个、广东省名牌专业13个、省级特色专业18个、省级重点专业5个、省级专业综合改革试点专业16个，国家级精品课程（含双语教学示范课程）3门、省级精品课程（含双语教学示范课程）99门，国家级工程实践教育中心7个、国家级研究生联合培养示范基地2个、国家级大学生实践教学基地1个、省级大学生实践教学基地38个，国家级实验教学示范中心3个、国家级虚拟仿真实验教学中心1个、省级实验教学示范中心24个、省级虚拟仿真实验教学中心3个，拥有教育部教学指导委员会委员8人、国家级教学团队1个、省级教学团队18个、省教学名师16人。近五年来，获国家级教学成果二等奖2项，省级教学成果一等奖14项、二等奖21项。学校办学条件良好，校舍建筑面积161万余平方米，现有计算机15500台套，教学、科研仪器设备固定资产总值15.21亿元，拥有藏书401.1万册、电子图书237.04万册。\r\n\r\n                            学校高度重视创新创业教育和文化素质教育。通过一系列创新政策和举措，学生创新能力和综合素质不断提高，学生在全国各类科技创新竞赛、文化体育竞赛中屡创佳绩。中国高等教育学会2019全国普通高校学科竞赛排行榜位居36位。2013-2019年，学校连续四届捧得“挑战杯”全国赛“优胜杯”，获特等奖4项；2012-2018年，学校连续四届夺得“创青春”全国赛金奖，其中2018年摘得金奖2项，并捧得“优胜杯”；2018年，第42届ACM-ICPC全球总决赛总排名第32位、国内高校排名第8位；2017年，我校FSAE车队获中国大学生方程式汽车大赛总成绩第一名；2018年，我校学生荣获美国大学生数学建模竞赛一等奖18项；2017-2018年，我校学生获得德国RED\r\n                            DOT（红点）设计大奖1项、德国IF DEGIGN TALENT AWAARD\r\n                            大奖4项；我校“北斗”团队、“QG工作室”获评“小平科技创新团队”，近五年有3名大学生分别获得第七届、第十届、第十一届中国青少年科技创新奖。学校男子篮球队连续三年获全国大超联赛总冠军，2011年获第八届亚洲大学篮球锦标赛冠军；足球队获2018-2019CUFA全国大学生校园足球联赛大学男子校园组总冠军，第24届中国大学生乒乓球锦标赛（超级组）获男子单打冠军，2019年中国大学生阳光体育游泳比赛获男子200米自由泳第一名。近年来，学生在声乐、器乐和舞蹈集体项目上获全国大学生艺术展演一等奖、全国大学生素质教育艺术品牌金奖等50余项。\r\n\r\n                            学校坚持以习近平新时代中国特色社会主义思想为指导，深入贯彻习近平总书记对广东重要讲话和重要指示批示精神，抢抓粤港澳大湾区建设重大历史机遇，坚持改革创新，不断促进高质量发展，努力建设以工为主、与产业深度融合、极具创造活力的“特色鲜明、国内一流、世界知名”的高水平大学。', '广东工业大学是一所以工为主、工理经管文法艺结合、多科性协调发展的省属重点大学、广东省高水平大学重点建设高校，1995年由原广东工学院、广东机械学院和华南建设学院（东院）合并组建而成，1958年开办本科教育。六十多年来，学校始终坚持“与广东崛起共成长，为广东发展作贡献”的办学理念，加强与产业深度融合，不断推进内涵建设，办学实力、社会影响力和国际声誉日益提升。2019年首次进入THE（泰晤士高等教育）世界大学排行榜、软科世界大学学术排名“千强”名单，2020年泰晤士高等教育新兴经济体大学排名中国大陆高校第51位，USNews2020');
INSERT INTO `html_element_control` VALUES ('aboutustitle', 'aboutus', 'text', '关于我们', 'aboutus');
INSERT INTO `html_element_control` VALUES ('accounttitle', 'login', 'text', '账号', 'Account');
INSERT INTO `html_element_control` VALUES ('algorithms_filter', 'execution_algorithms', 'filter_btn', '筛选', 'Filter');
INSERT INTO `html_element_control` VALUES ('algorithms_filter1', 'execution_algorithms', 'title', '搜索', 'Search');
INSERT INTO `html_element_control` VALUES ('algorithms_filter2', 'execution_algorithms', 'title', '计算方式', 'Calculation');
INSERT INTO `html_element_control` VALUES ('algorithms_filter3', 'execution_algorithms', 'title', '系列', 'Series');
INSERT INTO `html_element_control` VALUES ('algorithms_info_how', 'execution_algorithms', 'title', '如何使用', 'How to start');
INSERT INTO `html_element_control` VALUES ('algorithms_info_how_context', 'execution_algorithms', 'html', '<p class=\"card-text\">上述步骤帮助你快速使用算法</p>', '<p class=\"card-text\">Follow these steps help you get start quickly.</p>');
INSERT INTO `html_element_control` VALUES ('algorithms_info_how_img', 'execution_algorithms', 'img', 'pic/timg.jpg', 'pic/timg.jpg');
INSERT INTO `html_element_control` VALUES ('algorithms_info_intro', 'execution_algorithms', 'title', '算法介绍', 'Introduction');
INSERT INTO `html_element_control` VALUES ('algorithms_info_papers', 'execution_algorithms', 'title', '文献来源', 'Papers');
INSERT INTO `html_element_control` VALUES ('algorithms_info_parameter', 'execution_algorithms', 'title', '参数信息', 'Parameters of the algorithm');
INSERT INTO `html_element_control` VALUES ('algorithms_info_parameter_footer', 'execution_algorithms', 'text', '参数', 'Parameter');
INSERT INTO `html_element_control` VALUES ('algorithms_info_parameter_li1', 'execution_algorithms', 'li', '类型：', 'Type:');
INSERT INTO `html_element_control` VALUES ('algorithms_info_parameter_li2', 'execution_algorithms', 'li', '默认值：', 'Default Value:');
INSERT INTO `html_element_control` VALUES ('algorithms_info_title', 'execution_algorithms', 'title', '特征算法', 'Feature Selection Algorithm');
INSERT INTO `html_element_control` VALUES ('algorithms_search', 'execution_algorithms', 'text', '搜索', 'Search');
INSERT INTO `html_element_control` VALUES ('already', 'register', 'text', '准备拥有一个账户', 'Already have an account');
INSERT INTO `html_element_control` VALUES ('button_text1', 'guide', 'text', '试一试', 'Try');
INSERT INTO `html_element_control` VALUES ('button_text2', 'guide', 'text', '学习更多', 'Learn More');
INSERT INTO `html_element_control` VALUES ('contactustitle', 'aboutus', 'text', '联系我们', 'contact us');
INSERT INTO `html_element_control` VALUES ('datasetinfotitle', 'schemesDetails', 'text', '数据集信息', 'DatasetInfo');
INSERT INTO `html_element_control` VALUES ('dataset_info_p1', 'execution_main', 'text', '简介', 'Introduction');
INSERT INTO `html_element_control` VALUES ('dataset_info_p2', 'execution_main', 'text', '数据源', 'Source');
INSERT INTO `html_element_control` VALUES ('dataset_info_p3', 'execution_main', 'text', '大小', 'Size');
INSERT INTO `html_element_control` VALUES ('dataset_info_p4', 'execution_main', 'text', '维度', 'Dimension:');
INSERT INTO `html_element_control` VALUES ('dataset_info_p5', 'execution_main', 'text', '记录数', 'Records:');
INSERT INTO `html_element_control` VALUES ('dataset_info_p6', 'execution_main', 'text', '标签数', 'Tags:');
INSERT INTO `html_element_control` VALUES ('dataset_info_p7', 'execution_main', 'text', '类型', 'Type:');
INSERT INTO `html_element_control` VALUES ('givittry', 'algorithms', 'text', '尝试一下', 'Give It a Try');
INSERT INTO `html_element_control` VALUES ('guidetext', 'guide', 'text', '特征选择算法研究', 'Reseraches on Feature Selection');
INSERT INTO `html_element_control` VALUES ('home_text', 'execution_home', 'text', '这里我们为您提供了很多算法，希望能帮助您更好地分析数据集，做出更好的决策。', 'Here we provide you with a lot of algorithms and hope to help you analysis your datasets better and make better decisions.');
INSERT INTO `html_element_control` VALUES ('home_title', 'execution_home', 'title', '欢迎来到执行器系统', 'Welcome to Executions');
INSERT INTO `html_element_control` VALUES ('home_ul1', 'execution_home', 'title', '特色', 'What You Can Do?');
INSERT INTO `html_element_control` VALUES ('home_ul1_li1', 'execution_home', 'li', '使用全部的算法', 'Use all algorithm');
INSERT INTO `html_element_control` VALUES ('home_ul1_li2', 'execution_home', 'li', '自定义所有参赛', 'Costumed all parameter');
INSERT INTO `html_element_control` VALUES ('home_ul1_li3', 'execution_home', 'li', '上传你的数据集', 'Upload your own dataset');
INSERT INTO `html_element_control` VALUES ('home_ul1_li4', 'execution_home', 'li', '随时查询你的订单', 'Check Your Task Anytime');
INSERT INTO `html_element_control` VALUES ('home_ul2', 'execution_home', 'title', '如何开始？', 'How to Start?');
INSERT INTO `html_element_control` VALUES ('home_ul2_li1', 'execution_home', 'li', '选择算法', 'Step1:Choose an algorithm that you need.');
INSERT INTO `html_element_control` VALUES ('home_ul2_li2', 'execution_home', 'li', '上传数据集', 'Step2:Upload your dataset or choose a public dataset.');
INSERT INTO `html_element_control` VALUES ('home_ul2_li3', 'execution_home', 'li', '选择参数配置算法', 'Step3:Set up parameters or choose situation.');
INSERT INTO `html_element_control` VALUES ('home_ul2_li4', 'execution_home', 'li', '等待结果', 'Step4:Waiting for result.');
INSERT INTO `html_element_control` VALUES ('introductionusinfo', 'aboutus', 'text', 'Cillum ad ut irure tempor velit nostrud occaecat\r\n                            ullamco aliqua anim Lorem sint. Veniam sint duis incididunt do esse magna mollit excepteur\r\n                            laborum qui. Id id reprehenderit sit est eu aliqua occaecat quis et velit excepteur laborum\r\n                            mollit dolore eiusmod. Ipsum dolor in occaecat commodo et voluptate minim reprehenderit\r\n                            mollit pariatur. Deserunt non laborum enim et cillum eu deserunt excepteur ea incididunt\r\n                            minim occaecat.', 'Cillum ad ut irure tempor velit nostrud occaecat\r\n                            ullamco aliqua anim Lorem sint. Veniam sint duis incididunt do esse magna mollit excepteur\r\n                            laborum qui. Id id reprehenderit sit est eu aliqua occaecat quis et velit excepteur laborum\r\n                            mollit dolore eiusmod. Ipsum dolor in occaecat commodo et voluptate minim reprehenderit\r\n                            mollit pariatur. Deserunt non laborum enim et cillum eu deserunt excepteur ea incididunt\r\n                            minim occaecat.');
INSERT INTO `html_element_control` VALUES ('introductionustitle', 'aboutus', 'text', '人员介绍', 'introduction of us');
INSERT INTO `html_element_control` VALUES ('log', 'login', 'text', '登陆', 'Log');
INSERT INTO `html_element_control` VALUES ('logintitle', 'login', 'text', '登陆', 'Login');
INSERT INTO `html_element_control` VALUES ('modal_btn_cancel', 'execution_main', 'btn', '取消', 'cancel');
INSERT INTO `html_element_control` VALUES ('modal_btn_close', 'execution_main', 'btn', '关闭', 'Close');
INSERT INTO `html_element_control` VALUES ('modal_btn_confirm', 'execution_main', 'text', '确定', 'Confirm');
INSERT INTO `html_element_control` VALUES ('modal_btn_save', 'execution_main', 'btn', '保存', 'Save');
INSERT INTO `html_element_control` VALUES ('modal_btn_submit', 'execution_main', 'btn', '提交', 'Submit');
INSERT INTO `html_element_control` VALUES ('navBody_a1', 'execution_main', 'nav_li', '首页', 'Home');
INSERT INTO `html_element_control` VALUES ('navBody_a2', 'execution_main', 'nav_li', '算法列表', 'Algorithms');
INSERT INTO `html_element_control` VALUES ('navBody_a3', 'execution_main', 'nav_li', '创建任务', 'New Task');
INSERT INTO `html_element_control` VALUES ('navBody_a4', 'execution_main', 'nav_li', '查询任务', 'Query Task');
INSERT INTO `html_element_control` VALUES ('navBody_a5', 'execution_main', 'nav_li', '公共数据集', 'Public Dataset');
INSERT INTO `html_element_control` VALUES ('navHead_btn1', 'execution_main', 'nav_btn', '登录', 'Login');
INSERT INTO `html_element_control` VALUES ('navHead_li1', 'execution_main', 'nav_li', '快速开始', 'Getting Start');
INSERT INTO `html_element_control` VALUES ('navHead_li2', 'execution_main', 'nav_li', '执行器', 'Executions');
INSERT INTO `html_element_control` VALUES ('navHead_li3', 'execution_main', 'nav_li', '关于我们', 'About us');
INSERT INTO `html_element_control` VALUES ('new_task_navbar_a1', 'execution_new_task', 'text', '数据集', 'Dataset');
INSERT INTO `html_element_control` VALUES ('new_task_navbar_a2', 'execution_new_task', 'text', '算法', 'Algorithm');
INSERT INTO `html_element_control` VALUES ('new_task_navbar_a3', 'execution_new_task', 'text', '基本信息', 'Basic Info');
INSERT INTO `html_element_control` VALUES ('new_task_step1', 'execution_new_task', 'text', '第一步：选择数据集', 'Step1: Choose dataset');
INSERT INTO `html_element_control` VALUES ('new_task_step1_feedback1', 'execution_new_task', 'text', '错误！', 'Error!');
INSERT INTO `html_element_control` VALUES ('new_task_step1_feedback2', 'execution_new_task', 'html', '<strong>还没有选择数据集！</strong>请选择', '<strong>Has not selected an dataset!</strong>Please select one.');
INSERT INTO `html_element_control` VALUES ('new_task_step1_label1', 'execution_new_task', 'label', '选择一个公共数据集或者上传一个数据集', 'Select a public dataset or upload a dataset.');
INSERT INTO `html_element_control` VALUES ('new_task_step1_label2', 'execution_new_task', 'label', '选择一个数据集文件(仅支持.csv .xlsx .xls)', 'Choose file(.csv .xlsx .xls) from disk.');
INSERT INTO `html_element_control` VALUES ('new_task_step1_select_default', 'execution_new_task', 'text', '选择一个公共数据集', 'Select a public Dataset');
INSERT INTO `html_element_control` VALUES ('new_task_step2', 'execution_new_task', 'text', '第二步：选择算法并设置参数', 'Step2: Choose and custom Algorithm');
INSERT INTO `html_element_control` VALUES ('new_task_step2_card_btn1', 'execution_new_task', 'btn', '详细信息', 'More');
INSERT INTO `html_element_control` VALUES ('new_task_step2_card_btn2', 'execution_new_task', 'btn', '选择算法', 'Select');
INSERT INTO `html_element_control` VALUES ('new_task_step2_card_p1', 'execution_new_task', 'text', '最近更新', 'Last Update');
INSERT INTO `html_element_control` VALUES ('new_task_step2_feedback1', 'execution_new_task', 'html', '<strong>还未选择算法。</strong>请选择!', '<strong>Has not selected an algorithm!</strong>Please select one.');
INSERT INTO `html_element_control` VALUES ('new_task_step3', 'execution_new_task', 'text', '第三步：填写基本信息', 'Step3: Fill in BasicInfo');
INSERT INTO `html_element_control` VALUES ('new_task_step3_card_label1', 'execution_new_task', 'label', '邮箱', 'E-mail');
INSERT INTO `html_element_control` VALUES ('new_task_step3_card_label2', 'execution_new_task', 'label', '名字', 'Name');
INSERT INTO `html_element_control` VALUES ('new_task_step3_card_label3', 'execution_new_task', 'label', '简介', 'Comment');
INSERT INTO `html_element_control` VALUES ('new_task_step3_card_label4', 'execution_new_task', 'label', '是否使用邮箱接收结果', 'Use email to receive result');
INSERT INTO `html_element_control` VALUES ('new_task_step3_feedback1', 'execution_new_task', 'text', '邮箱格式错误！', 'Not an email!');
INSERT INTO `html_element_control` VALUES ('new_task_step3_feedback2', 'execution_new_task', 'text', '已使用', 'Has used!Please change');
INSERT INTO `html_element_control` VALUES ('new_task_step_btn1', 'execution_new_task', 'btn', '提交', 'Submit');
INSERT INTO `html_element_control` VALUES ('notaccount', 'login', 'text', '没有账号？', 'not account？');
INSERT INTO `html_element_control` VALUES ('pagetitle', 'aboutus', 'text', '关于我们', 'About Us');
INSERT INTO `html_element_control` VALUES ('parametertitle', 'schemesDetails', 'text', '参数及参数值列表', 'Parameters and Values list here');
INSERT INTO `html_element_control` VALUES ('passwordtitle', 'login', 'text', '密码', 'Password');
INSERT INTO `html_element_control` VALUES ('public_dataset_check_th1', 'execution_public_dataset', 'text', '提交时间', 'Submit Time');
INSERT INTO `html_element_control` VALUES ('public_dataset_check_title1', 'execution_public_dataset', 'title', '我的上传', 'Your Uploads');
INSERT INTO `html_element_control` VALUES ('public_dataset_intro_btn1', 'execution_public_dataset', 'btn', '上传公共数据集', 'Upload Dataset');
INSERT INTO `html_element_control` VALUES ('public_dataset_intro_btn2', 'execution_public_dataset', 'btn', '查看我的上传', 'Check My Uploads');
INSERT INTO `html_element_control` VALUES ('public_dataset_intro_p1', 'execution_public_dataset', 'text', '你可以获取所有公共数据的信息并下载它。', 'You can get all the dataset information and download them.');
INSERT INTO `html_element_control` VALUES ('public_dataset_intro_title', 'execution_public_dataset', 'title', '下表所有公共数据集', 'The followings are public datasets available!');
INSERT INTO `html_element_control` VALUES ('public_dataset_list_btn1', 'execution_public_dataset', 'btn', '下载', 'Download');
INSERT INTO `html_element_control` VALUES ('public_dataset_upload_label1', 'execution_public_dataset', 'text', '预处理说明', 'Preprocessing');
INSERT INTO `html_element_control` VALUES ('public_dataset_upload_label2', 'execution_public_dataset', 'text', '可用算法', 'Algorithm');
INSERT INTO `html_element_control` VALUES ('public_dataset_upload_label3', 'execution_public_dataset', 'text', '数据集', 'Dataset');
INSERT INTO `html_element_control` VALUES ('public_dataset_upload_title1', 'execution_public_dataset', 'title', '上传公共数据集', 'Upload a Public Dataset\r\n');
INSERT INTO `html_element_control` VALUES ('query_task_chart_title', 'execution_query_task', 'title', '结果集', 'Results');
INSERT INTO `html_element_control` VALUES ('query_task_delete_context', 'execution_query_task', 'text', '确定删除 ', 'You are sure delete to delete ');
INSERT INTO `html_element_control` VALUES ('query_task_delete_warning', 'execution_query_task', 'text', '警告', 'Warning');
INSERT INTO `html_element_control` VALUES ('query_task_table_th1', 'execution_query_task', 'text', 'id', 'id');
INSERT INTO `html_element_control` VALUES ('query_task_table_th2', 'execution_query_task', 'text', '名字', 'Name');
INSERT INTO `html_element_control` VALUES ('query_task_table_th3', 'execution_query_task', 'text', '简介', 'Comment');
INSERT INTO `html_element_control` VALUES ('query_task_table_th4', 'execution_query_task', 'text', '状态', 'Status');
INSERT INTO `html_element_control` VALUES ('query_task_table_th5', 'execution_query_task', 'text', '操作', 'Options');
INSERT INTO `html_element_control` VALUES ('register', 'login', 'text', '注册', 'Register');
INSERT INTO `html_element_control` VALUES ('register', 'register', 'text', '注册', 'Register');
INSERT INTO `html_element_control` VALUES ('registeremail', 'register', 'text', '邮箱', 'Email');
INSERT INTO `html_element_control` VALUES ('registerpassword', 'register', 'text', '密码', 'Password');
INSERT INTO `html_element_control` VALUES ('registerreason', 'register', 'text', '申请原因', 'applyReason');
INSERT INTO `html_element_control` VALUES ('registersuccess', 'register', 'text', '成功完成了提交', 'success to commit');
INSERT INTO `html_element_control` VALUES ('registertitle', 'register', 'text', '注册', 'Register');
INSERT INTO `html_element_control` VALUES ('resulttext', 'algorithms', 'text', '运行处理结果图表', 'navicat for result');
INSERT INTO `html_element_control` VALUES ('run', 'algorithms', 'text', '运行', 'text');
INSERT INTO `html_element_control` VALUES ('schemehead', 'algorithms', 'text', '以下是运行方案细节', 'The following is the detail of schemes');
INSERT INTO `html_element_control` VALUES ('schemesdetailstitle', 'schemesDetails', 'text', '方案详情', 'SchemesDetails');
INSERT INTO `html_element_control` VALUES ('title', 'algorithms', 'text', '实现特征选择算法', 'Implemented Feature Selection Algorithms');
INSERT INTO `html_element_control` VALUES ('updatetitle', 'updates', 'text', '更新', 'Update');
