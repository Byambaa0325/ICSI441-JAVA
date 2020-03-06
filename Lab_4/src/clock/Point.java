package clock;
/**
 * 2D point in an euclidian space
 * @author Byambaa Bayarmandakh
 *
 */
public class Point {
	public double x;
	public double y;
	Point(double _x, double _y){
		x=_x;
		y=_y;
	}
	
	public int getIntX() {
		return (int) Math.round(x);
	}
	public int getIntY() {
		return (int) Math.round(y);
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}
}
