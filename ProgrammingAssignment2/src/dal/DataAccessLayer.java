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
	String loginName = "sa";
	String password = "reallyStrongPwd123";
	
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
		
		String query = "SELECT TABLE_NAME as table_name, TABLE_SCHEMA as schema_name, COLUMN_NAME as column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee'";
		return dataGenerator(query);
	}
	
	public ResultSet viewMetaForEmployee() throws SQLException {
		
		String query = "SELECT TABLE_CATALOG as table_catalog, TABLE_NAME as table_name, COLUMN_NAME as column_name, ORDINAL_POSITION as ordinal_position, IS_NULLABLE as is_nullable, DATA_TYPE as data_type FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee'";
		return dataGenerator(query);
	}
	
	public ResultSet viewLargestTable() throws SQLException {
		
		String query = "SELECT TOP(1) COUNT(*) as nbrRows, [tables].name FROM sys.tables JOIN sys.all_columns ON [tables].[object_id] = [all_columns].[object_id] GROUP BY [tables].[name] ORDER BY nbrRows DESC";
		return dataGenerator(query);
	}
}
