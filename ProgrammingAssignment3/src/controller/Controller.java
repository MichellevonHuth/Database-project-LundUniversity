package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import dal.DataAccessLayer;
import view.Frame;

public class Controller {
	
	private DataAccessLayer dal;
	private Frame frame;
	
	public Controller(Frame frame, DataAccessLayer dal) {
		this.frame = frame;
		this.dal = dal;
		declareEvents();
	}

	private void displayData (ResultSet rs) {
		 try {
			      
	        int columns = rs.getMetaData().getColumnCount();
	        Vector headers = new Vector(); 
	      
	        for (int i = 1; i <= columns; i++) {
	        	headers.addElement(rs.getMetaData().getColumnLabel(i));
	        }
	        ((DefaultTableModel) frame.getTable().getModel()).setRowCount(0);   
	        ((DefaultTableModel) frame.getTable().getModel()).setColumnCount(columns);
			((DefaultTableModel) frame.getTable().getModel()).setColumnIdentifiers(headers);

			while (rs.next()) {  
	            Object[] row = new Object[columns];
	            for (int i = 1; i <= columns; i++) {  
	                row[i-1] = rs.getObject(i); // 1
	            }

	            ((DefaultTableModel) frame.getTable().getModel()).insertRow(rs.getRow() - 1 ,row);
			}
			
		 }
		
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
	}
	
	
	public void declareEvents() {
	
		frame.getBtnExcel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
			File file = new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\SQLExcel.xlsx");
				
			try {
					Desktop.getDesktop().open(file);		
//				}
				
//				catch(java.lang.IllegalArgumentException f) {
					if(!file.exists()) {
						frame.getLblResponseField().setText("Filen finns inte");
					}
				}
				
				catch (IOException e1) {
					e1.printStackTrace(); 
				}
			}
		});
		
		
		frame.getBtnAccess().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\SQLAccess.accdb");
				
				try {
					Desktop.getDesktop().open(file);		
				}
				
				catch(java.lang.IllegalArgumentException f) {
					if(!file.exists()) {
						frame.getLblResponseField().setText("Filen finns inte");
					}
				}
				
				catch (IOException e1) {
					e1.printStackTrace(); 
				}
			}
		});
		
		
		frame.getBtnAllEmployees().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ResultSet rs = dal.getAllEmployees();
					displayData(rs);
				}
				
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		
		frame.getBtnAllCustomers().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ResultSet rs = dal.getAllCustomers();
					displayData(rs);
				}
				
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}	
}