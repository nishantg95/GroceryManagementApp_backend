GRANT ALL PRIVILEGES ON grocerymanagementapp.* TO 'groot'@'localhost';
USE grocerymanagementapp;
CREATE TABLE ITEM(
    id INT NOT NULL auto_increment, 
    name VARCHAR(50) NOT NULL,
    expiry VARCHAR(30),
    PRIMARY KEY (id)
);

--------------------------------------------------

ALTER TABLE grocerymanagementapp.item
ADD date_today DATE;
--------------------------------------------------
ALTER TABLE grocerymanagementapp.item MODIFY COLUMN date_today DATE NOT NULL;

-------------------------------------------------
ALTER TABLE `grocerymanagementapp`.`item` 
CHANGE COLUMN `date_today` `purchase_date` DATE NOT NULL ;


---------------------------------------------------

CREATE TABLE `grocerymanagementapp`.`repository_items` (
  `rItemId` INT NOT NULL,
  `rtemName` VARCHAR(45) NOT NULL,
  `rDate_U_P` VARCHAR(45) NULL COMMENT 'Repository Item\'s UNOPENED PANTRY date',
  `rDate_O_P` VARCHAR(45) NULL COMMENT 'Repository Item\'s OPENED PANTRY date',
  `rDate_U_F` VARCHAR(45) NULL COMMENT 'Repository Item\'s UNOPENED Freezer date',
  `rDate_O_F` VARCHAR(45) NULL COMMENT 'Repository Item\'s OPENED Freezer date',
  `rDate_U_R` VARCHAR(45) NULL COMMENT 'Repository Item\'s UNOPENED REFRIGERATED date',
  `rDate_O_R` VARCHAR(45) NULL COMMENT 'Repository Item\'s OPENED REFRIGERATED date',
  PRIMARY KEY (`rItemId`));