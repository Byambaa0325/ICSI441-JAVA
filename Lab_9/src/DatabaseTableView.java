import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class DatabaseTableView extends DefaultTableModel {
	/**
	 * Headers for current model
	 */
	private static final String[] HEADERS = {"Id", "First name", "Last name"};
	/**
	 * Database for the model
	 */
	static CustomerDAO db;

	/**
	 * Constructor
	 * @param d database to construct from
	 */
	public DatabaseTableView(CustomerDAO d) {
		super(getData(d), getHeaders());
	}

	/**
	 * Retrieve data from database
	 * @return the data stored
	 */
	public static Object[][] getData() {
		Customer[] data = db.getData();
		Object[][] toReturn = new Object[data.length][];
		for(int i = 0; i < toReturn.length; i++) {
			toReturn[i] = data[i].getArguments();
		}
		return toReturn;
	}

	/**
	 * Retrieve from argument database
	 * @param d database to get from
	 * @return the data stored in d
	 */
	private static Object[][] getData(CustomerDAO d) {
		db = d;
		Customer[] data = db.getData();
		Object[][] toReturn = new Object[data.length][];
		for(int i = 0; i < toReturn.length; i++) {
			toReturn[i] = data[i].getArguments();
		}
		return toReturn;
	}

	/**
	 * Return headers
	 * @return the headers
	 */
	public static Object[] getHeaders() {
		return HEADERS;
	}
}