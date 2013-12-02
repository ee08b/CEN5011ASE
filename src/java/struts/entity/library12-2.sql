-- MySQL dump 10.13  Distrib 5.1.72, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	5.1.72-0ubuntu0.10.04.1

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (2,'admin','1','admin'),(3,'Jack','hjkd%342','patron'),(4,'Mike','2','patron'),(5,'Lauren','jilk*11','librarian');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (3,'Jack','','book','2013-11-11','10:05:00','logout'),(5,'Jack','305','book','2013-11-19','11:56:39','reserve'),(6,'admin','Engineering Software as a Service: An Agile Approach Using Cloud Computing','book','2013-11-30','17:56:41','borrow'),(7,'admin','The Algorithm Design Manual','book','2013-11-30','17:59:12','borrow'),(8,'admin','Killing Jesus','book','2013-11-30','17:59:14','borrow'),(9,'admin','Engineering Software as a Service: An Agile Approach Using Cloud Computing','book','2013-11-30','17:59:28','return'),(10,'admin','The Algorithm Design Manual','book','2013-11-30','17:59:31','return'),(11,'admin','Journey',NULL,'2013-11-30','18:05:58','return'),(12,'admin','Engineering Software as a Service: An Agile Approach Using Cloud Computing','material','2013-11-30','18:09:20','borrow'),(13,'admin','The Algorithm Design Manual','material','2013-11-30','18:09:32','borrow'),(14,'admin','Engineering Software as a Service: An Agile Approach Using Cloud Computing','material','2013-11-30','18:09:39','return'),(15,'admin','The Algorithm Design Manual','material','2013-11-30','18:09:43','return');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `ISBN` varchar(255) DEFAULT NULL,
  `hit` int(11) DEFAULT '0',
  `available` int(11) NOT NULL DEFAULT '0',
  `amount` int(11) NOT NULL DEFAULT '10',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'Journey','Anderson','book','028874747',0,10,10),(2,'Software Engineering (9th Edition)','Ian Sommerville','book','0137035152',0,10,17),(3,'Engineering Software as a Service: An Agile Approach Using Cloud Computing','Armando Fox','book','0984881247',0,11,8),(4,'Killing Jesus','Billy O\'Reilly','book','0805098542',0,9,9),(5,'Software Engineering: A Practitioner\'s Approach','Roger Pressman','book','0073375977',0,10,11),(6,'The Algorithm Design Manual','Steven S Skiena','kindle','1848000693',0,10,9),(7,'Business Driven Technology','Stephen Haag','cd','0072979798',0,10,11),(9,'asdfa  fda','asdf','fasdf','34523',0,232,228);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_rsv`
--

DROP TABLE IF EXISTS `material_rsv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material_rsv` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_rsv`
--

LOCK TABLES `material_rsv` WRITE;
/*!40000 ALTER TABLE `material_rsv` DISABLE KEYS */;
INSERT INTO `material_rsv` VALUES (37,'Killing Jesus','admin','2013-11-30','17:59:14');
/*!40000 ALTER TABLE `material_rsv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_rsv`
--

DROP TABLE IF EXISTS `room_rsv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_rsv` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time1` time DEFAULT NULL,
  `time2` time DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_rsv`
--

LOCK TABLES `room_rsv` WRITE;
/*!40000 ALTER TABLE `room_rsv` DISABLE KEYS */;
INSERT INTO `room_rsv` VALUES (1,'303','2013-12-12','10:00:00','11:00:00','Lauren'),(2,'305','2013-12-14','11:00:00','12:00:00','Mike'),(3,'305','2013-12-13','10:30:00','12:00:00','Jack'),(10,'302','2013-11-30','13:00:00','10:00:00','admin');
/*!40000 ALTER TABLE `room_rsv` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-02  1:14:38
