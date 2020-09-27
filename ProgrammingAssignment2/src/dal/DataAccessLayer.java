package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataAccessLayer {
	
	private Connection con; 
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
	
	public String hejhej() {
		String temp = "hejhej";
		return temp;
	}
	
	public ArrayList<String> viewAllKeys() throws SQLException {
		ArrayList<String> temp = new ArrayList<String>();
		
		String query = "SELECT * FROM sys.key_constraints WHERE type_desc LIKE '%CONSTRAINT'";
		PreparedStatement ps = con.prepareStatement(query);		
		ResultSet resultSet = ps.executeQuery();
		
		while (resultSet.next()) {
			temp.add(resultSet.getString(1) + " | ");
			temp.add(resultSet.getString(2) + " | ");
			temp.add(resultSet.getString(3) + " | ");
			temp.add(resultSet.getString(4) + " | ");
			temp.add(resultSet.getString(5) + "\n");
		}
		return temp;
	}
	
	public ArrayList<String> viewAllTableConstraints() throws SQLException {
		ArrayList<String> temp = new ArrayList<String>();
		
		String query = "SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS";
		PreparedStatement ps = con.prepareStatement(query);		
		ResultSet resultSet = ps.executeQuery();
		
		while (resultSet.next()) {
			temp.add(resultSet.getString(1) + " | ");
			temp.add(resultSet.getString(2) + " | ");
			temp.add(resultSet.getString(3) + " | ");
			temp.add(resultSet.getString(4) + " | ");
			temp.add(resultSet.getString(5) + "\n");
		}
		return temp;
	}
	
	public ArrayList<String> viewAllTables() throws SQLException {
		ArrayList<String> temp = new ArrayList<String>();
		
		String query = "SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE LIKE 'BASE TABLE'";
		PreparedStatement ps = con.prepareStatement(query);		
		ResultSet resultSet = ps.executeQuery();
		
		while (resultSet.next()) {
			temp.add(resultSet.getString(1) + " | ");
			temp.add(resultSet.getString(2) + " | ");
			temp.add(resultSet.getString(3) + " | ");
			temp.add(resultSet.getString(4) + "\n");
		}
		return temp;
	}
	
	
	public ArrayList<String> viewAllEmployeeInfo() throws SQLException {
		ArrayList<String> temp = new ArrayList<String>(); 
		
		String query = "SELECT TABLE_NAME as table_name, TABLE_SCHEMA as schema_name, COLUMN_NAME as column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee'";
		PreparedStatement ps = con.prepareStatement(query);		
		ResultSet resultSet = ps.executeQuery();
//		ResultSetMetaData rsmd = resultSet.getMetaData();
			 
		while (resultSet.next()) {
			temp.add(resultSet.getString(1) + " | ");
			temp.add(resultSet.getString(2) + " | "); 
			temp.add(resultSet.getString(3) + "\n");
		}	
		return temp;
	}
	
	public ArrayList<String> viewMetaForEmployee() throws SQLException {
		ArrayList<String> temp = new ArrayList<String>();
		
		String query = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee'";
		PreparedStatement ps = con.prepareStatement(query);		
		ResultSet resultSet = ps.executeQuery();
		
		while (resultSet.next()) {
			temp.add(resultSet.getString(1) + " | ");
			temp.add(resultSet.getString(2) + " | ");
			temp.add(resultSet.getString(3) + " | ");
			temp.add(resultSet.getString(4) + " | ");
			temp.add(resultSet.getString(5) + "\n");
		}
		return temp;
	}
	
	public ArrayList<String> viewLargestTable() throws SQLException {
		ArrayList<String> temp = new ArrayList<String>();
		
		String query = "SELECT TOP(1) COUNT(*) as nbrRows, [tables].name FROM sys.tables JOIN sys.all_columns ON [tables].[object_id] = [all_columns].[object_id] GROUP BY [tables].[name] ORDER BY nbrRows DESC";
		PreparedStatement ps = con.prepareStatement(query);		
		ResultSet resultSet = ps.executeQuery();
		
		while (resultSet.next()) {
			temp.add(resultSet.getString(1) + " | ");
			temp.add(resultSet.getString(2) + "\n");
		}
		return temp;
	}
}
