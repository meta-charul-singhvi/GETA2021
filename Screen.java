package factoryForADT;

import java.util.*;

/*
 * class for implementing virtual screen
 */
public class Screen {
	// map for containing Shape objects
	private Map<String, Shape> mapOfShapeOnScreen = new HashMap<String, Shape>();
	// map to maintain timestamp and shape objects
	private Map<Shape, Date> mapOfTimestamp = new HashMap<Shape, Date>();
	
	/**
	 * method to add shape on the screen
	 * 
	 * @param shape
	 *            object
	 * @return 1 if shape added successfully otherwise return 0
	 */
	public int addShapeToScreen(Shape shape) {

		if (shape != null) {
			Date date = new Date();
			mapOfShapeOnScreen.put(shape.getUniqueId(), shape);
			mapOfTimestamp.put(shape, date);
			System.out.println("Shape at origin location " + shape.getOrigin()
					+ " with id: " + shape.getUniqueId() + " having timestamp: " + date);
			System.out.println("\nShapes On Screen: \n");
			showShapesOnScreen();
			return 1;
		}
		return 0;
	}

	/**
	 * method to remove shape on the screen
	 * 
	 * @param uniqueShapeId
	 *            of shape object
	 * @return 1 if shape removed successfully otherwise return 0
	 */
	public int deleteShapeFromScreen(String uniqueShapeId) {
		if (uniqueShapeId != null) {
			mapOfTimestamp.remove(mapOfShapeOnScreen.get(uniqueShapeId));
			mapOfShapeOnScreen.remove(uniqueShapeId);
			showShapesOnScreen();
			return 1;
		}
		return 0;
	}

	/**
	 * method to remove all shape of a type on the screen
	 * 
	 * @param shapeType
	 * @return 1 if all shapes are removed successfully otherwise return 0
	 */
	public int deleteAllShapesOfSpecificType(String shapeType) {

		for (String key : mapOfShapeOnScreen.keySet()) {
			Shape value = mapOfShapeOnScreen.get(key);
			if ((value.getType().name()).equals(shapeType)) {
				mapOfShapeOnScreen.remove(key);
				mapOfTimestamp.remove(value);

			}
		}
		return 1;
	}

	/**
	 * method to return list of shapes in ascending order sort by area
	 * 
	 * @return List of shapes in sorted order
	 */
	public List<Shape> getSortedListOfShapesByArea() {
		List<Shape> listOfShapes = new ArrayList<Shape>();
		if (mapOfShapeOnScreen.isEmpty()) {
			return listOfShapes;
		}
		for (Shape value : mapOfShapeOnScreen.values()) {
			listOfShapes.add(value);
		}

		for (int i = 0; i < listOfShapes.size(); i++) {
			for (int j = 0; j < (listOfShapes.size() - 1 - i); j++) {
				double area1 = listOfShapes.get(j).getArea();
				double area2 = listOfShapes.get(j + 1).getArea();
				if (area1 > area2) {
					Shape temp1 = listOfShapes.get(j);
					Shape temp2 = listOfShapes.get(j + 1);
					listOfShapes.set(j, temp2);
					listOfShapes.set(j + 1, temp1);
				}
			}
		}

		return listOfShapes;
	}

	/**
	 * method to find the shapes enclosing a particular point
	 * 
	 * @param Point
	 *            object as point which is enclosed
	 * @return list of shapes enclosing point
	 */
	public List<Shape> getListOfShapesEnclosingThePoint(Point point) {
		List<Shape> returningListOfShapes = new ArrayList<Shape>();
		for (Shape value : mapOfShapeOnScreen.values()) {
			if (value.isPointEnclosed(point)) {
				returningListOfShapes.add(value);
			}
		}

		return returningListOfShapes;
	}

	/**
	 * method to find the shapes that are overlapping a given shape
	 * 
	 * @param String 
	 * 			uniqueId of shape
	 * @return list of shapes overlapping
	 */
	public List<Shape> getListOfOverlapShape(String uniqueId){
		List<Shape> resultList = new ArrayList<Shape>();
		Shape startShape = null;  // shape from which we have to check overlapping
		 
		for(String key : mapOfShapeOnScreen.keySet()){
			if(key.equals(uniqueId)){
				startShape = mapOfShapeOnScreen.get(key);
				break;
			}
		}	
		Date startTimestamp = mapOfTimestamp.get(startShape);
		for(Shape shape : mapOfTimestamp.keySet()){
			if(startTimestamp.before(mapOfTimestamp.get(shape))){
				resultList.add(shape);
			}
		}
		return resultList;
	}
	/*
	 * method shows the shapes pesent on the screen
	 */
	private void showShapesOnScreen() {
		for (Shape shape : mapOfShapeOnScreen.values()) {
			System.out.println("Shape Type : " + shape.getType().name());
			System.out.println("UniqueId : " + shape.getUniqueId());
			System.out.println("Origin : " + shape.getOrigin());
			System.out.println("Area : " + shape.getArea());
			System.out.println("Perimeter : " + shape.getPerimeter());
			System.out
					.println("-----------------------------------------------------\n");
		}
	}

	/**
	 * method generate a unique Id by random function
	 * 
	 * @return unique Id as string
	 */
	private String uniqueIdGenerator() {
		String uniqueId = "shape";
		for (int i = 1; i <= 3; i++) {
			uniqueId = uniqueId + String.valueOf((int) (Math.random() * 10));
		}
		return uniqueId;
	}

	public String getUniqueIdGenerated() {
		return uniqueIdGenerator();
	}

	/* to check if list of shape is empty*/
	public boolean isListofShapeObjectEmpty(){
		if(mapOfShapeOnScreen.isEmpty())
			return true;
		
		return false;
	}
}