/*
1. Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, 
Status) with latest ordered items should be displayed first for last 60 days.
2. Use the above view to display the Products(Items) which are in ‘shipped’ state.
3. Use the above view to display the top 5 most selling products.
*/

-- 1.
CREATE OR REPLACE VIEW order_information AS
SELECT DISTINCT `order`.id as 'Id', product.title as 'Title', `order_item`.price as 'Price', CONCAT(firstName, lastName) as 
'Shoppers Name', email as 'Email' , `order`.createdAt as 'Order Date', order_status.status as 'Status' FROM `order`
JOIN order_item on `order`.id = order_item.orderId
JOIN product on order_item.productId = product.id
JOIN order_status on `order`.status = order_status.id
WHERE DATE(`order`.createdAt) > DATE(NOW() - INTERVAL 60 DAY)
ORDER BY `order`.createdAt desc;

SELECT * FROM order_information;

-- 2.
SELECT * FROM order_information WHERE Status='Shipped';

-- 3.
SELECT Title, COUNT(*) FROM order_information
GROUP BY Title
ORDER BY COUNT(Title) DESC LIMIT 5;