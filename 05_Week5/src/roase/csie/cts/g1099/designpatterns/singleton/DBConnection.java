package roase.csie.cts.g1099.designpatterns.singleton;

public class DBConnection {

	//the reference to the unique object
	private static DBConnection connection;
	
	private String connectionString;
	
	private String database;
	private String username;
	
	
	private DBConnection(String connectionString, String database, String username) {
		super();
		this.connectionString = connectionString;
		this.database = database;
		this.username = username;
	}
	
	private DBConnection() {
		super();
	}
	
	public synchronized static DBConnection getConnection() {
		
		if(connection == null) {
			connection = new DBConnection();
		}
		
		return DBConnection.connection;
	}
	
}
