/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jesper
 * Created: 19-02-2019
 */

INSERT INTO BOOK (TITLE) VALUES ('book-3');
SET @book1 = LAST_INSERT_ID();
INSERT INTO BOOK (TITLE) VALUES ('book-4');
SET @book2 = LAST_INSERT_ID();

INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, CUSTOMERTYPE) VALUES ('Jesper', 'Christensen', 'GOLD');
SET @customer1 = LAST_INSERT_ID();
INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, CUSTOMERTYPE) VALUES ('Jens', 'Christensen', 'RUSTY');
SET @customer2 = LAST_INSERT_ID();

