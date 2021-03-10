package factoryForADT;

/*
 * Class containing attributes of shape Square and
 * implements methods interfaced from Shape interface
 */

public class Square implements Shape {

	/* coordinates of square */
	private int xCoordinate;
	private int yCoordinate;
	private double width;
	private String uniqueId;

	/**
	 * Constructor to initialize attributes of square
	 * 
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param length
	 */
	public Square(int xCoordinate, int yCoordinate, Double double1, String uniqueId) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.width = double1;
		this.uniqueId =uniqueId;
	}

	// method to return the area calculated
	@Override
	public double getArea() {
		return (width * width);
	}

	// method to return the perimeter calculated
	@Override
	public double getPerimeter() {
		return (4 * width);
	}

	// method to origin points
	@Override
	public String getOrigin() {
		String originCoordinates = "";
		originCoordinates += String.valueOf(xCoordinate) + "," + String.valueOf(yCoordinate);
		return originCoordinates;
	}

	// method to check for the point whether it is enclosed or not
	@Override
	public boolean isPointEnclosed(Point point) {
		int x = point.getXCoordinate();
		int y = point.getYCoordinate();

		if (x < (xCoordinate + width) && y < (yCoordinate + width) && x>=xCoordinate && y>=yCoordinate) {
			return true;
		}
		return false;
	}

	// method to return the shape type
	@Override
	public ShapeType getType() {
		return ShapeType.SQUARE; // ShapeType is an enum
	}
	
	@Override
	public String getUniqueId() {
		
		return uniqueId;
	}
}