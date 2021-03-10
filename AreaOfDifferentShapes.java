/* @author Charul Singhvi
 *@date 03-03-2021
 *The class Area is used to calculate areas for different shapes. It contains :
 *Method to return area of a Triangle.
 *Method to return area of a Rectangle.
 *Method to return area of a Square.
 *Method to return area of a Circle.
*/
package ss;
import java.util.*;

public class AreaOfDifferentShapes {
	
	public double areaOfTriangle(double triangleBase, double triangleHeight)throws NullPointerException, NoSuchElementException, InputMismatchException, Exception{
		/* Method to calculate area of triangle
		 * @triangleBase is a double type value of the base of triangle.
		 * @triangleHeight is a double type value of the height of triangle
		 * returns the area of triangle as a double value.
		 */ 
		
		double triangleArea = 0.5 * triangleBase * triangleBase;
		return triangleArea;
	}
	
	public double areaOfRectangle(double rectangleWidth, double rectangleHeight){
		/* Method to calculate area of rectangle
		 * @rectangleWidth is a double type value of the width of rectangle.
		 * @rectangleHeight is a double type value of the height of rectangle.
		 * returns the area of rectangle as a double value.
		 */
		
		double rectangleArea = rectangleHeight * rectangleWidth;
		return rectangleArea;
	}

	public double areaOfSquare(double squareSide){
		/* Method to calculate area of square
		 * @squareSide is a double type value of the side of square.
		 * returns the area of square as a double value.
		 */ 
		
		double squareArea = squareSide * squareSide;
		return squareArea;
	}

	public double areaOfCircle(double circleRadius){
		/* Method to calculate area of circle.
		 * @circleRadius is a double type value of the radius of circle.
		 * returns the area of circle as a double value.
		 */ 
		
		double circleArea = 3.14 * circleRadius * circleRadius;
		return circleArea;
	}

	public void getUserChoice() throws NullPointerException, InputMismatchException, Exception{
	
		/* Method to get user choice and values for the shape for which area is to calculated.
		 * @throw exception when a string or character value is entered instead of expected integer value.
		 * @throw arithmetic exception, null pointer exception.
		 */
		System.out.println("Enter 1 to calculate area of triangle.\n"
						+	"Enter 2 to calculate area of rectangle.\n"
						+	"Enter 3 to calculate area of square.\n"
						+	"Enter 4 to calculate area of circle.\n"
						+	"Enter 5 to exit.\n");
		int userChoice;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your choice : ");
		try{	
			userChoice = scan.nextInt();	
		
			if(userChoice>5 || userChoice<1)
			{
				while(userChoice>5 || userChoice<1){
					System.out.println("Please enter a valid choice : ");
					userChoice = scan.nextInt();
				}
			}
			
			
			switch(userChoice){
			case 1:{
					System.out.println("Enter base of the triangle :");
					double baseOfTriangle = scan.nextDouble();
					System.out.println("Enter height of the triangle :");
					double heightOfTriangle = scan.nextDouble();
					System.out.printf("Area of triangle = %.2f cm^2\n" , (areaOfTriangle(baseOfTriangle, heightOfTriangle)));
					break;
				}
			case 2:{
					System.out.println("Enter width of the rectangle :");
					double widthOfRectangle = scan.nextDouble();
					System.out.println("Enter height of the rectangle :");
					double heightOfRectangle = scan.nextDouble();
					System.out.printf("Area of rectangle = %.2f cm^2\n" , (areaOfRectangle(widthOfRectangle, heightOfRectangle)));
					break;
				}
			case 3:{
					System.out.println("Enter side of the square :");
					double sideOfSquare = scan.nextDouble();
					System.out.printf("Area of square = %.2f cm^2\n" , (areaOfSquare(sideOfSquare)));
					break;
				}
			case 4:{
					System.out.println("Enter radius of the circle :");
					double radiusOfCircle = scan.nextDouble();
					System.out.printf("Area of circle = %.2f cm^2\n" , (areaOfCircle(radiusOfCircle)));
					break;
				}
			case 5:{
					System.exit(0);
				}
			default : {
					System.out.println("Invalid choice.");
					break;
				}
			}
		}
		catch (InputMismatchException e){
			System.out.println(e.getMessage() +" is not a valid input!");
		}
		catch(ArithmeticException e){
			System.out.println("Arithmetic Exception");			
		}
		catch(NoSuchElementException e){
			System.out.println("Invalid Input");		
		}
		scan.close();
	}
	
	public static void main(String args[]) throws NullPointerException, Exception{
		try{
			AreaOfDifferentShapes object = new AreaOfDifferentShapes();
			object.getUserChoice();
		}
		catch (NullPointerException e){
			System.out.println(e.getMessage() +" is not a valid input!");
		}
		catch(ArithmeticException e){
			System.out.println("Arithmetic Exception");			
		}
	}	
	
	
}