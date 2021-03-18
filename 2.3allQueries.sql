/*
1. Display Recent 50 Orders placed (Id, Order Date, Order Total).
2. Display 10 most expensive Orders.
3. Display all the Orders which are placed more than 10 days old and one or more items from those orders 
    are still not shipped.
4. Display list of shoppers which haven't ordered anything since last month.
5. Display list of shopper along with orders placed by them in last 15 days. 
6. Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
7. Display list of order items along with order placed date which fall between Rs 500 to Rs 1000 price.
*/

-- 1.
SELECT id as 'Order Id', createdAt as 'Order Date', total as 'Order Total' FROM `order` 
order by createdAt desc LIMIT 50;

-- 2.
SELECT id as 'Order Id', createdAt as 'Order Date', total as 'Order Total' FROM `order` 
order by total desc LIMIT 10;

-- 3.
SELECT id as 'Order Id', createdAt as 'Order Date', total as 'Order Total' FROM `order` 
WHERE current_timestamp - createdAt >=10 and status < 5;

-- 4.
SELECT user.id as 'Shopper Id', createdAt as 'Order Date', CONCAT(`order`.firstName, `order`.lastName) as 'Name' from user 
LEFT JOIN `order` ON user.id = `order`.userId
WHERE shopper=1 and current_timestamp > createdAt + 0000-01-00 ;

-- 5.
SELECT `order`.userId as 'Shopper Id', `order`.id as 'Order Id', createdAt as 'Order Date', CONCAT(`order`.firstName, `order`.lastName) as 'Shopper Name' from `order` 
WHERE current_timestamp > createdAt + 0000-00-15 ;

-- 6.
SELECT order_item.orderId as 'Order Id', CONCAT(`order`.firstName, `order`.lastName) as 'Shopper Name', total as 'Total' from order_item 
JOIN `order` ON order_item.orderId = `order`.id
WHERE order_status=5 and orderId=7;

-- 7.
SELECT order_item.orderId as 'Order Id', CONCAT(`order`.firstName, `order`.lastName) as 'Shopper Name',price as 'Price', quantity as 'Quantity', `order`.discount as 'Discount', total as 'Total', `order`.createdAt as 'Order Place Date' from order_item 
JOIN `order` ON order_item.orderId = `order`.id
WHERE price>500 and price<1000;