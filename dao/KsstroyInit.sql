USE ksstroy;
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `ID`           INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `PROJECT_NAME` VARCHAR(64)      NOT NULL,
  `DESCRIPTION`  VARCHAR(512),
  `ID_GROUP`     INT(10) UNSIGNED
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`, `ID_GROUP`)
VALUES (33, 'Cool Project', 'Very cool', '1');
INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`, `ID_GROUP`)
VALUES (34, 'Another Cool Project', 'Super cool', '1');
INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`, `ID_GROUP`)
VALUES (35, 'Not Cool Project', 'Not cool', '1');


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID`       INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `NAME`     VARCHAR(64)      NOT NULL,
  `PASSWORD` VARCHAR(64)      NOT NULL,
  `ROLE`     VARCHAR(32)      NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `users` (`ID`, `NAME`, `PASSWORD`, `ROLE`) VALUES (1, 'admin', 'nimda', 'admin');


DROP TABLE IF EXISTS `user_project_rel`;
CREATE TABLE `user_project_rel` (
  `project` INT(10),
  `user`    INT(10)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `user_project_rel` (`project`, `user`) VALUES (33, 1);
INSERT INTO `user_project_rel` (`project`, `user`) VALUES (34, 1);


DROP TABLE IF EXISTS `zones`;
CREATE TABLE `zones` (
  `id`                   BIGINT(10)      NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`                 VARCHAR(50)     NOT NULL,
  `width`                DOUBLE UNSIGNED NOT NULL,
  `height`               DOUBLE UNSIGNED NOT NULL,
  `mesure_name`          VARCHAR(50)     NOT NULL,
  `parent_group_id`      INT(10) UNSIGNED,
  `surplus_for_zones_id` INT(10) UNSIGNED, #have value only if the zone is surplus
  `addit_for_zones_id`   INT(10) UNSIGNED #have value only if the zone is additional
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `zones` VALUES (1, 'pol1', 10.0, 10.0, 'M2', 4, NULL, NULL);
INSERT INTO `zones` VALUES (2, 'stenaA', 6.0, 3.0, 'M2', 5, NULL, NULL);
INSERT INTO `zones` VALUES (3, 'potolok', 10.0, 10.0, 'M2', 5, NULL, NULL);
INSERT INTO `zones` VALUES (4, 'stenaB', 7.0, 3.5, 'M2', 6, NULL, NULL);
INSERT INTO `zones` VALUES (5, 'otkosi1', 5.0, 5.0, 'M2', NULL, NULL, 1);
INSERT INTO `zones` VALUES (6, 'otkosi2', 3.0, 2.0, 'M2', NULL, NULL, 2);
INSERT INTO `zones` VALUES (7, 'pamyatnikLenina', 2.0, 2.0, 'M2', NULL, NULL, 3);
INSERT INTO `zones` VALUES (8, 'pamyatnikDartVeyderu', 10.0, 4.0, 'M2', NULL, NULL, 4);
INSERT INTO `zones` VALUES (9, 'dver1', 2.0, 1.0, 'M2', NULL, 1, NULL);
INSERT INTO `zones` VALUES (10, 'dver2', 3.0, 2.0, 'M2', NULL, 2, NULL);
INSERT INTO `zones` VALUES (11, 'okno1', 3.0, 1.25, 'M2', NULL, 3, NULL);
INSERT INTO `zones` VALUES (12, 'okno2', 2.0, 1.35, 'M2', NULL, 4, NULL);


DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `group_id`  BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`      VARCHAR(50),
  `parent_id` BIGINT(20)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `groups` VALUES (1, 'Kvartira', NULL);
INSERT INTO `groups` VALUES (2, 'Penthaus', NULL);
INSERT INTO `groups` VALUES (3, 'Dacha', NULL);
INSERT INTO `groups` VALUES (4, 'Kuhnya', 1);
INSERT INTO `groups` VALUES (5, 'Spalnya', 1);
INSERT INTO `groups` VALUES (6, 'Tualet', 1);
INSERT INTO `groups` VALUES (7, 'Vannaya', 2);
INSERT INTO `groups` VALUES (8, 'Prihozhaya', 2);


DROP TABLE IF EXISTS `worktypes`;
CREATE TABLE `worktypes` (
  `worktype_id`     BIGINT(10)  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`            VARCHAR(50),
  `description`     VARCHAR(512),
  `measure_name`    VARCHAR(50) NOT NULL,
  `unit_price`      DOUBLE,
  `parent_group_id` INT(10) UNSIGNED
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `worktypes` VALUES (1, 'worktype_1', 'worktype_1_descr.', 'L', 3.45, 2);
INSERT INTO `worktypes` VALUES (2, 'worktype_2', 'worktype_2_descr.', 'L', 3.45, 2);
INSERT INTO `worktypes` VALUES (3, 'worktype_3', 'worktype_3_descr.', 'L', 3.45, 3);
INSERT INTO `worktypes` VALUES (4, 'worktype_4', 'worktype_4_descr.', 'L', 3.45, 3);
INSERT INTO `worktypes` VALUES (5, 'worktype_5', 'worktype_5_descr.', 'L', 3.45, 4);
INSERT INTO `worktypes` VALUES (6, 'worktype_6', 'worktype_6_descr.', 'L', 3.45, 4);
INSERT INTO `worktypes` VALUES (7, 'worktype_7', 'worktype_7_descr.', 'L', 3.45, 5);
INSERT INTO `worktypes` VALUES (8, 'worktype_8', 'worktype_8_descr.', 'L', 3.45, 5);
INSERT INTO `worktypes` VALUES (9, 'worktype_9', 'worktype_9_descr.', 'L', 3.45, 6);
INSERT INTO `worktypes` VALUES (10, 'worktype_10', 'worktype_10_descr.', 'L', 3.45, 6);
INSERT INTO `worktypes` VALUES (11, 'worktype_11', 'worktype_11_descr.', 'L', 3.45, 7);
INSERT INTO `worktypes` VALUES (12, 'worktype_12', 'worktype_12_descr.', 'L', 3.45, 7);


DROP TABLE IF EXISTS `worktype_groups`;
CREATE TABLE `worktype_groups` (
  `group_id`  BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`      VARCHAR(50),
  `parent_id` BIGINT(20)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `worktype_groups` VALUES (1, 'root_group', NULL);
INSERT INTO `worktype_groups` VALUES (2, 'group_level_1A', 1);
INSERT INTO `worktype_groups` VALUES (3, 'group_level_1B', 1);
INSERT INTO `worktype_groups` VALUES (4, 'group_level_2A', 2);
INSERT INTO `worktype_groups` VALUES (5, 'group_level_2B', 2);
INSERT INTO `worktype_groups` VALUES (6, 'group_level_2C', 3);
INSERT INTO `worktype_groups` VALUES (7, 'group_level_2D', 3);


DROP TABLE IF EXISTS `material_type`;
CREATE TABLE `material_type` (
  `id`          INT(11)     NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(50) NOT NULL,
  `description` VARCHAR(512) DEFAULT NULL,
  `parent_id`   BIGINT(20),
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_id` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `material_type` VALUES (1, 'root_material_type', 'root_material_type_descr.', NULL);
INSERT INTO `material_type` VALUES (2, 'material_type_level_1A', 'material_type_1A_descr.', 1);
INSERT INTO `material_type` VALUES (3, 'material_type_level_1B', 'material_type_1B_descr.', 1);
INSERT INTO `material_type` VALUES (4, 'material_type_level_2A', 'material_type_2A_descr.', 2);
INSERT INTO `material_type` VALUES (5, 'material_type_level_2B', 'material_type_2B_descr.', 2);
INSERT INTO `material_type` VALUES (6, 'material_type_level_2C', 'material_type_2C_descr.', 3);
INSERT INTO `material_type` VALUES (7, 'material_type_level_2D', 'material_type_2D_descr.', 3);


DROP TABLE IF EXISTS `materials`;
CREATE TABLE `materials` (
  `id`           INT(11)         NOT NULL AUTO_INCREMENT,
  `name`         VARCHAR(50)     NOT NULL,
  `description`  VARCHAR(512)             DEFAULT NULL,
  `measure_name` VARCHAR(5)      NOT NULL,
  `size`         DOUBLE UNSIGNED NOT NULL,
  `planed_cost`  DOUBLE UNSIGNED DEFAULT NULL,
  `deal_cost`    DOUBLE UNSIGNED DEFAULT NULL,
  `closed_cost`  DOUBLE UNSIGNED DEFAULT NULL,
  `parent_id`    BIGINT(20)      NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_id` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `materials` VALUES (1, 'material_1', 'material_1_descr.', 'L', 10, 7.0, 6.87, 6.87, 2);
INSERT INTO `materials` VALUES (2, 'material_2', 'material_2_descr.', 'L', 10, 19.0, 18.35, 17.01, 2);
INSERT INTO `materials` VALUES (3, 'material_3', 'material_3_descr.', 'L', 10, 456.0, 19.09, 14.45, 3);
INSERT INTO `materials` VALUES (4, 'material_4', 'material_4_descr.', 'L', 10, 456.0, 19.09, 14.45, 3);
INSERT INTO `materials` VALUES (5, 'material_5', 'material_5_descr.', 'L', 10, 456.0, 19.09, 14.45, 4);
INSERT INTO `materials` VALUES (6, 'material_6', 'material_6_descr.', 'L', 10, 456.0, 19.09, 14.45, 4);
INSERT INTO `materials` VALUES (7, 'material_7', 'material_7_descr.', 'L', 10, 456.0, 19.09, 14.45, 5);
INSERT INTO `materials` VALUES (8, 'material_8', 'material_8_descr.', 'L', 10, 456.0, 19.09, 14.45, 5);
INSERT INTO `materials` VALUES (9, 'material_9', 'material_9_descr.', 'L', 10, 456.0, 19.09, 14.45, 6);
INSERT INTO `materials` VALUES (10, 'material_10', 'material_10_descr.', 'L', 10, 456.0, 19.09, 14.45, 7);