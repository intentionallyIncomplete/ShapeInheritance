import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

/****************************************************/
/* The "stars" class draws a star to the screen. The*/
/* The basic concept is that the program will begin	*/
/* drawing at the given x,y coordinates	and then	*/
/* move to the next x,y coordinate pair and make a	*/
/* line to connect the two points.					*/
/****************************************************/

public class Stars extends Shape{
	private int startAngle;
	//private int arcAngle;
	private int midSecX;
	private int midSecY;
	int radius[] = {150, 50, 100, 50};

	/* final for the number of 'points' of the star
	 * these points are not just the parts that make the 'tops' of each triangle
	 * but rather the number of times the program will use the startAngle. 
	 */ 
	public static final int TOTAL_POINTS = 12; 

	/* the two arg ctor will simply send the x,y coordinate values
	 * to the super class (Shape) to be added to the array of Star
	 * staring coordinate pairs in PloyDemo.
	 */
	public Stars(int x, int y){
		super(x, y);
	}

	/* this is the ctor that is used to create a Star shape from the
	 * PloyDemo driver class. the x,y starting points are submitted
	 * to the super class (Shape) and the startAngle will determine
	 * the curve of the star's outer angles. 
	 * The midSecX and midSecY will set the center of the 'points' 
	 * of the Star shape. That is to say, there is a starting x,y 
	 * coordinate and the Star will then have its own "center" with
	 * a corresponding middle section (midSec) x,y coordinate position.
	 */
	public Stars(int x, int y, int startAngle, int midSecX, int midSecY){
		super(x,y);
		this.startAngle = startAngle;
		this.midSecX = midSecX;
		this.midSecY = midSecY;
	}

	/****************************************************/
	/* 						Getters						*/
	/****************************************************/
	public int getStartAngle(){
		return startAngle;
	}

	public int getMidSecX(){
		return midSecX;
	}

	public int getMidSecY(){
		return midSecY;
	}

	/****************************************************/
	/* 						Setters						*/
	/****************************************************/
	/* a little error checking in this setter for negative
	 * numbers. Just want to be sure that the angle that's set
	 * to create the steepness of the Star is not invalid (negative
	 */
	public void setStartAngle(int startAngle){
		if(startAngle > 0){
			this.startAngle = startAngle;
		}else{
			System.out.println("error setting start angle");
		}
	}

	/* this setter here is the for center X coordinate
	 * of the Star. Since a star has a circle in the middle
	 * there must be a center x,y coordinate pair for each
	 * point on the Star to be drawn from the same originating
	 * position
	 */
	public void setMidSecX(int midSecX){
		if(midSecX > 0){
			this.midSecX = midSecX;
		}else{
			System.out.println("error setting the center X coordinate");
		}
	}

	/* this setter here works on the same logic as the setter above */
	public void setMidSecY(int midSecY){
		if(midSecY > 0){
			this.midSecY = midSecY;
		}else{
			System.out.println("error setting the center Y coordinate");
		}
	}

	/****************************************************/
	/* This method overrides the draw() method from the */
	/* super class (Shape) and draws a Star using some	*/
	/* math that defines the way to draw a line between	*/
	/* points of the Star. the xCenter,yCenter are the	*/
	/* "base" of the Star object and are used to center */
	/* the origin of the Star so that each point is drawn*/
	/* equidistant from these coordinates.				*/
	/****************************************************/
	public void draw(Graphics g){
		Graphics g2d = (Graphics) g;

		final int xCenter = getMidSecX();
		final int yCenter = getMidSecY();


		int[] xs = new int[TOTAL_POINTS]; //array the size of the total points to be used (12)
		int[] ys = new int[TOTAL_POINTS]; //same as above, both arrays need to be the same size
		//to be sure the triangle draws the same number of sides for each part of the Star

		//logic here originated from
		//https://stackoverflow.com/questions/16327588/how-to-make-star-shape-in-java
		//for the x and y coordinate handling for drawing each new "point" on the star
		//in range of the total number of points that will be need to draw the Star
		//iterate over each one while setting the x coordinate to the point adjacent to
		//the hypotenuse and the y coordinate to the next side that's also adjacent
		//to the hypotenuse. 
		for (int k=0; k<TOTAL_POINTS; k++)
		{
			int i = (int) k;
			double x = Math.cos(k*((2*Math.PI)/10))*radius[i % 4];
			double y = Math.sin(k*((2*Math.PI)/10))*radius[i % 4];

			xs[i] = (int) x + xCenter; //add 
			ys[i] = (int) y + yCenter;
		}
		g2d.drawPolygon(xs, ys, TOTAL_POINTS); //similar to other draw method calls by setting the
		//args to the x, y, and number of points
	}
}
