/* @author Charul Singhvi
 * @date 03-03-2021 
*/

package factoryForADT;
/*
 * Interface containing attributes of shapes
 * 
 */

public interface Shape {

	public double getArea();

	public double getPerimeter();

	public String getOrigin();

	public ShapeType getType();
	
	public boolean isPointEnclosed(Point point);
	
	public String getUniqueId();
	
	public enum ShapeType {
		RECTANGLE, CIRCLE, SQUARE, TRIANGLE;
	}
}