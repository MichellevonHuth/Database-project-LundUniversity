package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import java.lang.AutoCloseable;
import java.io.Closeable;
import java.lang.Iterable;
import java.sql.ResultSet;
import java.sql.SQLException;
import dal.DataAccessLayer;
import view.Frame;
public class Controller {
	private DataAccessLayer dal;
	private Frame frame;
	public DataAccessLayer getDal() {
		return dal;
	}
	public void setDal(DataAccessLayer dal) {
		this.dal = dal;
	}
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	public Controller(Frame frame, DataAccessLayer dal) {
		this.dal = dal;
		this.frame = frame;
		declareEvents();
	}
	private void displayData (ResultSet rs) {
		 try {
			((DefaultTableModel) frame.getTable().getModel()).setRowCount(0);   
	        //Creating Object []rowData for jTable's Table Model        
	        int columns = rs.getMetaData().getColumnCount();
	        Vector headers = new Vector(); 
	        for (int i = 1; i <= columns; i++) {
	        	headers.addElement(rs.getMetaData().getColumnLabel(i));
	        }
			((DefaultTableModel) frame.getTable().getModel()).setColumnCount(columns);
			((DefaultTableModel) frame.getTable().getModel()).setColumnIdentifiers(headers);

			while (rs.next())
	        {  
	            Object[] row = new Object[columns];
	            for (int i = 1; i <= columns; i++)
	            {  
	                row[i - 1] = rs.getObject(i); // 1
	            }
	            ((DefaultTableModel) frame.getTable().getModel()).insertRow(rs.getRow() - 1,row);
	        }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
	}
	public void declareEvents() {

		
		frame.getBtnExcel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				System.out.println("i knappen");
			File file = new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\SQLExcel.xlsx");
				try {
					System.out.println("i try");
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
		frame.getBtnAccess().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\SQLAccess.accdb");
				try {
					System.out.println("i try");
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