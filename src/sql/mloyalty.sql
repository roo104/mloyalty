/*
SQLyog Ultimate v11.22 (64 bit)
MySQL - 5.6.16 : Database - mloyalty
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mloyalty` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mloyalty`;

/*Table structure for table `merchant` */

DROP TABLE IF EXISTS `merchant`;

CREATE TABLE `merchant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `merchant` */

insert  into `merchant`(`id`,`name`,`password`,`username`) values (1,'7-eleven','9d4e1e23bd5b727046a9e3b4b7db57bd8d6ee684','7-eleven');

/*Table structure for table `point` */

DROP TABLE IF EXISTS `point`;

CREATE TABLE `point` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `points` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `dateAdded` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dc207fihfo1l7xluv3pjgu2x8` (`user_id`),
  CONSTRAINT `FK_dc207fihfo1l7xluv3pjgu2x8` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `point` */

insert  into `point`(`id`,`points`,`user_id`,`dateAdded`) values (1,100,1,'2014-03-01 18:31:19'),(2,100,1,'2014-03-02 18:31:24'),(3,100,1,'2014-03-03 18:31:27'),(4,100,1,'2014-03-04 18:31:31'),(5,100,1,'2014-03-05 18:31:35'),(6,100,1,'2014-03-06 18:31:37'),(7,100,1,'2014-03-07 18:31:41'),(8,100,1,'2014-03-08 18:31:43');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `costInPoints` bigint(20) NOT NULL,
  `endDate` datetime DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_he7oii3ojjm80ul8agvlpjv7q` (`merchant_id`),
  CONSTRAINT `FK_he7oii3ojjm80ul8agvlpjv7q` FOREIGN KEY (`merchant_id`) REFERENCES `merchant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`merchant_id`,`name`,`costInPoints`,`endDate`,`startDate`) values (1,1,'Coffee',50,'2014-03-01 18:35:02','2014-04-02 18:35:06'),(3,1,'The',45,'2014-03-01 19:02:33','2014-04-05 19:02:37');

/*Table structure for table `redemption` */

DROP TABLE IF EXISTS `redemption`;

CREATE TABLE `redemption` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `points` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `redemptionDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bysvscrxx5aufw04qdfx6xgwk` (`product_id`),
  KEY `FK_dee4j7s5hcxaovstt9nt8rc6e` (`user_id`),
  CONSTRAINT `FK_bysvscrxx5aufw04qdfx6xgwk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_dee4j7s5hcxaovstt9nt8rc6e` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `redemption` */

insert  into `redemption`(`id`,`product_id`,`points`,`user_id`,`redemptionDate`) values (1,1,50,1,'2014-03-09 18:31:51');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` bigint(20) DEFAULT NULL,
  `identifier` varchar(255) DEFAULT NULL,
  `identifierType` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6li1npptiqaolnystaxt5jamu` (`merchant_id`),
  CONSTRAINT `FK_6li1npptiqaolnystaxt5jamu` FOREIGN KEY (`merchant_id`) REFERENCES `merchant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`merchant_id`,`identifier`,`identifierType`,`password`,`creationDate`) values (1,1,'4551967719','MSISDN',NULL,'2014-03-06 20:26:52');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
