package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccessLayer {
	
	private Connection con; 
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	String url = "jdbc:sqlserver://SYST3DEV01;database=CRONUS";
	String loginName = "user";
	String password = "123";
	
	public DataAccessLayer(){
		try {
			con = DriverManager.getConnection(url, loginName, password);
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
		
		String query = "SELECT name, object_id, type_desc FROM sys.key_constraints WHERE type_desc LIKE '%CONSTRAINT'";
//		PreparedStatement ps = con.prepareStatement(query);
//		ResultSet rs = ps.executeQuery();
		
		return dataGenerator(query);
	}
	
	public ResultSet viewAllTableConstraints() throws SQLException {
		
		String query = "SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS";
//		PreparedStatement ps = con.prepareStatement(query);		
//		ResultSet resultSet = ps.executeQuery();
		return dataGenerator(query);
	}
	
	public ResultSet viewAllTables() throws SQLException {
		
		String query = "SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE LIKE 'BASE TABLE'";
//		PreparedStatement ps = con.prepareStatement(query);		
//		ResultSet resultSet = ps.executeQuery();
		return dataGenerator(query);
	}
	
	
	public ResultSet viewAllEmployeeInfo() throws SQLException {
		
		String query = "SELECT TABLE_NAME as table_name, TABLE_SCHEMA as schema_name, COLUMN_NAME as column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee'";
//		PreparedStatement ps = con.prepareStatement(query);		
//		ResultSet resultSet = ps.executeQuery();
		return dataGenerator(query);
	}
	
	public ResultSet viewMetaForEmployee() throws SQLException {
		
		String query = "SELECT TABLE_CATALOG, TABLE_NAME, COLUMN_NAME, ORDINAL_POSITION, IS_NULLABLE, DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee'";
//		PreparedStatement ps = con.prepareStatement(query);		
//		ResultSet resultSet = ps.executeQuery();
		return dataGenerator(query);
	}
	
	public ResultSet viewLargestTable() throws SQLException {
		
		String query = "SELECT TOP(1) COUNT(*) as nbrRows, [tables].name FROM sys.tables JOIN sys.all_columns ON [tables].[object_id] = [all_columns].[object_id] GROUP BY [tables].[name] ORDER BY nbrRows DESC";
//		PreparedStatement ps = con.prepareStatement(query);		
//		ResultSet resultSet = ps.executeQuery();
		return dataGenerator(query);
	}
}
