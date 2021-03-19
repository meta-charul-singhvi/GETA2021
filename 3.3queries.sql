/*
1. Display Shopper’s information along with number of orders he/she placed during last 30 days.
2. Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
3. Display top 20 Products which are ordered most in last 60 days along with numbers.
4. Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
5. Mark the products as Inactive which are not ordered in last 90 days.
6. Given a category search keyword, display all the Products present in this category/categories. 
7. Display top 10 Items which were cancelled most.
*/

-- 1.
SELECT user.id as 'Shopper Id', CONCAT(user.firstName,user.lastName) as 'Shooper Name' , COUNT(`order`.id) as 'Count of Orders' 
FROM user JOIN `order` on user.id = `order`.userId
WHERE shopper=1 and month(createdAt) > month(NOW() - INTERVAL 1 MONTH)
group by `order`.id;

-- 2. Maximum amount purchase data displaying
SELECT user.id as 'Shopper Id', CONCAT(user.firstName,user.lastName) as 'Shooper Name' , total as 'Bill Amount' 
FROM user JOIN `order` on user.id = `order`.userId
order by total desc LIMIT 10;

-- 3.
SELECT order_item.id as 'Order Item Id', order_item.productId, product.title as 'Product Name', count(productId) as 'Order Count of Product' FROM order_item 
JOIN product ON order_item.productId = product.id
WHERE day(createdAt) <= day(NOW() - INTERVAL 60 DAY)
group by productId order by count(productId) desc LIMIT 20;

-- 4.
SELECT  price , quantity, sum(total) as 'Sales Amount per Month', month(order_item.createdAt)  as 'Month'
FROM `order` join order_item ON order_item.orderId = `order`.id
group by month(order_item.createdAt);

-- 5.
UPDATE product
SET isActive = 0
WHERE (SELECT id FROM product) IN (SELECT product.id from product
LEFT JOIN order_item ON order_item.productId = product.id
WHERE day(createdAt) >= day(SYSDATE() - INTERVAL 90 DAY));

-- 6.
SELECT * FROM category WHERE
parentCategoryTitle = 'Western Wear';

-- 7.
SELECT * FROM order_item
WHERE order_status=4;