package DAL;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataAccessLayer {

	private String connectionString =				
			"jdbc:sqlserver://" + 
			"localhost" +
			";database=master;user= "  + 
			"sa" + 
			";password=" + 
			System.getenv("PASSWORD") + 
			";trustServerCertificate=true;loginTimeout=30;" ;
	
	private Connection connection;
	
	public void setConnectionString(DataAccessLayer dataAccessLayer) {
		this.connection = connection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public DataAccessLayer() {
		try {
			this.connection = DriverManager.getConnection(connectionString);		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}


}
