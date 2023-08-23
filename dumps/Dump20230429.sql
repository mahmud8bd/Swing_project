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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'SAZZAD','admin','01700000000','admin@admin.com','123'),(5,'Hassan','hasan','01766666666','hasan@gmailcom','123'),(8,'kamal','kamal','01254789565','kamal@gmail.com','123'),(9,'sadia','sadia','01478542145','sadia@gm.com','123'),(10,'Habib','habib','01478659874','habib@gmail.com','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `date` date DEFAULT NULL,
  `batch_id` varchar(45) DEFAULT NULL,
  `student_id` varchar(45) DEFAULT NULL,
  `student_name` varchar(45) DEFAULT NULL,
  `attendance` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES ('2023-04-15','BH-0000001','ST-0000001','hasan AK','Absent'),('2023-04-15','BH-0000001','ST-0000002','jahid hossen',''),('2023-04-15','BH-0000001','ST-0000003','namin hossen','Present'),('2023-04-16','BH-0000001','ST-0000001','hasan AK','Present'),('2023-04-16','BH-0000001','ST-0000002','jahid hossen','Present'),('2023-04-16','BH-0000001','ST-0000003','namin hossen','Present'),('2023-04-18','BH-0000001','ST-0000003','namin hossen','Present'),('2023-04-18','BH-0000001','ST-0000002','jahid hossen','Present'),('2023-04-18','BH-0000001','ST-0000003','namin hossen','Present'),('2023-04-19','BH-0000001','ST-0000002','jahid hossen','Present'),('2023-04-19','BH-0000001','ST-0000003','namin hossen','Present'),('2023-04-20','BH-0000001','ST-0000001','hasan AK','Absent'),('2023-04-18','BH-0000001','ST-0000001','hasan AK','Absent'),('2023-04-11','BH-0000001','ST-0000002','jahid hossen','Absent');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
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
  `total_class` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sl`),
  UNIQUE KEY `batchid_UNIQUE` (`batchid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch`
--

LOCK TABLES `batch` WRITE;
/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
INSERT INTO `batch` VALUES (16,'BH-0000001','CS-0000001','Core Java','220 Hours','TR-0000002','Sonia Akter','09:00AM-11:00AM','74'),(17,'BH-0000002','CS-0000002','PHP','110 Hours','TR-0000005','Asad Mia','11:30AM-01:30PM','35'),(18,'BH-0000003','CS-0000003','Advance Java','180 Hours','TR-0000004','Lamia Akter','03:00PM-05:00PM','45'),(19,'BH-0000004','CS-0000004','HTML','80 Hours','TR-0000007','Nushrat Jahan','09:00AM-11:00AM','20'),(20,'BH-0000005','CS-0000005','CSS','50 Hours','TR-0000007','Nushrat Jahan','11:30AM-01:30PM','25'),(21,'BH-0000006','CS-0000006','My SQL','130 Hours','TR-0000011','siam sorder','09:00AM-11:00AM','45'),(22,'BH-0000007','CS-0000007','MS Office','180 Hours','TR-0000001','Adib Hasan','11:30AM-01:30PM','60'),(23,'BH-0000008','CS-0000008','PhotoShop','200 Hours','TR-0000019','Nazira Akter','03:00PM-05:00PM','50'),(24,'BH-0000009','CS-0000009','Illustrator','180 Hours','TR-0000019','Nazira Akter','11:30AM-01:30PM','45');
/*!40000 ALTER TABLE `batch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cirtificate_issue`
--

DROP TABLE IF EXISTS `cirtificate_issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cirtificate_issue` (
  `cirtificate_no` varchar(45) DEFAULT NULL,
  `student_id` varchar(50) DEFAULT NULL,
  `student_name` varchar(45) DEFAULT NULL,
  `batch_id` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cirtificate_issue`
--

LOCK TABLES `cirtificate_issue` WRITE;
/*!40000 ALTER TABLE `cirtificate_issue` DISABLE KEYS */;
INSERT INTO `cirtificate_issue` VALUES ('CR30000001','ST-0000001','Kamal Hossen','BH-0000003','2023-04-26'),('CR30000002','ST-0000003','Nayeem islam','BH-0000001','2023-04-20'),('CR30000003','ST-0000005','Afsaar uddin','BH-0000003','2023-04-20'),('CR30000004','ST-0000008','Saidul Islam','BH-0000006','2023-04-20'),('CR30000005','ST-0000010','Jannat Ara','BH-0000008','2023-04-20');
/*!40000 ALTER TABLE `cirtificate_issue` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (11,'CS-0000001','Core Java','220 Hours',8000),(12,'CS-0000002','PHP','110 Hours',4000),(13,'CS-0000003','Advance Java','180 Hours',5000),(14,'CS-0000004','HTML','80 Hours',3000),(15,'CS-0000005','CSS','50 Hours',2500),(16,'CS-0000006','My SQL','130 Hours',4000),(17,'CS-0000007','MS Office','180 Hours',2500),(18,'CS-0000008','PhotoShop','200 Hours',6000),(19,'CS-0000009','Illustrator','180 Hours',8000);
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
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`payment_id`),
  UNIQUE KEY `payment_id_UNIQUE` (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('PM-0000001','ST-0000001','Kamal Hossen','Advance Java','BH-0000003',5000,5000,0,'Paid','2023-04-25 16:50:49','2023-04-25 16:53:35'),('PM-0000002','ST-0000002','Nurjahan Akter','PHP','BH-0000002',4000,0,4000,'Unpaid','2023-04-25 16:52:53','2023-04-25 16:52:53'),('PM-0000003','ST-0000003','Nayeem islam','Core Java','BH-0000001',8000,8000,0,'Paid','2023-04-29 03:13:03','2023-04-29 03:45:09'),('PM-0000004','ST-0000004','Yakub Ali','PHP','BH-0000002',4000,0,4000,'Unpaid','2023-04-29 03:17:09','2023-04-29 03:17:09'),('PM-0000005','ST-0000005','Afsaar uddin','Advance Java','BH-0000003',5000,5000,0,'Paid','2023-04-29 03:18:59','2023-04-29 03:48:22'),('PM-0000006','ST-0000006','Nuruddin mun','HTML','BH-0000004',3000,0,3000,'Unpaid','2023-04-29 03:23:03','2023-04-29 03:23:03'),('PM-0000007','ST-0000007','Jafor mun','CSS','BH-0000005',2500,0,2500,'Unpaid','2023-04-29 03:26:30','2023-04-29 03:26:30'),('PM-0000008','ST-0000008','Saidul Islam','My SQL','BH-0000006',4000,4000,0,'Paid','2023-04-29 03:30:56','2023-04-29 03:48:41'),('PM-0000009','ST-0000009','Habibullah Tanvir','MS Office','BH-0000007',2500,0,2500,'Unpaid','2023-04-29 03:32:18','2023-04-29 03:32:18'),('PM-0000010','ST-0000010','Jannat Ara','PhotoShop','BH-0000008',6000,6000,0,'Paid','2023-04-29 03:34:50','2023-04-29 03:48:56'),('PM-0000011','ST-0000011','Tithi akter','Illustrator','BH-0000009',8000,8000,0,'Paid','2023-04-29 03:36:06','2023-04-29 03:44:29');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `student_id` varchar(50) DEFAULT NULL,
  `student_name` varchar(45) DEFAULT NULL,
  `course_name` varchar(45) DEFAULT NULL,
  `batch_id` varchar(45) DEFAULT NULL,
  `mark` double DEFAULT NULL,
  `result` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES ('ST-0000001','Kamal Hossen','Advance Java','BH-0000003',70,'A'),('ST-0000002','Nurjahan Akter','PHP','BH-0000002',20,'Fail'),('ST-0000004','Yakub Ali','PHP','BH-0000002',56,'C'),('ST-0000003','Nayeem islam','Core Java','BH-0000001',80,'A+'),('ST-0000005','Afsaar uddin','Advance Java','BH-0000003',78,'A'),('ST-0000006','Nuruddin mun','HTML','BH-0000004',39,'Fail'),('ST-0000007','Jafor mun','CSS','BH-0000005',65,'B'),('ST-0000008','Saidul Islam','My SQL','BH-0000006',85,'A+'),('ST-0000009','Habibullah Tanvir','MS Office','BH-0000007',75,'A'),('ST-0000010','Jannat Ara','PhotoShop','BH-0000008',65,'B'),('ST-0000011','Tithi akter','Illustrator','BH-0000009',35,'Fail');
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary` (
  `salary_id` varchar(45) NOT NULL,
  `month` varchar(45) DEFAULT NULL,
  `id` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `pay` double DEFAULT NULL,
  `due` double DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `create` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`salary_id`),
  UNIQUE KEY `salary_id_UNIQUE` (`salary_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES ('SL-0000003','January','TR-0000019','Nazira Akter',18000,0,18000,'Unpaid','2023-04-28 07:47:57','2023-04-28 07:47:57'),('SL-0000004','Apri','SF-0000004','didar hossen',6500,6500,0,'Paid','2023-04-29 04:03:08','2023-04-29 04:03:36'),('SL-0000005','January','TR-0000003','Sadia Afren',13500,0,13500,'Unpaid','2023-04-29 04:36:20','2023-04-29 04:36:20');
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (9,'SF-0000001','kamal','hossen','jamal','komola','1993-04-30','Male','01785456985','kaml@gm.com','dhaka','2023-04-08','Recepsonist','HONOURS',16500),(10,'SF-0000002','jamal','hossen','abdullah','sadia','2000-04-21','Male','01456321452','jamal@gmail.com','kulna','2023-04-07','Computer Operator','MA',20000),(11,'SF-0000003','didar','hossen','fahim','fahimma','2023-04-16','Male','01458796542','sfdf@gm.com','dgtdgdg','2023-04-17','Recepsonist','HONOURS',5000),(12,'SF-0000004','didar','hossen','habib','hasina','2023-04-16','Male','01456258754','assda@gm.com','dhaka','2023-04-16','Recepsonist','HONOURS',6500),(13,'SF-0000005','Abid','Hasan','Korim','Kakoli','2023-04-11','Male','01478956541','abid@gmail.com','Dhaka','2023-04-18','Manager','HONOURS',15600);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_attendace`
--

DROP TABLE IF EXISTS `staff_attendace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_attendace` (
  `date` date DEFAULT NULL,
  `staff_id` varchar(45) DEFAULT NULL,
  `staff_name` varchar(45) DEFAULT NULL,
  `attendance` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_attendace`
--

LOCK TABLES `staff_attendace` WRITE;
/*!40000 ALTER TABLE `staff_attendace` DISABLE KEYS */;
INSERT INTO `staff_attendace` VALUES ('2023-04-13','SF-0000002','jamal hossen','Absent'),('2023-04-15','SF-0000001','kamal hossen','Present'),('2023-04-15','SF-0000003','didar hossen','Present');
/*!40000 ALTER TABLE `staff_attendace` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (22,'ST-0000001','Kamal','Hossen','Jamal','Jamila','2023-04-17','Male','01658749654','kamal@gmail.com','Dhaka','2023-04-17','Advance Java','BH-0000003','SF-0000005','HSC/ALIM',5000),(23,'ST-0000002','Nurjahan','Akter','Nasir','Nadia','2023-04-18','Female','01789546321','nurjahan@gm.com','Dhaka','2023-04-24','PHP','BH-0000002','SF-0000004','FAZIL/DEGREE',4000),(24,'ST-0000003','Nayeem','islam','Korim','Komola','2023-04-19','Male','01732548987','nayeem@gmail.com','Dhaka','2023-04-29','Core Java','BH-0000001','SF-0000004','HSC/ALIM',8000),(25,'ST-0000004','Yakub','Ali','Kayum','Sanjida','1995-04-12','Male','01789654123','yakub@gmail.com','Kumillah','2023-04-29','PHP','BH-0000002','SF-0000004','HSC/ALIM',4000),(26,'ST-0000005','Afsaar','uddin','Hasem','Dina','1992-04-15','Male','01758965412','afser@gmail.com','kustia','2023-04-29','Advance Java','BH-0000003','SF-0000004','FAZIL/DEGREE',5000),(28,'ST-0000006','Nuruddin','mun','Akabor','fatema','2000-04-18','Male','01789654123','nuruddin@gmail.com','barisal','2023-04-29','HTML','BH-0000004','SF-0000004','FAZIL/DEGREE',3000),(29,'ST-0000007','Jafor','mun','Kamal','Sadia','2023-04-29','Male','01789546214','jafor@gmail.com','dhaka','2023-04-29','CSS','BH-0000005','SF-0000003','FAZIL/DEGREE',2500),(30,'ST-0000008','Saidul','Islam','Ali Ahmed','Fatema','1995-04-19','Male','01789546985','saidul@gmail.com','Barisal','2023-04-20','My SQL','BH-0000006','SF-0000003','MA',4000),(31,'ST-0000009','Habibullah','Tanvir','Nurujjaman','Fatema','2023-04-28','Male','01758965412','habibullah@gmail.com','Dhaka','2023-04-19','MS Office','BH-0000007','SF-0000002','MA',2500),(32,'ST-0000010','Jannat','Ara','Kashem','Jamila','2000-04-12','Female','01365487941','jannat@gmail.com','soriatpur','2023-04-19','PhotoShop','BH-0000008','SF-0000001','KAMIL',6000),(33,'ST-0000011','Tithi','akter','Tanvir','Tania','2023-04-21','Female','01965874512','tithi@gmail.com','Jamalpur','2023-04-19','Illustrator','BH-0000009','SF-0000001','KAMIL',8000);
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (9,'TR-0000001','Adib','Hasan','Kadib','Komola','1995-04-25','Male','01200000000','adib@gmail.com','Dhaka','2023-04-25','MS Office','HONOURS',8000),(10,'TR-0000002','Sonia','Akter','Sajed','Sadia','2023-04-24','Female','01365487954','sonia@gmail.com','Cumilla','2023-04-24','Core JAVA','MA',12000),(11,'TR-0000003','Sadia','Afren','Didar','Didi','2023-04-18','Female','01452655454','sadia@gmail.com','Khulna','2023-04-24','Core JAVA','HONOURS',13500),(12,'TR-0000004','Lamia','Akter','Wali','Asia','2023-04-24','Female','01352154154','lamia@gmail.com','Dhaka','2023-04-24','Advanced Java','HONOURS',18500),(13,'TR-0000005','Asad','Mia','Amjad','sadia','2023-04-17','Male','01568541241','asad@gmail.com','Barisal','2023-04-24','PHP','HONOURS',14500),(14,'TR-0000006','Aminul','Hossain','Abir','Runa','2008-04-14','Male','01796502426','aminul@gmail.com','Dhaka,Bangladesh','2017-04-12','MS Office','HONOURS',13000),(15,'TR-0000007','Nushrat','Jahan','Muktu','Munni','1999-09-29','Female','01785698464','nushrat@gmail.com','Muladi.Borishal','2020-04-25','HTML CSS','HONOURS',14000),(24,'TR-0000008','Eakub','Ali','Monnan','Hasina','2009-07-30','Male','01896164646','eakub@gmail.com','Shariatpur','2019-08-15','C# .Net','MA',15000),(25,'TR-0000009','Mukul','Gorami','Nadir','Najira','1994-11-24','Male','01759784585','mukul@gmail.com','Hisla','2020-09-22','Core JAVA','KAMIL',15500),(26,'TR-0000010','Sayful','Hossain','Hossain','rajia','1996-10-18','Male','01897789656','sayful@gmail.com','Dilli','2015-04-30','Core JAVA','FAZIL/DEGREE',16590),(28,'TR-0000011','siam','sorder','Hasnain','Hasena','1975-10-16','Male','01456836855','sim@gmail.com','khoulna','2019-04-10','Oracle Database','HONOURS',16845),(29,'TR-0000012','Aklima','Akter','Harun','Hosnera','1996-04-19','Female','01456893564','aklima@gmail.com','Shariatpur','2010-04-14','PHP','HONOURS',15200),(30,'TR-0000013','Nabil','Hossain','Hozrat ali','Najira','1997-04-12','Male','01254698745','nabila','khoulna','2008-04-25','Phython','FAZIL/DEGREE',19200),(31,'TR-0000014','Hasan','Ali','Ali','Amena','1971-04-09','Male','01245639875','hasan@gmail.com','Noria','2016-04-09','Android','MA',19000),(32,'TR-0000015','Rakib','Hossain','Siam','Hasina','1982-04-23','Male','01467489648','rakib@gmail.com','Joghor','2009-04-30','Advanced Java','MA',16900),(33,'TR-0000016','Kalam','Midda','Midda','Laboni','2002-06-18','Male','01457589758','kalam@gmail.com','Piruspur','2021-04-08','Laravel','HSC/ALIM',14500),(34,'TR-0000017','Runa','Boyati','Nasir','Nadia','2004-01-12','Female','01245698754','runa@gmail.com','Kumilla','2021-10-18','Wordpress','HSC/ALIM',18990),(35,'TR-0000018','Sayaba','Amin','Aminul','Fatama','1980-04-04','Female','01237657348','sayaba@gmail.com','Norshendi','2016-04-08','Bootstrap','MA',17900),(36,'TR-0000019','Nazira','Akter','Akter','Halima','1989-04-15','Female','01426877897','nazira@gmail.com','Dhaka','2018-04-28','Graphic Design','FAZIL/DEGREE',18000);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_attendance`
--

DROP TABLE IF EXISTS `teacher_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_attendance` (
  `date` date DEFAULT NULL,
  `teacher_id` varchar(45) DEFAULT NULL,
  `teacher_name` varchar(45) DEFAULT NULL,
  `attendance` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_attendance`
--

LOCK TABLES `teacher_attendance` WRITE;
/*!40000 ALTER TABLE `teacher_attendance` DISABLE KEYS */;
INSERT INTO `teacher_attendance` VALUES ('2023-04-18','TR-0000002','lamia lamia','Present'),('2023-04-18','TR-0000002','lamia akter','Absent'),('2023-04-20','TR-0000001','samim hossen','Present'),('2023-04-07','TR-0000003','Robiul hasan','Present'),('2023-04-13','TR-0000003','Robiul hasan','Absent');
/*!40000 ALTER TABLE `teacher_attendance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-29 12:27:23
