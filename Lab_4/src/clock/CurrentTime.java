package clock;
import java.sql.Time;

/**
 * Singleton class that fetches current system time
 * @author Byambaa Bayarmandakh
 *
 */
public class CurrentTime {
	private static CurrentTime instance = null;
	
	private CurrentTime() {
		
	}
	public static CurrentTime getInstance() {
		if(instance ==null) {
			instance = new CurrentTime();
		}
		return instance;
	}
	public Time getTime() {
		return new Time(System.currentTimeMillis());
	}
}
