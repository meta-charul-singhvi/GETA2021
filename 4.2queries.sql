/*
Assignment 2:
1. Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be 
input parameter to function.
2. Create a stored procedure to retrieve table having order detail with status for a given period. Start 
date and end date will be input parameter. Put validation on input dates like start date is less than 
end date. If start date is greater than end date take first date of month as start date.
*/

-- 1.
DELIMITER //
CREATE PROCEDURE salesPerMonth (IN month INT,IN year INT)
BEGIN
SELECT monthname(createdAt) as 'Month',AVG(price) as 'Average Price',quantity,Count(*) as'Product count' 
FROM order_item 
WHERE month(createdAt)=month AND year(createdAt)=year;
END //
DELIMITER ;

call salesPerMonth(3,2021);

-- 2.
DELIMITER //
CREATE PROCEDURE ordersPerPeriod (IN start_date date, IN end_date date)
BEGIN

    SET start_date = IF(start_date < end_date, start_date, DATE_SUB(start_date, INTERVAL DAY(start_date)-1 DAY));

    SELECT o.id as 'Order Id', o.userId, o.createdAt as 'Order Date', o.total as 'Order Amount',
    CONCAT(s.line1,',',s.line2,',',s.city,',',s.province,',',s.country) AS Shipping_Address,
    os.status 
    from `order` o
    JOIN shipping_address s
    ON s.id = o.addressId
    JOIN order_status os
    ON o.status = os.id
    WHERE createdAt BETWEEN start_date AND end_date;

END //
DELIMITER ;

-- calling procedure with correct input data
call ordersPerPeriod('2021-03-01', '2021-04-01');
-- calling procedure with where start date is less then end date
call ordersPerPeriod('2021-03-15', '2021-03-10');