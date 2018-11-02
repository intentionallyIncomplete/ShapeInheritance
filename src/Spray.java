import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/**
 * Class Description:
 * @author Ian Bryan
 * @version 11/01/2018
 * 
 * Spray() builds some shapes using the Graphics2D methods from the Graphics interface.
 */
class Spray extends Shape {
	/**
	 * Class data members
	 * */
	private final int RADIUS = 20;
	private final int DENSITY = 10;


	/**
	 * @param a
	 * @param b
	 * 
	 * Constructor uses variables 'a' and 'b' 
	 */
	public Spray( int a, int b ) {
		super( a, b);
	}


	public void draw( Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		final int x = getX();
		final int y = getY();

		g2d.setColor( Color.GREEN );
		g2d.setPaint( new GradientPaint( x, y, Color.GREEN, x + RADIUS/4, y + RADIUS/4, Color.BLACK, true) );

		int xOffset = 0;
		int yOffset = 0;
		for( int i = 0; i < DENSITY; i++) {
			xOffset = (int) (Math.random()*RADIUS);
			yOffset = (int) (Math.random()*RADIUS);
			g2d.draw( new Ellipse2D.Double( x + xOffset, y + yOffset, x + xOffset+3, y + yOffset+3) );
		}
	}	
}