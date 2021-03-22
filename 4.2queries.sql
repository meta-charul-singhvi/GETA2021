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
CREATE PROCEDURE salesPerMonth ()
BEGIN
SELECT AVG(price) as 'Average Price',quantity,month(createdAt) as 'Month',Count(*) as'Product count' FROM order_item 
WHERE month(createdAt)=3 AND year(createdAt)=2021;
END //
DELIMITER ;

call salesPerMonth();

-- 2.
DELIMITER //
CREATE PROCEDURE ordersPerPeriod (@startDate varchar(10), @endDate varchar(10))
BEGIN
IF EXISTS(@startDate < @endDate)
    SELECT * from `order` WHERE createdAt>=@startDate AND createdAt<@endDate;
ELSE
    SELECT * from order_item WHERE createdAt>=(
    select CAST(CAST(YEAR(@startDate) AS VARCHAR(4)) 
    + '/' + CAST(MONTH(@startDate) AS VARCHAR(2)) + '/01' AS DATETIME)
    ) AND createdAt<@endDate ;
END //
DELIMITER ;

call ordersPerPeriod('2021-03-01', '2021-04-01');