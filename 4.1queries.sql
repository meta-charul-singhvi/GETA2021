/*
Assignment 1:
1. Create a function to calculate number of orders in a month. Month and year will be input parameter to 
function.
2. Create a function to return month in a year having maximum orders. Year will be input parameter.
*/

-- 1.
DELIMITER $$
CREATE FUNCTION getOrdersCountPerMonth(
    month INT,
    year INT
) 
RETURNS INT
DETERMINISTIC

BEGIN
    DECLARE numberOfOrders INT;
    SET numberOfOrders = (SELECT COUNT(id) FROM `order` WHERE Month(createdAt)=month AND 
    Year(createdAt)=year);
    RETURN numberOfOrders;
END $$

DELIMITER ;

SELECT getOrdersCountPerMonth(03,2021) as 'Order Count';


-- 2.
DELIMITER $$

CREATE FUNCTION getMaximumOrderMonth(year INT)
    RETURNS VARCHAR(10)
    DETERMINISTIC

BEGIN
    DECLARE monthOfMaximumOrders VARCHAR(10);
    SET monthOfMaximumOrders =  ( SELECT MONTHNAME(createdAt)
    FROM `order`
    WHERE YEAR(createdAt) = year 
    GROUP BY month(createdAt)
    ORDER BY COUNT(month(createdAt)) DESC LIMIT 1);
                
    RETURN monthOfMaximumOrders;
END $$

DELIMITER ;

SELECT getMaximumOrderMonth(2021);


