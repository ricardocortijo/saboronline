CREATE DATABASE  IF NOT EXISTS `db_sabor_online` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_sabor_online`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: db_sabor_online
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `banco`
--

DROP TABLE IF EXISTS `banco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Tabla de Bancos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banco`
--

LOCK TABLES `banco` WRITE;
/*!40000 ALTER TABLE `banco` DISABLE KEYS */;
INSERT INTO `banco` VALUES (1,'Banco del Pueblo'),(2,'Banco Cheverengue'),(3,'Banco del Cerdito');
/*!40000 ALTER TABLE `banco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `tipo_menu` int(11) NOT NULL,
  `precio_total` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk2_tipomenu_menu_idx` (`tipo_menu`),
  CONSTRAINT `fk1_menu_menudetalle` FOREIGN KEY (`id`) REFERENCES `menu_detalle` (`id_menu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk2_tipomenu_menu` FOREIGN KEY (`tipo_menu`) REFERENCES `tipo_menu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_detalle`
--

DROP TABLE IF EXISTS `menu_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_detalle` (
  `id_menu` int(11) NOT NULL,
  `correlativo` varchar(45) DEFAULT NULL,
  `id_plato` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_menu`),
  KEY `fk1_menudetalle_plato_idx` (`id_plato`),
  CONSTRAINT `fk1_menudetalle_plato` FOREIGN KEY (`id_plato`) REFERENCES `plato` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_detalle`
--

LOCK TABLES `menu_detalle` WRITE;
/*!40000 ALTER TABLE `menu_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `direccion_entrega` varchar(1000) DEFAULT NULL,
  `fecha_hora_llegada` datetime DEFAULT NULL,
  `fecha_hora_estimada` datetime DEFAULT NULL,
  `distrito` varchar(145) DEFAULT NULL,
  `modo_pago` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'2016-10-10 00:00:00',NULL,'Calle 123',NULL,NULL,'ATE','01'),(2,'2016-11-10 00:00:00',NULL,'Av. Real Plaza 456',NULL,NULL,'LINCE','02'),(3,'2016-11-10 00:00:00',NULL,'Av. Real Plaza 456',NULL,NULL,'LINCE','02'),(4,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_detalle`
--

DROP TABLE IF EXISTS `pedido_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_detalle` (
  `id_pedido` int(11) NOT NULL,
  `correlativo` varchar(45) DEFAULT NULL,
  `id_menu_plato` int(11) DEFAULT NULL,
  `cantidad_menu_plato` int(11) DEFAULT NULL,
  `tipo_detalle` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_detalle`
--

LOCK TABLES `pedido_detalle` WRITE;
/*!40000 ALTER TABLE `pedido_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plato`
--

DROP TABLE IF EXISTS `plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plato` (
  `id` int(11) NOT NULL,
  `nombre` varchar(450) DEFAULT NULL,
  `descripcion` text,
  `foto` longblob,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plato`
--

LOCK TABLES `plato` WRITE;
/*!40000 ALTER TABLE `plato` DISABLE KEYS */;
/*!40000 ALTER TABLE `plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva_mesa`
--

DROP TABLE IF EXISTS `reserva_mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva_mesa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_reserva` datetime DEFAULT NULL,
  `numero_mesa` int(11) DEFAULT NULL,
  `codigo_usuario` varchar(45) DEFAULT NULL,
  `numero_sillas` int(11) DEFAULT NULL,
  `comentarios` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva_mesa`
--

LOCK TABLES `reserva_mesa` WRITE;
/*!40000 ALTER TABLE `reserva_mesa` DISABLE KEYS */;
INSERT INTO `reserva_mesa` VALUES (1,'2016-10-10 00:00:00',6,NULL,5,'Atencion lo mejor posible');
/*!40000 ALTER TABLE `reserva_mesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla de Roles de Usuario';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Super Administrador'),(2,'Administrador'),(3,'Cliente'),(4,'Invitado');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_menu`
--

DROP TABLE IF EXISTS `tipo_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UX_CATEGORIA_01` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='Catálogo de Categorías';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_menu`
--

LOCK TABLES `tipo_menu` WRITE;
/*!40000 ALTER TABLE `tipo_menu` DISABLE KEYS */;
INSERT INTO `tipo_menu` VALUES (1,'Desayuno','Desayuno'),(2,'Menu Clásico','Menu Clásico'),(3,'Menu Ejecutivo','Menu Ejecutivo'),(4,'Menú Dietético','Menú Dietético'),(5,'Platos a la Carta','Platos a la Carta');
/*!40000 ALTER TABLE `tipo_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_rol` int(11) NOT NULL,
  `codigo_usuario` varchar(20) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `nombres` varchar(150) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `correo_electronico` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UX_USUARIO_01` (`codigo_usuario`),
  KEY `FK_USUARIO_TO_ROL_01` (`id_rol`),
  CONSTRAINT `FK_USUARIO_TO_ROL_01` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='Tabla de Usuarios del Sistema';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,2,'rcortijo','rcortijo','Ricardo','Cortijo','rcortijo@sbs.gob.pe'),(2,3,'gramos','gramos','Gisela','Ramos','gramos@gmail.com'),(3,1,'admin','admin','Administrador','del Sistema','system.rc@gmail.com'),(4,3,'rvasquez','rvasquez','Raul','Vasquez','rvasquez@sbs.gob.pe'),(5,3,'sportocarrero','sportocarrero','Sandra','Portocarrero','sportocarrero@sbs.gob.pe');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-10 21:50:32
