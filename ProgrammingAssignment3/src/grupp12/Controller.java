package grupp12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	
	private ReadFromExcel excel;
	private Menu menu;
	
	
	public ReadFromExcel getExcel() {
		return excel;
	}
	public void setExcel(ReadFromExcel excel) {
		this.excel = excel;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public Controller(Menu menu, ReadFromExcel excel) {
		this.excel = excel;
		this.menu = menu;
		declareEvents();
	}
	
	public void declareEvents() {
	
	menu.getBtnAllEmployees().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	
	menu.btnGetAllCustomers().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
}
	
}
