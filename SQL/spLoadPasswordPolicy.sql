DELIMITER $$
DROP procedure IF EXISTS spLoadPasswordPolicy;

CREATE PROCEDURE spLoadPasswordPolicy ()
BEGIN
select * 
from PasswordConfiguration 
where isPasswordPolicySet=1;
END $$

DELIMITER ;

