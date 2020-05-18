package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.CustomerTO;

public class SQLCustomerDatabase implements Database {
	
	private static final Database instance = new SQLCustomerDatabase();
	
	public static Database getInstance() {
		return instance;
	}

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public SQLCustomerDatabase() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "");
			statement = connect.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

	@Override
	public void insert(Entity toInsert) {
		CustomerTO customer = entityToCustomer(toInsert);
		try {
			preparedStatement = connect.prepareStatement("insert into customers values(?,?)");
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int search(Entity a) {
		CustomerTO customer = entityToCustomer(a);
		try {
			preparedStatement = connect.prepareStatement("select * from customers where ID = ? and Name = ?");
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2, customer.getName());
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			while (resultSet.next()) {
				count++;
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void update(Entity a, Entity b) {
		CustomerTO customerA = entityToCustomer(a);
		CustomerTO customerB = entityToCustomer(b);
		try {
			preparedStatement = connect.prepareStatement("UPDATE customers " + 
					"SET ID = ?, Name = ? " + 
					"WHERE ID = ? AND Name = ?");
			preparedStatement.setInt(3, customerA.getId());
			preparedStatement.setString(4, customerA.getName());
			preparedStatement.setInt(1, customerB.getId());
			preparedStatement.setString(2, customerB.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			preparedStatement = connect.prepareStatement("delete from customers where ID = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Construct customer from entity
	 * @param toInsert the entity to be converted
	 * @return the entity as customer
	 */
	private CustomerTO entityToCustomer(Entity toInsert) {
		CustomerTO customer;//Single argument constructor
		if(toInsert.getObject().length==1) {
			customer=new CustomerTO(toInsert.getObject()[0]);
		}
		//Double argument constructor
		else {
			customer=new CustomerTO(Integer.parseInt(toInsert.getObject()[0]), toInsert.getObject()[1]);
		}
		return customer;
	}

	@Override
	public Entity[] getData() {
		ArrayList<Entity> toReturn = new ArrayList<>();
		try {
			resultSet = statement.executeQuery("select * from customers");

			while (resultSet.next()) {
				toReturn.add(new Entity(new String[] {resultSet.getInt(1)+"", resultSet.getString(2)}));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Entity[] returningArray = new Entity[toReturn.size()];
		for(int i = 0; i < toReturn.size();i++) {
			returningArray[i] = toReturn.get(i);
		}
	
		return returningArray;
	}

}
