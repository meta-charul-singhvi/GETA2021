INSERT INTO `user` (`firstName`, `lastName`, `mobile`, `email`, `password`, `admin`, `shopper`, `registeredAt`) 
VALUES 
 ( 'Park', 'Jimin', '9867543212', 'jimin13@gmail.com', 'jimin', 1, 0, '2021-03-17'),
 ( 'Jeon', 'Jungkook', '8867543211', 'jk01@gmail.com', 'kookie', 0, 1, '2021-03-17'),
 ( 'Jung', 'Hoseok', '9917543204', 'hobi18@gmail.com', 'hobi', 0, 1, '2021-03-17'),
 ( 'Kim', 'Namjoon', '7867533210', 'rm12@gmail.com', 'rm', 1, 0, '2021-03-17'),
 ( 'Kim', 'Soekjin', '7767543662', 'jin04@gmail.com', 'jin', 0, 1, '2021-03-17'),
 ( 'Kim', 'Taehyung', '9867588904', 'tae12@gmail.com', 'tae', 0, 1, '2021-03-17'),
 ( 'Min', 'Yoongi', '7183643212', 'suga23@gmail.com', 'suga', 0, 1, '2021-03-17');

INSERT INTO `category` (`parentCategoryTitle`, `title`) VALUES 
('Top Category', 'Kids'),
('Top Category', 'Women'),
('Top Category', 'Men'),
('Top Category', 'Beauty & Personal Care'),
('Top Category', 'Gadgets'),
('Top Category', 'Home & Living'),
('Top Category', 'Season Special');

INSERT INTO `category` (`parentId`, `parentCategoryTitle`, `title`) VALUES 
(1, 'Kids', 'Clothing'),
(1, 'Kids', 'Footwear'),
(1, 'Kids', 'Toys'),
(2, 'Women', 'Western Wear'),
(2, 'Women', 'Ethnic Wear'),
(4, 'Women', 'Beauty & Personal Care'),
(3, 'Men', 'Footwear'),
(3, 'Men', 'Bags & Wallets'),
(3, 'Men', 'Sports & Activewear'),
(4, 'Beauty & Personal Care', 'Explore Beauty Store'),
(2, 'Beauty & Personal Care', 'Women'),
(3, 'Beauty & Personal Care', 'Men'),
(5, 'Gadgets', 'Smart Wearables'),
(5, 'Gadgets', 'Audio & Hearables'),
(5, 'Gadgets', 'Mobile Accessories'),
(6, 'Home & Living', 'Furnishing'),
(6, 'Home & Living', 'Kitchen & Dining'),
(6, 'Home & Living', 'Decor'),
(7, 'Season Special', 'Men'),
(7, 'Season Special', 'Women'),
(7, 'Season Special', 'Kids');

INSERT INTO `category` (`parentId`, `parentCategoryTitle`, `title`) VALUES 
(11, 'Western Wear', 'Dresses & Jumpsuits'),
(11, 'Western Wear', 'Tops, Tshirts & Shirts'),
(11, 'Western Wear', 'Jeans & Jeggings'),
(11, 'Western Wear', 'Jackets'),
(12, 'Ethnic Wear', 'Kurtas'),
(12, 'Ethnic Wear', 'Sarees'),
(12, 'Ethnic Wear', 'Lehenga Cholis'),
(12, 'Ethnic Wear', 'Ethnic Dresses'),
(24, 'Kitchen & Dining', 'Dinneerware'),
(24, 'Kitchen & Dining', 'Coasters'),
(24, 'Kitchen & Dining', 'Cups & Mugs'),
(20, 'Smart Wearables', 'Smart Watches'),
(20, 'Smart Wearables', 'Fitness Bands'),
(21, 'Audio & Hearables', 'Headphones'),
(21, 'Audio & Hearables', 'Speakers');


INSERT INTO `product` (`userId`, `title`, `category_id`, `discount`, `price`, `quantity`, `imagesCount`, `isActive`, `createdOn`) VALUES 
(2, 'Shopping1', 40, 1000, 9000, 50, 10, 1, '2021-03-17 02:34:00'),
(3, 'Shopping2', 36, 1500, 12000, 20, 6, 1, '2021-03-17 02:37:00'),
(5, 'Shopping3', 42, 200, 2000, 15, 4, 1, '2021-03-17 02:39:00'),
(6, 'Shopping4', 32, 50, 900, 10, 8, 1, '2021-03-17 02:41:00'),
(7, 'Shopping5', 38, 10, 150, 25, 3, 1, '2021-03-17 02:43:00');
UPDATE `product` SET `userId`=1, `description`='Smart Watches' WHERE `id`='1';
UPDATE `product` SET `userId`=1, `description`='Ethnic Dresses' WHERE `id`='2';
UPDATE `product` SET `userId`=1, `description`='Headphones' WHERE `id`='3';
UPDATE `product` SET `userId`=4, `description`='Jackets' WHERE `id`='4';
UPDATE `product` SET `userId`=4, `description`='Coasters' WHERE `id`='5';

INSERT INTO `product` (`userId`, `title`, `description`, `category_id`, `discount`, `price`, `quantity`, `imagesCount`, `isActive`, `createdOn`) VALUES 
(4, 'Shopping6', 'Lehenga Cholis', 35, 100, 7000, 22, 9, 1, '2021-03-17 02:47:00'),
(1, 'Shopping7', 'Speakers', 43, 50, 2000, 5, 5, 1, '2021-03-17 02:50:00');
UPDATE `e_store`.`product` SET `title`='Smart Watches', `description`='Shopping1' WHERE `id`='1';
UPDATE `e_store`.`product` SET `title`='Ethnic Dresses ', `description`='Shopping2' WHERE `id`='2';
UPDATE `e_store`.`product` SET `title`='Headphones', `description`='Shopping3' WHERE `id`='3';
UPDATE `e_store`.`product` SET `title`='Jackets', `description`='Shopping4' WHERE `id`='4';
UPDATE `e_store`.`product` SET `title`='Coasters', `description`='Shopping5' WHERE `id`='5';
UPDATE `e_store`.`product` SET `title`='Lehenga Cholis', `description`='Shopping6' WHERE `id`='6';
UPDATE `e_store`.`product` SET `title`='Speakers', `description`='Shopping7' WHERE `id`='7';


INSERT INTO `shipping_address` (`userId`, `line1`, `line2`, `city`, `province`, `country`) VALUES 
(2, '2 Moksh Marg', 'Shastri Circle', 'Udaipur', 'Rajasthan', 'India'),
(3, '334 sitaupra road', 'Bhupalpura', 'Jaipur', 'Rajasthan', 'India'),
(2, '30 Keshav Nagar', 'Hiran Magri', 'Udaipur', 'Rajasthan', 'US'),
(3, '119 Sambhal Complex', 'Tonk Road, Dahisar', 'Mumbai', 'Maharashtra', 'India'),
(5, '12 ghokha road', 'Ghantaghar', 'Shimla', 'Himachal Pradesh', 'India'),
(4, '15 DU road', 'Shastri Nagar', 'Delhi', 'Delhi', 'India'),
(6, 'Krishna vihar complex', 'Nehru Road', 'Jabalpur', 'UP', 'India'),
(1, '6 Durga Nursery', 'Opp. MLSU Garden', 'Sikar', 'Tamil Nadu', 'UK'),
(7, '99 Manglam Complex', 'Opp. Trade Park, Tonk Road', 'Katia', 'Karnataka', 'India');


INSERT INTO `login` (`username`, `password`) VALUES 
('jimin', '@parkMin'),
('kookie', '@rabbit'),
('jin', '@wwh'),
('namjoon', '@rapMonster'),
('tae', '@v'),
('suga', '@rap'),
('hobi', '@sunshine');


INSERT INTO `cart` (`userId`, `sessionId`, `status`, `firstName`, `lastName`, `mobile`, `email`, `addressId`, `createdAt`) VALUES 
(2, '1', 1, 'Jeon', 'Jungkook', '8867543211', 'jk01@gmail.com', 1, '2021-03-17 02:50:00'),
(5, '2', 1, 'Kim', 'Soekjin', '7767543662', 'jin04@gmail.com', 5, '2021-03-17 03:00:01'),
(7, '3', 1, 'Min', 'Yoongi', '7183643212', 'suga23@gmail.com', 9, '2021-03-17 03:07:00');


INSERT INTO `cart_item` (`productId`, `cartId`, `price`, `quantity`, `active`, `createdAt`) VALUES 
(1, 1, 9000, 25, 1, '2021-03-17 03:30:00'),
(4, 2, 900, 10, 1, '2021-03-17 03:45:00'),
(6, 3, 2000, 3, 1, '2021-03-17  03:50:00');

INSERT INTO `order` (`userId`, `sessionId`, `status`, `subTotal`, `itemDiscount`, `tax`, `promo`, `discount`, `addressId`, `createdAt`) VALUES 
(2, '1', 2, 225000, 1000, 2000, 'MN2021', 100, 1, '2021-03-17 03:40:09'),
(5, '2', 2, 9000, 50, 400, 'SH77OFF', 150, 5, '2021-03-17 04:20:00'),
(7, '3', 2, 6000, 100, 250, 0, 9, '2021-03-17 03:50:45');

UPDATE `e_store`.`order` SET `firstName`='Jeon', `lastName`='Jungkook', `mobile`='8867543211', `email`='jk01@gmail.com' WHERE `id`='5';
UPDATE `e_store`.`order` SET `firstName`='Kim', `lastName`='Soekjin', `mobile`='7767543662', `email`='jin04@gmail.com' WHERE `id`='6';
UPDATE `e_store`.`order` SET `firstName`='Min', `lastName`='Yoongi', `mobile`='7183643212', `email`='suga23@gmail.com' WHERE `id`='7';


/* update `order` INNER JOIN  `user` ON 
    order.userId = user.id
    set order.firstName = user.firstName,
        order.middleName = user.middleName,
        order.lastName = user.lastName,
        order.mobile = user.mobile,
        order.email = user.email; */
        
 UPDATE `order` SET `total`= subTotal+tax-discount WHERE `id`='5'; 
 UPDATE `order` SET `total`= subTotal+tax-discount WHERE `id`='6'; 
 UPDATE `order` SET `total`= subTotal+tax-discount WHERE `id`='7'; 
   

INSERT INTO `order_item` (`productId`, `orderId`, `price`, `discount`, `quantity`, `createdAt`) VALUES 
(1, 5, 9000, 1000, 25, '2021-03-17 03:40:08'),
(4, 6, 900, 50, 10, '2021-03-17 04:19:59'),
(6, 7, 2000, 100, 3, '2021-03-17 03:50:44');

UPDATE `e_store`.`product` SET `isActive`=0 WHERE `id`='5';
UPDATE `e_store`.`product` SET `isActive`=0 WHERE `id`='3';

UPDATE `e_store`.`product` SET `imagesCount`=0 WHERE `id`='5';

UPDATE `e_store`.`order` SET `discount`=25100 WHERE `id`='5';
UPDATE `e_store`.`order` SET `discount`=650 WHERE `id`='6';
UPDATE `e_store`.`order` SET `discount`=300 WHERE `id`='7';

UPDATE `e_store`.`order` SET `status`=4 WHERE `id`='5';
UPDATE `e_store`.`order` SET `status`=5 WHERE `id`='7';
UPDATE `e_store`.`order` SET `status`=6 WHERE `id`='6';

UPDATE `e_store`.`order` SET `createdAt`='2021-03-03 03:40:09' WHERE `id`='5';
UPDATE `e_store`.`order` SET `createdAt`='2021-03-07 04:20:00' WHERE `id`='6';
UPDATE `e_store`.`order` SET `createdAt`='2021-02-05 03:50:45' WHERE `id`='7';



INSERT INTO `e_store`.`order_status` (`id`, `status`) VALUES 
(1, 'New'),
(2, 'Checkout'),
(3, 'Paid'),
(4, 'Failed'),
(5, 'Shipped'),
(6, 'Delivered'),
(7, 'Returned'),
(8, 'Completed');

UPDATE `e_store`.`order_item` SET `order_status`=4 WHERE `id`='1';
UPDATE `e_store`.`order_item` SET `order_status`=6 WHERE `id`='2';
UPDATE `e_store`.`order_item` SET `order_status`=5 WHERE `id`='3';

UPDATE `e_store`.`order_item` SET `createdAt`='2021-03-03 03:40:09' WHERE `id`='1';
UPDATE `e_store`.`order_item` SET `createdAt`='2021-03-07 04:20:00' WHERE `id`='2';
UPDATE `e_store`.`order_item` SET `createdAt`='2021-02-05 03:50:45' WHERE `id`='3';




