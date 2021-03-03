package factoryForADT;

/*
 * Class containing attributes of a coordinate on the screen
 * 
 */

public class Point {

	/* initializing max coordinates of the rectangle screen */
	public final int MAX_X_COORDINATE = 500;
	public final int MAX_Y_COORDINATE = 500;

	/* coordinates of point */
	private int xCoordinate;
	private int yCoordinate;

	/**
	 * Constructor to initialize point variables
	 * 
	 * @param xCoordinate
	 * @param yCoordinate
	 */
	public Point(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	/**
	 * 
	 * @return value of X coordinate
	 */
	public int getXCoordinate() {
		return xCoordinate;
	}

	/**
	 * 
	 * @return value of Y coordinate
	 */
	public int getYCoordinate() {
		return yCoordinate;
	}

	/**
	 * 
	 * @return value of maximum value of X coordinate
	 */
	public int getMAX_X_Coordinate() {
		return MAX_X_COORDINATE;
	}

	/**
	 * 
	 * @return value of maximum value of Y coordinate
	 */
	public int getMAX_Y_Coordinate() {
		return MAX_Y_COORDINATE;
	}

}