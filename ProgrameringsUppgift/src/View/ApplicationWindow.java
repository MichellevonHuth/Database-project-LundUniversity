package View;
import java.sql.*;

import DataBase.DataBaseConnection;
public class ApplicationWindow {
	
	public static void main(String[] args) {
		try {
			DataBaseConnection DAL = new DataBaseConnection();
			
			//Query to be executed.
			String query = "SELECT * FROM Student";

			//Load the statement.
			PreparedStatement preparedStatement = DAL.getConnection().prepareStatement(query);

			//Execute the query and store Re	sultSet in variable.
			ResultSet resultSet = preparedStatement.executeQuery();

			//Store metadata of ResultSet in variable
			ResultSetMetaData md = resultSet.getMetaData();

			//Store the number of columns in ResultSet in variable.
			int columns = md.getColumnCount();

			while (resultSet.next()) {

				//For i <= number of columns in set.
				for (int i = 1; i <= columns; ++i) {
					
					//Print the cell value at the current row, index i
					System.out.println(resultSet.getObject(i));
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
