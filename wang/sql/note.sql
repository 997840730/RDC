/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - note
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`note` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `note`;

/*Table structure for table `blacklist` */

DROP TABLE IF EXISTS `blacklist`;

CREATE TABLE `blacklist` (
  `black_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`black_id`),
  CONSTRAINT `blacklist_user_fk` FOREIGN KEY (`black_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `blacklist` */

insert  into `blacklist`(`black_id`) values (5),(6);

/*Table structure for table `forum` */

DROP TABLE IF EXISTS `forum`;

CREATE TABLE `forum` (
  `forum` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `uusername` varchar(20) DEFAULT NULL,
  `uname` varchar(20) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `saydate` date DEFAULT NULL,
  PRIMARY KEY (`forum`),
  KEY `forum_user_fk` (`uid`),
  CONSTRAINT `forum_user_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `forum` */

insert  into `forum`(`forum`,`uid`,`uusername`,`uname`,`content`,`saydate`) values (1,1,'1','1','江山万里','2021-04-08'),(2,1,'1','1','我怎么知道他在说什么','2021-04-08'),(3,3,'2','天地','天地山河','2021-04-08');

/*Table structure for table `library` */

DROP TABLE IF EXISTS `library`;

CREATE TABLE `library` (
  `library_id` int(11) NOT NULL AUTO_INCREMENT,
  `library_name` varchar(20) DEFAULT NULL,
  `uid` int(11) NOT NULL,
  `librarydate` date DEFAULT NULL,
  PRIMARY KEY (`library_id`),
  KEY `library_user_fk` (`uid`),
  CONSTRAINT `library_user_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `library` */

insert  into `library`(`library_id`,`library_name`,`uid`,`librarydate`) values (1,'public',1,'2021-04-07'),(2,'不知道是谁的',3,'2021-03-31'),(5,'222',1,'2021-04-08'),(6,'我是傻逼',6,'2021-04-10'),(8,'全公开',3,'2021-04-10');

/*Table structure for table `note` */

DROP TABLE IF EXISTS `note`;

CREATE TABLE `note` (
  `note_id` int(11) NOT NULL AUTO_INCREMENT,
  `ispublic` tinyint(1) NOT NULL,
  `title` varchar(20) NOT NULL,
  `content` varchar(400) NOT NULL,
  `thumbs` int(11) DEFAULT NULL,
  `notedate` date DEFAULT NULL,
  `uid` int(11) NOT NULL,
  `lid` int(11) DEFAULT NULL,
  `uname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`note_id`),
  KEY `note_user_fk` (`uid`),
  KEY `note_library` (`lid`),
  CONSTRAINT `note_library` FOREIGN KEY (`lid`) REFERENCES `library` (`library_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `note_user_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `note` */

insert  into `note`(`note_id`,`ispublic`,`title`,`content`,`thumbs`,`notedate`,`uid`,`lid`,`uname`) values (1,1,'你','丑',1,'2021-03-30',1,5,'1'),(10,0,'我','帅',0,'2021-03-31',1,5,'1'),(20,1,'啦啦啦','丑八怪咿呀咿呀啊啊',1,'2021-04-10',3,1,'2');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_title` varchar(20) NOT NULL,
  `notice_content` varchar(50) NOT NULL,
  `notice_date` date DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`notice_id`,`notice_title`,`notice_content`,`notice_date`) values (1,'关于项目','哈哈哈，我终于做完啦!','2021-04-10');

/*Table structure for table `picture` */

DROP TABLE IF EXISTS `picture`;

CREATE TABLE `picture` (
  `picture_id` int(11) NOT NULL AUTO_INCREMENT,
  `nid` int(11) DEFAULT NULL,
  `filename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`picture_id`),
  KEY `picture_note_fk` (`nid`),
  CONSTRAINT `picture_note_fk` FOREIGN KEY (`nid`) REFERENCES `note` (`note_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `picture` */

/*Table structure for table `thumbs` */

DROP TABLE IF EXISTS `thumbs`;

CREATE TABLE `thumbs` (
  `uid` int(11) DEFAULT NULL,
  `nid` int(11) DEFAULT NULL,
  `thumbdate` date DEFAULT NULL,
  KEY `user_thumbs_fk` (`uid`),
  KEY `note_thumbs_fk` (`nid`),
  CONSTRAINT `note_thumbs_fk` FOREIGN KEY (`nid`) REFERENCES `note` (`note_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_thumbs_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `thumbs` */

insert  into `thumbs`(`uid`,`nid`,`thumbdate`) values (1,1,'2021-04-09'),(3,20,'2021-04-10');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`username`,`password`,`name`) values (1,'1','1','管理者'),(3,'2','1','天地'),(5,'5','5','阴阳'),(6,'123123','123123','卢浩林');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
