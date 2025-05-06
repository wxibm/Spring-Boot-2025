CREATE DATABASE  IF NOT EXISTS `mydata` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydata`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mydata
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_avatar` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '../img/default.png',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'admin','11111','../img/default.png','2024-04-25 13:34:11'),(2,'user','22222','   ',NULL),(3,'jack','12345','../img/default.png','2024-04-25 13:35:18'),(4,'bruce','12345','../img/default.png','2024-04-25 13:35:18'),(5,'lucy','12345','../img/default.png','2024-04-25 13:35:18'),(6,'smith','11111','../img/default.png','2024-04-24 16:00:00'),(7,'sarah','11111','../img/default.png','2024-04-28 00:00:00'),(8,'nancy','11111','../img/default.png','2024-04-28 00:00:00'),(9,'clark','11111','../img/default.png','2024-04-27 17:08:26'),(10,'andy','11111','../img/default.png','2024-04-27 17:08:26'),(11,'adrian','11111','../img/default.png','2024-04-27 17:08:26'),(12,'susan','11111','../img/default.png','2024-04-27 17:08:26'),(13,'king','11111','../img/default.png','2024-04-28 14:34:13'),(14,'alva','11111','../img/default.png','2024-04-28 14:41:29'),(15,'xzavier','11111','../img/default.png','2024-04-28 14:58:37'),(16,'cornelia','11111','../img/default.png','2024-04-28 15:01:51'),(17,'jordan','11111','../img/default.png','2024-04-29 02:28:52'),(18,'carl','11111','../img/default.png','2024-04-29 03:17:41'),(19,'ralf','11111','../img/default.png','2024-05-02 04:07:56'),(20,'lily','11111','../img/default.png','2024-05-02 04:07:56'),(33,'henry','Abc123!@','../img/default.png','2024-05-02 16:21:27');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-09 13:03:01
