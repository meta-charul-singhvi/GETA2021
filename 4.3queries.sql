/*
Assignment 3:
1. Identify the columns require indexing in order, product, category tables and create indexes.

The columns that require indexing in 

Order Table are:
    Id and userId as they are feequently used to access dataproduct

Product Table :
    Id, category_id, title are the columns require indexing
    
Category Table:
    Id, parentCategoryTitle are the columns that require indexing
*/

CREATE INDEX order_index ON `order` (id , userId);

CREATE INDEX product_index ON product (id , category_id, title);

CREATE INDEX category_index ON category (id , parentCategoryTitle) USING hash;
DROP INDEX category_index ON category;
