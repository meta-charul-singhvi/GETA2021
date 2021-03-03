package factoryForADT;

/*
 * Class containing attributes of shape Circle and
 * implements methods interfaced from Shape interface
 */

public class Circle implements Shape {

	private final double PI = 3.14; /* initializing pi value for calculation */

	/* coordinates of circle */
	private int xCoordinate;
	private int yCoordinate;
	private int radius;
	private String uniqueId;

	/**
	 * Constructor to initialize attributes of circle
	 * 
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param radius
	 */
	public Circle(int xCoordinate, int yCoordinate, int radius, String uniqueId) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.radius = radius;
		this.uniqueId =uniqueId;
	}

	// method to return the area calculated
	@Override
	public double getArea() {
		return (PI * radius * radius);
	}

	// method to return the perimeter calculated
	@Override
	public double getPerimeter() {
		return (2 * PI * radius);
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

		double centreX = 0, centreY = 0;
		double m = 0;
		double n = radius;

		// calculating coordinates of centre
		m = Math.sqrt((xCoordinate * xCoordinate) + (yCoordinate * yCoordinate))
				+ radius;
		centreX = (m * xCoordinate) / (m - n);
		centreX = (m * yCoordinate) / (m - n);

		// calculate distance of centre from the point given
		double distanceToPoint = (double) Math
				.sqrt(((x - centreX) * (x - centreX))
						+ ((y - centreY) * (y - centreY)));

		if (distanceToPoint < radius) {
			return true;
		}
		return false;
	}

	// method to return the shape type
	@Override
	public ShapeType getType() {
		return ShapeType.CIRCLE;   // ShapeType is an enum
	}
	
	@Override
	public String getUniqueId() {
		
		return uniqueId;
	}
}