import java.awt.Graphics;
import java.awt.Polygon;

/****************************************************/
/* This hexagon class actually uses the same values */
/* as a circle but the simple difference is in the 	*/
/* draw method using the for-loop to change the		*/
/* angle at which the next line will be directed to */
/* be drawn. */
/****************************************************/
public class Hexagon extends Shape {
	private int r;

	public Hexagon(int x, int y, int r){
		super(x,y);
		this.r = r;
	}
	/****************************************************/
	/* 						Getter(s)					*/
	/****************************************************/
	public int getR(){
		return r;
	}

	/****************************************************/
	/* 						Setter(s)					*/
	/****************************************************/
	public void setR(int r){
		if(r > 0){
			this.r = r;
		}else{
			System.out.println("error setting the radius");
		}
	}

	/****************************************************/
	/* TEXT HERE */
	/****************************************************/
	public void draw(Graphics g){
		Graphics g2d = (Graphics) g;
		
		final int x = getX();
		final int y = getY();
		final int r = getR();

		//found this logic here. I was missing the casting
		//and the way to create the offsets for each new
		//x,y coordinate pair to draw the next line from.
		//https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=3&cad=rja&uact=8&ved=0ahUKEwjbj_qdruvaAhWJ5YMKHdHSCrsQFgg4MAI&url=http%3A%2F%2Fheuristic.kaist.ac.kr%2Fcylee%2Fxwireless%2FHexagonal%2FHexagon.java&usg=AOvVaw0BfAbJUJL50KkmlHldr52e
		Polygon p = new Polygon();
		for (int i=0;i<6;i++){
			p.addPoint(
				(int)(x + r * Math.cos(i * 2 * Math.PI / 6)),
				(int)(y + r * Math.sin(i * 2 * Math.PI / 6)));
		}    
		g.drawPolygon(p);
	}
}
