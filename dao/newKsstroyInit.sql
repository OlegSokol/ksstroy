DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `PROJECT_NAME` VARCHAR(64) NOT NULL,
  `DESCRIPTION` VARCHAR(512), 
  `ID_GROUP` INT(10) UNSIGNED
);  
INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`, `ID_GROUP`) VALUES (33, 'Cool Project', 'Very cool', '1');
INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`, `ID_GROUP`) VALUES (34, 'Another Cool Project', 'Super cool', '1');
INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`, `ID_GROUP`) VALUES (35, 'Not Cool Project', 'Not cool', '1');


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `NAME` VARCHAR(64) NOT NULL,
  `PASSWORD` VARCHAR(64) NOT NULL,
  `ROLE` VARCHAR(32) NOT NULL
);
INSERT INTO `users` (`ID`, `NAME`, `PASSWORD`, `ROLE`) VALUES (1, 'admin', 'nimda', 'admin');
  

DROP TABLE IF EXISTS `user_project_rel`;
CREATE TABLE `user_project_rel` (
  `project` INT(10),
  `user` INT(10)
);
INSERT INTO `user_project_rel` (`project`, `user`) VALUES (33, 1);
INSERT INTO `user_project_rel` (`project`, `user`) VALUES (34, 1);


DROP TABLE IF EXISTS `zones`;
CREATE TABLE `zones` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(50) not NULL ,
  `width` double unsigned not NULL,
  `height` double unsigned not NULL ,
  `mesure_name` VARCHAR(50) not NULL ,
  `parent_group_id` INT(10) UNSIGNED ,
  `surplus_for_zones_id` INT(10) UNSIGNED ,#have value only if the zone is surplus
  `addit_for_zones_id` INT(10) UNSIGNED #have value only if the zone is additional
);


INSERT INTO `zones`  VALUES (1,'pol1', 10.0,10.0,'M2',1,null,null);
INSERT INTO `zones`  VALUES (2,'stenaA', 6.0,3.0,'M2',1,null,null);
INSERT INTO `zones`  VALUES (3,'potolok', 10.0,10.0,'M2',1,null,null);
INSERT INTO `zones`  VALUES (4,'stenaB', 7.0,3.5,'M2',1,null,null);
INSERT INTO `zones`  VALUES (5,'otkosi1', 5.0,5.0,'M2',null,null,1);
INSERT INTO `zones`  VALUES (6,'otkosi2', 3.0,2.0,'M2',null,null,2);
INSERT INTO `zones`  VALUES (7,'pamyatnikLenina', 2.0,2.0,'M2',null,null,1);
INSERT INTO `zones`  VALUES (8,'pamyatnikDartVeyderu', 10.0,4.0,'M2',null,null,2);
INSERT INTO `zones`  VALUES (9,'dver1', 2.0,1.0,'M2',null,1,null);
INSERT INTO `zones`  VALUES (10,'dver2', 3.0,2.0,'M2',null,2,null);
INSERT INTO `zones`  VALUES (11,'okno1', 3.0,1.25,'M2',null,1,null);
INSERT INTO `zones`  VALUES (12,'okno2', 2.0,1.35,'M2',null,2,null);


DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
    `group_id` BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) ,
    `parent_id` BIGINT(20) 
);
INSERT INTO `groups`  VALUES (1,'Kvartira',null);
INSERT INTO `groups`  VALUES (2,'Penthaus',null);
INSERT INTO `groups`  VALUES (3,'Dacha',null);
INSERT INTO `groups` VALUES (4,'Kuhnya', 1);
INSERT INTO `groups` VALUES (5,'Spalnya', 1);
INSERT INTO `groups` VALUES (6,'Tualet', 1);
INSERT INTO `groups` VALUES (7,'Vannaya', 2);
INSERT INTO `groups` VALUES (8,'Prihozhaya', 2);