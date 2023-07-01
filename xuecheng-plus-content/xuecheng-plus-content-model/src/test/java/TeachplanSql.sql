DROP TABLE IF EXISTS `teachplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachplan` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `pname` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程计划名称',
  `parentid` BIGINT NOT NULL COMMENT '课程计划父级Id',
  `grade` SMALLINT NOT NULL COMMENT '层级，分为1、2、3级',
  `media_type` VARCHAR(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课程类型:1视频、2文档',
  `start_time` DATETIME DEFAULT NULL COMMENT '开始直播时间',
  `end_time` DATETIME DEFAULT NULL COMMENT '直播结束时间',
  `description` VARCHAR(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '章节及课程时介绍',
  `timelength` VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '时长，单位时:分:秒',
  `orderby` INT DEFAULT '0' COMMENT '排序字段',
  `course_id` BIGINT NOT NULL COMMENT '课程标识',
  `course_pub_id` BIGINT DEFAULT NULL COMMENT '课程发布标识',
  `status` INT NOT NULL DEFAULT '1' COMMENT '状态（1正常  0删除）',
  `is_preview` CHAR(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '是否支持试学或预览（试看）',
  `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
  `change_date` DATETIME DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=INNODB AUTO_INCREMENT=290 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='课程计划';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachplan`
--

LOCK TABLES `teachplan` WRITE;
/*!40000 ALTER TABLE `teachplan` DISABLE KEYS */;
INSERT INTO `teachplan` (`id`, `pname`, `parentid`, `grade`, `media_type`, `start_time`, `end_time`, `description`, `timelength`, `orderby`, `course_id`, `course_pub_id`, `status`, `is_preview`, `create_date`, `change_date`) VALUES (2,'数据库基础知识',43,2,'1','2019-09-16 10:45:36',NULL,NULL,NULL,1,25,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(3,'SQL查询',43,2,'1','2019-09-16 10:45:36',NULL,NULL,NULL,3,25,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(4,'SQL优化',43,2,'1','2019-09-16 10:45:36',NULL,NULL,NULL,2,25,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(5,'微服务架构入门',0,1,NULL,'2019-09-16 10:45:36',NULL,'微服务架构入门',NULL,1,26,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(6,'spring cloud 基础入门',0,1,NULL,'2019-09-16 10:45:36',NULL,'spring cloud 基础入门',NULL,2,26,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(7,'实战-Spring Boot',0,1,NULL,'2019-09-16 10:45:36',NULL,'实战-Spring Boot',NULL,3,26,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(8,'注册中心Eureka',0,1,NULL,'2019-09-16 10:45:36',NULL,'注册中心Eureka','55.00',4,26,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(9,'为什么要使用微服务:微服务的优缺点',13,2,'1','2019-09-16 10:45:36',NULL,'为什么要使用微服务:微服务的优缺点','55.00',2,26,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(10,'为什么要使用微服务:单体架构的特点',13,2,'1','2019-09-16 10:45:36',NULL,'为什么要使用微服务:单体架构的特点','44.00',1,26,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(11,'为什么springcloud要设计一套新的版本升级规则？',14,2,'1','2019-09-16 10:45:36',NULL,'为什么springcloud要设计一套新的版本升级规则？','33.00',2,26,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(12,'计算机原理',0,1,'0','2019-09-16 10:45:36',NULL,'介绍计算机工作原理',NULL,1,25,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(13,'为什么要选择spring cloud?',14,2,'1','2019-09-16 10:45:36',NULL,'为什么要选择spring cloud?','12.00',1,26,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(14,'spring boot的入门例子',15,2,'1','2019-09-16 10:45:36',NULL,'spring boot的入门例子','44.00',2,26,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(16,'为什么越来越多的开发者选择使用spring boot？它解决了什么问题？',15,2,'1','2019-09-16 10:45:36',NULL,'为什么越来越多的开发者选择使用spring boot？它解决了什么问题？','10.00',1,26,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(17,' 一个Eureka注册中心的入门例子',16,2,'1','2019-09-16 10:45:36',NULL,' 一个Eureka注册中心的入门例子','22.00',2,26,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(18,'微服务架构为什么需要注册中心，它解决了什么问题？',16,2,'1','2019-09-16 10:45:36',NULL,'微服务架构为什么需要注册中心，它解决了什么问题？','33.00',1,26,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(20,'Vuejs 第一讲',0,1,NULL,'2019-09-16 10:45:36',NULL,'Vuejs 第一讲',NULL,1,27,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(21,'Vuejs 第二讲',0,1,NULL,'2019-09-16 10:45:36',NULL,NULL,NULL,2,43,23,203002,NULL,'2019-09-16 10:45:36','2019-11-19 00:55:16'),(22,'Vuejs 第三讲',0,1,NULL,'2019-09-16 10:45:36',NULL,NULL,NULL,3,27,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(23,'计算机硬件',2,2,'1','2019-09-16 10:45:36',NULL,NULL,'10.00',1,25,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(24,'第一节 vue基础、常用指令、bootstrap+vue的简易留言',20,2,'1','2019-09-16 10:45:36',NULL,'第一节 vue基础、常用指令、bootstrap+vue的简易留言','22.00',1,27,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(25,'第二节 属性和事件、模板、交互、案例',20,2,'1','2019-09-16 10:45:36',NULL,'第二节 属性和事件、模板、交互、案例','33.00',2,27,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(26,'第一节 计算属性的使用、vue实例的简单方法、提高循环的性能，让重复数据显示出来',21,2,NULL,'2019-09-16 10:45:36',NULL,NULL,NULL,1,27,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(27,'第二节 自定义过滤器、自定义指令 、自定义键盘事件、数据的监听',21,2,'1','2019-09-16 10:45:36',NULL,NULL,NULL,2,27,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(29,'第一章：redis简介',0,1,NULL,'2019-09-16 10:45:36',NULL,NULL,NULL,1,28,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(30,'第二章：redis的安装与配置',0,1,NULL,'2019-09-16 10:45:36',NULL,NULL,NULL,2,28,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(31,'第三章：Redis数据操作',0,1,NULL,'2019-09-16 10:45:36',NULL,NULL,NULL,3,28,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(32,'第四章：Redis进阶操作',0,1,NULL,'2019-09-16 10:45:36',NULL,NULL,NULL,4,28,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(33,'第五章：Redis主从配置',0,1,NULL,'2019-09-16 10:45:36',NULL,NULL,NULL,5,28,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(34,'计算机软件',2,2,'1','2019-09-16 10:45:36',NULL,NULL,'12.00',2,25,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(35,'操作系统类型介绍',12,2,'1','2019-09-16 10:45:36',NULL,'操作系统类型介绍操作系统类型介绍','11.00',2,25,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(36,'操作系统原理',12,2,'1','2019-09-16 10:45:36',NULL,'操作系统原理操作系统原理操作系统原理操作系统原理','22.00',1,25,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(37,'第一节 NoSQL简介',29,2,'1','2019-09-16 10:45:36',NULL,NULL,NULL,1,28,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(38,'第二节 认识Redis',29,2,'1','2019-09-16 10:45:36',NULL,NULL,NULL,2,28,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(39,'计算机编程入门',0,1,'0','2019-09-16 10:45:36',NULL,NULL,NULL,3,25,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(40,'java语法介绍',39,2,'1','2019-09-16 10:45:36',NULL,NULL,NULL,2,25,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(41,'Hello World',39,2,'1','2019-09-16 10:45:36',NULL,NULL,NULL,1,25,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(43,'数据库编程',0,1,'1','2019-09-16 10:45:36',NULL,'数据库编程数据库编程','11.00',2,25,NULL,0,NULL,'2019-09-16 10:45:36',NULL),(110,'第一章',0,1,NULL,NULL,NULL,NULL,NULL,1,72,NULL,1,'0','2021-12-25 16:27:34',NULL),(111,'第一小节',110,2,NULL,NULL,NULL,NULL,NULL,1,72,NULL,1,'0','2021-12-25 16:27:42',NULL),(113,'第1章基础知识',0,1,NULL,NULL,NULL,NULL,NULL,1,74,NULL,1,'0','2021-12-25 17:53:12',NULL),(115,'第1节项目概述',113,2,'001002',NULL,NULL,NULL,NULL,1,74,NULL,1,'0','2021-12-25 17:53:17',NULL),(117,'新章名称 [点击修改]',0,1,NULL,NULL,NULL,NULL,NULL,1,75,NULL,1,'0','2021-12-26 18:21:51',NULL),(118,'新章名称 [点击修改]',0,1,NULL,NULL,NULL,NULL,NULL,2,75,NULL,1,'0','2021-12-26 18:29:48',NULL),(121,'第一大章节',0,1,NULL,NULL,NULL,NULL,NULL,1,76,NULL,1,'0','2021-12-26 19:59:43',NULL),(122,'新章名称 [点击修改]',0,1,NULL,NULL,NULL,NULL,NULL,1,76,NULL,1,'0','2021-12-26 19:59:43',NULL),(123,'第一小节',121,2,NULL,NULL,NULL,NULL,NULL,1,76,NULL,1,'0','2021-12-26 19:59:46',NULL),(125,'第一大章节',0,1,NULL,NULL,NULL,NULL,NULL,1,77,NULL,1,'0','2021-12-26 20:02:08',NULL),(126,'第一小节',125,2,NULL,NULL,NULL,NULL,NULL,1,77,NULL,1,'0','2021-12-26 20:02:24',NULL),(128,'第一大章',0,1,NULL,NULL,NULL,NULL,NULL,1,78,NULL,1,'0','2021-12-26 20:54:25',NULL),(129,'第一小节',128,2,NULL,NULL,NULL,NULL,NULL,1,78,NULL,1,'0','2021-12-26 20:54:40',NULL),(131,'新小节名称 [点击修改]',128,2,NULL,NULL,NULL,NULL,NULL,3,78,NULL,1,'0','2021-12-26 20:55:40',NULL),(135,'新小节名称 [点击修改]',121,2,'001004',NULL,NULL,NULL,NULL,2,76,NULL,1,'0','2021-12-27 09:56:49',NULL),(137,'Spring1',0,1,NULL,NULL,NULL,NULL,NULL,1,79,NULL,1,'0','2021-12-27 10:34:41',NULL),(138,'Spring1.2',137,2,NULL,NULL,NULL,NULL,NULL,1,79,NULL,1,'0','2021-12-27 10:34:52',NULL),(139,'Spring2',0,1,NULL,NULL,NULL,NULL,NULL,2,79,NULL,1,'0','2021-12-27 10:34:59',NULL),(141,'Java Web1',0,1,NULL,NULL,NULL,NULL,NULL,1,80,NULL,1,'0','2021-12-27 11:08:35',NULL),(142,'Java Web1.1',141,2,NULL,NULL,NULL,NULL,NULL,1,80,NULL,1,'0','2021-12-27 11:08:40',NULL),(143,'Java Web2',0,1,NULL,NULL,NULL,NULL,NULL,2,80,NULL,1,'0','2021-12-27 11:09:05',NULL),(144,'Java Web2.1',143,2,NULL,NULL,NULL,NULL,NULL,1,80,NULL,1,'0','2021-12-27 11:09:10',NULL),(146,'什么是微服务',0,1,NULL,NULL,NULL,NULL,NULL,1,82,NULL,1,'1','2021-12-27 11:28:07',NULL),(147,'什么是微服务',146,2,NULL,NULL,NULL,NULL,NULL,1,82,NULL,1,'1','2021-12-27 11:28:14',NULL),(148,'Spring Boot入门',0,1,NULL,NULL,NULL,NULL,NULL,2,82,NULL,1,'1','2021-12-27 11:28:35',NULL),(149,'入门程序',148,2,NULL,NULL,NULL,NULL,NULL,1,82,NULL,1,'1','2021-12-27 11:28:41',NULL),(152,'123',0,1,NULL,NULL,NULL,NULL,NULL,1,83,NULL,1,'0','2021-12-27 12:22:08',NULL),(153,'123456',152,2,'001002',NULL,NULL,NULL,NULL,1,83,NULL,1,'0','2021-12-27 12:22:14',NULL),(154,'456',0,1,NULL,NULL,NULL,NULL,NULL,2,83,NULL,1,'0','2021-12-27 12:22:23',NULL),(155,'123456',154,2,'001004',NULL,NULL,NULL,NULL,1,83,NULL,1,'0','2021-12-27 12:22:29',NULL),(157,'Spring Cloud1',0,1,NULL,NULL,NULL,NULL,NULL,1,84,NULL,1,'0','2021-12-27 13:42:06',NULL),(158,'Spring Cloud1.1',157,2,'001002',NULL,NULL,NULL,NULL,1,84,NULL,1,'1','2021-12-27 13:42:12',NULL),(159,'Spring Cloud2',0,1,NULL,NULL,NULL,NULL,NULL,2,84,NULL,1,'0','2021-12-27 13:42:18',NULL),(160,'Spring Cloud2.1',159,2,'001004',NULL,NULL,NULL,NULL,1,84,NULL,1,'1','2021-12-27 13:42:23',NULL),(162,'第一章',0,1,NULL,NULL,NULL,NULL,NULL,1,85,NULL,1,'0','2021-12-27 15:55:03',NULL),(163,'第二章',0,1,NULL,NULL,NULL,NULL,NULL,2,85,NULL,1,'0','2021-12-27 15:55:04',NULL),(164,'第三章',0,1,NULL,NULL,NULL,NULL,NULL,3,85,NULL,1,'0','2021-12-27 15:55:05',NULL),(165,'第一小节',162,2,'001004',NULL,NULL,NULL,NULL,1,85,NULL,1,'0','2021-12-27 15:55:06',NULL),(166,'第一小节',163,2,'001004',NULL,NULL,NULL,NULL,1,85,NULL,1,'0','2021-12-27 15:55:07',NULL),(167,'第二小节',162,2,'001002',NULL,NULL,NULL,NULL,2,85,NULL,1,'0','2021-12-27 15:55:08',NULL),(168,'第一章',164,2,'001002',NULL,NULL,NULL,NULL,1,85,NULL,1,'0','2021-12-27 15:55:10',NULL),(170,'1',0,1,NULL,NULL,NULL,NULL,NULL,1,86,NULL,1,'0','2021-12-27 20:01:08',NULL),(171,'2',0,1,NULL,NULL,NULL,NULL,NULL,2,86,NULL,1,'0','2021-12-27 20:01:16',NULL),(172,'3',0,1,NULL,NULL,NULL,NULL,NULL,3,86,NULL,1,'0','2021-12-27 20:01:17',NULL),(173,'1',170,2,'001004',NULL,NULL,NULL,NULL,1,86,NULL,1,'0','2021-12-27 20:01:31',NULL),(174,'2',170,2,'001004',NULL,NULL,NULL,NULL,2,86,NULL,1,'0','2021-12-27 20:01:37',NULL),(175,'1',171,2,'001002',NULL,NULL,NULL,NULL,1,86,NULL,1,'0','2021-12-27 20:01:42',NULL),(176,'2',171,2,'001002',NULL,NULL,NULL,NULL,2,86,NULL,1,'0','2021-12-27 20:01:43',NULL),(177,'1',172,2,'001004',NULL,NULL,NULL,NULL,1,86,NULL,1,'0','2021-12-27 20:01:47',NULL),(179,'新章名称 [点击修改]',0,1,NULL,NULL,NULL,NULL,NULL,1,87,NULL,1,'0','2021-12-27 20:14:15',NULL),(180,'新小节名称 [点击修改]',179,2,'001004',NULL,NULL,NULL,NULL,1,87,NULL,1,'0','2021-12-27 20:14:17',NULL),(181,'新小节名称 [点击修改]',179,2,'001004',NULL,NULL,NULL,NULL,2,87,NULL,1,'0','2021-12-27 20:14:29',NULL),(183,'新章名称 [点击修改]',0,1,NULL,NULL,NULL,NULL,NULL,1,88,NULL,1,'0','2021-12-27 20:14:56',NULL),(184,'新小节名称 [点击修改]',183,2,'001004',NULL,NULL,NULL,NULL,1,88,NULL,1,'0','2021-12-27 20:14:59',NULL),(186,'1',0,1,NULL,NULL,NULL,NULL,NULL,1,89,NULL,1,'0','2021-12-27 20:21:50',NULL),(187,'2',186,2,'001002',NULL,NULL,NULL,NULL,1,89,NULL,1,'1','2021-12-27 20:21:55',NULL),(189,'1',0,1,NULL,NULL,NULL,NULL,NULL,1,90,NULL,1,'0','2021-12-27 20:26:59',NULL),(190,'2',189,2,'001002',NULL,NULL,NULL,NULL,1,90,NULL,1,'1','2021-12-27 20:27:04',NULL),(191,'3',0,1,NULL,NULL,NULL,NULL,NULL,2,90,NULL,1,'0','2021-12-27 20:27:11',NULL),(192,'4',191,2,'001004',NULL,NULL,NULL,NULL,1,90,NULL,1,'1','2021-12-27 20:27:14',NULL),(194,'第一大章',0,1,NULL,NULL,NULL,NULL,NULL,1,91,NULL,1,'0','2021-12-27 20:35:10',NULL),(195,'1',194,2,'001002',NULL,NULL,NULL,NULL,1,91,NULL,1,'1','2021-12-27 20:35:13',NULL),(196,'2',194,2,'001004',NULL,NULL,NULL,NULL,2,91,NULL,1,'1','2021-12-27 20:35:27',NULL),(198,'新章名称 [点击修改]',0,1,'',NULL,NULL,NULL,NULL,1,92,NULL,1,'0','2021-12-27 20:53:34',NULL),(199,'新章名称 [点击修改]',0,1,'',NULL,NULL,NULL,NULL,2,92,NULL,1,'0','2021-12-27 20:53:35',NULL),(200,'新小节名称 [点击修改]',198,2,'001004',NULL,NULL,NULL,NULL,1,92,NULL,1,'0','2021-12-27 20:53:39',NULL),(201,'新小节名称 [点击修改]',198,2,'001004',NULL,NULL,NULL,NULL,2,92,NULL,1,'0','2021-12-27 20:53:40',NULL),(202,'新小节名称 [点击修改]',199,2,'001002',NULL,NULL,NULL,NULL,1,92,NULL,1,'0','2021-12-27 20:53:41',NULL),(204,'新章名称 [点击修改]',0,1,'',NULL,NULL,NULL,NULL,1,93,NULL,1,'0','2021-12-27 23:23:19',NULL),(205,'新章名称 [点击修改]',0,1,'',NULL,NULL,NULL,NULL,2,93,NULL,1,'0','2021-12-27 23:23:20',NULL),(206,'新章名称 [点击修改]',0,1,'',NULL,NULL,NULL,NULL,3,93,NULL,1,'0','2021-12-27 23:23:21',NULL),(207,'新小节名称 [点击修改]',204,2,'001004',NULL,NULL,NULL,NULL,1,93,NULL,1,'0','2021-12-27 23:23:22',NULL),(208,'新小节名称 [点击修改]',204,2,'001004',NULL,NULL,NULL,NULL,2,93,NULL,1,'0','2021-12-27 23:23:23',NULL),(209,'新小节名称 [点击修改]',205,2,'001002',NULL,NULL,NULL,NULL,1,93,NULL,1,'0','2021-12-27 23:23:24',NULL),(211,'新章名称 [点击修改]',0,1,'',NULL,NULL,NULL,NULL,1,94,NULL,1,'0','2021-12-27 23:48:16',NULL),(212,'新章名称 [点击修改]',0,1,'',NULL,NULL,NULL,NULL,2,94,NULL,1,'0','2021-12-27 23:48:17',NULL),(213,'新章名称 [点击修改]',0,1,'',NULL,NULL,NULL,NULL,3,94,NULL,1,'0','2021-12-27 23:48:17',NULL),(214,'新小节名称 [点击修改]',211,2,'001004',NULL,NULL,NULL,NULL,1,94,NULL,1,'0','2021-12-27 23:48:18',NULL),(215,'新小节名称 [点击修改]',211,2,'001004',NULL,NULL,NULL,NULL,2,94,NULL,1,'0','2021-12-27 23:48:20',NULL),(216,'新小节名称 [点击修改]',212,2,'001004',NULL,NULL,NULL,NULL,1,94,NULL,1,'0','2021-12-27 23:48:22',NULL),(217,'新小节名称 [点击修改]',213,2,'001002',NULL,NULL,NULL,NULL,1,94,NULL,1,'0','2021-12-27 23:48:47',NULL),(219,'新章名称 [点击修改]',0,1,'',NULL,NULL,NULL,NULL,1,95,NULL,1,'0','2021-12-28 02:08:10',NULL),(220,'新章名称 [点击修改]',0,1,'',NULL,NULL,NULL,NULL,2,95,NULL,1,'0','2021-12-28 02:08:11',NULL),(221,'新小节名称 [点击修改]',219,2,'001004',NULL,NULL,NULL,NULL,1,95,NULL,1,'0','2021-12-28 02:08:13',NULL),(222,'新小节名称 [点击修改]',219,2,'001004',NULL,NULL,NULL,NULL,2,95,NULL,1,'0','2021-12-28 02:08:14',NULL),(223,'新小节名称 [点击修改]',220,2,'001002',NULL,NULL,NULL,NULL,1,95,NULL,1,'0','2021-12-28 02:08:38',NULL),(225,'究极测试1',0,1,'',NULL,NULL,NULL,NULL,1,96,NULL,1,'0','2021-12-28 03:10:28',NULL),(226,'1',225,2,'001004',NULL,NULL,NULL,NULL,1,96,NULL,1,'1','2021-12-28 03:10:32',NULL),(227,'2',225,2,'001002',NULL,NULL,NULL,NULL,2,96,NULL,1,'1','2021-12-28 03:10:34',NULL),(228,'究极测试2',0,1,'',NULL,NULL,NULL,NULL,2,96,NULL,1,'0','2021-12-28 03:10:35',NULL),(230,'新章名称 [点击修改]',0,1,'',NULL,NULL,NULL,NULL,1,97,NULL,1,'0','2021-12-28 03:36:54',NULL),(231,'新章名称 [点击修改]',0,1,'',NULL,NULL,NULL,NULL,2,97,NULL,1,'0','2021-12-28 03:36:55',NULL),(232,'新章名称 [点击修改]',0,1,'',NULL,NULL,NULL,NULL,3,97,NULL,1,'0','2021-12-28 03:36:56',NULL),(234,'新小节名称 [点击修改]',231,2,'001002',NULL,NULL,NULL,NULL,1,97,NULL,1,'0','2021-12-28 03:36:59',NULL),(235,'新小节名称 [点击修改]',230,2,'001004',NULL,NULL,NULL,NULL,2,97,NULL,1,'0','2021-12-28 03:38:27',NULL),(236,'新小节名称 [点击修改]',231,2,'001004',NULL,NULL,NULL,NULL,2,97,NULL,1,'0','2021-12-28 03:39:11',NULL),(237,'第1章',0,1,'',NULL,NULL,NULL,NULL,1,22,NULL,1,'0','2022-08-21 21:09:58',NULL),(240,'第1节',237,2,'',NULL,NULL,NULL,NULL,1,22,NULL,1,'1','2022-08-21 21:16:29',NULL),(241,'第2节',237,2,'',NULL,NULL,NULL,NULL,2,22,NULL,1,'0','2022-08-21 21:17:20',NULL),(242,'第2章快速入门',0,1,'',NULL,NULL,NULL,NULL,1,74,NULL,1,'0','2022-08-23 15:07:09',NULL),(244,'第1节搭建环境',242,2,'001002',NULL,NULL,NULL,NULL,2,74,NULL,1,'1','2022-08-23 15:36:30',NULL),(245,'第2节项目概述',242,2,'001002',NULL,NULL,NULL,NULL,3,74,NULL,1,'0','2022-08-23 18:35:16',NULL),(246,'第3章项目概述',0,1,NULL,NULL,NULL,NULL,NULL,3,74,NULL,1,'0',NULL,NULL),(247,'第4章',0,1,NULL,NULL,NULL,NULL,NULL,4,74,NULL,1,'0',NULL,NULL),(248,'第3-1节',246,2,NULL,NULL,NULL,NULL,NULL,4,74,NULL,1,'1',NULL,NULL),(249,'第4-1小节 ',247,2,NULL,NULL,NULL,NULL,NULL,5,74,NULL,1,'0',NULL,NULL),(250,'第4-0小节',247,2,NULL,NULL,NULL,NULL,NULL,2,74,NULL,1,'0',NULL,NULL),(251,'新章名称 [点击修改]',0,1,NULL,NULL,NULL,NULL,NULL,5,74,NULL,1,'0',NULL,NULL),(252,'小节名称 [点击修改]',247,2,NULL,NULL,NULL,NULL,NULL,3,74,NULL,1,'0',NULL,NULL),(253,'第1节修改名称',237,2,'',NULL,NULL,NULL,NULL,3,22,NULL,1,'1',NULL,NULL),(255,'第1章',0,1,NULL,NULL,NULL,NULL,NULL,1,1,NULL,1,'0',NULL,NULL),(256,'第1小节',255,2,NULL,NULL,NULL,NULL,NULL,1,1,NULL,1,'0',NULL,NULL),(257,'配置详解',148,2,NULL,NULL,NULL,NULL,NULL,2,82,NULL,1,'0',NULL,NULL),(258,'项目实战',148,2,NULL,NULL,NULL,NULL,NULL,3,82,NULL,1,'0',NULL,NULL),(259,'新章名称 [点击修改]',0,1,NULL,NULL,NULL,NULL,NULL,2,22,NULL,1,'0',NULL,NULL),(260,'新小节名称 [点击修改]',259,2,NULL,NULL,NULL,NULL,NULL,1,22,NULL,1,'0',NULL,NULL),(261,'新章名称 [点击修改]',0,1,NULL,NULL,NULL,NULL,NULL,1,40,NULL,1,'0',NULL,NULL),(262,'新小节名称 [点击修改]',261,2,NULL,NULL,NULL,NULL,NULL,1,40,NULL,1,'1',NULL,NULL),(263,'新小节名称 [点击修改]',255,2,NULL,NULL,NULL,NULL,NULL,2,1,NULL,1,'0',NULL,NULL),(264,'新章名称 [点击修改]',0,1,NULL,NULL,NULL,NULL,NULL,2,1,NULL,1,'0',NULL,NULL),(265,'新小节名称 [点击修改]',264,2,NULL,NULL,NULL,NULL,NULL,1,1,NULL,1,'0',NULL,NULL),(266,'第1章',0,1,NULL,NULL,NULL,NULL,NULL,1,2,NULL,1,'0',NULL,NULL),(267,'第1节',266,2,NULL,NULL,NULL,NULL,NULL,1,2,NULL,1,'0',NULL,NULL),(268,'1.配置管理',0,1,NULL,NULL,NULL,NULL,NULL,1,117,NULL,1,'0',NULL,NULL),(269,'1.1 什么是配置中心',268,2,NULL,NULL,NULL,NULL,NULL,1,117,NULL,1,'0',NULL,NULL),(270,'1.2Nacos简介',268,2,NULL,NULL,NULL,NULL,NULL,2,117,NULL,1,'0',NULL,NULL),(271,'1.3安装Nacos Server',268,2,NULL,NULL,NULL,NULL,NULL,3,117,NULL,1,'0',NULL,NULL),(272,'1.4Nacos配置入门',268,2,NULL,NULL,NULL,NULL,NULL,4,117,NULL,1,'0',NULL,NULL),(273,'1.5命名空间管理',268,2,NULL,NULL,NULL,NULL,NULL,5,117,NULL,1,'0',NULL,NULL),(274,'2.服务发现',0,1,NULL,NULL,NULL,NULL,NULL,2,117,NULL,1,'0',NULL,NULL),(275,'2.1什么是服务发现',274,2,NULL,NULL,NULL,NULL,NULL,1,117,NULL,1,'0',NULL,NULL),(276,'2.2服务发现快速入门',274,2,NULL,NULL,NULL,NULL,NULL,2,117,NULL,1,'0',NULL,NULL),(277,'2.3服务发现数据模型',274,2,NULL,NULL,NULL,NULL,NULL,3,117,NULL,1,'0',NULL,NULL),(278,'2.4服务列表管理',274,2,NULL,NULL,NULL,NULL,NULL,4,117,NULL,1,'0',NULL,NULL),(279,'第一章xxx',0,1,NULL,NULL,NULL,NULL,NULL,1,18,NULL,1,'0',NULL,NULL),(280,'第一节xxx',279,2,NULL,NULL,NULL,NULL,NULL,1,18,NULL,1,'0',NULL,NULL),(281,'第1章 SpringCloud概述',0,1,NULL,NULL,NULL,NULL,NULL,1,121,NULL,1,'0',NULL,NULL),(282,'Spring Cloud发展历史',281,2,NULL,NULL,NULL,NULL,NULL,1,121,NULL,1,'0',NULL,NULL),(283,'Spring Cloud与SpringBoot的关系',281,2,NULL,NULL,NULL,NULL,NULL,2,121,NULL,1,'0',NULL,NULL),(284,'第2章 基础组件',0,1,NULL,NULL,NULL,NULL,NULL,2,121,NULL,1,'0',NULL,NULL),(285,'服务注册中心',284,2,NULL,NULL,NULL,NULL,NULL,1,121,NULL,1,'0',NULL,NULL),(286,'配置中心',284,2,NULL,NULL,NULL,NULL,NULL,2,121,NULL,1,'0',NULL,NULL),(287,'负载均衡',284,2,NULL,NULL,NULL,NULL,NULL,3,121,NULL,1,'0',NULL,NULL),(288,'远程调用',284,2,NULL,NULL,NULL,NULL,NULL,4,121,NULL,1,'0',NULL,NULL),(289,'熔断降级',284,2,NULL,NULL,NULL,NULL,NULL,5,121,NULL,1,'0',NULL,NULL);
/*!40000 ALTER TABLE `teachplan` ENABLE KEYS */;
UNLOCK TABLES;


SELECT * FROM `course_base` WHERE id = 117--

-- 查询290第三章的子章节, 274第二章内容
SELECT one.id, one.pname, two.id, two.pname, two.orderby
FROM `teachplan` ONE
JOIN `teachplan` two
ON one.id = two.parentid
WHERE one.id = 274
ORDER BY one.orderby, two.orderby


SELECT id, pname, orderby
FROM teachplan
WHERE orderby = (
  SELECT MAX(orderby) FROM teachplan
  WHERE orderby < -2
);




SELECT *
FROM teachplan
WHERE orderby = (
  SELECT MIN(orderby) FROM teachplan
  WHERE orderby > (
    SELECT orderby FROM teachplan
    WHERE id = 292
  )
);

SELECT *
FROM teachplan
WHERE orderby = (
    SELECT MIN(orderby) FROM teachplan
    WHERE orderby > (
	SELECT orderby FROM teachplan
	WHERE id = 276
    )
    AND id IN (
	SELECT id
	FROM teachplan
	WHERE teachplan.parentid = (
	SELECT parentid
	FROM teachplan
	WHERE id = 276
	)
    )
)
AND id IN (
SELECT id
FROM teachplan
WHERE teachplan.parentid = (
SELECT parentid
FROM teachplan
WHERE id = 276
)
)



-- 上移
        SELECT *
        FROM teachplan
        WHERE orderby = (
        SELECT MAX(orderby) FROM teachplan
        WHERE orderby < -1
        )
        GROUP BY parentid
        LIMIT 1

        SELECT *
        FROM teachplan
        WHERE orderby = -2
        GROUP BY parentid
        LIMIT 1


SELECT * FROM teachplan WHERE parentid = (

)

SELECT parentid, MAX(orderby)
FROM teachplan
GROUP BY parentid
HAVING parentid = (
SELECT parentid FROM teachplan WHERE id = 277
)

277 的 父节点是 274

也就是说查询出来的父节点也必须是 274

SELECT id, pname, orderby, parentid
FROM teachplan
WHERE parentid = (
SELECT parentid FROM teachplan WHERE id = 275
)


-- 上移DAO完成
SELECT *
FROM teachplan
WHERE orderby < 10
AND parentid = (
SELECT parentid FROM teachplan WHERE id = 290
)
AND course_id = (
  SELECT course_id FROM teachplan WHERE id = 290
)
ORDER BY orderby DESC
LIMIT 1

SELECT * FROM teachplan WHERE id = 274

-- 下移DAO
SELECT *
FROM teachplan
WHERE orderby > -1
AND parentid = (
SELECT parentid FROM teachplan WHERE id = 290
)
AND course_id = (
  SELECT course_id FROM teachplan WHERE id = 290
)
ORDER BY orderby
LIMIT 1

UPDATE teachplan SET orderby = 0 WHERE id = 274
