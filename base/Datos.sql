-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pima_cpt
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Dumping data for table `answer_client_opt`
--

LOCK TABLES `answer_client_opt` WRITE;
/*!40000 ALTER TABLE `answer_client_opt` DISABLE KEYS */;
/*!40000 ALTER TABLE `answer_client_opt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `broker`
--

LOCK TABLES `broker` WRITE;
/*!40000 ALTER TABLE `broker` DISABLE KEYS */;
/*!40000 ALTER TABLE `broker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category_user`
--

LOCK TABLES `category_user` WRITE;
/*!40000 ALTER TABLE `category_user` DISABLE KEYS */;
INSERT INTO `category_user` VALUES (1,'ADMIN'),(2,'CLIENTE');
/*!40000 ALTER TABLE `category_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Nombre','ApellidoP','ApellidoM','89','347','',1,2,2,1,1,1);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `colonia`
--

LOCK TABLES `colonia` WRITE;
/*!40000 ALTER TABLE `colonia` DISABLE KEYS */;
INSERT INTO `colonia` VALUES (1,'Morelos','97190',1);
/*!40000 ALTER TABLE `colonia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `datos_personales_asesor`
--

LOCK TABLES `datos_personales_asesor` WRITE;
/*!40000 ALTER TABLE `datos_personales_asesor` DISABLE KEYS */;
/*!40000 ALTER TABLE `datos_personales_asesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `document_reference`
--

LOCK TABLES `document_reference` WRITE;
/*!40000 ALTER TABLE `document_reference` DISABLE KEYS */;
/*!40000 ALTER TABLE `document_reference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `documentation_cliente`
--

LOCK TABLES `documentation_cliente` WRITE;
/*!40000 ALTER TABLE `documentation_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `documentation_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Yucatan');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `free_answer`
--

LOCK TABLES `free_answer` WRITE;
/*!40000 ALTER TABLE `free_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `free_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'Hombre'),(2,'Mujer');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `marital_status`
--

LOCK TABLES `marital_status` WRITE;
/*!40000 ALTER TABLE `marital_status` DISABLE KEYS */;
INSERT INTO `marital_status` VALUES (1,'Default'),(2,'Mancumunado');
/*!40000 ALTER TABLE `marital_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `medic_questions`
--

LOCK TABLES `medic_questions` WRITE;
/*!40000 ALTER TABLE `medic_questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `medic_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `municipio`
--

LOCK TABLES `municipio` WRITE;
/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` VALUES (1,'Merida',1);
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nationality`
--

LOCK TABLES `nationality` WRITE;
/*!40000 ALTER TABLE `nationality` DISABLE KEYS */;
INSERT INTO `nationality` VALUES (1,'Mexicana');
/*!40000 ALTER TABLE `nationality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `option_answer`
--

LOCK TABLES `option_answer` WRITE;
/*!40000 ALTER TABLE `option_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `option_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `personal_data_client`
--

LOCK TABLES `personal_data_client` WRITE;
/*!40000 ALTER TABLE `personal_data_client` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_data_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reference`
--

LOCK TABLES `reference` WRITE;
/*!40000 ALTER TABLE `reference` DISABLE KEYS */;
/*!40000 ALTER TABLE `reference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `requement_client_broker`
--

LOCK TABLES `requement_client_broker` WRITE;
/*!40000 ALTER TABLE `requement_client_broker` DISABLE KEYS */;
/*!40000 ALTER TABLE `requement_client_broker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `requerement`
--

LOCK TABLES `requerement` WRITE;
/*!40000 ALTER TABLE `requerement` DISABLE KEYS */;
/*!40000 ALTER TABLE `requerement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `status_requeriment`
--

LOCK TABLES `status_requeriment` WRITE;
/*!40000 ALTER TABLE `status_requeriment` DISABLE KEYS */;
/*!40000 ALTER TABLE `status_requeriment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `type_cilvil`
--

LOCK TABLES `type_cilvil` WRITE;
/*!40000 ALTER TABLE `type_cilvil` DISABLE KEYS */;
INSERT INTO `type_cilvil` VALUES (1,'Soltero'),(2,'Divorciado'),(3,'Casado');
/*!40000 ALTER TABLE `type_cilvil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `type_contract`
--

LOCK TABLES `type_contract` WRITE;
/*!40000 ALTER TABLE `type_contract` DISABLE KEYS */;
INSERT INTO `type_contract` VALUES (1,'Tiempo completo'),(2,'Tiempo parcial');
/*!40000 ALTER TABLE `type_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `type_datos`
--

LOCK TABLES `type_datos` WRITE;
/*!40000 ALTER TABLE `type_datos` DISABLE KEYS */;
INSERT INTO `type_datos` VALUES (1,'CURP'),(2,'RFC');
/*!40000 ALTER TABLE `type_datos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `type_document`
--

LOCK TABLES `type_document` WRITE;
/*!40000 ALTER TABLE `type_document` DISABLE KEYS */;
INSERT INTO `type_document` VALUES (1,'INE'),(2,'CURP');
/*!40000 ALTER TABLE `type_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `type_laboral_activity`
--

LOCK TABLES `type_laboral_activity` WRITE;
/*!40000 ALTER TABLE `type_laboral_activity` DISABLE KEYS */;
INSERT INTO `type_laboral_activity` VALUES (1,'Agricola');
/*!40000 ALTER TABLE `type_laboral_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `type_position`
--

LOCK TABLES `type_position` WRITE;
/*!40000 ALTER TABLE `type_position` DISABLE KEYS */;
INSERT INTO `type_position` VALUES (1,'Empleado');
/*!40000 ALTER TABLE `type_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `type_reference`
--

LOCK TABLES `type_reference` WRITE;
/*!40000 ALTER TABLE `type_reference` DISABLE KEYS */;
INSERT INTO `type_reference` VALUES (1,'Amigo'),(2,'Familiar');
/*!40000 ALTER TABLE `type_reference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'testClient2','metest2@mail.comn','$2a$10$kqj.ATfMO60Vw4Aw7EBcTeHEQSqup.D62Cj7pIyD0KTJxb/IHxTTW','2021-06-02 11:42:50','2021-06-02 06:42:50',1,2),(2,'testClient','metest@mail.comn','$2a$10$ziggdGH.DbjGiC6SXLRIlu2qeidSkZumJyRosOPZ5lS9nIIfTRHyi','2021-06-02 11:43:46','2021-06-02 06:55:00',1,2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work`
--

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-02  7:16:38
