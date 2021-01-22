/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : ccfdb

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 22/01/2021 21:47:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author`  (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`author_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES (1, 'Feng Xue');
INSERT INTO `author` VALUES (2, 'Luis Gustavo Araujo Rodriguez');
INSERT INTO `author` VALUES (3, 'Daniel Mac{\\^{e}}do Batista');
INSERT INTO `author` VALUES (4, 'Zichen Guo');
INSERT INTO `author` VALUES (5, 'Jiawei Liu');
INSERT INTO `author` VALUES (6, 'Tieke He');
INSERT INTO `author` VALUES (7, 'Zhuoyang Li');
INSERT INTO `author` VALUES (8, 'Peitian Zhangzhu');
INSERT INTO `author` VALUES (9, 'Gang Fan');
INSERT INTO `author` VALUES (10, 'Chengpeng Wang');
INSERT INTO `author` VALUES (11, 'Rongxin Wu');
INSERT INTO `author` VALUES (12, 'Xiao Xiao');
INSERT INTO `author` VALUES (13, 'Qingkai Shi');
INSERT INTO `author` VALUES (14, 'Charles Zhang');
INSERT INTO `author` VALUES (15, 'Andrea Fioraldi');
INSERT INTO `author` VALUES (16, 'Daniele Cono D\'Elia');
INSERT INTO `author` VALUES (17, 'Emilio Coppa');
INSERT INTO `author` VALUES (18, 'Yun Lin');
INSERT INTO `author` VALUES (19, 'Jun Sun');
INSERT INTO `author` VALUES (20, 'Gordon Fraser');
INSERT INTO `author` VALUES (21, 'Ziheng Xiu');
INSERT INTO `author` VALUES (22, 'Ting Liu');
INSERT INTO `author` VALUES (23, 'Jin Song Dong');
INSERT INTO `author` VALUES (24, 'Asem Ghaleb');
INSERT INTO `author` VALUES (25, 'Karthik Pattabiraman');
INSERT INTO `author` VALUES (26, 'Jackson Vanover');
INSERT INTO `author` VALUES (27, 'Xuan Deng');
INSERT INTO `author` VALUES (28, 'Cindy Rubio{-}Gonz{\\\'{a}}lez');
INSERT INTO `author` VALUES (29, 'Zhibo Liu');
INSERT INTO `author` VALUES (30, 'Shuai Wang');
INSERT INTO `author` VALUES (31, 'Ali Ghanbari');
INSERT INTO `author` VALUES (32, 'Xiao He');
INSERT INTO `author` VALUES (33, 'Xingwei Wang');
INSERT INTO `author` VALUES (34, 'Jia Shi');
INSERT INTO `author` VALUES (35, 'Yi Liu');
INSERT INTO `author` VALUES (36, 'Chunrong Fang');
INSERT INTO `author` VALUES (37, 'Zixi Liu');
INSERT INTO `author` VALUES (38, 'Yangyang Shi');
INSERT INTO `author` VALUES (39, 'Jeff Huang');
INSERT INTO `author` VALUES (40, 'Qingkai Shi');
INSERT INTO `author` VALUES (41, 'Jo{\\~{a}}o Choma Neto');
INSERT INTO `author` VALUES (42, 'Chao Guo');
INSERT INTO `author` VALUES (43, 'Tieke He');
INSERT INTO `author` VALUES (44, 'Wei Yuan');
INSERT INTO `author` VALUES (45, 'Yue Guo');
INSERT INTO `author` VALUES (46, 'Rui Hao');
INSERT INTO `author` VALUES (47, 'Yang Zhang');
INSERT INTO `author` VALUES (48, 'Shuai Shao');
INSERT INTO `author` VALUES (49, 'Juan Zhai');
INSERT INTO `author` VALUES (50, 'Shiqing Ma');
INSERT INTO `author` VALUES (51, 'Kaiyuan Wang');
INSERT INTO `author` VALUES (52, 'Greg Tener');
INSERT INTO `author` VALUES (53, 'Vijay Gullapalli');
INSERT INTO `author` VALUES (54, 'Xin Huang');
INSERT INTO `author` VALUES (55, 'Ahmed Gad');
INSERT INTO `author` VALUES (56, 'Daniel Rall');
INSERT INTO `author` VALUES (57, 'George Fourtounis');
INSERT INTO `author` VALUES (58, 'Leonidas Triantafyllou');
INSERT INTO `author` VALUES (59, 'Yannis Smaragdakis');
INSERT INTO `author` VALUES (60, 'Yakun Zhang');
INSERT INTO `author` VALUES (61, 'Wensheng Dou');
INSERT INTO `author` VALUES (62, 'Jiaxin Zhu');
INSERT INTO `author` VALUES (63, 'Liang Xu');
INSERT INTO `author` VALUES (64, 'Zhiyong Zhou');
INSERT INTO `author` VALUES (65, 'Jun Wei');
INSERT INTO `author` VALUES (66, 'Dan Ye');
INSERT INTO `author` VALUES (67, 'Bo Yang');
INSERT INTO `author` VALUES (68, 'Muhui Jiang');
INSERT INTO `author` VALUES (69, 'Yajin Zhou');
INSERT INTO `author` VALUES (70, 'Xiapu Luo');
INSERT INTO `author` VALUES (71, 'Ruoyu Wang');
INSERT INTO `author` VALUES (72, 'Yang Liu');
INSERT INTO `author` VALUES (73, 'Kui Ren');
INSERT INTO `author` VALUES (74, 'Carl Hildebrandt');
INSERT INTO `author` VALUES (75, 'Sebastian G. Elbaum');
INSERT INTO `author` VALUES (76, 'Nicola Bezzo');
INSERT INTO `author` VALUES (77, 'Matthew B. Dwyer');
INSERT INTO `author` VALUES (78, 'Qianyang Peng');
INSERT INTO `author` VALUES (79, 'August Shi');
INSERT INTO `author` VALUES (80, 'Lingming Zhang');
INSERT INTO `author` VALUES (81, 'Yifei Xu');
INSERT INTO `author` VALUES (82, 'Zhengzi Xu');
INSERT INTO `author` VALUES (83, 'Bihuan Chen');
INSERT INTO `author` VALUES (84, 'Fu Song');
INSERT INTO `author` VALUES (85, 'Yang Liu');
INSERT INTO `author` VALUES (86, 'Ting Liu');
INSERT INTO `author` VALUES (87, 'George Thompson');
INSERT INTO `author` VALUES (88, 'Allison K. Sullivan');
INSERT INTO `author` VALUES (89, 'Muyang Liu');
INSERT INTO `author` VALUES (90, 'Ke Li');
INSERT INTO `author` VALUES (91, 'Tao Chen');
INSERT INTO `author` VALUES (92, 'Mohannad Alhanahnah');
INSERT INTO `author` VALUES (93, 'Clay Stevens');
INSERT INTO `author` VALUES (94, 'Hamid Bagheri');
INSERT INTO `author` VALUES (95, 'Patrice Godefroid');
INSERT INTO `author` VALUES (96, 'Daniel Lehmann');
INSERT INTO `author` VALUES (97, 'Marina Polishchuk');
INSERT INTO `author` VALUES (98, 'Hui Li');
INSERT INTO `author` VALUES (99, 'Dong Wang');
INSERT INTO `author` VALUES (100, 'Tianze Huang');
INSERT INTO `author` VALUES (101, 'Yu Gao');
INSERT INTO `author` VALUES (102, 'Wensheng Dou');
INSERT INTO `author` VALUES (103, 'Lijie Xu');
INSERT INTO `author` VALUES (104, 'Wei Wang');
INSERT INTO `author` VALUES (105, 'Jun Wei');
INSERT INTO `author` VALUES (106, 'Hua Zhong');
INSERT INTO `author` VALUES (107, 'Per Erik Strandberg');
INSERT INTO `author` VALUES (108, 'Thomas J. Ostrand');
INSERT INTO `author` VALUES (109, 'Elaine J. Weyuker');
INSERT INTO `author` VALUES (110, 'Wasif Afzal');
INSERT INTO `author` VALUES (111, 'Daniel Sundmark');
INSERT INTO `author` VALUES (112, 'Wentian Yan');
INSERT INTO `author` VALUES (113, 'Jianbo Gao');
INSERT INTO `author` VALUES (114, 'Zhenhao Wu');
INSERT INTO `author` VALUES (115, 'Yue Li');
INSERT INTO `author` VALUES (116, 'Zhi Guan');
INSERT INTO `author` VALUES (117, 'Qingshan Li');
INSERT INTO `author` VALUES (118, 'Zhong Chen');
INSERT INTO `author` VALUES (119, 'Ruixiang Qian');
INSERT INTO `author` VALUES (120, 'Yuan Zhao');
INSERT INTO `author` VALUES (121, 'Duo Men');
INSERT INTO `author` VALUES (122, 'Yang Feng');
INSERT INTO `author` VALUES (123, 'Qingkai Shi');
INSERT INTO `author` VALUES (124, 'Yong Huang');
INSERT INTO `author` VALUES (125, 'Zhenyu Chen');
INSERT INTO `author` VALUES (126, 'Pengyu Nie');
INSERT INTO `author` VALUES (127, 'Ahmet {\\c{C}}elik');
INSERT INTO `author` VALUES (128, 'Matthew Coley');
INSERT INTO `author` VALUES (129, 'Aleksandar Milicevic');
INSERT INTO `author` VALUES (130, 'Jonathan Bell');
INSERT INTO `author` VALUES (131, 'Milos Gligoric');
INSERT INTO `author` VALUES (132, 'Saikat Dutta');
INSERT INTO `author` VALUES (133, 'August Shi');
INSERT INTO `author` VALUES (134, 'Rutvik Choudhary');
INSERT INTO `author` VALUES (135, 'Zhekun Zhang');
INSERT INTO `author` VALUES (136, 'Aryaman Jain');
INSERT INTO `author` VALUES (137, 'Sasa Misailovic');
INSERT INTO `author` VALUES (138, 'Wing Lam');
INSERT INTO `author` VALUES (139, 'August Shi');
INSERT INTO `author` VALUES (140, 'Reed Oei');
INSERT INTO `author` VALUES (141, 'Sai Zhang');
INSERT INTO `author` VALUES (142, 'Michael D. Ernst');
INSERT INTO `author` VALUES (143, 'Tao Xie');
INSERT INTO `author` VALUES (144, 'Gustavo Grieco');
INSERT INTO `author` VALUES (145, 'Will Song');
INSERT INTO `author` VALUES (146, 'Artur Cygan');
INSERT INTO `author` VALUES (147, 'Josselin Feist');
INSERT INTO `author` VALUES (148, 'Alex Groce');
INSERT INTO `author` VALUES (149, 'Ismet Burak Kadron');
INSERT INTO `author` VALUES (150, 'Nicol{\\\'{a}}s Rosner');
INSERT INTO `author` VALUES (151, 'Tevfik Bultan');
INSERT INTO `author` VALUES (152, 'Michael Pradel');
INSERT INTO `author` VALUES (153, 'Vijayaraghavan Murali');
INSERT INTO `author` VALUES (154, 'Rebecca Qian');
INSERT INTO `author` VALUES (155, 'Mateusz Machalica');
INSERT INTO `author` VALUES (156, 'Erik Meijer');
INSERT INTO `author` VALUES (157, 'Satish Chandra');
INSERT INTO `author` VALUES (158, 'Oliviero Riganelli');
INSERT INTO `author` VALUES (159, 'Simone Paolo Mottadelli');
INSERT INTO `author` VALUES (160, 'Claudio Rota');
INSERT INTO `author` VALUES (161, 'Daniela Micucci');
INSERT INTO `author` VALUES (162, 'Leonardo Mariani');
INSERT INTO `author` VALUES (163, 'Arnab Sharma');
INSERT INTO `author` VALUES (164, 'Heike Wehrheim');
INSERT INTO `author` VALUES (165, 'Minxue Pan');
INSERT INTO `author` VALUES (166, 'An Huang');
INSERT INTO `author` VALUES (167, 'Guoxin Wang');
INSERT INTO `author` VALUES (168, 'Tian Zhang');
INSERT INTO `author` VALUES (169, 'Xuandong Li');
INSERT INTO `author` VALUES (170, 'Ezio Bartocci');
INSERT INTO `author` VALUES (171, 'Niveditha Manjunath');
INSERT INTO `author` VALUES (172, 'Leonardo Mariani');
INSERT INTO `author` VALUES (173, 'Cristinel Mateis');
INSERT INTO `author` VALUES (174, 'Dejan Nickovic');
INSERT INTO `author` VALUES (175, 'Fabrizio Pastore');
INSERT INTO `author` VALUES (176, 'Seokhyun Lee');
INSERT INTO `author` VALUES (177, 'Sooyoung Cha');
INSERT INTO `author` VALUES (178, 'Dain Lee');
INSERT INTO `author` VALUES (179, 'Hakjoo Oh');
INSERT INTO `author` VALUES (180, 'Saeid Tizpaz{-}Niari');
INSERT INTO `author` VALUES (181, 'Pavol Cern{\\\'{y}}');
INSERT INTO `author` VALUES (182, 'Ashutosh Trivedi');
INSERT INTO `author` VALUES (183, 'Frank Busse');
INSERT INTO `author` VALUES (184, 'Martin Nowack');
INSERT INTO `author` VALUES (185, 'Cristian Cadar');
INSERT INTO `author` VALUES (186, 'Yang Feng');
INSERT INTO `author` VALUES (187, 'Qingkai Shi');
INSERT INTO `author` VALUES (188, 'Xinyu Gao');
INSERT INTO `author` VALUES (189, 'Jun Wan');
INSERT INTO `author` VALUES (190, 'Chunrong Fang');
INSERT INTO `author` VALUES (191, 'Zhenyu Chen');
INSERT INTO `author` VALUES (192, 'Thibaud Lutellier');
INSERT INTO `author` VALUES (193, 'Hung Viet Pham');
INSERT INTO `author` VALUES (194, 'Lawrence Pang');
INSERT INTO `author` VALUES (195, 'Yitong Li');
INSERT INTO `author` VALUES (196, 'Moshi Wei');
INSERT INTO `author` VALUES (197, 'Lin Tan');
INSERT INTO `author` VALUES (198, 'Yiling Lou');
INSERT INTO `author` VALUES (199, 'Ali Ghanbari');
INSERT INTO `author` VALUES (200, 'Xia Li');
INSERT INTO `author` VALUES (201, 'Lingming Zhang');
INSERT INTO `author` VALUES (202, 'Haotian Zhang');
INSERT INTO `author` VALUES (203, 'Dan Hao');
INSERT INTO `author` VALUES (204, 'Lu Zhang');
INSERT INTO `author` VALUES (205, 'Hui Liu');
INSERT INTO `author` VALUES (206, 'Mingzhu Shen');
INSERT INTO `author` VALUES (207, 'Jiahao Jin');
INSERT INTO `author` VALUES (208, 'Yanjie Jiang');
INSERT INTO `author` VALUES (209, 'Raja Ben Abdessalem');
INSERT INTO `author` VALUES (210, 'Annibale Panichella');
INSERT INTO `author` VALUES (211, 'Shiva Nejati');
INSERT INTO `author` VALUES (212, 'Lionel C. Briand');
INSERT INTO `author` VALUES (213, 'Thomas Stifter');
INSERT INTO `author` VALUES (214, 'Xueliang Li');
INSERT INTO `author` VALUES (215, 'Yuming Yang');
INSERT INTO `author` VALUES (216, 'Yepang Liu');
INSERT INTO `author` VALUES (217, 'John P. Gallagher');
INSERT INTO `author` VALUES (218, 'Kaishun Wu');
INSERT INTO `author` VALUES (219, 'David Trabish');
INSERT INTO `author` VALUES (220, 'Noam Rinetzky');
INSERT INTO `author` VALUES (221, 'Yuqi Chen');
INSERT INTO `author` VALUES (222, 'Bohan Xuan');
INSERT INTO `author` VALUES (223, 'Christopher M. Poskitt');
INSERT INTO `author` VALUES (224, 'Jun Sun');
INSERT INTO `author` VALUES (225, 'Fan Zhang');
INSERT INTO `author` VALUES (226, 'Rahul Gopinath');
INSERT INTO `author` VALUES (227, 'Alexander Kampmann');
INSERT INTO `author` VALUES (228, 'Nikolas Havrikov');
INSERT INTO `author` VALUES (229, 'Ezekiel O. Soremekun');
INSERT INTO `author` VALUES (230, 'Andreas Zeller');
INSERT INTO `author` VALUES (231, 'Dominik Helm');
INSERT INTO `author` VALUES (232, 'Florian K{\\\"{u}}bler');
INSERT INTO `author` VALUES (233, 'Jan Thomas K{\\\"{o}}lzer');
INSERT INTO `author` VALUES (234, 'Philipp Haller');
INSERT INTO `author` VALUES (235, 'Michael Eichberg');
INSERT INTO `author` VALUES (236, 'Guido Salvaneschi');
INSERT INTO `author` VALUES (237, 'Mira Mezini');
INSERT INTO `author` VALUES (238, 'Bj{\\\"{o}}rn Mathis');
INSERT INTO `author` VALUES (239, 'Rahul Gopinath');
INSERT INTO `author` VALUES (240, 'Andreas Zeller');
INSERT INTO `author` VALUES (241, 'Peisen Yao');
INSERT INTO `author` VALUES (242, 'Qingkai Shi');
INSERT INTO `author` VALUES (243, 'Heqing Huang');
INSERT INTO `author` VALUES (244, 'Charles Zhang');

-- ----------------------------
-- Table structure for editor
-- ----------------------------
DROP TABLE IF EXISTS `editor`;
CREATE TABLE `editor`  (
  `editor_id` int(11) NOT NULL AUTO_INCREMENT,
  `editor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`editor_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of editor
-- ----------------------------
INSERT INTO `editor` VALUES (1, 'Sarfraz Khurshid');
INSERT INTO `editor` VALUES (2, 'Corina S. Pasareanu');

-- ----------------------------
-- Table structure for institution
-- ----------------------------
DROP TABLE IF EXISTS `institution`;
CREATE TABLE `institution`  (
  `institution_id` int(11) NOT NULL AUTO_INCREMENT,
  `institution` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`institution_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for keyword
-- ----------------------------
DROP TABLE IF EXISTS `keyword`;
CREATE TABLE `keyword`  (
  `keyword_id` int(11) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`keyword_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of keyword
-- ----------------------------
INSERT INTO `keyword` VALUES (1, 'Software testing');
INSERT INTO `keyword` VALUES (2, 'Mobile applications');
INSERT INTO `keyword` VALUES (3, 'Computer vision');
INSERT INTO `keyword` VALUES (4, 'Test automation');
INSERT INTO `keyword` VALUES (5, 'Testing');
INSERT INTO `keyword` VALUES (6, 'Internet of Things');
INSERT INTO `keyword` VALUES (7, 'Fuzzing');
INSERT INTO `keyword` VALUES (8, 'Security');
INSERT INTO `keyword` VALUES (9, 'MQTT');
INSERT INTO `keyword` VALUES (10, 'Test Augmentation');
INSERT INTO `keyword` VALUES (11, 'Judicial Documents');
INSERT INTO `keyword` VALUES (12, 'Machine Learning');
INSERT INTO `keyword` VALUES (13, 'dependency verification');
INSERT INTO `keyword` VALUES (14, 'build tools');
INSERT INTO `keyword` VALUES (15, 'build maintenance');
INSERT INTO `keyword` VALUES (16, 'binary testing');
INSERT INTO `keyword` VALUES (17, 'Fuzzing');
INSERT INTO `keyword` VALUES (18, 'structural mutations');
INSERT INTO `keyword` VALUES (19, 'chunk-based formats');
INSERT INTO `keyword` VALUES (20, 'testability');
INSERT INTO `keyword` VALUES (21, 'search-based');
INSERT INTO `keyword` VALUES (22, 'testing');
INSERT INTO `keyword` VALUES (23, 'program analysis');
INSERT INTO `keyword` VALUES (24, 'bug injection');
INSERT INTO `keyword` VALUES (25, 'Ethereum security');
INSERT INTO `keyword` VALUES (26, 'solidity code analysis');
INSERT INTO `keyword` VALUES (27, 'Ethereum');
INSERT INTO `keyword` VALUES (28, 'smart contracts security');
INSERT INTO `keyword` VALUES (29, 'smart contracts');
INSERT INTO `keyword` VALUES (30, 'fault injection');
INSERT INTO `keyword` VALUES (31, 'smart contracts dataset');
INSERT INTO `keyword` VALUES (32, 'smart contracts analysis');
INSERT INTO `keyword` VALUES (33, 'static analysis tools evaluation');
INSERT INTO `keyword` VALUES (34, 'floating point');
INSERT INTO `keyword` VALUES (35, 'software testing');
INSERT INTO `keyword` VALUES (36, 'differential testing');
INSERT INTO `keyword` VALUES (37, 'numerical libraries');
INSERT INTO `keyword` VALUES (38, 'Reverse Engineering');
INSERT INTO `keyword` VALUES (39, 'Decompiler');
INSERT INTO `keyword` VALUES (40, 'Software Testing');
INSERT INTO `keyword` VALUES (41, 'Test Case');
INSERT INTO `keyword` VALUES (42, 'Patch Prioritization');
INSERT INTO `keyword` VALUES (43, 'Object Similarity');
INSERT INTO `keyword` VALUES (44, 'Automatic Program Repair');
INSERT INTO `keyword` VALUES (45, 'High performance computing');
INSERT INTO `keyword` VALUES (46, 'Software testing');
INSERT INTO `keyword` VALUES (47, 'Experience');
INSERT INTO `keyword` VALUES (48, 'Numerical simulation');
INSERT INTO `keyword` VALUES (49, 'functional clone detection');
INSERT INTO `keyword` VALUES (50, 'Code clone detection');
INSERT INTO `keyword` VALUES (51, 'code representation');
INSERT INTO `keyword` VALUES (52, 'syntax and semantics fusion learning');
INSERT INTO `keyword` VALUES (53, 'Structural Testing');
INSERT INTO `keyword` VALUES (54, 'Software Testing');
INSERT INTO `keyword` VALUES (55, 'Search Based Software Testing');
INSERT INTO `keyword` VALUES (56, 'Infeasible Path Problem');
INSERT INTO `keyword` VALUES (57, 'Crowdsourced Requirements');
INSERT INTO `keyword` VALUES (58, 'Knowledge Graph');
INSERT INTO `keyword` VALUES (59, 'Android GUI Testing');
INSERT INTO `keyword` VALUES (60, 'Read-write lock');
INSERT INTO `keyword` VALUES (61, 'Refactoring');
INSERT INTO `keyword` VALUES (62, 'Fine-grained lock');
INSERT INTO `keyword` VALUES (63, 'Static analysis');
INSERT INTO `keyword` VALUES (64, 'Pushdown automaton');
INSERT INTO `keyword` VALUES (65, 'build scheduling service');
INSERT INTO `keyword` VALUES (66, 'Build service system');
INSERT INTO `keyword` VALUES (67, 'build system design');
INSERT INTO `keyword` VALUES (68, 'static analysis');
INSERT INTO `keyword` VALUES (69, 'native code');
INSERT INTO `keyword` VALUES (70, 'binary');
INSERT INTO `keyword` VALUES (71, 'Java');
INSERT INTO `keyword` VALUES (72, 'Spreadsheet');
INSERT INTO `keyword` VALUES (73, 'format');
INSERT INTO `keyword` VALUES (74, 'table clone');
INSERT INTO `keyword` VALUES (75, 'structure');
INSERT INTO `keyword` VALUES (76, 'Disassembly Tools');
INSERT INTO `keyword` VALUES (77, 'Empirical Study');
INSERT INTO `keyword` VALUES (78, 'ARM Architecture');
INSERT INTO `keyword` VALUES (79, 'Kinematic and Dynamic Models');
INSERT INTO `keyword` VALUES (80, 'Test Generation');
INSERT INTO `keyword` VALUES (81, 'Stress Testing');
INSERT INTO `keyword` VALUES (82, 'Robotics');
INSERT INTO `keyword` VALUES (83, 'continuous integration');
INSERT INTO `keyword` VALUES (84, 'Test-case prioritization');
INSERT INTO `keyword` VALUES (85, 'information retrieval');
INSERT INTO `keyword` VALUES (86, 'Vulnerability Matching');
INSERT INTO `keyword` VALUES (87, 'Binary Analysis');
INSERT INTO `keyword` VALUES (88, 'Patch Presence Identification');
INSERT INTO `keyword` VALUES (89, 'Security');
INSERT INTO `keyword` VALUES (90, 'Fault localization');
INSERT INTO `keyword` VALUES (91, 'Prolog');
INSERT INTO `keyword` VALUES (92, 'Declarative programming');
INSERT INTO `keyword` VALUES (93, 'test case generation');
INSERT INTO `keyword` VALUES (94, 'natural language processing');
INSERT INTO `keyword` VALUES (95, 'deep learning');
INSERT INTO `keyword` VALUES (96, 'SQL injection');
INSERT INTO `keyword` VALUES (97, 'Web security');
INSERT INTO `keyword` VALUES (98, 'Formal Verification');
INSERT INTO `keyword` VALUES (99, 'IoT Safety');
INSERT INTO `keyword` VALUES (100, 'Interaction Threats');
INSERT INTO `keyword` VALUES (101, 'specification regression');
INSERT INTO `keyword` VALUES (102, 'REST APIs');
INSERT INTO `keyword` VALUES (103, 'differential regression testing');
INSERT INTO `keyword` VALUES (104, 'service version matrix');
INSERT INTO `keyword` VALUES (105, 'service regression');
INSERT INTO `keyword` VALUES (106, 'bug detection');
INSERT INTO `keyword` VALUES (107, 'performance');
INSERT INTO `keyword` VALUES (108, 'Spark');
INSERT INTO `keyword` VALUES (109, 'cache');
INSERT INTO `keyword` VALUES (110, 'non-deterministic tests');
INSERT INTO `keyword` VALUES (111, 'flaky tests');
INSERT INTO `keyword` VALUES (112, 'system level test automation');
INSERT INTO `keyword` VALUES (113, 'intermittently failing tests');
INSERT INTO `keyword` VALUES (114, 'embedded systems');
INSERT INTO `keyword` VALUES (115, 'Reverse Engineering');
INSERT INTO `keyword` VALUES (116, 'Ethereum');
INSERT INTO `keyword` VALUES (117, 'Program Analysis');
INSERT INTO `keyword` VALUES (118, 'Smart Contract');
INSERT INTO `keyword` VALUES (119, 'Blockchain');
INSERT INTO `keyword` VALUES (120, 'Static analysis');
INSERT INTO `keyword` VALUES (121, 'Test guid');
INSERT INTO `keyword` VALUES (122, 'Program Slice');
INSERT INTO `keyword` VALUES (123, 'Test recommendation');
INSERT INTO `keyword` VALUES (124, 'test isolation');
INSERT INTO `keyword` VALUES (125, 'Build system');
INSERT INTO `keyword` VALUES (126, 'Maven');
INSERT INTO `keyword` VALUES (127, 'Machine Learning');
INSERT INTO `keyword` VALUES (128, 'Flaky tests');
INSERT INTO `keyword` VALUES (129, 'Non-Determinism');
INSERT INTO `keyword` VALUES (130, 'Probabilistic Programming');
INSERT INTO `keyword` VALUES (131, 'Randomness');
INSERT INTO `keyword` VALUES (132, 'regression testing');
INSERT INTO `keyword` VALUES (133, 'flaky test');
INSERT INTO `keyword` VALUES (134, 'order-dependent test');
INSERT INTO `keyword` VALUES (135, 'fuzzing');
INSERT INTO `keyword` VALUES (136, 'test generation');
INSERT INTO `keyword` VALUES (137, 'smart contracts');
INSERT INTO `keyword` VALUES (138, 'network traffic analysis');
INSERT INTO `keyword` VALUES (139, 'input generation');
INSERT INTO `keyword` VALUES (140, 'dynamic program analysis');
INSERT INTO `keyword` VALUES (141, 'Side-channel analysis');
INSERT INTO `keyword` VALUES (142, 'Bug localization');
INSERT INTO `keyword` VALUES (143, 'software crashes');
INSERT INTO `keyword` VALUES (144, 'machine learning');
INSERT INTO `keyword` VALUES (145, 'validation');
INSERT INTO `keyword` VALUES (146, 'Android');
INSERT INTO `keyword` VALUES (147, 'mobile apps');
INSERT INTO `keyword` VALUES (148, 'test case generation');
INSERT INTO `keyword` VALUES (149, 'data loss');
INSERT INTO `keyword` VALUES (150, 'Machine Learning Testing');
INSERT INTO `keyword` VALUES (151, 'Monotonicity');
INSERT INTO `keyword` VALUES (152, 'Decision Tree');
INSERT INTO `keyword` VALUES (153, 'functional scenario division');
INSERT INTO `keyword` VALUES (154, 'Android app testing');
INSERT INTO `keyword` VALUES (155, 'reinforcement learning');
INSERT INTO `keyword` VALUES (156, 'Cyber-Physical Systems');
INSERT INTO `keyword` VALUES (157, 'Debugging');
INSERT INTO `keyword` VALUES (158, 'Model-based Development');
INSERT INTO `keyword` VALUES (159, 'Specification Mining');
INSERT INTO `keyword` VALUES (160, 'Testing');
INSERT INTO `keyword` VALUES (161, 'Failure Explanation');
INSERT INTO `keyword` VALUES (162, 'Deep neural networks');
INSERT INTO `keyword` VALUES (163, 'Online learning');
INSERT INTO `keyword` VALUES (164, 'White-box testing');
INSERT INTO `keyword` VALUES (165, 'Debugging');
INSERT INTO `keyword` VALUES (166, 'Testing');
INSERT INTO `keyword` VALUES (167, 'ML Libraries');
INSERT INTO `keyword` VALUES (168, 'Differential Performance Bugs');
INSERT INTO `keyword` VALUES (169, 'symbolic execution');
INSERT INTO `keyword` VALUES (170, 'KLEE');
INSERT INTO `keyword` VALUES (171, 'memoization');
INSERT INTO `keyword` VALUES (172, 'Deep Learning Testing');
INSERT INTO `keyword` VALUES (173, 'Deep Learning');
INSERT INTO `keyword` VALUES (174, 'Test Case Prioritization');
INSERT INTO `keyword` VALUES (175, 'Automated program repair');
INSERT INTO `keyword` VALUES (176, 'Deep Learning');
INSERT INTO `keyword` VALUES (177, 'AI and Software Engineering');
INSERT INTO `keyword` VALUES (178, 'Neural Machine Translation');
INSERT INTO `keyword` VALUES (179, 'Automated Program Repair');
INSERT INTO `keyword` VALUES (180, 'Unified Debugging');
INSERT INTO `keyword` VALUES (181, 'Fault Localization');
INSERT INTO `keyword` VALUES (182, 'Bug report');
INSERT INTO `keyword` VALUES (183, 'Classification');
INSERT INTO `keyword` VALUES (184, 'Test Case Generation');
INSERT INTO `keyword` VALUES (185, 'Mobile Testing');
INSERT INTO `keyword` VALUES (186, 'Search-based Software Testing');
INSERT INTO `keyword` VALUES (187, 'Feature Interaction Problem');
INSERT INTO `keyword` VALUES (188, 'Automated Software Repair');
INSERT INTO `keyword` VALUES (189, 'Automated Driving Systems');
INSERT INTO `keyword` VALUES (190, 'Mobile Applications');
INSERT INTO `keyword` VALUES (191, 'Energy Issues');
INSERT INTO `keyword` VALUES (192, 'Energy Bugs');
INSERT INTO `keyword` VALUES (193, 'Android');
INSERT INTO `keyword` VALUES (194, 'Symbolic execution');
INSERT INTO `keyword` VALUES (195, 'Addressing model');
INSERT INTO `keyword` VALUES (196, 'Memory partitioning');
INSERT INTO `keyword` VALUES (197, 'Cyber-physical systems');
INSERT INTO `keyword` VALUES (198, 'fuzzing');
INSERT INTO `keyword` VALUES (199, 'testing defence mechanisms');
INSERT INTO `keyword` VALUES (200, 'benchmark generation');
INSERT INTO `keyword` VALUES (201, 'active learning');
INSERT INTO `keyword` VALUES (202, 'error diagnosis');
INSERT INTO `keyword` VALUES (203, 'failure-inducing inputs');
INSERT INTO `keyword` VALUES (204, 'debugging');
INSERT INTO `keyword` VALUES (205, 'grammars');
INSERT INTO `keyword` VALUES (206, 'concurrency');
INSERT INTO `keyword` VALUES (207, 'parallelization');
INSERT INTO `keyword` VALUES (208, 'static analysis');
INSERT INTO `keyword` VALUES (209, 'fuzzing');
INSERT INTO `keyword` VALUES (210, 'test input generation');
INSERT INTO `keyword` VALUES (211, 'parser');
INSERT INTO `keyword` VALUES (212, 'program analysis');
INSERT INTO `keyword` VALUES (213, 'SAT solving');
INSERT INTO `keyword` VALUES (214, 'Satisfiability modulo theory');

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting`  (
  `meeting_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `publisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `year` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `doi` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isbn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bib_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bib_source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`meeting_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of meeting
-- ----------------------------
INSERT INTO `meeting` VALUES (1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '{ACM}', '2020', 'https://doi.org/10.1145/3395363', '10.1145/3395363', '978-1-4503-8008-9', 'Wed, 15 Jul 2020 15:59:31 +0200', 'https://dblp.org/rec/conf/issta/2020.bib', 'dblp computer science bibliography, https://dblp.org');

-- ----------------------------
-- Table structure for meeting_editor_relation
-- ----------------------------
DROP TABLE IF EXISTS `meeting_editor_relation`;
CREATE TABLE `meeting_editor_relation`  (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `meeting_id` int(11) NOT NULL,
  `editor_id` int(11) NOT NULL,
  PRIMARY KEY (`relation_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of meeting_editor_relation
-- ----------------------------
INSERT INTO `meeting_editor_relation` VALUES (1, 1, 1);
INSERT INTO `meeting_editor_relation` VALUES (2, 1, 2);

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `paper_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `abstract` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `doi` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `citation` int(11) NULL DEFAULT NULL,
  `book_title` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pages` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `publisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `year` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bib_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bib_source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`paper_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES (1, 'Automated mobile apps testing from visual perspective', 'The current implementation of automated mobile apps testing generally relies on internal program information, such as reading code or GUI layout files, capturing event streams. This paper proposes an approach of automated mobile apps testing from a completely visual perspective. It uses computer vision technology to enable computer to judge the internal functions from the external GUI information of mobile apps as we humans do and generates test strategy for execution, which improves the interactivity, flexibility, and authenticity of testing. We believe that this vision-based testing approach will further help alleviate the contradiction between the current huge test requirements of mobile apps and the relatively lack of testers.', '10.1145/3395363.3402644', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '577--581', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3402644', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/Xue20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (2, 'Program-aware fuzzing for {MQTT} applications', 'Over the last few years, MQTT applications have been widely exposed to vulnerabilities because of their weak protocol implementations. For our preliminary research, we conducted background studies to: (1) determine the main cause of vulnerabilities in MQTT applications; and (2) analyze existing MQTT-based testing frameworks. Our preliminary results confirm that MQTT is most susceptible to malformed packets, and its existing testing frameworks are based on blackbox fuzzing, meaning vulnerabilities are difficult and time-consuming to find. Thus, the aim of my research is to study and develop effective fuzzing strategies for the MQTT protocol, thereby contributing to the development of more robust MQTT applications in IoT and Smart Cities.', '10.1145/3395363.3402645', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '582--586', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3402645', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/RodriguezB20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (3, 'TauJud: test augmentation of machine learning in judicial documents', 'The booming of big data makes the adoption of machine learning ubiquitous in the legal field. As we all know, a large amount of test data can better reflect the performance of the model, so the test data must be naturally expanded. In order to solve the high cost problem of labeling data in natural language processing, people in the industry have improved the performance of text classification tasks through simple data amplification techniques. However, the data amplification requirements in the judgment documents are interpretable and logical, as observed from CAIL2018 test data with over 200,000 judicial documents. Therefore, we have designed a test augmentation tool called TauJud specifically for generating more effective test data with uniform distribution over time and location for model evaluation and save time in marking data. The demo can be found at https://github.com/governormars/TauJud.', '10.1145/3395363.3404364', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '549--552', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3404364', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/GuoLHLZ20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (4, 'Escaping dependency hell: finding build dependency errors with the unified dependency graph', 'Modern software projects rely on build systems and build scripts to assemble executable artifacts correctly and efficiently. However, developing build scripts is error-prone. Dependency-related errors in build scripts, mainly including missing dependencies and redundant dependencies, are common in various kinds of software projects. These errors lead to build failures, incorrect build results or poor performance in incremental or parallel builds. To detect such errors, various techniques are proposed and suffer from low efficiency and high false positive problems, due to the deficiency of the underlying dependency graphs. In this work, we design a new dependency graph, the unified dependency graph (UDG), which leverages both static and dynamic information to uniformly encode the declared and actual dependencies between build targets and files. The construction of UDG facilitates the efficient and precise detection of dependency errors via simple graph traversals. We implement the proposed approach as a tool, VeriBuild, and evaluate it on forty-two well-maintained open-source projects. The experimental results show that, without losing precision, VeriBuild incurs 58.2% less overhead than the state-of-the-art approach. By the time of writing, 398 detected dependency issues have been confirmed by the developers.', '10.1145/3395363.3397388', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '463--474', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397388', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/FanWW0SZ20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (5, '{WEIZZ:} automatic grey-box fuzzing for structured binary formats', 'Fuzzing technologies have evolved at a fast pace in recent years, revealing bugs in programs with ever increasing depth and speed. Applications working with complex formats are however more difficult to take on, as inputs need to meet certain format-specific characteristics to get through the initial parsing stage and reach deeper behaviors of the program. \n Unlike prior proposals based on manually written format specifications, we propose a technique to automatically generate and mutate inputs for unknown chunk-based binary formats. We identify dependencies between input bytes and comparison instructions, and use them to assign tags that characterize the processing logic of the program. Tags become the building block for structure-aware mutations involving chunks and fields of the input. \n Our technique can perform comparably to structure-aware fuzzing proposals that require human assistance. Our prototype implementation WEIZZ revealed 16 unknown bugs in widely used programs.', '10.1145/3395363.3397372', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '1--13', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397372', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/FioraldiDC20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (6, 'Recovering fitness gradients for interprocedural Boolean flags in search-based testing', 'In Search-based Software Testing (SBST), test generation is guided by fitness functions that estimate how close a test case is to reach an uncovered test goal (e.g., branch). A popular fitness function estimates how close conditional statements are to evaluating to true or false, i.e., the branch distance. However, when conditions read Boolean variables (e.g., if(x && y)), the branch distance provides no gradient for the search, since a Boolean can either be true or false. This flag problem can be addressed by transforming individual procedures such that Boolean flags are replaced with numeric comparisons that provide better guidance for the search. Unfortunately, defining a semantics-preserving transformation that is applicable in an interprocedural case, where Boolean flags are passed around as parameters and return values, is a daunting task. Thus, it is not yet supported by modern test generators. \nThis work is based on the insight that fitness gradients can be recovered by using runtime information: Given an uncovered interprocedural flag branch, our approach (1) calculates context-sensitive branch distance for all control flows potentially returning the required flag in the called method, and (2) recursively aggregates these distances into a continuous value. We implemented our approach on top of the EvoSuite framework for Java, and empirically compared it with state-of-the-art testability transformations on non-trivial methods suffering from interprocedural flag problems, sampled from open source Java projects. Our experiment demonstrates that our approach achieves higher coverage on the subject methods with statistical significance and acceptable runtime overheads.', '10.1145/3395363.3397358', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '440--451', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397358', 'Mon, 23 Nov 2020 12:33:06 +0100', 'https://dblp.org/rec/conf/issta/00010FXLD20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (7, 'How effective are smart contract analysis tools? evaluating smart contract static analysis tools using bug injection', 'Security attacks targeting smart contracts have been on the rise, which have led to financial loss and erosion of trust. Therefore, it is important to enable developers to discover security vulnerabilities in smart contracts before deployment. A number of static analysis tools have been developed for finding security bugs in smart contracts. However, despite the numerous bug-finding tools, there is no systematic approach to evaluate the proposed tools and gauge their effectiveness. This paper proposes SolidiFI, an automated and systematic approach for evaluating smart contracts’ static analysis tools. SolidiFI is based on injecting bugs (i.e., code defects) into all potential locations in a smart contract to introduce targeted security vulnerabilities. SolidiFI then checks the generated buggy contract using the static analysis tools, and identifies the bugs that the tools are unable to detect (false-negatives) along with identifying the bugs reported as false-positives. SolidiFI is used to evaluate six widely-used static analysis tools, namely, Oyente, Securify, Mythril, SmartCheck, Manticore and Slither, using a set of 50 contracts injected by 9369 distinct bugs. It finds several instances of bugs that are not detected by the evaluated tools despite their claims of being able to detect such bugs, and all the tools report many false positives.', '10.1145/3395363.3397385', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '415--427', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397385', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/GhalebP20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (8, 'Discovering discrepancies in numerical libraries', 'Numerical libraries constitute the building blocks for software applications that perform numerical calculations. Thus, it is paramount that such libraries provide accurate and consistent results. To that end, this paper addresses the problem of finding discrepancies between synonymous functions in different numerical libraries as a means of identifying incorrect behavior. Our approach automatically finds such synonymous functions, synthesizes testing drivers, and executes differential tests to discover meaningful discrepancies across numerical libraries. We implement our approach in a tool named FPDiff, and provide an evaluation on four popular numerical libraries: GNU Scientific Library (GSL), SciPy, mpmath, and jmat. FPDiff finds a total of 126 equivalence classes with a 95.8% precision and 79% recall, and discovers 655 instances in which an input produces a set of disagreeing outputs between function synonyms, 150 of which we found to represent 125 unique bugs. We have reported all bugs to library maintainers; so far, 30 bugs have been fixed, 9 have been found to be previously known, and 25 more have been acknowledged by developers.', '10.1145/3395363.3397380', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '488--501', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397380', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/VanoverDR20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (9, 'How far we have come: testing decompilation correctness of {C} decompilers', 'A C decompiler converts an executable (the output from a C compiler) into source code. The recovered C source code, once recompiled, will produce an executable with the same functionality as the original executable. With over twenty years of development, C decompilers have been widely used in production to support reverse engineering applications, including legacy software migration, security retrofitting, software comprehension, and to act as the first step in launching adversarial software exploitations. As the paramount component and the trust base in numerous cybersecurity tasks, C decompilers have enabled the analysis of malware, ransomware, and promoted cybersecurity professionals’ understanding of vulnerabilities in real-world systems. \n In contrast to this flourishing market, our observation is that in academia, outputs of C decompilers (i.e., recovered C source code) are still not extensively used. Instead, the intermediate representations are often more desired for usage when developing applications such as binary security retrofitting. We acknowledge that such conservative approaches in academia are a result of widespread and pessimistic views on the decompilation correctness. However, in conventional software engineering and security research, how much of a problem is, for instance, reusing a piece of simple legacy code by taking the output of modern C decompilers? \n In this work, we test decompilation correctness to present an up-to-date understanding regarding modern C decompilers. We detected a total of 1,423 inputs that can trigger decompilation errors from four popular decompilers, and with extensive manual effort, we identified 13 bugs in two open-source decompilers. Our findings show that the overly pessimistic view of decompilation correctness leads researchers to underestimate the potential of modern decompilers; the state-of-the-art decompilers certainly care about the functional correctness, and they are making promising progress. However, some tasks that have been studied for years in academia, such as type inference and optimization, still impede C decompilers from generating quality outputs more than is reflected in the literature. These issues rarely receive enough attention and can lead to great confusion that misleads users.', '10.1145/3395363.3397370', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '475--487', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397370', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/LiuW20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (10, 'ObjSim: lightweight automatic patch prioritization via object similarity', 'In the context of test case based automatic program repair (APR), patches that pass all the test cases but fail to fix the bug are called overfitted patches. Currently, patches generated by APR tools get inspected manually by the users to find and adopt genuine fixes. Being a laborious activity hindering widespread adoption of APR, automatic identification of overfitted patches has lately been the topic of active research. This paper presents engineering details of ObjSim: a fully automatic, lightweight similarity-based patch prioritization tool for JVM-based languages. The tool works by comparing the system state at the exit point(s) of patched method before and after patching and prioritizing patches that result in state that is more similar to that of original, unpatched version on passing tests while less similar on failing ones. Our experiments with patches generated by the recent APR tool PraPR for fixable bugs from Defects4J v1.4.0 show that ObjSim prioritizes 16.67% more genuine fixes in top-1 place. A demo video of the tool is located at https://bit.ly/2K8gnYV.', '10.1145/3395363.3404362', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '541--544', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3404362', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/Ghanbari20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (11, 'Testing high performance numerical simulation programs: experience, lessons learned, and open issues', 'High performance numerical simulation programs are widely used to simulate actual physical processes on high performance computers for the analysis of various physical and engineering problems. They are usually regarded as non-testable due to their high complexity. This paper reports our real experience and lessons learned from testing five simulation programs that will be used to design and analyze nuclear power plants. We applied five testing approaches and found 33 bugs. We found that property-based testing and metamorphic testing are two effective methods. Nevertheless, we suffered from the lack of domain knowledge, the high test costs, the shortage of test cases, severe oracle issues, and inadequate automation support. Consequently, the five programs are not exhaustively tested from the perspective of software testing, and many existing software testing techniques and tools are not fully applicable due to scalability and portability issues. We need more collaboration and communication with other communities to promote the research and application of software testing techniques.', '10.1145/3395363.3397382', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '502--515', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397382', 'Wed, 22 Jul 2020 16:06:01 +0200', 'https://dblp.org/rec/conf/issta/HeWSL20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (12, 'Functional code clone detection with syntax and semantics fusion learning', 'Clone detection of source code is among the most fundamental software engineering techniques. Despite intensive research in the past decade, existing techniques are still unsatisfactory in detecting \"functional\" code clones. In particular, existing techniques cannot efficiently extract syntax and semantics information from source code. In this paper, we propose a novel joint code representation that applies fusion embedding techniques to learn hidden syntactic and semantic features of source codes. Besides, we introduce a new granularity for functional code clone detection. Our approach regards the connected methods with caller-callee relationships as a functionality and the method without any caller-callee relationship with other methods represents a single functionality. Then we train a supervised deep learning model to detect functional code clones. We conduct evaluations on a large dataset of C++ programs and the experimental results show that fusion learning can significantly outperform the state-of-the-art techniques in detecting functional code clones.', '10.1145/3395363.3397362', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '516--527', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397362', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/FangLS0S20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (13, 'Automatic support for the identification of infeasible testing requirements', 'Software testing activity is imperative to improve software quality. However, finding a set of test cases satisfies a given test criterion, is not a trivial task because the overall input domain is very large, and different test sets can be derived, with different effectiveness. In the context of structural testing, the non-executability is a feature present in most programs, increasing cost and effort of testing activity. When concurrent programs are tested, new challenges arise, mainly related to the non-determinism. Non-determinism can result in different possible test outputs for the same test input, which makes the problem of non-executability more complex, requiring treatment. In this sense, our project intends to define an approach to support automatic identification of infeasible testing requirements. Hence, this proposal aims to identify properties which cause infeasible testing requirements and automate their application. Due to complexity of the problem, we will apply search-based algorithms in the automation of concurrent and sequential programs treatment.', '10.1145/3395363.3402646', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '587--591', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3402646', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/Neto20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (14, 'Crowdsourced requirements generation for automatic testing via knowledge graph', 'Crowdsourced testing provides an effective way to deal with the problem of Android system fragmentation, as well as the application scenario diversity faced by Android testing. The generation of test requirements is a significant part of crowdsourced testing. However, manually generating crowdsourced testing requirements is tedious, which requires the issuers to have the domain knowledge of the Android application under test. To solve these problems, we have developed a tool named KARA, short for Knowledge Graph Aided Crowdsourced Requirements Generation for Android Testing. KARA first analyzes the result of automatic testing on the Android application, through which the operation sequences can be obtained. Then, the knowledge graph of the target application is constructed in a manner of pay-as-you-go. Finally, KARA utilizes knowledge graph and the automatic testing result to generate crowdsourced testing requirements with domain knowledge. Experiments prove that the test requirements generated by KARA are well understandable, and KARA can improve the quality of crowdsourced testing. The demo video can be found at https://youtu.be/kE-dOiekWWM.', '10.1145/3395363.3404363', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '545--548', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3404363', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/GuoHYGH20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (15, 'FineLock: automatically refactoring coarse-grained locks into fine-grained locks', 'Lock is a frequently-used synchronization mechanism to enforce exclusive access to a shared resource. However, lock-based concurrent programs are susceptible to lock contention, which leads to low performance and poor scalability. Furthermore, inappropriate granularity of a lock makes lock contention even worse. Compared to coarse-grained lock, fine-grained lock can mitigate lock contention but difficult to use. Converting coarse-grained lock into fine-grained lock manually is not only error-prone and tedious, but also requires a lot of expertise. In this paper, we propose to leverage program analysis techniques and pushdown automaton to automatically covert coarse-grained locks into fine-grained locks to reduce lock contention. We developed a prototype FineLock and evaluates it on 5 projects. The evaluation results demonstrate FineLock can refactor 1,546 locks in an average of 27.6 seconds, including converting 129 coarse-grained locks into fine-grained locks and 1,417 coarse-grained locks into read/write locks. By automatically providing potential refactoring recommendations, our tool saves a lot of efforts for developers.', '10.1145/3395363.3404368', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '565--568', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3404368', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/ZhangSZM20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (16, 'Scalable build service system with smart scheduling service', 'Build automation is critical for developers to check if their code compiles, passes all tests and is safe to deploy to the server. Many companies adopt Continuous Integration (CI) services to make sure that the code changes from multiple developers can be safely merged at the head of the project. Internally, CI triggers builds to make sure that the new code change compiles and passes the tests. For any large company which has a monolithic code repository and thousands of developers, it is hard to make sure that all code changes are safe to submit in a timely manner. The reason is that each code change may involve multiple builds, and the company needs to run millions of builds every day to guarantee developers’ productivity. \n Google is one of those large companies that need a scalable build service to support developers’ work. More than 100,000 code changes are submitted to our repository on average each day, including changes from either human users or automated tools. More than 15 million builds are executed on average each day. In this paper, we first describe an overview of our scalable build service architecture. Then, we discuss more details about how we make build scheduling decisions. Finally, we discuss some experience in the scalability of the build service system and the performance of the build scheduling service.', '10.1145/3395363.3397371', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '452--462', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397371', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/WangTGHGR20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (17, 'Identifying Java calls in native code via binary scanning', 'Current Java static analyzers, operating either on the source or bytecode level, exhibit unsoundness for programs that contain native code. We show that the Java Native Interface (JNI) specification, which is used by Java programs to interoperate with Java code, is principled enough to permit static reasoning about the effects of native code on program execution when it comes to call-backs. Our approach consists of disassembling native binaries, recovering static symbol information that corresponds to Java method signatures, and producing a model for statically exercising these native call-backs with appropriate mock objects. The approach manages to recover virtually all Java calls in native code, for both Android and Java desktop applications—(a) achieving 100% native-to-application call-graph recall on large Android applications (Chrome, Instagram) and (b) capturing the full native call-back behavior of the XCorpus suite programs.', '10.1145/3395363.3397368', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '388--400', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397368', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/FourtounisTS20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (18, 'Learning to detect table clones in spreadsheets', 'In order to speed up spreadsheet development productivity, end users can create a spreadsheet table by copying and modifying an existing one. These two tables share the similar computational semantics, and form a table clone. End users may modify the tables in a table clone, e.g., adding new rows and deleting columns, thus introducing structure changes into the table clone. Our empirical study on real-world spreadsheets shows that about 58.5% of table clones involve structure changes. However, existing table clone detection approaches in spreadsheets can only detect table clones with the same structures. Therefore, many table clones with structure changes cannot be detected. \nWe observe that, although the tables in a table clone may be modified, they usually share the similar structures and formats, e.g., headers, formulas and background colors. Based on this observation, we propose \n (\nearning to detect \nable \nlones), to automatically detect table clones with or without structure changes. LTC utilizes the structure and format information from labeled table clones and non table clones to train a binary classifier. LTC first identifies tables in spreadsheets, and then uses the trained binary classifier to judge whether every two tables can form a table clone. Our experiments on real-world spreadsheets from the EUSES and Enron corpora show that, LTC can achieve a precision of 97.8% and recall of 92.1% in table clone detection, significantly outperforming the state-of-the-art technique (a precision of 37.5% and recall of 11.1%).', '10.1145/3395363.3397384', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '528--540', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397384', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/ZhangDZXZWYY20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (19, 'An empirical study on {ARM} disassembly tools', 'With the increasing popularity of embedded devices, ARM is becoming the dominant architecture for them. In the meanwhile, there is a pressing need to perform security assessments for these devices. Due to different types of peripherals, it is challenging to dynamically run the firmware of these devices in an emulated environment. Therefore, the static analysis is still commonly used. Existing work usually leverages off-the-shelf tools to disassemble stripped ARM binaries and (implicitly) assume that reliable disassembling binaries and function recognition are solved problems. However, whether this assumption really holds is unknown. \nIn this paper, we conduct the first comprehensive study on ARM disassembly tools. Specifically, we build 1,896 ARM binaries (including 248 obfuscated ones) with different compilers, compiling options, and obfuscation methods. We then evaluate them using eight state-of-the-art ARM disassembly tools (including both commercial and noncommercial ones) on their capabilities to locate instructions and function boundaries. These two are fundamental ones, which are leveraged to build other primitives. Our work reveals some observations that have not been systematically summarized and/or confirmed. For instance, we find that the existence of both ARM and Thumb instruction sets, and the reuse of the BL instruction for both function calls and branches bring serious challenges to disassembly tools. Our evaluation sheds light on the limitations of state-of-the-art disassembly tools and points out potential directions for improvement. To engage the community, we release the data set, and the related scripts at https://github.com/valour01/arm_disasssembler_study.', '10.1145/3395363.3397377', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '401--414', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397377', 'Thu, 17 Dec 2020 16:29:24 +0100', 'https://dblp.org/rec/conf/issta/JiangZLWL020.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (20, 'Feasible and stressful trajectory generation for mobile robots', 'While executing nominal tests on mobile robots is required for their validation, such tests may overlook faults that arise under trajectories that accentuate certain aspects of the robot\'s behavior. Uncovering such stressful trajectories is challenging as the input space for these systems, as they move, is extremely large, and the relation between a planned trajectory and its potential to induce stress can be subtle. To address this challenge we propose a framework that 1) integrates kinematic and dynamic physical models of the robot into the automated trajectory generation in order to generate valid trajectories, and 2) incorporates a parameterizable scoring model to efficiently generate physically valid yet stressful trajectories for a broad range of mobile robots. We evaluate our approach on four variants of a state-of-the-art quadrotor in a racing simulator. We find that, for non-trivial length trajectories, the incorporation of the kinematic and dynamic model is crucial to generate any valid trajectory, and that the approach with the best hand-crafted scoring model and with a trained scoring model can cause on average a 55.9% and 41.3% more stress than a random selection among valid trajectories. A follow-up study shows that the approach was able to induce similar stress on a deployed commercial quadrotor, with trajectories that deviated up to 6m from the intended ones.', '10.1145/3395363.3397387', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '349--362', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397387', 'Tue, 29 Dec 2020 18:31:45 +0100', 'https://dblp.org/rec/conf/issta/HildebrandtEBD20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (21, 'Empirically revisiting and enhancing IR-based test-case prioritization', 'Test-case prioritization (TCP) aims to detect regression bugs faster via reordering the tests run. While TCP has been studied for over 20 years, it was almost always evaluated using seeded faults/mutants as opposed to using real test failures. In this work, we study the recent change-aware information retrieval (IR) technique for TCP. Prior work has shown it performing better than traditional coverage-based TCP techniques, but it was only evaluated on a small-scale dataset with a cost-unaware metric based on seeded faults/mutants. We extend the prior work by conducting a much larger and more realistic evaluation as well as proposing enhancements that substantially improve the performance. In particular, we evaluate the original technique on a large-scale, real-world software-evolution dataset with real failures using both cost-aware and cost-unaware metrics under various configurations. Also, we design and evaluate hybrid techniques combining the IR features, historical test execution time, and test failure frequencies. Our results show that the change-aware IR technique outperforms stateof-the-art coverage-based techniques in this real-world setting, and our hybrid techniques improve even further upon the original IR technique. Moreover, we show that flaky tests have a substantial impact on evaluating the change-aware TCP techniques based on real test failures.', '10.1145/3395363.3397383', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '324--336', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397383', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/PengSZ20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (22, 'Patch based vulnerability matching for binary programs', 'The binary-level function matching has been widely used to detect whether there are 1-day vulnerabilities in released programs. However, the high false positive is a challenge for current function matching solutions, since the vulnerable function is highly similar to its corresponding patched version. In this paper, the Binary X-Ray (BinXray), a patch based vulnerability matching approach, is proposed to identify the specific 1-day vulnerabilities in target programs accurately and effectively. In the preparing step, a basic block mapping algorithm is designed to extract the signature of a patch, by comparing the given vulnerable and patched programs. The signature is represented as a set of basic block traces. In the detection step, the patching semantics is applied to reduce irrelevant basic block traces to speed up the signature searching. The trace similarity is also designed to identify whether a target program is patched. In experiments, 12 real software projects related to 479 CVEs are collected. BinXray achieves 93.31% accuracy and the analysis time cost is only 296.17ms per function, outperforming the state-of-the-art works.', '10.1145/3395363.3397361', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '376--387', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397361', 'Thu, 17 Dec 2020 16:29:24 +0100', 'https://dblp.org/rec/conf/issta/XuX0SLL20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (23, 'ProFL: a fault localization framework for Prolog', 'Prolog is a declarative, first-order logic that has been used in a variety of domains to implement heavily rules-based systems. However, it is challenging to write a Prolog program correctly. Fortunately, the SWI-Prolog environment supports a unit testing framework, plunit, which enables developers to systematically check for correctness. However, knowing a program is faulty is just the first step. The developer then needs to fix the program which means the developer needs to determine what part of the program is faulty. ProFL is a fault localization tool that adapts imperative-based fault localization techniques to Prolog’s declarative environment. ProFL takes as input a faulty Prolog program and a plunit test suite. Then, ProFL performs fault localization and returns a list of suspicious program clauses to the user. Our toolset encompasses two different techniques: ProFL\n, a spectrum-based technique, and ProFL\n, a mutation-based technique. This paper describes our Python implementation of ProFL, which is a command-line tool, released as an open-source project on GitHub (https://github.com/geoorge1d127/ProFL). Our experimental results show ProFL is accurate at localizing faults in our benchmark programs.', '10.1145/3395363.3404367', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '561--564', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3404367', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/ThompsonS20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (24, 'DeepSQLi: deep semantic learning for testing {SQL} injection', 'Security is unarguably the most serious concern for Web applications, to which SQL injection (SQLi) attack is one of the most devastating attacks. Automatically testing SQLi vulnerabilities is of ultimate importance, yet is unfortunately far from trivial to implement. This is because the existence of a huge, or potentially infinite, number of variants and semantic possibilities of SQL leading to SQLi attacks on various Web applications. In this paper, we propose a deep natural language processing based tool, dubbed DeepSQLi, to generate test cases for detecting SQLi vulnerabilities. Through adopting deep learning based neural language model and sequence of words prediction, DeepSQLi is equipped with the ability to learn the semantic knowledge embedded in SQLi attacks, allowing it to translate user inputs (or a test case) into a new test case, which is se- mantically related and potentially more sophisticated. Experiments are conducted to compare DeepSQLi with SQLmap, a state-of-the-art SQLi testing automation tool, on six real-world Web applications that are of different scales, characteristics and domains. Empirical results demonstrate the effectiveness and the remarkable superiority of DeepSQLi over SQLmap, such that more SQLi vulnerabilities can be identified by using a less number of test cases, whilst running much faster.', '10.1145/3395363.3397375', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '286--297', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397375', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/Liu0020.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (25, 'Scalable analysis of interaction threats in IoT systems', 'The ubiquity of Internet of Things (IoT) and our growing reliance on IoT apps are leaving us more vulnerable to safety and security threats than ever before. Many of these threats are manifested at the interaction level, where undesired or malicious coordinations between apps and physical devices can lead to intricate safety and security issues. This paper presents IoTCOM, an approach to automatically discover such hidden and unsafe interaction threats in a compositional and scalable fashion. It is backed with auto-mated program analysis and formally rigorous violation detection engines. IoTCOM relies on program analysis to automatically infer the relevant app’s behavior. Leveraging a novel strategy to trim the extracted app’s behavior prior to translating them to analyzable formal specifications,IoTCOM mitigates the state explosion associated with formal analysis. Our experiments with numerous bundles of real-world IoT apps have corroborated IoTCOM’s ability to effectively detect a broad spectrum of interaction threats triggered through cyber and physical channels, many of which were previously unknown, and to significantly outperform the existing techniques in terms of scalability.', '10.1145/3395363.3397347', 2, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '272--285', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397347', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/AlhanahnahSB20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (26, 'Differential regression testing for {REST} APIs', 'Cloud services are programmatically accessed through REST APIs. Since REST APIs are constantly evolving, an important problem is how to prevent breaking changes of APIs, while supporting several different versions. To find such breaking changes in an automated way, we introduce differential regression testing for REST APIs. Our approach is based on two observations. First, breaking changes in REST APIs involve two software components, namely the client and the service. As such, there are also two types of regressions: regressions in the API specification, i.e., in the contract between the client and the service, and regressions in the service itself, i.e., previously working requests are \"broken\" in later versions of the service. Finding both kinds of regressions involves testing along two dimensions: when the service changes and when the specification changes. Second, to detect such bugs automatically, we employ differential testing. That is, we compare the behavior of different versions on the same inputs against each other, and find regressions in the observed differences. For generating inputs (sequences of HTTP requests) to services, we use RESTler, a stateful fuzzer for REST APIs. Comparing the outputs (HTTP responses) of a cloud service involves several challenges, like abstracting over minor differences, handling out-of-order requests, and non-determinism. Differential regression testing across 17 different versions of the widely-used Azure networking APIs deployed between 2016 and 2019 detected 14 regressions in total, 5 of those in the official API specifications and 9 regressions in the services themselves.', '10.1145/3395363.3397374', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '312--323', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397374', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/GodefroidLP20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (27, 'Detecting cache-related bugs in Spark applications', 'Apache Spark has been widely used to build big data applications. Spark utilizes the abstraction of Resilient Distributed Dataset (RDD) to store and retrieve large-scale data. To reduce duplicate computation of an RDD, Spark can cache the RDD in memory and then reuse it later, thus improving performance. Spark relies on application developers to enforce caching decisions by using \n() and \n() APIs, e.g., \n RDD is persisted and \n the RDD is persisted / unpersisted. Incorrect RDD caching decisions can cause duplicate computations, or waste precious memory resource, thus introducing serious performance degradation in Spark applications. In this paper, we propose \n, to automatically detect cache-related bugs in Spark applications. We summarize six cache-related bug patterns in Spark applications, and then dynamically detect cache-related bugs by analyzing the execution traces of Spark applications. We evaluate CacheCheck on six real-world Spark applications. The experimental result shows that CacheCheck detects 72 previously unknown cache-related bugs, and 28 of them have been fixed by developers.', '10.1145/3395363.3397353', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '363--375', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397353', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/LiWHGDXWWZ20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (28, 'Intermittently failing tests in the embedded systems domain', 'Software testing is sometimes plagued with intermittently failing tests and finding the root causes of such failing tests is often difficult. This problem has been widely studied at the unit testing level for open source software, but there has been far less investigation at the system test level, particularly the testing of industrial embedded systems. This paper describes our investigation of the root causes of intermittently failing tests in the embedded systems domain, with the goal of better understanding, explaining and categorizing the underlying faults. The subject of our investigation is a currently-running industrial embedded system, along with the system level testing that was performed. We devised and used a novel metric for classifying test cases as intermittent. From more than a half million test verdicts, we identified intermittently and consistently failing tests, and identified their root causes using multiple sources. We found that about 1-3% of all test cases were intermittently failing. From analysis of the case study results and related work, we identified nine factors associated with test case intermittence. We found that a fix for a consistently failing test typically removed a larger number of failures detected by other tests than a fix for an intermittent test. We also found that more effort was usually needed to identify fixes for intermittent tests than for consistent tests. An overlap between root causes leading to intermittent and consistent tests was identified. Many root causes of intermittence are the same in industrial embedded systems and open source software. However, when comparing unit testing to system level testing, especially for embedded systems, we observed that the test environment itself is often the cause of intermittence.', '10.1145/3395363.3397359', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '337--348', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397359', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/StrandbergOWAS20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (29, 'EShield: protect smart contracts against reverse engineering', 'Smart contracts are the back-end programs of blockchain-based applications and the execution results are deterministic and publicly visible. Developers are unwilling to release source code of some smart contracts to generate randomness or for security reasons, however, attackers still can use reverse engineering tools to decompile and analyze the code. In this paper, we propose EShield, an automated security enhancement tool for protecting smart contracts against reverse engineering. EShield replaces original instructions of operating jump addresses with anti-patterns to interfere with control flow recovery from bytecode. We have implemented four methods in EShield and conducted an experiment on over 20k smart contracts. The evaluation results show that all the protected smart contracts are resistant to three different reverse engineering tools with little extra gas cost.', '10.1145/3395363.3404365', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '553--556', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3404365', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/YanGWLGLC20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (30, 'Test recommendation system based on slicing coverage filtering', 'Software testing plays a crucial role in software lifecycle. As a basic approach of software testing, unit testing is one of the necessary skills for software practitioners. Since testers are required to understand the inner code of the software under test(SUT) while writing a test case, testers usually need to learn how to detect the bug within SUT effectively. When novice programmers started to learn writing unit tests, they will generally watch a video lesson or reading unit tests written by others. These learning approaches are either time-consuming or too hard for a novice. To solve these problems, we developed a system, named TeSRS, to assist novice programmers to learn unit testing. TeSRS is a test recommendation system which can effectively assist test novice in learning unit testing. Utilizing program slice technique, TeSRS has gotten an enormous amount of test snippets from superior crowdsourcing test scripts. Depending on these test snippets, TeSRS provides novices a easier way for unit test learning. To sum up, TeSRS can help test novices (1) obtain high level design ideas of unit test case and (2) improve capabilities(e.g. branch coverage rate and mutation coverage rate) of their test scripts. TeSRS has built a scalable corpus composed of over 8000 test snippets from more than 25 test problems. Its stable performance shows effectiveness in unit test learning. \nDemo video can be found at <a>https://youtu.be/xvrLdvU8zFA</a>', '10.1145/3395363.3404370', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '573--576', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3404370', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/QianZMFSH020.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (31, 'Debugging the performance of Maven\'s test isolation: experience report', 'Testing is the most common approach used in industry for checking software correctness. Developers frequently practice reliable testing-executing individual tests in isolation from each other-to avoid test failures caused by test-order dependencies and shared state pollution (e.g., when tests mutate static fields). A common way of doing this is by running each test as a separate process. Unfortunately, this is known to introduce substantial overhead. This experience report describes our efforts to better understand the sources of this overhead and to create a system to confirm the minimal overhead possible. We found that different build systems use different mechanisms for communicating between these multiple processes, and that because of this design decision, running tests with some build systems could be faster than with others. Through this inquiry we discovered a significant performance bug in Apache Maven’s test running code, which slowed down test execution by on average 350 milliseconds per-test when compared to a competing build system, Ant. When used for testing real projects, this can result in a significant reduction in testing time. We submitted a patch for this bug which has been integrated into the Apache Maven build system, and describe our ongoing efforts to improve Maven’s test execution tooling.', '10.1145/3395363.3397381', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '249--259', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397381', 'Mon, 27 Jul 2020 07:36:48 +0200', 'https://dblp.org/rec/conf/issta/NieCCMBG20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (32, 'Detecting flaky tests in probabilistic and machine learning applications', 'Probabilistic programming systems and machine learning frameworks like Pyro, PyMC3, TensorFlow, and PyTorch provide scalable and efficient primitives for inference and training. However, such operations are non-deterministic. Hence, it is challenging for developers to write tests for applications that depend on such frameworks, often resulting in flaky tests – tests which fail non-deterministically when run on the same version of code. \n In this paper, we conduct the first extensive study of flaky tests in this domain. In particular, we study the projects that depend on four frameworks: Pyro, PyMC3, TensorFlow-Probability, and PyTorch. We identify 75 bug reports/commits that deal with flaky tests, and we categorize the common causes and fixes for them. This study provides developers with useful insights on dealing with flaky tests in this domain. \n Motivated by our study, we develop a technique, FLASH, to systematically detect flaky tests due to assertions passing and failing in different runs on the same code. These assertions fail due to differences in the sequence of random numbers in different runs of the same test. FLASH exposes such failures, and our evaluation on 20 projects results in 11 previously-unknown flaky tests that we reported to developers.', '10.1145/3395363.3397366', 2, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '211--224', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397366', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/0001SCZJM20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (33, 'Dependent-test-aware regression testing techniques', 'Developers typically rely on regression testing techniques to ensure that their changes do not break existing functionality. Unfortunately, these techniques suffer from flaky tests, which can both pass and fail when run multiple times on the same version of code and tests. One prominent type of flaky tests is order-dependent (OD) tests, which are tests that pass when run in one order but fail when run in another order. Although OD tests may cause flaky-test failures, OD tests can help developers run their tests faster by allowing them to share resources. We propose to make regression testing techniques dependent-test-aware to reduce flaky-test failures. \n To understand the necessity of dependent-test-aware regression testing techniques, we conduct the first study on the impact of OD tests on three regression testing techniques: test prioritization, test selection, and test parallelization. In particular, we implement 4 test prioritization, 6 test selection, and 2 test parallelization algorithms, and we evaluate them on 11 Java modules with OD tests. When we run the orders produced by the traditional, dependent-test-unaware regression testing algorithms, 82% of human-written test suites and 100% of automatically-generated test suites with OD tests have at least one flaky-test failure. \n We develop a general approach for enhancing regression testing algorithms to make them dependent-test-aware, and apply our approach to 12 algorithms. Compared to traditional, unenhanced regression testing algorithms, the enhanced algorithms use provided test dependencies to produce orders with different permutations or extra tests. Our evaluation shows that, in comparison to the orders produced by unenhanced algorithms, the orders produced by enhanced algorithms (1) have overall 80% fewer flaky-test failures due to OD tests, and (2) may add extra tests but run only 1% slower on average. Our results suggest that enhancing regression testing algorithms to be dependent-test-aware can substantially reduce flaky-test failures with only a minor slowdown to run the tests.', '10.1145/3395363.3397364', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '298--311', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397364', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/LamSOZE020.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (34, 'Echidna: effective, usable, and fast fuzzing for smart contracts', 'Ethereum smart contracts---autonomous programs that run on a blockchain---often control transactions of financial and intellectual property. Because of the critical role they play, smart contracts need complete, comprehensive, and effective test generation. This paper introduces an open-source smart contract fuzzer called Echidna that makes it easy to automatically generate tests to detect violations in assertions and custom properties. Echidna is easy to install and does not require a complex configuration or deployment of contracts to a local blockchain. It offers responsive feedback, captures many property violations, and its default settings are calibrated based on experimental data. To date, Echidna has been used in more than 10 large paid security audits, and feedback from those audits has driven the features and user experience of Echidna, both in terms of practical usability (e.g., smart contract frameworks like Truffle and Embark) and test generation strategies. Echidna aims to be good at finding real bugs in smart contracts, with minimal user effort and maximal speed.', '10.1145/3395363.3404366', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '557--560', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3404366', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/GriecoSCFG20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (35, 'Feedback-driven side-channel analysis for networked applications', 'Information leakage in software systems is a problem of growing importance. Networked applications can leak sensitive information even when they use encryption. For example, some characteristics of network packets, such as their size, timing and direction, are visible even for encrypted traffic. Patterns in these characteristics can be leveraged as side channels to extract information about secret values accessed by the application. In this paper, we present a new tool called AutoFeed for detecting and quantifying information leakage due to side channels in networked software applications. AutoFeed profiles the target system and automatically explores the input space, explores the space of output features that may leak information, quantifies the information leakage, and identifies the top-leaking features. Given a set of input mutators and a small number of initial inputs provided by the user, AutoFeed iteratively mutates inputs and periodically updates its leakage estimations to identify the features that leak the greatest amount of information about the secret of interest. AutoFeed uses a feedback loop for incremental profiling, and a stopping criterion that terminates the analysis when the leakage estimation for the top-leaking features converges. AutoFeed also automatically assigns weights to mutators in order to focus the search of the input space on exploring dimensions that are relevant to the leakage quantification. Our experimental evaluation on the benchmarks shows that AutoFeed is effective in detecting and quantifying information leaks in networked applications.', '10.1145/3395363.3397365', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '260--271', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397365', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/KadronRB20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (36, 'Scaffle: bug localization on millions of files', 'Despite all efforts to avoid bugs, software sometimes crashes in the field, leaving crash traces as the only information to localize the problem. Prior approaches on localizing where to fix the root cause of a crash do not scale well to ultra-large scale, heterogeneous code bases that contain millions of code files written in multiple programming languages. This paper presents Scaffle, the first scalable bug localization technique, which is based on the key insight to divide the problem into two easier sub-problems. First, a trained machine learning model predicts which lines of a raw crash trace are most informative for localizing the bug. Then, these lines are fed to an information retrieval-based search engine to retrieve file paths in the code base, predicting which file to change to address the crash. The approach does not make any assumptions about the format of a crash trace or the language that produces it. We evaluate Scaffle with tens of thousands of crash traces produced by a large-scale industrial code base at Facebook that contains millions of possible bug locations and that powers tools used by billions of people. The results show that the approach correctly predicts the file to fix for 40% to 60% (50% to 70%) of all crash traces within the top-1 (top-5) predictions. Moreover, Scaffle improves over several baseline approaches, including an existing classification-based approach, a scalable variant of existing information retrieval-based approaches, and a set of hand-tuned, industrially deployed heuristics.', '10.1145/3395363.3397356', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '225--236', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397356', 'Wed, 22 Jul 2020 16:06:01 +0200', 'https://dblp.org/rec/conf/issta/PradelMQMM020.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (37, 'Data loss detector: automatically revealing data loss bugs in Android apps', 'Android apps must work correctly even if their execution is interrupted by external events. For instance, an app must work properly even if a phone call is received, or after its layout is redrawn because the smartphone has been rotated. Since these events may require destroying, when the execution is interrupted, and recreating, when the execution is resumed, the foreground activity of the app, the only way to prevent the loss of state information is to save and restore it. This behavior must be explicitly implemented by app developers, who often miss to implement it properly, releasing apps affected by data loss problems, that is, apps that may lose state information when their execution is interrupted. Although several techniques can be used to automatically generate test cases for Android apps, the obtained test cases seldom include the interactions and the checks necessary to exercise and reveal data loss faults. To address this problem, this paper presents Data Loss Detector (DLD), a test case generation technique that integrates an exploration strategy, data-loss-revealing actions, and two customized oracle strategies for the detection of data loss failures. DLD revealed 75% of the faults in a benchmark of 54 Android app releases affected by 110 known data loss faults, and also revealed unknown data loss problems, outperforming competing approaches.', '10.1145/3395363.3397379', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '141--152', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397379', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/RiganelliMRMM20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (38, 'Higher income, larger loan? monotonicity testing of machine learning models', 'Today, machine learning (ML) models are increasingly applied in decision making. This induces an urgent need for quality assurance of ML models with respect to (often domain-dependent) requirements. Monotonicity is one such requirement. It specifies a software as \'\'learned\'\' by an ML algorithm to give an increasing prediction with the increase of some attribute values. While there exist multiple ML algorithms for ensuring monotonicity of the generated model, approaches for checking monotonicity, in particular of black-box models are largely lacking. \n In this work, we propose verification-based testing of monotonicity, i.e., the formal computation of test inputs on a white-box model via verification technology, and the automatic inference of this approximating white-box model from the black-box model under test. On the white-box model, the space of test inputs can be systematically explored by a directed computation of test cases. The empirical evaluation on 90 black-box models shows that verification-based testing can outperform adaptive random testing as well as property-based techniques with respect to effectiveness and efficiency.', '10.1145/3395363.3397352', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '200--210', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397352', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/SharmaW20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (39, 'Reinforcement learning based curiosity-driven testing of Android applications', 'Mobile applications play an important role in our daily life, while it still remains a challenge to guarantee their correctness. Model-based and systematic approaches have been applied to Android GUI testing. However, they do not show significant advantages over random approaches because of limitations such as imprecise models and poor scalability. In this paper, we propose Q-testing, a reinforcement learning based approach which benefits from both random and model-based approaches to automated testing of Android applications. Q-testing explores the Android apps with a curiosity-driven strategy that utilizes a memory set to record part of previously visited states and guides the testing towards unfamiliar functionalities. A state comparison module, which is a neural network trained by plenty of collected samples, is novelly employed to divide different states at the granularity of functional scenarios. It can determine the reinforcement learning reward in Q-testing and help the curiosity-driven strategy explore different functionalities efficiently. We conduct experiments on 50 open-source applications where Q-testing outperforms the state-of-the-art and state-of-practice Android GUI testing tools in terms of code coverage and fault detection. So far, 22 of our reported faults have been confirmed, among which 7 have been fixed.', '10.1145/3395363.3397354', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '153--164', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397354', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/PanHWZL20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (40, 'CPSDebug: a tool for explanation of failures in cyber-physical systems', 'Debugging Cyber-Physical System models is often challenging, as it requires identifying a potentially long, complex and heterogenous combination of events that resulted in a violation of the expected behavior of the system. In this paper we present CPSDebug, a tool for supporting designers in the debugging of failures in MATLAB Simulink/Stateflow models. CPSDebug implements a gray-box approach that combines testing, specification mining, and failure analysis to identify the causes of failures and explain their propagation in time and space. The evaluation of the tool, based on multiple usage scenarios and faults and direct feedback from engineers, shows that CPSDebug can effectively aid engineers during debugging tasks.', '10.1145/3395363.3404369', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '569--572', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3404369', 'Tue, 29 Dec 2020 18:31:45 +0100', 'https://dblp.org/rec/conf/issta/BartocciMMMNP20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (41, 'Effective white-box testing of deep neural networks with adaptive neuron-selection strategy', 'We present Adapt, a new white-box testing technique for deep neural networks. As deep neural networks are increasingly used in safety-first applications, testing their behavior systematically has become a critical problem. Accordingly, various testing techniques for deep neural networks have been proposed in recent years. However, neural network testing is still at an early stage and existing techniques are not yet sufficiently effective. In this paper, we aim to advance this field, in particular white-box testing approaches for neural networks, by identifying and addressing a key limitation of existing state-of-the-arts. We observe that the so-called neuron-selection strategy is a critical component of white-box testing and propose a new technique that effectively employs the strategy by continuously adapting it to the ongoing testing process. Experiments with real-world network models and datasets show that Adapt is remarkably more effective than existing testing techniques in terms of coverage and adversarial inputs found.', '10.1145/3395363.3397346', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '165--176', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397346', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/LeeCLO20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (42, 'Detecting and understanding real-world differential performance bugs in machine learning libraries', 'Programming errors that degrade the performance of systems are widespread, yet there is very little tool support for finding and diagnosing these bugs. We present a method and a tool based on differential performance analysis---we find inputs for which the performance varies widely, despite having the same size. To ensure that the differences in the performance are robust (i.e. hold also for large inputs), we compare the performance of not only single inputs, but of classes of inputs, where each class has similar inputs parameterized by their size. Thus, each class is represented by a performance function from the input size to performance. Importantly, we also provide an explanation for why the performance differs in a form that can be readily used to fix a performance bug. The two main phases in our method are discovery with fuzzing and explanation with decision tree classifiers, each of which is supported by clustering. First, we propose an evolutionary fuzzing algorithm to generate inputs that characterize different performance functions. For this fuzzing task, the unique challenge is that we not only need the input class with the worst performance, but rather a set of classes exhibiting differential performance. We use clustering to merge similar input classes which significantly improves the efficiency of our fuzzer. Second, we explain the differential performance in terms of program inputs and internals (e.g., methods and conditions). We adapt discriminant learning approaches with clustering and decision trees to localize suspicious code regions. We applied our techniques on a set of micro-benchmarks and real-world machine learning libraries. On a set of micro-benchmarks, we show that our approach outperforms state-of-the-art fuzzers in finding inputs to characterize differential performance. On a set of case-studies, we discover and explain multiple performance bugs in popular machine learning frameworks, for instance in implementations of logistic regression in scikit-learn. Four of these bugs, reported first in this paper, have since been fixed by the developers.', '10.1145/3395363.3404540', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '189--199', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3404540', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/Tizpaz-NiariC020.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (43, 'Running symbolic execution forever', 'When symbolic execution is used to analyse real-world applications, it often consumes all available memory in a relatively short amount of time, sometimes making it impossible to analyse an application for an extended period. In this paper, we present a technique that can record an ongoing symbolic execution analysis to disk and selectively restore paths of interest later, making it possible to run symbolic execution indefinitely. To be successful, our approach addresses several essential research challenges related to detecting divergences on re-execution, storing long-running executions efficiently, changing search heuristics during re-execution, and providing a global view of the stored execution. Our extensive evaluation of 93 Linux applications shows that our approach is practical, enabling these applications to run for days while continuing to explore new execution paths.', '10.1145/3395363.3397360', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '63--74', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397360', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/BusseNC20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (44, 'DeepGini: prioritizing massive tests to enhance the robustness of deep neural networks', 'Deep neural networks (DNN) have been deployed in many software systems to assist in various classification tasks. In company with the fantastic effectiveness in classification, DNNs could also exhibit incorrect behaviors and result in accidents and losses. Therefore, testing techniques that can detect incorrect DNN behaviors and improve DNN quality are extremely necessary and critical. However, the testing oracle, which defines the correct output for a given input, is often not available in the automated testing. To obtain the oracle information, the testing tasks of DNN-based systems usually require expensive human efforts to label the testing data, which significantly slows down the process of quality assurance. \n To mitigate this problem, we propose DeepGini, a test prioritization technique designed based on a statistical perspective of DNN. Such a statistical perspective allows us to reduce the problem of measuring misclassification probability to the problem of measuring set impurity, which allows us to quickly identify possibly-misclassified tests. To evaluate, we conduct an extensive empirical study on popular datasets and prevalent DNN models. The experimental results demonstrate that DeepGini outperforms existing coverage-based techniques in prioritizing tests regarding both effectiveness and efficiency. Meanwhile, we observe that the tests prioritized at the front by DeepGini are more effective in improving the DNN quality in comparison with the coverage-based techniques.', '10.1145/3395363.3397357', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '177--188', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397357', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/FengSGWF020.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (45, 'CoCoNuT: combining context-aware neural translation models using ensemble for program repair', 'Automated generate-and-validate (GV) program repair techniques (APR) typically rely on hard-coded rules, thus only fixing bugs following specific fix patterns. These rules require a significant amount of manual effort to discover and it is hard to adapt these rules to different programming languages. \nTo address these challenges, we propose a new G&V technique—CoCoNuT, which uses ensemble learning on the combination of convolutional neural networks (CNNs) and a new context-aware neural machine translation (NMT) architecture to automatically fix bugs in multiple programming languages. To better represent the context of a bug, we introduce a new context-aware NMT architecture that represents the buggy source code and its surrounding context separately. CoCoNuT uses CNNs instead of recurrent neural networks (RNNs), since CNN layers can be stacked to extract hierarchical features and better model source code at different granularity levels (e.g., statements and functions). In addition, CoCoNuT takes advantage of the randomness in hyperparameter tuning to build multiple models that fix different bugs and combines these models using ensemble learning to fix more bugs. \nOur evaluation on six popular benchmarks for four programming languages (Java, C, Python, and JavaScript) shows that CoCoNuT correctly fixes (i.e., the first generated patch is semantically equivalent to the developer’s patch) 509 bugs, including 309 bugs that are fixed by none of the 27 techniques with which we compare.', '10.1145/3395363.3397369', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '101--114', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397369', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/LutellierPPLW020.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (46, 'Can automated program repair refine fault localization? a unified debugging approach', 'A large body of research efforts have been dedicated to automated software debugging, including both automated fault localization and program repair. However, existing fault localization techniques have limited effectiveness on real-world software systems while even the most advanced program repair techniques can only fix a small ratio of real-world bugs. Although fault localization and program repair are inherently connected, their only existing connection in the literature is that program repair techniques usually use off-the-shelf fault localization techniques (e.g., Ochiai) to determine the potential candidate statements/elements for patching. In this work, we propose the unified debugging approach to unify the two areas in the other direction for the first time, i.e., can program repair in turn help with fault localization? In this way, we not only open a new dimension for more powerful fault localization, but also extend the application scope of program repair to all possible bugs (not only the bugs that can be directly automatically fixed). We have designed ProFL to leverage patch-execution results (from program repair) as the feedback information for fault localization. The experimental results on the widely used Defects4J benchmark show that the basic ProFL can already at least localize 37.61% more bugs within Top-1 than state-of-the-art spectrum and mutation based fault localization. Furthermore, ProFL can boost state-of-the-art fault localization via both unsupervised and supervised learning. Meanwhile, we have demonstrated ProFL\'s effectiveness under different settings and through a case study within Alipay, a popular online payment system with over 1 billion global users.', '10.1145/3395363.3397351', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '75--87', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397351', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/LouGLZZHZ20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (47, 'Automated classification of actions in bug reports of mobile apps', 'When users encounter problems with mobile apps, they may commit such problems to developers as bug reports. To facilitate the processing of bug reports, researchers proposed approaches to validate the reported issues automatically according to the \n specified in bug reports. Although such approaches have achieved high success rate in reproducing the reported issues, they often rely on a predefined vocabulary to identify and classify actions in bug reports. However, such manually constructed vocabulary and classification have significant limitations. It is challenging for the vocabulary to cover all potential action words because users may describe the same action with different words. Besides that, classification of actions solely based on the action words could be inaccurate because the same action word, appearing in different contexts, may have different meaning and thus belongs to different action categories. To this end, in this paper we propose an automated approach, called \n, to identify and classify action words in Mobile apps’ bug reports. For a given bug report, it first identifies action words based on natural language processing. For each of the resulting action words, \n extracts its contexts, i.e., its enclosing segment, the associated UI target, and the type of its target element by both natural language processing and static analysis of the associated app. The action word and its contexts are then fed into a machine learning based classifier that predicts the category of the given action word in the given context. To train the classifier, we manually labelled 1,202 actions words from 525 bug reports that are associated with 207 apps. Our evaluation results on manually labelled data suggested that \n was accurate with high accuracy varying from 95% to 96.7%. We also investigated to what extent \n could further improve existing approaches (i.e., Yakusu and ReCDroid) in reproducing bug reports. Our evaluation results suggested that integrating \n into existing approaches significantly improved the success rates of ReCDroid and Yakusu by 22.7% = (69.2%-56.4%)/56.4% and 22.9%= (62.7%-51%)/51%, respectively.', '10.1145/3395363.3397355', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '128--140', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397355', 'Tue, 01 Sep 2020 19:50:08 +0200', 'https://dblp.org/rec/conf/issta/LiuSJJ20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (48, 'Automated repair of feature interaction failures in automated driving systems', 'In the past years, several automated repair strategies have been proposed to fix bugs in individual software programs without any human intervention. There has been, however, little work on how automated repair techniques can resolve failures that arise at the system-level and are caused by undesired interactions among different system components or functions. Feature interaction failures are common in complex systems such as autonomous cars that are typically built as a composition of independent features (i.e., units of functionality). In this paper, we propose a repair technique to automatically resolve undesired feature interaction failures in automated driving systems (ADS) that lead to the violation of system safety requirements. Our repair strategy achieves its goal by (1) localizing faults spanning several lines of code, (2) simultaneously resolving multiple interaction failures caused by independent faults, (3) scaling repair strategies from the unit-level to the system-level, and (4) resolving failures based on their order of severity. We have evaluated our approach using two industrial ADS containing four features. Our results show that our repair strategy resolves the undesired interaction failures in these two systems in less than 16h and outperforms existing automated repair techniques.', '10.1145/3395363.3397386', 2, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '88--100', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397386', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/AbdessalemPNBS20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (49, 'Detecting and diagnosing energy issues for mobile applications', 'Energy efficiency is an important criterion to judge the quality of mobile apps, but one third of our randomly sampled apps suffer from energy issues that can quickly drain battery power. To understand these issues, we conducted an empirical study on 27 well-maintained apps such as Chrome and Firefox, whose issue tracking systems are publicly accessible. Our study revealed that the main root causes of energy issues include unnecessary workload and excessively frequent operations. Surprisingly, these issues are beyond the application of present technology on energy issue detection. We also found that 25.0% of energy issues can only manifest themselves under specific contexts such as poor network performance, but such contexts are again neglected by present technology. In this paper, we propose a novel testing framework for detecting energy issues in real-world mobile apps. Our framework examines apps with well-designed input sequences and runtime contexts. To identify the root causes mentioned above, we employed a machine learning algorithm to cluster the workloads and further evaluate their necessity. For the issues concealed by the specific contexts, we carefully set up several execution contexts to catch them. More importantly, we designed leading edge technology, e.g. pre-designing input sequences with potential energy overuse and tuning tests on-the-fly, to achieve high efficacy in detecting energy issues. A large-scale evaluation shows that 91.6% issues detected in our experiments were previously unknown to developers. On average, these issues double the energy costs of the apps. Our testing technique achieves a low number of false positives.', '10.1145/3395363.3397350', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '115--127', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397350', 'Sat, 05 Sep 2020 17:58:56 +0200', 'https://dblp.org/rec/conf/issta/0002Y0GW20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (50, 'Relocatable addressing model for symbolic execution', 'Symbolic execution (SE) is a widely used program analysis technique. Existing SE engines model the memory space by associating memory objects with concrete addresses, where the representation of each allocated object is determined during its allocation. We present a novel addressing model where the underlying representation of an allocated object can be dynamically modified even after its allocation, by using symbolic addresses rather than concrete ones. We demonstrate the benefits of our model in two application scenarios: dynamic inter- and intra-object partitioning. In the former, we show how the recently proposed segmented memory model can be improved by dynamically merging several object representations into a single one, rather than doing that a-priori using static pointer analysis. In the latter, we show how the cost of solving array theory constraints can be reduced by splitting the representations of large objects into multiple smaller ones. Our preliminary results show that our approach can significantly improve the overall effectiveness of the symbolic exploration.', '10.1145/3395363.3397363', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '51--62', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397363', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/TrabishR20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (51, 'Active fuzzing for testing and securing cyber-physical systems', 'Cyber-physical systems (CPSs) in critical infrastructure face a pervasive threat from attackers, motivating research into a variety of countermeasures for securing them. Assessing the effectiveness of these countermeasures is challenging, however, as realistic benchmarks of attacks are difficult to manually construct, blindly testing is ineffective due to the enormous search spaces and resource requirements, and intelligent fuzzing approaches require impractical amounts of data and network access. In this work, we propose \n, an automatic approach for finding test suites of packet-level CPS network attacks, targeting scenarios in which attackers can observe sensors and manipulate packets, but have no existing knowledge about the payload encodings. Our approach learns regression models for predicting sensor values that will result from sampled network packets, and uses these predictions to guide a search for payload manipulations (i.e. bit flips) most likely to drive the CPS into an unsafe state. Key to our solution is the use of \n, which iteratively updates the models by sampling payloads that are estimated to maximally improve them. We evaluate the efficacy of active fuzzing by implementing it for a water purification plant testbed, finding it can automatically discover a test suite of flow, pressure, and over/underflow attacks, all with substantially less time, data, and network access than the most comparable approach. Finally, we demonstrate that our prediction models can also be utilised as countermeasures themselves, implementing them as anomaly detectors and early warning systems.', '10.1145/3395363.3397376', 2, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '14--26', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397376', 'Sat, 05 Sep 2020 17:58:56 +0200', 'https://dblp.org/rec/conf/issta/0001XP0020.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (52, 'Abstracting failure-inducing inputs', 'A program fails. Under which circumstances does the failure occur? Starting with a single failure-inducing input (\"The input ((4)) fails\") and an input grammar, the DDSET algorithm uses systematic tests to automatically generalize the input to an abstract failure-inducing input that contains both (concrete) terminal symbols and (abstract) nonterminal symbols from the grammar—for instance, \"((<expr>))\", which represents any expression <expr> in double parentheses. Such an abstract failure-inducing input can be used (1) as a debugging diagnostic, characterizing the circumstances under which a failure occurs (\"The error occurs whenever an expression is enclosed in double parentheses\"); (2) as a producer of additional failure-inducing tests to help design and validate fixes and repair candidates (\"The inputs ((1)), ((3 * 4)), and many more also fail\"). In its evaluation on real-world bugs in JavaScript, Clojure, Lua, and UNIX command line utilities, DDSET’s abstract failure-inducing inputs provided to-the-point diagnostics, and precise producers for further failure inducing inputs.', '10.1145/3395363.3397349', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '237--248', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397349', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/GopinathKHSZ20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (53, 'A programming model for semi-implicit parallelization of static analyses', 'Parallelization of static analyses is necessary to scale to real-world programs, but it is a complex and difficult task and, therefore, often only done manually for selected high-profile analyses. In this paper, we propose a programming model for semi-implicit parallelization of static analyses which is inspired by reactive programming. Reusing the domain-expert knowledge on how to parallelize anal- yses encoded in the programming framework, developers do not need to think about parallelization and concurrency issues on their own. The programming model supports stateful computations, only requires monotonic computations over lattices, and is independent of specific analyses. Our evaluation shows the applicability of the programming model to different analyses and the importance of user-selected scheduling strategies. We implemented an IFDS solver that was able to outperform a state-of-the-art, specialized parallel IFDS solver both in absolute performance and scalability.', '10.1145/3395363.3397367', 1, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '428--439', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397367', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/HelmKKHESM20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (54, 'Learning input tokens for effective fuzzing', 'Modern fuzzing tools like AFL operate at a lexical level: They explore the input space of tested programs one byte after another. For inputs with complex syntactical properties, this is very inefficient, as keywords and other tokens have to be composed one character at a time. Fuzzers thus allow to specify dictionaries listing possible tokens the input can be composed from; such dictionaries speed up fuzzers dramatically. Also, fuzzers make use of dynamic tainting to track input tokens and infer values that are expected in the input validation phase. Unfortunately, such tokens are usually implicitly converted to program specific values which causes a loss of the taints attached to the input data in the lexical phase. In this paper, we present a technique to extend dynamic tainting to not only track explicit data flows but also taint implicitly converted data without suffering from taint explosion. This extension makes it possible to augment existing techniques and automatically infer a set of tokens and seed inputs for the input language of a program given nothing but the source code. Specifically targeting the lexical analysis of an input processor, our lFuzzer test generator systematically explores branches of the lexical analysis, producing a set of tokens that fully cover all decisions seen. The resulting set of tokens can be directly used as a dictionary for fuzzing. Along with the token extraction seed inputs are generated which give further fuzzing processes a head start. In our experiments, the lFuzzer-AFL combination achieves up to 17% more coverage on complex input formats like json, lisp, tinyC, and JavaScript compared to AFL.', '10.1145/3395363.3397348', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '27--37', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397348', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/MathisGZ20.bib', 'dblp computer science bibliography, https://dblp.org');
INSERT INTO `paper` VALUES (55, 'Fast bit-vector satisfiability', 'SMT solving is often a major source of cost in a broad range of techniques such as symbolic program analysis. Thus, speeding up SMT solving is still an urgent requirement. A dominant approach, which is known as eager SMT solving, is to reduce a first-order formula to a pure Boolean formula, which is handed to an expensive SAT solver to determine the satisfiability. We observe that the SAT solver can utilize the knowledge in the first-order formula to boost its solving efficiency. Unfortunately, despite much progress, it is still not clear how to make use of the knowledge in an eager SMT solver. This paper addresses the problem by introducing a new and fast method, which utilizes the interval and data-dependence information learned from the first-order formulas. \n We have implemented the approach as a tool called Trident and evaluated it on three symbolic analyzers (Angr, Qsym, and Pinpoint). The experimental results, based on seven million SMT solving instances generated for thirty real-world software systems, show that Trident significantly reduces the total solving time from 2.9X to 7.9X over three state-of-the-art SMT solvers (Z3, CVC4, and Boolector), without sacrificing the number of solved instances. We also demonstrate that Trident achieves end-to-end speedups for three program analysis clients by 1.9X, 1.6X, and 2.4X, respectively.', '10.1145/3395363.3397378', 0, '{ISSTA} \'20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020', '38--50', '{ACM}', '2020', 'https://doi.org/10.1145/3395363.3397378', 'Wed, 15 Jul 2020 16:06:56 +0200', 'https://dblp.org/rec/conf/issta/YaoSHZ20.bib', 'dblp computer science bibliography, https://dblp.org');

-- ----------------------------
-- Table structure for paper_author_relation
-- ----------------------------
DROP TABLE IF EXISTS `paper_author_relation`;
CREATE TABLE `paper_author_relation`  (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  PRIMARY KEY (`relation_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper_author_relation
-- ----------------------------
INSERT INTO `paper_author_relation` VALUES (1, 1, 1);
INSERT INTO `paper_author_relation` VALUES (2, 2, 2);
INSERT INTO `paper_author_relation` VALUES (3, 2, 3);
INSERT INTO `paper_author_relation` VALUES (4, 3, 4);
INSERT INTO `paper_author_relation` VALUES (5, 3, 5);
INSERT INTO `paper_author_relation` VALUES (6, 3, 6);
INSERT INTO `paper_author_relation` VALUES (7, 3, 7);
INSERT INTO `paper_author_relation` VALUES (8, 3, 8);
INSERT INTO `paper_author_relation` VALUES (9, 4, 9);
INSERT INTO `paper_author_relation` VALUES (10, 4, 10);
INSERT INTO `paper_author_relation` VALUES (11, 4, 11);
INSERT INTO `paper_author_relation` VALUES (12, 4, 12);
INSERT INTO `paper_author_relation` VALUES (13, 4, 13);
INSERT INTO `paper_author_relation` VALUES (14, 4, 14);
INSERT INTO `paper_author_relation` VALUES (15, 5, 15);
INSERT INTO `paper_author_relation` VALUES (16, 5, 16);
INSERT INTO `paper_author_relation` VALUES (17, 5, 17);
INSERT INTO `paper_author_relation` VALUES (18, 6, 18);
INSERT INTO `paper_author_relation` VALUES (19, 6, 19);
INSERT INTO `paper_author_relation` VALUES (20, 6, 20);
INSERT INTO `paper_author_relation` VALUES (21, 6, 21);
INSERT INTO `paper_author_relation` VALUES (22, 6, 22);
INSERT INTO `paper_author_relation` VALUES (23, 6, 23);
INSERT INTO `paper_author_relation` VALUES (24, 7, 24);
INSERT INTO `paper_author_relation` VALUES (25, 7, 25);
INSERT INTO `paper_author_relation` VALUES (26, 8, 26);
INSERT INTO `paper_author_relation` VALUES (27, 8, 27);
INSERT INTO `paper_author_relation` VALUES (28, 8, 28);
INSERT INTO `paper_author_relation` VALUES (29, 9, 29);
INSERT INTO `paper_author_relation` VALUES (30, 9, 30);
INSERT INTO `paper_author_relation` VALUES (31, 10, 31);
INSERT INTO `paper_author_relation` VALUES (32, 11, 32);
INSERT INTO `paper_author_relation` VALUES (33, 11, 33);
INSERT INTO `paper_author_relation` VALUES (34, 11, 34);
INSERT INTO `paper_author_relation` VALUES (35, 11, 35);
INSERT INTO `paper_author_relation` VALUES (36, 12, 36);
INSERT INTO `paper_author_relation` VALUES (37, 12, 37);
INSERT INTO `paper_author_relation` VALUES (38, 12, 38);
INSERT INTO `paper_author_relation` VALUES (39, 12, 39);
INSERT INTO `paper_author_relation` VALUES (40, 12, 40);
INSERT INTO `paper_author_relation` VALUES (41, 13, 41);
INSERT INTO `paper_author_relation` VALUES (42, 14, 42);
INSERT INTO `paper_author_relation` VALUES (43, 14, 43);
INSERT INTO `paper_author_relation` VALUES (44, 14, 44);
INSERT INTO `paper_author_relation` VALUES (45, 14, 45);
INSERT INTO `paper_author_relation` VALUES (46, 14, 46);
INSERT INTO `paper_author_relation` VALUES (47, 15, 47);
INSERT INTO `paper_author_relation` VALUES (48, 15, 48);
INSERT INTO `paper_author_relation` VALUES (49, 15, 49);
INSERT INTO `paper_author_relation` VALUES (50, 15, 50);
INSERT INTO `paper_author_relation` VALUES (51, 16, 51);
INSERT INTO `paper_author_relation` VALUES (52, 16, 52);
INSERT INTO `paper_author_relation` VALUES (53, 16, 53);
INSERT INTO `paper_author_relation` VALUES (54, 16, 54);
INSERT INTO `paper_author_relation` VALUES (55, 16, 55);
INSERT INTO `paper_author_relation` VALUES (56, 16, 56);
INSERT INTO `paper_author_relation` VALUES (57, 17, 57);
INSERT INTO `paper_author_relation` VALUES (58, 17, 58);
INSERT INTO `paper_author_relation` VALUES (59, 17, 59);
INSERT INTO `paper_author_relation` VALUES (60, 18, 60);
INSERT INTO `paper_author_relation` VALUES (61, 18, 61);
INSERT INTO `paper_author_relation` VALUES (62, 18, 62);
INSERT INTO `paper_author_relation` VALUES (63, 18, 63);
INSERT INTO `paper_author_relation` VALUES (64, 18, 64);
INSERT INTO `paper_author_relation` VALUES (65, 18, 65);
INSERT INTO `paper_author_relation` VALUES (66, 18, 66);
INSERT INTO `paper_author_relation` VALUES (67, 18, 67);
INSERT INTO `paper_author_relation` VALUES (68, 19, 68);
INSERT INTO `paper_author_relation` VALUES (69, 19, 69);
INSERT INTO `paper_author_relation` VALUES (70, 19, 70);
INSERT INTO `paper_author_relation` VALUES (71, 19, 71);
INSERT INTO `paper_author_relation` VALUES (72, 19, 72);
INSERT INTO `paper_author_relation` VALUES (73, 19, 73);
INSERT INTO `paper_author_relation` VALUES (74, 20, 74);
INSERT INTO `paper_author_relation` VALUES (75, 20, 75);
INSERT INTO `paper_author_relation` VALUES (76, 20, 76);
INSERT INTO `paper_author_relation` VALUES (77, 20, 77);
INSERT INTO `paper_author_relation` VALUES (78, 21, 78);
INSERT INTO `paper_author_relation` VALUES (79, 21, 79);
INSERT INTO `paper_author_relation` VALUES (80, 21, 80);
INSERT INTO `paper_author_relation` VALUES (81, 22, 81);
INSERT INTO `paper_author_relation` VALUES (82, 22, 82);
INSERT INTO `paper_author_relation` VALUES (83, 22, 83);
INSERT INTO `paper_author_relation` VALUES (84, 22, 84);
INSERT INTO `paper_author_relation` VALUES (85, 22, 85);
INSERT INTO `paper_author_relation` VALUES (86, 22, 86);
INSERT INTO `paper_author_relation` VALUES (87, 23, 87);
INSERT INTO `paper_author_relation` VALUES (88, 23, 88);
INSERT INTO `paper_author_relation` VALUES (89, 24, 89);
INSERT INTO `paper_author_relation` VALUES (90, 24, 90);
INSERT INTO `paper_author_relation` VALUES (91, 24, 91);
INSERT INTO `paper_author_relation` VALUES (92, 25, 92);
INSERT INTO `paper_author_relation` VALUES (93, 25, 93);
INSERT INTO `paper_author_relation` VALUES (94, 25, 94);
INSERT INTO `paper_author_relation` VALUES (95, 26, 95);
INSERT INTO `paper_author_relation` VALUES (96, 26, 96);
INSERT INTO `paper_author_relation` VALUES (97, 26, 97);
INSERT INTO `paper_author_relation` VALUES (98, 27, 98);
INSERT INTO `paper_author_relation` VALUES (99, 27, 99);
INSERT INTO `paper_author_relation` VALUES (100, 27, 100);
INSERT INTO `paper_author_relation` VALUES (101, 27, 101);
INSERT INTO `paper_author_relation` VALUES (102, 27, 102);
INSERT INTO `paper_author_relation` VALUES (103, 27, 103);
INSERT INTO `paper_author_relation` VALUES (104, 27, 104);
INSERT INTO `paper_author_relation` VALUES (105, 27, 105);
INSERT INTO `paper_author_relation` VALUES (106, 27, 106);
INSERT INTO `paper_author_relation` VALUES (107, 28, 107);
INSERT INTO `paper_author_relation` VALUES (108, 28, 108);
INSERT INTO `paper_author_relation` VALUES (109, 28, 109);
INSERT INTO `paper_author_relation` VALUES (110, 28, 110);
INSERT INTO `paper_author_relation` VALUES (111, 28, 111);
INSERT INTO `paper_author_relation` VALUES (112, 29, 112);
INSERT INTO `paper_author_relation` VALUES (113, 29, 113);
INSERT INTO `paper_author_relation` VALUES (114, 29, 114);
INSERT INTO `paper_author_relation` VALUES (115, 29, 115);
INSERT INTO `paper_author_relation` VALUES (116, 29, 116);
INSERT INTO `paper_author_relation` VALUES (117, 29, 117);
INSERT INTO `paper_author_relation` VALUES (118, 29, 118);
INSERT INTO `paper_author_relation` VALUES (119, 30, 119);
INSERT INTO `paper_author_relation` VALUES (120, 30, 120);
INSERT INTO `paper_author_relation` VALUES (121, 30, 121);
INSERT INTO `paper_author_relation` VALUES (122, 30, 122);
INSERT INTO `paper_author_relation` VALUES (123, 30, 123);
INSERT INTO `paper_author_relation` VALUES (124, 30, 124);
INSERT INTO `paper_author_relation` VALUES (125, 30, 125);
INSERT INTO `paper_author_relation` VALUES (126, 31, 126);
INSERT INTO `paper_author_relation` VALUES (127, 31, 127);
INSERT INTO `paper_author_relation` VALUES (128, 31, 128);
INSERT INTO `paper_author_relation` VALUES (129, 31, 129);
INSERT INTO `paper_author_relation` VALUES (130, 31, 130);
INSERT INTO `paper_author_relation` VALUES (131, 31, 131);
INSERT INTO `paper_author_relation` VALUES (132, 32, 132);
INSERT INTO `paper_author_relation` VALUES (133, 32, 133);
INSERT INTO `paper_author_relation` VALUES (134, 32, 134);
INSERT INTO `paper_author_relation` VALUES (135, 32, 135);
INSERT INTO `paper_author_relation` VALUES (136, 32, 136);
INSERT INTO `paper_author_relation` VALUES (137, 32, 137);
INSERT INTO `paper_author_relation` VALUES (138, 33, 138);
INSERT INTO `paper_author_relation` VALUES (139, 33, 139);
INSERT INTO `paper_author_relation` VALUES (140, 33, 140);
INSERT INTO `paper_author_relation` VALUES (141, 33, 141);
INSERT INTO `paper_author_relation` VALUES (142, 33, 142);
INSERT INTO `paper_author_relation` VALUES (143, 33, 143);
INSERT INTO `paper_author_relation` VALUES (144, 34, 144);
INSERT INTO `paper_author_relation` VALUES (145, 34, 145);
INSERT INTO `paper_author_relation` VALUES (146, 34, 146);
INSERT INTO `paper_author_relation` VALUES (147, 34, 147);
INSERT INTO `paper_author_relation` VALUES (148, 34, 148);
INSERT INTO `paper_author_relation` VALUES (149, 35, 149);
INSERT INTO `paper_author_relation` VALUES (150, 35, 150);
INSERT INTO `paper_author_relation` VALUES (151, 35, 151);
INSERT INTO `paper_author_relation` VALUES (152, 36, 152);
INSERT INTO `paper_author_relation` VALUES (153, 36, 153);
INSERT INTO `paper_author_relation` VALUES (154, 36, 154);
INSERT INTO `paper_author_relation` VALUES (155, 36, 155);
INSERT INTO `paper_author_relation` VALUES (156, 36, 156);
INSERT INTO `paper_author_relation` VALUES (157, 36, 157);
INSERT INTO `paper_author_relation` VALUES (158, 37, 158);
INSERT INTO `paper_author_relation` VALUES (159, 37, 159);
INSERT INTO `paper_author_relation` VALUES (160, 37, 160);
INSERT INTO `paper_author_relation` VALUES (161, 37, 161);
INSERT INTO `paper_author_relation` VALUES (162, 37, 162);
INSERT INTO `paper_author_relation` VALUES (163, 38, 163);
INSERT INTO `paper_author_relation` VALUES (164, 38, 164);
INSERT INTO `paper_author_relation` VALUES (165, 39, 165);
INSERT INTO `paper_author_relation` VALUES (166, 39, 166);
INSERT INTO `paper_author_relation` VALUES (167, 39, 167);
INSERT INTO `paper_author_relation` VALUES (168, 39, 168);
INSERT INTO `paper_author_relation` VALUES (169, 39, 169);
INSERT INTO `paper_author_relation` VALUES (170, 40, 170);
INSERT INTO `paper_author_relation` VALUES (171, 40, 171);
INSERT INTO `paper_author_relation` VALUES (172, 40, 172);
INSERT INTO `paper_author_relation` VALUES (173, 40, 173);
INSERT INTO `paper_author_relation` VALUES (174, 40, 174);
INSERT INTO `paper_author_relation` VALUES (175, 40, 175);
INSERT INTO `paper_author_relation` VALUES (176, 41, 176);
INSERT INTO `paper_author_relation` VALUES (177, 41, 177);
INSERT INTO `paper_author_relation` VALUES (178, 41, 178);
INSERT INTO `paper_author_relation` VALUES (179, 41, 179);
INSERT INTO `paper_author_relation` VALUES (180, 42, 180);
INSERT INTO `paper_author_relation` VALUES (181, 42, 181);
INSERT INTO `paper_author_relation` VALUES (182, 42, 182);
INSERT INTO `paper_author_relation` VALUES (183, 43, 183);
INSERT INTO `paper_author_relation` VALUES (184, 43, 184);
INSERT INTO `paper_author_relation` VALUES (185, 43, 185);
INSERT INTO `paper_author_relation` VALUES (186, 44, 186);
INSERT INTO `paper_author_relation` VALUES (187, 44, 187);
INSERT INTO `paper_author_relation` VALUES (188, 44, 188);
INSERT INTO `paper_author_relation` VALUES (189, 44, 189);
INSERT INTO `paper_author_relation` VALUES (190, 44, 190);
INSERT INTO `paper_author_relation` VALUES (191, 44, 191);
INSERT INTO `paper_author_relation` VALUES (192, 45, 192);
INSERT INTO `paper_author_relation` VALUES (193, 45, 193);
INSERT INTO `paper_author_relation` VALUES (194, 45, 194);
INSERT INTO `paper_author_relation` VALUES (195, 45, 195);
INSERT INTO `paper_author_relation` VALUES (196, 45, 196);
INSERT INTO `paper_author_relation` VALUES (197, 45, 197);
INSERT INTO `paper_author_relation` VALUES (198, 46, 198);
INSERT INTO `paper_author_relation` VALUES (199, 46, 199);
INSERT INTO `paper_author_relation` VALUES (200, 46, 200);
INSERT INTO `paper_author_relation` VALUES (201, 46, 201);
INSERT INTO `paper_author_relation` VALUES (202, 46, 202);
INSERT INTO `paper_author_relation` VALUES (203, 46, 203);
INSERT INTO `paper_author_relation` VALUES (204, 46, 204);
INSERT INTO `paper_author_relation` VALUES (205, 47, 205);
INSERT INTO `paper_author_relation` VALUES (206, 47, 206);
INSERT INTO `paper_author_relation` VALUES (207, 47, 207);
INSERT INTO `paper_author_relation` VALUES (208, 47, 208);
INSERT INTO `paper_author_relation` VALUES (209, 48, 209);
INSERT INTO `paper_author_relation` VALUES (210, 48, 210);
INSERT INTO `paper_author_relation` VALUES (211, 48, 211);
INSERT INTO `paper_author_relation` VALUES (212, 48, 212);
INSERT INTO `paper_author_relation` VALUES (213, 48, 213);
INSERT INTO `paper_author_relation` VALUES (214, 49, 214);
INSERT INTO `paper_author_relation` VALUES (215, 49, 215);
INSERT INTO `paper_author_relation` VALUES (216, 49, 216);
INSERT INTO `paper_author_relation` VALUES (217, 49, 217);
INSERT INTO `paper_author_relation` VALUES (218, 49, 218);
INSERT INTO `paper_author_relation` VALUES (219, 50, 219);
INSERT INTO `paper_author_relation` VALUES (220, 50, 220);
INSERT INTO `paper_author_relation` VALUES (221, 51, 221);
INSERT INTO `paper_author_relation` VALUES (222, 51, 222);
INSERT INTO `paper_author_relation` VALUES (223, 51, 223);
INSERT INTO `paper_author_relation` VALUES (224, 51, 224);
INSERT INTO `paper_author_relation` VALUES (225, 51, 225);
INSERT INTO `paper_author_relation` VALUES (226, 52, 226);
INSERT INTO `paper_author_relation` VALUES (227, 52, 227);
INSERT INTO `paper_author_relation` VALUES (228, 52, 228);
INSERT INTO `paper_author_relation` VALUES (229, 52, 229);
INSERT INTO `paper_author_relation` VALUES (230, 52, 230);
INSERT INTO `paper_author_relation` VALUES (231, 53, 231);
INSERT INTO `paper_author_relation` VALUES (232, 53, 232);
INSERT INTO `paper_author_relation` VALUES (233, 53, 233);
INSERT INTO `paper_author_relation` VALUES (234, 53, 234);
INSERT INTO `paper_author_relation` VALUES (235, 53, 235);
INSERT INTO `paper_author_relation` VALUES (236, 53, 236);
INSERT INTO `paper_author_relation` VALUES (237, 53, 237);
INSERT INTO `paper_author_relation` VALUES (238, 54, 238);
INSERT INTO `paper_author_relation` VALUES (239, 54, 239);
INSERT INTO `paper_author_relation` VALUES (240, 54, 240);
INSERT INTO `paper_author_relation` VALUES (241, 55, 241);
INSERT INTO `paper_author_relation` VALUES (242, 55, 242);
INSERT INTO `paper_author_relation` VALUES (243, 55, 243);
INSERT INTO `paper_author_relation` VALUES (244, 55, 244);

-- ----------------------------
-- Table structure for paper_keyword_relation
-- ----------------------------
DROP TABLE IF EXISTS `paper_keyword_relation`;
CREATE TABLE `paper_keyword_relation`  (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) NOT NULL,
  `keyword_id` int(11) NOT NULL,
  PRIMARY KEY (`relation_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper_keyword_relation
-- ----------------------------
INSERT INTO `paper_keyword_relation` VALUES (1, 1, 1);
INSERT INTO `paper_keyword_relation` VALUES (2, 1, 2);
INSERT INTO `paper_keyword_relation` VALUES (3, 1, 3);
INSERT INTO `paper_keyword_relation` VALUES (4, 1, 4);
INSERT INTO `paper_keyword_relation` VALUES (5, 2, 5);
INSERT INTO `paper_keyword_relation` VALUES (6, 2, 6);
INSERT INTO `paper_keyword_relation` VALUES (7, 2, 7);
INSERT INTO `paper_keyword_relation` VALUES (8, 2, 8);
INSERT INTO `paper_keyword_relation` VALUES (9, 2, 9);
INSERT INTO `paper_keyword_relation` VALUES (10, 3, 10);
INSERT INTO `paper_keyword_relation` VALUES (11, 3, 11);
INSERT INTO `paper_keyword_relation` VALUES (12, 3, 12);
INSERT INTO `paper_keyword_relation` VALUES (13, 4, 13);
INSERT INTO `paper_keyword_relation` VALUES (14, 4, 14);
INSERT INTO `paper_keyword_relation` VALUES (15, 4, 15);
INSERT INTO `paper_keyword_relation` VALUES (16, 5, 16);
INSERT INTO `paper_keyword_relation` VALUES (17, 5, 17);
INSERT INTO `paper_keyword_relation` VALUES (18, 5, 18);
INSERT INTO `paper_keyword_relation` VALUES (19, 5, 19);
INSERT INTO `paper_keyword_relation` VALUES (20, 6, 20);
INSERT INTO `paper_keyword_relation` VALUES (21, 6, 21);
INSERT INTO `paper_keyword_relation` VALUES (22, 6, 22);
INSERT INTO `paper_keyword_relation` VALUES (23, 6, 23);
INSERT INTO `paper_keyword_relation` VALUES (24, 7, 24);
INSERT INTO `paper_keyword_relation` VALUES (25, 7, 25);
INSERT INTO `paper_keyword_relation` VALUES (26, 7, 26);
INSERT INTO `paper_keyword_relation` VALUES (27, 7, 27);
INSERT INTO `paper_keyword_relation` VALUES (28, 7, 28);
INSERT INTO `paper_keyword_relation` VALUES (29, 7, 29);
INSERT INTO `paper_keyword_relation` VALUES (30, 7, 30);
INSERT INTO `paper_keyword_relation` VALUES (31, 7, 31);
INSERT INTO `paper_keyword_relation` VALUES (32, 7, 32);
INSERT INTO `paper_keyword_relation` VALUES (33, 7, 33);
INSERT INTO `paper_keyword_relation` VALUES (34, 8, 34);
INSERT INTO `paper_keyword_relation` VALUES (35, 8, 35);
INSERT INTO `paper_keyword_relation` VALUES (36, 8, 36);
INSERT INTO `paper_keyword_relation` VALUES (37, 8, 37);
INSERT INTO `paper_keyword_relation` VALUES (38, 9, 38);
INSERT INTO `paper_keyword_relation` VALUES (39, 9, 39);
INSERT INTO `paper_keyword_relation` VALUES (40, 9, 40);
INSERT INTO `paper_keyword_relation` VALUES (41, 10, 41);
INSERT INTO `paper_keyword_relation` VALUES (42, 10, 42);
INSERT INTO `paper_keyword_relation` VALUES (43, 10, 43);
INSERT INTO `paper_keyword_relation` VALUES (44, 10, 44);
INSERT INTO `paper_keyword_relation` VALUES (45, 11, 45);
INSERT INTO `paper_keyword_relation` VALUES (46, 11, 46);
INSERT INTO `paper_keyword_relation` VALUES (47, 11, 47);
INSERT INTO `paper_keyword_relation` VALUES (48, 11, 48);
INSERT INTO `paper_keyword_relation` VALUES (49, 12, 49);
INSERT INTO `paper_keyword_relation` VALUES (50, 12, 50);
INSERT INTO `paper_keyword_relation` VALUES (51, 12, 51);
INSERT INTO `paper_keyword_relation` VALUES (52, 12, 52);
INSERT INTO `paper_keyword_relation` VALUES (53, 13, 53);
INSERT INTO `paper_keyword_relation` VALUES (54, 13, 54);
INSERT INTO `paper_keyword_relation` VALUES (55, 13, 55);
INSERT INTO `paper_keyword_relation` VALUES (56, 13, 56);
INSERT INTO `paper_keyword_relation` VALUES (57, 14, 57);
INSERT INTO `paper_keyword_relation` VALUES (58, 14, 58);
INSERT INTO `paper_keyword_relation` VALUES (59, 14, 59);
INSERT INTO `paper_keyword_relation` VALUES (60, 15, 60);
INSERT INTO `paper_keyword_relation` VALUES (61, 15, 61);
INSERT INTO `paper_keyword_relation` VALUES (62, 15, 62);
INSERT INTO `paper_keyword_relation` VALUES (63, 15, 63);
INSERT INTO `paper_keyword_relation` VALUES (64, 15, 64);
INSERT INTO `paper_keyword_relation` VALUES (65, 16, 65);
INSERT INTO `paper_keyword_relation` VALUES (66, 16, 66);
INSERT INTO `paper_keyword_relation` VALUES (67, 16, 67);
INSERT INTO `paper_keyword_relation` VALUES (68, 17, 68);
INSERT INTO `paper_keyword_relation` VALUES (69, 17, 69);
INSERT INTO `paper_keyword_relation` VALUES (70, 17, 70);
INSERT INTO `paper_keyword_relation` VALUES (71, 17, 71);
INSERT INTO `paper_keyword_relation` VALUES (72, 18, 72);
INSERT INTO `paper_keyword_relation` VALUES (73, 18, 73);
INSERT INTO `paper_keyword_relation` VALUES (74, 18, 74);
INSERT INTO `paper_keyword_relation` VALUES (75, 18, 75);
INSERT INTO `paper_keyword_relation` VALUES (76, 19, 76);
INSERT INTO `paper_keyword_relation` VALUES (77, 19, 77);
INSERT INTO `paper_keyword_relation` VALUES (78, 19, 78);
INSERT INTO `paper_keyword_relation` VALUES (79, 20, 79);
INSERT INTO `paper_keyword_relation` VALUES (80, 20, 80);
INSERT INTO `paper_keyword_relation` VALUES (81, 20, 81);
INSERT INTO `paper_keyword_relation` VALUES (82, 20, 82);
INSERT INTO `paper_keyword_relation` VALUES (83, 21, 83);
INSERT INTO `paper_keyword_relation` VALUES (84, 21, 84);
INSERT INTO `paper_keyword_relation` VALUES (85, 21, 85);
INSERT INTO `paper_keyword_relation` VALUES (86, 22, 86);
INSERT INTO `paper_keyword_relation` VALUES (87, 22, 87);
INSERT INTO `paper_keyword_relation` VALUES (88, 22, 88);
INSERT INTO `paper_keyword_relation` VALUES (89, 22, 89);
INSERT INTO `paper_keyword_relation` VALUES (90, 23, 90);
INSERT INTO `paper_keyword_relation` VALUES (91, 23, 91);
INSERT INTO `paper_keyword_relation` VALUES (92, 23, 92);
INSERT INTO `paper_keyword_relation` VALUES (93, 24, 93);
INSERT INTO `paper_keyword_relation` VALUES (94, 24, 94);
INSERT INTO `paper_keyword_relation` VALUES (95, 24, 95);
INSERT INTO `paper_keyword_relation` VALUES (96, 24, 96);
INSERT INTO `paper_keyword_relation` VALUES (97, 24, 97);
INSERT INTO `paper_keyword_relation` VALUES (98, 25, 98);
INSERT INTO `paper_keyword_relation` VALUES (99, 25, 99);
INSERT INTO `paper_keyword_relation` VALUES (100, 25, 100);
INSERT INTO `paper_keyword_relation` VALUES (101, 26, 101);
INSERT INTO `paper_keyword_relation` VALUES (102, 26, 102);
INSERT INTO `paper_keyword_relation` VALUES (103, 26, 103);
INSERT INTO `paper_keyword_relation` VALUES (104, 26, 104);
INSERT INTO `paper_keyword_relation` VALUES (105, 26, 105);
INSERT INTO `paper_keyword_relation` VALUES (106, 27, 106);
INSERT INTO `paper_keyword_relation` VALUES (107, 27, 107);
INSERT INTO `paper_keyword_relation` VALUES (108, 27, 108);
INSERT INTO `paper_keyword_relation` VALUES (109, 27, 109);
INSERT INTO `paper_keyword_relation` VALUES (110, 28, 110);
INSERT INTO `paper_keyword_relation` VALUES (111, 28, 111);
INSERT INTO `paper_keyword_relation` VALUES (112, 28, 112);
INSERT INTO `paper_keyword_relation` VALUES (113, 28, 113);
INSERT INTO `paper_keyword_relation` VALUES (114, 28, 114);
INSERT INTO `paper_keyword_relation` VALUES (115, 29, 115);
INSERT INTO `paper_keyword_relation` VALUES (116, 29, 116);
INSERT INTO `paper_keyword_relation` VALUES (117, 29, 117);
INSERT INTO `paper_keyword_relation` VALUES (118, 29, 118);
INSERT INTO `paper_keyword_relation` VALUES (119, 29, 119);
INSERT INTO `paper_keyword_relation` VALUES (120, 30, 120);
INSERT INTO `paper_keyword_relation` VALUES (121, 30, 121);
INSERT INTO `paper_keyword_relation` VALUES (122, 30, 122);
INSERT INTO `paper_keyword_relation` VALUES (123, 30, 123);
INSERT INTO `paper_keyword_relation` VALUES (124, 31, 124);
INSERT INTO `paper_keyword_relation` VALUES (125, 31, 125);
INSERT INTO `paper_keyword_relation` VALUES (126, 31, 126);
INSERT INTO `paper_keyword_relation` VALUES (127, 32, 127);
INSERT INTO `paper_keyword_relation` VALUES (128, 32, 128);
INSERT INTO `paper_keyword_relation` VALUES (129, 32, 129);
INSERT INTO `paper_keyword_relation` VALUES (130, 32, 130);
INSERT INTO `paper_keyword_relation` VALUES (131, 32, 131);
INSERT INTO `paper_keyword_relation` VALUES (132, 33, 132);
INSERT INTO `paper_keyword_relation` VALUES (133, 33, 133);
INSERT INTO `paper_keyword_relation` VALUES (134, 33, 134);
INSERT INTO `paper_keyword_relation` VALUES (135, 34, 135);
INSERT INTO `paper_keyword_relation` VALUES (136, 34, 136);
INSERT INTO `paper_keyword_relation` VALUES (137, 34, 137);
INSERT INTO `paper_keyword_relation` VALUES (138, 35, 138);
INSERT INTO `paper_keyword_relation` VALUES (139, 35, 139);
INSERT INTO `paper_keyword_relation` VALUES (140, 35, 140);
INSERT INTO `paper_keyword_relation` VALUES (141, 35, 141);
INSERT INTO `paper_keyword_relation` VALUES (142, 36, 142);
INSERT INTO `paper_keyword_relation` VALUES (143, 36, 143);
INSERT INTO `paper_keyword_relation` VALUES (144, 36, 144);
INSERT INTO `paper_keyword_relation` VALUES (145, 37, 145);
INSERT INTO `paper_keyword_relation` VALUES (146, 37, 146);
INSERT INTO `paper_keyword_relation` VALUES (147, 37, 147);
INSERT INTO `paper_keyword_relation` VALUES (148, 37, 148);
INSERT INTO `paper_keyword_relation` VALUES (149, 37, 149);
INSERT INTO `paper_keyword_relation` VALUES (150, 38, 150);
INSERT INTO `paper_keyword_relation` VALUES (151, 38, 151);
INSERT INTO `paper_keyword_relation` VALUES (152, 38, 152);
INSERT INTO `paper_keyword_relation` VALUES (153, 39, 153);
INSERT INTO `paper_keyword_relation` VALUES (154, 39, 154);
INSERT INTO `paper_keyword_relation` VALUES (155, 39, 155);
INSERT INTO `paper_keyword_relation` VALUES (156, 40, 156);
INSERT INTO `paper_keyword_relation` VALUES (157, 40, 157);
INSERT INTO `paper_keyword_relation` VALUES (158, 40, 158);
INSERT INTO `paper_keyword_relation` VALUES (159, 40, 159);
INSERT INTO `paper_keyword_relation` VALUES (160, 40, 160);
INSERT INTO `paper_keyword_relation` VALUES (161, 40, 161);
INSERT INTO `paper_keyword_relation` VALUES (162, 41, 162);
INSERT INTO `paper_keyword_relation` VALUES (163, 41, 163);
INSERT INTO `paper_keyword_relation` VALUES (164, 41, 164);
INSERT INTO `paper_keyword_relation` VALUES (165, 42, 165);
INSERT INTO `paper_keyword_relation` VALUES (166, 42, 166);
INSERT INTO `paper_keyword_relation` VALUES (167, 42, 167);
INSERT INTO `paper_keyword_relation` VALUES (168, 42, 168);
INSERT INTO `paper_keyword_relation` VALUES (169, 43, 169);
INSERT INTO `paper_keyword_relation` VALUES (170, 43, 170);
INSERT INTO `paper_keyword_relation` VALUES (171, 43, 171);
INSERT INTO `paper_keyword_relation` VALUES (172, 44, 172);
INSERT INTO `paper_keyword_relation` VALUES (173, 44, 173);
INSERT INTO `paper_keyword_relation` VALUES (174, 44, 174);
INSERT INTO `paper_keyword_relation` VALUES (175, 45, 175);
INSERT INTO `paper_keyword_relation` VALUES (176, 45, 176);
INSERT INTO `paper_keyword_relation` VALUES (177, 45, 177);
INSERT INTO `paper_keyword_relation` VALUES (178, 45, 178);
INSERT INTO `paper_keyword_relation` VALUES (179, 46, 179);
INSERT INTO `paper_keyword_relation` VALUES (180, 46, 180);
INSERT INTO `paper_keyword_relation` VALUES (181, 46, 181);
INSERT INTO `paper_keyword_relation` VALUES (182, 47, 182);
INSERT INTO `paper_keyword_relation` VALUES (183, 47, 183);
INSERT INTO `paper_keyword_relation` VALUES (184, 47, 184);
INSERT INTO `paper_keyword_relation` VALUES (185, 47, 185);
INSERT INTO `paper_keyword_relation` VALUES (186, 48, 186);
INSERT INTO `paper_keyword_relation` VALUES (187, 48, 187);
INSERT INTO `paper_keyword_relation` VALUES (188, 48, 188);
INSERT INTO `paper_keyword_relation` VALUES (189, 48, 189);
INSERT INTO `paper_keyword_relation` VALUES (190, 49, 190);
INSERT INTO `paper_keyword_relation` VALUES (191, 49, 191);
INSERT INTO `paper_keyword_relation` VALUES (192, 49, 192);
INSERT INTO `paper_keyword_relation` VALUES (193, 49, 193);
INSERT INTO `paper_keyword_relation` VALUES (194, 50, 194);
INSERT INTO `paper_keyword_relation` VALUES (195, 50, 195);
INSERT INTO `paper_keyword_relation` VALUES (196, 50, 196);
INSERT INTO `paper_keyword_relation` VALUES (197, 51, 197);
INSERT INTO `paper_keyword_relation` VALUES (198, 51, 198);
INSERT INTO `paper_keyword_relation` VALUES (199, 51, 199);
INSERT INTO `paper_keyword_relation` VALUES (200, 51, 200);
INSERT INTO `paper_keyword_relation` VALUES (201, 51, 201);
INSERT INTO `paper_keyword_relation` VALUES (202, 52, 202);
INSERT INTO `paper_keyword_relation` VALUES (203, 52, 203);
INSERT INTO `paper_keyword_relation` VALUES (204, 52, 204);
INSERT INTO `paper_keyword_relation` VALUES (205, 52, 205);
INSERT INTO `paper_keyword_relation` VALUES (206, 53, 206);
INSERT INTO `paper_keyword_relation` VALUES (207, 53, 207);
INSERT INTO `paper_keyword_relation` VALUES (208, 53, 208);
INSERT INTO `paper_keyword_relation` VALUES (209, 54, 209);
INSERT INTO `paper_keyword_relation` VALUES (210, 54, 210);
INSERT INTO `paper_keyword_relation` VALUES (211, 54, 211);
INSERT INTO `paper_keyword_relation` VALUES (212, 55, 212);
INSERT INTO `paper_keyword_relation` VALUES (213, 55, 213);
INSERT INTO `paper_keyword_relation` VALUES (214, 55, 214);

-- ----------------------------
-- Table structure for publication
-- ----------------------------
DROP TABLE IF EXISTS `publication`;
CREATE TABLE `publication`  (
  `publication_id` int(11) NOT NULL AUTO_INCREMENT,
  `pubication` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `shortname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`publication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
