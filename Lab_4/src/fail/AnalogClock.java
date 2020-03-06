package fail;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.sql.Time;
import java.util.Date;
/**
 * Failed attempt to make Analog Clock
 * @author Byambaa Bayarmandakh
 *
 */
public class AnalogClock extends Applet {
	public static double HOUR_HAND_RATIO = 1/4;
	public static double MINUTE_HAND_RATIO = 1;
	public static double SECOND_HAND_RATIO = 1;
	public int counter = 0;
	
	public void paint(Graphics g) {
		Date toDraw = new Date(System.currentTimeMillis());
		drawClockFrame(g);
		drawClockHands(g,toDraw);
	}

	private void drawClockFrame(Graphics g) {
		
	}

	private void drawClockHands(Graphics g, Date toDraw) {
		drawHourHand(g,toDraw.getHours());
		drawMinuteHand(g,toDraw.getMinutes());
		drawSecondHand(g,toDraw.getSeconds());
	}

	private void drawSecondHand(Graphics g, int seconds) {
		Point center = getCenterPoint();
		Point defaultTwelve = new Point(center.x,(int) (center.y/SECOND_HAND_RATIO));
		Point toDraw = rotateLine(defaultTwelve, center, (seconds/60)*360);
		g.setColor(Color.black);
		g.drawLine(center.x,center.y,toDraw.x,toDraw.y);
		System.out.println(toDraw.toString());
	}
	private void drawMinuteHand(Graphics g, int minutes) {
		Point center = getCenterPoint();
		Point defaultTwelve = new Point(center.x,(int)(center.y/MINUTE_HAND_RATIO));
		Point toDraw = rotateLine(defaultTwelve, center, (minutes/60)*360);
		g.setColor(Color.blue);
		g.drawLine(center.x,center.y,toDraw.x,toDraw.y);
	}

	private void drawHourHand(Graphics g, int hours) {
		Point center = getCenterPoint();
		Point defaultTwelve = new Point((center.x),(int)(center.y/HOUR_HAND_RATIO));
		Point toDraw = rotateLine(defaultTwelve, center, ((hours%12)/12)*360);
		g.setColor(Color.red);
		g.drawLine(center.x,center.y,toDraw.x,toDraw.y);
	}
	
	private Point getCenterPoint() {
		return new Point(this.getWidth()/2,this.getHeight()/2);
	}
	
	private Point rotateLine(Point point, Point center, double angle) {
		angle = (angle) * (Math.PI/180); // Convert to radians

		double rotatedX = Math.cos(angle) * (point.x - center.x) - Math.sin(angle) * (point.y-center.y) + center.x;
		double rotatedY = Math.sin(angle) * (point.x - center.x) + Math.cos(angle) * (point.y - center.y) + center.y;
		
		return new Point((int)rotatedX,(int)rotatedY);
	}
}
