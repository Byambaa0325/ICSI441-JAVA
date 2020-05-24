import java.util.ArrayList;

public class CustomerDAO {
	ArrayList<Customer> db = new ArrayList<>();
	
	/**
	 * Insert Customer to database
	 * @param toInsert The object to be inserted
	 */
	public void insert(Customer toInsert) {
		//Add to database
		db.add(toInsert);		
	}

	/**
	 * Remove Customer by id
	 * @param id The id in database
	 */
	public void delete(int id) {
		db.remove(id-1);
	}

	/**
	 * Linear Search for Customer from database
	 * @param toSearch Customer to be searched
	 * @return the index in the database
	 */
	public int search(Customer toSearch) {
		int index = 0;
		for(Customer Customer : db) {
			if(equals(Customer,toSearch)) {
				return index+1;
			}
			index++;
		}
		return -1;
	}

	private boolean equals(Customer customer, Customer toSearch) {
		return false;
	}

	/**
	 * Update existing Customer with new Customer
	 * @param old The old Customer in the database
	 * @param update the Customer to replace the old Customer
	 */
	public void update(Customer old, Customer update) {
		int index = search(old)-1;
		db.remove(index);
		db.add(index, update);
	}

	/**
	 * Return data stored as Customer array
	 * @return array of entities
	 */
	public Customer[] getData() {
		Customer[] toReturn = new Customer[db.size()];
		for(int i = 0 ; i< toReturn.length; i++) {
			toReturn[i] = db.get(i);
		}
		return toReturn;
	}

	

}
