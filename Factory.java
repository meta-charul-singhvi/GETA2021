package factoryForADT;
import java.util.*;

import factoryForADT.Shape.ShapeType;

/*
 * Class containing method which returns the object of shape type
 */
public class Factory {
	
	/* method to create shape based on Shape type*/
	public static Shape createShape(ShapeType shapeType, Point point, List<Integer> parametersList, String uniqueId){
		Shape shape = null;
		
		/*check if point  lies inside the screen*/
		if(point.getXCoordinate()>point.getMAX_X_Coordinate() || point.getYCoordinate() > point.getMAX_Y_Coordinate()){
			System.out.println("Screen limit exceed!!");
			return null;
		}
		
		switch(shapeType) {
		case RECTANGLE :
			shape = new Rectangle(point.getXCoordinate(),point.getYCoordinate(),parametersList.get(0),parametersList.get(1),uniqueId);
			break;
			
		case CIRCLE :
			shape = new Circle(point.getXCoordinate(),point.getYCoordinate(),parametersList.get(0),uniqueId);
			break;
		
		case SQUARE :
			shape = new Square(point.getXCoordinate(),point.getYCoordinate(),parametersList.get(0),uniqueId);
			break;
			
		case TRIANGLE :
			shape = new Triangle(point.getXCoordinate(),point.getYCoordinate(),parametersList.get(0),parametersList.get(1),parametersList.get(2),uniqueId);
			break;
		
		default : break;
		}
		return shape;
	}
	

}