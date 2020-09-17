import java.sql.*;
public class sqltest {

	public static void main(String[] args) {
		try {
			// Store connection string as variable.
			String connectionString = 
					"jdbc:sqlserver://" + 
					System.getenv("ADDRESS_SQL") + 
					";database=sudoku;user= "  + 
					System.getenv("USER_SQL") + 
					";password=" + 
					System.getenv("PASSWORD_SQL") + 
					";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

			//Create the connection.
			Connection connection = DriverManager.getConnection(connectionString);

			//Query to be executed.
			String query = "SELECT TOP(10) Id FROM Puzzles;";

			//Load the statement.
			PreparedStatement preparedStatement = connection.prepareStatement(query);

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
