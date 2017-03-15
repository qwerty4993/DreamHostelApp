-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hostel
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `feature`
--

DROP TABLE IF EXISTS `feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feature` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `allow_create` bit(1) DEFAULT NULL,
  `allow_delete` bit(1) DEFAULT NULL,
  `allow_edit` bit(1) DEFAULT NULL,
  `allow_read` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5u0uoik0oi6v0xh21ffpuk5oy` (`role_id`),
  CONSTRAINT `FK_5u0uoik0oi6v0xh21ffpuk5oy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feature`
--

LOCK TABLES `feature` WRITE;
/*!40000 ALTER TABLE `feature` DISABLE KEYS */;
INSERT INTO `feature` VALUES (1,'','','','','ROLE','ROLE',1),(2,'','','','','HostelRequest','HostelRequest',1),(3,'','','','','Features','Features',1),(4,NULL,NULL,NULL,'','HOME','HOME',2),(5,NULL,NULL,NULL,'','HostelRequest','HOSTELREQUEST',2),(6,NULL,NULL,NULL,'','PROFILE','PROFILE',2),(7,NULL,NULL,NULL,NULL,'ROOMS','ROOMS',2),(8,NULL,NULL,NULL,'','HOME','HOME',3),(9,NULL,NULL,NULL,NULL,'HostelRequest','HOSTELREQUEST',3),(10,NULL,NULL,NULL,'','PROFILE','PROFILE',3),(11,NULL,NULL,NULL,'','ROOMS','ROOMS',3),(12,NULL,NULL,NULL,'','HOME','HOME',4),(13,NULL,NULL,NULL,NULL,'HostelRequest','HOSTELREQUEST',4),(14,NULL,NULL,NULL,NULL,'PROFILE','PROFILE',4),(15,NULL,NULL,NULL,NULL,'ROOMS','ROOMS',4),(16,NULL,NULL,NULL,NULL,'HOME','HOME',5),(17,NULL,NULL,NULL,'','HostelRequest','HOSTELREQUEST',5),(18,NULL,NULL,NULL,NULL,'PROFILE','PROFILE',5),(19,NULL,NULL,NULL,NULL,'ROOMS','ROOMS',5),(20,NULL,NULL,NULL,'','HOME','HOME',6),(21,NULL,NULL,NULL,NULL,'HostelRequest','HOSTELREQUEST',6),(22,NULL,NULL,NULL,'','PROFILE','PROFILE',6),(23,NULL,NULL,NULL,NULL,'ROOMS','ROOMS',6),(24,NULL,NULL,NULL,'','HOME','HOME',7),(25,NULL,NULL,NULL,'','HostelRequest','HOSTELREQUEST',7),(26,NULL,NULL,NULL,NULL,'PROFILE','PROFILE',7),(27,NULL,NULL,NULL,NULL,'ROOMS','ROOMS',7);
/*!40000 ALTER TABLE `feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feature_lookup`
--

DROP TABLE IF EXISTS `feature_lookup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feature_lookup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feature_lookup`
--

LOCK TABLES `feature_lookup` WRITE;
/*!40000 ALTER TABLE `feature_lookup` DISABLE KEYS */;
INSERT INTO `feature_lookup` VALUES (1,'HOME','HOME'),(2,'HostelRequest','HostelRequest'),(3,'PROFILE','PROFILE'),(4,'ROOMS','ROOMS');
/*!40000 ALTER TABLE `feature_lookup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `display_name` varchar(255) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','admin'),(2,'user','user'),(3,'HostelManager','HostelManager'),(4,'test','test'),(5,'asd','asd'),(6,'dasdasd','asdas'),(7,'aasdasd','asdasdasd');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-15 18:41:13
