public class Customer {
	private int id;
	private String fName;
	private String lName;

	public Customer(String name1, String name2) {
		this.id = 0;
		this.fName = name1;
		this.lName = name2;
	}
	public Customer(int id, String name1, String name2) {
		this.id = id;
		this.fName = name1;
		this.lName = name2;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getFirstName() {
		return fName;
	}
	/**
	 * @param name the name to set
	 */
	public void setFirstName(String name) {
		this.fName = name;
	}
	/**
	 * @return the name
	 */
	public String getLastName() {
		return lName;
	}
	/**
	 * @param name the name to set
	 */
	public void setLasttName(String name) {
		this.lName = name;
	}
	public String[] getArguments() {
		return new String[] {""+id,fName,lName};		
	}
}