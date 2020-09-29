package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccessLayer {
	
	private Connection con; 

	String connectionString = "jdbc:sqlserver://SYST3DEV01;database=CRONUS;user=user;password=123;trustServerCertificate=true;loginTimeout=30;";
	
	public DataAccessLayer(){
		try {
			con = DriverManager.getConnection(connectionString);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet dataGenerator(String query) throws SQLException {
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs;
		return rs = ps.executeQuery();
	}
	
	public ResultSet viewAllKeys() throws SQLException {
		
		String query = "SELECT COLUMN_NAME as column_name, CONSTRAINT_NAME as constraint_name, type as key_tape, type_desc, object_id FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE ccu JOIN sys.objects kc ON ccu.CONSTRAINT_NAME = kc.name WHERE type_desc LIKE '%KEY%'";
	return dataGenerator(query);
	}
	
	public ResultSet viewAllTableConstraints() throws SQLException {
		
		String query = "SELECT TABLE_NAME as table_name, CONSTRAINT_NAME as constraint_name , CONSTRAINT_TYPE as constraint_type FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS";
		return dataGenerator(query);
	}
	
	public ResultSet viewAllTables() throws SQLException {
		
		String query = "SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE LIKE 'BASE TABLE'";
		return dataGenerator(query);
	}
	
	
	public ResultSet viewAllEmployeeInfo() throws SQLException {
		
		String query = "SELECT TABLE_NAME as table_name, COLUMN_NAME as column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee'";
		return dataGenerator(query);
	}
	
	public ResultSet viewMetaForEmployee() throws SQLException {
		
		String query = "SELECT TABLE_CATALOG as table_catalog, TABLE_NAME as table_name, COLUMN_NAME as column_name, ORDINAL_POSITION as ordinal_position, IS_NULLABLE as is_nullable, DATA_TYPE as data_type FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee'";
		return dataGenerator(query);
	}
	
	public ResultSet viewLargestTable() throws SQLException {
		
		String query = "SELECT TOP(1)COUNT(*) as nbrRows, t.name FROM sys.tables t JOIN sys.all_columns c ON t.object_id = c.object_id GROUP BY t.name ORDER BY nbrRows DESC";
		return dataGenerator(query);
	}
}
