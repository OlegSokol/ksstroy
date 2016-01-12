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


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID`       INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `NAME`     VARCHAR(64)      NOT NULL,
  `PASSWORD` VARCHAR(64)      NOT NULL,
  `ROLE`     VARCHAR(32)      NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `user_project_rel`;
CREATE TABLE `user_project_rel` (
  `project` INT(10),
  `user`    INT(10)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `zones`;
CREATE TABLE `zones` (
  `id`                   BIGINT(10)      NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`                 VARCHAR(50)     NOT NULL,
  `width`                DOUBLE UNSIGNED NOT NULL,
  `height`               DOUBLE UNSIGNED NOT NULL,
  `mesure_name`          VARCHAR(50)     NOT NULL,
  `parent_group_id`      INT(10) UNSIGNED,
  `surplus_for_zones_id` INT(10) UNSIGNED, #have value only if the zonegroup is surplus
  `addit_for_zones_id`   INT(10) UNSIGNED #have value only if the zonegroup is additional
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `group_id`  BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`      VARCHAR(50),
  `parent_id` BIGINT(20)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


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


DROP TABLE IF EXISTS `worktype_groups`;
CREATE TABLE `worktype_groups` (
  `group_id`  BIGINT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`      VARCHAR(50),
  `parent_id` BIGINT(20)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `material_type_group`;
CREATE TABLE `material_type_group` (
  `id`          INT(11)     NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(50) NOT NULL,
  `description` VARCHAR(512)         DEFAULT NULL,
  `parent_id`   BIGINT(20),
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_id` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `material_type`;
CREATE TABLE `material_type` (
  `id`             INT(11)     NOT NULL AUTO_INCREMENT,
  `name`           VARCHAR(50) NOT NULL,
  `description`    VARCHAR(512)         DEFAULT NULL,
  `price_per_unit` DOUBLE      NOT NULL,
  `unit_name`      VARCHAR(50) NOT NULL,
  `parent_id`      BIGINT(20),
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_id` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `materials`;
CREATE TABLE `materials` (
  `id`                          INT(8)      NOT NULL AUTO_INCREMENT,
   `units_per_work_zone_measure` DOUBLE  ,
  `planed_cost`                 DOUBLE      ,
  `deal_cost`                   DOUBLE      ,
  `closed_cost`                 DOUBLE      ,
  `material_type_id`          INT(8),
  PRIMARY KEY (`id`)
 )
ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `worktype_material_rel`;
CREATE TABLE `worktype_material_rel` (
  `worktype_id` INT(10),
  `material_id`    INT(10)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `works`;
CREATE TABLE `works` (
  `work_id`          BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`             VARCHAR(50),
  `work_type_id`     BIGINT(11),
  `planed_cost`      DOUBLE,
  `perspective_cost` DOUBLE,
  `closed_cost`      DOUBLE,
  `deal_cost`        DOUBLE,
  `parent_group_id`  BIGINT(11)
);


DROP TABLE IF EXISTS `work_zone_rel`;
CREATE TABLE `work_zone_rel` (
  `id`      BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `work_id` BIGINT(11),
  `zone_id` BIGINT(11)
);


DROP TABLE IF EXISTS `adjustments`;
CREATE TABLE `adjustments` (
  `id`          BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `value`       DOUBLE,
  `is_absolute` TINYINT,
  `work_id`     BIGINT(11)
);


DROP TABLE IF EXISTS `covers`;
CREATE TABLE `covers` (
  `id`          BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `value`       DOUBLE,
  `date`        VARCHAR(20),
  `description` VARCHAR(20),
  `work_id`     BIGINT(11)
);


DROP TABLE IF EXISTS `work_groups`;
CREATE TABLE `work_groups` (
  `id`        BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`      VARCHAR(20),
  `parent_id` BIGINT(11)
);