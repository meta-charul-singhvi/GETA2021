package factoryForADT;
/*
 * Class containing attributes of shape Triangle and
 * implements methods interfaced from Shape interface
 */

public class Triangle implements Shape {

	/* coordinates of triangle */
	private int xCoordinate;
	private int yCoordinate;
	private double side1;
	private double side2;
	private double side3;
	private String uniqueId;

	/**
	 * Constructor to initialize attributes of triangle
	 * 
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param double1
	 * @param double2
	 * @param double3
	 */
	public Triangle(int xCoordinate, int yCoordinate, Double double1, Double double2,
			Double double3, String uniqueId) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.side1 = double1;
		this.side2 = double2;
		this.side3 = double3;
		this.uniqueId = uniqueId;
	}

	// method to return the area calculated
	@Override
	public double getArea() {
		double area;
		double s = (side1 + side2 + side3) / 2;
		area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		return area;
	}

	// method to return the perimeter calculated
	@Override
	public double getPerimeter() {
		return (side1 + side2 + side3);
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

		double x2 = xCoordinate + side1;
		double y2 = yCoordinate + side1;

		double x3 = x2 + side2;
		double y3 = y2 + side2;

		if ( x >= xCoordinate && x <= x3 && y <= y2) {
			return true;
		}
		return false;
	}

	// method to return the shape type
	@Override
	public ShapeType getType() {
		return ShapeType.TRIANGLE; // ShapeType is an enum
	}
	
	@Override
	public String getUniqueId() {
		
		return uniqueId;
	}
}