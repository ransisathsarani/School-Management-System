9

CREATE TABLE `activities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_reg_num` varchar(14) DEFAULT NULL,
  `sports` varchar(45) DEFAULT NULL,
  `clubs` varchar(45) DEFAULT NULL,
  `organizations` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 



CREATE TABLE `admin_staff` (
  `adminID` varchar(20) NOT NULL DEFAULT '',
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`adminID`)
) 

CREATE TABLE `enroll` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `regNo` varchar(50) DEFAULT NULL,
  `first_Name` varchar(50) DEFAULT NULL,
  `last_Name` varchar(50) DEFAULT NULL,
  `address1` varchar(50) DEFAULT NULL,
  `address2` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  `gender` char(50) DEFAULT NULL,
  `ethnicity` char(50) DEFAULT NULL,
  `pName` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `grade` varchar(20) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `level2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_reg_num` varchar(14) DEFAULT NULL,
  `option1` varchar(45) DEFAULT NULL,
  `option2` varchar(45) DEFAULT NULL,
  `option3` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

CREATE TABLE `level3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_reg_num` varchar(14) DEFAULT NULL,
  `stream` varchar(45) DEFAULT NULL,
  `subject1` varchar(45) DEFAULT NULL,
  `subject2` varchar(45) DEFAULT NULL,
  `subject3` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) delimiter $$

CREATE TABLE `student_001` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentNum` varchar(14) DEFAULT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `BOD` varchar(20) DEFAULT NULL,
  `number` varchar(40) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  `level` varchar(10) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 



CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subjectNum` varchar(14) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staffid` varchar(14) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `subjectNum` varchar(45) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

CREATE TABLE `timetable_001` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ttid` varchar(20) DEFAULT NULL,
  `subid_1` varchar(45) DEFAULT NULL,
  `time_1` varchar(45) DEFAULT NULL,
  `subid_2` varchar(45) DEFAULT NULL,
  `time_2` varchar(45) DEFAULT NULL,
  `subid_3` varchar(45) DEFAULT NULL,
  `time_3` varchar(45) DEFAULT NULL,
  `subid_4` varchar(45) DEFAULT NULL,
  `time_4` varchar(45) DEFAULT NULL,
  `subid_5` varchar(45) DEFAULT NULL,
  `time_5` varchar(45) DEFAULT NULL,
  `subid_6` varchar(45) DEFAULT NULL,
  `time_6` varchar(45) DEFAULT NULL,
  `subid_7` varchar(45) DEFAULT NULL,
  `time_7` varchar(45) DEFAULT NULL,
  `subid_8` varchar(45) DEFAULT NULL,
  `time_8` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

CREATE TABLE `user_validation` (
  `ID` varchar(10) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `userID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) 


CREATE TABLE `grading` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `SID` varchar(14) DEFAULT NULL,
  `level` varchar(45) DEFAULT NULL,
  `examID` varchar(45) DEFAULT NULL,
  `sub1` varchar(45) DEFAULT NULL,
  `sub2` varchar(45) DEFAULT NULL,
  `sub3` varchar(45) DEFAULT NULL,
  `sub4` varchar(45) DEFAULT NULL,
  `sub5` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 


CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(14) DEFAULT NULL,
  `classroom` varchar(45) DEFAULT NULL,
  `date` varchar(40) DEFAULT NULL,
  `present` varchar(14) DEFAULT NULL,
  `absent` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 




CREATE TABLE `account_monarch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(14) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `amount` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

