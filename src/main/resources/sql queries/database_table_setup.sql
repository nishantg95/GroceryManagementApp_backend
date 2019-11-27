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


