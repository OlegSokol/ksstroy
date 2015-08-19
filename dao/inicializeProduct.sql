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


DROP TABLE IF EXISTS `zones`;
CREATE TABLE `zones` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `width` double NULL DEFAULT NULL,
  `height` double NULL DEFAULT NULL,
  `mesure_name` VARCHAR(50) NULL DEFAULT NULL,
  `group_for_zones_id` BIGINT(20) NULL DEFAULT NULL
);
INSERT INTO `zones` (`name`, `width`, `height`, `mesure_name`, `group_for_zones_id`) VALUES ('Door', '2', '0.8', 'm2', '1');
INSERT INTO `zones` (`name`, `width`, `height`, `mesure_name`, `group_for_zones_id`) VALUES ('Window', '2', '0.8', 'm2', '1');


DROP TABLE IF EXISTS `adddit_zones`;
CREATE TABLE `adddit_zones` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `width` double NULL DEFAULT NULL,
  `height` double NULL DEFAULT NULL,
  `mesure_name` VARCHAR(50) NULL DEFAULT NULL,
  `zones_additionals` BIGINT(20) NULL DEFAULT NULL
);
INSERT INTO `adddit_zones` (`name`, `width`, `height`, `mesure_name`, `zones_additionals`) VALUES ('Door', '2', '0.8', 'm2', '1');
INSERT INTO `adddit_zones` (`name`, `width`, `height`, `mesure_name`, `zones_additionals`) VALUES ('Window', '2', '0.8', 'm2', '1');


DROP TABLE IF EXISTS `surplus_zones`;
CREATE TABLE `surplus_zones` (
   `id` BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `width` double NULL DEFAULT NULL,
  `height` double NULL DEFAULT NULL,
  `mesure_name` VARCHAR(50) NULL DEFAULT NULL,
  `zones_surpluses` BIGINT(20) NULL DEFAULT NULL
);
INSERT INTO `surplus_zones` (`name`, `width`, `height`, `mesure_name`, `zones_surpluses`) VALUES ('Door', '2', '0.8', 'm2', '1');
INSERT INTO `surplus_zones` (`name`, `width`, `height`, `mesure_name`, `zones_surpluses`) VALUES ('Window', '2', '0.8', 'm2', '1');


DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
    `id` BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NULL DEFAULT NULL,
    `parent_id` BIGINT(20) NULL DEFAULT NULL
);
INSERT INTO `groups` (`name`, `parent_id`) VALUES ('Kitchen', '1');
INSERT INTO `groups` (`name`, `parent_id`) VALUES ('Kitchen2', '1');

CREATE TABLE IF NOT EXISTS worktypes (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    parent_id INT(10) UNSIGNED,
    name VARCHAR(50) NOT NULL,
	description VARCHAR(400),
	measure_name VARCHAR(50),
	unit_price DOUBLE,
	FOREIGN KEY (parent_id) REFERENCES worktypes(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS materials (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS worktype_material_rel (
    worktype_id INT(10) UNSIGNED,
    material_id INT(10) UNSIGNED,
    FOREIGN KEY (worktype_id) REFERENCES worktypes(id),
    FOREIGN KEY (material_id) REFERENCES materials(id),
	PRIMARY KEY (worktype_id,material_id)
) engine=InnoDB;
