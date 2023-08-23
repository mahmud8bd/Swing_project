CREATE DATABASE  IF NOT EXISTS `itinstitudemanagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `itinstitudemanagement`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: itinstitudemanagement
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `sl` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sl`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `contact_UNIQUE` (`contact`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'SAZZAD','admin','01700000000','admin@admin.com','123'),(5,'Hassan','hasan','01766666666','hasan@gmailcom','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `batch`
--

DROP TABLE IF EXISTS `batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `batch` (
  `sl` int NOT NULL AUTO_INCREMENT,
  `batchid` varchar(45) DEFAULT NULL,
  `courseid` varchar(45) DEFAULT NULL,
  `coursename` varchar(45) DEFAULT NULL,
  `duration` varchar(45) DEFAULT NULL,
  `teacherid` varchar(45) DEFAULT NULL,
  `teachername` varchar(45) DEFAULT NULL,
  `schedule` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sl`),
  UNIQUE KEY `batchid_UNIQUE` (`batchid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch`
--

LOCK TABLES `batch` WRITE;
/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
INSERT INTO `batch` VALUES (7,'BH-0000001','CS-0000656','Core Java','120h','TR-0000002','lamia akter','03:00PM-05:00PM');
/*!40000 ALTER TABLE `batch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `sl` int NOT NULL AUTO_INCREMENT,
  `course_id` varchar(45) DEFAULT NULL,
  `course_name` varchar(45) DEFAULT NULL,
  `course_Duration` varchar(45) DEFAULT NULL,
  `course_fee` double DEFAULT NULL,
  PRIMARY KEY (`sl`),
  UNIQUE KEY `course_id_UNIQUE` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (6,'CS-0000655','PHP','80',4000),(7,'CS-0000656','Core Java','120h',10000);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` varchar(50) NOT NULL,
  `student_id` varchar(45) DEFAULT NULL,
  `student_name` varchar(45) DEFAULT NULL,
  `course_name` varchar(45) DEFAULT NULL,
  `batch_id` varchar(45) DEFAULT NULL,
  `course_fee` double DEFAULT NULL,
  `pay` double DEFAULT NULL,
  `due` double DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  UNIQUE KEY `payment_id_UNIQUE` (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('PM-0000001','ST-0000003','kamal hossen','ms office','220044',3500,1000,2500,'Unpaid'),('PM-0000002','ST-0000004','sffsfdsf sdfdfsd','ms office','220044',3500,0,3500,'Unpaid'),('PM-0000003','ST-0000001','hasan AK','Core Java','BH-0000001',10000,0,10000,'Unpaid'),('PM-0000004','ST-0000002','jahid hossen','Core Java','BH-0000001',10000,0,10000,'Unpaid'),('PM-0000005','ST-0000003','namin hossen','Core Java','BH-0000001',10000,0,10000,'Unpaid');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `sl` int NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(45) DEFAULT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `father_name` varchar(45) DEFAULT NULL,
  `mother_name` varchar(45) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `join_date` varchar(45) DEFAULT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `education_level` varchar(45) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  PRIMARY KEY (`sl`),
  UNIQUE KEY `staff_id_UNIQUE` (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (9,'SF-0000001','kamal','hossen','jamal','komola','1993-04-30','Male','01785456985','kaml@gm.com','dhaka','2023-04-08','Recepsonist','HONOURS',16500),(10,'SF-0000002','jamal','hossen','abdullah','sadia','2000-04-21','Male','01456321452','jamal@gmail.com','kulna','2023-04-07','Computer Operator','MA',20000);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `sl` int NOT NULL AUTO_INCREMENT,
  `s_id` varchar(45) DEFAULT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `father_name` varchar(45) DEFAULT NULL,
  `mother_name` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `admit` date DEFAULT NULL,
  `course_name` varchar(45) DEFAULT NULL,
  `batch_id` varchar(45) DEFAULT NULL,
  `staff_ref` varchar(45) DEFAULT NULL,
  `education_level` varchar(45) DEFAULT NULL,
  `fee` double DEFAULT NULL,
  PRIMARY KEY (`sl`),
  UNIQUE KEY `s_id_UNIQUE` (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (18,'ST-0000001','hasan','AK','sumon','napa','1995-04-13','Male','01456325873','hasn@gm.com','hhhh','2023-04-08','Core Java','BH-0000001','SF-0000002','HSC/ALIM',10000),(19,'ST-0000002','jahid','hossen','naim','hasina','2023-04-13','Male','01452369874','saasas@gm.com','gosaa','2023-04-07','Core Java','BH-0000001','SF-0000001','FAZIL/DEGREE',10000),(20,'ST-0000003','namin','hossen','namima','namima','2023-04-14','Male','012546987451','Sssss@gm.com','gfhfhf','2023-04-11','Core Java','BH-0000001','SF-0000002','FAZIL/DEGREE',10000);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `sl` int NOT NULL AUTO_INCREMENT,
  `teacherid` varchar(45) DEFAULT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `father_name` varchar(45) DEFAULT NULL,
  `mother_name` varchar(45) DEFAULT NULL,
  `birtyday` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `join_date` varchar(45) DEFAULT NULL,
  `skill` varchar(45) DEFAULT NULL,
  `education_level` varchar(45) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  PRIMARY KEY (`sl`),
  UNIQUE KEY `teacherid_UNIQUE` (`teacherid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (6,'TR-0000001','samim','hossen','nadim','sonali','1992-04-17','Male','01756945621','samim@gm.com','savar','2023-04-02','MS Office','MA',25000),(7,'TR-0000002','lamia','akter','labib','luba','1995-04-20','Female','01456325871','lamia@gmail.com','dhaka','2023-04-20','Core JAVA','MA',35000);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-08 10:14:22
