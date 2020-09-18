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
	private DataAccessLayer dataAccessLayer;
	
	public void setConnectionString(DataAccessLayer dataAccessLayer) {
		this.dataAccessLayer = dataAccessLayer;
	}
	
	public DataAccessLayer getConnection() {
		return dataAccessLayer;
	}
	
	public DataAccessLayer() {
		try {
			this.dataAccessLayer = DriverManager.getConnection(connectionString);		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}


}
