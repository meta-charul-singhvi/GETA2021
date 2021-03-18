/* 
2. Display Id, Title, Category Title, Price of the products which are Active and recently added products 
should be at top.
3. Display the list of products which don't have any images.
4. Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category 
Title and then Category Title. (If Category is top category then Parent Category Title column should 
display “Top Category” as value.)
5. Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of 
any other category)
6. Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
7. Display the list of Products whose Quantity on hand (Inventory) is under 50. 
*/

-- 2.
SELECT product.id as 'Product Id', product.title as 'Title', parentCategoryTitle as 'Parent Category Title', price as 'Price of Active products' FROM product
inner join category on product.category_id = category.id
WHERE isActive=1 order by createdOn desc ;

-- 3.
SELECT * from product WHERE imagesCount != 0;

-- 4.
SELECT id as 'Category Id', parentCategoryTitle as 'Parent Category Title', title as 'Leaf Category Title' FROM category order by parentCategoryTitle, title;

-- 5.
SELECT id as 'Category Id', parentCategoryTitle as 'Parent Category Title', title as 'Leaf Category Title' 
FROM category 
WHERE id not in (SELECT parentId from category);

-- 6. Suppose the category title be 'Smart Watches'
SELECT title as 'Product Title', price as 'Product Price', description as 'Description' 
FROM product WHERE title = 'Smart Watches';

-- 7.
SELECT title as 'Product Title' , quantity as 'Quantity' from product
WHERE quantity<50;