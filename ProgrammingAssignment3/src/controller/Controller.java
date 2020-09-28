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
import view.Menu;

public class Controller {
	
	private DataAccessLayer dal;
	private Menu menu;
	
	public DataAccessLayer getExcel() {
		return dal;
	}
	public void setExcel(DataAccessLayer dal) {
		this.dal = dal;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public Controller(Menu menu, DataAccessLayer dal) {
		this.dal = dal;
		this.menu = menu;
		declareEvents();
	}
	
	private void displayData (ResultSet rs) {
		 try {
			((DefaultTableModel) menu.getTable().getModel()).setRowCount(0);   
				      
	        //Creating Object []rowData for jTable's Table Model        
	        int columns = rs.getMetaData().getColumnCount();
	        Vector headers = new Vector(); 
	        
	        for (int i = 1; i <= columns; i++) {
	        	headers.addElement(rs.getMetaData().getColumnLabel(i));
	        }
			((DefaultTableModel) menu.getTable().getModel()).setColumnCount(columns);
			((DefaultTableModel) menu.getTable().getModel()).setColumnIdentifiers(headers);


			while (rs.next())
	        {  
	            Object[] row = new Object[columns];
	            for (int i = 1; i <= columns; i++)
	            {  
	                row[i - 1] = rs.getObject(i); // 1
	            }
	            ((DefaultTableModel) menu.getTable().getModel()).insertRow(rs.getRow() - 1,row);
	        }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
	}
	
	public void declareEvents() {
		
		
		menu.getBtnExcel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				System.out.println("i knappen");
			File file = new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\SQLExcel.xlsx");
				
				try {
					System.out.println("i try");
					Desktop.getDesktop().open(file);		
				}
				
				catch(java.lang.IllegalArgumentException f) {
					if(!file.exists()) {
						menu.getTextField().setText("Filen finns inte");
						
					}
				}
				
				catch (IOException e1) {
					e1.printStackTrace(); 
				}
			}
		});
	
		menu.getBtnAccess().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File file = new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\SQLAccess.accdb");
				
				try {
					System.out.println("i try");
					Desktop.getDesktop().open(file);		
				}
				
				catch(java.lang.IllegalArgumentException f) {
					if(!file.exists()) {
						menu.getTextField().setText("Filen finns inte");
						
					}
				}
				
				catch (IOException e1) {
					e1.printStackTrace(); 
				}
			}
		});
		
	}
		
		public File chooseFile() {
			JFileChooser fileChooser = new JFileChooser(); 
			int returnValue = menu.getFileChooser().showOpenDialog(null);
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				
				File selectedFile = menu.getFileChooser().getSelectedFile(); 
				setFile(selectedFile);
				return selectedFile;
			}
			
			return null; 
			
		}
		
		public void setFile(File selectedFile) {
			File file = new File(selectedFile.getAbsolutePath());
			
			try {
				Workbook workbook = Workbook.getWorkbook(file);
				Sheet sheet = workbook.getSheet(0); 
				menu.getHeaders().clear(); 
				
				for(int i = 0; i< sheet.getColumn(); i++) {
					Cell cell1 = sheet.getCell(i, 0); 
					menu.getHeaders().add(cell1, getContents());
				}
				
				menu.getData().clear(); 
			
				for(int j = 1; j< sheet.getRows(); j++) {
					Vector d = new Vector(); 
					for(int i = 0; i < sheet.getColumns(); i++) {
						Cell cell = sheet.getCell(i, j); 
						d.add(cell.getContents()); 
					
				}
				
				d.add("\n"); 
				menu.getData().add(d); 		
				
			}
			
				menu.setTable(); 		
			}
			
			catch (Exception e) {
				menu.getTextField().setText("Wrong format of imported file. The format must be: .xls");
			}
				
		} 
	}
