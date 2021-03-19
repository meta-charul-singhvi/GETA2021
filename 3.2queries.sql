/*
Assignment 2:
Write SQL scripts for the following:
1. Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
2. Display Count of products as per below price range:
    Range in Rs.
    Count
    0 - 1000     1001 - 5000       Above 5000
3. Display the Categories along with number of products under each category.
*/

-- 1.
SELECT id as 'Product Id', title as 'Title', COUNT(category_id) as 'Count of Categories' FROM product 
group by title having COUNT(category_id) > 1;

-- 2.
SELECT id as 'Product Id', title as 'Title', COUNT(id) as 'Count of Products, Price Range 0-1000' FROM product 
WHERE price < 1000;
SELECT id as 'Product Id', title as 'Title', COUNT(id) as 'Count of Products, Price Range 1001-5000' FROM product 
WHERE price <= 5000 and price > 1000;
SELECT id as 'Product Id', title as 'Title', COUNT(id) as 'Count of Products, Price Range 5001-20000' FROM product 
WHERE price > 5000;

-- 3.
SELECT id as 'Product Id', title as 'Category Title', COUNT(id) as 'Count of Product' FROM product 
group by title;

