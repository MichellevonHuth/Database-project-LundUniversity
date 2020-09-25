package grupp12;

import grupp12.DataAccessLayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	
	private DataAccessLayer dal;
	private Menu menu;
	
	public DataAccessLayer getExcel() {
		return dal;
	}
	public void setExcel(DataAccessLayer excel) {
		this.dal = excel;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public Controller(Menu menu, DataAccessLayer excel) {
		this.dal = excel;
		this.menu = menu;
		declareEvents();
	}
	
	public void declareEvents() {
		
		menu.getComboBoxQuestionsOption().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}	
		});
		
		menu.getBtnSearch().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedQuestion = (String) menu.getComboBoxQuestionsOption().getSelectedItem();
				
				try {
					if(menu.getComboBoxAccessORExcel().equals("Access")) {
						dal.getAccess(selectedQuestion);
						
					} 
					else if (menu.getComboBoxAccessORExcel().equals("Excel")) {
						dal.getExcel(selectedQuestion);
					}	
				}
				
				catch (Exception e1) {
					System.out.println("Something went wrong"); 
				
				}
			}
		});
	
	}
}
