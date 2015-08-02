DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `PROJECT_NAME` VARCHAR(64) NOT NULL,
  `DESCRIPTION` VARCHAR(512) 
);  
INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`) VALUES (33, 'Cool Project', 'Very cool');
INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`) VALUES (34, 'Another Cool Project', 'Super cool');
INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`) VALUES (35, 'Not Cool Project', 'Not cool');


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
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `width` double NULL DEFAULT NULL,
  `height` double NULL DEFAULT NULL,
  `mesure_name` VARCHAR(50) NULL DEFAULT NULL,
  `group_for_zones_id` BIGINT(20) NULL DEFAULT NULL
);


DROP TABLE IF EXISTS `adddit_zones`;
CREATE TABLE `adddit_zones` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `width` double NULL DEFAULT NULL,
  `height` double NULL DEFAULT NULL,
  `mesure_name` VARCHAR(50) NULL DEFAULT NULL,
  `zones_additionals` BIGINT(20) NULL DEFAULT NULL
);


DROP TABLE IF EXISTS `surplus_zones`;
CREATE TABLE `surplus_zones` (
   `id` BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `width` double NULL DEFAULT NULL,
  `height` double NULL DEFAULT NULL,
  `mesure_name` VARCHAR(50) NULL DEFAULT NULL,
  `zones_surpluses` BIGINT(20) NULL DEFAULT NULL
);


DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
    `id` BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NULL DEFAULT NULL,
    `parent_id` BIGINT(20) NULL DEFAULT NULL
);