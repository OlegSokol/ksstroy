DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `PROJECT_NAME` VARCHAR(64) NOT NULL,
  `DESCRIPTION` VARCHAR(512), 
  `ID_GROUP` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`ID`, `ID_GROUP`) 
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

/*
refactoring begin
*/
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


INSERT INTO `zones`  VALUES (1,'pol', 10.0,10.0,'m2',1,null,null);
INSERT INTO `zones`  VALUES (2,'potolok', 10.0,10.0,'m2',1,null,null);
INSERT INTO `zones`  VALUES (3,'otkosi', 5.0,5.0,'m2',null,null,1);
INSERT INTO `zones`  VALUES (4,'pamyatnikLenina', 2.0,2.0,'m2',null,null,1);
INSERT INTO `zones`  VALUES (5,'dver', 2.0,1.0,'m2',null,1,null);
INSERT INTO `zones`  VALUES (6,'okno', 3.0,1.25,'m2',null,1,null);


DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
    `group_id` BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) ,
    `parent_id` BIGINT(20) 
);
INSERT INTO `groups`  VALUES (1,'Kvartira',null);
INSERT INTO `groups` VALUES (2,'Kuhnya', 1);
INSERT INTO `groups` VALUES (3,'Spalnya', 1);