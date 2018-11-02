import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 * Class Description
 * @author Ian Bryan
 * @version 11/01/2018
 * 
 * Hexagon is a Shape and inherits all public modules and data from the super class
 * Shape(). 
 */
public class Hexagon extends Shape {
	/*Class data members*/
	private int r;
	/**
	 * @param x
	 * @param y
	 * @param r
	 * 
	 * Constructor takes in X and Y coordinate pair along with radius.
	 */
	public Hexagon(int x, int y, int r){
		super(x,y);
		if(r < 0) {
			System.out.println("Radius must be non-negative");
		}else {
			this.r = r;
		}
	}

	/**
	 * @return Return the present Hexagon's radius (r) value.
	 */
	public int getR(){
		return this.r;
	}

	/**
	 * @param r
	 * Sets the radius of the present radius of the present hexagon.
	 */
	public void setR(int r){
		if(r > 0){
			this.r = r;
		}else{
			System.out.println("The radius cannot be less than or equal to 0");
		}
	}

	public void draw(Graphics g){
		//Casting object type of Graphics to Graphics2D
		Graphics2D g2d = (Graphics2D) g;
		
		final int x = getX();
		final int y = getY();
		final int r = getR(); //radius
		
		/**
		 * Creates a new Polygon object and assigns it with values from the for-loop
		 * The for-loop will generate two coordinate pairs each iteration
		 * and assign them as a single pair to the Polygon object.
		 */
		Polygon p = new Polygon();
		for (int i=0;i<6;i++){
			p.addPoint(
				(int)(x + r * Math.cos(i * 2 * Math.PI / 6)),
				(int)(y + r * Math.sin(i * 2 * Math.PI / 6)));
		}    
		g.drawPolygon(p);
	}
}
