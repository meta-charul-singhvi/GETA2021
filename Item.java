/*	Item.java -> pojo class
 *	Uses the Item class to create items and add them to a shopping cart.
 *	Item represents an item in a shopping cart.
 */

package shop;
import java.text.NumberFormat;

public class Item
{
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Item(){}
    
    /*
     * Create a new item with the given attributes.
     */
    public Item (int itemId, String itemName, double itemPrice, int itemQuantity)
    {
    	id = itemId;
    	name = itemName;
    	price = itemPrice;
    	quantity = itemQuantity;
    	
    }
    
    /*
     * Return a string with the information about the item
     */
    public String toString ()
    {
    	NumberFormat fmt = NumberFormat.getCurrencyInstance();

    	return (id +"\t"+ name.toUpperCase() + "\t\t" + fmt.format(price) + "\t\t" + quantity + 
    			"\t\t"+ fmt.format(price*quantity));
    }

    /*
     * Returns the id of the item
     */
    public int getItemId(){
    	return id;
    }
     
    /*
     * Returns the unit price of the item
     */
    public double getPrice()
    {
    	return price;
    }
    
     
    /*
     * Returns the name of the item
     */
    public String getName()
    {
    	return name;
    }

    /*
     * Returns the quantity of the item
     */
    public int getQuantity()
    {
    	return quantity;
    }
     
    /*
     * Returns the updated quantity of the item
     */
    public void updatedQuantity(int editedItemQuantity)
    {
    	this.quantity = editedItemQuantity;
    }
} 
