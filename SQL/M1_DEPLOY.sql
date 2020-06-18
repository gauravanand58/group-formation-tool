CREATE TABLE `Course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `User` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bannerID` varchar(20) NOT NULL,
  `password` varchar(76) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `CourseRole` (
  `courseID` bigint(20) NOT NULL,
  `roleID` bigint(20) NOT NULL,
  `userID` bigint(20) NOT NULL,
  PRIMARY KEY (`courseID`,`roleID`,`userID`),
  KEY `roleID` (`roleID`),
  KEY `userID` (`userID`),
  CONSTRAINT `CourseRole_ibfk_1` FOREIGN KEY (`courseID`) REFERENCES `Course` (`id`),
  CONSTRAINT `CourseRole_ibfk_2` FOREIGN KEY (`roleID`) REFERENCES `Role` (`id`),
  CONSTRAINT `CourseRole_ibfk_3` FOREIGN KEY (`userID`) REFERENCES `User` (`id`)
);

CREATE TABLE `QuestionSet` (
  `questionId` bigint(20) NOT NULL AUTO_INCREMENT,
  `id` bigint(20) DEFAULT NULL,
  `questionTitle` varchar(30) DEFAULT NULL,
  `questionHeading` varchar(50) DEFAULT NULL,
  `questionType` varchar(10) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  PRIMARY KEY (`questionId`),
  KEY `id` (`id`),
  CONSTRAINT `QuestionSet_ibfk_1` FOREIGN KEY (`id`) REFERENCES `User` (`id`)
);

CREATE TABLE `PasswordConfiguration` (
  `maxLen` int(11) DEFAULT NULL,
  `minLen` int(11) DEFAULT NULL,
  `minUpperChar` int(11) DEFAULT NULL,
  `minLowerChar` int(11) DEFAULT NULL,
  `minSplChar` int(11) DEFAULT NULL,
  `notAllowedChar` varchar(45) DEFAULT NULL,
  `isPasswordPolicySet` tinyint(1) DEFAULT NULL,
  `passwordHistoryCount` int(11) DEFAULT NULL
);

CREATE TABLE `QuestionOptions` (
  `questionId` bigint(20) DEFAULT NULL,
  `optionId` int(4) NOT NULL AUTO_INCREMENT,
  `optionText` varchar(50) DEFAULT NULL,
  `optionScore` int(4) DEFAULT NULL,
  PRIMARY KEY (`optionId`),
  KEY `questionId` (`questionId`),
  CONSTRAINT `QuestionOptions_ibfk_1` FOREIGN KEY (`questionId`) REFERENCES `QuestionSet` (`questionId`)
);

CREATE TABLE `Response` (
  `responseId` bigint(20) NOT NULL,
  `responseText` varchar(200) DEFAULT NULL,
  `questionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`responseId`),
  KEY `fk_response_question` (`questionId`),
  CONSTRAINT `fk_response_question` FOREIGN KEY (`questionId`) REFERENCES `QuestionSet` (`questionId`)
);



CREATE TABLE `SystemRole` (
  `roleID` bigint(20) NOT NULL,
  `userID` bigint(20) NOT NULL,
  PRIMARY KEY (`roleID`,`userID`),
  KEY `userID` (`userID`),
  CONSTRAINT `SystemRole_ibfk_1` FOREIGN KEY (`roleID`) REFERENCES `Role` (`id`),
  CONSTRAINT `SystemRole_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `User` (`id`)
);

CREATE TABLE `UserAuthHistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uId` bigint(20) NOT NULL,
  `password` varchar(76) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_IDFK_idx` (`uId`),
  CONSTRAINT `user_IDFK` FOREIGN KEY (`uId`) REFERENCES `User` (`id`)
);

CREATE TABLE `UserContactInfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userID` bigint(20) NOT NULL,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `email` varchar(320) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userID` (`userID`),
  CONSTRAINT `UserContactInfo_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `User` (`id`)
);

INSERT INTO Role(role)
VALUES
    ('Admin'),
	('Guest'),
    ('Student'),
    ('Instructor'),
    ('TA');

/*
	This is not how you would do this in the real world, it would not be safe to have passwords
    or accounts stored in files in git.  This creates the admin user with an empty password.
*/
INSERT INTO User(bannerID, password)
VALUES ('B-000000', '1234');

SELECT LAST_INSERT_ID()
INTO @adminID;

INSERT INTO UserContactInfo(userID, firstName, lastName, email)
VALUES (@adminID, 'Rob', 'Hawkey', 'rhawkey@dal.ca');

SELECT id
INTO @adminRoleID
FROM Role
WHERE role = 'Admin';

INSERT INTO SystemRole(roleID, userID)
VALUES (@adminRoleID, @adminID);

SELECT * FROM Role;
SELECT * FROM User;