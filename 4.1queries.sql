/*
Assignment 1:
1. Create a function to calculate number of orders in a month. Month and year will be input parameter to 
function.
2. Create a function to return month in a year having maximum orders. Year will be input parameter.
*/

-- 1.
SELECT year(createdAt) as 'Year of Order', month(createdAt) as 'Month of Order', COUNT(month(createdAt)) 
as 'Order count / Month' FROM `order`
GROUP BY month(createdAt);

-- 2.
CREATE FUNCTION maximum_orders_per_month (
@year1 int =2021)
RETURNS int AS
BEGIN
    DECLARE @month int;
    SELECT @month = month(createdAt), createdAt
    FROM `order`
    GROUP BY month(createdAt)
    HAVING year(createdAt) = year1 
    ORDER BY COUNT(month(createdAt)) DESC LIMIT 1;
    RETURN @month;
END;
