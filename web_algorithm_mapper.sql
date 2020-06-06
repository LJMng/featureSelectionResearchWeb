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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_algorithm_mapper`
--

LOCK TABLES `web_algorithm_mapper` WRITE;
/*!40000 ALTER TABLE `web_algorithm_mapper` DISABLE KEYS */;
INSERT INTO `web_algorithm_mapper` VALUES (1,50,15,NULL,'200','itr_num_200'),(2,50,15,NULL,'300','itr_num_300'),(3,50,15,NULL,'200_true','algorithm_true'),(4,50,15,NULL,'200_false','algorithm_false'),(5,50,15,NULL,'300_100','algorithm_100'),(6,50,15,NULL,'300_200','algorithm_200'),(7,50,15,NULL,'300_300','algorithm_300'),(8,NULL,16,7,'方法1','mew'),(9,NULL,16,7,'方法2','inti'),(10,NULL,17,8,'1','one'),(11,NULL,17,8,'2','two'),(12,NULL,17,8,'3','three');
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

-- Dump completed on 2020-06-06 11:21:29
