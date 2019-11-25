GRANT ALL PRIVILEGES ON grocerymanagementapp.* TO 'groot'@'localhost';
USE grocerymanagementapp;
CREATE TABLE ITEM(
    id INT NOT NULL auto_increment, 
    name VARCHAR(50) NOT NULL,
    expiry VARCHAR(30),
    PRIMARY KEY (id)
);