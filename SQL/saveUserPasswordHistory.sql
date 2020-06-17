CREATE DEFINER=`CSCI5308_4_DEVINT_USER`@`%` PROCEDURE `saveUserPasswordHistory`(
    IN banner varchar(20)
    )
BEGIN
SELECT id,password 
	INTO @userID,@pass
    FROM User 
    where bannerID=banner;
    

INSERT INTO UserAuthHistory 
(
`uId`,
`password`,
`time`)
VALUES
(@userID,@pass,now());


END