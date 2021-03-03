package shop;
/* ShoppingCart.java
 * Represents the shopping cart list which contains:
 * @Cart List of items 
 * @itemCount Total items in cart 
 * @totalPrice Total bill amount
 * @capacity Current capacity of the cart
 * Methods such as:
 * @addToCart adds elements to the cart.
 * @editItemDetailInCart edit the quantity of already present element in cart using item Id.
 * @removeFromCart removes specific item from the cart
 * @displayItems Display the Cart items
 * @calculateBill returns the total bill calculated
 */

public class ShoppingCart
{

    private Item[] cart;
    public int itemCount;      	// total number of items in the cart
    private double totalPrice;  // total price of items in the cart
    private int capacity;       // current cart capacity

    
    /*
     *   Creates an empty shopping cart with a capacity of 5 items.
     */
    public ShoppingCart()
    {
      capacity = 5;
      cart = new Item[capacity];
      itemCount = 0;
      totalPrice = 0.0;
    }
     
    /*
     *   Adds an item to the shopping cart.
     */
    public void addToCart(int itemId, String itemName, double price, int quantity)
    { 

        Item newItem = new Item(itemId, itemName, price, quantity);
        totalPrice += (price * quantity);
        cart[itemCount] = newItem;
        itemCount += 1;
        if(itemCount==capacity)
        {
            increaseSize();
        }
    }
    
    /*
     *   Edits the item in the shopping cart.
     */
    public void editItemDetailInCart(int itemId, int updatedQuantity)
    { 
    	Item updateItem = new Item();
    	Item updatedItem = new Item();
    	System.out.println("Item in the cart " + updateItem);
        updateTotalPrice(updateItem, updatedQuantity);
        cart[itemId-1].updatedQuantity(updatedQuantity);
        updatedItem = cart[itemId-1];
        System.out.println("Updated to " + updatedItem+" successfully!");
        updateItem = null;
        updatedItem = null;
    }
    
    /*
     *   Removes an item from the shopping cart.
     */
    public void removeFromCart(int itemId)
    { 
    	//checking if item with the given Id is present in the cart
		Item removeItem = new Item();
		removeItem = cart[itemId-1];
		for(int removingId=itemId; removingId<itemCount; removingId++)
			cart[itemId-1] = cart[itemId];
	    itemCount-=1;
	    capacity = cart.length;
	    updateTotalPrice(removeItem, 0);
	    
	    System.out.println("Item removed successfully : " + removeItem);
	    removeItem = null;
    }

    /*
     *   Returns the contents of the cart together with summary information.
     */
    public String displayItems()
    {
      
      String contents = "\nShopping Cart\n" +
      "\nItem Id\tItem Name\tUnit Price\tQuantity\tTotal\n";

      for (int i = 0; i < itemCount; i++)
          contents += cart[i].toString() + "\n";

      return contents;
    }
    
    /* Updating total price on editing or removing item from cart
     * for removing item updatedQuantity will become zero
     */
    public void updateTotalPrice(Item updateItem, int updatedQuantity){
    	totalPrice -= updateItem.getPrice() * updateItem.getQuantity();
    	totalPrice +=  updateItem.getPrice() * updatedQuantity;
    }
    
    /*
     *  returns calculated bill
     */
    public String calculateBill()
    {
      String contents = "\nTotal Bill : " + (totalPrice) + "\n";
      return contents;
    }
    
    /*
     *  Increases the capacity of the shopping cart by 3
     */
    private void increaseSize()
    {
        Item[] temp = new Item[capacity+1];
        for(int i=0; i < capacity; i++)
        {
            temp[i] = cart[i];
        }
        cart = temp; 
        temp = null;
        capacity = cart.length;
    }
    
    /*
     * checking if item with the given Id is present in the cart
     */
    public boolean checkItemInCartById(int checkItemIdInCart){
    	for(int checkItemId = 0; checkItemId < itemCount; checkItemId++){
        	if(checkItemIdInCart == (cart[checkItemId].getItemId()) ){
        		return true;
        	}
        }
    	return false;
    }
    
    /*
     * checking if item with the given name is present in the cart
     */
    public boolean checkItemInCartByName(String checkItemNameInCart){
    	for(int checkItemId = 0; checkItemId < itemCount; checkItemId++){
        	if(checkItemNameInCart.equalsIgnoreCase(cart[checkItemId].getName()) ){
        		return true;
        	}
        }
    	return false;
    }
    
}
