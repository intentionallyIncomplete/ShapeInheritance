import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;

/**
 * Class Description:
 * @author Ian Bryan
 * @version 11/1/2018
 * 
 * Star class draws a single triangle to the screen who's base is on a circle
 * and repeats the drawing process until a certain number of "draw" interactions
 * are complete.
 */
public class Stars extends Shape{
	private int startAngle;
	private int midSecX;
	private int midSecY;
	private int radius[] = {150, 50, 100, 50};

	//The total number of points to use to create a star
	//Ex: 12 = 6 points on a star.
	public static final int TOTAL_POINTS = 12; 

	/**
	 * @param x
	 * @param y
	 * 
	 * Constructor takes only X and Y pair values.
	 * Parameters are handed to super class.
	 */
	public Stars(int x, int y){	super(x, y);	}

	/**
	 * @param x
	 * @param y
	 * @param startAngle
	 * @param midSecX
	 * @param midSecY
	 * 
	 * X and Y values are handed to the super class Shape().java for processing.
	 * startAngle and it's two midpoints (midSecX, midSecY) are assigned.
	 */
	public Stars(int x, int y, int startAngle, int midSecX, int midSecY){
		super(x,y);
		if(startAngle > 0 || startAngle > 360) {
			System.out.println("Cannot start at an angle larger than 360");
		}else {
			this.startAngle = startAngle;
		}
		this.midSecX = midSecX;
		this.midSecY = midSecY;
	}

	/**
	 * @return Returns the degree of the starting angle for the line to be drawn from
	 */
	public int getStartAngle(){	return startAngle;	}

	/**
	 * @return Returns the value of the distance between the center point
	 * and the latest X,Y coordinate pair of the latest point.
	 */
	public int getMidSecX(){	return midSecX;	}

	/**
	 * @return Returns the value of the Y point between the point of the star
	 * and the center of the circle.
	 */
	public int getMidSecY(){	return midSecY;	}

	/**
	 * @param startAngle
	 * When if or else is satisfied, an execution of either a print statement with an error 
	 * or assignment to startAngle will happen.
	 */
	public void setStartAngle(int startAngle){
		if(startAngle > 0){
			this.startAngle = startAngle;
		}else if(startAngle > 360){
			System.out.println("Cannot start at an angle larger than 360");
		}else{
			System.out.println("Starting angle degree must be non-negative");
		}
	}

	/**
	 * @param midSecX
	 * @see getMidSecY()
	 */
	public void setMidSecX(int midSecX){
		if(midSecX > 0){
			this.midSecX = midSecX;
		}else{
			System.out.println("Midpoints cannot be non-positive");
		}
	}

	/**
	 * @param midSecY
	 * @see setMidSecX(int)
	 */
	public void setMidSecY(int midSecY){
		if(midSecY > 0){
			this.midSecY = midSecY;
		}else{
			System.out.println("Midpoints cannot be non-positive");
		}
	}

	/**
	 * xCenter 
	 * yCenter are the"base" of the Star object and are used to center 
	 * the origin of the Star so that each point is drawn
	 * equal distance from these coordinates.
	 */
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		final int xCenter = getMidSecX();
		final int yCenter = getMidSecY();

		int[] xs = new int[TOTAL_POINTS];
		int[] ys = new int[TOTAL_POINTS];

		/**logic here originated from
		 * https://stackoverflow.com/questions/16327588/how-to-make-star-shape-in-java
		 * for the x and y coordinate handling for drawing each new "point" on the star
		 * in range of the total number of points that will be need to draw the Star
		 * iterate over each one while setting the x coordinate to the point adjacent to
		 * the hypotenuse and the y coordinate to the next side that's also adjacent
		 * to the hypotenuse.
		 */
		for (int k=0; k<TOTAL_POINTS; k++)
		{
			int i = (int) k;
			double x = Math.cos(k*((2*Math.PI)/10))*radius[i % 4];
			double y = Math.sin(k*((2*Math.PI)/10))*radius[i % 4];

			xs[i] = (int) x + xCenter;
			ys[i] = (int) y + yCenter;
		}
		g2d.drawPolygon(xs, ys, TOTAL_POINTS);
	}
}
