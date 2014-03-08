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
  `user_id` bigint(20) DEFAULT NULL,
  `points` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dc207fihfo1l7xluv3pjgu2x8` (`user_id`),
  CONSTRAINT `FK_dc207fihfo1l7xluv3pjgu2x8` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `point` */

insert  into `point`(`id`,`user_id`,`points`) values (1,1,100),(2,1,100),(3,1,100),(4,1,100),(5,1,100),(6,1,100),(7,1,100),(8,1,100);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_he7oii3ojjm80ul8agvlpjv7q` (`merchant_id`),
  CONSTRAINT `FK_he7oii3ojjm80ul8agvlpjv7q` FOREIGN KEY (`merchant_id`) REFERENCES `merchant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`merchant_id`,`name`) values (1,1,'Coffee');

/*Table structure for table `redemption` */

DROP TABLE IF EXISTS `redemption`;

CREATE TABLE `redemption` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bysvscrxx5aufw04qdfx6xgwk` (`product_id`),
  KEY `FK_dee4j7s5hcxaovstt9nt8rc6e` (`user_id`),
  CONSTRAINT `FK_bysvscrxx5aufw04qdfx6xgwk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_dee4j7s5hcxaovstt9nt8rc6e` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `redemption` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` bigint(20) DEFAULT NULL,
  `identifier` varchar(255) DEFAULT NULL,
  `identifierType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6li1npptiqaolnystaxt5jamu` (`merchant_id`),
  CONSTRAINT `FK_6li1npptiqaolnystaxt5jamu` FOREIGN KEY (`merchant_id`) REFERENCES `merchant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`merchant_id`,`identifier`,`identifierType`) values (1,1,'4551967719','MSISDN');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
