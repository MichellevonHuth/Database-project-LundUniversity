package dal;

import java.io.File;  
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.ArrayList;

	public class DataAccessLayer 
	{ 
		private Connection connection;
		String connectionString = "jdbc:sqlserver://" +  "localhost" + ";database=TestDB;user= "  + "sa" + ";password=" + System.getenv("PASSWORD") + ";trustServerCertificate=true;loginTimeout=30;" ;
		
		
		public DataAccessLayer() {
			
			try {
				this.connection = DriverManager.getConnection(connectionString);		
			}
			catch(Exception e) {
				e.printStackTrace();
			}	
		}
		
		
		public ResultSet dataGenerator(String query) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs;
			return rs = ps.executeQuery();
		}
		
		public ResultSet getAllEmployees() throws SQLException {
			
			String query = "SELECT [First Name], [Last Name],Address,  [Social Security No_]FROM [CRONUS Sverige AB$Employee]"; 
			
			return dataGenerator(query);

		}
		
		public ResultSet getAllCustomers() throws SQLException {
			
			String query = "SELECT  Name, Address, City, No_ FROM [CRONUS Sverige AB$Customer]";
			
			return dataGenerator(query);

		}
	
	}


	
