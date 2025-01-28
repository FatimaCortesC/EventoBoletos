CREATE DATABASE  IF NOT EXISTS `boletos` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `boletos`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: boletos
-- ------------------------------------------------------
-- Server version	5.7.44-log

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
-- Table structure for table `boletos`
--

DROP TABLE IF EXISTS `boletos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boletos` (
  `id_boleto` bigint(20) NOT NULL AUTO_INCREMENT,
  `canjeado` bit(1) NOT NULL,
  `codigo` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `evento_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_boleto`),
  KEY `FKk2c7bb0g7x2xgqgcdfgivcm01` (`evento_id`),
  CONSTRAINT `FKk2c7bb0g7x2xgqgcdfgivcm01` FOREIGN KEY (`evento_id`) REFERENCES `eventos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletos`
--

LOCK TABLES `boletos` WRITE;
/*!40000 ALTER TABLE `boletos` DISABLE KEYS */;
INSERT INTO `boletos` VALUES (1,_binary '\0','4a6fa244-01d5-440b-93fa-f14512d219af','Vendido',1),(2,_binary '\0','a0c2de20-32be-4b4b-ac2f-6c40c5a28b12','Vendido',1),(3,_binary '\0','6dccf807-c81f-4f8f-a37b-5435fe6ee10b','Vendido',1),(4,_binary '\0','bca1ae8a-c3eb-4475-981a-f5336f96fc9a','Vendido',7),(5,_binary '\0','49815ad0-357a-46a0-8233-febbe613273d','Canjeado',8),(6,_binary '\0','904c74e9-7499-45c3-b850-60b769d1c5fa','Vendido',8),(7,_binary '\0','5c7c057d-e18d-41ae-929f-bdbf59f49ce7','Vendido',8),(8,_binary '\0','b4c66867-0d60-4eb0-b98f-ba143cd5bc94','Vendido',8),(9,_binary '\0','187fb653-b7e3-430b-bbde-c186bea9574f','Vendido',10),(10,_binary '\0','d2cf51d0-7369-40ed-b227-07b403222480','Vendido',10),(11,_binary '\0','d2cc2396-47c7-4db9-9634-bc735096bf38','Vendido',10),(12,_binary '\0','dde2d8ab-01f1-44a0-91f0-bc2baae74d25','Vendido',10),(13,_binary '\0','aac92b23-554d-4f24-b04e-1ec4963808b8','Vendido',10),(14,_binary '\0','981d91e7-96ac-4068-bf92-ec342d263138','Vendido',10),(15,_binary '\0','18bfaf3a-ab9a-40d5-b0df-9e5a219e8c8e','Vendido',10),(16,_binary '\0','5dc64a2c-6889-4f51-b991-f4cb5d981017','Vendido',10),(17,_binary '\0','778809e1-ed3e-4979-b2ed-cdd37309c67d','Vendido',10),(18,_binary '\0','08a55650-624f-498b-aba2-065819957938','Vendido',10),(19,_binary '\0','f7a09ecf-a4d8-41e8-ab32-baac2eb843fc','Vendido',10),(20,_binary '\0','5fb9b700-8e53-459a-bdc5-5b2456ae22ab','Vendido',10),(21,_binary '\0','941960e9-24cf-44eb-b54c-dcbb3b559830','Vendido',10),(22,_binary '\0','e6b43179-5af0-470d-8a5b-e57a783384a9','Vendido',12),(23,_binary '\0','07ecf309-e2bf-45f4-832a-eea174cbd825','Vendido',12),(24,_binary '\0','74aa3fde-7775-4018-8500-86d4b8c44f67','Vendido',12),(25,_binary '\0','d16a9841-6b06-4b8d-97fd-cab1afdf2924','Vendido',12);
/*!40000 ALTER TABLE `boletos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `boletos_disponibles` int(11) NOT NULL,
  `fecha_fin` date NOT NULL,
  `fecha_inicio` date NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (1,297,'2025-01-30','2025-01-29','Mylo'),(6,90,'2025-01-30','2025-01-29','Concierto Rock'),(7,99,'2025-01-30','2025-01-29','Concierto Metal'),(8,296,'2025-01-29','2025-01-26','Concierto pop'),(10,0,'2025-01-30','2025-01-29','Concierto Metal'),(11,1,'2025-01-30','2025-01-29','Concierto Metal'),(12,3,'2025-01-30','2025-01-29','Concierto Metal');
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'boletos'
--

--
-- Dumping routines for database 'boletos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-27 23:51:47
