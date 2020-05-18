package database.writingstrategy;

import database.Database;
import database.DatabaseSavingStrategy;
import database.Entity;

public class MySQLStrategy implements DatabaseSavingStrategy {


	@Override
	public void save(String filename, Database db) {
		//Do Nothing because DAO directly works with the database
	}

	@Override
	public Entity[] read(String filename, Database db) {
		//Do Nothing because DAO directly works with the database
		return db.getData();
		
	}
}
