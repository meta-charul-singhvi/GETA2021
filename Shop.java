/*
 * @author: Charul Singhvi
 * @date : 03-03-201
 * Shop.java : Main Class
 * Uses this class to perform action according to user's demand.
 */

package shop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop
{
    public static void main (String[] args)throws Exception
    {
    	try{
			String itemName;
			double itemPrice;
			int itemQuantity;
			
			Scanner scan = new Scanner(System.in);
			
			int usersChoice;
			ShoppingCart shoppingCart = new ShoppingCart();
			
			int countOfItem =0;
			while (true) {
				
				System.out.println("***************************************************************"+"\n"
				+ "Shopping Menu:\n\n" 
				+ "1) Add item in shopping cart" + "\t"
			    + "2) Edit item quantity in cart" + "\n"
			    + "3) Remove item from cart" + "\t"
			    + "4) Display Items in cart" + "\n"
		    	+ "5) Display Bill" + "\t\t\t"
		    	+ "6) End up Shopping!" + "\n\n"
		    	+ "***************************************************************\n");
				
				
				usersChoice = scan.nextInt();
			  
				/*
				 * Validating user's input
				 */
				while(usersChoice>6 || usersChoice<=0){
					System.out.println("Oops! You entered a wrong choice. Please re-enter a valid choice : ");
					usersChoice = scan.nextInt();
				}
			  
				
				switch (usersChoice) {
				/*
				 * calling functions for adding items to cart
				 */
				case 1:
					
					System.out.print ("Enter the name of the item: ");
					itemName = scan.next();
					/*
					 * Null checks
					 */
					while(itemName == null || itemName.isEmpty()){
						System.out.println("Please enter some Name of the item!");
					}
					
					/*
					 * check if new item entered already exists in cart
					 */
					if (!shoppingCart.checkItemInCartByName(itemName)){
						System.out.print("Enter the unit price: ");
						
						itemPrice = scan.nextDouble();
						while(itemPrice <= 0){
							System.out.println("Please enter a valid Price Value!");
							itemPrice = scan.nextDouble();
						}
						
						System.out.print ("Enter the quantity: ");
						itemQuantity = scan.nextInt();
						while(itemQuantity <= 0){
							System.out.println("Please enter a valid Item Quantity!");
							itemQuantity = scan.nextInt();
						}
						
						countOfItem++;
						shoppingCart.addToCart(countOfItem, itemName, itemPrice, itemQuantity);
						
					}
					else{
						System.out.println("This Item already exists in the cart. You can update the quantity in editing cart option!");
					}
					
					break;
					
					/*
					 * calling functions for editing itemList in cart
					 */
					case 2:
						
						if(shoppingCart.cartIsEmpty()){
							System.out.println("Cart is Empty!");
						}
						else{
							System.out.print ("Enter id of item to be Edited : ");
							int idOfItemEditing = scan.nextInt();
							while(idOfItemEditing <= 0 || idOfItemEditing > countOfItem){
								System.out.println("Please enter a valid Item Id: ");
								idOfItemEditing = scan.nextInt();
							}
							if( !shoppingCart.checkItemInCartById(idOfItemEditing) )
							{
								while(shoppingCart.checkItemInCartById(idOfItemEditing)){
									System.out.print ("Item with this id doesn't exist.Please re-enter id : ");
									idOfItemEditing = scan.nextInt();
								}
							}
							System.out.print ("Enter new Quantity of "+ idOfItemEditing +" : ");
							int editedItemQuantity = scan.nextInt();
							System.out.println(editedItemQuantity);
							/*
							 * validating the edited quantity
							 */
							while(editedItemQuantity < 0){
								System.out.println("Please enter a valid Item Quantity:");
								editedItemQuantity = scan.nextInt();
								
							}
							try{
								shoppingCart.editItemDetailInCart(idOfItemEditing, editedItemQuantity);
							}
							catch(Exception e){
								System.out.println ("Not edited!");
							}
						}
						break;
						
					/*
					 * calling functions for removing item to cart
					 */
					case 3:
						/*
						 * checking if cart is empty or not
						 */
						if(shoppingCart.cartIsEmpty())
							System.out.println("Sorry! You can't remove elements from an empty cart.");
						
						/*
						 * deleting Item from cart using Item Id
						 */
						else{
							System.out.print ("Enter id of item to be removed : ");
							int idOfItemToBeRemoved = scan.nextInt();
							if(idOfItemToBeRemoved <= 0 || idOfItemToBeRemoved > countOfItem){
								while(idOfItemToBeRemoved <= 0 || idOfItemToBeRemoved > countOfItem){
									System.out.println("Please enter a valid Item Id!");
									idOfItemToBeRemoved = scan.nextInt();
								}
							}
							else {
								while(!shoppingCart.checkItemInCartById(idOfItemToBeRemoved)){
									System.out.print ("Oops! Item with this id doesn't doesn't in the cart. Re-enter id : ");
									idOfItemToBeRemoved = scan.nextInt();
								}
							}
							shoppingCart.removeFromCart(idOfItemToBeRemoved);
						}
						break;
						
		      		/*
		      		 * calling function for displaying shopping cart
		      		 */
					case 4:
						if(shoppingCart.itemCount == 0)
							System.out.println("The cart is empty! You can add items to the cart.");
						else	
							System.out.println(shoppingCart.displayItems()); 
						break;
				  
					/*
					 * calling function to print the bill
					 */
					case 5:
						if(shoppingCart.itemCount == 0)
							System.out.println("The cart is empty! You can add items to the cart.");
						else
							System.out.println(shoppingCart.calculateBill());
						break;
						
					/*
					 * exiting the ShoppingCart
					 */
					case 6:
						System.out.println("\n" + "Thank You for connecting!");
						System.exit(0);
					}
				}
    		}
    		catch(NullPointerException e){
    			System.out.println("Closed the session due to invalid input!");
    		}
    		catch(InputMismatchException e){
    			System.out.println("Closed the session due to invalid input!");
    		}
    		catch(Exception e){
    			System.out.print(e.getMessage());
    		}
    	}
}
