package controller;

import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import dal.*;

public class Controller {
	
	private ApplicationWindow aw; 
	private DataAccessLayer dal;
	

	public Controller(ApplicationWindow aw, DataAccessLayer dal) {
		this.aw = aw;
		this.dal = dal;
		declareEvents();
	}
	

	private void displayData (ResultSet rs) {
		 try {
			((DefaultTableModel) aw.getTable().getModel()).setRowCount(0);   
	              
	        int columns = rs.getMetaData().getColumnCount();
	        Vector headers = new Vector(); 
	      
	        for (int i = 1; i <= columns; i++) {
	        	headers.addElement(rs.getMetaData().getColumnLabel(i));
	        }
			
	        ((DefaultTableModel) aw.getTable().getModel()).setColumnCount(columns);
			((DefaultTableModel) aw.getTable().getModel()).setColumnIdentifiers(headers);

			while (rs.next()) {  
	            Object[] row = new Object[columns];
	            for (int i = 1; i <= columns; i++) {  
	                row[i - 1] = rs.getObject(i); // 1
	            }
	           
	            ((DefaultTableModel) aw.getTable().getModel()).insertRow(rs.getRow() - 1,row);
			}
		 }
		
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
	}
	
	
	public void declareEvents() {
		aw.getBtnAllEmployeeFacts().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					ResultSet rs = dal.viewAllEmployeeInfo();
					displayData(rs);
					}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		
		aw.getBtnAllKeys().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ResultSet rs = dal.viewAllKeys();
					displayData(rs);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		
		aw.getBtnAllConstraints().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ResultSet rs = dal.viewAllTableConstraints();
					displayData(rs);
					}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		
		aw.getBtnAllTables().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ResultSet rs = dal.viewAllTables();
					displayData(rs);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		
		aw.getBtnMetaForEmployee().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ResultSet rs = dal.viewMetaForEmployee();
					displayData(rs);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		
		aw.getBtnLargestTable().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ResultSet rs = dal.viewLargestTable();
					displayData(rs);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
    }

}
