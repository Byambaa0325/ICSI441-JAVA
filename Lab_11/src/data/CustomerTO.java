package data;

import java.io.Serializable;

public class CustomerTO implements Serializable{
	
	private static final long serialVersionUID = 8450139132847788816L;
	
	private int id;
	private String name;

	public CustomerTO(String name2) {
		this.id = 0;
		this.name = name2;
	}
	public CustomerTO(int id, String name2) {
		this.id = id;
		this.name = name2;
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
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


}
