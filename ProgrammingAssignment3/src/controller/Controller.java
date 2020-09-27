package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
}
