/*
1. Given the id of a user, fetch all orders (Id, Order Date, Order Total) of that user which are in 
    shipped state. Orders should be sorted by order date column in chronological order.
2. Insert five or more images of a product using batch insert technique.
3. Delete all those products which were not ordered by any Shopper in last 1 year. Return the number of
    products deleted.
4. Select and display the category title of all top parent categories sorted alphabetically and the 
    count of their child categories.
*/

-- 1.
SELECT `order`.id, createdAt, total FROM `order`
JOIN user ON user.id = `order`.userId
WHERE userId = 2 AND shopper=1
order by createdAt desc;

-- 2.
CREATE TABLE `product_image`(
    imageId INT NOT NULL AUTO_INCREMENT,
    image LONGBLOB NOT NULL,
    PRIMARY KEY (`imageId`)
);

INSERT INTO `e_store`.`product_image` (`image`) VALUES
(load_file('C:/Users/charul.singhvi_metac/Downloads/ER Diagram_old.png')),
(load_file('C:/Users/charul.singhvi_metac/Downloads/shoes1.jpg')),
(load_file('C:/Users/charul.singhvi_metac/Downloads/shoes2.jfif')),
(load_file('C:/Users/charul.singhvi_metac/Downloads/shoes3.jfif'));

SELECT * FROM product_image;

-- 3.
SELECT COUNT(*) FROM product
WHERE product.id IN
(SELECT order_item.id FROM order_item
WHERE year(order_item.createdAt) < year(NOW() - INTERVAL 1 YEAR));

DELETE product.id FROM product
WHERE NOT EXISTS
(   SELECT * FROM product
    WHERE product.id IN
    (SELECT order_item.id FROM order_item
    WHERE year(order_item.createdAt) < year(NOW() - INTERVAL 1 YEAR))
);

-- 4.
SELECT c1.parentCategoryTitle, COUNT(c1.title) as 'Count of Child Category' FROM Category c1 
JOIN category c2 ON c1.parentCategoryTitle = c2.title
GROUP BY c1.parentCategoryTitle
HAVING c1.parentCategoryTitle IN
(SELECT title FROM Category WHERE parentId =0);

