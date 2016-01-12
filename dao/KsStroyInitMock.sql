/*
Init mock projects table
 */
INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`, `ID_GROUP`)
VALUES (33, 'Cool Project', 'Very cool', '1');
INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`, `ID_GROUP`)
VALUES (34, 'Another Cool Project', 'Super cool', '1');
INSERT INTO `projects` (`ID`, `PROJECT_NAME`, `DESCRIPTION`, `ID_GROUP`)
VALUES (35, 'Not Cool Project', 'Not cool', '1');

/*
Init mock users table
 */
INSERT INTO `users` (`ID`, `NAME`, `PASSWORD`, `ROLE`) VALUES (1, 'admin', 'nimda', 'admin');

/*
Init mock user_project_rel table
 */
INSERT INTO `user_project_rel` (`project`, `user`) VALUES (33, 1);
INSERT INTO `user_project_rel` (`project`, `user`) VALUES (34, 1);

/*
Init mock zones table
 */
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

/*
Init mock groups table
 */
INSERT INTO `groups` VALUES (1, 'Kvartira', NULL);
INSERT INTO `groups` VALUES (2, 'Penthaus', NULL);
INSERT INTO `groups` VALUES (3, 'Dacha', NULL);
INSERT INTO `groups` VALUES (4, 'Kuhnya', 1);
INSERT INTO `groups` VALUES (5, 'Spalnya', 1);
INSERT INTO `groups` VALUES (6, 'Tualet', 1);
INSERT INTO `groups` VALUES (7, 'Vannaya', 2);
INSERT INTO `groups` VALUES (8, 'Prihozhaya', 2);

/*
Init mock worktypes table
 */
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

/*
Init mock worktype_groups table
 */
INSERT INTO `worktype_groups` VALUES (1, 'root_worktype_group', NULL);
INSERT INTO `worktype_groups` VALUES (2, 'group_level_1A', 1);
INSERT INTO `worktype_groups` VALUES (3, 'group_level_1B', 1);
INSERT INTO `worktype_groups` VALUES (4, 'group_level_2A', 2);
INSERT INTO `worktype_groups` VALUES (5, 'group_level_2B', 2);
INSERT INTO `worktype_groups` VALUES (6, 'group_level_2C', 3);
INSERT INTO `worktype_groups` VALUES (7, 'group_level_2D', 3);

/*
Init mock material_type_group table
 */
INSERT INTO `material_type_group` VALUES (1, 'root_material_type_group', 'root_material_type_group_descr.', NULL);
INSERT INTO `material_type_group` VALUES (2, 'material_type_group_level_1A', 'material_type_group_1A_descr.', 1);
INSERT INTO `material_type_group` VALUES (3, 'material_type_group_level_1B', 'material_type_group_1B_descr.', 1);
INSERT INTO `material_type_group` VALUES (4, 'material_type_group_level_2A', 'material_type_group_2A_descr.', 2);
INSERT INTO `material_type_group` VALUES (5, 'material_type_group_level_2B', 'material_type_group_2B_descr.', 2);
INSERT INTO `material_type_group` VALUES (6, 'material_type_group_level_2C', 'material_type_group_2C_descr.', 3);
INSERT INTO `material_type_group` VALUES (7, 'material_type_group_level_2D', 'material_type_group_2D_descr.', 3);

/*
Init mock material_type table
 */
INSERT INTO `material_type` VALUES (1, 'material_type_1', 'material_type_1_descr.', '3.0', 'unit_name_1', '2');
INSERT INTO `material_type` VALUES (2, 'material_type_2', 'material_type_2_descr.', '3.0', 'unit_name_2', '3');
INSERT INTO `material_type` VALUES (3, 'material_type_3', 'material_type_3_descr.', '3.0', 'unit_name_3', '4');
INSERT INTO `material_type` VALUES (4, 'material_type_4', 'material_type_4_descr.', '3.0', 'unit_name_4', '5');
INSERT INTO `material_type` VALUES (5, 'material_type_5', 'material_type_5_descr.', '3.0', 'unit_name_5', '6');
INSERT INTO `material_type` VALUES (6, 'material_type_6', 'material_type_6_descr.', '3.0', 'unit_name_6', '6');
INSERT INTO `material_type` VALUES (7, 'material_type_7', 'material_type_7_descr.', '3.0', 'unit_name_7', '7');
INSERT INTO `material_type` VALUES (8, 'material_type_8', 'material_type_8_descr.', '3.0', 'unit_name_8', '7');
INSERT INTO `material_type` VALUES (9, 'material_type_9', 'material_type_9_descr.', '3.0', 'unit_name_9', '7');

/*
Init mock materials table
 */
INSERT INTO `materials` VALUES (1, '2', '10.0', '3.0', '4.2', '1');
INSERT INTO `materials` VALUES (2, '2', '10.0', '3.0', '4.2', '2');
INSERT INTO `materials` VALUES (3, '2', '10.0', '3.0', '4.2', '3');
INSERT INTO `materials` VALUES (4, '2', '10.0', '3.0', '4.2', '4');
INSERT INTO `materials` VALUES (5, '2', '10.0', '3.0', '4.2', '5');

/*
Init mock worktype_material_rel table
 */
INSERT INTO `worktype_material_rel` (`worktype_id`, `material_id`) VALUES (1, 1);
INSERT INTO `worktype_material_rel` (`worktype_id`, `material_id`) VALUES (1, 2);
INSERT INTO `worktype_material_rel` (`worktype_id`, `material_id`) VALUES (2, 1);
INSERT INTO `worktype_material_rel` (`worktype_id`, `material_id`) VALUES (2, 2);

/*
Init mock works table
 */
INSERT INTO `works` VALUES (1, 'Work_ziro', 1, 1, 2, 3, 4, 4);
INSERT INTO `works` VALUES (2, 'work_one', 2, 1, 2, 3, 4, 4);
INSERT INTO `works` VALUES (3, 'work_two', 2, 1, 2, 3, 4, 4);
INSERT INTO `works` VALUES (4, 'work_tree', 3, 1, 2, 3, 4, 5);
INSERT INTO `works` VALUES (5, 'work_four', 3, 1, 2, 3, 4, 5);
INSERT INTO `works` VALUES (6, 'work_five', 3, 1, 2, 3, 4, 6);

/*
Init mock work_zone_rel table
 */
INSERT INTO `work_zone_rel` VALUES (1, 1, 1);
INSERT INTO `work_zone_rel` VALUES (2, 2, 1);
INSERT INTO `work_zone_rel` VALUES (3, 3, 2);
INSERT INTO `work_zone_rel` VALUES (4, 4, 4);
INSERT INTO `work_zone_rel` VALUES (5, 5, 5);
INSERT INTO `work_zone_rel` VALUES (6, 6, 6);

/*
Init mock adjustments table
 */
INSERT INTO `adjustments` VALUES (1, 23, 1, 1);
INSERT INTO `adjustments` VALUES (2, 23, 1, 2);
INSERT INTO `adjustments` VALUES (3, 23, 1, 3);
INSERT INTO `adjustments` VALUES (4, 23, 1, 4);
INSERT INTO `adjustments` VALUES (5, 23, 1, 5);
INSERT INTO `adjustments` VALUES (6, 23, 1, 6);

/*
Init mock covers table
 */
INSERT INTO `covers` VALUES (1, 12, '12', 'cover1', 1);
INSERT INTO `covers` VALUES (2, 12, '12', 'cover2', 2);
INSERT INTO `covers` VALUES (3, 12, '12', 'cover3', 3);
INSERT INTO `covers` VALUES (4, 12, '12', 'cover4', 4);
INSERT INTO `covers` VALUES (5, 12, '12', 'cover5', 5);
INSERT INTO `covers` VALUES (6, 12, '12', 'cover6', 6);

/*
Init mock work_groups table
 */
INSERT INTO `work_groups` VALUES (1, 'root_group', NULL);
INSERT INTO `work_groups` VALUES (2, 'group1_lvl_a', 1);
INSERT INTO `work_groups` VALUES (3, 'group2_lvl_a', 1);
INSERT INTO `work_groups` VALUES (4, 'group3_lvl_b', 2);
INSERT INTO `work_groups` VALUES (5, 'group4_lvl_b', 2);
INSERT INTO `work_groups` VALUES (6, 'group5_lvl_b', 3);