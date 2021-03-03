package factoryForADT;

/*
 * Class containing attributes of shape Rectangle and
 * implements methods interfaced from Shape interface
 */

public class Rectangle implements Shape {

	/* coordinates of rectangle */
	private int xCoordinate;
	private int yCoordinate;
	private int width;
	private int length;
	private String uniqueId;

	/**
	 * Constructor to initialize attributes of rectangle
	 * 
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param length
	 * @param width
	 */
	public Rectangle(int xCoordinate, int yCoordinate, int length, int width, String uniqueId) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.length = length;
		this.width = width;
		this.uniqueId = uniqueId;
	}

	// method to return the area calculated
	@Override
	public double getArea() {
		return (length * width);
	}

	// method to return the perimeter calculated
	@Override
	public double getPerimeter() {
		return (2 * (length * width));
	}

	// method to origin points
	@Override
	public String getOrigin() {
		String originCoordinates = "";
		originCoordinates += String.valueOf(xCoordinate) + ",";
		originCoordinates += String.valueOf(yCoordinate);

		return originCoordinates;
	}

	// method to check for the point whether it is enclosed or not
	@Override
	public boolean isPointEnclosed(Point point) {
		int x = point.getXCoordinate();
		int y = point.getYCoordinate();

		if (x < (xCoordinate + width) && y < (yCoordinate + length)) {
			return true;
		}
		return false;
	}

	// method to return the shape type
	@Override
	public ShapeType getType() {
		return ShapeType.RECTANGLE; // ShapeType is an enum
	}

	@Override
	public String getUniqueId() {
		
		return uniqueId;
	}
}