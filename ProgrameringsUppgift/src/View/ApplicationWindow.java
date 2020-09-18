package View;

import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import DAL.*;
import DAL.DataAccessLayer;

public class ApplicationWindow {

	private JFrame frame;
	
	
		public static void main(String[] args) {
			
		
			try {
				DataAccessLayer DAL = new DataAccessLayer();
				
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
		

	

	

	/**
	 * Launch the application.
	 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
